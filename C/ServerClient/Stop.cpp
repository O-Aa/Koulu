//Ohjelma, joka lopettaa siististi Client-ohjelman
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

void lopeta(SOCKET client) {

  #ifdef _MSC_VER
  //suljetaan socket
  closesocket(client);

  //Ja taas Windows-erikoisuus
  WSACleanup();

  system("PAUSE");
  #else
  close(client);
  #endif
}
