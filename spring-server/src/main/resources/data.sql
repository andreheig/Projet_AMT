-- Permet de remplir la table d'applications
INSERT INTO Application (appId, name, keyUUID, secretUUID) VALUES (1,'Vélo', '06068b82-d91a-8888-5b39-cd4adb07ae27', 'b7197d93-e3ab-f2ac-e4ac-6e3362289fdc');
INSERT INTO Application (appId, name, keyUUID, secretUUID) VALUES (2,'stackOverflow', '4432ae66-f995-f10f-6b14-962a8429b41f', '9b4a75ec-8af2-67ff-bf85-321f4170e585');
INSERT INTO Application (appId, name, keyUUID, secretUUID) VALUES (3,'filmovore', 'e55e4dca-461e-c80f-8a88-a994ec1c381c', '2b19184e-aca3-acf6-f6f2-0c23b37a49ba');
INSERT INTO Application (appId, name, keyUUID, secretUUID) VALUES (4,'eleifend vitae, erat.', '601262e1-7d3d-84fd-6e82-aa243252ae81', 'be722e5f-b7a5-ced3-d8ee-b489d6b5bdaa');
-- Permet de rentrer des badges:
INSERT INTO Badge (badgeId, application_appId, name) VALUES (1, 1, 'beginner');
INSERT INTO Badge (badgeId, application_appId, name) VALUES (2, 1, 'medium');
INSERT INTO Badge (badgeId, application_appId, name) VALUES (3, 1, 'expert');
INSERT INTO Badge (badgeId, application_appId, name) VALUES (4, 3, 'beginner');
INSERT INTO Badge (badgeId, application_appId, name) VALUES (5, 3, 'medium');
INSERT INTO Badge (badgeId, application_appId, name) VALUES (6, 3, 'expert');
-- Permet de lier les Badges à une application:
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (1, 1);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (1, 2);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (1, 3);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (3, 4);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (3, 5);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (3, 6);
-- Permet de rentrer des échelles:
INSERT INTO Scale (scaleId, application_appId, max, name) VALUES (1, 1, 10000, 'Kilomètres');
INSERT INTO Scale (scaleId, application_appId, max, name) VALUES (2, 3, 10000, 'Films');
-- Permet de lier les échelles à une application:
INSERT INTO Application_scales (Application_appId, scales_scaleId) VALUES (1, 1);
INSERT INTO Application_scales (Application_appId, scales_scaleId) VALUES (3, 2);
-- Permet de rentrer des règles:
INSERT INTO Rule (id, application_appId, name, type) VALUES (1, 1, 'test', 'ajouter un kilomètre');
INSERT INTO Rule (id, application_appId, name, type) VALUES (2, 3, 'visionnage d un film', 'ajouter un film');
-- Permet de lier une règle à une application:
INSERT INTO Application_rules (Application_appId, rules_id) VALUES (1, 1);
INSERT INTO Application_rules (Application_appId, rules_id) VALUES (3, 2);
-- Permet de rentrer des utilisateurs:
INSERT INTO EndUser (id, idInGamifiedApplication, name, numberOfEvents) VALUES (1, '90011445-4354-4aff-8863-d55598867884', 'Aladin', 0);
-- Permet de lier un utilisateur a des applications:
INSERT INTO Application_Users (Users_id, Application_appId) VALUES (1, 1);
INSERT INTO Application_Users (Users_id, Application_appId) VALUES (1, 2);
INSERT INTO Application_Users (Users_id, Application_appId) VALUES (1, 3);
INSERT INTO Application_Users (Users_id, Application_appId) VALUES (1, 4);