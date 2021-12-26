-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2021 at 07:05 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gajidb`
--

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE `gaji` (
  `tanggal` varchar(20) NOT NULL,
  `waktu` varchar(20) NOT NULL,
  `noPegawai` int(20) NOT NULL,
  `namaPegawai` varchar(50) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `gajiPokok` int(20) NOT NULL,
  `jumlahHariMasuk` int(20) NOT NULL,
  `potongan` int(20) NOT NULL,
  `totalGaji` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`tanggal`, `waktu`, `noPegawai`, `namaPegawai`, `jabatan`, `gajiPokok`, `jumlahHariMasuk`, `potongan`, `totalGaji`) VALUES
('25 December 2021', '21:41:12', 12311, 'Bambang', 'Direktur', 10000000, 30, 0, 10000000),
('25 December 2021', '21:41:45', 12322, 'Wiliam', 'Manager', 8000000, 25, 50000, 7950000),
('25 December 2021', '21:42:09', 12333, 'Yuni', 'Kabag', 5000000, 28, 20000, 4980000),
('25 December 2021', '21:42:26', 12344, 'Ulfa', 'Kasub', 3000000, 29, 10000, 2990000),
('25 December 2021', '21:42:46', 12355, 'Nana', 'Karyawan', 2500000, 27, 30000, 2470000),
('25 December 2021', '21:43:44', 12366, 'Omen', 'Kabag', 5000000, 28, 20000, 4980000),
('25 December 2021', '22:35:36', 12377, 'Farid', 'Manager', 8000000, 25, 50000, 7950000),
('26 December 2021', '12:56:59', 12388, 'Siti Rahayu', 'Kasub', 3000000, 26, 40000, 2960000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gaji`
--
ALTER TABLE `gaji`
  ADD PRIMARY KEY (`noPegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
