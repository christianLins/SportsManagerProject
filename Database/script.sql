SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `SportClubManagement` ;
CREATE SCHEMA IF NOT EXISTS `SportClubManagement` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `SportClubManagement` ;

-- -----------------------------------------------------
-- Table `SportClubManagement`.`Country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Country` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Country` (
  `idCountry` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Alpha3` VARCHAR(100) NULL ,
  `Alpha2` VARCHAR(100) NULL ,
  `TLD` VARCHAR(100) NULL ,
  `Deutsch` VARCHAR(100) NULL ,
  `Espanol` VARCHAR(100) NULL ,
  `Francaise` VARCHAR(100) NULL ,
  `Italiano` VARCHAR(100) NULL ,
  `Portugues` VARCHAR(100) NULL ,
  UNIQUE INDEX `idCountry_UNIQUE` (`idCountry` ASC) ,
  PRIMARY KEY (`idCountry`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Address` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Address` (
  `idAddress` INT NOT NULL AUTO_INCREMENT ,
  `Country` INT NOT NULL ,
  `Street` VARCHAR(45) NOT NULL ,
  `StreetNumber` INT NOT NULL ,
  `Village` VARCHAR(45) NOT NULL ,
  `PostalCode` INT NOT NULL ,
  PRIMARY KEY (`idAddress`) ,
  UNIQUE INDEX `idAddress_UNIQUE` (`idAddress` ASC) ,
  INDEX `fk_Address_Country_idx` (`Country` ASC) ,
  CONSTRAINT `fk_Address_Country0`
    FOREIGN KEY (`Country` )
    REFERENCES `SportClubManagement`.`Country` (`idCountry` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Member` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Member` (
  `idMember` INT NOT NULL AUTO_INCREMENT ,
  `Prename` VARCHAR(45) NOT NULL ,
  `Lastname` VARCHAR(45) NOT NULL ,
  `Username` VARCHAR(45) NOT NULL,
  `DateOfBirth` DATE NOT NULL ,
  `Address` INT NOT NULL ,
  `MemberFrom` DATE NOT NULL ,
  `MemberTo` DATE NULL ,
  `Nationality` INT NOT NULL ,
  `Telephonenumber` VARCHAR(45) NULL ,
  `EmailAddress` VARCHAR(45) NULL ,
  `Gender` TINYINT(1) NULL ,
  PRIMARY KEY (`idMember`) ,
  UNIQUE INDEX `idMember_UNIQUE` (`idMember` ASC) ,
  INDEX `fk_Member_Address1_idx` (`Address` ASC) ,
  INDEX `fk_Member_Country1_idx` (`Nationality` ASC) ,
  CONSTRAINT `fk_Member_Address10`
    FOREIGN KEY (`Address` )
    REFERENCES `SportClubManagement`.`Address` (`idAddress` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Member_Country10`
    FOREIGN KEY (`Nationality` )
    REFERENCES `SportClubManagement`.`Country` (`idCountry` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Role1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Role1` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Role1` (
  `idRole` INT NOT NULL ,
  `Member_idMember` INT NOT NULL ,
  PRIMARY KEY (`idRole`) ,
  INDEX `fk_Role_Member1_idx` (`Member_idMember` ASC) ,
  CONSTRAINT `fk_Role_Member1`
    FOREIGN KEY (`Member_idMember` )
    REFERENCES `SportClubManagement`.`Member` (`idMember` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`DepartmentHead`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`DepartmentHead` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`DepartmentHead` (
  `idDepartmentHead` INT NOT NULL ,
  INDEX `fk_DepartmentHead_Role1_idx` (`idDepartmentHead` ASC) ,
  PRIMARY KEY (`idDepartmentHead`) ,
  CONSTRAINT `fk_DepartmentHead_Role10`
    FOREIGN KEY (`idDepartmentHead` )
    REFERENCES `SportClubManagement`.`Role1` (`idRole` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Department` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Department` (
  `idDepartment` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  `DepartmentHead` INT NOT NULL ,
  PRIMARY KEY (`idDepartment`) ,
  UNIQUE INDEX `idDepartment_UNIQUE` (`idDepartment` ASC) ,
  INDEX `fk_Department_DepartmentHead1_idx` (`DepartmentHead` ASC) ,
  CONSTRAINT `fk_Department_DepartmentHead1`
    FOREIGN KEY (`DepartmentHead` )
    REFERENCES `SportClubManagement`.`DepartmentHead` (`idDepartmentHead` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`TypeOfSport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`TypeOfSport` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`TypeOfSport` (
  `idTypeOfSport` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTypeOfSport`) ,
  UNIQUE INDEX `idTypeOfSport_UNIQUE` (`idTypeOfSport` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Department_has_TypeOfSport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Department_has_TypeOfSport` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Department_has_TypeOfSport` (
  `idDepartmentTypeOfSport` INT NOT NULL AUTO_INCREMENT ,
  `TypeOfSport` INT NOT NULL ,
  `Department_idDepartment` INT NOT NULL ,
  PRIMARY KEY (`idDepartmentTypeOfSport`) ,
  UNIQUE INDEX `idDepartmentTypeOfSport_UNIQUE` (`idDepartmentTypeOfSport` ASC) ,
  INDEX `fk_DepartmentTypeOfSport_TypeOfSport1_idx` (`TypeOfSport` ASC) ,
  INDEX `fk_DepartmentTypeOfSport_Department1_idx` (`Department_idDepartment` ASC) ,
  CONSTRAINT `fk_DepartmentTypeOfSport_TypeOfSport1`
    FOREIGN KEY (`TypeOfSport` )
    REFERENCES `SportClubManagement`.`TypeOfSport` (`idTypeOfSport` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DepartmentTypeOfSport_Department1`
    FOREIGN KEY (`Department_idDepartment` )
    REFERENCES `SportClubManagement`.`Department` (`idDepartment` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`League`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`League` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`League` (
  `idLeague` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  PRIMARY KEY (`idLeague`) ,
  UNIQUE INDEX `idLeague_UNIQUE` (`idLeague` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Team` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Team` (
  `idTeam` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  `League` INT NOT NULL ,
  PRIMARY KEY (`idTeam`) ,
  UNIQUE INDEX `idTeam_UNIQUE` (`idTeam` ASC) ,
  INDEX `fk_Team_League1_idx` (`League` ASC) ,
  CONSTRAINT `fk_Team_League10`
    FOREIGN KEY (`League` )
    REFERENCES `SportClubManagement`.`League` (`idLeague` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`ClubTeam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`ClubTeam` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`ClubTeam` (
  `idTeam` INT NOT NULL ,
  INDEX `fk_ClubTeam_Team1_idx` (`idTeam` ASC) ,
  PRIMARY KEY (`idTeam`) ,
  CONSTRAINT `fk_ClubTeam_Team1`
    FOREIGN KEY (`idTeam` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
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
  INDEX `fk_DepartmentTeam_ClubTeam1_idx` (`Team` ASC) ,
  CONSTRAINT `fk_DepartmentTeam_Department1`
    FOREIGN KEY (`Department` )
    REFERENCES `SportClubManagement`.`Department` (`idDepartment` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DepartmentTeam_ClubTeam1`
    FOREIGN KEY (`Team` )
    REFERENCES `SportClubManagement`.`ClubTeam` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Trainer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Trainer` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Trainer` (
  `idTrainer` INT NOT NULL ,
  INDEX `fk_Trainer_Role1_idx` (`idTrainer` ASC) ,
  PRIMARY KEY (`idTrainer`) ,
  CONSTRAINT `fk_Trainer_Role10`
    FOREIGN KEY (`idTrainer` )
    REFERENCES `SportClubManagement`.`Role1` (`idRole` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Team_has_Trainer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Team_has_Trainer` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Team_has_Trainer` (
  `Team` INT NOT NULL ,
  `Trainer` INT NOT NULL ,
  INDEX `fk_Team_has_Trainer_ClubTeam1_idx` (`Team` ASC) ,
  PRIMARY KEY (`Team`, `Trainer`) ,
  INDEX `fk_Team_has_Trainer_Trainer1_idx` (`Trainer` ASC) ,
  CONSTRAINT `fk_Team_has_Trainer_ClubTeam1`
    FOREIGN KEY (`Team` )
    REFERENCES `SportClubManagement`.`ClubTeam` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Team_has_Trainer_Trainer1`
    FOREIGN KEY (`Trainer` )
    REFERENCES `SportClubManagement`.`Trainer` (`idTrainer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Team_has_Player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Team_has_Player` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Team_has_Player` (
  `Team` INT NOT NULL ,
  `Player` INT NOT NULL ,
  PRIMARY KEY (`Team`, `Player`) ,
  INDEX `fk_Team_has_Member_ClubTeam1_idx` (`Team` ASC) ,
  CONSTRAINT `fk_Team_has_Member_ClubTeam1`
    FOREIGN KEY (`Team` )
    REFERENCES `SportClubManagement`.`ClubTeam` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Player` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Player` (
  `Role_idRole` INT NOT NULL ,
  PRIMARY KEY (`Role_idRole`) ,
  CONSTRAINT `fk_Player_Role1`
    FOREIGN KEY (`Role_idRole` )
    REFERENCES `SportClubManagement`.`Role1` (`idRole` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Player_has_TypeOfSport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Player_has_TypeOfSport` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Player_has_TypeOfSport` (
  `TypeOfSport_idTypeOfSport` INT NOT NULL ,
  `Player_Role_idRole` INT NOT NULL ,
  PRIMARY KEY (`TypeOfSport_idTypeOfSport`, `Player_Role_idRole`) ,
  INDEX `fk_Member_has_TypeOfSport_TypeOfSport1_idx` (`TypeOfSport_idTypeOfSport` ASC) ,
  INDEX `fk_Player_has_TypeOfSport_Player1_idx` (`Player_Role_idRole` ASC) ,
  CONSTRAINT `fk_Member_has_TypeOfSport_TypeOfSport1`
    FOREIGN KEY (`TypeOfSport_idTypeOfSport` )
    REFERENCES `SportClubManagement`.`TypeOfSport` (`idTypeOfSport` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Player_has_TypeOfSport_Player1`
    FOREIGN KEY (`Player_Role_idRole` )
    REFERENCES `SportClubManagement`.`Player` (`Role_idRole` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Matchresult`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Matchresult` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Matchresult` (
  `idMatchresult` INT NOT NULL AUTO_INCREMENT ,
  `PointsHometeam` DOUBLE NOT NULL ,
  `PointsForeignteam` DOUBLE NOT NULL ,
  PRIMARY KEY (`idMatchresult`) ,
  UNIQUE INDEX `idMatchresult_UNIQUE` (`idMatchresult` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Competition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Competition` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Competition` (
  `idCompetition` INT NOT NULL AUTO_INCREMENT ,
  `DateFrom` DATE NOT NULL ,
  `DateTo` DATE NULL ,
  `Payment` DOUBLE NULL ,
  PRIMARY KEY (`idCompetition`) ,
  UNIQUE INDEX `idCompetition_UNIQUE` (`idCompetition` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Match`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Match` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Match` (
  `idMatch` INT NOT NULL AUTO_INCREMENT ,
  `Hometeam` INT NOT NULL ,
  `Foreignteam` INT NOT NULL ,
  `Matchresult` INT NOT NULL ,
  `Competition` INT NOT NULL ,
  `DateFrom` DATE NOT NULL ,
  `DateTo` DATE NULL ,
  PRIMARY KEY (`idMatch`) ,
  UNIQUE INDEX `idMatch_UNIQUE` (`idMatch` ASC) ,
  INDEX `fk_Match_Team1_idx` (`Hometeam` ASC) ,
  INDEX `fk_Match_Team2_idx` (`Foreignteam` ASC) ,
  INDEX `fk_Match_Matchresult1_idx` (`Matchresult` ASC) ,
  INDEX `fk_Match_Competition1_idx` (`Competition` ASC) ,
  CONSTRAINT `fk_Match_Team10`
    FOREIGN KEY (`Hometeam` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Team20`
    FOREIGN KEY (`Foreignteam` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Matchresult10`
    FOREIGN KEY (`Matchresult` )
    REFERENCES `SportClubManagement`.`Matchresult` (`idMatchresult` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Competition10`
    FOREIGN KEY (`Competition` )
    REFERENCES `SportClubManagement`.`Competition` (`idCompetition` )
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
    REFERENCES `SportClubManagement`.`Competition` (`idCompetition` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Competition_has_Team_Team10`
    FOREIGN KEY (`Team` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Permission` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Permission` (
  `idPermission` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(45) NULL ,
  PRIMARY KEY (`idPermission`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Role_has_Permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Role_has_Permission` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Role_has_Permission` (
  `Role_idRole` INT NOT NULL ,
  `Permission_idPermission` INT NOT NULL ,
  PRIMARY KEY (`Role_idRole`, `Permission_idPermission`) ,
  INDEX `fk_Role_has_Permission_Permission1_idx` (`Permission_idPermission` ASC) ,
  INDEX `fk_Role_has_Permission_Role1_idx` (`Role_idRole` ASC) ,
  CONSTRAINT `fk_Role_has_Permission_Role1`
    FOREIGN KEY (`Role_idRole` )
    REFERENCES `SportClubManagement`.`Role1` (`idRole` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Role_has_Permission_Permission1`
    FOREIGN KEY (`Permission_idPermission` )
    REFERENCES `SportClubManagement`.`Permission` (`idPermission` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
