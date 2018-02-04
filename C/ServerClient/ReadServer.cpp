//Lukee viestin soketista
//Tämä Visual Studioa varten

#ifdef _MSC_VER
#define _CRT_SECURE_NO_WARNINGS
#include <winsock2.h>
#endif

//Jos ei kyseessä Visual Studio, oletetaan että Gnu C++

#ifndef _MSC_VER
#include <sys/socket.h>
#include <netinet/in.h>
#define SOCKET int
#define closesocket close
#define SOCKET_ERROR -1
#define INVALID_SOCKET -1
#endif

#define BUF_SIZE 1024
#define NIMI_SIZE 1024
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int lue(SOCKET conn, char *buf, int size) {
	int retu;

     //Luetaan viesti
	 retu = recv(conn, buf, size, 0);
     if (retu == 0) {
        perror("Jotain virhettä lukemisessa, viestin mitta 0");
        exit(-4);
     } else if (retu == SOCKET_ERROR) {
       perror("Datan vastaanotto epäonnistui");
       exit(-5);
     }
	 return retu;
}
