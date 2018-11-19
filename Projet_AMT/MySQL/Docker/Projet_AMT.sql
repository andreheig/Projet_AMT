-- phpMyAdmin SQL Dump
-- version 4.7.8
-- https://www.phpmyadmin.net/
--
-- Client :  localhost
-- Généré le :  Sam 17 Novembre 2018 à 19:41
-- Version du serveur :  10.3.7-MariaDB
-- Version de PHP :  5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `Projet_AMT`
--
DROP DATABASE IF EXISTS `Projet_AMT`;
CREATE DATABASE IF NOT EXISTS `Projet_AMT` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `Projet_AMT`;

-- --------------------------------------------------------

--
-- Structure de la table `Application`
--

CREATE TABLE `Application` (
  `appId` int(11) NOT NULL,
  `appName` varchar(60) NOT NULL,
  `appDescription` varchar(300) NOT NULL,
  `appKey` char(36) NOT NULL,
  `appSecret` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Application`
--

INSERT INTO `Application` (`appId`, `appName`, `appDescription`, `appKey`, `appSecret`) VALUES
(1, 'arcu.', 'dapibus quam quis diam.', '06068b82-d91a-8888-5b39-cd4adb07ae27', 'b7197d93-e3ab-f2ac-e4ac-6e3362289fdc'),
(2, 'in felis. nulla', 'fusce mi lorem, vehicula et, rutrum eu, ultrices sit', '4432ae66-f995-f10f-6b14-962a8429b41f', '9b4a75ec-8af2-67ff-bf85-321f4170e585'),
(3, 'ultrices sit amet,', 'tempor erat neque non quam. pellentesque', 'e55e4dca-461e-c80f-8a88-a994ec1c381c', '2b19184e-aca3-acf6-f6f2-0c23b37a49ba'),
(4, 'eleifend vitae, erat.', 'sed turpis nec mauris blandit mattis. cras eget nisi dictum', '601262e1-7d3d-84fd-6e82-aa243252ae81', 'be722e5f-b7a5-ced3-d8ee-b489d6b5bdaa'),
(5, 'non, vestibulum', 'nunc. in at pede. cras vulputate velit eu', '69645456-635e-5697-7d24-0e57460cfa9a', 'c7b857e6-e9a6-cd9b-19c8-553f87901fee'),
(6, 'posuere vulputate,', 'non, bibendum sed, est. nunc laoreet lectus quis', 'dd20318c-96c6-8035-5fa8-cfc551b9652f', '3e6863d7-0306-9de5-95f1-14c8b3ec8084'),
(7, 'eu metus.', 'quis accumsan convallis, ante', '40d78bfa-9837-3073-3757-53c9c2f894a9', 'ac4371d0-6953-babb-45d5-37799bd4e1a9'),
(8, 'fermentum convallis', 'nulla ante, iaculis nec, eleifend non, dapibus rutrum, justo. praesent', '53c70312-39af-eeb5-a7ed-1d58a665b701', '9908c688-bbcf-404c-6a58-84182ac92499'),
(9, 'dapibus', 'mollis non, cursus non, egestas a, dui. cras', 'd281b54d-bf8c-b72f-f220-921c02579a3b', 'bf06022e-a98c-829f-248d-192031542359'),
(10, 'ut aliquam', 'dolor. quisque tincidunt pede ac urna. ut tincidunt vehicula risus.', '1d039995-0e23-727f-8bf0-fa091f645a6a', '06e847b2-7950-8735-9e6d-0d4ea0ea63eb'),
(11, 'malesuada augue', 'diam vel arcu. curabitur ut odio vel est tempor', '9ddda2e0-aeb0-b65e-d8ee-34c94f7da825', '76307f83-098a-e9fa-561f-0b6441ea8d1a'),
(12, 'nascetur ridiculus', 'arcu. aliquam ultrices iaculis odio. nam interdum', 'fb90e04d-c718-0246-0a02-2221e519918f', '25b7a16d-524a-6512-a923-ec65bdc5942f'),
(13, 'bibendum fermentum metus.', 'arcu. aliquam ultrices iaculis', '6c75be41-624c-57b5-a922-7f4792c708d8', 'b3fa01c8-c015-7996-cd62-7b00a69a50b4'),
(14, 'consectetuer', 'parturient montes, nascetur ridiculus mus.', 'f436f798-9c84-bf37-ff5d-b196844a0cc2', '2b0a9a97-c171-1021-68f7-ad0ab3742b67'),
(15, 'metus. aenean', 'curabitur sed tortor. integer aliquam adipiscing lacus.', '69ae2558-acbc-9e51-df7e-6fd14517c1ef', '1fed6d98-2007-c33d-997e-be71aabe5b5a'),
(16, 'amet', 'augue porttitor interdum. sed auctor', '3ab1051e-8d66-c79c-a472-2f49cb55498b', '3597866d-baa2-d191-2c37-9c525fbcb447'),
(17, 'sociosqu ad', 'euismod in, dolor. fusce feugiat. lorem ipsum', '7402b1f5-5a14-f944-cdcc-8fc8084e68db', '2660d8ba-4281-5f8d-715f-b3c902dbb690'),
(18, 'nulla. integer urna.', 'sollicitudin a, malesuada id, erat. etiam', '1439542d-7548-22e7-0e6c-691ca499706d', '439170c1-0559-677f-307c-8aa3a57b50c7'),
(19, 'non nisi. aenean', 'curae; donec tincidunt. donec vitae erat', '6103aebe-7040-f5ae-d60b-85c52b5322ba', 'd3f76143-9b74-0c6e-c3c2-cd377a761012'),
(20, 'nibh. donec est', 'eu nibh vulputate mauris sagittis', '1d7e7907-461b-08bc-cdd7-a567d6eeaf63', 'b4584d3f-2419-ab71-3368-f495cf862469'),
(21, 'nunc.', 'in magna. phasellus dolor elit, pellentesque', 'ea1d6ca8-6827-6eaf-859c-db565b2d9a26', '15fe8c84-544f-7b0e-d62b-85fb5b133e78'),
(22, 'sed orci', 'massa non ante bibendum ullamcorper. duis cursus, diam', '9dfaf6ad-2634-0082-f0eb-d4075d36ce47', 'a41f8dfe-7b33-f33f-c64f-08967bad83b3'),
(23, 'nostra, per', 'nec ante blandit viverra. donec tempus, lorem fringilla', '31ae370a-0030-1e81-8069-14ec16c56008', 'a7e2b1b6-cb2d-1e6b-4ae2-6ac8ac38a46f'),
(24, 'eu', 'integer vulputate, risus a ultricies adipiscing,', 'b8075626-f059-f704-8a6a-76e86c7c05ae', 'c68fe2a8-1d31-2d58-a8b4-8f7ecdb76a64'),
(25, 'orci, consectetuer euismod', 'semper et, lacinia vitae,', 'fa72d278-4d0b-23ad-f00e-146219b11e55', '196d45f4-b112-4c8e-5f7d-b75eb53f878d'),
(26, 'neque sed', 'arcu. vestibulum ante ipsum primis in faucibus orci luctus', '40fa56fe-270e-7991-2d1d-daddd0acaee6', 'bd4562d6-c3fc-e602-6cc1-0d15d375877d'),
(27, 'adipiscing fringilla,', 'aliquam, enim nec tempus scelerisque, lorem', 'f89c660c-9716-a41c-89d9-32927cd53b8a', '71db84d3-6d2a-abef-81af-d31a50548e31'),
(28, 'tincidunt nibh. phasellus', 'sem, consequat nec, mollis vitae,', '4a37105f-1953-0ded-9e9c-166e8791cc61', '9ed751d1-4374-7904-8a6c-92872b054c42'),
(29, 'vestibulum ut', 'pede nec ante blandit viverra. donec', '0c69de0d-8a38-23c2-047c-b5411f3beeef', 'e707e51f-1722-9ce9-174a-fec0ad5d4f15'),
(30, 'augue', 'blandit viverra. donec tempus, lorem fringilla ornare placerat, orci lacus', '5b2a5f9f-9b35-b1f6-eba0-e6d61b259b55', '768b5571-b15a-5578-c142-ac388a2bbf83'),
(31, 'mauris sit amet', 'tellus, imperdiet non, vestibulum nec, euismod in, dolor. fusce feugiat.', 'c64e6cf4-9f7e-f65b-5582-c780431de2b7', 'c765241f-2e19-a80e-645b-013afa91faf1'),
(32, 'pede.', 'libero. morbi accumsan laoreet ipsum.', '43904b1e-a315-1f44-6fd6-85ced038ce20', '7b9ce7a0-4626-cbb1-ff6d-b966b2dd136d'),
(33, 'vulputate dui,', 'consectetuer mauris id sapien. cras dolor dolor, tempus', '008235e7-6d44-0e39-0655-a488cb879f6b', 'd7797685-972d-48ca-a5aa-f9ce4100a6c4'),
(34, 'est ac', 'nam interdum enim non nisi. aenean eget metus. in nec', 'bfb9e935-eb4a-8c61-c53e-cb12c227ce1e', '2319081e-cff2-c481-babe-c725d6045ecc'),
(35, 'dolor sit', 'semper erat, in consectetuer ipsum nunc', '09d132ae-15a7-105c-9bf7-04758e223583', '637c26cd-27ae-1e56-f615-a2be20b4d880'),
(36, 'duis', 'natoque penatibus et magnis dis parturient montes,', '141006e4-20c9-4718-167c-202f0ff9902b', '125c1eb8-9723-0096-900e-f2673da60855'),
(37, 'velit justo', 'pede. cras vulputate velit eu sem. pellentesque ut ipsum ac', 'c7a76718-a243-9976-c7eb-2b1575bf6a31', '6efaebc4-4fec-94f0-3a6e-7ffae9b076ec'),
(38, 'duis mi', 'penatibus et magnis dis', '82a3fed3-b403-e7d7-99bb-26414d347735', 'edd622f1-2ba6-e315-e227-e8cca8854cdc'),
(39, 'mauris erat eget', 'auctor ullamcorper, nisl arcu iaculis enim,', 'd1ce0828-4f08-9849-1c58-f98dadba9f3b', '2b7230be-cdd8-c795-d78f-6ff02056a78f'),
(40, 'pharetra.', 'maecenas libero est, congue a, aliquet vel,', '5142f222-3fd8-9037-1319-6121abf2af32', '5a3c7a82-1d32-14d4-caa2-8686bc476254'),
(41, 'vitae', 'mi enim, condimentum eget,', 'd38b1258-ed9d-2fbe-fd7b-dfe3a6bf9da2', 'c9344984-d524-7c2e-02b8-f8b991fe04c2'),
(42, 'massa.', 'dolor, tempus non, lacinia at, iaculis quis, pede.', '22ae6db4-844b-59c8-0178-754517c32cd2', 'ed6ddedf-4878-b5d3-5413-3d726fbd3916'),
(43, 'amet massa.', 'cras vehicula aliquet libero. integer in magna. phasellus dolor', 'f629dd0f-10f8-0ff0-3809-938e1f59909b', '5b9c4162-333c-fb52-23a3-ea331644a282'),
(44, 'at arcu.', 'per inceptos hymenaeos. mauris ut quam vel', '59bc114a-afe2-9d9e-9bbf-9a5024ab74be', 'f5d37606-aee4-f2a8-c056-c8403056da85'),
(45, 'ac orci.', 'aliquam eros turpis non enim. mauris quis turpis vitae', 'e6d4b7f1-fd05-871f-2791-8f3da9beecd1', '9926e355-fe9d-825f-40b9-ac141cb59f4a'),
(46, 'massa. mauris vestibulum,', 'dui nec urna suscipit nonummy. fusce fermentum fermentum arcu. vestibulum', '3338d9ad-4c2c-b282-458d-4f2509b7f2e9', 'b73757b7-5ea9-e60c-44b0-fe3743765a2c'),
(47, 'erat. sed', 'vulputate eu, odio. phasellus at augue', 'daa89af4-18fe-ba02-efe9-a5f8e7037566', '410af318-7589-6370-b299-00af17e870ae'),
(48, 'augue', 'sed id risus quis', '879f95bd-0be1-5e03-48b5-7e1f1a87d690', '120f02ba-1609-a620-03ad-90c1b2d9867b'),
(49, 'vitae, orci.', 'phasellus dolor elit, pellentesque a,', '8c01e003-89aa-4d85-30f0-3ff70fb3aa5c', '8613961d-2612-6ca8-1180-b8afceabb0fc'),
(50, 'vehicula risus.', 'vulputate, lacus. cras interdum.', '6f876884-962f-65e7-620a-085dc4809599', '4cfc8081-3b13-9780-1f41-e29c1ea71109'),
(51, 'placerat,', 'enim mi tempor lorem, eget mollis lectus pede et risus.', '27e29a0f-cfd1-1454-28a4-f1c376e65a45', '0c1a0f41-a6ba-ed26-0e31-89210a3640be'),
(52, 'adipiscing', 'elit erat vitae risus. duis', 'c892b7e6-3f9a-c6f0-3f84-4f24cc36f8fb', '986fb177-ad09-36b3-4f5d-cda48575d1ff'),
(53, 'varius. nam porttitor', 'eros. proin ultrices. duis volutpat nunc', '1605f6ad-83c0-ee09-b4bf-b543ac2787e2', '0598c3fb-0298-c91a-941f-60be03ce1cde'),
(54, 'sed', 'augue malesuada malesuada. integer id magna et ipsum cursus vestibulum.', 'a5f63c5c-85a9-8d59-5871-2b32b0c445b3', '818698a9-ae40-dc90-4247-03af45102772'),
(55, 'velit eu', 'suspendisse aliquet, sem ut cursus luctus, ipsum', 'ec183230-fea2-2ab9-c475-8d663b10ed1a', '3fd92112-618e-265b-09cc-37c87065620c'),
(56, 'non, luctus', 'neque sed sem egestas blandit. nam', '5cf2de44-2b45-1f86-9e21-2b84563bd36f', 'daee0895-99ca-9150-7369-a57f4ad8c83e'),
(57, 'facilisis lorem tristique', 'a mi fringilla mi lacinia mattis. integer eu lacus. quisque', '48645cbb-7fef-33d1-443e-5317131a73fd', '9bbd39e9-c320-d3f0-9ee0-6e13ce86d32c'),
(58, 'sodales', 'imperdiet non, vestibulum nec, euismod', '81d03920-d392-5e14-4837-6ee34a036ff6', 'bb6a639b-6709-5edc-9bee-0c9208778e37'),
(59, 'habitant', 'amet, consectetuer adipiscing elit. curabitur sed', '8ed3bb95-649e-e8d5-ad4e-60fa12b6e073', '76d0b2b1-47f9-4a38-b600-8e2522deb76c'),
(60, 'mus.', 'euismod in, dolor. fusce feugiat. lorem ipsum dolor', '624b3a5e-72ab-9865-57f7-68b2fac2874c', 'a4896397-5d88-752f-e0db-9431ba268308'),
(61, 'aliquam erat volutpat.', 'dui, in sodales elit erat vitae risus. duis a', '6a6d02e4-5431-e158-de0f-2b86f3665866', '6c679044-0067-397c-2835-ced25eb67df8'),
(62, 'a mi fringilla', 'metus. vivamus euismod urna. nullam', '99988f92-31bd-e110-2ec6-fd6d76d5662a', '977a8a80-bdb0-24b9-3df0-af7dfd016864'),
(63, 'accumsan sed, facilisis', 'rutrum lorem ac risus. morbi', 'a36878d0-32ce-9bea-3991-9065b43072a3', '9036f569-ee07-f67e-12f9-8c37ef401731'),
(64, 'sed tortor.', 'id, libero. donec consectetuer', 'c45bf481-1ea8-03f4-dff9-69001e6a7ba0', 'eb428150-9372-e3f9-979e-e9de880d3a0d'),
(65, 'vitae', 'suspendisse eleifend. cras sed leo.', '57ded7f7-bc9b-ad5c-9651-c0e90d2b578d', '0751fe48-9e98-205b-be09-f6783e0ab09f'),
(66, 'velit. aliquam nisl.', 'orci, consectetuer euismod est arcu ac orci. ut semper pretium', 'dd830eb7-8d10-fa9d-5b15-c1a5aa80fe03', 'a1c6dce3-1626-e441-2211-89827b19ec45'),
(67, 'orci.', 'cursus et, magna. praesent interdum ligula eu enim.', '644fdf43-61f7-a3eb-91b7-234fa5df4890', '3356fdbd-cba5-445a-6191-18441c05f083'),
(68, 'cursus vestibulum.', 'risus varius orci, in consequat enim diam vel arcu. curabitur', 'bf20e60e-490b-63b4-9cd0-e990fc6832c4', 'c9ba3921-cf08-e96e-0cfe-6d0958552f2a'),
(69, 'risus varius orci,', 'tellus. aenean egestas hendrerit', 'ee35a9c4-c022-c4b9-2f8b-5d7f48e9ba32', 'dc89c12a-6045-17c9-4033-71b5587740dc'),
(70, 'eu, accumsan sed,', 'duis cursus, diam at pretium aliquet, metus', '84d7b902-e225-eb31-e31d-9c864a205107', '486c0c01-ee05-3d81-5060-273c2b52c84a'),
(71, 'elementum purus,', 'est, mollis non, cursus non, egestas a, dui.', '9bf12484-c663-a00e-acd5-1c6ab691dfce', 'b69fa866-281b-ea9d-a0bb-10e1754fa617'),
(72, 'vivamus', 'euismod urna. nullam lobortis', '28f4c70d-00f7-ffa4-145d-f03dbe91e04d', 'd42ae5d5-2c34-7016-7e47-8bfff1ac5019'),
(73, 'adipiscing non,', 'placerat velit. quisque varius.', '6d3bb622-9e60-906b-8b43-bcaf85225920', 'f0fcd054-982e-7906-835d-3992543de576'),
(74, 'nonummy ut,', 'sem, vitae aliquam eros turpis non enim. mauris quis', 'de4af22d-3abc-3459-10cd-490b91fc89ca', '7888f5d2-2192-c16a-8c3b-ed0567828789'),
(75, 'massa. vestibulum accumsan', 'lacus pede sagittis augue, eu tempor erat', '8a7317dd-a478-26ee-5944-3b4fa532f55b', '00100770-d723-abde-fedc-3a02da47d933'),
(76, 'eu turpis. nulla', 'in at pede. cras', '4ada0477-0372-167c-5d6c-bea7a8b0dadf', '57e3e2f2-87d0-873d-eb35-996d88f47882'),
(77, 'bibendum sed, est.', 'metus. in nec orci. donec', '047b6e55-96f2-41ad-d324-05e1dfeabc97', '38af216c-e401-63cd-7919-6ca772594c14'),
(78, 'aliquam, enim', 'cursus vestibulum. mauris magna. duis dignissim tempor arcu. vestibulum', 'e14ed2a3-80ca-1a14-11b9-6c07519f5b4c', '58fd7696-4563-5c5b-f70f-389deb3e4e27'),
(79, 'amet nulla. donec', 'justo. proin non massa non ante', 'a6498366-dec4-ad95-655f-4880d33e05ce', '8b4198df-e9aa-7ec9-5b66-fcd8455cf7c7'),
(80, 'mi, ac', 'lorem ipsum dolor sit amet, consectetuer', '12442182-32f9-c7d3-b5a2-6484d8075eb6', '51fadfe7-8751-1647-b9b5-61d4b7f1b6ca'),
(81, 'blandit at,', 'arcu imperdiet ullamcorper. duis at lacus. quisque', '3a4d3bb7-038d-7b62-da6a-6af48200f251', 'aec6facf-9bcc-6bcd-96f1-1daa8f522b41'),
(82, 'faucibus leo, in', 'etiam gravida molestie arcu. sed eu nibh vulputate', 'b7682d0c-51a2-3751-806e-17d493b0d06e', '1eedd8e8-7b28-d240-ec19-92831fb7683e'),
(83, 'eu, placerat eget,', 'tempus non, lacinia at, iaculis quis, pede. praesent eu', 'bdd484f9-60e5-9702-6542-4fb54174e917', '38e32fcd-f73f-541a-c2fa-21daefd012a6'),
(84, 'semper et,', 'interdum feugiat. sed nec metus', 'd5ba1b5b-5602-dfce-763d-60c8cb556adc', '415a71ac-4e8a-fec0-8054-7355a21d62a4'),
(85, 'vel turpis. aliquam', 'vitae, erat. vivamus nisi. mauris nulla. integer urna. vivamus', 'c884a469-572e-bbe7-d67d-14bcde3d7b77', 'a0ec279a-fa66-1f23-eae1-44e9e8bb2c09'),
(86, 'enim mi tempor', 'dolor dolor, tempus non, lacinia at, iaculis quis, pede. praesent', 'e17985ca-23d6-485c-c3fa-5dc20f4a975b', '4e1314ff-39ef-39c8-93ff-806fd18ed106'),
(87, 'purus gravida sagittis.', 'in consequat enim diam vel arcu. curabitur ut', '1bd58215-1ae9-4d20-cc01-0e87b0641148', '0aff2e9c-366a-8431-27a8-0771c660f5cd'),
(88, 'erat vel', 'parturient montes, nascetur ridiculus mus. aenean', '6c4155c3-93cc-3c90-133e-5ea8132785ea', '1a4fb957-956d-6e4d-bf45-be0b3c154fbe'),
(89, 'primis in faucibus', 'massa. vestibulum accumsan neque et nunc.', 'f58df3a0-e362-3485-6af9-8424df6e3bb4', '810d2843-3e58-4150-5410-453485cd7945'),
(90, 'nec ante', 'fusce diam nunc, ullamcorper eu, euismod ac,', 'c4b8bd68-c633-babc-c4a4-6e6bbe7cbb8f', '6231b445-34bb-0b31-2b0f-c21faf475409'),
(91, 'sed', 'dui nec urna suscipit nonummy. fusce fermentum fermentum', '6212ff37-6772-633a-d153-d8516b3ae013', '84877a54-9702-b2fa-0fe3-e2316a8b00eb'),
(92, 'vel, vulputate', 'augue malesuada malesuada. integer id magna et', '642d4427-4497-00ad-ae9a-b99a1e93cdf7', '10fcc44b-dc43-3460-cc5e-4bab1f94782e'),
(93, 'curabitur', 'lorem vitae odio sagittis semper. nam tempor diam', 'e5ae7907-e24c-9a03-908e-429d12a729ba', '404dae59-543c-d931-957b-3d8d90081a7f'),
(94, 'a', 'ac risus. morbi metus. vivamus euismod urna. nullam', '2207ed23-5bec-db30-02ee-4ff29032c2f4', '0a25bee5-60ca-9b47-bff4-de30b4b18bfe'),
(95, 'tempus risus.', 'iaculis quis, pede. praesent', 'c1ac068c-9596-0b48-d53a-31339e55a616', 'ee789bd1-a6c0-dde7-fc2d-0ca14449c4af'),
(96, 'pellentesque massa', 'curabitur massa. vestibulum accumsan neque et', '10aab5d6-382e-78ae-cfba-5497b1ecfa32', 'b54cc4c8-eb86-8cbe-75f2-6137038934bb'),
(97, 'interdum libero', 'egestas, urna justo faucibus lectus, a sollicitudin orci sem', '22b0edc6-8cb8-4ac2-0377-3ef753f91ac8', '5bf767a0-74aa-099c-b76a-abb7b88025c4'),
(98, 'dolor.', 'non, hendrerit id, ante.', 'c827d384-d9ab-44aa-8326-4b99efcbd5a7', '840004d4-5eda-2be3-7f73-b6239d4b93bb'),
(99, 'egestas nunc sed', 'vestibulum nec, euismod in, dolor. fusce feugiat. lorem ipsum dolor', '3d13521e-44c1-3fbb-509a-b3a1d32d2a9f', '096c491b-5f5a-3e28-5cb6-e35ad6783850'),
(100, 'vitae, erat.', 'sit amet diam eu dolor egestas rhoncus. proin', '3c3a4164-ae7d-7cfa-975f-31b8f1a4d37c', '2cd9c051-2d75-bb76-175f-79d928e6aa24'),
(101, 'est', 'ipsum. curabitur consequat, lectus sit amet luctus vulputate,', 'a4c1b3de-c4df-38fa-e1a3-afab1f1f4fa4', '9ce0b547-d8cf-66e4-5956-c575a1abd6ff'),
(102, 'turpis vitae purus', 'adipiscing non, luctus sit amet,', '44c11445-51ac-f97c-bbb9-d8310a9df723', '5653292a-96c9-d538-e780-9af5ead28be0'),
(103, 'etiam', 'porttitor tellus non magna. nam ligula elit, pretium', '6287db06-4e73-39aa-d673-a816055788d6', '51f48656-2cf6-895f-74c7-a06e4e53eede'),
(104, 'libero. donec consectetuer', 'risus. quisque libero lacus, varius', 'ee497513-c451-2917-070c-11671268c347', 'e43014af-b0ee-b8c8-99a4-bc9121c68947'),
(105, 'at, nisi.', 'quam. curabitur vel lectus. cum sociis natoque penatibus et', 'f9ebe198-e937-0e24-790c-608665f78fe1', '653abfbf-5369-907e-f42b-4b624e58813e'),
(106, 'urna convallis', 'tristique pellentesque, tellus sem mollis dui,', '8fca8825-0845-f668-e9d3-5761cbdd5ecc', 'd565fbb3-37d8-7d8b-101a-df2304125f96'),
(108, 'euismod est', 'enim. sed nulla ante, iaculis nec, eleifend non,', 'cd6067a3-f413-2590-81b0-493c02c26d09', 'e2719d90-18a9-9099-b33e-7b3afda064e5'),
(109, 'dis', 'nisl. quisque fringilla euismod enim. etiam gravida', 'd7156d67-c0e0-98a6-eda2-119fe0a2295b', 'dce5ab7c-0c12-b7e4-088c-b40815470fb2'),
(110, 'amet', 'dictum augue malesuada malesuada. integer', 'b516f1db-b94e-c5f0-6833-a728c9b169e2', '19519658-4d21-3181-1a72-caf972fe7a33'),
(111, 'odio vel est', 'cubilia curae; phasellus ornare. fusce mollis. duis sit amet', '1156aaa6-afe6-0bce-17ba-cbb78c273c90', '46527542-6449-925e-d806-73934c4e93a0'),
(112, 'dictum mi, ac', 'eu sem. pellentesque ut ipsum ac mi', 'dc253d96-e786-eb2a-0fcd-c97ab61a8c9f', '0c622ce8-64c6-46d6-df34-611e34f0a985'),
(113, 'proin velit.', 'euismod urna. nullam lobortis quam a felis ullamcorper viverra. maecenas', 'a8321e6c-1b08-a964-387d-cd71428feb74', 'ad14d123-1b0b-18c8-ac7e-25c3683bb2e9'),
(114, 'odio.', 'morbi vehicula. pellentesque tincidunt tempus risus. donec egestas.', '8bf0fcd9-9b17-846c-4e75-36958c110b2c', '18e3124b-c98a-3ffa-52c7-967f39a2bc70'),
(115, 'duis dignissim tempor', 'consectetuer mauris id sapien. cras dolor dolor, tempus non,', '4bf53b5d-7a5f-ea1f-544b-5f921017ac3b', 'e360f98b-7d08-638a-89fc-82310168a4f6'),
(116, 'at, egestas', 'leo. morbi neque tellus, imperdiet non, vestibulum nec,', '4424df07-43f4-579f-f247-cc85e4f114e8', 'e50a8111-4c3f-74dd-ffb3-a8b3d72fb911'),
(117, 'dignissim.', 'massa. suspendisse eleifend. cras', 'a9311088-f0cb-97b7-8ec2-a1c5cffebb6c', 'ad3036c3-43cf-a253-a989-4b3ae4bdf3ea'),
(118, 'pharetra nibh. aliquam', 'mi eleifend egestas. sed pharetra, felis', 'f7ed59d8-4df8-94c7-0244-7651c1a55eaf', '68ea279a-2d84-b12a-f68a-ca0ccbd9d1f3'),
(119, 'nunc mauris sapien,', 'ultrices iaculis odio. nam interdum enim non nisi.', '280a8128-0a5e-7e89-5080-32636241d901', 'cd4f29dd-7c14-dbbd-728c-982debd5cde1'),
(120, 'ut, sem. nulla', 'pellentesque habitant morbi tristique senectus et netus et malesuada fames', 'fd35b254-f467-cd4a-562c-6ab929b51643', 'cb028248-c435-2531-0b89-59fbd33682d2'),
(121, 'quam vel', 'nam consequat dolor vitae dolor. donec fringilla.', '343a5080-5ab1-42a6-b16c-a465ee7780c6', '6596ef6e-e9bd-631b-13be-bc80fd11044e'),
(122, 'aenean', 'lobortis quam a felis ullamcorper viverra. maecenas iaculis aliquet diam.', '6f81af1c-cebd-8dcf-a378-f54a8ddc43fb', 'c871c8a1-5b04-c72c-f7ba-50bd14d6f761'),
(123, 'consectetuer', 'gravida non, sollicitudin a, malesuada id, erat.', '6f4f7018-e266-4c58-d564-25153d153650', '6df43965-642c-ac9a-83f5-052e4b2fd973'),
(124, 'commodo at,', 'interdum. curabitur dictum. phasellus in felis. nulla', '0bda17b3-411e-fffc-1e67-d9711f641a68', '4399aca6-84cf-a15d-cd7e-8dc18daa1692'),
(125, 'porttitor scelerisque neque.', 'interdum. sed auctor odio', 'c1d90df6-e36f-c0e3-630a-d79dc424b61f', '25104c70-1440-77e9-9656-44f94796914f'),
(126, 'accumsan convallis, ante', 'orci. phasellus dapibus quam quis diam. pellentesque habitant morbi', 'aa76b908-00dd-1924-df81-0b4dd1144d62', 'eae94bc4-080c-848d-5d79-65c9bf8088aa'),
(127, 'vel,', 'velit in aliquet lobortis,', '1576fa05-e87b-d88e-669a-880664376ecd', '8247c81a-3247-2c51-e184-0bed14c4572d'),
(128, 'nibh vulputate mauris', 'ac mi eleifend egestas. sed pharetra, felis eget', '803db835-e3a4-5f2e-69b0-5f760a89bea9', '4e32718d-5df8-78de-b3dc-0f3b4d1de1ff'),
(129, 'nulla', 'velit. aliquam nisl. nulla eu', '0a680f68-16e3-d5f2-151d-ece3bb98e533', 'd71adf06-adf3-1d19-d0b3-e62a1762fa68'),
(130, 'auctor', 'tempus risus. donec egestas. duis', 'd79d9c0e-f6ed-1ad0-f50c-80c85c3ef921', '1a2fb3c7-7da5-73f2-91f3-baede489f6f0'),
(131, 'nisi sem semper', 'diam nunc, ullamcorper eu, euismod ac,', 'a164678e-4d31-1172-03d0-ed1fddee8fd0', '33f625f7-7512-2603-31f0-9832e11f5596'),
(132, 'purus ac', 'fames ac turpis egestas. aliquam fringilla cursus', '0ea79af1-aefc-6a34-35d1-2e077efb861d', 'e6c17aff-8726-f3c3-040a-9eb5c0fb34be'),
(133, 'eget metus eu', 'magna. phasellus dolor elit, pellentesque', '03c7e43e-f136-6070-c20a-4f8bc40a8a97', '72ffdb9b-97ea-a004-61e9-686c6ff55ca6'),
(134, 'consectetuer', 'curabitur dictum. phasellus in felis. nulla tempor augue ac', '5de9a103-381c-89a0-03c2-d2e28cdc00a4', 'e8e8178a-dc6b-d90d-9b4c-6e73ffce3610'),
(135, 'vulputate, posuere', 'lacus. mauris non dui nec', '32125f5b-6f00-5168-9af5-10a1ee0588fa', 'ab9e2d7e-e823-6154-d3b8-55a1c0d348b3'),
(136, 'magnis dis parturient', 'blandit. nam nulla magna, malesuada vel, convallis in, cursus', '0832192a-5cc9-20c8-1d2f-4c594126bbdd', 'c5b083ee-74c2-e9b8-59cc-d65ae67bdde2'),
(137, 'dignissim pharetra. nam', 'purus gravida sagittis. duis gravida. praesent eu nulla at', '81dad51a-19aa-17bf-3ac3-de860f44f683', '6302c73b-b156-5512-d510-32ef313f9060'),
(138, 'et magnis', 'lorem, vehicula et, rutrum eu, ultrices sit amet,', '1900eecc-7db7-7a02-b991-0fa5d66b1e61', '6caca8f7-7e9b-dded-3616-cc92aadf0410'),
(139, 'fames', 'dapibus quam quis diam. pellentesque habitant morbi tristique', 'f5a64eaa-5cd8-1135-2500-43c5d5fbe0ce', '5bfcf0e3-86d3-68c6-2076-077295a90bd9'),
(140, 'nisl.', 'vel est tempor bibendum. donec felis orci, adipiscing non, luctus', '5b007d4c-3abc-af7d-8d97-416e42aef46e', '415ca30e-7057-ee32-e50c-a84000c7794f'),
(141, 'mauris. integer', 'sem magna nec quam.', '03c670d1-2f1f-37bb-2936-d8746ea461ca', '1d33e201-6950-1f57-fd3a-7f9b6a956117'),
(142, 'nulla. cras eu', 'erat, in consectetuer ipsum nunc id enim. curabitur massa. vestibulum', '862fe945-e928-1e6f-9182-db33c6201ce9', 'de021027-2d7c-d2d6-6b47-39903c81792d'),
(143, 'ornare sagittis', 'montes, nascetur ridiculus mus. donec', 'e7a47168-5e6d-f893-57c1-8d5fee76b6ed', '296a72e9-e442-75d7-a9db-51e06c5603da'),
(144, 'egestas lacinia.', 'ut mi. duis risus odio, auctor vitae, aliquet nec,', '97518574-f2b4-9ff8-277c-e6bef4f577c8', 'eac25b72-47bd-988f-164c-4d08a67376c1'),
(145, 'curae;', 'scelerisque neque. nullam nisl.', '90cc0721-6654-7696-1de5-c69df1926901', '7d73ebe6-6e44-36ba-2de4-225c61f848c4'),
(146, 'quis', 'sit amet diam eu dolor egestas rhoncus. proin nisl', 'c6b22542-6685-2b35-b773-f0b04506ccec', 'fbefc5c0-a76b-555d-6f15-7152b0624d91'),
(147, 'quisque ornare tortor', 'dolor. fusce feugiat. lorem', 'e064676e-125e-b204-4d29-de83bf98588a', '8fbe92f9-8296-38bf-8b2a-32887287f59c'),
(148, 'libero.', 'eget massa. suspendisse eleifend. cras sed leo. cras', '418b0c79-dbd2-c8ea-70db-5b96da870e04', '0ab9826d-f4e5-830a-b480-94090cab1af3'),
(149, 'etiam', 'rutrum non, hendrerit id, ante. nunc mauris sapien,', 'c0f839eb-08a0-991f-c8ac-3e014358be9e', 'c7cf12f5-c532-d908-0404-288b301749e4'),
(150, 'sem. pellentesque', 'nunc interdum feugiat. sed', '809178c3-fbd9-b55e-eb4a-8a5bbd936481', '056c209f-0064-6ec9-9098-8499dd65e1f7'),
(151, 'dictum', 'ante. nunc mauris sapien,', '4ff2e28f-9922-d5ca-2885-85b0227b08e2', '52fef456-2ae8-326c-882a-bdb9e688558e'),
(152, 'metus. vivamus euismod', 'mauris ipsum porta elit, a feugiat tellus lorem', '32edb13a-0a97-c8cc-03a0-8d7dbf946809', 'c4f803ee-b857-280a-9cea-894593198dfe'),
(153, 'eleifend.', 'aliquet diam. sed diam lorem, auctor quis, tristique', '0ec7a5a8-5101-9f22-0db4-ab014c12a2c5', '2029e89d-6ca2-6988-9e17-ba7942f817b7'),
(154, 'lectus', 'donec felis orci, adipiscing non, luctus sit amet, faucibus ut,', '1e26bf14-220b-8a43-85a0-c37aa8c27982', 'b361b7eb-a556-d743-b193-ee1f1229e80a'),
(155, 'ultrices a,', 'ullamcorper. duis at lacus. quisque purus sapien, gravida', '45918d1a-1d61-ead6-3bed-516d3aa0299e', '60ca4c92-3a2e-9b6a-674e-04567da80aa1'),
(156, 'id, ante. nunc', 'quisque ornare tortor at risus. nunc', '279af8f2-5397-c8d9-8f30-ef46b77e1a68', 'd514d727-d396-8a3e-b847-ff7c89ce9e20'),
(157, 'pede nec ante', 'in, tempus eu, ligula. aenean euismod mauris eu', 'df8440a5-cedd-2655-fea0-babec1d4146c', '3f2b1508-ffa8-2a94-b799-5c08e6a81c7c'),
(158, 'fringilla,', 'dolor elit, pellentesque a, facilisis non, bibendum', 'e3cbd0f3-d2b2-aba5-5fb1-7360495adaf2', '9cef1d71-4e2d-d3d9-6910-e0a92219ea03'),
(159, 'ullamcorper, velit', 'quisque porttitor eros nec tellus.', '6a48e295-3af5-e046-660c-fc8fc8e1f145', '8097734b-2150-eeff-ee08-c8d81cddc976'),
(160, 'a', 'praesent luctus. curabitur egestas nunc sed libero.', '790d881b-1742-81c3-c115-c552810da7bb', '26c7a251-cba4-d5a4-77f2-7355897a9833'),
(161, 'dui. cras pellentesque.', 'faucibus ut, nulla. cras eu tellus eu augue', 'aee0b018-95c9-8f24-6a3a-4409879a953c', '0c606917-73c5-808b-bd43-479b07008373'),
(162, 'vestibulum accumsan', 'nisl sem, consequat nec, mollis vitae, posuere', 'fb7b05a4-1465-c75d-8ae6-8e768ddaf2e7', 'bfd1a185-3804-f8a3-83bc-acfa7be92c2b'),
(163, 'dictum placerat,', 'enim, sit amet ornare lectus justo eu arcu.', 'e59d7994-8167-cadb-3b1f-daaebd8c6ddc', '77deac03-ddd4-13c2-ab71-508b58efac08'),
(164, 'netus et malesuada', 'aliquet, sem ut cursus', '080d4a13-dec3-590e-b7bc-5949e2e4c27d', 'b3ed5fa9-b5ef-7cca-6c25-b05804d60d6c'),
(165, 'aliquam, enim nec', 'duis dignissim tempor arcu. vestibulum', '86219d04-603b-476c-fe0d-cd035a614c1e', 'bc177d8b-b7d9-0ec9-b834-bb2213652699'),
(166, 'est ac facilisis', 'ipsum nunc id enim. curabitur massa.', '61e2c261-c9d8-8e08-0b51-3776f39a32cf', 'b1121bb1-fb47-1f2c-5e94-e534f2aa444c'),
(167, 'rhoncus.', 'tempus mauris erat eget', 'c85ccd77-0d26-b550-083d-b9c9da0d2a36', '8e1eb38a-da67-c5da-a496-844af49ea27a'),
(168, 'morbi quis urna.', 'molestie pharetra nibh. aliquam ornare,', 'b0b55b46-4f50-9f58-5b18-7864256ca153', '0ece0f7a-3bc0-fe4e-df58-43c5bc6a9417'),
(169, 'nibh enim,', 'luctus. curabitur egestas nunc sed libero. proin sed turpis', '72f0ecae-2d89-0bff-e196-9ba220754133', '584a19cb-9d27-f432-4cc6-07a9fd3d02f7'),
(170, 'varius ultrices,', 'mauris eu elit. nulla', 'dc13e000-d27e-19ff-65f8-62cd90589789', '06c672bd-5b2a-a08e-e0e0-49e21f7cb749'),
(171, 'pede. cum', 'suspendisse aliquet, sem ut cursus luctus, ipsum leo', '89bbc78e-e70b-69dc-04c1-32307737b9e6', '96c94686-843b-e527-6013-6151a0cbd85e'),
(172, 'aliquam', 'orci, adipiscing non, luctus sit amet,', '910acf73-5c44-848a-e68e-0b2cc0f3f6c4', '0a484fbe-b144-8d46-0676-03a5ef71521e'),
(173, 'et,', 'nisi nibh lacinia orci, consectetuer euismod est arcu ac', '0dea5f2c-7771-5496-31d5-6450dd0cfa2f', 'c869febb-3a44-5c70-9a84-400f4601860b'),
(174, 'ante ipsum primis', 'cum sociis natoque penatibus et magnis dis parturient montes,', '0cae5f01-8306-3ed4-c6b0-b8029a37c8e8', 'df4d9326-4016-a3a0-d870-af70bed5719c'),
(175, 'aliquam', 'mi. duis risus odio,', 'e905b66b-828f-83ae-472d-8acf654fbb27', 'fbf621e1-b30d-5977-b122-c5b936eb3bf0'),
(176, 'in mi', 'eu neque pellentesque massa lobortis ultrices. vivamus', '6064e53a-f6c2-e5d8-ec1b-54ec18241f4c', '87c8c6fa-a5f9-4ad5-2a69-ff4d05903f6a'),
(177, 'pede, malesuada vel,', 'at pretium aliquet, metus urna', '87072c10-fd15-604e-15e0-0940550e68db', 'e74cc4c8-1359-8dd4-393c-f459e8152259'),
(178, 'non, egestas a,', 'cubilia curae; phasellus ornare. fusce mollis. duis', 'ef10e66c-dc6f-46c2-3c3c-20852f98302a', 'f3b1d5dd-79f5-c3ec-3e5f-99c4a4b8dca8'),
(179, 'malesuada', 'nullam velit dui, semper et, lacinia vitae, sodales', 'bba8c1e6-57bb-132d-d11b-502feac6bc8c', '6d996a8b-ee3c-d5b9-52ce-e5ec69c8bf7a'),
(180, 'eu tellus. phasellus', 'eget odio. aliquam vulputate ullamcorper magna. sed eu eros.', 'da58f97f-9075-8ab9-c9dd-fdc543f0a455', 'dce4e3cc-b523-c2de-e82b-2a24ef80b0a0'),
(181, 'consectetuer adipiscing elit.', 'massa. vestibulum accumsan neque', 'c25757fc-b03a-48f1-fb6d-cd81f680c499', '3aea0921-67e2-f153-4cda-3eb793455ab6'),
(182, 'risus.', 'justo eu arcu. morbi sit amet massa. quisque', 'ebb37dac-6295-bc30-148a-c3cc8cd94b83', '71f46197-8b2c-9187-fc38-4f27c08c2fab'),
(183, 'fermentum vel, mauris.', 'est. nunc laoreet lectus quis', '441c274d-f967-3e8d-e91e-da5d8928daf7', 'a93f19fe-c6da-a9ed-572f-6d6ab8ece7e3'),
(184, 'neque. nullam', 'aliquet nec, imperdiet nec,', 'a928ae7d-b7fb-8d7c-4eb0-34e262ba18f1', 'fe7157fc-fe8f-0f5a-0b6f-fa336a0c7119'),
(185, 'elit. aliquam', 'duis at lacus. quisque', '5ce4fed0-c1f0-3638-1fdd-0e20623002bb', 'ef1c4cf4-cd1c-76cc-8fed-717a9a242c9b'),
(186, 'enim. curabitur massa.', 'at, nisi. cum sociis natoque penatibus et magnis dis', '897eedff-965f-43c9-5773-1063b47f65b3', '47be51e6-7c68-5e7f-02bb-baf5e7325468'),
(187, 'velit. quisque', 'morbi tristique senectus et netus et malesuada fames ac turpis', '801c7c4d-e1e0-2a78-b7a1-33199d65605f', '269af52c-b450-deae-677b-fe41d82a9b18'),
(188, 'cum sociis natoque', 'sed dui. fusce aliquam, enim nec tempus scelerisque,', 'ae138f8f-682d-fecf-c76e-e9dfb44cfd72', '07a62c19-0208-675f-57d3-becf8285150d'),
(189, 'ac', 'eget, volutpat ornare, facilisis', '51f48add-b494-c571-6452-b06c1ac6f094', '89cb0c75-1d2e-a5d0-b938-0402c5854db4'),
(190, 'duis ac', 'lorem, auctor quis, tristique ac, eleifend', '99438ca3-95b1-c630-ba8d-b5b7fdecce6f', 'a4fcded3-709f-144f-b891-d9f7a3ddac38'),
(191, 'in', 'donec sollicitudin adipiscing ligula. aenean gravida nunc sed pede.', '258ad1f5-923a-3d8b-ab73-94f0a7eb7a13', '97322ad0-ca35-cdf1-3783-d6d4409d64df'),
(192, 'nec, euismod in,', 'mauris magna. duis dignissim tempor arcu. vestibulum', '8fae371d-c76f-3e5d-6c9c-d4bf85746026', '658a4fb3-aa70-e0e2-0bb6-a5a9bacb29ed'),
(193, 'donec felis orci,', 'ante blandit viverra. donec tempus, lorem', 'c3730594-749f-50b0-0c10-995d5023e472', '1e6b796c-10b6-41c2-d50d-280aa716814e'),
(194, 'rutrum,', 'sed eu nibh vulputate mauris sagittis placerat.', 'bb536a32-4e37-4120-7dab-0fa936f3d4b0', '8abe4b72-de4a-5f30-f467-0e839d12559b'),
(195, 'aliquet vel, vulputate', 'ad litora torquent per conubia nostra, per inceptos hymenaeos.', '7cec0fe6-1579-3df2-613c-286c8f9d9b32', '54e1194f-01c2-487c-367d-8fb1a3ddc540'),
(196, 'nunc sollicitudin', 'eu, euismod ac, fermentum vel, mauris. integer', '9a157b34-f05a-00b3-966d-c33c366fcff4', '49c409d9-52bb-0398-6c07-5aa5c73d36ea'),
(197, 'taciti sociosqu ad', 'sed orci lobortis augue scelerisque mollis.', '093b3653-f33b-3780-7505-ff32712c03cd', '1cad6ad7-30dd-3fa2-d58a-d7cdeaa24ccc'),
(198, 'nec', 'pede sagittis augue, eu tempor erat neque', 'd969d283-f9ec-4ec1-169f-37be12984800', 'f3ecd4d4-f45d-bb1c-2e08-73d497d4d7a4'),
(199, 'lacinia at, iaculis', 'mauris eu turpis. nulla aliquet.', 'c78cbb72-4511-1af5-a25f-d80614eef675', '291f14de-296f-a84d-5285-1b0980052736'),
(200, 'et netus et', 'nascetur ridiculus mus. aenean', 'de0d8a24-c5c0-17f8-0fe3-78b0eaa2ae52', 'b0eef191-25ed-bc9e-9192-30593e3879ea');

-- --------------------------------------------------------

--
-- Structure de la table `DevApp`
--

CREATE TABLE `DevApp` (
  `userId` int(11) NOT NULL,
  `appId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `DevApp`
--

INSERT INTO `DevApp` (`userId`, `appId`) VALUES
(4, 2),
(4, 4),
(4, 5),
(4, 8),
(4, 10),
(4, 13),
(4, 15),
(4, 16),
(4, 18),
(4, 20),
(4, 21),
(4, 22),
(4, 23),
(4, 24),
(4, 25),
(4, 26),
(4, 27),
(4, 28),
(4, 29),
(4, 30),
(4, 31),
(4, 32),
(4, 34),
(4, 36),
(4, 39),
(4, 41),
(4, 42),
(4, 43),
(4, 45),
(4, 48),
(4, 51),
(4, 52),
(4, 54),
(4, 56),
(4, 61),
(4, 63),
(4, 65),
(4, 68),
(4, 70),
(4, 72),
(4, 73),
(4, 78),
(4, 79),
(4, 80),
(4, 82),
(4, 84),
(4, 85),
(4, 89),
(4, 92),
(4, 104),
(4, 112),
(4, 115),
(4, 116),
(4, 117),
(4, 119),
(4, 120),
(4, 121),
(4, 123),
(4, 125),
(4, 127),
(4, 130),
(4, 131),
(4, 133),
(4, 135),
(4, 138),
(4, 140),
(4, 144),
(4, 145),
(4, 150),
(4, 152),
(4, 156),
(4, 159),
(4, 162),
(4, 163),
(4, 165),
(4, 167),
(4, 168),
(4, 170),
(4, 172),
(4, 174),
(4, 177),
(4, 179),
(4, 180),
(4, 181),
(4, 182),
(4, 184),
(4, 185),
(4, 187),
(4, 188),
(4, 189),
(4, 190),
(4, 192),
(4, 193),
(4, 194),
(4, 196),
(4, 198),
(4, 199),
(4, 200),
(5, 4),
(5, 10),
(5, 17),
(5, 21),
(5, 32),
(5, 104),
(5, 105),
(5, 106),
(5, 112),
(5, 113),
(6, 22),
(6, 26),
(6, 34),
(6, 65),
(10, 2),
(10, 3),
(10, 4),
(10, 6),
(10, 7),
(10, 9),
(10, 11),
(10, 14),
(10, 99);

-- --------------------------------------------------------

--
-- Structure de la table `Developper`
--

CREATE TABLE `Developper` (
  `userId` int(11) NOT NULL,
  `suspended` tinyint(1) DEFAULT 0,
  `hasToResetPassword` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Developper`
--

INSERT INTO `Developper` (`userId`, `suspended`, `hasToResetPassword`) VALUES
(4, 0, 0),
(5, 1, 0),
(6, 1, 0),
(7, 0, 0),
(8, 1, 0),
(9, 1, 0),
(10, 0, 0),
(11, 0, 0),
(12, 0, 0),
(13, 0, 0),
(14, 0, 0),
(15, 0, 0),
(16, 0, 0),
(17, 0, 0),
(18, 0, 0),
(19, 0, 0),
(20, 0, 0),
(21, 0, 0),
(22, 0, 0),
(23, 0, 0),
(24, 0, 0),
(25, 0, 0),
(26, 0, 0),
(27, 0, 0),
(28, 0, 0),
(29, 0, 0),
(30, 0, 0),
(31, 0, 0),
(32, 0, 0),
(33, 0, 0),
(34, 0, 0),
(35, 0, 0),
(36, 0, 0),
(37, 0, 0),
(38, 0, 0),
(39, 0, 0),
(40, 0, 0),
(41, 0, 0),
(42, 0, 0),
(43, 0, 0),
(44, 0, 0),
(45, 0, 0),
(46, 0, 0),
(47, 0, 0),
(48, 0, 0),
(49, 0, 0),
(50, 0, 0),
(51, 0, 0),
(52, 0, 0),
(53, 0, 0),
(54, 0, 0),
(55, 0, 0),
(56, 0, 0),
(57, 0, 0),
(58, 0, 0),
(59, 0, 0),
(60, 0, 0),
(61, 0, 0),
(62, 0, 0),
(63, 0, 0),
(64, 0, 0),
(65, 0, 0),
(66, 0, 0),
(67, 0, 0),
(68, 0, 0),
(69, 0, 0),
(70, 0, 0),
(71, 0, 0),
(72, 0, 0),
(73, 0, 0),
(74, 0, 0),
(75, 0, 0),
(76, 0, 0),
(77, 0, 0),
(78, 0, 0),
(79, 0, 0),
(80, 0, 0),
(81, 0, 0),
(82, 0, 0),
(83, 0, 0),
(84, 0, 0),
(85, 0, 0),
(86, 0, 0),
(87, 0, 0),
(88, 0, 0),
(89, 0, 0),
(90, 0, 0),
(91, 0, 0),
(92, 0, 0),
(93, 0, 0),
(94, 0, 0),
(95, 0, 0),
(96, 0, 0),
(97, 0, 0),
(98, 0, 0),
(99, 0, 0),
(100, 0, 0),
(101, 0, 0),
(102, 0, 0),
(103, 0, 0),
(104, 0, 0),
(105, 0, 0),
(106, 0, 0),
(107, 0, 0),
(108, 0, 0),
(109, 0, 0),
(132, 0, 0),
(133, 0, 0),
(134, 0, 0),
(135, 0, 0),
(136, 0, 0),
(137, 0, 0),
(138, 0, 0),
(139, 0, 0),
(140, 0, 0),
(141, 0, 0),
(142, 0, 0),
(143, 0, 0),
(144, 0, 0),
(145, 0, 0),
(146, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE `User` (
  `userId` int(11) NOT NULL,
  `firstName` text NOT NULL,
  `lastName` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `accountType` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `User`
--

INSERT INTO `User` (`userId`, `firstName`, `lastName`, `email`, `password`, `accountType`) VALUES
(1, 'André', 'Jacquemond', 'andre.jacquemond@heig-vd.ch', 'password', 'admin'),
(2, 'Silver', 'Kameni', 'hyacinthe.kamenitchieko@heig-vd.ch', 'pass', 'admin'),
(3, 'Alexandre', 'Vouilloz', 'alexandre.vouilloz@heig-vd.ch', 'pass', 'admin'),
(4, 'Bob', 'Eponge', 'bob.eponge@heig-vd.ch', 'pass', 'dev'),
(5, 'hulk', 'Hogan', 'hulk.hogan@heig.ch', 'pass', 'dev'),
(6, 'Mickey', 'Mouse', 'Mickey.Mouse@heig.ch', 'pass', 'dev'),
(7, 'America', 'Captain', 'captain@avengers.ch', 'pass', 'dev'),
(8, 'Cafe', 'Bob', 'bob.cafe@heig.ch', 'coucou', 'dev'),
(9, 'kevin', 'mignion', 'kevin.migion@heig.ch', 'salut', 'dev'),
(10, 'Alex', 'Vouilloz', 'alex_vouilloz@netplus.ch', 'pass', 'dev'),
(11, 'Geraldine', 'Dodson', 'Nulla@volutpatNulla.com', 'pass', 'dev'),
(12, 'Astra', 'Whitehead', 'Vestibulum@euultrices.co.uk', 'pass', 'dev'),
(13, 'Maisie', 'Burke', 'Phasellus.ornare.Fusce@arcuVivamussit.com', 'pass', 'dev'),
(14, 'Erica', 'Moreno', 'et.magnis.dis@convallisincursus.com', 'pass', 'dev'),
(15, 'Samson', 'Brown', 'Morbi.vehicula@acmattisornare.ca', 'pass', 'dev'),
(16, 'Yoshi', 'Lindsay', 'Class@malesuadavel.org', 'pass', 'dev'),
(17, 'Phillip', 'Harris', 'arcu@fermentummetusAenean.org', 'pass', 'dev'),
(18, 'Emery', 'Lang', 'est@euerosNam.edu', 'pass', 'dev'),
(19, 'Eden', 'Delgado', 'neque@enimmi.edu', 'pass', 'dev'),
(20, 'Jakeem', 'Hull', 'pharetra.felis.eget@Aenean.com', 'pass', 'dev'),
(21, 'Farrah', 'Haynes', 'sed@Nuncsollicitudin.net', 'pass', 'dev'),
(22, 'Frances', 'Payne', 'egestas@Nam.ca', 'pass', 'dev'),
(23, 'Zenia', 'Hanson', 'porttitor.tellus@justositamet.org', 'pass', 'dev'),
(24, 'Liberty', 'Jensen', 'velit.justo@blandit.edu', 'pass', 'dev'),
(25, 'Ria', 'Finley', 'egestas.blandit@urna.ca', 'pass', 'dev'),
(26, 'Grady', 'Lopez', 'Aliquam@ultricesiaculis.edu', 'pass', 'dev'),
(27, 'Evelyn', 'Hubbard', 'dolor.Quisque.tincidunt@semperrutrum.ca', 'pass', 'dev'),
(28, 'Brenden', 'Puckett', 'consequat@magnisdis.com', 'pass', 'dev'),
(29, 'Silas', 'Jordan', 'vestibulum.lorem@at.org', 'pass', 'dev'),
(30, 'Chandler', 'Callahan', 'a@utsemNulla.co.uk', 'pass', 'dev'),
(31, 'Murphy', 'Solomon', 'Nullam@sociosqu.ca', 'pass', 'dev'),
(32, 'Julian', 'King', 'at.velit.Cras@euismodac.net', 'pass', 'dev'),
(33, 'Colton', 'Gentry', 'magna@facilisisSuspendissecommodo.edu', 'pass', 'dev'),
(34, 'Acton', 'Conway', 'dapibus@fringillacursuspurus.edu', 'pass', 'dev'),
(35, 'Hu', 'Stanton', 'Cras.lorem.lorem@nuncest.org', 'pass', 'dev'),
(36, 'Kuame', 'Mercado', 'adipiscing@turpisnecmauris.ca', 'pass', 'dev'),
(37, 'Wayne', 'Reyes', 'nulla.Integer@at.edu', 'pass', 'dev'),
(38, 'Wynne', 'Serrano', 'dictum.Phasellus.in@uterat.edu', 'pass', 'dev'),
(39, 'Katell', 'Delgado', 'Aliquam.nisl@vitaesemper.org', 'pass', 'dev'),
(40, 'Baxter', 'Rich', 'scelerisque.dui@hendrerit.edu', 'pass', 'dev'),
(41, 'Jamalia', 'Dyer', 'sagittis.semper@Donecfringilla.ca', 'pass', 'dev'),
(42, 'Ian', 'Wagner', 'Aliquam@Duisacarcu.com', 'pass', 'dev'),
(43, 'Germane', 'Trevino', 'amet.orci@pede.edu', 'pass', 'dev'),
(44, 'Lois', 'Glover', 'et.malesuada.fames@posuerecubiliaCurae.net', 'pass', 'dev'),
(45, 'Lyle', 'Rosa', 'ligula.elit.pretium@turpis.org', 'pass', 'dev'),
(46, 'Amal', 'Gould', 'in.molestie@lectus.com', 'pass', 'dev'),
(47, 'Honorato', 'Compton', 'Nunc.commodo@pellentesque.edu', 'pass', 'dev'),
(48, 'Karyn', 'Hammond', 'Donec.sollicitudin.adipiscing@placeratorcilacus.net', 'pass', 'dev'),
(49, 'Lynn', 'Oneil', 'risus.In@imperdietullamcorperDuis.co.uk', 'pass', 'dev'),
(50, 'Mohammad', 'Odonnell', 'ipsum@lectusasollicitudin.net', 'pass', 'dev'),
(51, 'Ryder', 'Norman', 'magna.Cras@dolor.net', 'pass', 'dev'),
(52, 'Anjolie', 'Torres', 'per@enimmitempor.edu', 'pass', 'dev'),
(53, 'Finn', 'Kane', 'Donec@auctorquistristique.co.uk', 'pass', 'dev'),
(54, 'Gloria', 'Horne', 'scelerisque.neque@enimEtiam.org', 'pass', 'dev'),
(55, 'India', 'William', 'montes.nascetur@eu.edu', 'pass', 'dev'),
(56, 'Christen', 'Hooper', 'facilisis.lorem.tristique@Pellentesquetincidunttempus.co.uk', 'pass', 'dev'),
(57, 'Sharon', 'Franks', 'Maecenas.mi@enim.ca', 'pass', 'dev'),
(58, 'Inga', 'Ellison', 'ac.feugiat.non@felis.org', 'pass', 'dev'),
(59, 'Mona', 'Payne', 'lectus@velit.co.uk', 'pass', 'dev'),
(60, 'Piper', 'Clayton', 'risus@Donecestmauris.co.uk', 'pass', 'dev'),
(61, 'Dora', 'Bridges', 'hendrerit.a@luctuslobortis.com', 'pass', 'dev'),
(62, 'Gwendolyn', 'Rivera', 'lorem@porttitorscelerisque.edu', 'pass', 'dev'),
(63, 'Laurel', 'Brooks', 'aliquam.arcu.Aliquam@dictum.org', 'pass', 'dev'),
(64, 'Honorato', 'Sutton', 'Phasellus.ornare@Aliquamadipiscinglobortis.ca', 'pass', 'dev'),
(65, 'Illana', 'Wise', 'Vestibulum@odio.ca', 'pass', 'dev'),
(66, 'Stephen', 'Prince', 'nec@inaliquetlobortis.ca', 'pass', 'dev'),
(67, 'Caldwell', 'Yates', 'diam.Duis@Aeneansed.co.uk', 'pass', 'dev'),
(68, 'James', 'Sampson', 'sit.amet.consectetuer@DonecegestasDuis.org', 'pass', 'dev'),
(69, 'Cooper', 'Townsend', 'mus@accumsannequeet.net', 'pass', 'dev'),
(70, 'Erich', 'Alexander', 'aliquet.sem.ut@eulacusQuisque.edu', 'pass', 'dev'),
(71, 'Rama', 'Bridges', 'Nullam@malesuadaaugue.net', 'pass', 'dev'),
(72, 'Fleur', 'Lee', 'lectus@et.org', 'pass', 'dev'),
(73, 'Daria', 'Mann', 'vel@at.com', 'pass', 'dev'),
(74, 'Lester', 'Paul', 'scelerisque.neque@vel.net', 'pass', 'dev'),
(75, 'Clark', 'Mcpherson', 'ultricies.dignissim@sem.co.uk', 'pass', 'dev'),
(76, 'Alyssa', 'Kramer', 'consectetuer@massaSuspendisse.edu', 'pass', 'dev'),
(77, 'Juliet', 'Manning', 'libero@Donecestmauris.org', 'pass', 'dev'),
(78, 'Quinn', 'Jimenez', 'diam@fermentumfermentumarcu.com', 'pass', 'dev'),
(79, 'Bernard', 'Bond', 'ante.Maecenas@Quisqueornare.edu', 'pass', 'dev'),
(80, 'Alexandra', 'Horn', 'condimentum.Donec.at@semsemper.net', 'pass', 'dev'),
(81, 'Vivian', 'Solis', 'vitae.erat@gravidaPraesenteu.org', 'pass', 'dev'),
(82, 'Melissa', 'Pickett', 'metus.vitae@augueac.org', 'pass', 'dev'),
(83, 'Signe', 'Mcmahon', 'diam.Proin@euismodmauriseu.edu', 'pass', 'dev'),
(84, 'Hayfa', 'Stein', 'vel@lacusvestibulum.net', 'pass', 'dev'),
(85, 'Shea', 'Richmond', 'molestie.dapibus.ligula@nuncacmattis.net', 'pass', 'dev'),
(86, 'Brennan', 'Bruce', 'et@non.edu', 'pass', 'dev'),
(87, 'April', 'Rollins', 'ligula.consectetuer.rhoncus@erat.edu', 'pass', 'dev'),
(88, 'Wang', 'Gay', 'facilisis.magna.tellus@mi.net', 'pass', 'dev'),
(89, 'Lewis', 'Glass', 'convallis@necligulaconsectetuer.ca', 'pass', 'dev'),
(90, 'Philip', 'Mann', 'Cras@orciquis.ca', 'pass', 'dev'),
(91, 'Quamar', 'Mathis', 'velit@iaculisodioNam.org', 'pass', 'dev'),
(92, 'Justine', 'Foreman', 'vitae@luctus.net', 'pass', 'dev'),
(93, 'Jacqueline', 'Waller', 'dui@Pellentesquehabitant.net', 'pass', 'dev'),
(94, 'Hedley', 'Mcleod', 'ac.mattis@nonarcu.org', 'pass', 'dev'),
(95, 'Wesley', 'Burns', 'lorem.vehicula.et@tinciduntduiaugue.com', 'pass', 'dev'),
(96, 'Lucian', 'Hampton', 'Aliquam.tincidunt.nunc@pharetraNamac.net', 'pass', 'dev'),
(97, 'Ursula', 'Madden', 'at.risus@mollis.edu', 'pass', 'dev'),
(98, 'Magee', 'Hardy', 'vitae.erat@rhoncusidmollis.com', 'pass', 'dev'),
(99, 'Gavin', 'Finch', 'Vestibulum.ante@Inscelerisquescelerisque.co.uk', 'pass', 'dev'),
(100, 'Kasper', 'Hess', 'vel@tortor.ca', 'pass', 'dev'),
(101, 'Idona', 'Cash', 'arcu.Morbi@augueut.com', 'pass', 'dev'),
(102, 'Stephanie', 'Lambert', 'nibh.enim@luctus.co.uk', 'pass', 'dev'),
(103, 'Travis', 'Peterson', 'Nulla.tempor@arcuac.edu', 'pass', 'dev'),
(104, 'Xavier', 'Burris', 'justo@Cumsociis.net', 'pass', 'dev'),
(105, 'Elmo', 'Soto', 'nec.imperdiet.nec@loremipsumsodales.com', 'pass', 'dev'),
(106, 'Maia', 'Calderon', 'mi.ac@magnaSedeu.net', 'pass', 'dev'),
(107, 'Quon', 'Patton', 'iaculis@tristique.edu', 'pass', 'dev'),
(108, 'Mikayla', 'Dillon', 'sit.amet.risus@Vivamusnisi.edu', 'pass', 'dev'),
(109, 'Kareem', 'Nicholson', 'Vestibulum@Vestibulumanteipsum.com', 'pass', 'dev'),
(132, 'Oin', 'Marge Dursley', 'MargeDursleyOin@heig-vd.ch', 'pass', 'dev'),
(133, 'Belladonna Took', 'Cedric Diggory', 'CedricDiggoryBelladonnaTook@heig-vd.ch', 'pass', 'dev'),
(134, 'Smaug', 'Rufus Scrimgeour', 'RufusScrimgeourSmaug@heig-vd.ch', 'pass', 'dev'),
(135, 'Belladonna Took', 'Sir Cadogan', 'SirCadoganBelladonnaTook@heig-vd.ch', 'pass', 'dev'),
(136, 'Gandalf The Grey', 'Scabbers', 'ScabbersGandalfTheGrey@heig-vd.ch', 'pass', 'dev'),
(137, 'Ori', 'Kingsley Shacklebolt', 'KingsleyShackleboltOri@heig-vd.ch', 'pass', 'dev'),
(138, 'Fili', 'Anthony Goldstein', 'AnthonyGoldsteinFili@heig-vd.ch', 'pass', 'dev'),
(139, 'Nori', 'Scabior', 'ScabiorNori@heig-vd.ch', 'pass', 'dev'),
(140, 'Fili', 'Pansy Parkinson', 'PansyParkinsonFili@heig-vd.ch', 'pass', 'dev'),
(141, 'The Great Goblin', 'Olympe Maxime', 'OlympeMaximeTheGreatGoblin@heig-vd.ch', 'pass', 'dev'),
(142, 'Bert', 'Abeforth Dumbledore', 'AbeforthDumbledoreBert@heig-vd.ch', 'pass', 'dev'),
(143, 'Beorn', 'Winky', 'WinkyBeorn@heig-vd.ch', 'pass', 'dev'),
(144, 'Bofur', 'Marcus Belby', 'MarcusBelbyBofur@heig-vd.ch', 'pass', 'dev'),
(145, 'Dain', 'Merope Gaunt', 'MeropeGauntDain@heig-vd.ch', 'pass', 'dev'),
(146, 'Fili', 'Griphook', 'GriphookFili@heig-vd.ch', 'pass', 'dev');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Application`
--
ALTER TABLE `Application`
  ADD PRIMARY KEY (`appId`),
  ADD UNIQUE KEY `appKey` (`appKey`),
  ADD UNIQUE KEY `appSecret` (`appSecret`);

--
-- Index pour la table `DevApp`
--
ALTER TABLE `DevApp`
  ADD PRIMARY KEY (`userId`,`appId`),
  ADD KEY `FK_Application` (`appId`),
  ADD KEY `fk_User_id_dev` (`userId`);

--
-- Index pour la table `Developper`
--
ALTER TABLE `Developper`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `fk_User_id` (`userId`);

--
-- Index pour la table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Application`
--
ALTER TABLE `Application`
  MODIFY `appId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;

--
-- AUTO_INCREMENT pour la table `User`
--
ALTER TABLE `User`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=147;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `DevApp`
--
ALTER TABLE `DevApp`
  ADD CONSTRAINT `FK_Application` FOREIGN KEY (`appId`) REFERENCES `Application` (`appId`),
  ADD CONSTRAINT `fk_User_id_dev` FOREIGN KEY (`userId`) REFERENCES `Developper` (`userId`);

--
-- Contraintes pour la table `Developper`
--
ALTER TABLE `Developper`
  ADD CONSTRAINT `fk_User_id` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
