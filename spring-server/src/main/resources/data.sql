-- Permet de remplir la table d'applications
INSERT INTO Application (id, name, keyUUID, secretUUID, optlock) VALUES (1,'FPS', '06068b82-d91a-8888-5b39-cd4adb07ae27', 'b7197d93-e3ab-f2ac-e4ac-6e3362289fdc', 0);
/*INSERT INTO Application (id, name, keyUUID, secretUUID VALUES (2,'stackOverflow', '4432ae66-f995-f10f-6b14-962a8429b41f', '9b4a75ec-8af2-67ff-bf85-321f4170e585');
INSERT INTO Application (id, name, keyUUID, secretUUID VALUES (3,'filmovore', 'e55e4dca-461e-c80f-8a88-a994ec1c381c', '2b19184e-aca3-acf6-f6f2-0c23b37a49ba');
INSERT INTO Application (id, name, keyUUID, secretUUID VALUES (4,'eleifend vitae, erat.', '601262e1-7d3d-84fd-6e82-aa243252ae81', 'be722e5f-b7a5-ced3-d8ee-b489d6b5bdaa');*/
-- Permet de rentrer des utilisateurs:
INSERT INTO EndUser (id, idInGamifiedApplication, app_id, name, numberOfEvents, optlock) VALUES (1, '90011445-4354-4aff-8863-d55598867884', 1, 'Aladin', 0, 0);
-- Permet de rentrer des badges:
INSERT INTO Badge (id, app_id, name, optlock) VALUES (1, 1, 'beginner', 0);
-- Permet de rentrer des échelles:
INSERT INTO Scale (id, app_id, max, name, optlock) VALUES (1, 1, 10000, 'Killpoints', 0);
-- Point rules: what event awards how many point
INSERT INTO PointRule (id, app_id, name, scale_id, eventtype, defaultNbPoints, optlock) VALUES (1, 1, 'Killing rule', 1, 'kill',100, 0);
-- Threshold rule: with how many points a badge is won
INSERT INTO BadgeThresholdRule (id, app_id, name, scale_id, badge_id, threshold, optlock) VALUES (1, 1, 'Beginner killer rule', 1, 1, 200, 0);

