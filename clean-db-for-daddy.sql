-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13-Dez-2022 às 21:34
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dbdaddy`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbambiente`
--

CREATE TABLE `tbambiente` (
  `ambienteID` int(11) NOT NULL,
  `andar` varchar(100) DEFAULT NULL,
  `setor` varchar(100) DEFAULT NULL,
  `departamento` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbambiente`
--

INSERT INTO `tbambiente` (`ambienteID`, `andar`, `setor`, `departamento`) VALUES
(1, '3SS', 'Recepção', 'Central de Segurança'),
(2, '3SS', 'Ar-Condicionado', 'Indefinido'),
(3, '3SS', 'Arquivo Geral', 'Indefinido'),
(4, '3SS', 'Transporte', 'Indefinido'),
(5, '3SS', 'Motorista', 'Indefinido'),
(6, '3SS', 'Elétrica', 'Indefinido'),
(7, '3SS', 'Obras e Manutenção', 'Indefinido'),
(8, '3SS', 'Almoxarifaxo', 'Indefinido'),
(9, '1A', 'Teatro', 'Eventos'),
(10, '3A', 'Sala 1', 'Faculdade'),
(11, '3A', 'Sala 2', 'Faculdade'),
(12, '3A', 'Sala 3', 'Faculdade'),
(13, '3A', 'Sala 4', 'Faculdade'),
(14, '3A', 'Sala 5', 'Faculdade'),
(15, '3A', 'Sala 6', 'Faculdade'),
(16, '3A', 'Sala 7', 'Faculdade'),
(17, '3A', 'Sala 8', 'Faculdade'),
(18, '3A', 'Sala 9', 'Faculdade'),
(19, '3A', 'Redação 5', 'Faculdade'),
(20, '3A', 'Redação 6', 'Faculdade'),
(21, '3A', 'SAV', 'FCL'),
(22, '3A', 'Laboratorio de RP', 'Faculdade'),
(23, '3.5A', 'LC California', 'FCL'),
(24, '4A', 'Superintendência', 'Radio'),
(25, '4A', 'TI', 'Radio'),
(26, '4A', 'Jornalismo', 'Radio'),
(27, '4A', 'Estudio de Gravação RADIO FM', 'Radio'),
(28, '4A', 'Telefonista RADIO FM', 'Radio'),
(29, '4A', 'Datacenter RADIO FM', 'Radio'),
(30, '4A', 'Biblioteca', 'Faculdade'),
(31, '4A', 'Radio-TV Comercial', 'Radio'),
(32, '4A', 'Estúdio Radio 1', 'Radio'),
(33, '4A', 'Estúdio Radio 2', 'Radio'),
(34, '4A', 'Estúdio TV 3', 'Radio'),
(35, '4A', 'Supervisão VIANA', 'Radio'),
(36, '4A', 'Estúdio Radio Online', 'Radio'),
(37, '4A', 'Retirada de Prêmios', 'Radio'),
(38, '4A', 'Switcher', 'Radio'),
(39, '4A', 'Radio Online', 'Radio'),
(40, '4A', 'Discoteca', 'Radio'),
(41, '5A', 'Administração', 'Faculdade'),
(42, '5A', 'Vice-Diretoria', 'Faculdade'),
(43, '5A', 'Coordenadoria EaD', 'Faculdade'),
(44, '5A', 'Nucleo Editorial', 'Faculdade'),
(45, '5A', 'Central de Impressão', 'Faculdade'),
(46, '5A', 'Alípio', 'Faculdade'),
(47, '5A', 'BIOND', 'Faculdade'),
(48, '5A', 'Diretoria', 'Faculdade'),
(49, '5A', 'Biblioteca', 'Faculdade'),
(50, '5A', 'Secretaria', 'Faculdade'),
(51, '5A', 'Tesouraria', 'Faculdade'),
(52, '5A', 'CPA', 'Faculdade'),
(53, '5A', 'Coordenadoria Pós', 'Faculdade'),
(54, '5A', 'Coordenadoria Graduação', 'Faculdade'),
(55, '5A', 'Sala 1', 'Faculdade'),
(56, '5A', 'Sala 2', 'Faculdade'),
(57, '5A', 'Sala 3', 'Faculdade'),
(58, '5A', 'Sala 4', 'Faculdade'),
(59, '5A', 'Sala 5', 'Faculdade'),
(60, '5A', 'Sala 6', 'Faculdade'),
(61, '5A', 'Sala 7', 'Faculdade'),
(62, '5A', 'Sala 8', 'Faculdade'),
(63, '5A', 'Sala 9', 'Faculdade'),
(64, '5A', 'Sala 10', 'Faculdade'),
(65, '5A', 'Sala 11', 'Faculdade'),
(66, '5A', 'Sala 12', 'Faculdade'),
(67, '5A', 'Sala 13', 'Faculdade'),
(68, '5A', 'Sala 14', 'Faculdade'),
(69, '5A', 'Sala 15', 'Faculdade'),
(70, '5A', 'Sala 16', 'Faculdade'),
(71, '5A', 'Sala 17', 'Faculdade'),
(72, '5A', 'Sala 18', 'Faculdade'),
(73, '5A', 'Redação 1', 'Faculdade'),
(74, '5A', 'Redação 2', 'Faculdade'),
(75, '5A', 'Redação 3', 'Faculdade'),
(76, '5A', 'Redação 4', 'Faculdade'),
(77, '6A', 'Financeiro', 'FCL'),
(78, '6A', 'Administração Infra', 'FCL'),
(79, '6A', 'Superintendentes', 'FCL'),
(80, '7A', 'Trasmissores', 'FCL'),
(81, '7A', 'Cenografia', 'FCL'),
(82, '7A', 'Produção Comercial', 'FCL'),
(83, '7A', 'Gazeta Esportiva', 'FCL'),
(84, '7A', 'Gazeta Site', 'FCL'),
(85, '7A', 'Jornal', 'FCL'),
(86, '7A', 'Assist Jornal', 'FCL'),
(87, '7A', 'Comunicação Social TV', 'FCL'),
(88, '7A', 'AVID', 'FCL'),
(89, '7A', 'Mulheres', 'FCL'),
(90, '7A', 'Você Bonita', 'FCL'),
(91, '7A', 'Revista da Cidade', 'FCL'),
(92, '8A', 'TV', 'FCL'),
(93, '13A', 'Transmissor', 'FCL');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbconjunto`
--

CREATE TABLE `tbconjunto` (
  `conjuntoID` int(11) NOT NULL,
  `fk_maquinaID` int(11) DEFAULT NULL,
  `fk_monitorID1` int(11) DEFAULT NULL,
  `fk_monitorID2` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbequipamento`
--

CREATE TABLE `tbequipamento` (
  `equipamentoID` int(11) NOT NULL,
  `tipoEquipamento` varchar(50) DEFAULT NULL,
  `patrimonio` varchar(100) DEFAULT NULL,
  `servicetag` varchar(100) DEFAULT NULL,
  `modelo` varchar(100) DEFAULT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `observacao` text DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `disponibilidadeEmprestimo` varchar(10) DEFAULT NULL,
  `emprestado` varchar(5) DEFAULT NULL,
  `fk_ambienteID` int(11) DEFAULT NULL,
  `fk_conjuntoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbmaquina`
--

CREATE TABLE `tbmaquina` (
  `maquinaID` int(11) NOT NULL,
  `armazenamento` varchar(100) DEFAULT NULL,
  `memoriaRAM` varchar(100) DEFAULT NULL,
  `gpu` varchar(100) DEFAULT NULL,
  `sistemaOperacional` varchar(100) DEFAULT NULL,
  `enderecoMAC` varchar(100) DEFAULT NULL,
  `fk_equipamentoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbmonitor`
--

CREATE TABLE `tbmonitor` (
  `monitorID` int(11) NOT NULL,
  `ajustabilidade` varchar(100) DEFAULT NULL,
  `fk_equipamentoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbambiente`
--
ALTER TABLE `tbambiente`
  ADD PRIMARY KEY (`ambienteID`);

--
-- Índices para tabela `tbconjunto`
--
ALTER TABLE `tbconjunto`
  ADD PRIMARY KEY (`conjuntoID`),
  ADD KEY `fk_maquinaID` (`fk_maquinaID`),
  ADD KEY `fk_monitorID1` (`fk_monitorID1`),
  ADD KEY `fk_monitorID2` (`fk_monitorID2`);

--
-- Índices para tabela `tbequipamento`
--
ALTER TABLE `tbequipamento`
  ADD PRIMARY KEY (`equipamentoID`),
  ADD KEY `fk_ambienteID` (`fk_ambienteID`),
  ADD KEY `fk_conjuntoID` (`fk_conjuntoID`);

--
-- Índices para tabela `tbmaquina`
--
ALTER TABLE `tbmaquina`
  ADD PRIMARY KEY (`maquinaID`),
  ADD KEY `fk_equipamentoID` (`fk_equipamentoID`);

--
-- Índices para tabela `tbmonitor`
--
ALTER TABLE `tbmonitor`
  ADD PRIMARY KEY (`monitorID`),
  ADD KEY `fk_equipamentoID` (`fk_equipamentoID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbambiente`
--
ALTER TABLE `tbambiente`
  MODIFY `ambienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT de tabela `tbconjunto`
--
ALTER TABLE `tbconjunto`
  MODIFY `conjuntoID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbequipamento`
--
ALTER TABLE `tbequipamento`
  MODIFY `equipamentoID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbmaquina`
--
ALTER TABLE `tbmaquina`
  MODIFY `maquinaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbmonitor`
--
ALTER TABLE `tbmonitor`
  MODIFY `monitorID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tbconjunto`
--
ALTER TABLE `tbconjunto`
  ADD CONSTRAINT `tbconjunto_ibfk_1` FOREIGN KEY (`fk_maquinaID`) REFERENCES `tbmaquina` (`maquinaID`),
  ADD CONSTRAINT `tbconjunto_ibfk_2` FOREIGN KEY (`fk_monitorID1`) REFERENCES `tbmonitor` (`monitorID`),
  ADD CONSTRAINT `tbconjunto_ibfk_3` FOREIGN KEY (`fk_monitorID2`) REFERENCES `tbmonitor` (`monitorID`);

--
-- Limitadores para a tabela `tbequipamento`
--
ALTER TABLE `tbequipamento`
  ADD CONSTRAINT `tbequipamento_ibfk_1` FOREIGN KEY (`fk_ambienteID`) REFERENCES `tbambiente` (`ambienteID`),
  ADD CONSTRAINT `tbequipamento_ibfk_2` FOREIGN KEY (`fk_conjuntoID`) REFERENCES `tbconjunto` (`conjuntoID`);

--
-- Limitadores para a tabela `tbmaquina`
--
ALTER TABLE `tbmaquina`
  ADD CONSTRAINT `tbmaquina_ibfk_1` FOREIGN KEY (`fk_equipamentoID`) REFERENCES `tbequipamento` (`equipamentoID`);

--
-- Limitadores para a tabela `tbmonitor`
--
ALTER TABLE `tbmonitor`
  ADD CONSTRAINT `tbmonitor_ibfk_1` FOREIGN KEY (`fk_equipamentoID`) REFERENCES `tbequipamento` (`equipamentoID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
