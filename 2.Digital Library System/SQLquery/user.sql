SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
--Table structure for table `user`
--
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `city` varchar(100) NOT NULL,
  `contact` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `User`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `address`, `city`, `contact`) VALUES
(1, 'Ramji', 'Ram12', 'ram@gmail.com', 'sejbhar', 'Raipur', '6262405524'),
(4, 'shyam', 'Sym13', 'shym@gmail.com', 'Khairi', 'Bhatapara', '7974259693'),
(6, 'Raj', 'rj14', 'raj@gmail.com', 'Khapri', 'Balodabazar', '7804955651');
