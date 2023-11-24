# RolePlayCardPlugin

Plugin minecraft 1.19 permettant aux joueurs de se créer une fiche roleplay pour leur personnage.

Fonctionnalités :
- Créé une fiche rp et y ajouter ces différentes paramètres :
  - Son nom RP
  - Ses titres/rangs
  - Sa religion
  - Ses professions/métiers
  - Ses origines
  - Sa race
  - S’il est mort ou vivant
  - Eventuellement son âge.
- L’affichage de l’âge est activable dans la config. (les joueurs peuvent toujours le définir mais il ne sera jamais affiché.)
- Un lien vers une page wiki du nom RP du joueur est automatiquement ajouté au profil du joueur.
- Chaque profil est stocké sous format json
- On peut modifier le lien du wiki dans la config

Commandes :
- La commande de base est /rpcard
- Pour changer un paramètre de sa fiche il faut faire /rpcard set [le paramètre] (parmis nom_rp, race, age, status, titre, religion, métier, origine).
Si le profil du joueur n’existe pas encore, il est automatiquement créé.
- Pour /rpcard set status il faut ensuite ajouter “vivant” ou “mort” pour définir le statut du personnage.
- Pour afficher son propre profil il faut faire /rpcard see
- Pour afficher le profil de quelqu’un il faut faire /rpcard see [pseudo]
Si le profil  pour le joueur demandé n’existe pas, un profil vide sera généré


