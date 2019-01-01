-- Permet de remplir la table d'applications
INSERT INTO Application (appId, name, keyUUID, secretUUID) VALUES (1,'arcu.', '06068b82-d91a-8888-5b39-cd4adb07ae27', 'b7197d93-e3ab-f2ac-e4ac-6e3362289fdc');
INSERT INTO Application (appId, name, keyUUID, secretUUID) VALUES (2,'in felis. nulla', '4432ae66-f995-f10f-6b14-962a8429b41f', '9b4a75ec-8af2-67ff-bf85-321f4170e585');
INSERT INTO Application (appId, name, keyUUID, secretUUID) VALUES (3,'ultrices sit amet', 'e55e4dca-461e-c80f-8a88-a994ec1c381c', '2b19184e-aca3-acf6-f6f2-0c23b37a49ba');
INSERT INTO Application (appId, name, keyUUID, secretUUID) VALUES (4,'eleifend vitae, erat.', '601262e1-7d3d-84fd-6e82-aa243252ae81', 'be722e5f-b7a5-ced3-d8ee-b489d6b5bdaa');
-- Permet de rentrer des badges:
INSERT INTO Badge (badgeId, application_appId, name) VALUES (1, 1, 'beginner');
INSERT INTO Badge (badgeId, application_appId, name) VALUES (2, 1, 'medium');
INSERT INTO Badge (badgeId, application_appId, name) VALUES (3, 1, 'expert');
-- Permet de lier les Badges à l'application:
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (1, 1);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (1, 2);
INSERT INTO Application_badges (Application_appId, badges_badgeId) VALUES (1, 3);