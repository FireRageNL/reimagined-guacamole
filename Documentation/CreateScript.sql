-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Gegenereerd op: 18 okt 2016 om 12:52
-- Serverversie: 5.7.15-0ubuntu0.16.04.1
-- PHP-versie: 7.0.8-0ubuntu0.16.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Achievement`
--

CREATE TABLE `Achievement` (
  `AchievmentID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Category`
--

CREATE TABLE `Category` (
  `CategoryID` int(11) NOT NULL,
  `Category` varchar(45) NOT NULL,
  `Description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `Category`
--

INSERT INTO `Category` (`CategoryID`, `Category`, `Description`) VALUES
(1, 'Geschiedenis', 'Vragen over de wereld van weleer!'),
(2, 'Kunst', 'Vragen over Kunst en Kitsch'),
(3, 'Games', 'Vragen over Games.'),
(4, 'Entertainment', 'Vragen over films en televisie'),
(5, 'Muziek', 'Raad het liedje!'),
(6, 'Sport', 'Vragen over de sportwereld!'),
(7, 'Wetenschap', 'Vragen over alle soorten wetenschap');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `GameInfo`
--

CREATE TABLE `GameInfo` (
  `GameInfoID` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Score` int(11) NOT NULL,
  `Result` varchar(45) DEFAULT NULL,
  `Profile_ProfileID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `GameInfo`
--

INSERT INTO `GameInfo` (`GameInfoID`, `Date`, `Score`, `Result`, `Profile_ProfileID`) VALUES
(1, '2016-10-11 11:23:34', 1000, NULL, 2),
(2, '2016-10-17 15:38:04', 1000, NULL, 2),
(3, '2016-10-17 15:41:49', 1000, NULL, 2),
(4, '2016-10-17 15:42:50', 500, NULL, 5),
(5, '2016-10-17 15:58:51', 500, NULL, 5),
(6, '2016-10-18 08:07:24', 500, NULL, 3),
(7, '2016-10-18 08:24:36', 750, NULL, 3),
(8, '2016-10-18 08:35:14', 1000, NULL, 2),
(9, '2016-10-18 08:36:32', 1000, NULL, 2),
(10, '2016-10-18 08:40:14', 1000, NULL, 2),
(11, '2016-10-18 09:03:03', 1000, NULL, 2),
(12, '2016-10-18 09:14:40', 1000, NULL, 2),
(13, '2016-10-18 09:17:15', 1000, NULL, 2),
(14, '2016-10-18 09:22:23', 1000, NULL, 2),
(15, '2016-10-18 09:32:26', 1000, NULL, 2),
(16, '2016-10-18 09:34:53', 1000, NULL, 2),
(17, '2016-10-18 09:37:30', 1000, NULL, 2),
(18, '2016-10-18 09:38:26', 1000, NULL, 2),
(19, '2016-10-18 09:42:01', 1000, NULL, 2),
(20, '2016-10-18 09:42:26', 1000, NULL, 2),
(21, '2016-10-18 09:46:03', 525, NULL, 42),
(22, '2016-10-18 09:48:24', 1000, NULL, 2),
(23, '2016-10-18 09:49:56', 1000, NULL, 2),
(24, '2016-10-18 09:50:36', 1000, NULL, 2),
(25, '2016-10-18 09:52:36', 1000, NULL, 2),
(26, '2016-10-18 10:25:32', 1000, NULL, 2),
(27, '2016-10-18 10:37:07', 1000, NULL, 2),
(28, '2016-10-18 10:41:10', 1000, NULL, 2),
(29, '2016-10-18 10:44:24', 1000, NULL, 2);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `PowerUp`
--

CREATE TABLE `PowerUp` (
  `PowerUpID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `PowerUp`
--

INSERT INTO `PowerUp` (`PowerUpID`, `Name`, `Description`) VALUES
(1, 'Extra Punten', 'Krijg bij de volgende vraag extra punten'),
(2, 'Fout Schild', 'Je kan deze ronde niet falen!');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Profile`
--

CREATE TABLE `Profile` (
  `ProfileID` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(66) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Nickname` varchar(45) NOT NULL,
  `Wins` int(11) DEFAULT '0',
  `Losses` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `Profile`
--

INSERT INTO `Profile` (`ProfileID`, `Email`, `Password`, `Name`, `Nickname`, `Wins`, `Losses`) VALUES
(1, 'Henk@email.henk.nl', 'Wachtwoord', 'Henk', 'Henkie01', 10, 20),
(2, 'test@email.com', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'Test', 'testnickname1234', 11, 21),
(3, 'je@moeder.nl', '80178f789b33663830a7d2d5a049e9a14d445c330c43b4eee89bfb26ac3b8059', 'testington', 'testnickname1234', NULL, NULL),
(4, 'je@mams.nl', 'c1ff7eebbc393133fb9c6114627a3f6960398bb8d5ece9d8f6dce890bcc12d66', 'lol', 'lol', NULL, NULL),
(5, 'daan_tuller@hotmail.com', '311fe3feed16b9cd8df0f8b1517be5cb86048707df4889ba8dc37d4d68866d02', 'McYolo', 'yoloswag9001', NULL, NULL),
(6, 'test@je.moeder', 'c1ff7eebbc393133fb9c6114627a3f6960398bb8d5ece9d8f6dce890bcc12d66', 'mams', 'moeder', NULL, NULL),
(7, 'asfsdfasdfsadf', 'c1ff7eebbc393133fb9c6114627a3f6960398bb8d5ece9d8f6dce890bcc12d66', 'teeeest', 'test', NULL, NULL),
(8, 'hahaha', '8693873cd8f8a2d9c7c596477180f851e525f4eaf55a4f637b445cb442a5e340', 'ok', 'lol', NULL, NULL),
(9, 'sdfsdfsdfsdfsdf', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', '', '', NULL, NULL),
(10, 'asdasdasdasdasd', 'd8a928b2043db77e340b523547bf16cb4aa483f0645fe0a290ed1f20aab76257', 'asdasd', 'ada', NULL, NULL),
(11, 'adsdfsdfJKH@HOT.COM', '333e0a1e27815d0ceee55c473fe3dc93d56c63e3bee2b3b4aee8eed6d70191a3', 'HJ', 'HG', NULL, NULL),
(12, 'qweqweq@gotas.com', 'a6f7b874ea69329372ad75353314d7bcacd8c0be365023dab195bcac015d6009', 'sdfasdf', 'sdfasdf', NULL, NULL),
(13, 'asdfdsfad@hotmail.com', '2bf439dd8d45b03291c024c43374c03c18df25e8db11fe93cdf660c5a0a6bb77', 'asdfasdf', 'asdfasdf', NULL, NULL),
(14, 'asdasfasd@hotmail.com', '5fd924625f6ab16a19cc9807c7c506ae1813490e4ba675f843d5a10e0baacdb8', 'asdasdasd', 'jkashdjksahjkds', NULL, NULL),
(15, 'asdsada@asdasd.com', 'e0f5038e94d87998794e3ee7ed8906644a29a6e656eeacc3016e9e5c8533934a', 'asdfasdfsdf', 'sdfsdfasf', NULL, NULL),
(16, 'asdasd@asd.das', '4b2b17f68975ba8c806846c5cc898070f3f62423bec9d87f2dbe844b4c14f137', 'asdasdas', 'asdasda', NULL, NULL),
(22, 'test@test.test', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'tessst', 'testtttasdasdasd', 0, 0),
(23, '1475600424626@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1868325195', 'WhatAWeirdNick', 0, 0),
(24, '1475607752803@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1860997019', 'WhatAWeirdNick', 0, 0),
(25, '1475608036075@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1860713746', 'WhatAWeirdNick', 0, 0),
(26, '1475641296825@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1827452995', 'WhatAWeirdNick', 0, 0),
(27, '1476083400861@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1385348961', 'WhatAWeirdNick', 0, 0),
(28, '1476093377053@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1375372729', 'WhatAWeirdNick', 0, 0),
(29, '1476163427403@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1305322390', 'WhatAWeirdNick', 0, 0),
(30, '1476163637303@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1305112521', 'WhatAWeirdNick', 0, 0),
(31, '1476163994692@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1304755117', 'WhatAWeirdNick', 0, 0),
(32, '1476164103611@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1304646213', 'WhatAWeirdNick', 0, 0),
(33, '1476164651315@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1304098509', 'WhatAWeirdNick', 0, 0),
(34, '1476173887973@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1294861789', 'WhatAWeirdNick', 0, 0),
(35, '1476173927158@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1294822666', 'WhatAWeirdNick', 0, 0),
(36, '1476183144600@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1285605222', 'WhatAWeirdNick', 0, 0),
(37, '1476185026496@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-1283723327', 'WhatAWeirdNick', 0, 0),
(38, 'daan@email.com', '8f447168a4a83aa70f492d927abf96843dc2b33d0e4f45d4199955ba9496135d', 'Daan', 'Daan', 0, 0),
(39, '1476718701563@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-750048258', 'WhatAWeirdNick', 0, 0),
(40, '1476718981897@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-749767925', 'WhatAWeirdNick', 0, 0),
(41, '1476719945142@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-748804680', 'WhatAWeirdNick', 0, 0),
(42, 'daan@daan.nl', '8f447168a4a83aa70f492d927abf96843dc2b33d0e4f45d4199955ba9496135d', 'Daan', 'QuizMaster', 0, 0),
(43, '1476778056321@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-690693463', 'WhatAWeirdNick', 0, 0),
(44, '1476779081322@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-689668502', 'WhatAWeirdNick', 0, 0),
(45, 'Daan@roy.nl', 'fff5672f689e69fe78a3c1615a55c5df698d85e93760124e14722a3029cacf29', 'Daan', 'DaanInRoy', 0, 0),
(46, 'IkHak@live.nl', 'e2c2cc160255ecc47f16c838e45b48ebc02c6df1f68c27a88a02674dba145b6a', 'Jorrit', 'HardcoreJorrit', 0, 0),
(47, '1476779718911@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-689030908', 'WhatAWeirdNick', 0, 0),
(48, '1476779796580@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-688953239', 'WhatAWeirdNick', 0, 0),
(49, 'royeetteveelsnoep@live.nl', 'e32c16d3e2b5d5a4ef33faef3cd16db05eeb7fdc32c641f91aa6dc34818c9c32', 'Roy', 'snoepeterroy', 0, 0),
(50, '1476780018477@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-688731347', 'WhatAWeirdNick', 0, 0),
(53, '1476781393246@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-687356577', 'WhatAWeirdNick', 0, 0),
(54, '1476782082745@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-686667074', 'WhatAWeirdNick', 0, 0),
(55, '1476782237019@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-686512803', 'WhatAWeirdNick', 0, 0),
(56, '1476782546073@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-686203750', 'WhatAWeirdNick', 0, 0),
(57, '1476783148458@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-685601364', 'WhatAWeirdNick', 0, 0),
(58, '1476783295599@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-685454223', 'WhatAWeirdNick', 0, 0),
(59, '1476783452733@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-685297090', 'WhatAWeirdNick', 0, 0),
(60, '1476783508923@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-685240899', 'WhatAWeirdNick', 0, 0),
(61, '1476783723386@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-685026436', 'WhatAWeirdNick', 0, 0),
(62, '1476783748919@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-685000905', 'WhatAWeirdNick', 0, 0),
(63, '1476784106964@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-684642858', 'WhatAWeirdNick', 0, 0),
(64, '1476784198840@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-684550982', 'WhatAWeirdNick', 0, 0),
(65, '1476784239425@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-684510394', 'WhatAWeirdNick', 0, 0),
(66, '1476784358539@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-684391283', 'WhatAWeirdNick', 0, 0),
(67, '1476786335364@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-682414459', 'WhatAWeirdNick', 0, 0),
(68, '1476787029678@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-681720145', 'WhatAWeirdNick', 0, 0),
(69, '1476787272732@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-681477087', 'WhatAWeirdNick', 0, 0),
(70, '1476787467539@test.com', '690e8ea126c616b60d6572705492457fcd9c1105e597afba9a5153c6f44f2d62', '-681282284', 'WhatAWeirdNick', 0, 0);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `ProfileAchievement`
--

CREATE TABLE `ProfileAchievement` (
  `Profile_ProfileID` int(11) NOT NULL,
  `Achievment_AchievmentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Question`
--

CREATE TABLE `Question` (
  `QuestionID` int(11) NOT NULL,
  `Question` varchar(3000) NOT NULL,
  `Answer1` varchar(45) NOT NULL,
  `Answer2` varchar(45) NOT NULL,
  `Answer3` varchar(45) NOT NULL,
  `Answer4` varchar(45) NOT NULL,
  `CorrectAnswer` int(11) NOT NULL,
  `Category_CategoryID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `Question`
--

INSERT INTO `Question` (`QuestionID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4`, `CorrectAnswer`, `Category_CategoryID`) VALUES
(52, 'In welk jaar was de slag bij Waterloo?', '1789', '1800', '1812', '1815', 4, 1),
(53, 'Naar wie is Amerika vernoemd?', 'Amerika Belluci', 'Amerigo Vespucci', 'Amerika Bertutti', 'Uncle Sam', 2, 1),
(54, 'Hoe heten de twee stichters van Rome volgens de legende?', 'Ceasar en Augustus', ' Nero en Constantijn', ' Romulus en Remus', ' Julius en Brutus', 3, 1),
(55, 'Wat is de voornaam van de ontwerper van de Eiffeltoren?', 'Jean-pierre', 'Eiffel', 'Gustav', 'Ludovico', 2, 1),
(56, 'Hoe heet de zus van Anne Frank?', 'Marietje', 'Dennis', 'Margot', 'Yentl', 3, 1),
(57, 'Wanneer eindigde de Eerste Wereldoorlog?', '1918', '1917', '1945', '1939', 1, 1),
(58, 'Waarvoor staat de afkorting VOC?', 'Verenigde Onderdrukkings Compagnie', 'Verenigde Oost-indische Compagnie', 'Verenigde Oost-Aziatische Compagnie', 'Vijandige onderdrukker Counterstrike', 2, 1),
(59, 'In welke Griekse stad werden vroeger door de Grieken de Olympische spelen gehouden?', 'Athene', 'Olympia', 'Olympus', 'Sparta', 2, 1),
(60, 'Welke dictator werd op 30 december 2006 in Bagdad gexecuteerd?', 'Osama Bin Laden', 'Mohammed Atta', 'Saddam Hussein', 'George Bush', 3, 1),
(61, 'Welk land stuurde de eerste mens de ruimte in?', 'USA', 'USSR', 'Noord-Korea', 'Trinidag & Tobago', 2, 1),
(62, 'Wie schilderde de Schreeuw?', 'Edvard Munch', 'Karel Appel', 'Rembrandt', 'Van Gogh', 1, 2),
(63, 'Wie schreef de Illias?', 'Plato', 'Vergillius', 'Homerus', 'Archimedes', 3, 2),
(64, 'Welk merk soep gebruikte Andy Warhol voor zijn kunstwerk?', 'Uncle Ben\'s', 'Cup-a-Soup', 'Unox', 'Campbell', 4, 2),
(65, 'Wie schreef Dracula?', 'Bram Stoker', 'Bram de Steker', 'Harry Mulisch', 'Paul van Loon', 1, 2),
(66, 'Wat is het meest verkochte boek?', 'De Bijbel', ' 50 Shades', ' Harry Potter', ' Lord of the Rings', 1, 2),
(67, 'Wie Schreef La Divina Commedia?', 'Michelangelo', 'Leonardo da Vinci', ' Dante Alighieri', ' Donatello', 3, 2),
(68, 'Hoeveel cirkels heeft de hel in de werken van Dante?', '6', '7', '8', '9', 4, 2),
(69, 'Welke componist was doof?', 'Beethoven', 'Mozart', 'Chopin', 'Schoppenhauer', 1, 2),
(70, 'Wie van deze schilders maakte surrealistische kunst?', 'Salvador Dali', 'Andy Warhol', 'Rembrandt van Rijn', 'Karel Appel', 1, 2),
(71, 'Hoe heet het kunstwerk in Brussel wat voor de World Expo geplaatst is?', 'Manneke Pis', 'Het Koninklijk Paleis van Brussel', ' Atomium', 'Eiffel Toren', 3, 2),
(72, 'Wie is de uitgever van de Call Of Duty franchise?', 'Activision', 'EA', 'Ubisoft', 'Valve', 1, 3),
(73, 'In welk jaar is de originele Doom game uitgekomen?', '1991', '1992', '1993', '1994', 3, 3),
(74, 'Wat is geen First Person Shooter?', 'Counterstrike', 'Unreal Tournament', 'Quake', 'Metal Slug', 4, 3),
(75, 'Naar wie is een achievement genoemd in World of Warcraft?', 'Leeroy Jenkins', 'George Clooney', 'Jack Black', 'Mr. T', 1, 3),
(76, 'Welk gamekanaal heeft de meeste subscribers op Youtube?', 'Jacksepticeye', 'Markiplier', 'Kwebbelkop', 'Pewdiepie', 4, 3),
(77, 'Wat is de meest verkochte game ooit?', 'Super Mario Bros', 'GTA5', 'Wii Sports', 'Tetris', 3, 3),
(78, 'Op welke snelweg race je met het uit 1997 uitgekomen racespel?', 'a2', 'a4', 'n56', 'a325', 1, 3),
(79, 'Wie zijn de makers van het populaire spel League of Legends?', 'Blizzard', 'Valve', 'S2Games', 'Riot Games', 4, 3),
(80, 'Hoe heet het populaire gamedistributiesysteem van Valve?', 'Steam', 'Cloud', 'Smoke', 'Origin', 1, 3),
(81, 'In welke stad speelt het spel GTA5 zich af?', 'Los Angelos', 'Los Santos', 'La Bonita', 'El Bolista', 2, 3),
(82, 'Hoe wordt de mysterieuze coureur in het programma Top Gear genoemd?', 'The Stag', 'The Stallion', 'The Stig', 'The Stick', 3, 4),
(83, 'Wat is de naam van de rode race-auto uit de animatiefilm Cars?', 'Lightning McQueen', 'Lightning McKing', 'Thunder McQueen', 'Thunder McKing', 1, 4),
(84, 'Uit welk Noord-Brabants dorp kwamen de hangjongeren uit New Kids?', 'Schijndel', 'Veghel', 'Maaskantje', 'Erp', 3, 4),
(85, 'Uit welke film komt de quote: Your mother was a hamster and your father smells of elderberries?', 'Monthy Python and the Holy Grail', 'Life of Brian', 'Grown ups', 'Snatch', 1, 4),
(86, 'Wat is de dodelijkste vloek uit de Harry Potter Films?', 'Flippendo', 'Wingardium Leviosa', 'Alohomora', 'Avada Kedavra', 4, 4),
(87, 'Welke kleur heeft de teletubbie Tinky Winky?', 'Rood', 'Paars', 'Geel', 'Groen', 2, 4),
(88, 'Hoe heet de rechter in het programma De rijdende rechter?', 'Frank Bakker', 'Frank Visser', 'Frank Stucadoor', 'Frank De Wit', 2, 4),
(89, 'Welk Game of Thrones karakter weet niks?', 'Theon Greyjoy', 'Greyworm', 'Jorah Mormont', 'Jon Snow', 4, 4),
(90, 'Wie speelt Captain Jack Sparrow in de Pirates of the Carribean films?', 'Johhnie Depp', 'Orlando Bloom', 'Jack Black', 'Daniel Radcliffe', 1, 4),
(91, 'Uit welk dorpje komt Ash Ketchum uit de Pokemon serie?', 'New Bark Town', 'Vaniville Town', 'Pallet Town', 'Littleroot Town', 3, 4),
(92, 'Wie bracht de hit Bohemian Rhapsody uit?', 'Queen', 'Prince', 'Kings of Leon', 'Queens of the Stone Age', 1, 5),
(93, 'Welke rapper heeft niet bij de rapgroep G-Unit gezeten?', '50 Cent', 'Lloyd Banks', 'Tony Yayo', 'Snoop Dogg', 4, 5),
(94, 'Welke koreaanse artiest scoorde een hit met het nummer Gangnam Style?', 'Pys', 'Psy', 'Syp', 'Spy', 2, 5),
(95, 'Met welke artiest maakte de groep The Lonely Island het nummer Jack Sparrow?', 'Micheal Bubl', 'Micheal Bay', 'Micheal Bolton', 'Justin Timberlake', 3, 5),
(96, 'Uit welk land komt de band A-Ha?', 'Zweden', 'Noorwegen', 'Denemarken', 'Ijsland', 2, 5),
(97, 'Welke Artiest maakte hits als White & Nerdy en Pretty fly for a Rabbi?', 'Weird Al', 'Weirld Pal', 'Crazy Al', 'Crazy Bob', 1, 5),
(98, 'Van welke band is Bono de leadzanger?', 'Genesis', 'The Animals', 'The Rolling Stones', 'U2', 4, 5),
(99, 'Wie maakte de muziek voor de animatiefilm Tarzan?', 'Hans Zimmer', 'Phil Collins', 'Sting', 'John Williams', 2, 5),
(100, 'Welke artiest bracht albums genaamd 19 ,21 en 25?', 'Amy Winehouse', 'Miley Cyrus', 'Selah Sue', 'Adele', 4, 5),
(101, 'Met welke Film won Hans Zimmer een Oscar voor beste filmmuziek?', 'Rain man', 'The Lion King', 'Gladiator', 'Inception', 2, 5),
(102, 'Waar werden de Zomerspelen van 1972 gehouden?', 'Frankrijk', 'Oost-Duitsland', 'West-Duitsland', 'Zwitserland', 3, 6),
(103, 'Wanneer werd Nederland Europees kampioen voetbal?', '1984', '1988', '1992', '1996', 2, 6),
(104, 'Hoe heet het stadion van NEC', 'Euroborg', 'Rat Verlegh Stadion', 'Goffertstadion', 'De Kuip', 3, 6),
(105, 'Welke Argentijnse voetballer wordt de kleine Maradonna genoemd?', 'Suarez', 'Aguero', 'Messi', 'Higuain', 3, 6),
(106, 'Hoeveel nederlanders wonnen ooit de ronde van Frankrijk?', '0', '1', '2', '3', 3, 6),
(107, 'Welke kleur begint altijd bij het schaken?', 'Wit', 'Zwart', 'Je mag zelf kiezen', 'Maakt niet uit', 1, 6),
(108, 'Welk land mag in 2022 het WK voetbal organiseren?', 'Irak', 'Arabische Emiraten', 'Qatar', 'Lebanon', 3, 6),
(109, 'Uit hoeveel veldspelers bestaat een waterpoloteam?', '4', '6', '8', '10', 2, 6),
(110, 'Op welke ondergrond wordt getennist op Wimbledon?', 'Gravel', 'Hardcourt', 'Tapijt', 'Gras', 2, 6),
(111, 'Welke sport beoefent Ireen Wst?', 'Atletiek', 'Tennis', 'Wielrennen', 'Schaatsen', 4, 6),
(112, 'Welk metaal is als enige bij kamertemperatuur vloeibaar?', 'Kwik', 'Kwek', 'Kwak', 'Kwok', 1, 7),
(113, 'Waarvoor staat de afkorting NFC?', 'Near Force Communication', 'No Firewall Connection', 'Near Field Communication', 'Near Focus Communication', 3, 7),
(114, 'Hoe heette het supercontinent wat zich tot ongeveer 250 miljoen jaar op aarde bevond?', 'Eurazi', 'Pangea', 'Laurazi', 'MegaWorld', 2, 7),
(115, 'Welke metaal veroorzaakt de kleur groen in vuurwerk?', 'Magnesium', 'Ijzer', 'Aluminium', 'Koper', 4, 7),
(116, 'Hoeveel nanometer groeit een nagel in een seconde?', '1', '2', '3', '4', 1, 7),
(117, 'Wat is de sterkste spier in het menselijk lichaam?', 'De tong', 'Biceps', 'Triceps', 'Quadriceps', 1, 7),
(118, 'Wat kan afgelezen worden op een altimeter?', 'Luchtdruk', 'Afstand', 'Gewicht', 'Hoogte', 4, 7),
(119, 'Waarvoor staat c in de vergelijking e = mc?', 'Massa', 'Energie', 'Snelheid van het licht', 'Snelheid van het object', 3, 7),
(120, 'Wat hebben Jean-Baptiste Olivier en Andr Garnerin uitgevonden?', 'De luchtballon', 'Shampoo', 'Parachute', 'Handzeep', 3, 7),
(121, 'Welke van onderstaande namen is geen schaal?', 'Richter', 'Beaufort', 'Scoville', 'Edison', 4, 7),
(122, 'In welk jaar was de slag bij Waterloo?', '1789', '1800', '1812', '1815', 4, 1),
(123, 'Naar wie is Amerika vernoemd?', 'Amerika Belluci', 'Amerigo Vespucci', 'Amerika Bertutti', 'Uncle Sam', 2, 1),
(124, 'Hoe heten de twee stichters van Rome volgens de legende?', 'Ceasar en Augustus', ' Nero en Constantijn', ' Romulus en Remus', ' Julius en Brutus', 3, 1),
(125, 'Wat is de voornaam van de ontwerper van de Eiffeltoren?', 'Jean-pierre', 'Eiffel', 'Gustav', 'Ludovico', 2, 1),
(126, 'Hoe heet de zus van Anne Frank?', 'Marietje', 'Dennis', 'Margot', 'Yentl', 3, 1),
(127, 'Wanneer eindigde de Eerste Wereldoorlog?', '1918', '1917', '1945', '1939', 1, 1),
(128, 'Waarvoor staat de afkorting VOC?', 'Verenigde Onderdrukkings Compagnie', 'Verenigde Oost-indische Compagnie', 'Verenigde Oost-Aziatische Compagnie', 'Vijandige onderdrukker Counterstrike', 2, 1),
(129, 'In welke Griekse stad werden vroeger door de Grieken de Olympische spelen gehouden?', 'Athene', 'Olympia', 'Olympus', 'Sparta', 2, 1),
(130, 'Welke dictator werd op 30 december 2006 in Bagdad gexecuteerd?', 'Osama Bin Laden', 'Mohammed Atta', 'Saddam Hussein', 'George Bush', 3, 1),
(131, 'Welk land stuurde de eerste mens de ruimte in?', 'USA', 'USSR', 'Noord-Korea', 'Trinidag & Tobago', 2, 1),
(132, 'Wie schilderde de Schreeuw?', 'Edvard Munch', 'Karel Appel', 'Rembrandt', 'Van Gogh', 1, 2),
(133, 'Wie schreef de Illias?', 'Plato', 'Vergillius', 'Homerus', 'Archimedes', 3, 2),
(134, 'Welk merk soep gebruikte Andy Warhol voor zijn kunstwerk?', 'Uncle Ben\'s', 'Cup-a-Soup', 'Unox', 'Campbell', 4, 2),
(135, 'Wie schreef Dracula?', 'Bram Stoker', 'Bram de Steker', 'Harry Mulisch', 'Paul van Loon', 1, 2),
(136, 'Wat is het meest verkochte boek?', 'De Bijbel', ' 50 Shades', ' Harry Potter', ' Lord of the Rings', 1, 2),
(137, 'Wie Schreef La Divina Commedia?', 'Michelangelo', 'Leonardo da Vinci', ' Dante Alighieri', ' Donatello', 3, 2),
(138, 'Hoeveel cirkels heeft de hel in de werken van Dante?', '6', '7', '8', '9', 4, 2),
(139, 'Welke componist was doof?', 'Beethoven', 'Mozart', 'Chopin', 'Schoppenhauer', 1, 2),
(140, 'Wie van deze schilders maakte surrealistische kunst?', 'Salvador Dali', 'Andy Warhol', 'Rembrandt van Rijn', 'Karel Appel', 1, 2),
(141, 'Hoe heet het kunstwerk in Brussel wat voor de World Expo geplaatst is?', 'Manneke Pis', 'Het Koninklijk Paleis van Brussel', ' Atomium', 'Eiffel Toren', 3, 2),
(142, 'Wie is de uitgever van de Call Of Duty franchise?', 'Activision', 'EA', 'Ubisoft', 'Valve', 1, 3),
(143, 'In welk jaar is de originele Doom game uitgekomen?', '1991', '1992', '1993', '1994', 3, 3),
(144, 'Wat is geen First Person Shooter?', 'Counterstrike', 'Unreal Tournament', 'Quake', 'Metal Slug', 4, 3),
(145, 'Naar wie is een achievement genoemd in World of Warcraft?', 'Leeroy Jenkins', 'George Clooney', 'Jack Black', 'Mr. T', 1, 3),
(146, 'Welk gamekanaal heeft de meeste subscribers op Youtube?', 'Jacksepticeye', 'Markiplier', 'Kwebbelkop', 'Pewdiepie', 4, 3),
(147, 'Wat is de meest verkochte game ooit?', 'Super Mario Bros', 'GTA5', 'Wii Sports', 'Tetris', 3, 3),
(148, 'Op welke snelweg race je met het uit 1997 uitgekomen racespel?', 'a2', 'a4', 'n56', 'a325', 1, 3),
(149, 'Wie zijn de makers van het populaire spel League of Legends?', 'Blizzard', 'Valve', 'S2Games', 'Riot Games', 4, 3),
(150, 'Hoe heet het populaire gamedistributiesysteem van Valve?', 'Steam', 'Cloud', 'Smoke', 'Origin', 1, 3),
(151, 'In welke stad speelt het spel GTA5 zich af?', 'Los Angelos', 'Los Santos', 'La Bonita', 'El Bolista', 2, 3),
(152, 'Hoe wordt de mysterieuze coureur in het programma Top Gear genoemd?', 'The Stag', 'The Stallion', 'The Stig', 'The Stick', 3, 4),
(153, 'Wat is de naam van de rode race-auto uit de animatiefilm Cars?', 'Lightning McQueen', 'Lightning McKing', 'Thunder McQueen', 'Thunder McKing', 1, 4),
(154, 'Uit welk Noord-Brabants dorp kwamen de hangjongeren uit New Kids?', 'Schijndel', 'Veghel', 'Maaskantje', 'Erp', 3, 4),
(155, 'Uit welke film komt de quote: Your mother was a hamster and your father smells of elderberries?', 'Monthy Python and the Holy Grail', 'Life of Brian', 'Grown ups', 'Snatch', 1, 4),
(156, 'Wat is de dodelijkste vloek uit de Harry Potter Films?', 'Flippendo', 'Wingardium Leviosa', 'Alohomora', 'Avada Kedavra', 4, 4),
(157, 'Welke kleur heeft de teletubbie Tinky Winky?', 'Rood', 'Paars', 'Geel', 'Groen', 2, 4),
(158, 'Hoe heet de rechter in het programma De rijdende rechter?', 'Frank Bakker', 'Frank Visser', 'Frank Stucadoor', 'Frank De Wit', 2, 4),
(159, 'Welk Game of Thrones karakter weet niks?', 'Theon Greyjoy', 'Greyworm', 'Jorah Mormont', 'Jon Snow', 4, 4),
(160, 'Wie speelt Captain Jack Sparrow in de Pirates of the Carribean films?', 'Johhnie Depp', 'Orlando Bloom', 'Jack Black', 'Daniel Radcliffe', 1, 4),
(161, 'Uit welk dorpje komt Ash Ketchum uit de Pokemon serie?', 'New Bark Town', 'Vaniville Town', 'Pallet Town', 'Littleroot Town', 3, 4),
(162, 'Wie bracht de hit Bohemian Rhapsody uit?', 'Queen', 'Prince', 'Kings of Leon', 'Queens of the Stone Age', 1, 5),
(163, 'Welke rapper heeft niet bij de rapgroep G-Unit gezeten?', '50 Cent', 'Lloyd Banks', 'Tony Yayo', 'Snoop Dogg', 4, 5),
(164, 'Welke koreaanse artiest scoorde een hit met het nummer Gangnam Style?', 'Pys', 'Psy', 'Syp', 'Spy', 2, 5),
(165, 'Met welke artiest maakte de groep The Lonely Island het nummer Jack Sparrow?', 'Micheal Bubl', 'Micheal Bay', 'Micheal Bolton', 'Justin Timberlake', 3, 5),
(166, 'Uit welk land komt de band A-Ha?', 'Zweden', 'Noorwegen', 'Denemarken', 'Ijsland', 2, 5),
(167, 'Welke Artiest maakte hits als White & Nerdy en Pretty fly for a Rabbi?', 'Weird Al', 'Weirld Pal', 'Crazy Al', 'Crazy Bob', 1, 5),
(168, 'Van welke band is Bono de leadzanger?', 'Genesis', 'The Animals', 'The Rolling Stones', 'U2', 4, 5),
(169, 'Wie maakte de muziek voor de animatiefilm Tarzan?', 'Hans Zimmer', 'Phil Collins', 'Sting', 'John Williams', 2, 5),
(170, 'Welke artiest bracht albums genaamd 19 ,21 en 25?', 'Amy Winehouse', 'Miley Cyrus', 'Selah Sue', 'Adele', 4, 5),
(171, 'Met welke Film won Hans Zimmer een Oscar voor beste filmmuziek?', 'Rain man', 'The Lion King', 'Gladiator', 'Inception', 2, 5),
(172, 'Waar werden de Zomerspelen van 1972 gehouden?', 'Frankrijk', 'Oost-Duitsland', 'West-Duitsland', 'Zwitserland', 3, 6),
(173, 'Wanneer werd Nederland Europees kampioen voetbal?', '1984', '1988', '1992', '1996', 2, 6),
(174, 'Hoe heet het stadion van NEC', 'Euroborg', 'Rat Verlegh Stadion', 'Goffertstadion', 'De Kuip', 3, 6),
(175, 'Welke Argentijnse voetballer wordt de kleine Maradonna genoemd?', 'Suarez', 'Aguero', 'Messi', 'Higuain', 3, 6),
(176, 'Hoeveel nederlanders wonnen ooit de ronde van Frankrijk?', '0', '1', '2', '3', 3, 6),
(177, 'Welke kleur begint altijd bij het schaken?', 'Wit', 'Zwart', 'Je mag zelf kiezen', 'Maakt niet uit', 1, 6),
(178, 'Welk land mag in 2022 het WK voetbal organiseren?', 'Irak', 'Arabische Emiraten', 'Qatar', 'Lebanon', 3, 6),
(179, 'Uit hoeveel veldspelers bestaat een waterpoloteam?', '4', '6', '8', '10', 2, 6),
(180, 'Op welke ondergrond wordt getennist op Wimbledon?', 'Gravel', 'Hardcourt', 'Tapijt', 'Gras', 2, 6),
(181, 'Welke sport beoefent Ireen Wst?', 'Atletiek', 'Tennis', 'Wielrennen', 'Schaatsen', 4, 6),
(182, 'Welk metaal is als enige bij kamertemperatuur vloeibaar?', 'Kwik', 'Kwek', 'Kwak', 'Kwok', 1, 7),
(183, 'Waarvoor staat de afkorting NFC?', 'Near Force Communication', 'No Firewall Connection', 'Near Field Communication', 'Near Focus Communication', 3, 7),
(184, 'Hoe heette het supercontinent wat zich tot ongeveer 250 miljoen jaar op aarde bevond?', 'Eurazi', 'Pangea', 'Laurazi', 'MegaWorld', 2, 7),
(185, 'Welke metaal veroorzaakt de kleur groen in vuurwerk?', 'Magnesium', 'Ijzer', 'Aluminium', 'Koper', 4, 7),
(186, 'Hoeveel nanometer groeit een nagel in een seconde?', '1', '2', '3', '4', 1, 7),
(187, 'Wat is de sterkste spier in het menselijk lichaam?', 'De tong', 'Biceps', 'Triceps', 'Quadriceps', 1, 7),
(188, 'Wat kan afgelezen worden op een altimeter?', 'Luchtdruk', 'Afstand', 'Gewicht', 'Hoogte', 4, 7),
(189, 'Waarvoor staat c in de vergelijking e = mc?', 'Massa', 'Energie', 'Snelheid van het licht', 'Snelheid van het object', 3, 7),
(190, 'Wat hebben Jean-Baptiste Olivier en Andr Garnerin uitgevonden?', 'De luchtballon', 'Shampoo', 'Parachute', 'Handzeep', 3, 7),
(191, 'Welke van onderstaande namen is geen schaal?', 'Richter', 'Beaufort', 'Scoville', 'Edison', 4, 7);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Statistic`
--

CREATE TABLE `Statistic` (
  `StatisticID` int(11) NOT NULL,
  `Rights` int(11) DEFAULT '0',
  `Wrong` int(11) DEFAULT '0',
  `Category_CategoryID` int(11) NOT NULL,
  `Profile_ProfileID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `Statistic`
--

INSERT INTO `Statistic` (`StatisticID`, `Rights`, `Wrong`, `Category_CategoryID`, `Profile_ProfileID`) VALUES
(1, 1, 2, 1, 22),
(2, 0, 1, 2, 22),
(3, 0, 0, 3, 22),
(4, 0, 0, 4, 22),
(5, 0, 0, 5, 22),
(6, 0, 0, 6, 22),
(7, 0, 0, 7, 22),
(8, 0, 0, 1, 23),
(9, 0, 0, 2, 23),
(10, 0, 0, 3, 23),
(11, 0, 0, 4, 23),
(12, 0, 0, 5, 23),
(13, 0, 0, 6, 23),
(14, 0, 0, 7, 23),
(15, 0, 0, 1, 24),
(16, 0, 0, 2, 24),
(17, 0, 0, 3, 24),
(18, 0, 0, 4, 24),
(19, 0, 0, 5, 24),
(20, 0, 0, 6, 24),
(21, 0, 0, 7, 24),
(22, 0, 0, 1, 25),
(23, 0, 0, 2, 25),
(24, 0, 0, 3, 25),
(25, 0, 0, 4, 25),
(26, 0, 0, 5, 25),
(27, 0, 0, 6, 25),
(28, 0, 0, 7, 25),
(29, 0, 0, 1, 26),
(30, 0, 0, 2, 26),
(31, 0, 0, 3, 26),
(32, 0, 0, 4, 26),
(33, 0, 0, 5, 26),
(34, 0, 0, 6, 26),
(35, 0, 0, 7, 26),
(36, 0, 0, 1, 27),
(37, 0, 0, 2, 27),
(38, 0, 0, 3, 27),
(39, 0, 0, 4, 27),
(40, 0, 0, 5, 27),
(41, 0, 0, 6, 27),
(42, 0, 0, 7, 27),
(43, 0, 0, 1, 28),
(44, 0, 0, 2, 28),
(45, 0, 0, 3, 28),
(46, 0, 0, 4, 28),
(47, 0, 0, 5, 28),
(48, 0, 0, 6, 28),
(49, 0, 0, 7, 28),
(50, 0, 0, 1, 29),
(51, 0, 0, 2, 29),
(52, 0, 0, 3, 29),
(53, 0, 0, 4, 29),
(54, 0, 0, 5, 29),
(55, 0, 0, 6, 29),
(56, 0, 0, 7, 29),
(57, 0, 0, 1, 30),
(58, 0, 0, 2, 30),
(59, 0, 0, 3, 30),
(60, 0, 0, 4, 30),
(61, 0, 0, 5, 30),
(62, 0, 0, 6, 30),
(63, 0, 0, 7, 30),
(64, 0, 0, 1, 31),
(65, 0, 0, 2, 31),
(66, 0, 0, 3, 31),
(67, 0, 0, 4, 31),
(68, 0, 0, 5, 31),
(69, 0, 0, 6, 31),
(70, 0, 0, 7, 31),
(71, 0, 0, 1, 32),
(72, 0, 0, 2, 32),
(73, 0, 0, 3, 32),
(74, 0, 0, 4, 32),
(75, 0, 0, 5, 32),
(76, 0, 0, 6, 32),
(77, 0, 0, 7, 32),
(78, 0, 0, 1, 33),
(79, 0, 0, 2, 33),
(80, 0, 0, 3, 33),
(81, 0, 0, 4, 33),
(82, 0, 0, 5, 33),
(83, 0, 0, 6, 33),
(84, 0, 0, 7, 33),
(85, 0, 0, 1, 34),
(86, 0, 0, 2, 34),
(87, 0, 0, 3, 34),
(88, 0, 0, 4, 34),
(89, 0, 0, 5, 34),
(90, 0, 0, 6, 34),
(91, 0, 0, 7, 34),
(92, 0, 0, 1, 35),
(93, 0, 0, 2, 35),
(94, 0, 0, 3, 35),
(95, 0, 0, 4, 35),
(96, 0, 0, 5, 35),
(97, 0, 0, 6, 35),
(98, 0, 0, 7, 35),
(99, 0, 0, 1, 36),
(100, 0, 0, 2, 36),
(101, 0, 0, 3, 36),
(102, 0, 0, 4, 36),
(103, 0, 0, 5, 36),
(104, 0, 0, 6, 36),
(105, 0, 0, 7, 36),
(106, 0, 0, 1, 37),
(107, 0, 0, 2, 37),
(108, 0, 0, 3, 37),
(109, 0, 0, 4, 37),
(110, 0, 0, 5, 37),
(111, 0, 0, 6, 37),
(112, 0, 0, 7, 37),
(113, 3, 3, 1, 38),
(114, 2, 2, 2, 38),
(115, 1, 3, 3, 38),
(116, 1, 2, 4, 38),
(117, 1, 2, 5, 38),
(118, 0, 3, 6, 38),
(119, 0, 0, 7, 38),
(120, 0, 0, 1, 40),
(121, 0, 0, 2, 40),
(122, 0, 0, 3, 40),
(123, 0, 0, 4, 40),
(124, 0, 0, 5, 40),
(125, 0, 0, 6, 40),
(126, 0, 0, 7, 40),
(127, 0, 0, 1, 41),
(128, 0, 0, 2, 41),
(129, 0, 0, 3, 41),
(130, 0, 0, 4, 41),
(131, 0, 0, 5, 41),
(132, 0, 0, 6, 41),
(133, 0, 0, 7, 41),
(134, 1, 1, 1, 42),
(135, 5, 1, 2, 42),
(136, 3, 1, 3, 42),
(137, 6, 1, 4, 42),
(138, 2, 1, 5, 42),
(139, 7, 3, 6, 42),
(140, 4, 1, 7, 42),
(141, 0, 0, 1, 43),
(142, 0, 0, 2, 43),
(143, 0, 0, 3, 43),
(144, 0, 0, 4, 43),
(145, 0, 0, 5, 43),
(146, 0, 0, 6, 43),
(147, 0, 0, 7, 43),
(148, 0, 0, 1, 44),
(149, 0, 0, 2, 44),
(150, 0, 0, 3, 44),
(151, 0, 0, 4, 44),
(152, 0, 0, 5, 44),
(153, 0, 0, 6, 44),
(154, 0, 0, 7, 44),
(155, 0, 0, 1, 45),
(156, 1, 1, 2, 45),
(157, 0, 0, 3, 45),
(158, 0, 0, 4, 45),
(159, 0, 1, 5, 45),
(160, 0, 0, 6, 45),
(161, 0, 0, 7, 45),
(162, 0, 0, 1, 46),
(163, 1, 0, 2, 46),
(164, 1, 0, 3, 46),
(165, 0, 2, 4, 46),
(166, 0, 0, 5, 46),
(167, 0, 0, 6, 46),
(168, 0, 0, 7, 46),
(169, 0, 0, 1, 47),
(170, 0, 0, 2, 47),
(171, 0, 0, 3, 47),
(172, 0, 0, 4, 47),
(173, 0, 0, 5, 47),
(174, 0, 0, 6, 47),
(175, 0, 0, 7, 47),
(176, 0, 0, 1, 48),
(177, 0, 0, 2, 48),
(178, 0, 0, 3, 48),
(179, 0, 0, 4, 48),
(180, 0, 0, 5, 48),
(181, 0, 0, 6, 48),
(182, 0, 0, 7, 48),
(183, 0, 0, 1, 49),
(184, 0, 0, 2, 49),
(185, 0, 0, 3, 49),
(186, 0, 0, 4, 49),
(187, 0, 0, 5, 49),
(188, 0, 0, 6, 49),
(189, 0, 0, 7, 49),
(190, 0, 0, 1, 50),
(191, 0, 0, 2, 50),
(192, 0, 0, 3, 50),
(193, 0, 0, 4, 50),
(194, 0, 0, 5, 50),
(195, 0, 0, 6, 50),
(196, 0, 0, 7, 50),
(197, 0, 0, 1, 1),
(198, 0, 0, 2, 1),
(199, 0, 0, 3, 1),
(200, 0, 0, 4, 1),
(201, 0, 0, 5, 1),
(202, 0, 0, 6, 1),
(203, 0, 0, 7, 1),
(204, 0, 0, 1, 1),
(205, 0, 0, 2, 1),
(206, 0, 0, 3, 1),
(207, 0, 0, 4, 1),
(208, 0, 0, 5, 1),
(209, 0, 0, 6, 1),
(210, 0, 0, 7, 1),
(211, 0, 0, 1, 53),
(212, 0, 0, 2, 53),
(213, 0, 0, 3, 53),
(214, 0, 0, 4, 53),
(215, 0, 0, 5, 53),
(216, 0, 0, 6, 53),
(217, 0, 0, 7, 53),
(218, 0, 0, 1, 54),
(219, 0, 0, 2, 54),
(220, 0, 0, 3, 54),
(221, 0, 0, 4, 54),
(222, 0, 0, 5, 54),
(223, 0, 0, 6, 54),
(224, 0, 0, 7, 54),
(225, 0, 0, 1, 55),
(226, 0, 0, 2, 55),
(227, 0, 0, 3, 55),
(228, 0, 0, 4, 55),
(229, 0, 0, 5, 55),
(230, 0, 0, 6, 55),
(231, 0, 0, 7, 55),
(232, 0, 0, 1, 56),
(233, 0, 0, 2, 56),
(234, 0, 0, 3, 56),
(235, 0, 0, 4, 56),
(236, 0, 0, 5, 56),
(237, 0, 0, 6, 56),
(238, 0, 0, 7, 56),
(239, 0, 0, 1, 57),
(240, 0, 0, 2, 57),
(241, 0, 0, 3, 57),
(242, 0, 0, 4, 57),
(243, 0, 0, 5, 57),
(244, 0, 0, 6, 57),
(245, 0, 0, 7, 57),
(246, 0, 0, 1, 58),
(247, 0, 0, 2, 58),
(248, 0, 0, 3, 58),
(249, 0, 0, 4, 58),
(250, 0, 0, 5, 58),
(251, 0, 0, 6, 58),
(252, 0, 0, 7, 58),
(253, 0, 0, 1, 59),
(254, 0, 0, 2, 59),
(255, 0, 0, 3, 59),
(256, 0, 0, 4, 59),
(257, 0, 0, 5, 59),
(258, 0, 0, 6, 59),
(259, 0, 0, 7, 59),
(260, 0, 0, 1, 60),
(261, 0, 0, 2, 60),
(262, 0, 0, 3, 60),
(263, 0, 0, 4, 60),
(264, 0, 0, 5, 60),
(265, 0, 0, 6, 60),
(266, 0, 0, 7, 60),
(267, 0, 0, 1, 61),
(268, 0, 0, 2, 61),
(269, 0, 0, 3, 61),
(270, 0, 0, 4, 61),
(271, 0, 0, 5, 61),
(272, 0, 0, 6, 61),
(273, 0, 0, 7, 61),
(274, 0, 0, 1, 62),
(275, 0, 0, 2, 62),
(276, 0, 0, 3, 62),
(277, 0, 0, 4, 62),
(278, 0, 0, 5, 62),
(279, 0, 0, 6, 62),
(280, 0, 0, 7, 62),
(281, 0, 0, 1, 63),
(282, 0, 0, 2, 63),
(283, 0, 0, 3, 63),
(284, 0, 0, 4, 63),
(285, 0, 0, 5, 63),
(286, 0, 0, 6, 63),
(287, 0, 0, 7, 63),
(288, 0, 0, 1, 64),
(289, 0, 0, 2, 64),
(290, 0, 0, 3, 64),
(291, 0, 0, 4, 64),
(292, 0, 0, 5, 64),
(293, 0, 0, 6, 64),
(294, 0, 0, 7, 64),
(295, 0, 0, 1, 65),
(296, 0, 0, 2, 65),
(297, 0, 0, 3, 65),
(298, 0, 0, 4, 65),
(299, 0, 0, 5, 65),
(300, 0, 0, 6, 65),
(301, 0, 0, 7, 65),
(302, 0, 0, 1, 66),
(303, 0, 0, 2, 66),
(304, 0, 0, 3, 66),
(305, 0, 0, 4, 66),
(306, 0, 0, 5, 66),
(307, 0, 0, 6, 66),
(308, 0, 0, 7, 66),
(309, 0, 0, 1, 67),
(310, 0, 0, 2, 67),
(311, 0, 0, 3, 67),
(312, 0, 0, 4, 67),
(313, 0, 0, 5, 67),
(314, 0, 0, 6, 67),
(315, 0, 0, 7, 67),
(316, 0, 0, 1, 68),
(317, 0, 0, 2, 68),
(318, 0, 0, 3, 68),
(319, 0, 0, 4, 68),
(320, 0, 0, 5, 68),
(321, 0, 0, 6, 68),
(322, 0, 0, 7, 68),
(323, 0, 0, 1, 69),
(324, 0, 0, 2, 69),
(325, 0, 0, 3, 69),
(326, 0, 0, 4, 69),
(327, 0, 0, 5, 69),
(328, 0, 0, 6, 69),
(329, 0, 0, 7, 69),
(330, 0, 0, 1, 70),
(331, 0, 0, 2, 70),
(332, 0, 0, 3, 70),
(333, 0, 0, 4, 70),
(334, 0, 0, 5, 70),
(335, 0, 0, 6, 70),
(336, 0, 0, 7, 70);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `Achievement`
--
ALTER TABLE `Achievement`
  ADD PRIMARY KEY (`AchievmentID`);

--
-- Indexen voor tabel `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`CategoryID`);

--
-- Indexen voor tabel `GameInfo`
--
ALTER TABLE `GameInfo`
  ADD PRIMARY KEY (`GameInfoID`),
  ADD KEY `fk_GameInfo_Profile1_idx` (`Profile_ProfileID`);

--
-- Indexen voor tabel `PowerUp`
--
ALTER TABLE `PowerUp`
  ADD PRIMARY KEY (`PowerUpID`);

--
-- Indexen voor tabel `Profile`
--
ALTER TABLE `Profile`
  ADD PRIMARY KEY (`ProfileID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexen voor tabel `ProfileAchievement`
--
ALTER TABLE `ProfileAchievement`
  ADD PRIMARY KEY (`Profile_ProfileID`,`Achievment_AchievmentID`),
  ADD KEY `fk_ProfileAchievment_Achievment1_idx` (`Achievment_AchievmentID`);

--
-- Indexen voor tabel `Question`
--
ALTER TABLE `Question`
  ADD PRIMARY KEY (`QuestionID`),
  ADD KEY `fk_Question_Category_idx` (`Category_CategoryID`);

--
-- Indexen voor tabel `Statistic`
--
ALTER TABLE `Statistic`
  ADD PRIMARY KEY (`StatisticID`),
  ADD KEY `fk_Statistic_Category1_idx` (`Category_CategoryID`),
  ADD KEY `fk_Statistic_Profile1_idx` (`Profile_ProfileID`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `Achievement`
--
ALTER TABLE `Achievement`
  MODIFY `AchievmentID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `Category`
--
ALTER TABLE `Category`
  MODIFY `CategoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT voor een tabel `GameInfo`
--
ALTER TABLE `GameInfo`
  MODIFY `GameInfoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT voor een tabel `PowerUp`
--
ALTER TABLE `PowerUp`
  MODIFY `PowerUpID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT voor een tabel `Profile`
--
ALTER TABLE `Profile`
  MODIFY `ProfileID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
--
-- AUTO_INCREMENT voor een tabel `ProfileAchievement`
--
ALTER TABLE `ProfileAchievement`
  MODIFY `Profile_ProfileID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `Question`
--
ALTER TABLE `Question`
  MODIFY `QuestionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=192;
--
-- AUTO_INCREMENT voor een tabel `Statistic`
--
ALTER TABLE `Statistic`
  MODIFY `StatisticID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=337;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `GameInfo`
--
ALTER TABLE `GameInfo`
  ADD CONSTRAINT `fk_GameInfo_Profile1` FOREIGN KEY (`Profile_ProfileID`) REFERENCES `Profile` (`ProfileID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `ProfileAchievement`
--
ALTER TABLE `ProfileAchievement`
  ADD CONSTRAINT `fk_ProfileAchievment_Achievment1` FOREIGN KEY (`Achievment_AchievmentID`) REFERENCES `Achievement` (`AchievmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ProfileAchievment_Profile1` FOREIGN KEY (`Profile_ProfileID`) REFERENCES `Profile` (`ProfileID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `Question`
--
ALTER TABLE `Question`
  ADD CONSTRAINT `fk_Question_Category` FOREIGN KEY (`Category_CategoryID`) REFERENCES `Category` (`CategoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `Statistic`
--
ALTER TABLE `Statistic`
  ADD CONSTRAINT `fk_Statistic_Category1` FOREIGN KEY (`Category_CategoryID`) REFERENCES `Category` (`CategoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Statistic_Profile1` FOREIGN KEY (`Profile_ProfileID`) REFERENCES `Profile` (`ProfileID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
