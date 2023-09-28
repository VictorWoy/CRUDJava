-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Tempo de geração: 15-Dez-2021 às 14:24
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dearstage`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `person`
--

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `idolGroup` varchar(100) NOT NULL,
  `height` double NOT NULL,
  `age` int(11) NOT NULL,
  `birthplace` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `person`
--

INSERT INTO `person` (`id`, `name`, `idolGroup`, `height`, `age`, `birthplace`) VALUES
(2, 'Furukawa Mirin', 'Dempa', 1.65, 35, 'Kagawa'),
(3, 'Matoba Karin', 'NijiCon', 1.54, 20, 'Saitama'),
(4, 'Fujisaki Ayane', 'Dempa e Chape no Izumi', 1.57, 25, 'Saitama'),
(5, 'Sakurano Usa', 'Arcana e Lavilith', 1.58, 26, 'Tokyo'),
(7, 'Kurihara Mayu', 'Rirunede', 1.54, 20, 'Tochigi');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `person`
--
ALTER TABLE `person`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
