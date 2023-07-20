#定义生成的目标文件
CPP = g++
FLAG += -g -Wall -std=c++11

LIB_PATH+=-L/usr/local/lib 
LIB_PATH+=-L/usr/local/lib/boost

EXTRA_LIBS=-ldba.so -lphp-8.0 -lpthread -lboost_system
CFLAGS=-static -llibdhcp.a -ldhcpctl
#定义目标文件
SRC=./src

SOURCE := $(wildcard $(SRC)/*.cpp) $(wildcard $(SRC)/common/*.cpp)
OBJS := $(patsubst %.cpp,%.o,$(SOURCE))

EXEC=CMS

all:    $(EXEC)
$(EXEC):$(OBJS)
　　$(CPP) $(FLAG) -o $(EXEC) $(OBJS) $(EXTRA_LIBS) $(LIB_PATH)

######各文件的依赖关系
.cpp.o:
　　$(CPP) $(FLAG) $(CFLAGS) -c -o $@ $<

######定义依赖关系结束
clean:
　　rm -f ${SRC}/*.o

#g++ -g -Wall -std=c++11 main.cpp epoll_server.cpp -c 
#g++ main.o epoll_server.o -o -L/usr/local/lib -L/usr/local/lib/boost