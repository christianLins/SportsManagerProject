-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 19, 2012 at 01:31 PM
-- Server version: 5.5.24
-- PHP Version: 5.3.10-1ubuntu3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `SportClubManagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `Address`
--

CREATE TABLE IF NOT EXISTS `Address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Country` int(11) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `StreetNumber` int(11) NOT NULL,
  `Village` varchar(45) NOT NULL,
  `PostalCode` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idAddress_UNIQUE` (`id`),
  KEY `fk_Address_Country_idx` (`Country`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Address`
--

INSERT INTO `Address` (`id`, `Country`, `Street`, `StreetNumber`, `Village`, `PostalCode`) VALUES
(1, 1, 'Haslach', 1, 'Dornbirn', 6850),
(2, 2, 'Nalco Nagar', 46, 'Bhubaneswar', 751009);

-- --------------------------------------------------------

--
-- Table structure for table `Administrator`
--

CREATE TABLE IF NOT EXISTS `Administrator` (
  `Role_idRole` int(11) NOT NULL,
  PRIMARY KEY (`Role_idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Administrator`
--

INSERT INTO `Administrator` (`Role_idRole`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `Caretaker`
--

CREATE TABLE IF NOT EXISTS `Caretaker` (
  `Role_idRole` int(11) NOT NULL,
  PRIMARY KEY (`Role_idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Caretaker`
--

INSERT INTO `Caretaker` (`Role_idRole`) VALUES
(2);

-- --------------------------------------------------------

--
-- Table structure for table `ClubTeam`
--

CREATE TABLE IF NOT EXISTS `ClubTeam` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ClubTeam_Team1_idx` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ClubTeam`
--

INSERT INTO `ClubTeam` (`id`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `Competition`
--

CREATE TABLE IF NOT EXISTS `Competition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DateFrom` date NOT NULL,
  `DateTo` date DEFAULT NULL,
  `Payment` double DEFAULT NULL,
  `League_idLeague` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `Address` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idCompetition_UNIQUE` (`id`),
  KEY `fk_Competition_League1_idx` (`League_idLeague`),
  KEY `fk_Competition_Address1_idx` (`Address`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Competition`
--

INSERT INTO `Competition` (`id`, `DateFrom`, `DateTo`, `Payment`, `League_idLeague`, `Name`, `Description`, `Address`) VALUES
(1, '2013-02-03', '2013-02-28', 1000000, 1, 'Sau teure Veranstaltung', 'Viel Prominenz kostet Geld', 2);

-- --------------------------------------------------------

--
-- Table structure for table `Competition_has_Team`
--

CREATE TABLE IF NOT EXISTS `Competition_has_Team` (
  `Competition` int(11) NOT NULL,
  `Team` int(11) NOT NULL,
  PRIMARY KEY (`Competition`,`Team`),
  KEY `fk_Competition_has_Team_Team1_idx` (`Team`),
  KEY `fk_Competition_has_Team_Competition1_idx` (`Competition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Competition_has_Team`
--

INSERT INTO `Competition_has_Team` (`Competition`, `Team`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Country`
--

CREATE TABLE IF NOT EXISTS `Country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Alpha3` varchar(100) DEFAULT NULL,
  `Alpha2` varchar(100) DEFAULT NULL,
  `TLD` varchar(100) DEFAULT NULL,
  `Deutsch` varchar(100) DEFAULT NULL,
  `Espanol` varchar(100) DEFAULT NULL,
  `Francaise` varchar(100) DEFAULT NULL,
  `Italiano` varchar(100) DEFAULT NULL,
  `Portugues` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idCountry_UNIQUE` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Country`
--

INSERT INTO `Country` (`id`, `Name`, `Alpha3`, `Alpha2`, `TLD`, `Deutsch`, `Espanol`, `Francaise`, `Italiano`, `Portugues`) VALUES
(1, 'Österreich', 'AUT', 'AT', 'AUT', 'Österreich', 'Austria', 'Austria', 'Austria', 'Austria'),
(2, 'Indien', 'IND', 'IN', 'IND', 'Indien', 'India', 'India', 'India', 'India');

-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE IF NOT EXISTS `Department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idDepartment_UNIQUE` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Department`
--

INSERT INTO `Department` (`id`, `Name`, `Description`) VALUES
(1, 'Fußball', 'Fußball');

-- --------------------------------------------------------

--
-- Table structure for table `DepartmentHead`
--

CREATE TABLE IF NOT EXISTS `DepartmentHead` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_DepartmentHead_Role1_idx` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DepartmentHead`
--

INSERT INTO `DepartmentHead` (`id`) VALUES
(5);

-- --------------------------------------------------------

--
-- Table structure for table `Department_has_Team`
--

CREATE TABLE IF NOT EXISTS `Department_has_Team` (
  `Department` int(11) NOT NULL,
  `Team` int(11) NOT NULL,
  PRIMARY KEY (`Department`,`Team`),
  KEY `fk_DepartmentTeam_Department1_idx` (`Department`),
  KEY `fk_DepartmentTeam_ClubTeam1_idx` (`Team`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Department_has_Team`
--

INSERT INTO `Department_has_Team` (`Department`, `Team`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Department_has_TypeOfSport`
--

CREATE TABLE IF NOT EXISTS `Department_has_TypeOfSport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TypeOfSport` int(11) NOT NULL,
  `Department_idDepartment` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idDepartmentTypeOfSport_UNIQUE` (`id`),
  KEY `fk_DepartmentTypeOfSport_TypeOfSport1_idx` (`TypeOfSport`),
  KEY `fk_DepartmentTypeOfSport_Department1_idx` (`Department_idDepartment`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Department_has_TypeOfSport`
--

INSERT INTO `Department_has_TypeOfSport` (`id`, `TypeOfSport`, `Department_idDepartment`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `League`
--

CREATE TABLE IF NOT EXISTS `League` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `TypeOfSport_idTypeOfSport` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idLeague_UNIQUE` (`id`),
  KEY `fk_League_TypeOfSport1_idx` (`TypeOfSport_idTypeOfSport`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `League`
--

INSERT INTO `League` (`id`, `Name`, `Description`, `TypeOfSport_idTypeOfSport`) VALUES
(1, 'Erste Liga', 'Die erste Liga', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Match`
--

CREATE TABLE IF NOT EXISTS `Match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Hometeam` int(11) NOT NULL,
  `Foreignteam` int(11) NOT NULL,
  `Matchresult` int(11) NOT NULL,
  `Competition` int(11) NOT NULL,
  `DateFrom` date NOT NULL,
  `DateTo` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idMatch_UNIQUE` (`id`),
  KEY `fk_Match_Team1_idx` (`Hometeam`),
  KEY `fk_Match_Team2_idx` (`Foreignteam`),
  KEY `fk_Match_Matchresult1_idx` (`Matchresult`),
  KEY `fk_Match_Competition1_idx` (`Competition`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Match`
--

INSERT INTO `Match` (`id`, `Hometeam`, `Foreignteam`, `Matchresult`, `Competition`, `DateFrom`, `DateTo`) VALUES
(3, 1, 2, 1, 1, '2013-02-06', '2013-02-07'),
(4, 2, 1, 2, 1, '2013-02-13', '2013-02-14');

-- --------------------------------------------------------

--
-- Table structure for table `Matchresult`
--

CREATE TABLE IF NOT EXISTS `Matchresult` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `PointsHometeam` double NOT NULL,
  `PointsForeignteam` double NOT NULL,
  `Final` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idMatchresult_UNIQUE` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Matchresult`
--

INSERT INTO `Matchresult` (`id`, `PointsHometeam`, `PointsForeignteam`, `Final`) VALUES
(1, 0, 1, 0),
(2, 0, 3, 0),
(3, 1, 0, 1),
(4, 0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Member`
--

CREATE TABLE IF NOT EXISTS `Member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Prename` varchar(45) NOT NULL,
  `Lastname` varchar(45) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Address` int(11) NOT NULL,
  `MemberFrom` date NOT NULL,
  `MemberTo` date DEFAULT NULL,
  `Nationality` int(11) NOT NULL,
  `Telephonenumber` varchar(45) DEFAULT NULL,
  `EmailAddress` varchar(45) DEFAULT NULL,
  `Gender` tinyint(1) DEFAULT NULL,
  `Username` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idMember_UNIQUE` (`id`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  KEY `fk_Member_Address1_idx` (`Address`),
  KEY `fk_Member_Country1_idx` (`Nationality`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `Member`
--

INSERT INTO `Member` (`id`, `Prename`, `Lastname`, `DateOfBirth`, `Address`, `MemberFrom`, `MemberTo`, `Nationality`, `Telephonenumber`, `EmailAddress`, `Gender`, `Username`) VALUES
(1, 'Lucia', 'Amann', '1989-11-10', 2, '2002-11-04', NULL, 1, NULL, NULL, 1, 'lam1977'),
(2, 'Markus', 'Mohanty', '1988-04-14', 1, '2007-11-01', NULL, 2, NULL, NULL, 0, 'mmo7528'),
(3, 'Thomas', 'Schwarz', '1988-01-29', 1, '2006-11-05', NULL, 1, NULL, NULL, 0, 'tsc2526'),
(4, 'Christian', 'Lins', '1987-08-09', 1, '2002-11-03', NULL, 1, NULL, NULL, 0, 'cli1929'),
(5, 'Dominik', 'Gregotsch', '1990-05-05', 2, '2002-11-04', NULL, 2, NULL, NULL, 0, 'dgr9323'),
(6, 'Thomas', 'Feilhauer', '1965-11-01', 1, '1990-11-06', NULL, 2, NULL, NULL, 0, 'tf-test');

-- --------------------------------------------------------

--
-- Table structure for table `Member_has_Role`
--

CREATE TABLE IF NOT EXISTS `Member_has_Role` (
  `Member_idMember` int(11) NOT NULL,
  `Role_idRole` int(11) NOT NULL,
  PRIMARY KEY (`Member_idMember`,`Role_idRole`),
  KEY `fk_Member_has_Role_Role1_idx` (`Role_idRole`),
  KEY `fk_Member_has_Role_Member1_idx` (`Member_idMember`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Member_has_Role`
--

INSERT INTO `Member_has_Role` (`Member_idMember`, `Role_idRole`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(5, 3),
(6, 3),
(6, 5);

-- --------------------------------------------------------

--
-- Table structure for table `Permission`
--

CREATE TABLE IF NOT EXISTS `Permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `Permission`
--

INSERT INTO `Permission` (`id`, `Name`, `Description`) VALUES
(1, 'change', 'verändern'),
(2, 'view', 'ansehen'),
(3, 'delete', 'löschen');

-- --------------------------------------------------------

--
-- Table structure for table `Player`
--

CREATE TABLE IF NOT EXISTS `Player` (
  `Role_idRole` int(11) NOT NULL,
  PRIMARY KEY (`Role_idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Player`
--

INSERT INTO `Player` (`Role_idRole`) VALUES
(3);

-- --------------------------------------------------------

--
-- Table structure for table `Player_has_TypeOfSport`
--

CREATE TABLE IF NOT EXISTS `Player_has_TypeOfSport` (
  `TypeOfSport_idTypeOfSport` int(11) NOT NULL,
  `Player_Role_idRole` int(11) NOT NULL,
  PRIMARY KEY (`TypeOfSport_idTypeOfSport`,`Player_Role_idRole`),
  KEY `fk_Member_has_TypeOfSport_TypeOfSport1_idx` (`TypeOfSport_idTypeOfSport`),
  KEY `fk_Player_has_TypeOfSport_Player1_idx` (`Player_Role_idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Player_has_TypeOfSport`
--

INSERT INTO `Player_has_TypeOfSport` (`TypeOfSport_idTypeOfSport`, `Player_Role_idRole`) VALUES
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `MemberRole`
--

CREATE TABLE IF NOT EXISTS `MemberRole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `MemberRole`
--

INSERT INTO `MemberRole` (`id`, `Name`, `Description`) VALUES
(1, 'Admin', 'Admin'),
(2, 'Caretaker', 'The Waterboy'),
(3, 'Fußballer', 'Fußballspieler'),
(4, 'Fußballtrainer', 'Fußballtrainer'),
(5, 'Departmenthead', 'Departmenthead');

-- --------------------------------------------------------

--
-- Table structure for table `Role_has_Permission`
--

CREATE TABLE IF NOT EXISTS `Role_has_Permission` (
  `Role_idRole` int(11) NOT NULL,
  `Permission_idPermission` int(11) NOT NULL,
  PRIMARY KEY (`Role_idRole`,`Permission_idPermission`),
  KEY `fk_Role_has_Permisssion_Permisssion1_idx` (`Permission_idPermission`),
  KEY `fk_Role_has_Permisssion_Role1_idx` (`Role_idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Role_has_Permission`
--

INSERT INTO `Role_has_Permission` (`Role_idRole`, `Permission_idPermission`) VALUES
(1, 1),
(4, 1),
(5, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(1, 3),
(4, 3),
(5, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Team`
--

CREATE TABLE IF NOT EXISTS `Team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `League_idLeague` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idTeam_UNIQUE` (`id`),
  KEY `fk_Team_League1_idx` (`League_idLeague`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Team`
--

INSERT INTO `Team` (`id`, `Name`, `Description`, `League_idLeague`) VALUES
(1, 'Das beste Team', 'Das allerbeste Team aller Zeiten', 1),
(2, 'Ein Auswärtsteam', 'Das aller schlechteste Team', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Team_has_Player`
--

CREATE TABLE IF NOT EXISTS `Team_has_Player` (
  `Team` int(11) NOT NULL,
  `Player` int(11) NOT NULL,
  PRIMARY KEY (`Team`,`Player`),
  KEY `fk_Team_has_Member_ClubTeam1_idx` (`Team`),
  KEY `Player` (`Player`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Team_has_Player`
--

INSERT INTO `Team_has_Player` (`Team`, `Player`) VALUES
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Team_has_Trainer`
--

CREATE TABLE IF NOT EXISTS `Team_has_Trainer` (
  `Team` int(11) NOT NULL,
  `Trainer` int(11) NOT NULL,
  PRIMARY KEY (`Team`,`Trainer`),
  KEY `fk_Team_has_Trainer_ClubTeam1_idx` (`Team`),
  KEY `fk_Team_has_Trainer_Trainer1_idx` (`Trainer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Team_has_Trainer`
--

INSERT INTO `Team_has_Trainer` (`Team`, `Trainer`) VALUES
(1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `Trainer`
--

CREATE TABLE IF NOT EXISTS `Trainer` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Trainer_Role1_idx` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Trainer`
--

INSERT INTO `Trainer` (`id`) VALUES
(4);

-- --------------------------------------------------------

--
-- Table structure for table `TypeOfSport`
--

CREATE TABLE IF NOT EXISTS `TypeOfSport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idTypeOfSport_UNIQUE` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `TypeOfSport`
--

INSERT INTO `TypeOfSport` (`id`, `Name`, `Description`) VALUES
(1, 'Fußball', 'Ballsport, mit Fuß gespielt');

-- --------------------------------------------------------

--
-- Table structure for table `TypeOfSport_has_Trainer`
--

CREATE TABLE IF NOT EXISTS `TypeOfSport_has_Trainer` (
  `TypeOfSport_idTypeOfSport` int(11) NOT NULL,
  `Trainer_idTrainer` int(11) NOT NULL,
  PRIMARY KEY (`TypeOfSport_idTypeOfSport`,`Trainer_idTrainer`),
  KEY `fk_TypeOfSport_has_Trainer_Trainer1_idx` (`Trainer_idTrainer`),
  KEY `fk_TypeOfSport_has_Trainer_TypeOfSport1_idx` (`TypeOfSport_idTypeOfSport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TypeOfSport_has_Trainer`
--

INSERT INTO `TypeOfSport_has_Trainer` (`TypeOfSport_idTypeOfSport`, `Trainer_idTrainer`) VALUES
(1, 4);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Address`
--
ALTER TABLE `Address`
  ADD CONSTRAINT `fk_Address_Country0` FOREIGN KEY (`Country`) REFERENCES `Country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Administrator`
--
ALTER TABLE `Administrator`
  ADD CONSTRAINT `fk_Admin_Role1` FOREIGN KEY (`Role_idRole`) REFERENCES `MemberRole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Caretaker`
--
ALTER TABLE `Caretaker`
  ADD CONSTRAINT `fk_Caretaker_Role1` FOREIGN KEY (`Role_idRole`) REFERENCES `MemberRole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ClubTeam`
--
ALTER TABLE `ClubTeam`
  ADD CONSTRAINT `fk_ClubTeam_Team1` FOREIGN KEY (`id`) REFERENCES `Team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Competition`
--
ALTER TABLE `Competition`
  ADD CONSTRAINT `fk_Competition_League1` FOREIGN KEY (`League_idLeague`) REFERENCES `League` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Competition_Address1` FOREIGN KEY (`Address`) REFERENCES `Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Competition_has_Team`
--
ALTER TABLE `Competition_has_Team`
  ADD CONSTRAINT `fk_Competition_has_Team_Competition10` FOREIGN KEY (`Competition`) REFERENCES `Competition` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Competition_has_Team_Team10` FOREIGN KEY (`Team`) REFERENCES `Team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `DepartmentHead`
--
ALTER TABLE `DepartmentHead`
  ADD CONSTRAINT `fk_DepartmentHead_Role10` FOREIGN KEY (`id`) REFERENCES `MemberRole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Department_has_Team`
--
ALTER TABLE `Department_has_Team`
  ADD CONSTRAINT `fk_DepartmentTeam_Department1` FOREIGN KEY (`Department`) REFERENCES `Department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DepartmentTeam_ClubTeam1` FOREIGN KEY (`Team`) REFERENCES `ClubTeam` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Department_has_TypeOfSport`
--
ALTER TABLE `Department_has_TypeOfSport`
  ADD CONSTRAINT `fk_DepartmentTypeOfSport_TypeOfSport1` FOREIGN KEY (`TypeOfSport`) REFERENCES `TypeOfSport` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DepartmentTypeOfSport_Department1` FOREIGN KEY (`Department_idDepartment`) REFERENCES `Department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `League`
--
ALTER TABLE `League`
  ADD CONSTRAINT `fk_League_TypeOfSport1` FOREIGN KEY (`TypeOfSport_idTypeOfSport`) REFERENCES `TypeOfSport` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Match`
--
ALTER TABLE `Match`
  ADD CONSTRAINT `fk_Match_Team10` FOREIGN KEY (`Hometeam`) REFERENCES `Team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Match_Team20` FOREIGN KEY (`Foreignteam`) REFERENCES `Team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Match_Matchresult10` FOREIGN KEY (`Matchresult`) REFERENCES `Matchresult` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Match_Competition10` FOREIGN KEY (`Competition`) REFERENCES `Competition` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Member`
--
ALTER TABLE `Member`
  ADD CONSTRAINT `fk_Member_Address10` FOREIGN KEY (`Address`) REFERENCES `Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Member_Country10` FOREIGN KEY (`Nationality`) REFERENCES `Country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Member_has_Role`
--
ALTER TABLE `Member_has_Role`
  ADD CONSTRAINT `fk_Member_has_Role_Member1` FOREIGN KEY (`Member_idMember`) REFERENCES `Member` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Member_has_Role_Role1` FOREIGN KEY (`Role_idRole`) REFERENCES `MemberRole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Player`
--
ALTER TABLE `Player`
  ADD CONSTRAINT `fk_Player_Role1` FOREIGN KEY (`Role_idRole`) REFERENCES `MemberRole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Player_has_TypeOfSport`
--
ALTER TABLE `Player_has_TypeOfSport`
  ADD CONSTRAINT `fk_Member_has_TypeOfSport_TypeOfSport1` FOREIGN KEY (`TypeOfSport_idTypeOfSport`) REFERENCES `TypeOfSport` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Player_has_TypeOfSport_Player1` FOREIGN KEY (`Player_Role_idRole`) REFERENCES `Player` (`Role_idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Role_has_Permission`
--
ALTER TABLE `Role_has_Permission`
  ADD CONSTRAINT `fk_Role_has_Permisssion_Role1` FOREIGN KEY (`Role_idRole`) REFERENCES `MemberRole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Role_has_Permisssion_Permisssion1` FOREIGN KEY (`Permission_idPermission`) REFERENCES `Permission` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Team`
--
ALTER TABLE `Team`
  ADD CONSTRAINT `fk_Team_League1` FOREIGN KEY (`League_idLeague`) REFERENCES `League` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Team_has_Player`
--
ALTER TABLE `Team_has_Player`
  ADD CONSTRAINT `Team_has_Player_ibfk_1` FOREIGN KEY (`Player`) REFERENCES `Player` (`Role_idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Team_has_Member_ClubTeam1` FOREIGN KEY (`Team`) REFERENCES `ClubTeam` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Team_has_Trainer`
--
ALTER TABLE `Team_has_Trainer`
  ADD CONSTRAINT `fk_Team_has_Trainer_ClubTeam1` FOREIGN KEY (`Team`) REFERENCES `ClubTeam` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Team_has_Trainer_Trainer1` FOREIGN KEY (`Trainer`) REFERENCES `Trainer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Trainer`
--
ALTER TABLE `Trainer`
  ADD CONSTRAINT `fk_Trainer_Role10` FOREIGN KEY (`id`) REFERENCES `MemberRole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `TypeOfSport_has_Trainer`
--
ALTER TABLE `TypeOfSport_has_Trainer`
  ADD CONSTRAINT `fk_TypeOfSport_has_Trainer_TypeOfSport1` FOREIGN KEY (`TypeOfSport_idTypeOfSport`) REFERENCES `TypeOfSport` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_TypeOfSport_has_Trainer_Trainer1` FOREIGN KEY (`Trainer_idTrainer`) REFERENCES `Trainer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
