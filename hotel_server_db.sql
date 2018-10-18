# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             hotel_server_db
# Server version:       5.0.27-community-nt
# Server OS:            Win32
# Target-Compatibility: Standard ANSI SQL
# HeidiSQL version:     3.2 Revision: 1129
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1;*/
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'hotel_server_db'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "hotel_server_db" /*!40100 DEFAULT CHARACTER SET latin1 */;

USE "hotel_server_db";


#
# Table structure for table 'hotel_booking_table'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "hotel_booking_table" (
  "booking_id" int(10) unsigned NOT NULL auto_increment,
  "user_id" int(10) unsigned default NULL,
  "room_id" int(10) unsigned default NULL,
  "hotel_id" int(10) unsigned default NULL,
  "check_in_date" varchar(50) default NULL,
  "check_out_date" varchar(50) default NULL,
  "total_cost" varchar(50) default NULL,
  "status" varchar(50) default NULL,
  PRIMARY KEY  ("booking_id")
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Table structure for table 'hotel_image_tbl'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "hotel_image_tbl" (
  "hotel_id" int(50) default NULL,
  "hotel_image_id" int(10) NOT NULL auto_increment,
  "hotel_image" longblob,
  PRIMARY KEY  ("hotel_image_id")
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Table structure for table 'hotel_info_tbl'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "hotel_info_tbl" (
  "hotel_id" int(10) NOT NULL auto_increment,
  "hotel_name" varchar(50) default NULL,
  "hotel_address" varchar(50) default NULL,
  "hotel_contact_person" varchar(50) default NULL,
  "hotel_contact_no" varchar(50) default NULL,
  "hotel_email" varchar(50) default NULL,
  "swimming_pool" int(10) default NULL,
  "parking" int(10) unsigned default NULL,
  "loundry" int(3) unsigned default NULL,
  "hotel_lat" double default NULL,
  "hotel_long" double default NULL,
  PRIMARY KEY  ("hotel_id")
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Table structure for table 'hotel_room_image_tbl'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "hotel_room_image_tbl" (
  "hotel_room_id" int(11) default NULL,
  "hotel_room_image_id" int(11) NOT NULL auto_increment,
  "hotel_room_image" longblob,
  PRIMARY KEY  ("hotel_room_image_id")
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Table structure for table 'hotel_room_info_tbl'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "hotel_room_info_tbl" (
  "hotel_room_id" int(10) unsigned NOT NULL auto_increment,
  "hotel_id" int(10) unsigned default NULL,
  "hotel_room_type" varchar(50) default NULL,
  "number_of_room" int(10) unsigned default NULL,
  "room_prize" varchar(50) default NULL,
  PRIMARY KEY  ("hotel_room_id")
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Table structure for table 'hotel_user_tbl'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "hotel_user_tbl" (
  "user_id" int(10) unsigned NOT NULL auto_increment,
  "user_firstname" varchar(50) default NULL,
  "user_lastname" varchar(50) default NULL,
  "user_address" varchar(50) default NULL,
  "user_emailId" varchar(50) default NULL,
  "user_contactno" varchar(50) default NULL,
  "username" varchar(50) default NULL,
  "password" varchar(50) default NULL,
  PRIMARY KEY  ("user_id")
) /*!40100 DEFAULT CHARSET=latin1*/;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
