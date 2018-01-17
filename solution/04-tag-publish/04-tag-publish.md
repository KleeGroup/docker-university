
#1
### Tagger l'image custom buildée dans l'exercice 3 avec votre nom et la version 0.0.1. 
docker tag <image-id> <votre-nom>:0.0.1

### Verifier que l'image soit correctement taggée en listant les images.
docker images

#2
### Publier votre version sur la registry privée de vertigo : docker-vertigo.part.klee.lan.net:5000
***NOTE: Ajouter dans la conf docker (daemon.json): { "insecure-registries":["docker-vertigo.part.klee.lan.net:5000"] }***

docker tag <image-id> docker-vertigo.part.klee.lan.net:5000/<votre-nom>:0.0.1
docker push docker-vertigo.part.klee.lan.net:5000/<votre-nom>

***NOTE 2: En cas de problème avec docker-vertigo.part.klee.lan.net essayer en localhost : 
Ajout dans la conf docker (daemon.json): { "insecure-registries":["localhost:5000"] }***

docker run -d -p 5000:5000 registry:2
docker tag <image-id> localhost:5000/<votre-nom>:0.0.1
docker push localhost:5000/<votre-nom>

