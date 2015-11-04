-- MySQL Workbench Synchronization
-- Generated: 2015-11-04 20:34
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: JKAVDEV

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `db_sistema_churrasco`.`Convidado` (
  `idConvidado` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `telefone` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idConvidado`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_sistema_churrasco`.`Bebida` (
  `idBebida` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `descricao` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `preco` DECIMAL(10,2) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idBebida`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_sistema_churrasco`.`Carne` (
  `idCarne` INT(11) NOT NULL COMMENT '',
  `nome` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `unidade` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `preco` DECIMAL(10,2) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idCarne`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_sistema_churrasco`.`Churrasco` (
  `idChurrasco` INT(10) UNSIGNED NOT NULL COMMENT '',
  `data` DATE NULL DEFAULT NULL COMMENT '',
  `hora` TIME NULL DEFAULT NULL COMMENT '',
  `local` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idChurrasco`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_sistema_churrasco`.`Usuario` (
  `idUsuario` INT(10) UNSIGNED NOT NULL COMMENT '',
  `nome` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `login` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `senha` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idUsuario`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_sistema_churrasco`.`Convites` (
  `Convidado_idConvidado` INT(11) NOT NULL COMMENT '',
  `Churrasco_idChurrasco` INT(10) UNSIGNED NOT NULL COMMENT '',
  PRIMARY KEY (`Convidado_idConvidado`, `Churrasco_idChurrasco`)  COMMENT '',
  INDEX `fk_Convidado_has_Churrasco_Churrasco1_idx` (`Churrasco_idChurrasco` ASC)  COMMENT '',
  INDEX `fk_Convidado_has_Churrasco_Convidado_idx` (`Convidado_idConvidado` ASC)  COMMENT '',
  CONSTRAINT `fk_Convidado_has_Churrasco_Convidado`
    FOREIGN KEY (`Convidado_idConvidado`)
    REFERENCES `db_sistema_churrasco`.`Convidado` (`idConvidado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Convidado_has_Churrasco_Churrasco1`
    FOREIGN KEY (`Churrasco_idChurrasco`)
    REFERENCES `db_sistema_churrasco`.`Churrasco` (`idChurrasco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_sistema_churrasco`.`itemCarne` (
  `iditemCarne` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `quantidade` FLOAT(11) NULL DEFAULT NULL COMMENT '',
  `Churrasco_idChurrasco` INT(10) UNSIGNED NOT NULL COMMENT '',
  `Carne_idCarne` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`iditemCarne`)  COMMENT '',
  INDEX `fk_itemCarne_Churrasco1_idx` (`Churrasco_idChurrasco` ASC)  COMMENT '',
  INDEX `fk_itemCarne_Carne1_idx` (`Carne_idCarne` ASC)  COMMENT '',
  CONSTRAINT `fk_itemCarne_Churrasco1`
    FOREIGN KEY (`Churrasco_idChurrasco`)
    REFERENCES `db_sistema_churrasco`.`Churrasco` (`idChurrasco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemCarne_Carne1`
    FOREIGN KEY (`Carne_idCarne`)
    REFERENCES `db_sistema_churrasco`.`Carne` (`idCarne`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_sistema_churrasco`.`Churrasco_has_Bebida` (
  `iditemBebida` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `quantidade` FLOAT(11) NULL DEFAULT NULL COMMENT '',
  `Churrasco_idChurrasco` INT(10) UNSIGNED NOT NULL COMMENT '',
  `Bebida_idBebida` INT(11) NOT NULL COMMENT '',
  INDEX `fk_Churrasco_has_Bebida_Bebida1_idx` (`Bebida_idBebida` ASC)  COMMENT '',
  INDEX `fk_Churrasco_has_Bebida_Churrasco1_idx` (`Churrasco_idChurrasco` ASC)  COMMENT '',
  PRIMARY KEY (`iditemBebida`)  COMMENT '',
  CONSTRAINT `fk_Churrasco_has_Bebida_Churrasco1`
    FOREIGN KEY (`Churrasco_idChurrasco`)
    REFERENCES `db_sistema_churrasco`.`Churrasco` (`idChurrasco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Churrasco_has_Bebida_Bebida1`
    FOREIGN KEY (`Bebida_idBebida`)
    REFERENCES `db_sistema_churrasco`.`Bebida` (`idBebida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
