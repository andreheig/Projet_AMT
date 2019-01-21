# JMeter test

Afin de tester que notre application effectue les modifications en bonne et due forme, nous avons lancer plusieurs test en parallèles d'insertions d'évents.

## Test rollback

Pour les test de rollBack, nous avons utilisé ce test:

![test_kill](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/test_kill.png)

Qui est sous le contrôleur évent kill:

![jmeter](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/test_kill_jmeter.png)

Ce qui envoi un évent, qui une fois traité donnera 100 points à notre utilisateur, grâce à cette règle:

![regle](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/regle_kill.png)

Puis une fois le test lancé, on obtient des erreurs de concurrence levé par Spring/JPA et traités par eux-même:

![error](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/info_erreur_transaction.png)

une fois que l'on observe le nombre d'évent passé, on peut voir que le nombre de point correspond bien au  nombre de point que l'on devrait avoir:

![scale](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/echelle.png)

Ou sous JMeter grâce à Groovy, et les variables extraites:

![groovy](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/groovy.png)

On peut voir que 3699 * 100 = 369900 points, malgré les erreurs de concurrence annoncé, on se retrouve donc bien avec une échelle de point qui correspond bien à ce que l'on s'attend (nombre de points concordant avec le nombre d'évent, et pas un nombre de point n'étant pas en relation avec le nombre d'évent).



## Changement de paramètres:

Pour tester d'autres évènements, on peut changer les paramètres d'extracteur JSON afin de prendre une autre échelle (on se concentre ici sur l'échelle Killpoints, qui va être changé pour "Chuck Norris doesn't need an OS."):

![scale_Killpoint](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/scale_killpoints.png)

![groovy_2](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/groovy_2.png)

Ainsi que dans le script Groovy, changer la variable rule qui correspond à ce que la règle applique (ici on passe à 50):

![script](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/script_groovy.png)

Et notre test passe encore:

![event_OK](https://github.com/andreheig/Projet_AMT/blob/partTwo/.md/pictures/event_pass.png)