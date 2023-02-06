DROP USER IF EXISTS `UsuarioNexos` ;
CREATE USER 'UsuarioNexos'@'localhost' IDENTIFIED BY 'Nexos';
SHOW GRANTS FOR 'UsuarioNexos'@'localhost';
GRANT ALL PRIVILEGES ON * . * TO 'UsuarioNexos'@'localhost';
FLUSH PRIVILEGES;

DROP DATABASE IF EXISTS `PruebaNexos`;
CREATE DATABASE `PruebaNexos`;
USE `PruebaNexos` ;
-- -----------------------------------------------------
-- Table `PruebaNexos.`Tarjeta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PruebaNexos`.`tarjeta` ;

CREATE TABLE IF NOT EXISTS `PruebaNexos`.`tarjeta` (
  `iIdtarjeta` INT NOT NULL AUTO_INCREMENT,
  `tTitular` VARCHAR(100) NOT NULL,
  `tCedula` VARCHAR(15) NOT NULL,
  `tTelefono` VARCHAR(10) NOT NULL,
  `tEstado` VARCHAR(8) NOT NULL,
  `iNumeroValidacion` INT NOT NULL,
  `tNumeroTarjeta` VARCHAR(19) NOT NULL,
  `bEstado` boolean NOT NULL, 
  `dtFechacreacion` TIMESTAMP(3) NOT NULL,
  PRIMARY KEY (`iIdtarjeta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PruebaNexos`.`Transaccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PruebaNexos`.`transaccion` ;

CREATE TABLE IF NOT EXISTS `PruebaNexos`.`transaccion` (
  `iIdtransaccion` INT NOT NULL AUTO_INCREMENT,
  `tarjeta_iIdtarjeta` INT NOT NULL,
  `lValorCompra` long NOT NULL,
  `iNumeroReferencia` INT NOT NULL,
  `tDireccionCompra` VARCHAR(50) NOT NULL,
  `tEstadoTransaccion` VARCHAR(100) NOT NULL,
  `dtFechaCreacion` TIMESTAMP(3) NOT NULL,
  `bEstado` boolean NOT NULL,
  PRIMARY KEY (`iIdtransaccion`),
  INDEX `fk_Transaccion_Tarjeta_idx` (`tarjeta_iIdTarjeta` ASC) VISIBLE,
  CONSTRAINT `fk_Transaccion_Tarjeta1`
    FOREIGN KEY (`tarjeta_iIdTarjeta`)
    REFERENCES `pruebanexos`.`tarjeta` (`iIdtarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;