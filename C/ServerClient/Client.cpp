#ifdef _MSC_VER
#define _CRT_SECURE_NO_WARNINGS
#include <winsock2.h>
#include <ws2tcpip.h>
#else
#include <sys/socket.h>
#include <netinet/in.h>
#define SOCKET int
#define closesocket close
#define SOCKET_ERROR -1
#define INVALID_SOCKET -1
#endif
using namespace std;
#include <zlib.h>
#include <assert.h>
#include <openssl/conf.h>
#include <openssl/err.h>
#include <string.h>
#include <openssl/ssl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
#include <fstream>
#include <malloc.h>
#include <openssl/aes.h>
#include <openssl/rand.h>
#include <exception>

int def(FILE *source, FILE *dest, int level);
void zerr(int ret);
int encrypt(unsigned char *plaintext, int plaintext_len, unsigned char *key, unsigned char *iv, unsigned char *ciphertext);
int decrypt(unsigned char *ciphertext, int ciphertext_len, unsigned char *key, unsigned char *iv, unsigned char *plaintext);
void lopeta(SOCKET);
int lue(SOCKET conn, char *buf, int koko);

#define MAX_KOKO 1000
#define AV_PIT 128

#define LOHKO 0x4000
#define windowBits 15
#define ENABLE_ZLIB_GZIP 32
#define CHUNK 16384
#include <sys/types.h>
#define BUF_SIZE 1024
#define NIMI_SIZE 1024
#include <string>


