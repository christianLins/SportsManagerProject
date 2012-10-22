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
  `Description` TEXT NULL ,
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
  `Addresscol` VARCHAR(45) NULL ,
  PRIMARY KEY (`idAddress`) ,
  UNIQUE INDEX `idAddress_UNIQUE` (`idAddress` ASC) ,
  INDEX `fk_Address_Country_idx` (`Country` ASC) ,
  CONSTRAINT `fk_Address_Country`
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
  `DateOfBirth` VARCHAR(45) NOT NULL ,
  `Address` INT NOT NULL ,
  `MemberFrom` DATE NOT NULL ,
  `MemberTo` VARCHAR(45) NULL ,
  PRIMARY KEY (`idMember`) ,
  UNIQUE INDEX `idMember_UNIQUE` (`idMember` ASC) ,
  INDEX `fk_Member_Address1_idx` (`Address` ASC) ,
  CONSTRAINT `fk_Member_Address1`
    FOREIGN KEY (`Address` )
    REFERENCES `SportClubManagement`.`Address` (`idAddress` )
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
  `HeadOfDepartment` INT NOT NULL ,
  `DateFrom` DATE NOT NULL ,
  `DateTo` DATE NULL ,
  PRIMARY KEY (`idDepartment`) ,
  UNIQUE INDEX `idDepartment_UNIQUE` (`idDepartment` ASC) ,
  INDEX `fk_Department_Member1_idx` (`HeadOfDepartment` ASC) ,
  CONSTRAINT `fk_Department_Member1`
    FOREIGN KEY (`HeadOfDepartment` )
    REFERENCES `SportClubManagement`.`Member` (`idMember` )
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
-- Table `SportClubManagement`.`DepartmentTypeOfSport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`DepartmentTypeOfSport` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`DepartmentTypeOfSport` (
  `idDepartmentTypeOfSport` INT NOT NULL AUTO_INCREMENT ,
  `TypeOfSport` INT NOT NULL ,
  `Department_idDepartment` INT NOT NULL ,
  `DateFrom` DATE NOT NULL ,
  `DateTo` DATE NULL ,
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
  CONSTRAINT `fk_Team_League1`
    FOREIGN KEY (`League` )
    REFERENCES `SportClubManagement`.`League` (`idLeague` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`DepartmentTeam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`DepartmentTeam` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`DepartmentTeam` (
  `idDepartmentTeam` INT NOT NULL AUTO_INCREMENT ,
  `Department` INT NOT NULL ,
  `Team` INT NOT NULL ,
  `DateFrom` DATE NOT NULL ,
  `DateTo` DATE NULL ,
  PRIMARY KEY (`idDepartmentTeam`) ,
  UNIQUE INDEX `idDepartmentTeam_UNIQUE` (`idDepartmentTeam` ASC) ,
  INDEX `fk_DepartmentTeam_Department1_idx` (`Department` ASC) ,
  INDEX `fk_DepartmentTeam_Team1_idx` (`Team` ASC) ,
  CONSTRAINT `fk_DepartmentTeam_Department1`
    FOREIGN KEY (`Department` )
    REFERENCES `SportClubManagement`.`Department` (`idDepartment` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DepartmentTeam_Team1`
    FOREIGN KEY (`Team` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Competition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Competition` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Competition` (
  `idCompetition` INT NOT NULL AUTO_INCREMENT ,
  `DateFrom` DATE NOT NULL ,
  `DateTo` DATE NULL ,
  PRIMARY KEY (`idCompetition`) ,
  UNIQUE INDEX `idCompetition_UNIQUE` (`idCompetition` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Matchresult`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Matchresult` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Matchresult` (
  `idMatchresult` INT NOT NULL AUTO_INCREMENT ,
  `PointsHometeam` DOUBLE NOT NULL ,
  `PointsForeignteam` DOUBLE NOT NULL ,
  `Matchresultcol` VARCHAR(45) NULL ,
  PRIMARY KEY (`idMatchresult`) ,
  UNIQUE INDEX `idMatchresult_UNIQUE` (`idMatchresult` ASC) )
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
  CONSTRAINT `fk_Match_Team1`
    FOREIGN KEY (`Hometeam` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Team2`
    FOREIGN KEY (`Foreignteam` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Matchresult1`
    FOREIGN KEY (`Matchresult` )
    REFERENCES `SportClubManagement`.`Matchresult` (`idMatchresult` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Competition1`
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
  CONSTRAINT `fk_Competition_has_Team_Competition1`
    FOREIGN KEY (`Competition` )
    REFERENCES `SportClubManagement`.`Competition` (`idCompetition` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Competition_has_Team_Team1`
    FOREIGN KEY (`Team` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`President`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`President` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`President` (
  `idMember` INT NOT NULL ,
  `PresidentFrom` DATE NOT NULL ,
  `PresidentTo` DATE NULL ,
  INDEX `fk_President_Member1_idx` (`idMember` ASC) ,
  PRIMARY KEY (`idMember`) ,
  CONSTRAINT `fk_President_Member1`
    FOREIGN KEY (`idMember` )
    REFERENCES `SportClubManagement`.`Member` (`idMember` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`VicePresident`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`VicePresident` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`VicePresident` (
  `idMember` INT NOT NULL ,
  `VicePresidentFrom` DATE NOT NULL ,
  `VicePresidentTo` DATE NULL ,
  INDEX `fk_President_Member1_idx` (`idMember` ASC) ,
  PRIMARY KEY (`idMember`) ,
  CONSTRAINT `fk_President_Member10`
    FOREIGN KEY (`idMember` )
    REFERENCES `SportClubManagement`.`Member` (`idMember` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Greenkeeper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Greenkeeper` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Greenkeeper` (
  `idMember` INT NOT NULL ,
  `GreenkeeperFrom` DATE NOT NULL ,
  `GreenkeeperTo` DATE NULL ,
  INDEX `fk_President_Member1_idx` (`idMember` ASC) ,
  PRIMARY KEY (`idMember`) ,
  CONSTRAINT `fk_President_Member100`
    FOREIGN KEY (`idMember` )
    REFERENCES `SportClubManagement`.`Member` (`idMember` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`FinanceManager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`FinanceManager` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`FinanceManager` (
  `idMember` INT NOT NULL ,
  `FinanceManagerFrom` DATE NOT NULL ,
  `FinanceManagerTo` DATE NULL ,
  INDEX `fk_President_Member1_idx` (`idMember` ASC) ,
  PRIMARY KEY (`idMember`) ,
  CONSTRAINT `fk_President_Member101`
    FOREIGN KEY (`idMember` )
    REFERENCES `SportClubManagement`.`Member` (`idMember` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Trainer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Trainer` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Trainer` (
  `idMember` INT NOT NULL ,
  `TrainerFrom` DATE NOT NULL ,
  `TrainerTo` DATE NULL ,
  INDEX `fk_Greenkeeper_Member1_idx` (`idMember` ASC) ,
  PRIMARY KEY (`idMember`) ,
  UNIQUE INDEX `idMember_UNIQUE` (`idMember` ASC) ,
  CONSTRAINT `fk_Greenkeeper_Member10010`
    FOREIGN KEY (`idMember` )
    REFERENCES `SportClubManagement`.`Member` (`idMember` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`Team_has_Trainer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`Team_has_Trainer` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`Team_has_Trainer` (
  `Team` INT NOT NULL ,
  `idTeamTrainer` INT NOT NULL AUTO_INCREMENT ,
  `DateFrom` DATE NOT NULL ,
  `DateTo` DATE NULL ,
  `Trainer` INT NOT NULL ,
  PRIMARY KEY (`idTeamTrainer`) ,
  INDEX `fk_Team_has_Trainer_Team1_idx` (`Team` ASC) ,
  INDEX `fk_Team_has_Trainer_Trainer1_idx` (`Trainer` ASC) ,
  CONSTRAINT `fk_Team_has_Trainer_Team10`
    FOREIGN KEY (`Team` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Team_has_Trainer_Trainer1`
    FOREIGN KEY (`Trainer` )
    REFERENCES `SportClubManagement`.`Trainer` (`idMember` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportClubManagement`.`TeamMember`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportClubManagement`.`TeamMember` ;

CREATE  TABLE IF NOT EXISTS `SportClubManagement`.`TeamMember` (
  `idTeamMember` INT NOT NULL AUTO_INCREMENT ,
  `Team_idTeam` INT NOT NULL ,
  `Member_idMember` INT NOT NULL ,
  `TeamMemberFrom` DATE NOT NULL ,
  `TeamMemberTo` DATE NULL ,
  `TeamMembercol` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTeamMember`, `Team_idTeam`) ,
  UNIQUE INDEX `idTeamMember_UNIQUE` (`idTeamMember` ASC) ,
  INDEX `fk_TeamMember_Team1_idx` (`Team_idTeam` ASC) ,
  INDEX `fk_TeamMember_Member1_idx` (`Member_idMember` ASC) ,
  CONSTRAINT `fk_TeamMember_Team10`
    FOREIGN KEY (`Team_idTeam` )
    REFERENCES `SportClubManagement`.`Team` (`idTeam` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TeamMember_Member10`
    FOREIGN KEY (`Member_idMember` )
    REFERENCES `SportClubManagement`.`Member` (`idMember` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
