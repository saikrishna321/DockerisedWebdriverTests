# Snap-CI-AccountsDemoTest running within Docker Container in Parallel

This is a sample repo which runs selenium WebDriver tests inside docker container.

Make sure you have docker installed on your machine.

## Run Command

docker-compose up -d && docker-compose down

Now check http://localhost:4444/grid/console you will see all the nodes are registered to the hub and the test will run inside the container.

If you want to scale you node

docker-compose scale chromenode=3
