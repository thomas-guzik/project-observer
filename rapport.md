# Projet AOC

Gernez
Guzik

# Lancer les tests

Sur docker :
```
docker build -t observer .
docker run --name observer -t observer

// Pour supprimer le container
docker rm observer
// Ensuite supprimer l'image
docker rmi observer
```

Sur votre terminal :
```
mvn test
```

# Patron de conception

## Patron Proxy

Nous avons commencé par regarder les patterns proxy :

![](./img/proxy_up.png)

![](./img/proxy_down.png)

Nous en avons conclu :

![](./img/proxy.png)

## Patron Observer

## Patron Strategie

## Patron Active Object

À première vue, nous avons pensé à ça :

Par la suite, nous avons décidé d'utiliser cette architecture :

# Implémentation des algorithmes

## Introduction

## Cohérence atomique

## Cohérence séquentielle

## Incohérence

# Résultat des tests

Pour la cohérence atomique, le test consiste ...




