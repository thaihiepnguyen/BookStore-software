-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: book-store
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS author;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE author (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  gender varchar(45) DEFAULT NULL,
  date_of_birth date DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  tel varchar(45) DEFAULT NULL,
  is_enable tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES author WRITE;
INSERT INTO author VALUES (1,'Robert Greene','Nam','1991-09-23','robert19912309@gmail.com','0127384923',1),(2,'Tố Hữu','Nam','1982-10-01','huunamm@gmail.com','0909374821',1),(3,'Trần Nam Cao','Nam','2000-12-09','namcaotran00@gmail.com','0987235412',1),(4,'Đinh Lê Thái','Nam','1972-09-09','dinhlethai1@gmail.com','1234567891',1),(5,'Huỳnh Chu Du','Nữ','1955-10-23','chudu11@gmail.com','0789366582',1),(6,'Adriana Grande','Nữ','1978-01-05','grande22@gmail.com','092223334156',1),(7,'Lena Shukaku','Nữ','1965-06-28','shukakuuuu@gmail.com','025557825481',1),(8,'Nguyễn Vĩnh Nguyên','Nam','1970-06-29','nguyenvinh@gmail.com','025333825481',1),(9,'Nguyễn Trương Quý','Nam','1973-09-03','trquy22@gmail.com','02357824156',1),(10,'Đỗ Bích Thúy','Nữ','1965-12-10','bichthuy123@gmail.com','02357812345',1),(11,'Adriana Grande','Nữ','1978-01-05','grande22@gmail.com','092223334156',1),(12,'Mario Puzo','Nữ','1923-09-28','shukakuuuu@gmail.com','025552825481',1),(13,'Mari Tamagawa','Nam','1962-06-29','nguyenvinh@gmail.com','015333825481',1),(14,'J.D.Salinger','Nam','1977-09-03','trquy22@gmail.com','02357624156',1),(15,'J. K. Rowling','Nữ','1969-12-10','bichthuy123@gmail.com','03357812345',1),(16,'Robin Sharma','Nữ','1979-01-05','grande22@gmail.com','092223324156',1),(17,'Edmondo De Amicis','Nữ','1925-06-28','shukakuuuu@gmail.com','021557825481',1),(18,'Robert Kiyosaki','Nam','1870-06-29','nguyenvinh@gmail.com','026333825481',1),(19,'Andrew Matthews','Nam','1953-09-03','trquy22@gmail.com','02357234156',1),(20,'Đỗ Nam Trung','Nam','1962-12-10','bichthuy123@gmail.com','02351112345',1);
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS book;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE book (
  id int NOT NULL AUTO_INCREMENT,
  isbn varchar(45) NOT NULL,
  title varchar(45) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  category_id int DEFAULT NULL,
  publisher_id int DEFAULT NULL,
  author_id int DEFAULT NULL,
  image_path varchar(45) DEFAULT NULL,
  price int DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  is_enable tinyint(1) DEFAULT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (id,isbn),
  KEY FK_BOOK_CAT_idx (category_id),
  KEY FK_BOOK_AUT_idx (author_id),
  KEY FK_BOOK_PUB_idx (publisher_id),
  CONSTRAINT FK_BOOK_AUT FOREIGN KEY (author_id) REFERENCES author (id),
  CONSTRAINT FK_BOOK_CAT FOREIGN KEY (category_id) REFERENCES category (id),
  CONSTRAINT FK_BOOK_PUB FOREIGN KEY (publisher_id) REFERENCES publisher (id)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES book WRITE;
INSERT INTO book VALUES (1,'1827394023412','Lion King','The Lion King is a 1994 American animated musical drama film produced by Walt Disney Feature Animation and released by Walt Disney Pictures.',1,1,1,'Public/image/book/1.png',100000,'Tiếng Anh',1,20),(2,'9182035162229','The 48 laws of power','The 48 Laws of Power (1998) is a non-fiction book by American author Robert Greene. The book is a New York Times bestseller, selling over 1.2 million copies in the United States',3,3,2,'Public/image/book/2.png',200000,'Tiếng Việt',1,30),(3,'6270098203351','Sea Monster','Sea monsters are beings from folklore believed to dwell in the sea and often imagined to be of immense size',4,2,3,'Public/image/book/3.png',90000,'Tiếng Anh',1,15),(4,'4372819264009','Young Mungo','Growing up in a housing estate in Glasgow, Mungo and James are born under different stars--Mungo a Protestant and James a Catholic--and they should be sworn enemies if they\'re to be seen as men at all.',2,4,1,'Public/image/book/4.png',80000,'Tiếng Anh',1,0),(5,'7283341204923','Crudo','Her first novel, Crudo, is a real-time account of the turbulent summer of 2017. It was a Sunday Times top ten bestseller and a New York Times notable book',5,5,4,'Public/image/book/5.png',150000,'Tiếng Việt',1,0),(6,'6662228883681','Verity','Lowen Ashleigh is a struggling writer on the brink of financial ruin when she accepts the job offer of a lifetime. Jeremy Crawford, husband of bestselling author Verity Crawford, has hired Lowen to complete the remaining books in a successful series his injured wife is unable to finish',2,4,7,'Public/image/book/6.png',60000,'Tiếng Anh',1,0),(7,'2283659283711','It starts with us','Colleen Hoover tells fan favorite Atlas\'s side of the story and shares what comes next in this long-anticipated sequel to the “glorious and touching”',4,1,3,'Public/image/book/7.png',230000,'Tiếng Việt',1,24),(8,'4729163742812','The Light We Carry','There may be no tidy solutions or pithy answers to life’s big challenges, but Michelle Obama believes that we can all locate and lean on a set of tools to help us better navigate change and remain steady within flux.',1,3,1,'Public/image/book/8.png',70000,'Tiếng Việt',1,20),(9,'7658911330982','Guapa: A Novel','Set over the course of twenty-four hours, Guapa follows Rasa, a gay man living in an unnamed Arab country, as he tries to carve out a life for himself in the midst of political and social upheaval.',5,3,6,'Public/image/book/9.png',85000,'Tiếng Anh',1,10),(10,'3382987001003','King Kong','A king kong with a poor love in jungle',2,2,4,'Public/image/book/10.png',492000,'Tiếng Anh',1,40),(11,'8822346100231','Dragon Ball Z','Goku and his friends, they find 7 dragon balls to make a wish',3,4,1,'Public/image/book/11.png',92000,'Tiếng Việt',1,50),(12,'7658911330982','Đắc Nhân Tâm','Set over the course of twenty-four hours, Guapa follows Rasa, a gay man living in an unnamed Arab country, as he tries to carve out a life for himself in the midst of political and social upheaval.',5,3,16,'Public/image/book/12.png',85000,'Tiếng Anh',1,10),(13,'3382987001003','Nhà giả kim','A king kong with a poor love in jungle',2,2,14,'Public/image/book/13.png',492000,'Tiếng Anh',1,40),(14,'8822346100231','Tội Ác Và Hình Phạt','Goku and his friends, they find 7 dragon balls to make a wish',3,4,13,'Public/image/book/14.png',92000,'Tiếng Việt',1,50),(15,'7658911330982','Mỗi lần vấp ngã là một lần Trưởng Thành','Set over the course of twenty-four hours, Guapa follows Rasa, a gay man living in an unnamed Arab country, as he tries to carve out a life for himself in the midst of political and social upheaval.',5,3,20,'Public/image/book/15.png',85000,'Tiếng Anh',1,10),(16,'3382987001003','Tuổi Trẻ Đáng Giá Bao Nhiêu?','A king kong with a poor love in jungle',2,2,11,'Public/image/book/16.png',492000,'Tiếng Anh',1,40),(17,'8822346100231','Đời thay đổi khi chúng ta thay đổi','Goku and his friends, they find 7 dragon balls to make a wish',3,4,12,'Public/image/book/17.png',92000,'Tiếng Việt',1,50),(18,'1058911330982','Dạy Con Làm Giàu','Set over the course of twenty-four hours, Guapa follows Rasa, a gay man living in an unnamed Arab country, as he tries to carve out a life for himself in the midst of political and social upheaval.',5,3,13,'Public/image/book/18.png',85000,'Tiếng Anh',1,10),(19,'1182987001003','Những Tấm Lòng Cao Cả','A king kong with a poor love in jungle',2,2,15,'Public/image/book/19.png',492000,'Tiếng Anh',1,40),(20,'1222346100231','Nhà Lãnh Đạo','Goku and his friends, they find 7 dragon balls to make a wish',3,4,17,'Public/image/book/20.png',92000,'Tiếng Việt',1,50),(21,'1382987001003','Cho tôi xin 1 vé đi tuổi thơ','A king kong with a poor love in jungle',2,2,18,'Public/image/book/21.png',492000,'Tiếng Anh',1,40),(22,'1422346100231','Harry Potter','Goku and his friends, they find 7 dragon balls to make a wish',3,4,19,'Public/image/book/22.png',92000,'Tiếng Việt',1,50),(23,'1558911330982','Cà Phê Cùng Tony','Set over the course of twenty-four hours, Guapa follows Rasa, a gay man living in an unnamed Arab country in the midst of political and social upheaval.',5,3,20,'Public/image/book/23.png',85000,'Tiếng Anh',1,10),(24,'1682987001003','Người bán hàng vĩ đại nhất thế giới','A king kong with a poor love in jungle',2,2,7,'Public/image/book/24.png',492000,'Tiếng Anh',1,40),(25,'1722346100231','Trump – Đừng Bao Giờ Bỏ Cuộc','Goku and his friends, they find 7 dragon balls to make a wish',3,4,8,'Public/image/book/25.png',92000,'Tiếng Việt',1,50),(26,'1858911330982','Đừng Bao Giờ Đi Ăn Một Mình','Set over the course of twenty-four hours, Guapa follows Rasa, a gay man living in an unnamed Arab country, as he tries to carve out a life for himself in the midst of political and social upheaval.',5,3,9,'Public/image/book/26.png',85000,'Tiếng Anh',1,10),(27,'1982987001003','Bắt Trẻ Đồng Xanh','A king kong with a poor love in jungle',2,2,10,'Public/image/book/27.png',492000,'Tiếng Anh',1,40),(28,'2122346100231','Ông Già Và Biển Cả','Goku and his friends, they find 7 dragon balls to make a wish',3,4,1,'Public/image/book/28.png',92000,'Tiếng Việt',1,50),(29,'2358911330982','Tỷ Phú Bán Giày','Set over the course of twenty-four hours, Guapa follows Rasa, a gay man living in an unnamed Arab country, as he tries to carve out a life for himself in the midst of political and social upheaval.',5,3,17,'Public/image/book/29.png',85000,'Tiếng Anh',1,10),(30,'2582987001003','Đọc Vị Bất Kỳ Ai','A king kong with a poor love in jungle',2,2,14,'Public/image/book/30.png',492000,'Tiếng Anh',1,40),(31,'2622346100231','Bố già','Goku and his friends, they find 7 dragon balls to make a wish',3,4,19,'Public/image/book/31.png',92000,'Tiếng Việt',1,50);
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS category;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE category (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  is_enable tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES category WRITE;
INSERT INTO category VALUES (1,'Sách thiếu nhi',1),(2,'Khoa học công nghệ – Kinh tế',1),(3,'Văn học nghệ thuật',1),(4,'Văn hóa xã hội – Lịch sử',1),(5,'Truyện, tiểu thuyết',1);
UNLOCK TABLES;

--
-- Table structure for table `cus_pm`
--

DROP TABLE IF EXISTS cus_pm;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE cus_pm (
  cus_id int NOT NULL AUTO_INCREMENT,
  promotion_id int NOT NULL,
  PRIMARY KEY (cus_id,promotion_id),
  KEY FK_CUS_PRO_idx (promotion_id),
  CONSTRAINT FK_CUS_PRO FOREIGN KEY (promotion_id) REFERENCES promotion (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cus_pm`
--

LOCK TABLES cus_pm WRITE;
INSERT INTO cus_pm VALUES (2,1),(3,1),(10,1),(1,2),(4,2),(8,2),(2,3),(9,3),(3,4),(6,4),(7,4);
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS customer;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE customer (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  address varchar(1000) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  tel varchar(45) DEFAULT NULL,
  age varchar(45) DEFAULT NULL,
  is_enable int DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES customer WRITE;
INSERT INTO customer VALUES (1,'Nguyễn Quang Lân','111 Hưng Phú','user1@gmail.com','074676322','20',1),(2,'Nguyễn Hồ Bắc','22 Hưng Phú','user2@gmail.com','08382727372','30',1),(3,'Nguyễn Quang Thuận','33 Trần Hưng Đạo','user3@gmail.com','0635277222','25',1),(4,'Nguyễn Nguyên Bảo','12 Nguyễn Văn Cừ','user4@gmail.com','0735626263','24',1),(5,'Nguyễn Thiện Thanh','227 Nguyễn Văn Cừ, quận 5','user5@gmail.com','063672733','25',1),(6,'Lý Thành Doanh','777 Phạm Thế Hiển','user6@gmail.com','0553526523','27',1),(7,'Lý Nguyên Giáp','1 Nguyễn Cư Trinh, quận 1','user7@gmail.com','035626332','12',1),(8,'Lý Khắc Duy','4 Nguyễn Thị Minh Khai','user8@gmail.com','096737322','16',1),(9,'Lý Lân Vũ','36 Nam Kì Khởi Nghĩa','user9@gmail.com','09673763632','19',1),(10,'Lý Hữu Thiện','100 Nguyễn Trãi','user10@gmail.com','0735276722','40',1);
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  id int NOT NULL AUTO_INCREMENT,
  cus_id int DEFAULT NULL,
  employee_id int DEFAULT NULL,
  date_time varchar(45) DEFAULT NULL,
  promotion_id int DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_ORDER_EMP_idx (employee_id),
  KEY FK_ORDER_PRO_idx (promotion_id),
  KEY FK_ORDER_CUS_idx (cus_id),
  CONSTRAINT FK_ORDER_CUS FOREIGN KEY (cus_id) REFERENCES customer (id),
  CONSTRAINT FK_ORDER_EMP FOREIGN KEY (employee_id) REFERENCES `user` (id),
  CONSTRAINT FK_ORDER_PRO FOREIGN KEY (promotion_id) REFERENCES promotion (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
INSERT INTO `order` VALUES (1,1,1,'2020-03-02 17:23:04',1),(2,6,5,'2021-05-07 13:30:04',3),(3,8,4,'2022-07-12 08:49:14',4),(4,7,5,'2020-12-07 07:30:04',4),(5,10,8,'2021-08-23 13:30:04',3),(6,5,7,'2022-12-07 08:30:04',2),(7,2,9,'2020-05-07 15:30:04',2),(8,4,1,'2022-12-07 08:30:04',2),(9,9,5,'2021-03-08 12:15:04',4),(10,4,8,'2021-03-08 12:15:04',2);
UNLOCK TABLES;

--
-- Table structure for table `order_book`
--

DROP TABLE IF EXISTS order_book;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE order_book (
  order_id int NOT NULL,
  book_id int NOT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (order_id,book_id),
  KEY FK_OB_B_idx (book_id),
  CONSTRAINT FK_OB_B FOREIGN KEY (book_id) REFERENCES book (id),
  CONSTRAINT FK_OB_O FOREIGN KEY (order_id) REFERENCES `order` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_book`
--

LOCK TABLES order_book WRITE;
UNLOCK TABLES;

--
-- Table structure for table `pm_book`
--

DROP TABLE IF EXISTS pm_book;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE pm_book (
  pm_id int NOT NULL,
  book_id int NOT NULL,
  PRIMARY KEY (pm_id,book_id),
  KEY FK_PMB_BOOKID (book_id),
  CONSTRAINT FK_PMB_BOOKID FOREIGN KEY (book_id) REFERENCES book (id),
  CONSTRAINT FK_PMB_PM FOREIGN KEY (pm_id) REFERENCES promotion (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_book`
--

LOCK TABLES pm_book WRITE;
INSERT INTO pm_book VALUES (1,1),(3,1),(1,2),(3,2),(1,3),(3,3),(1,4),(2,4),(4,5),(3,6),(1,7),(3,7),(4,8),(1,9),(4,9),(2,10),(4,10),(2,11),(4,11);
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS promotion;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE promotion (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  start_date varchar(45) DEFAULT NULL,
  end_date varchar(45) DEFAULT NULL,
  is_enable tinyint(1) DEFAULT NULL,
  discount float DEFAULT NULL,
  order_limit int DEFAULT NULL,
  apply_cus tinyint(1) DEFAULT NULL,
  apply_ano tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES promotion WRITE;
INSERT INTO promotion VALUES (1,'Happy Aniversary','This promotion applies for celebration - discount 15%','2022-12-01','2022-12-04',1,0.15,10,1,0),(2,'Noel with fun','Discount 10% for membership','2022-12-06','2022-12-08',1,0.1,5,1,0),(3,'Love membership','Discount 12%','2022-12-11','2022-12-14',1,0.12,10,1,0),(4,'Cheap books','Discount 23%','2022-12-16','2022-12-30',1,0.23,20,1,1);
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS publisher;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE publisher (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  address varchar(1000) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  tel varchar(45) DEFAULT NULL,
  is_enable tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES publisher WRITE;
INSERT INTO publisher VALUES (1,'Nhà xuất bản Trẻ','161B Lý Chính Thắng, phường Võ Thị Sáu, Quận 3, TP. Hồ Chí Minh','hopthubandoc@nxbtre.com.vn','074676322',1),(2,'Nhà xuất bản Kim Đồng','55 Quang Trung, Hà Nội, Việt Nam ','info@nxbkimdong.com.vn','02439428653',1),(3,'Nhà xuất bản Hội Nhà văn','65 Nguyễn Du, Quận Hai Bà Trưng, Hà Nội','nhaxuatbanhnv@gmail.com','0243822 2135',1),(4,'Nhà xuất bản Lao Động','175 Giảng Võ, Đống Đa, Hà Nội','nxblaodong@yahoo.com','02439428653',1),(5,'Nhã Nam','59 Đỗ Quang, Cầu Giấy, Hà Nội','bookstore@nhanam.vn','0903244248',1);
UNLOCK TABLES;

--
-- Table structure for table `role_of_user`
--

DROP TABLE IF EXISTS role_of_user;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE role_of_user (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  salary varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_of_user`
--

LOCK TABLES role_of_user WRITE;
INSERT INTO role_of_user VALUES (1,'Administrator','5000000'),(2,'Employee','2000000');
UNLOCK TABLES;

--
-- Table structure for table `sheet`
--

DROP TABLE IF EXISTS sheet;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sheet (
  id int NOT NULL AUTO_INCREMENT,
  date_import varchar(45) DEFAULT NULL,
  user_id int DEFAULT NULL,
  total_cost int DEFAULT NULL,
  path_name varchar(45) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_SHEET_USER (user_id),
  CONSTRAINT FK_SHEET_USER FOREIGN KEY (user_id) REFERENCES `user` (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sheet`
--

LOCK TABLES sheet WRITE;
INSERT INTO sheet VALUES (1,'2023-01-01',1,500000,'sheets/sheet1.xlsx'),(2,'2023-01-01',1,500000,'sheets/sheet2.xlsx'),(3,'2023-01-01',1,500000,'sheets/sheet3.xlsx');
UNLOCK TABLES;

--
-- Table structure for table `sheet_book`
--

DROP TABLE IF EXISTS sheet_book;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sheet_book (
  sheet_id int NOT NULL,
  book_id int NOT NULL,
  quantity int DEFAULT NULL,
  new_price int DEFAULT NULL,
  PRIMARY KEY (sheet_id,book_id),
  KEY FK_SB_BOOK (book_id),
  CONSTRAINT FK_SB_BOOK FOREIGN KEY (book_id) REFERENCES book (id),
  CONSTRAINT FK_SB_SHEET FOREIGN KEY (sheet_id) REFERENCES sheet (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sheet_book`
--

LOCK TABLES sheet_book WRITE;
INSERT INTO sheet_book VALUES (1,1,5,300000),(1,2,2,400000),(1,3,18,500000),(2,4,5,300000),(2,5,2,40000),(2,6,18,50000),(2,7,11,50000),(3,7,5,30000),(3,8,2,40000),(3,9,5,30000),(3,10,2,40000),(3,12,18,50000);
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS user;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  firstname varchar(45) DEFAULT NULL,
  lastname varchar(45) DEFAULT NULL,
  gender varchar(45) DEFAULT NULL,
  address varchar(1000) DEFAULT NULL,
  role_id int DEFAULT NULL,
  hire_date date DEFAULT NULL,
  tel varchar(45) DEFAULT NULL,
  avt_path varchar(300) DEFAULT NULL,
  is_enable tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY role_id (role_id),
  CONSTRAINT user_ibfk_1 FOREIGN KEY (role_id) REFERENCES role_of_user (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES user WRITE;
INSERT INTO user VALUES (1,'nguyenan','12345678','Nguyễn','An','Nam','123 An Dương Vương, phường 3, quận 5',2,'2000-03-12','0937823664','',1),(2,'admin1','12345678','Nguyễn ','Thư','Nữ','35b Trần Hưng Đạo, phường 4, quận 1',1,'1998-05-29','0746387333','',1),(3,'admin2','12345678','Trần','Thanh','Nam','1 Cao Thắng, phường 4, quận 3',1,'1996-07-03','0783787272','',1),(4,'nguyenlan','12345678','Nguyễn ','Lan','Nữ','35b Trần Hưng Đạo, phường 4, quận 1',2,'1998-05-29','0746387333','',1),(5,'nguyenthanh','12345678','Nguyễn','Thanh','Nam','100 Cao Thắng, phường 4, quận 3',2,'2000-03-22','09378555','',1),(6,'admin3','12345678','Lý','Lam','Nữ','999 Nguyễn Cứu Phú, huyện Bình Chánh',1,'2000-04-12','0936826372','',1),(7,'nguyenlam','12345678','Nguyễn ','Lâm','Nam','35b Trần Hưng Đạo, phường 4, quận 1',2,'1995-03-23','0946736562','',1),(8,'nguyenminh','12345678','Nguyễn ','Minh ','Nam','10 Cao Thắng, phường 4, quận 3',2,'1998-10-03','0967363737','',1),(9,'vantan','12345678','Văn ','Tấn ','Nam','12 Trần Hưng Đạo, quận 6,',2,'2000-05-12','0937827822','',1),(10,'admin4','12345678','Thái','Hiệp','Nam','123 Điện Biên Phủ, phường 3, quận 5',1,'2002-02-03','0124143242','',1);
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
