FROM deathbypython/chrome-selenium-awesome
MAINTAINER Jaydeep Chakrabarty "jaydeep.c1@gmail.com"

RUN sudo apt-get update
RUN sudo apt-get install -y git
RUN sudo apt-get install -y maven
RUN sudo apt-get install -y nano


RUN sudo apt-get install -y software-properties-common
RUN sudo apt-get update
RUN sudo apt-get install -y openjdk-8-jdk
RUN sudo rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
ENV JAVA_VERSION 8u102
ENV JAVA_DEBIAN_VERSION 8u102-b14.1-1~bpo8+1
ENV CA_CERTIFICATES_JAVA_VERSION 20140324

WORKDIR /home
