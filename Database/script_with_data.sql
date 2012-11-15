-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 14, 2012 at 05:33 PM
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
  `idAddress` int(11) NOT NULL AUTO_INCREMENT,
  `Country` int(11) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `StreetNumber` int(11) NOT NULL,
  `Village` varchar(45) NOT NULL,
  `PostalCode` int(11) NOT NULL,
  PRIMARY KEY (`idAddress`),
  UNIQUE KEY `idAddress_UNIQUE` (`idAddress`),
  KEY `fk_Address_Country_idx` (`Country`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Address`
--

INSERT INTO `Address` (`idAddress`, `Country`, `Street`, `StreetNumber`, `Village`, `PostalCode`) VALUES
(1, 1, 'Haslach', 1, 'Dornbirn', 6850);

-- --------------------------------------------------------

--
-- Table structure for table `ClubTeam`
--

CREATE TABLE IF NOT EXISTS `ClubTeam` (
  `idTeam` int(11) NOT NULL,
  PRIMARY KEY (`idTeam`),
  KEY `fk_ClubTeam_Team1_idx` (`idTeam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ClubTeam`
--

INSERT INTO `ClubTeam` (`idTeam`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `Competition`
--

CREATE TABLE IF NOT EXISTS `Competition` (
  `idCompetition` int(11) NOT NULL AUTO_INCREMENT,
  `DateFrom` date NOT NULL,
  `DateTo` date DEFAULT NULL,
  `Payment` double DEFAULT NULL,
  PRIMARY KEY (`idCompetition`),
  UNIQUE KEY `idCompetition_UNIQUE` (`idCompetition`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Competition`
--

INSERT INTO `Competition` (`idCompetition`, `DateFrom`, `DateTo`, `Payment`) VALUES
(1, '2012-11-28', '2012-11-30', 12);

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
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Country`
--

CREATE TABLE IF NOT EXISTS `Country` (
  `idCountry` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Alpha3` varchar(100) DEFAULT NULL,
  `Alpha2` varchar(100) DEFAULT NULL,
  `TLD` varchar(100) DEFAULT NULL,
  `Deutsch` varchar(100) DEFAULT NULL,
  `Espanol` varchar(100) DEFAULT NULL,
  `Francaise` varchar(100) DEFAULT NULL,
  `Italiano` varchar(100) DEFAULT NULL,
  `Portugues` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCountry`),
  UNIQUE KEY `idCountry_UNIQUE` (`idCountry`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Country`
--

INSERT INTO `Country` (`idCountry`, `Name`, `Alpha3`, `Alpha2`, `TLD`, `Deutsch`, `Espanol`, `Francaise`, `Italiano`, `Portugues`) VALUES
(1, 'Austria', 'Austria', 'Austria', 'AUT', 'Österreich', 'Austria', 'Autriche', 'Austria', 'Austria');

-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE IF NOT EXISTS `Department` (
  `idDepartment` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `DepartmentHead` int(11) NOT NULL,
  PRIMARY KEY (`idDepartment`),
  UNIQUE KEY `idDepartment_UNIQUE` (`idDepartment`),
  KEY `fk_Department_DepartmentHead1_idx` (`DepartmentHead`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Department`
--

INSERT INTO `Department` (`idDepartment`, `Name`, `Description`, `DepartmentHead`) VALUES
(1, 'Sport', 'Alle Sportarten', 0);

-- --------------------------------------------------------

--
-- Table structure for table `DepartmentHead`
--

CREATE TABLE IF NOT EXISTS `DepartmentHead` (
  `idDepartmentHead` int(11) NOT NULL,
  PRIMARY KEY (`idDepartmentHead`),
  KEY `fk_DepartmentHead_Role1_idx` (`idDepartmentHead`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DepartmentHead`
--

INSERT INTO `DepartmentHead` (`idDepartmentHead`) VALUES
(0);

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
  `idDepartmentTypeOfSport` int(11) NOT NULL AUTO_INCREMENT,
  `TypeOfSport` int(11) NOT NULL,
  `Department_idDepartment` int(11) NOT NULL,
  PRIMARY KEY (`idDepartmentTypeOfSport`),
  UNIQUE KEY `idDepartmentTypeOfSport_UNIQUE` (`idDepartmentTypeOfSport`),
  KEY `fk_DepartmentTypeOfSport_TypeOfSport1_idx` (`TypeOfSport`),
  KEY `fk_DepartmentTypeOfSport_Department1_idx` (`Department_idDepartment`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Department_has_TypeOfSport`
--

INSERT INTO `Department_has_TypeOfSport` (`idDepartmentTypeOfSport`, `TypeOfSport`, `Department_idDepartment`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `League`
--

CREATE TABLE IF NOT EXISTS `League` (
  `idLeague` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLeague`),
  UNIQUE KEY `idLeague_UNIQUE` (`idLeague`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `League`
--

INSERT INTO `League` (`idLeague`, `Name`, `Description`) VALUES
(1, 'Erste Liga', 'Die erste Liga');

-- --------------------------------------------------------

--
-- Table structure for table `Match`
--

CREATE TABLE IF NOT EXISTS `Match` (
  `idMatch` int(11) NOT NULL AUTO_INCREMENT,
  `Hometeam` int(11) NOT NULL,
  `Foreignteam` int(11) NOT NULL,
  `Matchresult` int(11) NOT NULL,
  `Competition` int(11) NOT NULL,
  `DateFrom` date NOT NULL,
  `DateTo` date DEFAULT NULL,
  PRIMARY KEY (`idMatch`),
  UNIQUE KEY `idMatch_UNIQUE` (`idMatch`),
  KEY `fk_Match_Team1_idx` (`Hometeam`),
  KEY `fk_Match_Team2_idx` (`Foreignteam`),
  KEY `fk_Match_Matchresult1_idx` (`Matchresult`),
  KEY `fk_Match_Competition1_idx` (`Competition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Matchresult`
--

CREATE TABLE IF NOT EXISTS `Matchresult` (
  `idMatchresult` int(11) NOT NULL AUTO_INCREMENT,
  `PointsHometeam` double NOT NULL,
  `PointsForeignteam` double NOT NULL,
  PRIMARY KEY (`idMatchresult`),
  UNIQUE KEY `idMatchresult_UNIQUE` (`idMatchresult`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Member`
--

CREATE TABLE IF NOT EXISTS `Member` (
  `idMember` int(11) NOT NULL AUTO_INCREMENT,
  `Prename` varchar(45) NOT NULL,
  `Lastname` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Address` int(11) NOT NULL,
  `MemberFrom` date NOT NULL,
  `MemberTo` date DEFAULT NULL,
  `Nationality` int(11) NOT NULL,
  `Telephonenumber` varchar(45) DEFAULT NULL,
  `EmailAddress` varchar(45) DEFAULT NULL,
  `Gender` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idMember`),
  UNIQUE KEY `idMember_UNIQUE` (`idMember`),
  KEY `fk_Member_Address1_idx` (`Address`),
  KEY `fk_Member_Country1_idx` (`Nationality`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Member`
--

INSERT INTO `Member` (`idMember`, `Prename`, `Lastname`, `Username`, `DateOfBirth`, `Address`, `MemberFrom`, `MemberTo`, `Nationality`, `Telephonenumber`, `EmailAddress`, `Gender`) VALUES
(1, 'Markus', 'Mohanty', 'mmo7528', '2002-11-06', 1, '2011-11-01', NULL, 1, '00426763239108', 'markus.mohanty@students.fhv.at', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Permission`
--

CREATE TABLE IF NOT EXISTS `Permission` (
  `idPermission` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPermission`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Permission`
--

INSERT INTO `Permission` (`idPermission`, `Name`, `Description`) VALUES
(1, 'admin', 'Der darf einfach alles.');

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
(0);

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
(1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Role1`
--

CREATE TABLE IF NOT EXISTS `Role1` (
  `idRole` int(11) NOT NULL,
  `Member_idMember` int(11) NOT NULL,
  PRIMARY KEY (`idRole`),
  KEY `fk_Role_Member1_idx` (`Member_idMember`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Role1`
--

INSERT INTO `Role1` (`idRole`, `Member_idMember`) VALUES
(0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Role_has_Permission`
--

CREATE TABLE IF NOT EXISTS `Role_has_Permission` (
  `Role_idRole` int(11) NOT NULL,
  `Permission_idPermission` int(11) NOT NULL,
  PRIMARY KEY (`Role_idRole`,`Permission_idPermission`),
  KEY `fk_Role_has_Permission_Permission1_idx` (`Permission_idPermission`),
  KEY `fk_Role_has_Permission_Role1_idx` (`Role_idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Role_has_Permission`
--

INSERT INTO `Role_has_Permission` (`Role_idRole`, `Permission_idPermission`) VALUES
(0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Team`
--

CREATE TABLE IF NOT EXISTS `Team` (
  `idTeam` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `League` int(11) NOT NULL,
  PRIMARY KEY (`idTeam`),
  UNIQUE KEY `idTeam_UNIQUE` (`idTeam`),
  KEY `fk_Team_League1_idx` (`League`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Team`
--

INSERT INTO `Team` (`idTeam`, `Name`, `Description`, `League`) VALUES
(1, 'SuperTeam', 'Das beste Team Ever', 1),
(2, 'Das Beste Team', 'Das Beste Team', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Team_has_Player`
--

CREATE TABLE IF NOT EXISTS `Team_has_Player` (
  `Team` int(11) NOT NULL,
  `Player` int(11) NOT NULL,
  PRIMARY KEY (`Team`,`Player`),
  KEY `fk_Team_has_Member_ClubTeam1_idx` (`Team`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Trainer`
--

CREATE TABLE IF NOT EXISTS `Trainer` (
  `idTrainer` int(11) NOT NULL,
  PRIMARY KEY (`idTrainer`),
  KEY `fk_Trainer_Role1_idx` (`idTrainer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Trainer`
--

INSERT INTO `Trainer` (`idTrainer`) VALUES
(0);

-- --------------------------------------------------------

--
-- Table structure for table `TypeOfSport`
--

CREATE TABLE IF NOT EXISTS `TypeOfSport` (
  `idTypeOfSport` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTypeOfSport`),
  UNIQUE KEY `idTypeOfSport_UNIQUE` (`idTypeOfSport`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `TypeOfSport`
--

INSERT INTO `TypeOfSport` (`idTypeOfSport`, `Name`, `Description`) VALUES
(1, 'Fußball', 'Fußball');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Address`
--
ALTER TABLE `Address`
  ADD CONSTRAINT `fk_Address_Country0` FOREIGN KEY (`Country`) REFERENCES `Country` (`idCountry`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ClubTeam`
--
ALTER TABLE `ClubTeam`
  ADD CONSTRAINT `fk_ClubTeam_Team1` FOREIGN KEY (`idTeam`) REFERENCES `Team` (`idTeam`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Competition_has_Team`
--
ALTER TABLE `Competition_has_Team`
  ADD CONSTRAINT `fk_Competition_has_Team_Competition10` FOREIGN KEY (`Competition`) REFERENCES `Competition` (`idCompetition`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Competition_has_Team_Team10` FOREIGN KEY (`Team`) REFERENCES `Team` (`idTeam`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Department`
--
ALTER TABLE `Department`
  ADD CONSTRAINT `fk_Department_DepartmentHead1` FOREIGN KEY (`DepartmentHead`) REFERENCES `DepartmentHead` (`idDepartmentHead`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `DepartmentHead`
--
ALTER TABLE `DepartmentHead`
  ADD CONSTRAINT `fk_DepartmentHead_Role10` FOREIGN KEY (`idDepartmentHead`) REFERENCES `Role1` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Department_has_Team`
--
ALTER TABLE `Department_has_Team`
  ADD CONSTRAINT `fk_DepartmentTeam_Department1` FOREIGN KEY (`Department`) REFERENCES `Department` (`idDepartment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DepartmentTeam_ClubTeam1` FOREIGN KEY (`Team`) REFERENCES `ClubTeam` (`idTeam`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Department_has_TypeOfSport`
--
ALTER TABLE `Department_has_TypeOfSport`
  ADD CONSTRAINT `fk_DepartmentTypeOfSport_TypeOfSport1` FOREIGN KEY (`TypeOfSport`) REFERENCES `TypeOfSport` (`idTypeOfSport`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DepartmentTypeOfSport_Department1` FOREIGN KEY (`Department_idDepartment`) REFERENCES `Department` (`idDepartment`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Match`
--
ALTER TABLE `Match`
  ADD CONSTRAINT `fk_Match_Team10` FOREIGN KEY (`Hometeam`) REFERENCES `Team` (`idTeam`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Match_Team20` FOREIGN KEY (`Foreignteam`) REFERENCES `Team` (`idTeam`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Match_Matchresult10` FOREIGN KEY (`Matchresult`) REFERENCES `Matchresult` (`idMatchresult`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Match_Competition10` FOREIGN KEY (`Competition`) REFERENCES `Competition` (`idCompetition`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Member`
--
ALTER TABLE `Member`
  ADD CONSTRAINT `fk_Member_Address10` FOREIGN KEY (`Address`) REFERENCES `Address` (`idAddress`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Member_Country10` FOREIGN KEY (`Nationality`) REFERENCES `Country` (`idCountry`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Player`
--
ALTER TABLE `Player`
  ADD CONSTRAINT `fk_Player_Role1` FOREIGN KEY (`Role_idRole`) REFERENCES `Role1` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Player_has_TypeOfSport`
--
ALTER TABLE `Player_has_TypeOfSport`
  ADD CONSTRAINT `fk_Member_has_TypeOfSport_TypeOfSport1` FOREIGN KEY (`TypeOfSport_idTypeOfSport`) REFERENCES `TypeOfSport` (`idTypeOfSport`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Player_has_TypeOfSport_Player1` FOREIGN KEY (`Player_Role_idRole`) REFERENCES `Player` (`Role_idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Role1`
--
ALTER TABLE `Role1`
  ADD CONSTRAINT `fk_Role_Member1` FOREIGN KEY (`Member_idMember`) REFERENCES `Member` (`idMember`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Role_has_Permission`
--
ALTER TABLE `Role_has_Permission`
  ADD CONSTRAINT `fk_Role_has_Permission_Role1` FOREIGN KEY (`Role_idRole`) REFERENCES `Role1` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Role_has_Permission_Permission1` FOREIGN KEY (`Permission_idPermission`) REFERENCES `Permission` (`idPermission`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Team`
--
ALTER TABLE `Team`
  ADD CONSTRAINT `fk_Team_League10` FOREIGN KEY (`League`) REFERENCES `League` (`idLeague`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Team_has_Player`
--
ALTER TABLE `Team_has_Player`
  ADD CONSTRAINT `fk_Team_has_Member_ClubTeam1` FOREIGN KEY (`Team`) REFERENCES `ClubTeam` (`idTeam`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Team_has_Trainer`
--
ALTER TABLE `Team_has_Trainer`
  ADD CONSTRAINT `fk_Team_has_Trainer_ClubTeam1` FOREIGN KEY (`Team`) REFERENCES `ClubTeam` (`idTeam`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Team_has_Trainer_Trainer1` FOREIGN KEY (`Trainer`) REFERENCES `Trainer` (`idTrainer`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Trainer`
--
ALTER TABLE `Trainer`
  ADD CONSTRAINT `fk_Trainer_Role10` FOREIGN KEY (`idTrainer`) REFERENCES `Role1` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
