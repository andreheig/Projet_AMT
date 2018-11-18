# **AMT 2018** - Test fonctionnels



Author:  André Jacquemond, Silver Kameni Tchieko Hyacinthe et Alexandre Vouilloz
Date: 12-11-2018



## Présentations des test:

Voici donc les tests disponibles dans le programme:

- `register` : permet de tester que l'on peut s'enregistrer, et que l'on se retrouve redirigé vers la page d'accueil des développeur.
- `loginAsDev` : permet de se connecter avec le compte d'un développeur et de s'assurer que l'on est bien redirigé vers la page d'accueil des développeur.
- `deconection` : permet de nous déconnecter de la session en cours.
- `loginAsAdmin` : permet de se connecter en tant qu'administrateur et de vérifier que l'on se retrouve bien sur la page d'accueil des administrateurs.
- `createAppCheckPaginationLogoutAndTryURL` : test fonctionnels permettant de:
  - Créer un nouvel utilisateur.
  - Créer entre 25 et 45 applications.
  - Tester que l'on a le bon nombres de pages en fonction du nombre d'applications fraîchement créer.
  - Tester que l'on peut clicker sur le bouton next X fois (cela dépendera du nombre d'applications généré).
  - Tester que l'on peut clicker sur le bouton previous X fois (cela dépendera du nombre d'applications généré).
  - Se déconnecter.
  - Tenter de revenir a des URL connues, et être redirigé vers la page home.
- `tryReachForbiddenPageAsDev` : permet de se connecter en tant que développeur, et de tenter d'accéder à une page administrateur (escalade de privilège) qui nous redirigera vers la page d'accueil des développeurs.
- `checkPaginationAsAdmin` : permet de se connecter en tant qu'administrateur, et de vérifier le nombre de pages disponibles en fonction du nombres de développeurs.
- `tryReachForbiddenPageAsAdmin` : permet de se connecter en tant qu'administrateur, et de tenter d'accéder à une page dev qui nous redirigera vers la page d'accueil des administrateurs.
- `checkPaginationAsDevBob` : permet de se connecter en tant que développeur, et de vérifier le nombre de pages disponibles en fonction du nombres d'applications.
- `loginAsUnknowUserShouldRedirectToRegister` : permet de tenter de se connecter avec un compte n'éxistant pas, et de vérifier que l'on est bien redirigé vers la page d'enregistrement.



## Exécution des tests:

Afin de pouvoir exécuter le pannel de tests il est primordiale d'avoir Java installé, ainsi qu'un IDE pour plus de convivialité (ici IntelliJ a été utilisé). Bien entendu, le projet `Projet_AMT` doit tourner quelque part pendant ces tests. Une fois le projet `Test_Projet` ouvert, il suffit de cliquer avec le bouton droit et faire `Run 'Test'` sur le fichier `test.java` situé sous `Test_Projet\src\test\java\selenium\test,java` 

![Lancement des tests](https://github.com/andreheig/Projet_AMT/Projet_AMT/.md/test fonctionnels/capture lancement test.png)

Puis les test vont commencer à se lancer, ainsi que le navigateur (dans le cas des tests, ce sera chrome):

![progression des tests](https://github.com/andreheig/Projet_AMT/Projet_AMT/.md/test fonctionnels/capture progression test 1.png)

Au final, vous devriez avoir une fenêtre comme ceci:

![fin de test OK](https://github.com/andreheig/Projet_AMT/Projet_AMT/.md/test fonctionnels/capture fin test ok.png)



## Variables modifiables:

Afin de permettre une flexibilité dans les test (de le relancer plusieurs fois d'affilé), certaines variables ont été introduites:

![constantes](https://github.com/andreheig/Projet_AMT/Projet_AMT/.md/test fonctionnels/Const.png)

- `BASEURL` : permet de spécifier l'URL de base de l'application a tester
- `MINAPPLICATION` : permet de fixer le nombre minimum d'applications qui sera créer par la boucle dans le test `createAppCheckPaginationLogoutAndTryURL` 
- `MAXAPPLICATION` : permet de fixer le nombre maximum d'applications qui sera créer par la boucle dans le test `createAppCheckPaginationLogoutAndTryURL` 
- `MINDESCRIPTION` : permet de fixer le nombre minimum de mots dans la description d'application
- `MAXDESCRIPTION` : permet de fixer le nombre maximum de mots dans la description d'application
- `NUMBEROFBOBAPPLICATION` : permet de donner le nombre actuel d'applications de bob
- `NUMBEROFDEV` : permet de donner le nombre actuel de developpeurs dans la base de données
- `PAGINATIONSIZE` : permet de definir le nombre d'éléments présents dans les pages actuellements

Ces variables sont utiles si le projet est déployé ailleur que sur localhost (`BASEURL`), si le code source vient à être modifié, ou simplement si le nombre de développeur augmente (ce qui est le cas avec le test `register` ou `createAppCheckPaginationLogoutAndTryURL`). Ces modifications peuvent alors engendrer des test qui ne passent plus, et qui amenraient des changements similaires à ceux-ci:

![erreur test](https://github.com/andreheig/Projet_AMT/Projet_AMT/.md/test fonctionnels/capture erreur pagination.png)

Vous pouvez les ajuster en vous connectant à l'application et en regardant le nombre actuel.