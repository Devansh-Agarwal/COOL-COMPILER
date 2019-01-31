#!/bin/bash
wget http://www.antlr.org/download/antlr4-cpp-runtime-4.7.1-source.zip
unzip antlr4-cpp-runtime-4.7.1-source.zip -d antlr4-cpp
cd antlr4-cpp
mkdir build run
cd build
if [ -e /proc/cpuinfo ]; then
    procs=`cat /proc/cpuinfo | grep processor | wc -l`
else
    procs=1
fi

cmake .. -DANTLR_JAR_LOCATION=$1

make -j$procs

DESTDIR=`pwd`/../run make install
cd ..
echo "export ANTLR4CPP=`pwd`" >> ~/.bashrc
source ~/.bashrc
echo "export LD_LIBRARY_PATH=`pwd`/run/usr/local/lib:$LD_LIBRARY_PATH" >> ~/.bashrc
source ~/.bashrc