-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2018 at 03:31 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `day4msql`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accountnumber` int(11) NOT NULL,
  `opendate` datetime NOT NULL,
  `balance` varchar(45) NOT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountnumber`, `opendate`, `balance`, `customer_id`) VALUES
(111, '2018-08-09 00:00:00', '100000', 1),
(112, '2018-08-09 00:00:00', '200000', 1),
(113, '2018-11-12 00:00:00', '350000', 2),
(114, '2018-11-12 00:00:00', '50000', 2),
(115, '2017-11-12 00:00:00', '12500', 3),
(116, '2017-11-12 00:00:00', '370000', 3),
(117, '2018-09-12 00:00:00', '145000', 4),
(118, '2018-02-12 00:00:00', '600000', 4),
(119, '2018-05-12 00:00:00', '125000', 5),
(120, '2018-06-12 00:00:00', '875000', 5);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customernumber` int(11) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `birthdate` datetime NOT NULL,
  `username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `phonetype` varchar(45) NOT NULL,
  `phonenumber` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customernumber`, `firstname`, `lastname`, `birthdate`, `username`, `Password`, `phonetype`, `phonenumber`) VALUES
(1, 'Mirage', 'Age', '1990-01-10 00:00:00', 'mirage', '12345', 'cell', '08877'),
(2, 'Nova', 'Blaze', '1991-01-10 00:00:00', 'nova', '362718', 'cell', '08976'),
(3, 'Lion', 'Star', '1992-01-10 00:00:00', 'lion', '9908', 'cell', '087810'),
(4, 'Kilua', 'Matters', '1993-01-10 00:00:00', 'kilua', '21390', 'cell', '08765'),
(5, 'Pablo', 'Tabulo', '1994-01-10 00:00:00', 'pablo', '21313', 'cell', '098789');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `ID` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `amount` varchar(45) NOT NULL,
  `amountsign` varchar(45) NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`ID`, `type`, `amount`, `amountsign`, `account_id`) VALUES
(1, 'Top-Up', '10000', 'Debet', 111),
(2, 'Buy Coffee', '50000', 'Credit', 111),
(3, 'Top-Up', '10000', 'Debet', 112),
(4, 'Buy Drinks', '40000', 'Credit', 112),
(5, 'Buy Food', '12500', 'Credit', 113),
(6, 'Top-Up', '10000', 'Debet', 113),
(7, 'Top-Up', '15000', 'Debet', 114),
(8, 'Top-Up', '13000', 'Debet', 114),
(9, 'Buy Book', '15000', 'Credit', 115),
(10, 'Top-Up', '25000', 'Debet', 116),
(11, 'Top-Up', '456000', 'Debet', 111),
(12, 'Buy Food', '125000', 'Credit', 111);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountnumber`),
  ADD KEY `FK_customer_idx` (`customer_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customernumber`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_account_idx` (`account_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customernumber` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FK_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customernumber`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FK_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`accountnumber`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
