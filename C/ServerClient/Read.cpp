//Tämä Visual Studioa varten

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

int lue(SOCKET client, char *buf, int size) {
	int retu;

	//Luetaan vastaus
	 retu = recv(client, buf, size, 0);
     if (retu == 0) {
        perror("Jotain virhettä lukemisessa, viestin mitta 0");
        exit(-4);
     } else if (retu == SOCKET_ERROR) {
       perror("Datan vastaanotto epäonnistui");
       exit(-5);
     }
	 return retu;
}
