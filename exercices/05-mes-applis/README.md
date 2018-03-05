
## 1 Elasticsearch
1. En utilisant docker, démarrer un serveur elasticsearch en version 5.6. Ce serveur doit être accessible depuis un autre conteneur docker mais pas de l'exterieur. 


2. Vérifier que le conteneur soit bien à l'état 'Running'.
Depuis l'hote, avec un navigateur tester l'url http://localhost:9200/ : la connexion doit entrer en timeout.

3. Depuis un nouveau conteneur (image alpine 3.7), executer la commande ```wget -qO- <ip-container>:9200``` sur l'adresse IP du conteneur, le serveur doit répondre avec son status en JSON.
L'adresse IP d'un conteneur peut-être récupérée avec la commande : 
```docker inspect <container_id>```


## 2 Batch v1
1. En utilisant le jar dans le répertoire batch, créer une image permettant d'exécuter le jar avec java 8 (```java -jar batch-0.0.1.jar```)

**HINT 1**: Utiliser ENTRYPOINT et COPY. Ne pas utiliser entrypoint.sh

**HINT 2**: Utiliser de preference l'image de base openjdk:8-jdk-stretch


### Exécuter l'image sans paramètre.
La sortie standard doit afficher : 
```
args:0
Hello from batch
```
2. Exécuter l'image avec les paramètres ```elasticsearch http://<ip-container>:9200```

L'url doit s'afficher dans la console et l'appel au serveur elasticsearch doit retourner le status JSON d'ES.

## 3 Batch v2
1. Ajouter maintenant le script /entrypoint.sh dans l'image, faire de ce script l'entrypoint et rebuilder l'image.
Le script /entrypoint.sh permet de récupérer la variable d'environnement "URL_ELASTICSEARCH" et d'appeler le batch java avec les paramètres ```elasticsearch http://<ip-container>:9200```.

2. Lancer maintenant le conteneur de manière à passer l'IP d'élasticsearch (```http://x.x.x.x:9200``` ```x.x.x.x``` correspond à l'IP de la machine ES) dans la variable d'environnement ```URL_ELASTICSEARCH``` et non en second paramètre du conteneur. L'url doit s'afficher dans la console et le serveur doit répondre ses infos en JSON.


## 4 Network v1
1. Lancer le conteneur avec le nom du conteneur à la place l'adresse IP. Le résultat doit afficher le status du noeud elasticsearch.

**HINT : 2 Solutions : User-Defined network ou Legacy Link**

**Solution 1: User-Defined network**


**Solution 2: Legacy Link**


## 5 Network v2
1. En utilisant le war dans le répertoire webapp, créer une image exécutant un serveur tomcat 8. Ce serveur doit être accessible de l'exterieur. Naviguer sur http://localhost:8080/webapp/ .

**Note : Ajouter la ligne :**

```
RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf
```

