-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 21 Avril 2017 à 10:46
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `vdev`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `tel` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `mail`, `adresse`, `tel`) VALUES
(1, 'Zozo', 'Zaza', 'zozo.zaza@gmail.com', '1, rue de la zozozitude 59260 Hellemmes', '0601010101'),
(2, 'Dupont', 'Gaetan', 'dupont.gaetan@gmail.com', '5, rue dupont 59230 Vieux-Comdé', '0602598601');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `idCommande` int(10) NOT NULL,
  `nomProd` varchar(50) NOT NULL,
  `nomClient` varchar(50) NOT NULL,
  `varieteNoix` varchar(50) NOT NULL,
  `calibre` int(100) NOT NULL,
  `quantite` int(100) NOT NULL,
  `typeProduit` varchar(255) NOT NULL,
  `typeCond` varchar(50) NOT NULL,
  `dateCond` date NOT NULL,
  `dateLiv` date DEFAULT NULL,
  `idDistributeur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`idCommande`, `nomProd`, `nomClient`, `varieteNoix`, `calibre`, `quantite`, `typeProduit`, `typeCond`, `dateCond`, `dateLiv`, `idDistributeur`) VALUES
(1, 'Ostrowski', 'Zozo', 'franquette', 10, 10, 'fraiche', 'sachet', '2017-02-15', '2017-02-17', 'd01'),
(5, 'Ostrowski', 'Zozo', 'belge', 10, 10, 'fraiche', 'sachet', '2017-02-22', '2017-02-23', 'd01'),
(6, 'Ostrowski', 'Zozo', 'belge', 10, 10, 'fraiche', 'seau', '2017-02-21', NULL, 'd01'),
(8, 'Giaquinto', 'Zozo', 'franquette', 10, 10, 'sechée', 'seau', '2017-02-15', '2017-02-16', 'd02'),
(9, 'Giaquinto', 'Zozo', 'espagnole', 10, 10, 'sechée', 'seau', '2017-02-16', NULL, 'd02'),
(10, 'Dubrulle', 'Zozo', 'parisienne', 10, 10, 'sechée', 'sachet', '2017-02-15', '2017-02-17', 'd02'),
(11, 'Dubrulle', 'Zozo', 'franquette', 10, 10, 'sechée', 'sachet', '2017-04-05', NULL, 'd01'),
(14, 'Ostrowski', 'Zozo', 'franquette', 15, 6, 'fraiche', 'sachet', '2017-04-14', '2017-04-16', 'd01');

-- --------------------------------------------------------

--
-- Structure de la table `distributeur`
--

CREATE TABLE `distributeur` (
  `idDistributeur` varchar(255) NOT NULL,
  `nomDistributeur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `distributeur`
--

INSERT INTO `distributeur` (`idDistributeur`, `nomDistributeur`) VALUES
('d01', 'Carrefour'),
('d02', 'Auchan');

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

CREATE TABLE `membre` (
  `mail` varchar(100) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `role` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `membre`
--

INSERT INTO `membre` (`mail`, `mdp`, `role`) VALUES
('admin@gmail.com', '1234567', 2),
('dubrulle.gaetan@gmail.com', '1234567', 1),
('giaquinto.raphael@gmail.com', '1234567', 1),
('ostrowski.benjamin@gmail.com', '1234567', 1),
('zozo.zaza@gmail.com', '1234567', 0);

-- --------------------------------------------------------

--
-- Structure de la table `producteur`
--

CREATE TABLE `producteur` (
  `id` int(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `idCertif` int(10) NOT NULL,
  `dateAdherent` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `producteur`
--

INSERT INTO `producteur` (`id`, `nom`, `prenom`, `mail`, `adresse`, `tel`, `idCertif`, `dateAdherent`) VALUES
(1, 'Ostrowski', 'Benjamin', 'ostrowski.benjamin@gmail.com', '1, rue du bg 59260 Hellemmes', '0602020202', 1, '2017-04-05'),
(2, 'Dubrulle', 'Gaetan', 'dubrulle.gaetan@gmail.com', '5, rue du champs 59000 Lille', '0605050505', 0, '2000-01-01'),
(3, 'Giaquinto', 'Raphael', 'giaquinto.raphael@gmail.com', '6, rue du champs 59000 Lille', '0606060606', 0, '2000-01-01');

-- --------------------------------------------------------

--
-- Structure de la table `vergers`
--

CREATE TABLE `vergers` (
  `idVergers` int(10) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `nomProd` varchar(100) NOT NULL,
  `superficie` int(100) NOT NULL,
  `densite` int(100) NOT NULL,
  `varieteNoix` varchar(100) NOT NULL,
  `calibre` int(100) NOT NULL,
  `commune` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vergers`
--

INSERT INTO `vergers` (`idVergers`, `nom`, `nomProd`, `superficie`, `densite`, `varieteNoix`, `calibre`, `commune`) VALUES
(1, 'Gaston Bergers', 'Ostrowski', 100, 10, 'Franquette', 10, 'Lille'),
(2, 'Vergers1', 'Ostrowski', 150, 12, 'Belge', 2, 'Lille'),
(3, 'vergers2', 'Ostrowski', 50, 50, 'franquette', 150, 'Tourcoing');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`idCommande`);

--
-- Index pour la table `distributeur`
--
ALTER TABLE `distributeur`
  ADD PRIMARY KEY (`idDistributeur`);

--
-- Index pour la table `membre`
--
ALTER TABLE `membre`
  ADD UNIQUE KEY `mail` (`mail`);

--
-- Index pour la table `producteur`
--
ALTER TABLE `producteur`
  ADD UNIQUE KEY `id` (`id`);

--
-- Index pour la table `vergers`
--
ALTER TABLE `vergers`
  ADD UNIQUE KEY `idVergers` (`idVergers`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `idCommande` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `producteur`
--
ALTER TABLE `producteur`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `vergers`
--
ALTER TABLE `vergers`
  MODIFY `idVergers` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
