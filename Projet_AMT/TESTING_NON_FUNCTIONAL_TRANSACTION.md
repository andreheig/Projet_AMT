# AMT 2018 - Test non fonctionnels - transaction



Author:  André Jacquemond, Silver Kameni Tchieko Hyacinthe et Alexandre Vouilloz
Date: 18-11-2018



## Présentations des tests:

Différents tests ont été effectués afin de voir les possibles rollback possibles géré par les EJB.

Plusieurs test sont disponible, mais afin de les faire fonctionner, il est nécessaire de modifier la variable `test` indiquant le test à sélectionné (parmi `INSERTEXIST`, `DELETENOTWORK` et `DELETEWORK`)

`INSERTEXIST` permettre de se familiarisé avec les test, c'est un test "basic" permettant de tenter d'insérer un utilisateur déjà présent.

`DELETENOTWORK` permet de supprimer un utilisateur, et une fois ses applications supprimer, de supprimer ce-dit utilisateur. Une erreur est levé entre la suppression de l'utilisateur dans la table `Developper`, et la suppression dans la table `User` afin de montrer les différents comportement en fonction du type de transaction.

`DELETEWORK` permet de supprimer un utilisateur correctement et de voir que le nombre d'utilisateurs, ainsi que le nombre d'applications diminue.



## Variables d'attribut de transaction:

Voici la présentations de ces variables, permettant d'obtenir plusieurs cas possibles lors des transactions:

`REQUIRES_NEW` permet de supprimer une partie (app delete mais user encore la)

`REQUIRED` permet de supprimer en cascade s'il n'y a pas d'erreur.

`MANDATORY` ne permet pas la suppression en cascade (un ejb fait une transaction, puis en appelle un autre qui lance une erreur)

`NOT_SUPPORTED` permet de supprimer quoi qu'il arrive

`SUPPORTS` permet de supprimer

`NEVER` permet de supprimer



## Détails des tests avec le changement des variables d'attribut:

1. ### Test d'insertion d'un utilisateur déjà existant:

Voici l'utilisateur que l'on tente d'insérer à double:

![SQL avant insertion user](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/SQLAvantInsertionUser.png)

La modification des attributs de transaction dans la classe `UserDAO` comme suit permet:

`REQUIRED` : pas de modifications, lève une exception récupérable

![insertion échoué](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/insertionEchoue.png)

`REQUIRES_NEW` : idem

`MANDATORY` : lève une exception non récupérable, rien n'est ajouté

![erreur_irrécupérable](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/erreurIrrecuperable.png)

`NOT_SUPPORTED` : l'utilisateur est inséré! Lève une exception récupérable (inséré uniquement dans la table `User`, pas présent dans `Developper`)

![insertion échoué partiellement](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/insertionEchouePartiellement.png)



![SQL après insertion user](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/SQLApresInsertionUser.png)

`SUPPORTS` : idem

`NEVER` : idem

2. ### Test de suppression raté:

Voici ce que contient les tables pour tester cette partie:

![SQL user 6 (suppression partielle)](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/SQLUser6(suppressionPartielle).png)

La modification des attributs de transaction dans la classe `UserDAO` et `ApplicationDAO` comme suit permet:

`REQUIRED` `REQUIRED` : pas de modifications

`REQUIRES_NEW` `REQUIRES_NEW` : Suppressions des applications (tout est supprimé dans la table `DevApp`, mais la table `Developper` ne se trouve pas touché malgré l'exception placé après)! Lève une exception récupérable

![SQL suppression partielle 6 REQUIRES_NEW](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/SQLSuppressionPartielle6REQUIRES_NEW.png)

![suppression_partielle](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/suppressionPartielle.png)

`MANDATORY` `MANDATORY` : lève une exception non récupérable, rien n'est supprimé

![erreur_irrécupérable](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/erreurIrrecuperable.png)

`NOT_SUPPORTED` `NOT_SUPPORTED` : Suppressions des applications de l'utilisateur, et partiellement de l'utilisateur (tout est supprimé dans la table `DevApp`et `Developper`, uniquement la table `User` ne se trouve pas touché)

![SQL suppression partielle 6](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/SQLSuppressionPartielle6.png)

`SUPPORTS` `SUPPORTS` : idem

`NEVER` `NEVER` : idem

3. ### Test de suppression ok:

Voici ce que contient une partie de la table pour ce test:

![SQL user 4 (suppression ok)](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/SQLUser4(suppressionOk).png)

La modification des attributs de transaction dans la classe `UserDAO` et `ApplicationDAO` comme suit permet (malgré que beaucoup de cas se révèlent sans intérêt étant donnée que l'on souhaite que la transaction soit correctement effectué) :

`REQUIRED` `REQUIRED` : suppression OK

![suppression ok](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/suppressionOk.png)

![SQL suppression ok](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/SQLSuppressionOk.png)

`REQUIRES_NEW` `REQUIRES_NEW` : idem

`MANDATORY` `MANDATORY` : lève une exception non récupérable, rien n'est supprimé

![erreur_irrécupérable](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/erreurIrrecuperable.png)

`NOT_SUPPORTED` `NOT_SUPPORTED` : suppression OK

`SUPPORTS` `SUPPORTS` : idem

`NEVER` `NEVER` : idem

4. ### Conclusion des tests:

Les différents test on permis de voir que : 

- l'option `MANDATORY` ne permet pas d'avoir des transaction d'EJB imbriqué, mais permet de protéger les transaction en ne modifiant aucune table dans le cas d'une erreur.
- les options `NOT_SUPPORTED`, `SUPPORTS` et `NEVER`, permettent de prendre en compte les changements, jusqu'à l'arrivé de l'erreur, i.e. pas de roll-back. Cette option implique l'incrémentation des id malgré une erreur (dans le cas d'insertions pour les test effectué).

![grignotage des id lors d'erreur d'insertions](https://github.com/andreheig/Projet_AMT/blob/master/Projet_AMT/.md/testNonFonctionnelsTransaction/grignotageId.png)

- l'option `REQUIRES_NEW` permet d'annuler une transaction s'il y a une erreur au milieu, i.e. faire un roll-back (les transaction d'un EJB sont indépendantes les unes des autres).
- l'option `REQUIRED` permet d'annuler entièrement une transaction si une erreur survient, i.e. fait un roll-back