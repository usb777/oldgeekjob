/*
SQLyog Ultimate v12.2.6 (64 bit)
MySQL - 10.1.33-MariaDB : Database - oldgeekjob
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`oldgeekjob` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `oldgeekjob`;

/*Table structure for table `cities` */

DROP TABLE IF EXISTS `cities`;

CREATE TABLE `cities` (
  `CITY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `ZIP` int(11) DEFAULT NULL,
  `ST_ID` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`CITY_ID`),
  KEY `fk_stid` (`ST_ID`),
  CONSTRAINT `fk_stid` FOREIGN KEY (`ST_ID`) REFERENCES `states` (`ST_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cities` */

/*Table structure for table `employment_type` */

DROP TABLE IF EXISTS `employment_type`;

CREATE TABLE `employment_type` (
  `ET_ID` tinyint(6) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ET_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `employment_type` */

insert  into `employment_type`(`ET_ID`,`NAME`) values 
(1,'full-time'),
(2,'part-time'),
(3,'contract'),
(4,'intermediate');

/*Table structure for table `job_assignment` */

DROP TABLE IF EXISTS `job_assignment`;

CREATE TABLE `job_assignment` (
  `JA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_ID` int(11) DEFAULT NULL,
  `U_ID` int(11) DEFAULT NULL,
  `DATE_ASSIGNMENT` date DEFAULT NULL,
  PRIMARY KEY (`JA_ID`),
  KEY `fk_jobid` (`JOB_ID`),
  KEY `fk_uid` (`U_ID`),
  CONSTRAINT `fk_jobid` FOREIGN KEY (`JOB_ID`) REFERENCES `jobs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_uid` FOREIGN KEY (`U_ID`) REFERENCES `users` (`U_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `job_assignment` */

insert  into `job_assignment`(`JA_ID`,`JOB_ID`,`U_ID`,`DATE_ASSIGNMENT`) values 
(1,1,3,'2019-02-27'),
(2,2,3,'2019-02-27');

/*Table structure for table `job_status` */

DROP TABLE IF EXISTS `job_status`;

CREATE TABLE `job_status` (
  `JS_ID` tinyint(4) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`JS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `job_status` */

insert  into `job_status`(`JS_ID`,`NAME`) values 
(1,'enabled'),
(2,'disabled'),
(3,'pending');

/*Table structure for table `jobs` */

DROP TABLE IF EXISTS `jobs`;

CREATE TABLE `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(400) CHARACTER SET latin1 DEFAULT NULL,
  `COMPENSATION` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `DESCRIPTION` text CHARACTER SET latin1,
  `EDUCATION` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `RESPONSIBILITIES` text CHARACTER SET latin1,
  `QUALIFICATION` text CHARACTER SET latin1,
  `SKILLS` text CHARACTER SET latin1,
  `U_ID` int(11) DEFAULT NULL,
  `JOBSTATUS_ID` tinyint(4) DEFAULT NULL,
  `EMPLOYMENTTYPE_ID` tinyint(4) DEFAULT NULL,
  `BENEFITS` text CHARACTER SET latin1,
  `CONTACT_INFO` text CHARACTER SET latin1,
  `DATE_PUBLICATION` date DEFAULT NULL,
  `CITY` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `STATE_ID` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userid` (`U_ID`),
  KEY `fk_EMPLOYMENTTYPEID` (`EMPLOYMENTTYPE_ID`),
  KEY `fk_jobstatusid` (`JOBSTATUS_ID`),
  KEY `fk_stateid` (`STATE_ID`),
  CONSTRAINT `fk_EMPLOYMENTTYPEID` FOREIGN KEY (`EMPLOYMENTTYPE_ID`) REFERENCES `employment_type` (`ET_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_jobstatusid` FOREIGN KEY (`JOBSTATUS_ID`) REFERENCES `job_status` (`JS_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stateid` FOREIGN KEY (`STATE_ID`) REFERENCES `states` (`ST_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_userid` FOREIGN KEY (`U_ID`) REFERENCES `users` (`U_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `jobs` */

insert  into `jobs`(`id`,`TITLE`,`COMPENSATION`,`DESCRIPTION`,`EDUCATION`,`RESPONSIBILITIES`,`QUALIFICATION`,`SKILLS`,`U_ID`,`JOBSTATUS_ID`,`EMPLOYMENTTYPE_ID`,`BENEFITS`,`CONTACT_INFO`,`DATE_PUBLICATION`,`CITY`,`STATE_ID`) values 
(1,'Oracle DB','100K','Mega Job','Bacjelor','Hacking','good programmer','cool skills',2,1,2,'Medical','44','2019-02-13','New York',32),
(2,'Oracle developer ','120K','Good Db ','higher, master degree','-DB\r\n-Knowledgr','java\r\noracle','',2,1,1,'bene','289038407234','2019-02-27','Brooklyn',1);

/*Table structure for table `messages` */

DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `M_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FROM_ID` int(11) DEFAULT NULL,
  `TO_ID` int(11) DEFAULT NULL,
  `TITLE` varchar(300) CHARACTER SET latin1 DEFAULT NULL,
  `MESSAGE` text CHARACTER SET latin1,
  `CONTACT` text CHARACTER SET latin1,
  `DATE_MESSAGE` date DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `ATTACH_URL` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`M_ID`),
  KEY `fk_fromuid` (`FROM_ID`),
  KEY `fk_touid` (`TO_ID`),
  CONSTRAINT `fk_fromuid` FOREIGN KEY (`FROM_ID`) REFERENCES `users` (`U_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_touid` FOREIGN KEY (`TO_ID`) REFERENCES `users` (`U_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `messages` */

insert  into `messages`(`M_ID`,`FROM_ID`,`TO_ID`,`TITLE`,`MESSAGE`,`CONTACT`,`DATE_MESSAGE`,`STATUS`,`ATTACH_URL`) values 
(1,1,2,'Bad Job','Bad job description','Send me message','2019-02-27',0,'no'),
(2,2,8,'Hey man','Hello dude, How are yu???','contact','2019-02-27',0,'attach_url');

/*Table structure for table `page_visited` */

DROP TABLE IF EXISTS `page_visited`;

CREATE TABLE `page_visited` (
  `PV_ID` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `US_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PV_ID`),
  KEY `fk_usid` (`US_ID`),
  CONSTRAINT `fk_usid` FOREIGN KEY (`US_ID`) REFERENCES `user_story` (`US_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `page_visited` */

/*Table structure for table `profile` */

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `P_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` text CHARACTER SET latin1,
  `U_ID` int(11) DEFAULT NULL,
  `LINKEDIN` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `GITHUB` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `RESUME_URL` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `DATE_MODIFICATION` date DEFAULT NULL,
  PRIMARY KEY (`P_ID`),
  KEY `fk_uid_profile` (`U_ID`),
  CONSTRAINT `fk_uid_profile` FOREIGN KEY (`U_ID`) REFERENCES `users` (`U_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `profile` */

insert  into `profile`(`P_ID`,`DESCRIPTION`,`U_ID`,`LINKEDIN`,`GITHUB`,`RESUME_URL`,`DATE_MODIFICATION`) values 
(1,'Java developer',3,'link_url','git_url','resume_url','2019-02-21'),
(2,'skills, qualification',8,'linkedinurl','github_url','resume_url','2019-02-27');

/*Table structure for table `proposed_technologies` */

DROP TABLE IF EXISTS `proposed_technologies`;

CREATE TABLE `proposed_technologies` (
  `PT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`PT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `proposed_technologies` */

/*Table structure for table `role_user` */

DROP TABLE IF EXISTS `role_user`;

CREATE TABLE `role_user` (
  `ROLE_ID` tinyint(4) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(40) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `role_user` */

insert  into `role_user`(`ROLE_ID`,`NAME`) values 
(1,'superadmin'),
(2,'moderator'),
(3,'employer'),
(4,'jobseeker');

/*Table structure for table `states` */

DROP TABLE IF EXISTS `states`;

CREATE TABLE `states` (
  `ST_ID` tinyint(4) NOT NULL AUTO_INCREMENT,
  `SHORTNAME` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `NAME` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ST_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Data for the table `states` */

insert  into `states`(`ST_ID`,`SHORTNAME`,`NAME`) values 
(1,'AL','Alabama'),
(2,'AK','Alaska'),
(3,'AZ','Arizona'),
(4,'AR','Arkansas'),
(5,'CA','California'),
(6,'CO','Colorado'),
(7,'CT','Connecticut'),
(8,'DE','Delaware'),
(9,'FL','Florida'),
(10,'GA','Georgia'),
(11,'HI','Hawaii'),
(12,'ID','Idaho'),
(13,'IL','Illinois'),
(14,'IN','Indiana'),
(15,'IA','Iowa'),
(16,'KS','Kansas'),
(17,'KY','Kentucky'),
(18,'LA','Louisiana'),
(19,'ME','Maine'),
(20,'MD','Maryland'),
(21,'MA','Massachusetts'),
(22,'MI','Michigan'),
(23,'MN','Minnesota'),
(24,'MS','Mississippi'),
(25,'MO','Missouri'),
(26,'MT','Montana'),
(27,'NE','Nebraska'),
(28,'NV','Nevada'),
(29,'NH','New Hampshire'),
(30,'NJ','New Jersey'),
(31,'NM','New Mexico'),
(32,'NY','New York'),
(33,'NC','North Carolina'),
(34,'ND','North Dakota'),
(35,'OH','Ohio'),
(36,'OK','Oklahoma'),
(37,'OR','Oregon'),
(38,'PA','Pennsylvania'),
(39,'RI','Rhode Island'),
(40,'SC','South Carolina'),
(41,'SD','South Dakota'),
(42,'TN','Tennessee'),
(43,'TX','Texas'),
(44,'UT','Utah'),
(45,'VT','Vermont'),
(46,'VA','Virginia'),
(47,'WA','Washington'),
(48,'WV','West Virginia'),
(49,'WI','Wisconsin'),
(50,'WY','Wyoming');

/*Table structure for table `technologies` */

DROP TABLE IF EXISTS `technologies`;

CREATE TABLE `technologies` (
  `T_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `POPULARITY` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`T_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `technologies` */

/*Table structure for table `user_story` */

DROP TABLE IF EXISTS `user_story`;

CREATE TABLE `user_story` (
  `US_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `DATE_START` date DEFAULT NULL,
  `U_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`US_ID`),
  KEY `fk_uid_userstory` (`U_ID`),
  CONSTRAINT `fk_uid_userstory` FOREIGN KEY (`U_ID`) REFERENCES `users` (`U_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_story` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `U_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FNAME` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `LNAME` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `LOGIN` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `EMAIL` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `TELEFONA` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `ROLE_ID` tinyint(4) DEFAULT NULL,
  `PASSWORD` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`U_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`U_ID`,`FNAME`,`LNAME`,`LOGIN`,`EMAIL`,`TELEFONA`,`ROLE_ID`,`PASSWORD`) values 
(1,'admin','admin','admin','admin@admin.com','444333777',1,'$2a$10$aZL4tGgvnhKuHlx5z0tqEekeUjFw6fvb.2NKAjScke66xA1ilf4JS'),
(2,'Oracle','oracle','oracle','orcl@gmail.com','23894245',3,'$2a$10$1X88VPHLz6yuqRK1GW2PeenngJGVF.weaqzQfxo7yOGb50FoLvyeW'),
(3,'Vasia','Pupkin','vupkin','vpupkin@gmail.com','32423455',4,'$2a$10$c3eUcHXDrUCL25Hf/Ug7ie6cr10Q4oCMiRSFYJrAirTedIbH3ghUy'),
(4,'asd','asddd','qazwsx','sun1riser@rambler.ru','23894245',4,'$2a$10$XguRALhW7Ik0uq9pB1OrDOKGlq95XvrFQ1aW2e1AOfrlYZbxeX6Wq'),
(7,'Exodus','Exodus','exodus','exodus@mail.com','32423455',3,'$2a$10$ofd87k6g7qGWTvZUZj5Vt.V9zWndZGHf7IioGU5aoeGo3FsSeD5vS'),
(8,'Ivan','Shilo','shilo777','shilo@gmail.com','23894245',4,'$2a$10$Sn/MwLhJjqVStXRZoX3vRO.tVtKSTHPVy85pK/zldbL//CmoX.PRW');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
