SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO"
SET time_zone = "+00:00";


-- Mysql  Ver 8.0.32

--
--Table structure for table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `callno` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `quantity` int NOT NULL,
  `issued` int NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `callno` (`callno`),
  UNIQUE KEY `callno_2` (`callno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4;

--
--Dumping data for table `books`
--
INSERT INTO `books` (`id`, `callno`, `name`, `author`, `publisher`, `quantity`, `issued`, `added_date`) VALUES
(2, 'G@2', 'Higher Engineering Mathematics', 'B.S. Grewal', 'Khanna', 15, 0, '2023-06-18 14:30:56'),
(5, 'B@0', 'India After Gandhi', 'Ramachandra Guha', 'Ecco Press', 5, 0, '2023-08-9 19:37:56'),
(6, 'C@2', 'Wings of fire', 'Apj Abdul Kalam', 'University Press', 9, 0, '2023-08-9 19:37:56');
