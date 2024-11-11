-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 11/11/2024 às 14:56
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_cm`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `jogadas`
--

CREATE TABLE `jogadas` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `situacao` varchar(45) NOT NULL,
  `tempo` int(11) NOT NULL,
  `dificuldade` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `jogadas`
--

INSERT INTO `jogadas` (`id`, `nome`, `situacao`, `tempo`, `dificuldade`) VALUES
(22, 'MAX', 'VENCEU', 271, 'MÉDIA'),
(23, 'João Víctor', 'PERDEU', 18, 'MÉDIA'),
(35, 'João', 'PERDEU', 53, 'FÁCIL'),
(36, 'João', 'VENCEU', 51, 'FÁCIL'),
(37, 'Paulo', 'VENCEU', 110, 'FÁCIL'),
(38, 'Víctor', 'VENCEU', 74, 'FÁCIL'),
(39, 'João ', 'PERDEU', 9, 'DIFÍCIL');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `jogadas`
--
ALTER TABLE `jogadas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `jogadas`
--
ALTER TABLE `jogadas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
