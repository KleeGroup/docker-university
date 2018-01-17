
#1 
### En utilisant docker, démarrer un serveur elasticsearch en version 5.6. Ce serveur doit être accessible depuis un autre conteneur docker mais pas de l'exterieur du démon docker. 
```docker run -d --rm --name=monelasticsearch elasticsearch:5.6-alpine```

### Vérifier que le conteneur soit bien à l'état 'Running'. Naviguer sur http://localhost:9200/ ,la connexion doit entrer en time out.
```docker ps```

#2 
### En utilisant le jar dans le répertoire batch créer une image permettant d'executer le jar avec java 8 ("java -jar batch-0.0.1.jar")
HINT: Utiliser ENTRYPOINT et COPY

Creer le dockerfile
```docker build . -t batch```

### Executer l'image sans paramètre
```docker run --rm batch```

### Executer l'image avec le paramètre "elasticsearch" http://monelasticsearch:9200
```docker run --rm batch "elasticsearch" http://monelasticsearch:9200```

#3 
### Ajouter maintenant le script /entrypoint.sh dans l'image et faire de ce script l'entrypoint et rebuilder l'image. 
Modification dockerfile

### Lancer maintenant le conteneur de manière à passer l'url d'élasticsearch (http://monelasticsearch:9200) dans la variable d'environement URL_ELASTICSEARCH et non en second paramètre.
```docker run -e URL_ELASTICSEARCH=http://monelasticsearch:9200 --rm batch:0.0.1 elasticsearch```

#4 
### Démarrer un conteneur en utilisant l'image buildée en 2 pour lancer le batch avec le paramètre "elasticsearch" et la variable d'environnement URL_ELASTICSEARCH. Le résultat doit afficher le status du noeud elasticsearch.
HINT : 2 Solutions : User-Defined network ou Legacy Link

**Solution 1: User-Defined network**
```
docker network create -d bridge --subnet 192.168.0.0/8 elasticsearch_nw
docker run -d --rm --network=elasticsearch_nw --name=monelasticsearch elasticsearch:5.6-alpine 
docker run --rm --network=elasticsearch_nw batch "elasticsearch" http://monelasticsearch:9200
```

**Solution  2 : Legacy Link**
```docker run --rm --link monelasticsearch:monelasticsearch batch "elasticsearch" http://monelasticsearch:9200```


#5 
### En utilisant le war dans le répertoire webapp créer une image éxécutant un serveur tomcat 8. Ce serveur doit être accessible de l'exterieur du démon docker. Naviguer sur http://localhost:8080/webapp/ . Le site doit être accessible.
**Note : Ajouter la ligne : **
RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf

```
docker build . -t webapp
docker run -d --rm -p 8080:8080 webapp 
```
