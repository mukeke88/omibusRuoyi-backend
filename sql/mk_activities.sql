/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.31 : Database - omibus_ruoyi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`omibus_ruoyi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `omibus_ruoyi`;

/*Table structure for table `mk_activities` */

DROP TABLE IF EXISTS `mk_activities`;

CREATE TABLE `mk_activities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `pause_time` datetime DEFAULT NULL,
  `total_time` int DEFAULT '0',
  `description` text,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `is_deleted` tinyint unsigned DEFAULT '0' COMMENT '0 as not deleted, 1 as deleted',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `mk_activities` */

insert  into `mk_activities`(`id`,`activity_name`,`start_time`,`pause_time`,`total_time`,`description`,`create_time`,`update_time`,`status`,`is_deleted`) values (1,'test1','2024-11-29 14:58:18','2024-11-29 14:58:21',21,'Just test','2024-11-14 14:14:47','2024-11-29 14:58:21','paused',0),(2,'test2','2024-11-29 16:05:04','2024-11-29 16:05:15',18,'test2','2024-11-14 16:08:47','2024-11-29 16:05:15','paused',0),(3,'test3',NULL,NULL,0,'ff','2024-11-29 09:21:10','2024-11-29 10:40:41',NULL,1),(4,'test4','2024-11-29 16:04:35','2024-11-29 16:04:50',185,'ttttest4','2024-11-29 09:24:19','2024-11-29 16:04:50','paused',0),(5,'test5','2024-11-29 14:37:23','2024-11-29 14:37:26',2,'5555','2024-11-29 14:37:19','2024-11-29 14:37:25','paused',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
