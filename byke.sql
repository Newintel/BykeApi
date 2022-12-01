SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : byke
--

drop database if exists byke;
create database if not exists byke;
use byke;

-- --------------------------------------------------------

--
-- Structure de la table user
--

CREATE TABLE user
(
    id       int(11) NOT NULL AUTO_INCREMENT,
    username    varchar(50) NOT NULL,
    lastname       char(20)      DEFAULT NULL,
    firstname    char(20)      DEFAULT NULL,
    password       char(100)      NOT NULL,
    birthdate date          DEFAULT NULL,
    size         decimal(6, 2) DEFAULT NULL,
    weight          decimal(6, 2) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table user
--

INSERT INTO user (username, lastname, firstname, birthdate, size, weight, password)
VALUES ('GALLOIS_Jean', 'GALLOIS', 'Jean', '1964-04-23', '183.00', '75.00', '$2a$04$CQCsj3BONbDGpAfw60a2vedagwH1jUxRt4O8Se9YdfTVyvF/YerlS'),
       ('VILLE_Pierre', 'VILLE', 'Pierre', '1962-04-12', '173.00', '69.00', '$2a$04$CQCsj3BONbDGpAfw60a2vedagwH1jUxRt4O8Se9YdfTVyvF/YerlS'),
       ('Merlot', 'MICHON', 'John', '2001-09-11', '182.00', '80,50', '$2a$04$CQCsj3BONbDGpAfw60a2vedagwH1jUxRt4O8Se9YdfTVyvF/YerlS');

-- --------------------------------------------------------

--
-- Structure de la table path
--

CREATE TABLE path
(
    id         int(11) NOT NULL AUTO_INCREMENT,
    creatorId           int(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (creatorId) REFERENCES user (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table path
--

INSERT INTO path (creatorId)
VALUES (1),
       (2);

-- --------------------------------------------------------

--
-- Structure de la table bike
--

CREATE TABLE bike
(
    id  int(11) NOT NULL AUTO_INCREMENT,
    brand char(20)      DEFAULT NULL,
    wheels    decimal(6, 2) DEFAULT NULL,
    cassette  char(10)      DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table bike
--

INSERT INTO bike (brand, wheels, cassette)
VALUES ('LAPIERRE X-CONTROL 3', '29.00', '11/42'),
       ('CANONDALE SYNASPE', '700.00', '11/28'),
       ('CUBE Kathmandu Hybri', '29.00', '11/52');


-- --------------------------------------------------------

--
-- Structure de la table electricBike
--

CREATE TABLE electricBike
(
    id            int(11) NOT NULL,
    engine_power   int(11)       DEFAULT NULL,
    battery_power int(11)       DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES bike (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table electricBike
--

INSERT INTO electricBike (id, engine_power, battery_power)
VALUES (3, 250, 625);

-- --------------------------------------------------------

--
-- Structure de la table mountainBike
--

CREATE TABLE mountainBike
(
    id  int(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES bike (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table mountainBike
--

INSERT INTO mountainBike (id)
VALUES (1);

-- --------------------------------------------------------

--
-- Structure de la table roadBike
--

CREATE TABLE roadBike
(
    id    int(11) NOT NULL,
    frame_type char(20)      DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES bike (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table roadBike
--

INSERT INTO roadBike (id, frame_type)
VALUES (2, 'CARBONE');


-- --------------------------------------------------------

--
-- Structure de la table excursion
--

CREATE TABLE excursion
(
    pathId         int(11) NOT NULL,
    userId           int(11) NOT NULL,
    bikeId           int(11) DEFAULT -1,
    departure       datetime          DEFAULT NULL,
    arrival       datetime          DEFAULT NULL,
    PRIMARY KEY (userId, departure),
    FOREIGN KEY (userId) REFERENCES user (id),
    FOREIGN KEY (pathId) REFERENCES path (id),
    FOREIGN KEY (bikeId) REFERENCES bike (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table sortie
--

INSERT INTO excursion (pathId, userId, departure, arrival, bikeId)
VALUES (1, 1, '2022-09-30 08:15:00', '2022-09-30 12:20:00', 1),
       (2, 2, '2022-09-23 08:15:00', '2022-09-23 12:45:00', 3);

-- --------------------------------------------------------

--
-- Structure de la table purchase
--

CREATE TABLE purchase
(
    bikeId   int(11) NOT NULL,
    userId  int(11) NOT NULL,
    purchaseDate date    NOT NULL,
    PRIMARY KEY (bikeId, userId, purchaseDate),
    FOREIGN KEY (bikeId) REFERENCES bike (id),
    FOREIGN KEY (userId) REFERENCES user (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table purchase
--

INSERT INTO purchase (bikeId, userId, purchaseDate)
VALUES (1, 1, '2013-11-10'),
       (2, 1, '2018-05-12'),
       (3, 2, '2020-09-15');

-- --------------------------------------------------------

--
-- Structure de la table step
--

CREATE TABLE step
(
    id   int(11) NOT NULL AUTO_INCREMENT,
    location  char(25)        DEFAULT NULL,
    latitude   decimal(16, 14) DEFAULT NULL,
    longitude  decimal(16, 14) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table step
--

INSERT INTO step (id, location, latitude, longitude)
VALUES (1, 'RONTALON', '45.66052627560000', '4.63221406937000'),
       (2, 'COL DE LA LUERE', '45.76320538304853', '4.62908812807553'),
       (3, 'SAINT ANDRE LA COTE', '45.63100000000000', '4.60100000000000'),
       (4, 'COL DE MALVAL', '45.74772421385712', '4.61158104883301'),
       (5, 'SAINT MARTIN EN HAUT', '45.66000000000000', '4.55900000000000'),
       (6, 'DUERNE', '45.68635971090647', '4.52697130259405'),
       (7, 'SAINTE CATHERINE', '45.39582000000000', '-73.56574300000000'),
       (8, 'AVEIZE', '45.68026051032419', '4.48057381147755'),
       (9, 'Intersection', '45.62861466155582', '4.52521573815698'),
       (10, 'GREYZIEU LE MARCHE', '45.66182791270027', '4.42396251904246'),
       (11, 'SAINTE FOY L\'ARGENTIERE', '45.70569896294748', '4.47046508170943'),
       (12, 'CROIX PERRIERE', '45.68594298751449', '4.57593439831060'),
       (13, 'MONTROMANT', '45.70802393301300', '4.52539125664541'),
       (14, 'COL DES BROSSES', '45.70682093090597', '4.55467737970977'),
       (15, 'LA CROIX DE PARS', '45.72126840968257', '4.56804910562751'),
       (16, 'POLLIONNAY', '45.76592776077334', '4.66072522354320'),
       (17, 'SAINTE CONSORCE', '45.77646635536404', '4.69614559515543'),
       (18, 'SAINT GENIS LES OLLIERES', '45.75796018172125', '4.72596372582408');

-- --------------------------------------------------------

--
-- Structure de la table pathStep
--

CREATE TABLE pathStep
(
    pathId int(11) NOT NULL,
    stepId   int(11) NOT NULL,
    position  int(11) NOT NULL,
    FOREIGN KEY (pathId) REFERENCES path (id),
    FOREIGN KEY (stepId) REFERENCES step (id),
    PRIMARY KEY (pathId, position)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table pathStep
--

INSERT INTO pathStep (pathId, stepId, position)
VALUES (1, 1, 1),
       (1, 3, 2),
       (1, 5, 3),
       (1, 7, 4),
       (1, 9, 5),
       (1, 9, 6),
       (1, 12, 7),
       (1, 14, 8),
       (1, 4, 9),
       (1, 2, 10),
       (1, 16, 11),
       (1, 17, 12),
       (1, 18, 13),
       (2, 2, 1),
       (2, 4, 2),
       (2, 6, 3),
       (2, 8, 4),
       (2, 10, 5),
       (2, 11, 6),
       (2, 13, 7),
       (2, 15, 8),
       (2, 9, 9),
       (2, 4, 10),
       (2, 2, 11),
       (2, 16, 12),
       (2, 17, 13),
       (2, 18, 14);

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
