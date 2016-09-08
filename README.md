# Dockerizing WebDriver Tests

This is a sample repo which runs selenium WebDriver tests inside docker container.

Make sure you have docker installed on your machine.(https://docs.docker.com/engine/installation/linux/ubuntulinux/)

## Run Command

docker-compose up -d

Now check [GridConsole](http://localhost:4444/grid/console) you will see all the nodes are registered to the hub and test would be triggered inside the containers.

If you want to scale you node

docker-compose scale chromenode=3

To view the test running within the container, make sure you have vnc client installed on your machine.

$ docker port <container-name|container-id> 5900
0.0.0.0:49338
0.0.0.0:49339

./vncviewer 127.0.0.1:49338

When you are prompted for the password it is "secret", which will bring the container view.


