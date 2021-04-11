# Getting Started with Docker

## Commands

### Building an Image
```sh
# Check docker version
docker --version

# Building a docker image for an App
# Everything in current directory will get build as an image
# deepanshubhatti is username for docker hub
# gsd is repository name
# first-ctr is image name
docker image build -t deepanshubhatti/gsd:first-ctr .

```

### Hosting a Registry

```sh
# Login to docker in terminal
docker login

# Pushing image to Docker Hub
docker image push deepanshubhatti/gsf:first-ctr
```

### Running a Centralized App

```sh
# Run a container and redirect data to a port
docker container run -d --name web -p 8000:8080 deepanshubhatti/gsd:first-ctr

# Show Containers running
docker container ls -a

# Start a Container (Name: web)
docker container start web

# Stop a Container (Name: web)
docker container stop web

# Delete a Container
docker container rm web
```

---

## Micro Services

```sh
# To Create 3 Docker Services
docker service create --name web -p 8080:8080 --replicas 3 deepanshubhatti/gsd:first-ctr

# To list docker services
docker service ls

# To get docker service with name
docker service ps web

# To scale number of replicas
docker service scale web=10

# Remove containers
docker container rm -f <names>
```

## Swarm Stack

```sh

# Initialize Swarm
docker swarm init

# deploy the app
docker stack deploy -c docker-compose.yml counter

# List stack
docker stack services counter

# Remove all conatiner in stack
docker stack rm counter

```

---
