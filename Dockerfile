FROM yegor256/java-maven
MAINTAINER SaiKrishna "saikrishna321@yahoo.com"

RUN sudo apt-get update
RUN sudo apt-get install -y git
RUN sudo apt-get install -y nano

ADD ./pom.xml /home

RUN cd home
RUN mvn clean install
