## 1
### Exécuter le programme hello à la racine
```docker run --rm hello-world /hello```

### Est-il possible d'exécuter un "ls" avec l'image hello-world ? 
```docker run --rm hello-world ls```

> docker run --rm hello-world ls

C:\Program Files\Docker\Docker\Resources\bin\docker.exe: Error response from daemon: OCI runtime create failed: container_linux.go:296: starting
 container process caused "exec: \"ls\": executable file not found in $PATH": unknown.
ERRO[0001] error waiting for container: context canceled

Non

### Pourquoi ?
Il n'y a pas de programme 'ls' ni dans l'image hello-world, ni dans l'image 'scratch'


### Dans un nouveau conteneur, executer la commande "ls" en utilisant l'image officielle alpine. Executer la commande top en "mode interactif"


```docker run --rm alpine:3.7 ls```
```docker run -it --rm alpine:3.7 top```

