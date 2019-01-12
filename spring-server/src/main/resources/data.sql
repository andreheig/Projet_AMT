-- Permet de remplir la table d'applications
INSERT INTO Application (appId, name, keyUUID, secretUUID, version) VALUES (1,'Vélo', '06068b82-d91a-8888-5b39-cd4adb07ae27', 'b7197d93-e3ab-f2ac-e4ac-6e3362289fdc', 0);
INSERT INTO Application (appId, name, keyUUID, secretUUID, version) VALUES (2,'stackOverflow', '4432ae66-f995-f10f-6b14-962a8429b41f', '9b4a75ec-8af2-67ff-bf85-321f4170e585', 0);
INSERT INTO Application (appId, name, keyUUID, secretUUID, version) VALUES (3,'filmovore', 'e55e4dca-461e-c80f-8a88-a994ec1c381c', '2b19184e-aca3-acf6-f6f2-0c23b37a49ba', 0);
INSERT INTO Application (appId, name, keyUUID, secretUUID, version) VALUES (4,'eleifend vitae, erat.', '601262e1-7d3d-84fd-6e82-aa243252ae81', 'be722e5f-b7a5-ced3-d8ee-b489d6b5bdaa', 0);
-- Permet de rentrer des badges:
INSERT INTO Badge (badgeId, name, version) VALUES (1, 'beginner', 0);
INSERT INTO Badge (badgeId, name, version) VALUES (2, 'medium', 0);
INSERT INTO Badge (badgeId, name, version) VALUES (3, 'expert', 0);
INSERT INTO Badge (badgeId, name, version) VALUES (4, 'beginner', 0);
INSERT INTO Badge (badgeId, name, version) VALUES (5, 'medium', 0);
INSERT INTO Badge (badgeId, name, version) VALUES (6, 'expert', 0);
-- Permet de lier les Badges à une application:
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (1, 1);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (1, 2);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (1, 3);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (3, 4);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (3, 5);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (3, 6);
-- Permet de rentrer des échelles:
INSERT INTO Scale (scaleId, max, name, version) VALUES (1, 10000, 'Kilomètres', 0);
INSERT INTO Scale (scaleId, max, name, version) VALUES (2, 10000, 'Films', 0);
-- Permet de lier les échelles à une application:
INSERT INTO Application_scales (Application_appId, scales_scaleId) VALUES (1, 1);
INSERT INTO Application_scales (Application_appId, scales_scaleId) VALUES (3, 2);
-- Permet de rentrer des règles:
INSERT INTO Rule (id, application_appId, name, type, numberOfPoint, version) VALUES (1, 1, 'test', 'ajouter un kilomètre', 1, 0);
INSERT INTO Rule (id, application_appId, name, type, numberOfPoint, version) VALUES (2, 3, 'visionnage d un film', 'ajouter un film', 1, 0);
-- Permet de lier une règle à une application:
-- INSERT INTO Application_rules (Application_appId, rules_id) VALUES (1, 1);
-- INSERT INTO Application_rules (Application_appId, rules_id) VALUES (3, 2);
-- Permet de rentrer des utilisateurs:
INSERT INTO EndUser (id, idInGamifiedApplication, name, numberOfEvents) VALUES (1, '90011445-4354-4aff-8863-d55598867884', 'Aladin', 0);
-- Permet de lier un utilisateur a des applications:
INSERT INTO Application_Users (Users_id, Application_appId) VALUES (1, 1);
INSERT INTO Application_Users (Users_id, Application_appId) VALUES (1, 2);
INSERT INTO Application_Users (Users_id, Application_appId) VALUES (1, 3);
INSERT INTO Application_Users (Users_id, Application_appId) VALUES (1, 4);