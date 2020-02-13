Projet Bibliothèque - projet 10
=

Référence 
---
* https://openclassrooms.com/fr/courses/5684146-create-web-applications-efficiently-with-the-spring-boot-mvc-framework

Environnement 
---
* Spring Boot ( Web, Security, Data/Jpa, Hibernate, Mail), PostgreSql, httpClient, Git, Maven

Jars executables
---
* Un service REST pour les  méthodes de persistence - Spring Data/JPA et Hibernate.
* Un batch  pour envoi de email - "@Scheduled" 
* Une Web application MVC - template engine : ThymeLeaf

Installation sous Windows
---
* Git version 2.24.0.windows.2
* Apache Maven  3.6.0
* Intellij IDEA 2019.3.1 Ultimate
* Oracle JDK 11.04
* PostgreSql 12
* Projet  à Cloner depuis  https://github.com/lco3004/ocr-projet07-v3.git

Création  de la base  PostgreSql
---
* cd ${basedir]/sql_uml
* docker-compose up -d

Lancement des applications
--
Service Rest
---
* Ouvrir un terminal puis se placer dans le répertoire du service_crud
* Lancer l'application avec mvn spring-boot:run (c'est une démo...)

Application Web
---
* Ouvrir un terminal puis se placer dans le répertoire de l'application Web
* Lancer l'application avec mvn spring-boot:run (c'est une démo...)


Application  Batch
---
* Se placer dans le répertoire de l'application
* Editer le fichier application.yml et valoriser les champs de la rubrique Mail
* lancer le service avec mvn spring-boot:run -Dspring-boot.run.arguments="immediat"

Utilisation de l'application
-- 
Login
---
* connexion avec un des usagers du jeu de test (ex : juie / julie)

Les Ouvrages - Recherche et liste
---
* Insensible à la Casse 
* Fonctionne avec début de mot (ex  : chris renvoie Christophe)

Les Prêts (Par défaut 4 semaines - dans properties.yml)
---
* le bouton "update" en regard d'un prêt permet de le prolonger

