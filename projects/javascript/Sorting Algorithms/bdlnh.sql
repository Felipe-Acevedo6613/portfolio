-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 17 juil. 2024 à 09:12
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdlnh`
--
CREATE DATABASE IF NOT EXISTS `bdlnh` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdlnh`;

-- --------------------------------------------------------

--
-- Structure de la table `equipes`
--

CREATE TABLE `equipes` (
  `id` int(11) NOT NULL,
  `nom_equipe` varchar(100) NOT NULL,
  `ville` varchar(100) NOT NULL,
  `pays` varchar(100) NOT NULL,
  `annee_creation` int(11) NOT NULL,
  `nombre_coupes_stanley` int(11) NOT NULL,
  `annee_coupes_stanley` varchar(255) DEFAULT NULL,
  `directeur_general` varchar(100) NOT NULL,
  `entraineur` varchar(100) DEFAULT NULL,
  `stade` varchar(100) DEFAULT NULL,
  `couleur_principale` varchar(50) DEFAULT NULL,
  `site_officiel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `equipes`
--

INSERT INTO `equipes` (`id`, `nom_equipe`, `ville`, `pays`, `annee_creation`, `nombre_coupes_stanley`, `annee_coupes_stanley`, `directeur_general`, `entraineur`, `stade`, `couleur_principale`, `site_officiel`) VALUES
(1, 'Bruins de Boston', 'Boston', 'États-Unis', 1924, 6, '1929, 1939, 1941, 1970, 1972, 2011', 'Don Sweeney', 'Jim Montgomery', 'TD Garden', 'Noir, Or', 'http://www.bostonbruins.com'),
(2, 'Sabres de Buffalo', 'Buffalo', 'États-Unis', 1970, 0, NULL, 'Kevyn Adams', 'Don Granato', 'KeyBank Center', 'Bleu, Or', 'http://www.sabres.com'),
(3, 'Red Wings de Détroit', 'Détroit', 'États-Unis', 1926, 11, '1936, 1937, 1943, 1950, 1952, 1954, 1955, 1997, 1998, 2002, 2008', 'Steve Yzerman', 'Derek Lalonde', 'Little Caesars Arena', 'Rouge, Blanc', 'http://www.detroitredwings.com'),
(4, 'Panthers de la Floride', 'Sunrise', 'États-Unis', 1993, 0, NULL, 'Bill Zito', 'Paul Maurice', 'FLA Live Arena', 'Rouge, Or, Bleu', 'http://www.floridapanthers.com'),
(5, 'Canadiens de Montréal', 'Montréal', 'Canada', 1909, 24, '1916, 1924, 1930, 1931, 1944, 1946, 1953, 1956, 1957, 1958, 1959, 1960, 1965, 1966, 1968, 1969, 1971, 1973, 1976, 1977, 1978, 1979, 1986, 1993', 'Kent Hughes', 'Martin St-Louis', 'Centre Bell', 'Rouge, Blanc, Bleu', 'http://www.canadiens.com'),
(6, 'Sénateurs d\'Ottawa', 'Ottawa', 'Canada', 1992, 0, NULL, 'Pierre Dorion', 'D.J. Smith', 'Centre Canadian Tire', 'Rouge, Noir, Blanc', 'http://www.senators.com'),
(7, 'Lightning de Tampa Bay', 'Tampa', 'États-Unis', 1992, 3, '2004, 2020, 2021', 'Julien BriseBois', 'Jon Cooper', 'Amalie Arena', 'Bleu, Blanc', 'http://www.tampabaylightning.com'),
(8, 'Maple Leafs de Toronto', 'Toronto', 'Canada', 1917, 13, '1918, 1922, 1932, 1942, 1945, 1947, 1948, 1949, 1951, 1962, 1963, 1964, 1967', 'Brad Treliving', 'Sheldon Keefe', 'Scotiabank Arena', 'Bleu, Blanc', 'http://www.mapleleafs.com'),
(9, 'Hurricanes de la Caroline', 'Raleigh', 'États-Unis', 1972, 1, '2006', 'Don Waddell', 'Rod Brind\'Amour', 'PNC Arena', 'Rouge, Noir, Blanc', 'http://www.hurricanes.com'),
(10, 'Blue Jackets de Columbus', 'Columbus', 'États-Unis', 2000, 0, NULL, 'Jarmo Kekäläinen', 'Pascal Vincent', 'Nationwide Arena', 'Bleu, Rouge, Argent', 'http://www.bluejackets.com'),
(11, 'Devils du New Jersey', 'Newark', 'États-Unis', 1974, 3, '1995, 2000, 2003', 'Tom Fitzgerald', 'Lindy Ruff', 'Prudential Center', 'Rouge, Noir, Blanc', 'http://www.njdevils.com'),
(12, 'Islanders de New York', 'New York', 'États-Unis', 1972, 4, '1980, 1981, 1982, 1983', 'Lou Lamoriello', 'Lane Lambert', 'UBS Arena', 'Bleu, Orange, Blanc', 'http://www.newyorkislanders.com'),
(13, 'Rangers de New York', 'New York', 'États-Unis', 1926, 4, '1928, 1933, 1940, 1994', 'Chris Drury', 'Peter Laviolette', 'Madison Square Garden', 'Bleu, Rouge, Blanc', 'http://www.newyorkrangers.com'),
(14, 'Flyers de Philadelphie', 'Philadelphie', 'États-Unis', 1967, 2, '1974, 1975', 'Daniel Brière', 'John Tortorella', 'Wells Fargo Center', 'Orange, Noir, Blanc', 'http://www.philadelphiaflyers.com'),
(15, 'Penguins de Pittsburgh', 'Pittsburgh', 'États-Unis', 1967, 5, '1991, 1992, 2009, 2016, 2017', 'Kyle Dubas', 'Mike Sullivan', 'PPG Paints Arena', 'Noir, Or', 'http://www.pittsburghpenguins.com'),
(16, 'Capitals de Washington', 'Washington', 'États-Unis', 1974, 1, '2018', 'Brian MacLellan', 'Spencer Carbery', 'Capital One Arena', 'Rouge, Bleu, Blanc', 'http://www.washingtoncapitals.com'),
(17, 'Blackhawks de Chicago', 'Chicago', 'États-Unis', 1926, 6, '1934, 1938, 1961, 2010, 2013, 2015', 'Kyle Davidson', 'Luke Richardson', 'United Center', 'Rouge, Noir, Blanc', 'http://www.chicagoblackhawks.com'),
(18, 'Avalanche du Colorado', 'Denver', 'États-Unis', 1972, 3, '1996, 2001, 2022', 'Chris MacFarland', 'Jared Bednar', 'Ball Arena', 'Bordeaux, Bleu, Argent', 'http://www.coloradoavalanche.com'),
(19, 'Stars de Dallas', 'Dallas', 'États-Unis', 1967, 1, '1999', 'Jim Nill', 'Peter DeBoer', 'American Airlines Center', 'Vert, Or, Blanc', 'http://www.dallasstars.com'),
(20, 'Wild du Minnesota', 'Saint Paul', 'États-Unis', 2000, 0, NULL, 'Bill Guerin', 'Dean Evason', 'Xcel Energy Center', 'Vert, Rouge, Blanc', 'http://www.wild.com'),
(21, 'Predators de Nashville', 'Nashville', 'États-Unis', 1998, 0, NULL, 'Barry Trotz', 'Andrew Brunette', 'Bridgestone Arena', 'Or, Bleu, Blanc', 'http://www.nashvillepredators.com'),
(22, 'Blues de Saint-Louis', 'Saint-Louis', 'États-Unis', 1967, 1, '2019', 'Doug Armstrong', 'Craig Berube', 'Enterprise Center', 'Bleu, Or, Blanc', 'http://www.stlouisblues.com'),
(23, 'Jets de Winnipeg', 'Winnipeg', 'Canada', 1999, 0, NULL, 'Kevin Cheveldayoff', 'Rick Bowness', 'Canada Life Centre', 'Bleu, Argent, Blanc', 'http://www.winnipegjets.com'),
(24, 'Ducks d\'Anaheim', 'Anaheim', 'États-Unis', 1993, 1, '2007', 'Pat Verbeek', 'Greg Cronin', 'Honda Center', 'Noir, Or, Orange', 'http://www.anaheimducks.com'),
(25, 'Coyotes de l\'Arizona', 'Glendale', 'États-Unis', 1972, 0, NULL, 'Bill Armstrong', 'André Tourigny', 'Mullett Arena', 'Bordeaux, Sable, Noir', 'http://www.arizonacoyotes.com'),
(26, 'Flames de Calgary', 'Calgary', 'Canada', 1972, 1, '1989', 'Craig Conroy', 'Ryan Huska', 'Scotiabank Saddledome', 'Rouge, Jaune, Blanc', 'http://www.calgaryflames.com'),
(27, 'Oilers d\'Edmonton', 'Edmonton', 'Canada', 1972, 5, '1984, 1985, 1987, 1988, 1990', 'Ken Holland', 'Jay Woodcroft', 'Rogers Place', 'Bleu, Orange', 'http://www.edmontonoilers.com'),
(28, 'Kings de Los Angeles', 'Los Angeles', 'États-Unis', 1967, 2, '2012, 2014', 'Rob Blake', 'Todd McLellan', 'Crypto.com Arena', 'Noir, Argent, Blanc', 'http://www.lakings.com'),
(29, 'Sharks de San José', 'San José', 'États-Unis', 1991, 0, NULL, 'Mike Grier', 'David Quinn', 'SAP Center', 'Bleu Sarcelle, Noir, Blanc', 'http://www.sjsharks.com'),
(30, 'Kraken de Seattle', 'Seattle', 'États-Unis', 2021, 0, NULL, 'Ron Francis', 'Dave Hakstol', 'Climate Pledge Arena', 'Bleu Marine, Aqua, Rouge', 'http://www.seattlekraken.com'),
(31, 'Canucks de Vancouver', 'Vancouver', 'Canada', 1970, 0, NULL, 'Patrik Allvin', 'Rick Tocchet', 'Rogers Arena', 'Bleu, Vert, Blanc', 'http://www.canucks.com'),
(32, 'Golden Knights de Vegas', 'Las Vegas', 'États-Unis', 2017, 1, '2023', 'Kelly McCrimmon', 'Bruce Cassidy', 'T-Mobile Arena', 'Or, Noir, Rouge', 'http://www.vegasgoldenknights.com');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `equipes`
--
ALTER TABLE `equipes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `equipes`
--
ALTER TABLE `equipes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
