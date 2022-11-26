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
-- Structure de la table utilisateur
--

CREATE TABLE utilisateur
(
    num_util       int(11) NOT NULL AUTO_INCREMENT,
    pseudo_util    varchar(50) NOT NULL,
    nom_util       char(20)      DEFAULT NULL,
    prenom_util    char(20)      DEFAULT NULL,
    mdp_util       char(100)      DEFAULT NULL,
    date_naissance date          DEFAULT NULL,
    taille         decimal(6, 2) DEFAULT NULL,
    poids          decimal(6, 2) DEFAULT NULL,
    PRIMARY KEY (num_util)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table utilisateur
--

INSERT INTO utilisateur (pseudo_util, nom_util, prenom_util, date_naissance, taille, poids, mdp_util)
VALUES ('GALLOIS_Jean', 'GALLOIS', 'Jean', '1964-04-23', '183.00', '75.00', '$2a$04$CQCsj3BONbDGpAfw60a2vedagwH1jUxRt4O8Se9YdfTVyvF/YerlS'),
       ('VILLE_Pierre', 'VILLE', 'Pierre', '1962-04-12', '173.00', '69.00', '$2a$04$CQCsj3BONbDGpAfw60a2vedagwH1jUxRt4O8Se9YdfTVyvF/YerlS'),
       ('Merlot', 'MICHON', 'John', '2001-09-11', '182.00', '80,50', '$2a$04$CQCsj3BONbDGpAfw60a2vedagwH1jUxRt4O8Se9YdfTVyvF/YerlS');

-- --------------------------------------------------------

--
-- Structure de la table sortie
--

CREATE TABLE sortie
(
    num_sortie         int(11) NOT NULL AUTO_INCREMENT,
    num_util           int(11) NOT NULL,
    date_sortie        date          DEFAULT NULL,
    heure_depart       time          DEFAULT NULL,
    heure_arrivee      time          DEFAULT NULL,
    lieu_depart        char(30)      DEFAULT NULL,
    distance_parcourue decimal(6, 2) DEFAULT NULL,
    PRIMARY KEY (num_sortie),
    FOREIGN KEY (num_util) REFERENCES utilisateur (num_util)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table sortie
--

INSERT INTO sortie (num_sortie, num_util, date_sortie, heure_depart, heure_arrivee, lieu_depart, distance_parcourue)
VALUES (1, 1, '2022-09-30', '08:15:00', '12:20:00', 'SAINT GENIS LES OLLLIERES', '86.20'),
       (2, 2, '2022-09-23', '08:15:00', '12:45:00', 'SAINT GENIS LES OLLLIERES', '88.10');

-- --------------------------------------------------------

--
-- Structure de la table velo
--

CREATE TABLE velo
(
    id_velo  int(11) NOT NULL AUTO_INCREMENT,
    nom_velo char(20)      DEFAULT NULL,
    roues    decimal(6, 2) DEFAULT NULL,
    casette  char(10)      DEFAULT NULL,
    PRIMARY KEY (id_velo)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table velo
--

INSERT INTO velo (id_velo, nom_velo, roues, casette)
VALUES (1, 'LAPIERRE X-CONTROL 3', '29.00', '11/42'),
       (2, 'CANONDALE SYNASPE', '700.00', '11/28'),
       (3, 'CUBE Kathmandu Hybri', '29.00', '11/52');


-- --------------------------------------------------------

--
-- Structure de la table vae
--

CREATE TABLE vae
(
    id_velo            int(11) NOT NULL,
    puissance_moteur   int(11)       DEFAULT NULL,
    puissance_batterie int(11)       DEFAULT NULL,
    PRIMARY KEY (id_velo),
    FOREIGN KEY (id_velo) REFERENCES velo (id_velo)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table vae
--

INSERT INTO vae (id_velo, puissance_moteur, puissance_batterie)
VALUES (3, 250, 625);

-- --------------------------------------------------------

--
-- Structure de la table vtt
--

CREATE TABLE vtt
(
    id_velo  int(11) NOT NULL,
    PRIMARY KEY (id_velo),
    FOREIGN KEY (id_velo) REFERENCES velo (id_velo)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table vtt
--

INSERT INTO vtt (id_velo)
VALUES (1);

-- --------------------------------------------------------

--
-- Structure de la table route
--

CREATE TABLE route
(
    id_velo    int(11) NOT NULL,
    type_cadre char(20)      DEFAULT NULL,
    PRIMARY KEY (id_velo),
    FOREIGN KEY (id_velo) REFERENCES velo (id_velo)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table route
--

INSERT INTO route (id_velo, type_cadre)
VALUES (2, 'CARBONE');


-- --------------------------------------------------------

--
-- Structure de la table achete
--

CREATE TABLE achete
(
    id_velo   int(11) NOT NULL,
    num_util  int(11) NOT NULL,
    date_jour date    NOT NULL,
    PRIMARY KEY (id_velo, num_util, date_jour),
    FOREIGN KEY (id_velo) REFERENCES velo (id_velo),
    FOREIGN KEY (num_util) REFERENCES utilisateur (num_util)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table achete
--

INSERT INTO achete (id_velo, num_util, date_jour)
VALUES (1, 1, '2013-11-10'),
       (2, 1, '2018-05-12'),
       (3, 1, '2020-09-15');

-- --------------------------------------------------------

--
-- Structure de la table etape
--

CREATE TABLE etape
(
    id_etape   int(11) NOT NULL AUTO_INCREMENT,
    nom_etape  char(25)        DEFAULT NULL,
    latitude   decimal(16, 14) DEFAULT NULL,
    longitude  decimal(16, 14) DEFAULT NULL,
    PRIMARY KEY (id_etape),
    UNIQUE KEY (id_etape)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table etape
--

INSERT INTO etape (id_etape, nom_etape, latitude, longitude)
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
-- Structure de la table sortie_etape
--

CREATE TABLE sortie_etape
(
    num_sortie int(11) NOT NULL,
    id_etape   int(11) NOT NULL,
    num_etape  int(11) NOT NULL,
    PRIMARY KEY (num_sortie, id_etape, num_etape),
    FOREIGN KEY (num_sortie) REFERENCES sortie (num_sortie),
    FOREIGN KEY (id_etape) REFERENCES etape (id_etape)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Déchargement des données de la table sortie_etape
--

INSERT INTO sortie_etape (num_sortie, id_etape, num_etape)
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
