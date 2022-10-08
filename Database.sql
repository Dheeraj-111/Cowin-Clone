/*
SQLyog Community Edition- MySQL GUI v8.04 
MySQL - 5.0.37-community-nt : Database - covid
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`covid` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `covid`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `Name` varchar(50) default NULL,
  `Email` varchar(50) default NULL,
  `Password` varchar(50) default NULL,
  `S.No.` int(50) NOT NULL auto_increment,
  UNIQUE KEY `S.No.` (`S.No.`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`Name`,`Email`,`Password`,`S.No.`) values ('Durva Kulkarni','durvakulkarni3@gmail.com','12345',1),('Ayush Raghuvanshi','arraghuvanshi12@gmail.com','12345',2),('Dheeraj Joshi','djjoshi02@gmail.com','12345',3);

/*Table structure for table `hospital` */

DROP TABLE IF EXISTS `hospital`;

CREATE TABLE `hospital` (
  `Hname` varchar(20) default NULL,
  `Hpin` int(11) default NULL,
  `Hstate` varchar(20) default NULL,
  `Hdistrict` varchar(20) default NULL,
  `Hmail` varchar(30) default NULL,
  `Hpass` varchar(10) default NULL,
  `Hslots` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hospital` */

insert  into `hospital`(`Hname`,`Hpin`,`Hstate`,`Hdistrict`,`Hmail`,`Hpass`,`Hslots`) values ('Apolla',452007,'Andra Pradesh','Chittoor','abc1@gmail.com','12345',100),('Lapolla',452008,'Andra Pradesh','Chittoor','ab1@hj.kl','12345',0),('Dapolla',454775,'Bihar','Baksa','newh1@gmail.com','12345',0),('Bappola',452009,'Andra Pradesh','Chittoor','abc3@gmail.com','12345',250);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `Name` varchar(20) default NULL,
  `password` varchar(10) default NULL,
  `username` varchar(30) default NULL,
  `aadharno` varchar(14) default NULL,
  `conpass` varchar(10) default NULL,
  `User_ID` int(11) NOT NULL auto_increment,
  `dob` varchar(11) default NULL,
  `dose` int(11) default NULL,
  `Hname` varchar(20) default NULL,
  PRIMARY KEY  (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`Name`,`password`,`username`,`aadharno`,`conpass`,`User_ID`,`dob`,`dose`,`Hname`) values ('Durva Kulkarni','12345','durvakulkarni3@gmail.com','910123456789','12345',1001,'2002',0,'Bappola'),('Dheeraj Joshi','12345','dheeraj1@gmail.com','098765432123','12345',1002,'2001',1,'Apolla'),('Ayush Raghuvanshi','12345','ayush1@gmail.com','098765432123','12345',1003,'2001',0,'abvcx'),('New User','12345','new1@gmail.com','1234567890','12345',1004,'2023',0,NULL),('New User','12345','new2@gmail.com','1234567890','12345',1005,'2022',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
