-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_control_lab
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_control_lab
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_control_lab` DEFAULT CHARACTER SET utf8 ;
USE `db_control_lab` ;

-- -----------------------------------------------------
-- Table `db_control_lab`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_control_lab`.`professor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `matricula` VARCHAR(20) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `ativo` TINYINT NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `data_ateracao` DATE NOT NULL,
  `data_ativacao` DATE NOT NULL,
  `data_desativacao` DATE NULL,
  `telefone` VARCHAR(25) NOT NULL,
  `observacao` TEXT NULL,
  `login` VARCHAR(100) NOT NULL,
  `senha` TEXT NOT NULL,
  `ultima_senha` TEXT NOT NULL,
  `sobrenome` VARCHAR(45) NULL,
  `foto` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_control_lab`.`laboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_control_lab`.`laboratorio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `numero` INT(11) NOT NULL,
  `localizacao` VARCHAR(100) NOT NULL,
  `quantidade_maquinas` INT(11) NOT NULL,
  `ativo` TINYINT NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `data_alteracao` DATE NOT NULL,
  `data_ativacao` DATE NOT NULL,
  `data_desativacao` DATE NOT NULL,
  `observacao` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_control_lab`.`horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_control_lab`.`horario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hora_inicio` TIME NOT NULL,
  `hora_fim` TIME NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `data_alteracao` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_control_lab`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_control_lab`.`disciplina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `data_alteracao` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_control_lab`.`permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_control_lab`.`permissao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_control_lab`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_control_lab`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `login` VARCHAR(100) NOT NULL,
  `senha` TEXT NOT NULL,
  `ultima_senha` TEXT NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `ativo` TINYINT NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `data_alteracao` DATE NOT NULL,
  `data_ativacao` DATE NOT NULL,
  `data_desativacao` DATE NOT NULL,
  `observacao` TEXT NULL,
  `permissao_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_permissao1_idx` (`permissao_id` ASC),
  CONSTRAINT `fk_usuario_permissao1`
    FOREIGN KEY (`permissao_id`)
    REFERENCES `db_control_lab`.`permissao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_control_lab`.`agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_control_lab`.`agendamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status_agendamento` VARCHAR(15) NULL,
  `observacao` TEXT NOT NULL,
  `data_agendamento` DATE NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `data_alteracao` DATE NOT NULL,
  `professor_id` INT NOT NULL,
  `laboratorio_id` INT NOT NULL,
  `disciplina_id` INT NOT NULL,
  `horario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_agendamento_professor_idx` (`professor_id` ASC),
  INDEX `fk_agendamento_laboratorio1_idx` (`laboratorio_id` ASC),
  INDEX `fk_agendamento_disciplina1_idx` (`disciplina_id` ASC),
  INDEX `fk_agendamento_horario1_idx` (`horario_id` ASC),
  CONSTRAINT `fk_agendamento_professor`
    FOREIGN KEY (`professor_id`)
    REFERENCES `db_control_lab`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_agendamento_laboratorio1`
    FOREIGN KEY (`laboratorio_id`)
    REFERENCES `db_control_lab`.`laboratorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_agendamento_disciplina1`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `db_control_lab`.`disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_agendamento_horario1`
    FOREIGN KEY (`horario_id`)
    REFERENCES `db_control_lab`.`horario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_control_lab`.`log_aplicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_control_lab`.`log_aplicacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_cadastro` DATE NOT NULL,
  `id_registro_operacao` INT(11) NOT NULL,
  `descricao_operacao` VARCHAR(100) NOT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_log_aplicacao_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_log_aplicacao_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `db_control_lab`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;