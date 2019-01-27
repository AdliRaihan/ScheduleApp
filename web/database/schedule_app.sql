-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 27 Jan 2019 pada 05.27
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `schedule_app`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_commit_schedule`
--

CREATE TABLE `user_commit_schedule` (
  `commit_id` int(11) NOT NULL,
  `commit_schedule_name` varchar(20) NOT NULL,
  `commit_schedule_description` text NOT NULL,
  `commit_schedule_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `commit_schedule_user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user_commit_schedule`
--

INSERT INTO `user_commit_schedule` (`commit_id`, `commit_schedule_name`, `commit_schedule_description`, `commit_schedule_time`, `commit_schedule_user_id`) VALUES
(2, 'Duh Adley', 'Adli Bangets', '2019-01-27 04:25:44', 1),
(3, 'Duh Rei', 'Adli Ganteng banget yalord', '2019-01-27 04:23:21', 1),
(4, 'Duh Rai', 'Halo Raihan', '2019-01-27 04:23:27', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_schedule`
--

CREATE TABLE `user_schedule` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nama_lengkap` varchar(32) NOT NULL,
  `pekerjaan` varchar(25) NOT NULL,
  `umur` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user_schedule`
--

INSERT INTO `user_schedule` (`id`, `username`, `password`, `email`, `nama_lengkap`, `pekerjaan`, `umur`) VALUES
(1, 'adliraihan', 'adliraihan', 'adliraihan001@gmail.com', 'Adli Raihan', 'Mahasiswa', 20);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `user_commit_schedule`
--
ALTER TABLE `user_commit_schedule`
  ADD PRIMARY KEY (`commit_id`),
  ADD KEY `commit_schedule_user_id` (`commit_schedule_user_id`);

--
-- Indeks untuk tabel `user_schedule`
--
ALTER TABLE `user_schedule`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user_commit_schedule`
--
ALTER TABLE `user_commit_schedule`
  MODIFY `commit_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `user_schedule`
--
ALTER TABLE `user_schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `user_commit_schedule`
--
ALTER TABLE `user_commit_schedule`
  ADD CONSTRAINT `user_commit_schedule_ibfk_1` FOREIGN KEY (`commit_schedule_user_id`) REFERENCES `user_schedule` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
