SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `SportClubManagement` ;
CREATE SCHEMA IF NOT EXISTS `SportClubManagement` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `SportClubManagement` ;

-- -----------------------------------------------------
-- Table `SportClubManagement`.`MemberRole`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`MemberRole` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`MemberRole` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`DepartmentHead`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`DepartmentHead` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`DepartmentHead` (
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_DepartmentHead_MemberRole1`
    FOREIGN KEY (`id` )
    REFERENCES `SportClubManagement`.`MemberRole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Department` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Department` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  `DepartmentHead_id` INT NOT NULL ,
  PRIMARY KEY (`id`, `DepartmentHead_id`) ,
  UNIQUE INDEX `idDepartment_UNIQUE` (`id` ASC) ,
  INDEX `fk_Department_DepartmentHead1_idx` (`DepartmentHead_id` ASC) ,
  CONSTRAINT `fk_Department_DepartmentHead1`
    FOREIGN KEY (`DepartmentHead_id` )
    REFERENCES `SportClubManagement`.`DepartmentHead` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`TypeOfSport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`TypeOfSport` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`TypeOfSport` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idTypeOfSport_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Department_has_TypeOfSport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Department_has_TypeOfSport` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Department_has_TypeOfSport` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `TypeOfSport` INT NOT NULL ,
  `Department_idDepartment` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idDepartmentTypeOfSport_UNIQUE` (`id` ASC) ,
  INDEX `fk_DepartmentTypeOfSport_TypeOfSport1_idx` (`TypeOfSport` ASC) ,
  INDEX `fk_DepartmentTypeOfSport_Department1_idx` (`Department_idDepartment` ASC) ,
  CONSTRAINT `fk_DepartmentTypeOfSport_TypeOfSport1`
    FOREIGN KEY (`TypeOfSport` )
    REFERENCES `SportClubManagement`.`TypeOfSport` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DepartmentTypeOfSport_Department1`
    FOREIGN KEY (`Department_idDepartment` )
    REFERENCES `SportClubManagement`.`Department` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`League`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`League` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`League` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  `TypeOfSport_idTypeOfSport` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idLeague_UNIQUE` (`id` ASC) ,
  INDEX `fk_League_TypeOfSport1_idx` (`TypeOfSport_idTypeOfSport` ASC) ,
  CONSTRAINT `fk_League_TypeOfSport1`
    FOREIGN KEY (`TypeOfSport_idTypeOfSport` )
    REFERENCES `SportClubManagement`.`TypeOfSport` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Team` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Team` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  `League_idLeague` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idTeam_UNIQUE` (`id` ASC) ,
  INDEX `fk_Team_League1_idx` (`League_idLeague` ASC) ,
  CONSTRAINT `fk_Team_League1`
    FOREIGN KEY (`League_idLeague` )
    REFERENCES `SportClubManagement`.`League` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Department_has_Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Department_has_Team` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Department_has_Team` (
  `Department` INT NOT NULL ,
  `Team` INT NOT NULL ,
  PRIMARY KEY (`Department`, `Team`) ,
  INDEX `fk_DepartmentTeam_Department1_idx` (`Department` ASC) ,
  INDEX `fk_Department_has_Team_Team1_idx` (`Team` ASC) ,
  CONSTRAINT `fk_DepartmentTeam_Department1`
    FOREIGN KEY (`Department` )
    REFERENCES `SportClubManagement`.`Department` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Department_has_Team_Team1`
    FOREIGN KEY (`Team` )
    REFERENCES `SportClubManagement`.`Team` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Trainer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Trainer` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Trainer` (
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Trainer_MemberRole1_idx` (`id` ASC) ,
  CONSTRAINT `fk_Trainer_MemberRole1`
    FOREIGN KEY (`id` )
    REFERENCES `SportClubManagement`.`MemberRole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`ClubTeam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`ClubTeam` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`ClubTeam` (
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_ClubTeam_Team1_idx` (`id` ASC) ,
  CONSTRAINT `fk_ClubTeam_Team1`
    FOREIGN KEY (`id` )
    REFERENCES `SportClubManagement`.`Team` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Team_has_Trainer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Team_has_Trainer` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Team_has_Trainer` (
  `Trainer` INT NOT NULL ,
  `ClubTeam` INT NOT NULL ,
  PRIMARY KEY (`Trainer`, `ClubTeam`) ,
  INDEX `fk_Team_has_Trainer_Trainer1_idx` (`Trainer` ASC) ,
  INDEX `fk_Team_has_Trainer_ClubTeam1_idx` (`ClubTeam` ASC) ,
  CONSTRAINT `fk_Team_has_Trainer_Trainer1`
    FOREIGN KEY (`Trainer` )
    REFERENCES `SportClubManagement`.`Trainer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Team_has_Trainer_ClubTeam1`
    FOREIGN KEY (`ClubTeam` )
    REFERENCES `SportClubManagement`.`ClubTeam` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Player` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Player` (
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Player_MemberRole1_idx` (`id` ASC) ,
  CONSTRAINT `fk_Player_MemberRole1`
    FOREIGN KEY (`id` )
    REFERENCES `SportClubManagement`.`MemberRole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Player_has_TypeOfSport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Player_has_TypeOfSport` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Player_has_TypeOfSport` (
  `TypeOfSport_idTypeOfSport` INT NOT NULL ,
  `Player_idPlayer` INT NOT NULL ,
  PRIMARY KEY (`TypeOfSport_idTypeOfSport`, `Player_idPlayer`) ,
  INDEX `fk_Member_has_TypeOfSport_TypeOfSport1_idx` (`TypeOfSport_idTypeOfSport` ASC) ,
  INDEX `fk_Player_has_TypeOfSport_Player1_idx` (`Player_idPlayer` ASC) ,
  CONSTRAINT `fk_Member_has_TypeOfSport_TypeOfSport1`
    FOREIGN KEY (`TypeOfSport_idTypeOfSport` )
    REFERENCES `SportClubManagement`.`TypeOfSport` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Player_has_TypeOfSport_Player1`
    FOREIGN KEY (`Player_idPlayer` )
    REFERENCES `SportClubManagement`.`Player` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Matchresult`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Matchresult` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Matchresult` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `PointsHometeam` DOUBLE NOT NULL ,
  `PointsForeignteam` DOUBLE NOT NULL ,
  `Final` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idMatchresult_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Country` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Country` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Alpha3` VARCHAR(100) NULL ,
  `Alpha2` VARCHAR(100) NULL ,
  `TLD` VARCHAR(100) NULL ,
  `Deutsch` VARCHAR(100) NULL ,
  `Espanol` VARCHAR(100) NULL ,
  `Francaise` VARCHAR(100) NULL ,
  `Italiano` VARCHAR(100) NULL ,
  `Portugues` VARCHAR(100) NULL ,
  UNIQUE INDEX `idCountry_UNIQUE` (`id` ASC) ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Address` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Address` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Country` INT NOT NULL ,
  `Street` VARCHAR(45) NOT NULL ,
  `StreetNumber` INT NOT NULL ,
  `Village` VARCHAR(45) NOT NULL ,
  `PostalCode` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idAddress_UNIQUE` (`id` ASC) ,
  INDEX `fk_Address_Country_idx` (`Country` ASC) ,
  CONSTRAINT `fk_Address_Country0`
    FOREIGN KEY (`Country` )
    REFERENCES `SportClubManagement`.`Country` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Competition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Competition` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Competition` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `DateFrom` DATE NOT NULL ,
  `DateTo` DATE NULL ,
  `Payment` DOUBLE NULL ,
  `League_idLeague` INT NOT NULL ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  `Address` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idCompetition_UNIQUE` (`id` ASC) ,
  INDEX `fk_Competition_League1_idx` (`League_idLeague` ASC) ,
  INDEX `fk_Competition_Address1_idx` (`Address` ASC) ,
  CONSTRAINT `fk_Competition_League1`
    FOREIGN KEY (`League_idLeague` )
    REFERENCES `SportClubManagement`.`League` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Competition_Address1`
    FOREIGN KEY (`Address` )
    REFERENCES `SportClubManagement`.`Address` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Match`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Match` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Match` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Hometeam` INT NOT NULL ,
  `Foreignteam` INT NOT NULL ,
  `Matchresult` INT NOT NULL ,
  `Competition` INT NOT NULL ,
  `DateFrom` DATE NOT NULL ,
  `DateTo` DATE NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idMatch_UNIQUE` (`id` ASC) ,
  INDEX `fk_Match_Team1_idx` (`Hometeam` ASC) ,
  INDEX `fk_Match_Team2_idx` (`Foreignteam` ASC) ,
  INDEX `fk_Match_Matchresult1_idx` (`Matchresult` ASC) ,
  INDEX `fk_Match_Competition1_idx` (`Competition` ASC) ,
  CONSTRAINT `fk_Match_Team10`
    FOREIGN KEY (`Hometeam` )
    REFERENCES `SportClubManagement`.`Team` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Team20`
    FOREIGN KEY (`Foreignteam` )
    REFERENCES `SportClubManagement`.`Team` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Matchresult10`
    FOREIGN KEY (`Matchresult` )
    REFERENCES `SportClubManagement`.`Matchresult` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Competition10`
    FOREIGN KEY (`Competition` )
    REFERENCES `SportClubManagement`.`Competition` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Competition_has_Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Competition_has_Team` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Competition_has_Team` (
  `Competition` INT NOT NULL ,
  `Team` INT NOT NULL ,
  PRIMARY KEY (`Competition`, `Team`) ,
  INDEX `fk_Competition_has_Team_Team1_idx` (`Team` ASC) ,
  INDEX `fk_Competition_has_Team_Competition1_idx` (`Competition` ASC) ,
  CONSTRAINT `fk_Competition_has_Team_Competition10`
    FOREIGN KEY (`Competition` )
    REFERENCES `SportClubManagement`.`Competition` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Competition_has_Team_Team10`
    FOREIGN KEY (`Team` )
    REFERENCES `SportClubManagement`.`Team` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`ClubMember`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`ClubMember` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`ClubMember` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Prename` VARCHAR(45) NOT NULL ,
  `Lastname` VARCHAR(45) NOT NULL ,
  `DateOfBirth` DATE NOT NULL ,
  `Address` INT NOT NULL ,
  `MemberFrom` DATE NOT NULL ,
  `MemberTo` DATE NULL ,
  `Nationality` INT NOT NULL ,
  `Telephonenumber` VARCHAR(45) NULL ,
  `EmailAddress` VARCHAR(45) NULL ,
  `Gender` TINYINT(1) NULL ,
  `Username` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idMember_UNIQUE` (`id` ASC) ,
  INDEX `fk_Member_Address1_idx` (`Address` ASC) ,
  INDEX `fk_Member_Country1_idx` (`Nationality` ASC) ,
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC) ,
  CONSTRAINT `fk_Member_Address10`
    FOREIGN KEY (`Address` )
    REFERENCES `SportClubManagement`.`Address` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Member_Country10`
    FOREIGN KEY (`Nationality` )
    REFERENCES `SportClubManagement`.`Country` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Permission` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Permission` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Role_has_Permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Role_has_Permission` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Role_has_Permission` (
  `Role_idRole` INT NOT NULL ,
  `Permission_idPermission` INT NOT NULL ,
  PRIMARY KEY (`Role_idRole`, `Permission_idPermission`) ,
  INDEX `fk_Role_has_Permisssion_Permisssion1_idx` (`Permission_idPermission` ASC) ,
  INDEX `fk_Role_has_Permisssion_Role1_idx` (`Role_idRole` ASC) ,
  CONSTRAINT `fk_Role_has_Permisssion_Role1`
    FOREIGN KEY (`Role_idRole` )
    REFERENCES `SportClubManagement`.`MemberRole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Role_has_Permisssion_Permisssion1`
    FOREIGN KEY (`Permission_idPermission` )
    REFERENCES `SportClubManagement`.`Permission` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Member_has_Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Member_has_Role` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Member_has_Role` (
  `Member_idMember` INT NOT NULL ,
  `Role_idRole` INT NOT NULL ,
  PRIMARY KEY (`Member_idMember`, `Role_idRole`) ,
  INDEX `fk_Member_has_Role_Role1_idx` (`Role_idRole` ASC) ,
  INDEX `fk_Member_has_Role_Member1_idx` (`Member_idMember` ASC) ,
  CONSTRAINT `fk_Member_has_Role_Member1`
    FOREIGN KEY (`Member_idMember` )
    REFERENCES `SportClubManagement`.`ClubMember` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Member_has_Role_Role1`
    FOREIGN KEY (`Role_idRole` )
    REFERENCES `SportClubManagement`.`MemberRole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`TypeOfSport_has_Trainer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`TypeOfSport_has_Trainer` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`TypeOfSport_has_Trainer` (
  `TypeOfSport_idTypeOfSport` INT NOT NULL ,
  `Trainer_idTrainer` INT NOT NULL ,
  PRIMARY KEY (`TypeOfSport_idTypeOfSport`, `Trainer_idTrainer`) ,
  INDEX `fk_TypeOfSport_has_Trainer_TypeOfSport1_idx` (`TypeOfSport_idTypeOfSport` ASC) ,
  INDEX `fk_TypeOfSport_has_Trainer_Trainer1_idx` (`Trainer_idTrainer` ASC) ,
  CONSTRAINT `fk_TypeOfSport_has_Trainer_TypeOfSport1`
    FOREIGN KEY (`TypeOfSport_idTypeOfSport` )
    REFERENCES `SportClubManagement`.`TypeOfSport` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TypeOfSport_has_Trainer_Trainer1`
    FOREIGN KEY (`Trainer_idTrainer` )
    REFERENCES `SportClubManagement`.`Trainer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Caretaker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Caretaker` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Caretaker` (
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_Caretaker_MemberRole1`
    FOREIGN KEY (`id` )
    REFERENCES `SportClubManagement`.`MemberRole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Admininstrator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Admininstrator` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Admininstrator` (
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_Admin_Role1`
    FOREIGN KEY (`id` )
    REFERENCES `SportClubManagement`.`MemberRole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Team_has_Player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Team_has_Player` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Team_has_Player` (
  `ClubTeam_idTeam` INT NOT NULL ,
  `Player_idPlayer` INT NOT NULL ,
  PRIMARY KEY (`ClubTeam_idTeam`, `Player_idPlayer`) ,
  INDEX `fk_Team_has_Player_Player1_idx` (`Player_idPlayer` ASC) ,
  CONSTRAINT `fk_Team_has_Player_Player1`
    FOREIGN KEY (`Player_idPlayer` )
    REFERENCES `SportClubManagement`.`Player` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
