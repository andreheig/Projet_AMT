# JMeter test

Afin de tester que notre application effectue les modifications en bonne et due forme, nous avons lancer plusieurs test en parallèles d'insertions d'évents.

## Test rollback

Pour les test de rollBack, nous avons utilisé ce test:

![test_kill](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\test_kill.png)

Qui est sous le contrôleur évent kill:

![jmeter](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\test_kill_jmeter.png)

Ce qui envoi un évent, qui une fois traité donnera 100 points à notre utilisateur, grâce à cette règle:

![regle](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\regle_kill.png)

Puis une fois le test lancé, on obtient des erreurs de concurrence levé par Spring/JPA et traités par eux-même:

![error](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\info erreur transaction.png)

une fois que l'on observe le nombre d'évent passé, on peut voir que le nombre de point correspond bien au  nombre de point que l'on devrait avoir:

![scale](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\echelle.png)

Ou sous JMeter grâce à Groovy, et les variables extraites:

![groovy](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\groovy.png)

On peut voir que 3699 * 100 = 369900 points, malgré les erreurs de concurrence annoncé, on se retrouve donc bien avec une échelle de point qui correspond bien à ce que l'on s'attend (nombre de points concordant avec le nombre d'évent, et pas un nombre de point n'étant pas en relation avec le nombre d'évent).



## Changement de paramètres:

Pour tester d'autres évènements, on peut changer les paramètres d'extracteur JSON afin de prendre une autre échelle (on se concentre ici sur l'échelle Killpoints, qui va être changé pour "Chuck Norris doesn't need an OS."):

![scale_Killpoint](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\scale_killpoints.png)

![groovy_2](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\groovy_2.png)

Ainsi que dans le script Groovy, changer la variable rule qui correspond à ce que la règle applique (ici on passe à 50):

![script](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\script_groovy.png)

Et notre test passe encore:

![event_OK](C:\Users\Andre\IntelliJProject\Projet_AMT\.md\pictures\event_pass.png)