
### Exporter l'image webapp dans un tar.
```docker save --output webapp-0-0-1.tar webapp:0.0.1```

### Supprimer l'image en local. Lister les images et vérifier que l'image ne soit plus disponible.
```docker rmi webapp:0.0.1```

### Importer l'image à partir du tar. 
```docker load --input webapp-0-0-1.tar```

### Lister les images et vérifier l'image soit de nouveau disponible.
```docker images```

