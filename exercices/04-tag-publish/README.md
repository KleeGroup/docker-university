
## 1 Tag
1. Tagger l'image custom buildée dans l'exercice 3 avec votre nom et la version 0.0.1. 

2. Vérifier que l'image soit correctement taggée en listant les images.


## 2 Publish
1. Publier votre version sur la registry privée de vertigo : docker-vertigo.part.klee.lan.net:5000

**NOTE**: Ajouter dans la conf docker (daemon.json): ```{ "insecure-registries":["docker-vertigo.part.klee.lan.net:5000"] }```

**NOTE 2**: En cas de problème avec docker-vertigo.part.klee.lan.net essayer en localhost : 

```docker run -d -p 5000:5000 registry:2.6.2``` 

Ajouter dans la conf docker (daemon.json): 
```{ "insecure-registries":["localhost:5000"] }```


