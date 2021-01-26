Thomas Guzik
Lisa Gernez

# Algo de diffusion

## Trois modèles de cohérence

Problème des lecteurs rédacteurs...
Ici on a pour Subject une variable qui est l'attribut valeur du sujet, 1 rédacteur (le mutateur), et N lecteurs (les observers). Il y a 3 idées pour la mise en oeuvre:
- cohérence atomique, cohérence séquentielle, incohérence assistée

Mais d'abord, définissons les cohérences dans ce cadre :
- Soit V la suite des valeurs écrites dans la variable V = V_1, V_2,...,V_x produites par le mutateur (= rédacteur).
- Soit L(i) la suite des valeurs lues par chaque observer O_i : `L(i) = L(i)_1,...``

*fin td1 2020-10-13*

## Cohérence atomique

#### Définition de atomique

Pour tout i : L(i) = V

Toutes les valeurs écrites sont des valeurs lues. La suite de valeurs écrites V est la même que la suite de valeur lues L(i)

#### Réalisation (comment faire)

Les appels ne se perdent pas, ils sont executés une fois.

Alternance rédacteurs/lecteurs :

1. Initialement le rédacteur peut écrire dans la variable (= le mutateur peut modifier le sujet,
un appel à setValue(v_i))

2. À la fin de l'écriture, la phase de lecture commence.

3. Pendant la phase de lecture, toute écriture est interdite.

4. Lorsque tous les lecteurs ont lu une fois (par appel à getValue()) la phase de lecture termine et la phase d'écriture
commence.

### Cohérence séquentielle

#### Définition de séquentielle

1. Pour tout i : L(i) est une sous-suite de V
-> Ce qui signifie que certaines valeurs écrites par le redacteur ne sont pas connu par les observers

2. Pour tout i : L(i) = L ; une seule sous-suite autorisée => tous les lecteurs (Observers) voient la même chose

Avantage par rapport à la cohérence atomique : on ne bloque pas le mutateur (pas d'exclusion mutuelle entre
lecteurs et rédacteur).

Inconvénient : on perd des valeurs produites par le rédacteur.

Dans certains nombre de cas, on a besoin que le rédacteur écrite les valeurs produites le + rapidement possible même si on perd des données (par ex. thermomètre)

#### Réalisation

1. Les lecteurs lisent une copie de la variable.

2. Le mutateur écrit dans l'original, sans exclusion mutuelle.

3. Au début d'une phase de lecture, on copie l'original dans la variable copie et les getValue() retourne la valeur de la copie.

4. Lorsque tout les lecteurs ont lu une fois, la phase de lecture est finie : pendant la phase de lecture la copie est "gelée".

En d'autres termes : une variable pour le rédacteur, une autre pour les lecteurs ; cohérence atomique de la copie

### Incohérence (assistée)

#### Définition de causale

1. Pour tout i : L(i) est une sous-suite de V

Par contre pas de règle pour dire que les L(i) doit être unique


#### Implémentation de causale

1. On utilise un mécanisme d'horloge (estampille). (utilisation d'un temps logique, de tampon : au temps(i), la variable vaut ...)

1. Au moment de l'écriture de la valeur V_i, la valeur est estampillée avec i.

2. Lors d'une lecture, un lecteur reçoit la valeur courante de la variable, avec son estampille.

3. Si la valeur reçue est plus ancienne que celle précédemment reçue(par ex. on fait 2 getValue()), on ne garde que la plus récente (au sens des estampille, = celle qui a l'estampille la plus élevée).


# Info TP

", les données diffusées seront une séquence croissante d’entiers" -> on peut faire de la cohérence atomique, car on peut prévoir les valeurs. Egalement v(i) = i

"les canaux" -> permettent de mettre un délai.

" un ensemble de canaux de transmission avec des délais variables" -> au moins 4 canaux 

" un ensemble d’afficheurs réalisés en utilisant la bibliothèque graphi-
que Swing ; " -> pas besoin, par contre enregistré ça dans des listes pour qu'on puisse faire des tests et qu'oracle puisse dire que les affichers se comportent bien comme des lecteurs dans le modèle de cohérence atomique/ séquentielle/ incohérence.

" un ensemble de politiques de diffusion Observer," -> gestion de la cohérence

pattern strategy est utilisé pour gérer les 3 pattern de diffusion

le canal joue le role de proxy


*2020-10-13*
tick -> opération qui passe par le mutateur qui va incrémenter la valeur du capteur

tick -> d'habitude il y a notify, mais on a décidé d'appliquer le pattern strategy, donc on fait execute ???

Comme il y a eu une écrite, on utilise l'algo


notifyobse]ver dans diffusion atomqiue

le modele m2 de l'intéresse pas

*2020-10-19*

Passer du M1 à M2 :

1. Définir l'interface asynchrone à partir de l'interface synchrone
2.  Definir un proxy

Dans un canal on met les délai

Il ne faut pas mettre les diagrammes m2

Actice object en mirroir l'un de l'autre
Les opérations asyncrhones se font des deux cotés


M3

Conseil de mise en oeuvre

Classe de configuration :
- Créer le capteur instance de CapteurImpl
- Créer 4 canaux
- Créer 4 afficheurs, chaque afficheur écrit dans la console avec Logger... et enregistre dans une liste la valeur reçue
- Connecter tout ça

- Pas de besoin de Update et GetValue = utiliser les lambda

- Employer suffisament de thread

Ecriture de l'oracle :

Après arret de l'execution (après 100 tick par exemple )
Comparaison des traces enregistrées par chaque afficheur
On ne retient que le plus court préfixe (si l'enregistreur A a 90 valeur enregistré et les autres en ont plus on s'arretre à 90)

- atomique : toutes les traces sont égales à 1,2...L
- séqentielle : toutes les traces sont croissantes et identiques
- à époque ou cuasle : toutes les traces sont croissantes

*2020-11-20*

- on est pas obigé de mettre les detach et attach dans les ineterfaces asynchrone
- créer une classe App
- l'oracle compare les listes dans les enregistreurs (c'est à dire les listes)
- ScheduledExecutorService -> dans App


# Diagramme de conception

# M1

![](./img/M1.png)

![](./img/M1_seq.png)
Il manque des update vers diffusion atomique

# M2

![](./img/m2.png)

![](./img/m2_seq_001.png)

![](./img/m2_seq_002.png)


# M3

![](./img/m3.png)

![](./img/m3_seq.png)

![](./img/m3_seq_001.png)

![](./img/m3_seq_002.png)

![](./img/m3_seq_003.png)






