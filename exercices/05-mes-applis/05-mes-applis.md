
## 1 
### En utilisant docker, démarrer un serveur elasticsearch en version 5.6. Ce serveur doit être accessible depuis un autre conteneur docker mais pas de l'exterieur. 


### Vérifier que le conteneur soit bien à l'état 'Running'. Naviguer sur http://localhost:9200/ ,la connexion doit entrer en time out.


## 2 
### En utilisant le jar dans le répertoire batch, créer une image permettant d'exécuter le jar avec java 8 ("java -jar batch-0.0.1.jar")
**HINT: Utiliser ENTRYPOINT et COPY. Ne pas utiliser entrypoint.sh**




### Exécuter l'image sans paramètre


### Exécuter l'image avec les paramètres ```elasticsearch http://monelasticsearch:9200```


## 3 
### Ajouter maintenant le script /entrypoint.sh dans l'image, faire de ce script l'entrypoint et rebuilder l'image. 


### Lancer maintenant le conteneur de manière à passer l'url d'élasticsearch (```http://monelasticsearch:9200```) dans la variable d'environement ```URL_ELASTICSEARCH``` et non en second paramètre du conteneur. L'url doit s'afficher dans la console et l'appel au serveur elasticsearch doit échouer.


## 4 
### Corriger le problème de connexion ci-dessus. Le résultat doit afficher le status du noeud elasticsearch.
**HINT : 2 Solutions : User-Defined network ou Legacy Link**

**Solution 1: User-Defined network**


**Solution  2 : Legacy Link**



## 5 
### En utilisant le war dans le répertoire webapp, créer une image exécutant un serveur tomcat 8. Ce serveur doit être accessible de l'exterieur. Naviguer sur http://localhost:8080/webapp/ . Le site doit être accessible.
**Note : Ajouter la ligne :**

```RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf```
