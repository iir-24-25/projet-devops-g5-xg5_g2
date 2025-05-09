## Backlog du Produit

### EPIC 1 : Gestion des Utilisateurs
- **US-001** : En tant que pharmacien, je veux m'inscrire avec email/mot de passe pour accéder au système  
  _Critères d'Acceptation_ :  
  - Endpoint POST `/api/auth/register`  
  - Validation des champs email/mot de passe  
  - Stockage sécurisé dans la base de données


### EPIC 2 : Gestion des Médicaments
- **US-002** : En tant qu'administrateur, je veux ajouter un nouveau médicament au stock  
  _Champs requis : Nom, dosage, quantité, date d'expiration_

- **US-003** : En tant que système, je veux générer une alerte pour les médicaments expirés  
  _Priorité : Moyenne_

## Planification des Sprints (2 Semaines)

### Sprint 1 : Initialisation
- [x] Configuration de l'environnement Spring Boot
- [x] Modèle de données pour les médicaments
- [ ] Mise en place CI/CD

### Sprint 2 : Développement
- [ ] Implémentation US-001 (Authentification)
- [ ] Implémentation US-002 (CRUD Médicaments)