1-Réaliser l'opération de clone de ce projet
2-Ouvrir le projet avec IntelliJ
3-Ouvrir un Terminal sur la racine du projet
4-compiler le projet avec la commande: mvn clean compile
4-Lancer l'exécution du projet avec la commande suivante: mvn spring-boot:run
5-Tester l'accès aux URLs suivantes 

            http://localhost:8888/public/test   (accès public)
            http://localhost:8888/produits    (accès nécessitant l'authentification)
6-Pour s'authentifier:
       -Lancer l'outil ARC
       -Spécifier l'URL suivante avec la méthode POST:     http://localhost:8888/auth/login
       -Spécifier un header "Content-Type" avec la valeur "application/x-www-form-urlencoded"
       -Ajouter deux paramètres, dans la zone "Body":
            -username avec la valeur : admin
            -password avec la valeur : 123
       -Envoyer l'url pour recevoir le token JWT
7-Pour accèder aux ressources sécurisées (afficher la liste des produits):
       -Spécifier l'url : http://localhost:8888/produits   avec la méthode GET
       -Ajouter une header "Authorization" avec la valeur Bearer <votre_token_jwt>
       -Lancer l'url pour afficher la liste des produits
8-Tester le fonctionnement des autres opérations offertes par l'API (ajouter,supprimer,modifier)
9-Refaire la même chose avec un autre utilisateur:  (username=user, password=123)
10-Interpréter le résultat

