#ifdef _MSC_VER
#define _CRT_SECURE_NO_WARNINGS
#include <winsock2.h>
#include <zlib.h>
#endif
#ifndef _MSC_VER
#include <sys/socket.h>
#include <netinet/in.h>
#define SOCKET int
#define closesocket close
#define SOCKET_ERROR -1
#define INVALID_SOCKET -1
#endif
using namespace std;
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <string>
#include <iostream>
#include <fstream>
#include <assert.h>
#include <openssl/conf.h>
#include <openssl/err.h>
#include <string.h>
#include <openssl/ssl.h>
#include <malloc.h>
#include <openssl/aes.h>
#include <openssl/rand.h>
#include <exception>

#define BUF_SIZE 1024
#define NIMI_SIZE 1024
#define LOHKO 0x4000
#define windowBits 15
#define ENABLE_ZLIB_GZIP 32
#define CHUNK 16384

void zerr(int ret);
int inf(FILE *source, FILE *dest);
int laheta(SOCKET conn, char *vast);
int lue(SOCKET conn, char *buf, int size);

int inf(FILE *source, FILE *dest)
{
	int ret;
	unsigned have;
	z_stream strm;
	unsigned char in[CHUNK];
	unsigned char out[CHUNK];

	/* allocate inflate state */
	strm.zalloc = Z_NULL;
	strm.zfree = Z_NULL;
	strm.opaque = Z_NULL;
	strm.avail_in = 0;
	strm.next_in = Z_NULL;
	ret = inflateInit(&strm);
	if (ret != Z_OK)
		return ret;

	/* decompress until deflate stream ends or end of file */
	do {
		strm.avail_in = fread(in, 1, CHUNK, source);
		if (ferror(source)) {
			(void)inflateEnd(&strm);
			return Z_ERRNO;
		}
		if (strm.avail_in == 0)
			break;
		strm.next_in = in;

		/* run inflate() on input until output buffer not full */
		do {
			strm.avail_out = CHUNK;
			strm.next_out = out;
			ret = inflate(&strm, Z_NO_FLUSH);
			assert(ret != Z_STREAM_ERROR);  /* state not clobbered */
			switch (ret) {
			case Z_NEED_DICT:
				ret = Z_DATA_ERROR;     /* and fall through */
			case Z_DATA_ERROR:
			case Z_MEM_ERROR:
				(void)inflateEnd(&strm);
				return ret;
			}
			have = CHUNK - strm.avail_out;
			if (fwrite(out, 1, have, dest) != have || ferror(dest)) {
				(void)inflateEnd(&strm);
				return Z_ERRNO;
			}
		} while (strm.avail_out == 0);

		/* done when inflate() says it's done */
	} while (ret != Z_STREAM_END);

	/* clean up and return */
	(void)inflateEnd(&strm);
	return ret == Z_STREAM_END ? Z_OK : Z_DATA_ERROR;
}

/* report a zlib or i/o error */
void zerr(int ret)
{
	fputs("zpipe: ", stderr);
	switch (ret) {
	case Z_ERRNO:
		if (ferror(stdin))
			fputs("error reading stdin\n", stderr);
		if (ferror(stdout))
			fputs("error writing stdout\n", stderr);
		break;
	case Z_STREAM_ERROR:
		fputs("invalid compression level\n", stderr);
		break;
	case Z_DATA_ERROR:
		fputs("invalid or incomplete deflate data\n", stderr);
		break;
	case Z_MEM_ERROR:
		fputs("out of memory\n", stderr);
		break;
	case Z_VERSION_ERROR:
		fputs("zlib version mismatch!\n", stderr);
	}
}


