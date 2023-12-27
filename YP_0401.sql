
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `yp_0401` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `yp_0401` ;


CREATE TABLE IF NOT EXISTS `yp_0401`.`manufacturer_product` (
  `id_manufacturer_product` BIGINT NOT NULL AUTO_INCREMENT,
  `name_manufacturer_product` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_manufacturer_product`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `yp_0401`.`person` (
  `active` BIT(1) NOT NULL,
  `id_person` BIGINT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_person`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `yp_0401`.`product_category` (
  `id_product_category` BIGINT NOT NULL AUTO_INCREMENT,
  `name_product_category` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_product_category`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `yp_0401`.`product` (
  `price` DOUBLE NULL DEFAULT NULL,
  `id_product` BIGINT NOT NULL AUTO_INCREMENT,
  `manufacturer_product_id` BIGINT NOT NULL,
  `product_category_id` BIGINT NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `specifications` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `FK7jr6u2ktm1qbbhnufufpw0cu9` (`manufacturer_product_id` ASC) VISIBLE,
  INDEX `FKcwclrqu392y86y0pmyrsi649r` (`product_category_id` ASC) VISIBLE,
  CONSTRAINT `FK7jr6u2ktm1qbbhnufufpw0cu9`
    FOREIGN KEY (`manufacturer_product_id`)
    REFERENCES `yp_0401`.`manufacturer_product` (`id_manufacturer_product`),
  CONSTRAINT `FKcwclrqu392y86y0pmyrsi649r`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `yp_0401`.`product_category` (`id_product_category`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `yp_0401`.`person_shop` (
  `id_person_shop` BIGINT NOT NULL AUTO_INCREMENT,
  `person_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  PRIMARY KEY (`id_person_shop`),
  INDEX `FK90viqdhyiowggaciyrqg25pgx` (`person_id` ASC) VISIBLE,
  INDEX `FK5p117jivicrufh5tiap0nlck8` (`product_id` ASC) VISIBLE,
  CONSTRAINT `FK5p117jivicrufh5tiap0nlck8`
    FOREIGN KEY (`product_id`)
    REFERENCES `yp_0401`.`product` (`id_product`),
  CONSTRAINT `FK90viqdhyiowggaciyrqg25pgx`
    FOREIGN KEY (`person_id`)
    REFERENCES `yp_0401`.`person` (`id_person`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `yp_0401`.`role` (
  `person_id` BIGINT NOT NULL,
  `roles` ENUM('ADMIN', 'EMPLOYEE', 'USER') NULL DEFAULT NULL,
  INDEX `FKp74rfg21c55d8eebfl00w5451` (`person_id` ASC) VISIBLE,
  CONSTRAINT `FKp74rfg21c55d8eebfl00w5451`
    FOREIGN KEY (`person_id`)
    REFERENCES `yp_0401`.`person` (`id_person`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `yp_0401`.`schedule` (
  `id_timetable` BIGINT NOT NULL AUTO_INCREMENT,
  `schedule` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_timetable`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `yp_0401`.`shop` (
  `id_shop` BIGINT NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT NOT NULL,
  `schedule_id` BIGINT NOT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_shop`),
  INDEX `FKj9eee0t9rx8u74cwuv17677xc` (`product_id` ASC) VISIBLE,
  INDEX `FKgsknmlvdvs204voeudc3nlt3x` (`schedule_id` ASC) VISIBLE,
  CONSTRAINT `FKgsknmlvdvs204voeudc3nlt3x`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `yp_0401`.`schedule` (`id_timetable`),
  CONSTRAINT `FKj9eee0t9rx8u74cwuv17677xc`
    FOREIGN KEY (`product_id`)
    REFERENCES `yp_0401`.`product` (`id_product`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
