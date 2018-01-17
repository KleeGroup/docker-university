## 1

### Récupérer l'image hello-world de la registry docker officielle : https://hub.docker.com/explore/.
https://docs.docker.com/engine/reference/commandline/pull/

docker pull hello-world
### Créer un conteneur à partir de l'image récupéree
https://docs.docker.com/engine/reference/commandline/create/ 

docker create hello-world
xxxxx

### Démarrer le conteneur à partir de l'image récupérée
https://docs.docker.com/engine/reference/commandline/start/

docker start xxxxx

## 2
### Démarrer le conteneur à partir de l'image récupérée
https://docs.docker.com/engine/reference/run/

docker run hello-world
docker run --rm hello-world

### Quelle est l'image de base de hello-world ?
scratch