int main(int argc, char *argv[])
{
  //määritellään muuttujat
  SOCKET server;          //minä itse eli palvelin
  SOCKET conn;            //ns. connected socket
  struct sockaddr_in localaddr;   //paikallinen osoite
  struct sockaddr_in clientaddr;  //etäkoneen osoite
  char buf[BUF_SIZE];
  char vast[BUF_SIZE];
  char nimi[BUF_SIZE];
  char viesti[BUF_SIZE];
  ofstream tied;
  int retu;
  int koko;

  //tyhjennetään muistialueet
  memset((char *)&localaddr, 0, sizeof(struct sockaddr_in));
  memset((char *)&clientaddr, 0, sizeof(struct sockaddr_in));
  memset(buf, 0, BUF_SIZE);
  memset(vast, 0, BUF_SIZE);
  memset(nimi, 0, BUF_SIZE);

  //Initialisoidaan Winsock /tämä on Windows-lisä
  #ifdef _MSC_VER
  WSADATA wsaData;
  retu = WSAStartup(MAKEWORD(2,2), &wsaData);
  if (retu != 0) {
	  perror("WSAStartup epäonnistui");
      exit(-1);
  }
  #endif

  //Luodaan palvelinsoketti
  server = socket(AF_INET, SOCK_STREAM, IPPROTO_IP);
  if (server == SOCKET_ERROR) {
     perror("Socketin luonti epäonnistui");
     exit(-1);
  }

  //Täytetään paikallinen nimirakenne palvelimelle sopivaksi
  localaddr.sin_addr.s_addr = htonl(INADDR_ANY);
  localaddr.sin_family = AF_INET;
  localaddr.sin_port = htons(3333);
  //localaddr.sin_port = 3333;

  //sidotaan paikallinen nimirakenne paikalliseen porttiin
  retu = bind(server,(struct sockaddr *)&localaddr,sizeof(struct sockaddr_in));
  if (retu == SOCKET_ERROR) {
     perror("Sidonta epäonnistui");
     exit(-2);
  }

  //muodostetaan jono tuleville kutsuille
  listen(server,5);

  //jäädään odottamaan yhteyksiä
  printf("Odotetaan yhteydenottoa....\n");

  //hyväksytään tullut yhteyspyyntö ja luodaan ns. connected socket,
  //jonka kautta kommunikointi tapahtuu. Tämä voitaisiin erkauttaa
  //omaan säikeeseen, jolloin palvelin palalisi kuuntelutilaan seuraavaa
  //yhteyttä varten (esim. komento fork())
  koko = sizeof(struct sockaddr_in);
  conn = accept(server, (struct sockaddr *)&clientaddr, &koko);
  if (conn == INVALID_SOCKET) {
     perror("Accept epäonnistui");
     exit(-3);
  }

     //Luetaan viesti
	 retu = lue(conn, buf, BUF_SIZE);

     //Ensimmäinen 8 bittiä on PDU:n tyyppi 
	 // 1 - nimi
	 // 2 - data (lähetys jatkuu)
	 // 3 - data (lähetys päättyy)
	 // 4 - OK
	 // 5 - NOK 
	 //ensimmäinen viesti pitää olla tiedoston avaus
	 if (buf[0] == 1) {
		 //Seuraavat 4 tavua pituus (Huom! mahd. big-endian / little-endian ero)
		 memcpy((void *)&koko, (void *)(buf + 1), sizeof(int));
		 //Sitten kopioidaan nimi
		 memcpy((void *)nimi, (void *)(buf + 5), koko);

		 tied.open(nimi,ios::binary);
		 if (!tied.fail()) {
			 vast[0] = 4; //OK
			 int pit = sprintf(viesti, "Tiedosto avattu");
			 memcpy((void *)(vast + 1), (void *)&pit, 4);
			 memcpy((void *)(vast + 5), (void *)viesti, pit);

			 laheta(conn, vast);
		 } else {
			 vast[0] = 5; //NOK
			 int pit = sprintf(viesti, "Tiedostoa ei voitu avata");
			 memcpy((void *)(vast + 1), (void *)&pit, 4);
			 memcpy((void *)(vast + 5), (void *)viesti, pit);
			 laheta(conn, vast);
		 }
	 }
	 else {
		 vast[0] = 5; //NOK
		 int pit = sprintf(viesti, "V\x84r\x84 PDU %i", buf[0]);
		 memcpy((void *)(vast + 1), (void *)&pit, 4);
		 memcpy((void *)(vast + 5), (void *)viesti, pit);
		 laheta(conn, vast);
	 }

  //luetaan viestejä, kunnes loppu
  do {
	 retu = lue(conn, buf, BUF_SIZE);

	 if (buf[0] == 2) { //data-pdu
		 memcpy((void *)&koko, (void *)(buf + 1), sizeof(int));
		 tied.write((buf + 5), koko);

		 vast[0] = 4; //OK
		 int pit = sprintf(viesti, "Kirjoitettiin tiedostoon %i merkkia", koko);
		 memcpy((void *)(vast + 1), (void *)&pit, 4);
		 memcpy((void *)(vast + 5), (void *)viesti, pit);

		 laheta(conn, vast);
	 } else if (buf[0] == 3) {
		 memcpy((void *)&koko, (void *)(buf + 1), sizeof(int));
		 if (koko > 0) {
			 tied.write((buf + 5), koko);
		 }
		 tied.close();

		 vast[0] = 4; //OK
		 int pit = sprintf(viesti, "Tiedosto suljetaan. Kirjoitettiin tiedostoon %i merkkia", koko);
		 memcpy((void *)(vast + 1), (void *)&pit, 4);
		 memcpy((void *)(vast + 5), (void *)viesti, pit);
		 laheta(conn, vast);
	 } else {
		 tied.close();
		 
		 vast[0] = 5; //NOK
		 int pit = sprintf(viesti, "Virheellinen PDU %i", buf[0]);
		 memcpy((void *)(vast + 1), (void *)&pit, 4);
		 memcpy((void *)(vast + 5), (void *)viesti, pit);
		 laheta(conn, vast);
	 }
	 
  } while (buf[0] == 2);


  #ifdef _MSC_VER
  //suljetaan connected socket
  closesocket(conn);
  //suljetaan server socket
  closesocket(server);

  WSACleanup();

#else
  close(conn);
  close(server);
#endif

//Decrypting
#define MAX_KOKO 1000
#define AV_PIT 128

  AES_KEY enc_key, dec_key;
  ifstream tied_in;
  ofstream tied_out;
  char nimi1[128], nimi2[128];
  char *viesti_salaus;
  int koko_salaus;
  char *pur_viesti;
  char *lah_viesti;
  size_t pit, buf_pit;


  char *salausavain = "aes_salausavainn";
  char *alkuarvo = "algoritmin lahtoarvo";

  do {
	  strcpy(nimi1, nimi);

	  strcpy(nimi2, nimi1);
	  pit = strlen(nimi1);
	  if (nimi2[pit - 4] == '.') {
		  nimi2[pit - 4] = 0;
	  }

	  tied_in.open(nimi1, ios::binary);
	  tied_out.open(nimi2, ios::out | ios::binary);
	  if (tied_in.fail()) {
		  cout << "Lähtötiedoston avaamisessa ongelmaa\n";
	  }
	  if (tied_out.fail()) {
		  cout << "Tulostiedoston avaamisessa ongelmaa\n";
	  }
  } while (tied_in.fail() || tied_out.fail());

  //Mitataan tiedoston koko
  tied_in.seekg(0, ios::end);
  koko_salaus = tied_in.tellg();

  //Luetaan tiedosto kokonaisuudessaan muistiin
  viesti_salaus = new char[koko_salaus];
  tied_in.seekg(0, ios::beg);
  tied_in.read(viesti_salaus, koko_salaus);
  tied_in.close();

  //Salaus
  pit = ((koko_salaus / AES_BLOCK_SIZE)*AES_BLOCK_SIZE) + AES_BLOCK_SIZE;
  lah_viesti = (char *)malloc(pit);
  memset(lah_viesti, 0, pit);
  memcpy(lah_viesti, viesti_salaus, koko_salaus);

  // CBC (Cipher Block Chaining) vaatii ensimmäiselle lohkolle jonkin arvon, 
  // joka on sama purussa ja koodauksessa. Voitaisiin tehdä vaikka satunnais-
  // lukugeneraattorilla ja lähettää toiselle osapuolelle.
  unsigned char iv_enc[AES_BLOCK_SIZE], iv_dec[AES_BLOCK_SIZE];
  //RAND_bytes(iv_enc, AES_BLOCK_SIZE);
  memcpy(iv_enc, alkuarvo, AES_BLOCK_SIZE);
  memcpy(iv_dec, iv_enc, AES_BLOCK_SIZE);

  //Muodostetaan purkuavain lukemista varten
  AES_set_decrypt_key((unsigned char *)salausavain, AV_PIT, &dec_key);

  //Muodostetaan puskuri, johon viesti puretaan
  //buf_pit = ((pit + AES_BLOCK_SIZE) / AES_BLOCK_SIZE) * AES_BLOCK_SIZE;
  buf_pit = pit;
  pur_viesti = (char *)malloc(buf_pit);
  memset(pur_viesti, 0, buf_pit);

  //Varsinainen salaus
  AES_cbc_encrypt((unsigned char *)lah_viesti, (unsigned char *)pur_viesti, koko_salaus, &dec_key, iv_dec, AES_DECRYPT);


  //Kirjoitetaan tiedosto levylle

  tied_out.write(pur_viesti, koko_salaus);
  tied_out.close();

  //Vapautetaan muistit
  free((void *)pur_viesti);
  free((void *)lah_viesti);
  free((void *)viesti_salaus);


//Decompressing
	  FILE *tied_luku, *tied_kirj;
	  string nimi_luku;
	  string nimi_kirj;
	  int ret;
	  size_t lastChar;

	  nimi_luku=nimi2;

	  lastChar = nimi_luku.find_last_of(".");
	  nimi_kirj = nimi_luku.substr(0, lastChar);

	  tied_luku = fopen(nimi_luku.data(), "rb");

	  tied_kirj = fopen(nimi_kirj.data(), "wb");

	  if ((tied_luku == NULL) || (tied_kirj == NULL)) {
		  cerr << "Tiedostonavausvirhe!\n";
		  return(-1);
	  }

	  ret = inf(tied_luku, tied_kirj);
	  if (ret == Z_OK)

	  if (ret != Z_OK)
		  zerr(ret);

	  fclose(tied_luku);
	  fclose(tied_kirj);

	  cout << "File received!" << endl;
  return 0;
}


