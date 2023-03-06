# hippopocrate

Sur ce projet collaboratif, nous avons créé une application de gestion des séjours des patients dans un Hopital fictif. 
Les fonctionnalités présentes dans ce projet sont les suivantes: 

*Ajouter un nouveau patient, modifier des patients existants.
*Prendre en compte l’arrivée d’un patient dans un service.
*Prendre en compte la sortie d’un service.
*Affecter un patient, lors d’un séjour, à un lit qui est lui-même dans une chambre.
*Des niveaux d'habilitation ont été mis en place : Administrateur, Infirmier, secretaire médical.

Cette application a été développée sous Spring Boot et Angular. Une API REST a par ailleurs été incluse, elle gère le bon fonctionnement des applications.
L’authentification à l’application est sécurisé (cryptage des mots de passes, utilisation d'identifiants), il en va de même avec la liaison entre le client et le serveur web (CORS, HTTPS...).
Cette application est par ailleurs lié à une BDD mySQL via un identifiant unique et un mot de passe personnalisé.
