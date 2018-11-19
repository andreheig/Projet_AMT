# AMT 2018 - Test non fonctionnels - pagination



Author:  André Jacquemond, Silver Kameni Tchieko Hyacinthe et Alexandre Vouilloz
Date: 12-11-2018



## Présentations des tests:

Le projet a été testé avec la totalité du projet dockerisé. Ces tests permettent de s'apercevoir que la conception d'une application est importante, quel que soit le niveau sur lequel on travaille. Des tests de charges simulant 900 utilisateurs ont été effectués avec un système de pagination différente:

- récupérations de tous les éléments dans la base de données, puis sélections du nombre d'éléments utiles à afficher sur la page.
- récupération uniquement des éléments dans la base de données à afficher sur la page.

Les tests permettent donc de visualiser le temps que met le moyen de créer la pagination, avec le test de navigation entre 10 pages sur 900 utilisateurs.

`testJMeterAdmin`  en tant qu'administrateur, permet de voir la performance lorsque l'on ramène de la DB uniquement ce qui est nécessaire à afficher. 

`testJMeterDev`  en tant que développeur, permet de voir la performance lorsque l'on ramène de la DB tout, puis que l'on pioche avec le servlet pour choisir ce qui nous intéresse à afficher.

Pour cela, chaque arborescence de JMeter possède une boucle d'un certain nombre d'itérations, avec  différents contrôleurs :

- un permettant de paramétrer tout ce qui est nécessaire avant de commencer le test (paramètres HTTP par défaut, gestionnaire de cookies, et requête de login) 
- 10 contrôleurs pour les différentes pages (une par page)
- un contrôleur de fin de boucle pour se déconnecter (même s'il est possible de vider les cookies après chaque itération).



## Lancement du test:

1. ### En mode grapique:

Pour lancer le test, il est possible de cliquer directement sur `testJMeter.jmx` ou de lancer JMeter, et d'ouvrir le fichier de test. Une fois le test ouvert, vous aurez donc une arborescence comme celle-ci:

![présentation arborescence](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsPagination/presentationArborescence.png)

Vous pouvez ensuite lancer le test en cliquant sur la flèche verte:

![flèche lancement](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsPagination/flecheLancement.png)

Ou en allant dans le menu lancer, puis lancer:

![menu de lancement](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsPagination/menuDeLancement.png)

Une fois le test lancé, vous pouvez vous balader dans les différents rapports (ou autre chose) afin de voir les différents résultats. Ce mode n'est pas conseillé lords de réels tests de charge.

2. ### En ligne de commande:	

Pour plus de réalité, il est conseillé de lancer JMeter en ligne de commande une fois le plan de test effectué (afin d'éviter de perdre du temps à afficher des résultats intermédiaires à l'utilisateur) et d'obtenir un rapport final de ce test.

Pour cela, il faut ouvrir un terminal de commande, puis tapper:  

`<pathToJMeterBin>jmeter -n -t <testPlan.jmx> -l logfile.jtl -e -o <folderOutputForResult>`  

![CLI lancement](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsPagination/CLILancement.png)

Ensuite, il suffit d'attendre, et les résultats seront disponibles dans un dossier créer grâce à l'option -e -o.

![folder output](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsPagination/folderOutput.png)



## Interprétation des résultats:

Toutes les interprétations de résultats ont été faites avec les tests effectués en ligne de commande.

1. ### Pour le test `testJMeterAdmin`:

Une fois le test fini, on peut voir sur le graphique 

> Response Times Over Time 

![Responses Times Over Time admin](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsPagination/ResponsesTimesOverTimeAdmin.png)

On peut voir que nos réponses se situent entre 0 et  237 ms (valeurs obtenues du graphique). Grâce à la représentation en fonction du pourcentage, on peut voir que ces requêtes mettent un certain temps pour arriver:

> Response Time Percentiles

![Response Time Percentiles admin](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsPagination/ResponseTimePercentilesAdmin.png)

Après un zoom autour des 80 - 100%, on peut voir que le temps de réponse est supérieur à 127 ms (temps au minimum d'une des requêtes à 90%).

Voici donc le temps nécessaire au parcours de chacune des 10 pages sans le login en tant qu'administrateur pour les 90%:

page 1 : 135 ms, page 2 : 133 ms, page 3 : 130 ms, page 4 : 129 ms, page 5 : 128 ms, page 6 : 127 ms, page 7 : 127 ms, page 8 : 127 ms, page 9 : 128 ms, page 10 : 129 ms.

Ce qui nous fait un total de 1293 ms, ou environ 1,3 seconde.

2. ### Pour le test `testJMeterDev`:

Une fois le test fini, on peut voir sur le graphique 

> Response Times Over Time 

![Responses Times Over Time admin](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsPagination/ResponsesTimesOverTimeDev.png)

On peut voir que nos réponses se situent entre 0 et  58 ms (valeurs obtenues du graphique). Grâce à la représentation en fonction du pourcentage, on peut voir que ces requêtes mettent un temps restreint pour arriver.

> Response Time Percentiles

![Response Time Percentiles admin](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsPagination/ResponseTimePercentilesDev.png)

Après un zoom autour des 80 - 100%, on peut voir que le temps de réponse est supérieur à 55ms (temps au minimum d'une des requêtes à 90%).

Voici donc le temps nécessaire au parcours de chacune des 10 pages sans le login en tant que développeur pour les 90%:

page 1 : 55 ms, page 2 : 56 ms, page 3 : 56 ms, page 4 : 56 ms, page 5 : 56 ms, page 6 : 55 ms, page 7 : 55 ms, page 8 : 55 ms, page 9 : 55 ms, page 10 : 55 ms.

Ce qui nous fait un total de 554ms, ou environ 0,6 seconde.

3. ### Conclusion:

Ces deux tests ont donc montré qu'il était plus rapide d'utiliser la pagination propre aux développeurs qu'aux administrateurs. En effet, le temps de parcours se voit diminuer par 2! (Magie des EJB?) Ce qui démontre une différence par rapport à la logique qui nous amènerait à croire que ramener 10 éléments à chaque fois est plus performant que de tout ramener à chaque fois, et de prendre ensuite nos 10 éléments.