#include<stdio.h>
#include<unistd.h>
#include<fcntl.h> // open
#include<stdlib.h>

int main(void){
    int fd;
    char *buf;
    buf = (char*) malloc(sizeof(char)*30);
    fd = open("test.txt", O_RDONLY);

    printf("1) read의 반환값: %z\n", read(fd,buf,10));
    printf("buf의 결과 : %s\n", buf);

    free(buf);
    close(fd);
    return 0;
}