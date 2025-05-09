# Spécifications Techniques - Gestion de Stock Pharmaceutique

## Fonctionnalités Principales
- **Authentification Sécurisée**  
  Inscription/connexion avec JWT pour les utilisateurs (pharmaciens, administrateurs)
- **Gestion des Médicaments**  
  CRUD pour les médicaments (nom, dosage, quantité en stock, date d'expiration)
- **Suivi des Mouvements de Stock**  
  Historique des entrées/sorties avec type de mouvement (approvisionnement, vente, etc.)
- **Système d'Alerte**  
  Notifications pour médicaments périmés ou stock critique

## Architecture Technique
![Diagramme d'Architecture](https://via.placeholder.com/800x400?text=Spring+Boot+API+%2B+MySQL+%2B+Docker+%2B+GitHub+Actions)

## Stack Technologique
| Composant               | Technologie                          |
|-------------------------|--------------------------------------|
| Backend                 | Spring Boot 3.4.4 (Java 17)          |
| Base de Données         | MySQL 8.0                            |
| Sécurité                | Spring Security + JWT                |
| CI/CD                   | GitHub Actions                       |
| Conteneurisation        | Docker                               |
| Orchestration           | Kubernetes                           |