int def(FILE *source, FILE *dest, int level)
{
	int ret, flush;
	unsigned have;
	z_stream strm;
	unsigned char in[CHUNK];
	unsigned char out[CHUNK];

	/* allocate deflate state */
	strm.zalloc = Z_NULL;
	strm.zfree = Z_NULL;
	strm.opaque = Z_NULL;

	//ret = deflateInit2(&strm, windowBits | ENABLE_ZLIB_GZIP);
	ret = deflateInit(&strm, level);
	if (ret != Z_OK)
		return ret;

	/* compress until end of file */
	do {
		strm.avail_in = fread(in, 1, CHUNK, source);
		if (ferror(source)) {
			(void)deflateEnd(&strm);
			return Z_ERRNO;
		}
		flush = feof(source) ? Z_FINISH : Z_NO_FLUSH;
		strm.next_in = in;

		/* run deflate() on input until output buffer not full, finish
		compression if all of source has been read in */
		do {
			strm.avail_out = CHUNK;
			strm.next_out = out;
			ret = deflate(&strm, flush);    /* no bad return value */
			assert(ret != Z_STREAM_ERROR);  /* state not clobbered */
			have = CHUNK - strm.avail_out;
			if (fwrite(out, 1, have, dest) != have || ferror(dest)) {
				(void)deflateEnd(&strm);
				return Z_ERRNO;
			}
		} while (strm.avail_out == 0);
		assert(strm.avail_in == 0);     /* all input will be used */

										/* done when last data in file processed */
	} while (flush != Z_FINISH);
	assert(ret == Z_STREAM_END);        /* stream will be complete */

										/* clean up and return */
	(void)deflateEnd(&strm);
	return Z_OK;
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

  SOCKET client=NULL;     //asiakasohjelma etäkoneessa
  struct sockaddr_in localaddr;   //paikallinen osoite
  struct sockaddr_in clientaddr;  //etäkoneen osoite
  struct addrinfo hints, *res, *ptr;
  char buf[BUF_SIZE];
  char *vast;
  char *data;
  char viesti[BUF_SIZE];
  char nimi[NIMI_SIZE];
  ifstream tied;
  int retu;
  int koko;

  FILE *tied_luku, *tied_kirj;
  string nimi_luku;
  string nimi_kirj;
  int ret;

  vast = (char *)malloc(BUF_SIZE);
  data = new char[BUF_SIZE];

  //tyhjennetään muistialueet
  memset((char *)&hints, 0, sizeof(struct addrinfo));
  memset((char *)&localaddr, 0, sizeof(struct sockaddr_in));
  memset((char *)&clientaddr, 0, sizeof(struct sockaddr_in));
  memset(buf, 0, BUF_SIZE);
  memset(viesti, 0, BUF_SIZE);

  //Initialisoidaan Winsock /tämäon Windows-lisä
#ifdef _MSC_VER
  WSADATA wsaData;
  retu = WSAStartup(MAKEWORD(2, 2), &wsaData);
  if (retu != 0) {
	  perror("WSAStartup epäonnistui");
	  exit(-1);
  }
#endif

  hints.ai_family = AF_INET;
  hints.ai_socktype = SOCK_STREAM;
  hints.ai_protocol = IPPROTO_TCP;

  //Nimikysely
  retu = getaddrinfo("127.0.0.1", "3333", &hints, &res);
  if (retu != 0) {
	  perror("Nimi-osoitemuunnos epäonnistui");
	  exit(retu);
  }

  //Koska nimikysely voi palauttaa useita osoitteita
  for (ptr = res; ptr != NULL; ptr = ptr->ai_next) {
	  //Luodaan soketti yhteyttä varten palvelimeen
	  client = socket(ptr->ai_family, ptr->ai_socktype, ptr->ai_protocol);
	  if (client == INVALID_SOCKET) {
		  perror("Socketin luonti epäonnistui");
		  return(1);
	  }

	  retu = connect(client, ptr->ai_addr, (int)ptr->ai_addrlen);
	  if (retu == SOCKET_ERROR) {
		  printf("Kokeillaan seuraavaa\n");
		  closesocket(client);
		  continue;
	  }
	  break;
  }

  if (retu == INVALID_SOCKET) {
	  printf("Unable to connect to server!\n");
#ifdef _MSC_VER
	  WSACleanup();
#endif
	  return 1;
  }
  cout << "Give the filename to send: ";
  cin >> nimi_luku;
  nimi_kirj = nimi_luku + ".gz";
  

//Compression
  tied_luku = fopen(nimi_luku.data(), "rb");
  tied_kirj = fopen(nimi_kirj.data(), "wb");

  if ((tied_luku == NULL) || (tied_kirj == NULL)) {
	  cerr << "Tiedostonavausvirhe!\n";
	  return(-1);
  }

  ret = def(tied_luku, tied_kirj, Z_DEFAULT_COMPRESSION);
  if (ret != Z_OK)
	  zerr(ret);

  fclose(tied_luku);
  fclose(tied_kirj);

//Encryption
  AES_KEY enc_key, dec_key;
  ifstream tied_in;
  ofstream tied_out;


  char nimi1[128], nimi2[128];
  char *salattava;
  int koko_salattava;
  char *sal_viesti;
  char *lah_viesti;
  size_t pit, buf_pit;
  char *salausavain = "aes_salausavainn";
  char *alkuarvo = "algoritmin lahtoarvo";
  do {
	  strcpy(nimi1, nimi_kirj.c_str());
	  sprintf(nimi2, "%s.aes", nimi1);
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
  koko_salattava = tied_in.tellg();

  //Luetaan tiedosto kokonaisuudessaan muistiin
  salattava = new char[koko_salattava];
  tied_in.seekg(0, ios::beg);
  tied_in.read(salattava, koko_salattava);
  tied_in.close();

  //Salaus
  pit = ((koko_salattava / AES_BLOCK_SIZE)*AES_BLOCK_SIZE) + AES_BLOCK_SIZE;
  lah_viesti = (char *)malloc(pit);
  memset(lah_viesti, 0, pit);
  memcpy(lah_viesti, salattava, koko_salattava);

  unsigned char iv_enc[AES_BLOCK_SIZE], iv_dec[AES_BLOCK_SIZE];
  //RAND_bytes(iv_enc, AES_BLOCK_SIZE);
  memcpy(iv_enc, alkuarvo, AES_BLOCK_SIZE);
  //memcpy(iv_dec, iv_enc, AES_BLOCK_SIZE);

  //Muodostetaan salausavain kirjoittamista varten
  AES_set_encrypt_key((unsigned char *)salausavain, AV_PIT, &enc_key);
  //Muodostetaan puskuri, johon viesti salataan
  //buf_pit = ((pit + AES_BLOCK_SIZE) / AES_BLOCK_SIZE) * AES_BLOCK_SIZE;
  buf_pit = pit + 1;
  sal_viesti = (char *)malloc(buf_pit);
  memset(sal_viesti, 0, buf_pit);
  //Varsinainen salaus
  AES_cbc_encrypt((unsigned char *)lah_viesti, (unsigned char *)sal_viesti, pit, &enc_key, iv_enc, AES_ENCRYPT);
  //Kirjoitetaan tiedosto levylle
  tied_out.write(sal_viesti, pit);
  tied_out.close();

  //Vapautetaan muistit
  free((void *)sal_viesti);
  free((void *)lah_viesti);
  free((void *)salattava);

  //Sending the file

	  strcpy(nimi, nimi2);

	tied.open(nimi,ios::binary);


  vast[0] = 1;

  koko = strlen(nimi);
  //Seuraavat 4 tavua pituus (Huom! mahd. big-endian / little-endian ero)
  memcpy((void *)(vast+1), (void *)&koko, sizeof(int));
  //Sitten kopioidaan nimi
  memcpy((void *)(vast+5), (void *)nimi, koko);

  retu = send(client, vast, (koko+5),0);
  if (retu == SOCKET_ERROR) {
      perror("Kirjoitusvirhe sockettiin");
      exit(-5);
  }
  do {
     //Luetaan vastaus
	 retu = lue(client, buf, BUF_SIZE);
     
	 //tarkistetaan, oliko OK tai NOK
	 if (buf[0] != 4) {
		 perror("Tiedonsiirtovirhe");

		 vast[0] = 5; //NOK
		 int pit = sprintf(viesti, "Virheellinen PDU %i", buf[0]);
		 memcpy((void *)(vast + 1), (void *)&pit, 4);
		 memcpy((void *)(vast + 5), (void *)viesti, pit);

		 retu = send(client, vast, 5+pit, 0);
		 lopeta(client);
	 }

	 tied.read(data, BUF_SIZE - 5);
	 int pit = tied.gcount();

	 if (tied.eof()) {
		 vast[0] = 3; //tiedosto loppui
		 memcpy((void *)(vast + 1), (void *)&pit, 4);
		 memcpy((void *)(vast + 5), (void *)data, (pit+5));

		 retu = send(client, vast, 5 + pit, 0);
	 } else { 
		 vast[0] = 2; //tiedostoa vielä jäljellä
		 memcpy((void *)(vast + 1), (void *)&pit, 4);
		 memcpy((void *)(vast + 5), (void *)data, (pit + 5));

		 retu = send(client, vast, 5 + pit, 0);
	 }
     
     if (retu == SOCKET_ERROR) {
        perror("Kirjoitusvirhe sockettiin");
        exit(-6);
     }

  } while (!tied.eof());

  cout << "\nFile has been sent" << endl;
  lopeta(client);

   return 0;
}

