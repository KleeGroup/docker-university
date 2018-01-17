
### Builder une image en modifiant la commande par default par "echo <votre-nom>"
Modifier le fichier dockerfile
docker build .

### Executer un nouveau conteneur utilisant cette nouvelle image (ne pas oublier de cleaner le conteneur après execution)
docker run --rm <image-id>

### Executer un nouveau conteneur en surchargant la commande par "pwd"
docker run --rm <image-id> pwd
