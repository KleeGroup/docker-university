## 1
### Executer le programme hello à la racine
docker run --rm hello-world /hello

### Est-il possible d'executer un "ls" avec l'image hello-world ? 
docker run --rm hello-world ls
### Pourquoi ?
Il n'y a pas de programme ls ni dans hello-world, ni dans scratch


### Trouver une solution pour executer le programme "ls" dans un conteneur
Utiliser une image disposant du programme "ls"
docker run --rm bash ls

