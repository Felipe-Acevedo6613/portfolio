--FELIPE ACEVEDO

-- Creation de la base de donnees
CREATE DATABASE cegep;
Go
-- Selection de la base de donnees
USE cegep;

-- Creation de la table Etudiant
CREATE TABLE Etudiant (
    ID_Etudiant INT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
	sexe char(1) NOT NULL,
    date_naissance DATE,
    adresse VARCHAR(100),
    telephone VARCHAR(20),
    courriel VARCHAR(100) UNIQUE,
	constraint pk_etudiant PRIMARY KEY(ID_Etudiant)
);

-- Creation de la table Enseignant
CREATE TABLE Enseignant (
    ID_Enseigant INT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
	sexe char(1) NOT NULL,
    date_naissance DATE,
    adresse VARCHAR(100),
    telephone VARCHAR(20),
    courriel VARCHAR(100) UNIQUE,
    departement VARCHAR(50) NOT NULL,
	constraint pk_enseigant PRIMARY KEY(ID_Enseigant)
);

-- Creation de la table Cours
CREATE TABLE Cours (
    ID_cours INT,
	code_cours char(7),
    nom VARCHAR(50) NOT NULL,
	session CHAR(1) NOT NULL,
	annee INT NOT NULL,
	Groupe INT NOT NULL,
	enseignant_responsable INT,
	constraint pk_cours PRIMARY KEY(ID_Cours),
    constraint fk_cours_enseignant FOREIGN KEY (enseignant_responsable) REFERENCES Enseignant(ID_Enseigant)
);

-- Creation de la table Inscription
CREATE TABLE Inscription (
    ID_Inscription INT identity(1,1),
    ID_etudiant INT NOT NULL,
    ID_cours INT NOT NULL,
    date_inscription DATE NOT NULL,
	note INT,
	constraint pk_inscription PRIMARY KEY(ID_Inscription),
    constraint fk_inscription_etudiant FOREIGN KEY (ID_etudiant) REFERENCES Etudiant(ID_Etudiant),
    constraint fk_inscription_cours FOREIGN KEY (ID_cours) REFERENCES Cours(ID_cours)
);

-- Insertion etudiants
INSERT INTO Etudiant(ID_Etudiant, nom, prenom,sexe, date_naissance, adresse, telephone, courriel) 
		VALUES (1, 'Tremblay', 'Jean', 'M', '2000-05-01', '123 Rue de la Montagne, Boucherville', '514-123-4567', 'jean.tremblay@cegep.qc.ca'),
			 (2, 'Gagnon', 'Marie', 'F', '2001-02-14', '456 Rue Sainte-Catherine Est, Montreal', '514-234-5678', 'marie.gagnon@cegep.qc.ca'),
			 (3, 'Lapointe', 'Pierre', 'M', '1999-11-07', '789 Avenue Laurier Est, Montreal', '514-345-6789', 'pierre.lapointe@cegep.qc.ca'),
			 (4, 'Kazloo', 'Andras', 'M', '2002-04-02', '567 Rue Lajoie, Longueuil', '514-456-7890', 'Kazlou.andras@cegep.qc.ca'),
			 (5, 'Novak', 'Marta', 'F', '2003-06-12', '123 Rue Peel, Montreal', '514-567-8901', 'marta.novak@cegep.qc.ca'),
			 (6, 'Ali', 'Sara', 'F', '1998-09-23', '210 Rue Jean-Talon Est, Montreal', '514-678-9012', 'sara.ali@cegep.qc.ca'),
			 (7, 'Nguyen', 'Linh', 'M', '2000-08-18', '789 Boulevard RenE-LEvesque Est,Montreal', '514-789-0123', 'linh.nguyen@cegep.qc.ca'),
			 (8, 'Sato', 'Yuka', 'F', '1999-03-15', '456 Rue Saint-Denis, Montreal, Laval', '514-890-1234', 'yuka.sato@cegep.qc.ca'),
			 (9, 'Popescu', 'Andrei', 'M', '2002-11-24', '123 Boulevard Saint-Laurent, Ste-Rose', '418-901-2345', 'andrei.popescu@cegep.qc.ca'),
			 (10, 'Leroy', 'Gilles', 'M', '2001-05-09', '789 Avenue Mont-Royal Est, Ste-thErEse', '418-012-3456', 'gille.leroy@cegep.qc.ca'),
			 (11, 'Bouchard', 'Sophie', 'F', '2002-01-30', '123 Avenue du Parc, Montreal', '514-123-4567', 'sophie.bouchard@cegep.qc.ca'),
			 (12, 'Desjardin', 'Emilie', 'F', '1999-07-14', '456 Rue de la Commune Ouest, Lachenaie', '514-234-5678', 'emilie.desjardin@cegep.qc.ca'),
			 (13, 'Bokhari', 'Youssef', 'M', '1998-12-05', '789 Rue Sainte-Catherine Ouest', '514-345-6789', 'youssef.bokhari@cegep.qc.ca'),
			 (14,'Tremblay', 'Gabriel', 'M', '1999-07-12', '1234 Rue Emard, Repentigny', '514-871-6666', 'gabriel.tremblay@cegep.qc.ca'),
			 (15,'Nadeau', 'Sofia', 'F', '2000-03-25', '5678 Rue Ontario, Montreal', '514-555-7777', 'sofia.nadeau@cegep.qc.ca'),
			 (16,'Ibrahim', 'Amina', 'F', '1998-09-17', '9012 Rue Jean-Talon Est, Montreal', '514-325-8888', 'amina.ibrahim@cegep.qc.ca'),
			 (17,'Toure', 'Cheikh Ahmed', 'M', '1997-05-01', '3456 Rue Sainte-Catherine Ouest, Montreal', '514-555-9999', 'cheikhahmed.toure@cegep.qc.ca'),
			 (18,'Gagnon', 'Alexandre', 'M', '1999-12-02', '7890 Rue Saint-Denis, Montreal', '514-555-1111', 'alexandre.gagnon@cegep.qc.ca'),
			 (19,'Jean-Baptiste', 'Marie', 'F', '2001-02-14', '2345 Rue de l''aviation, Longueuil', '438-555-2222', 'marie.jeanbaptiste@cegep.qc.ca'),
			 (20, 'Alvarez', 'Juan', 'M', '1999-09-09', '6789 Rue Beaubien Est, Montreal', '514-224-3333', 'juan.alvarez@cegep.qc.ca'),
			 (21, 'Joseph', 'Isabelle', 'F', '2000-04-03', '3456 Rue Ontario Est, Montreal', '514-555-4444', 'joseph.isabelle@cegep.qc.ca');

-- Insertion Enseignant
INSERT INTO Enseignant (id_enseigant,nom, prenom, sexe, date_naissance, adresse, telephone, courriel, departement)
		VALUES	(1,'Gagnon', 'Julie', 'F', '1985-02-15', '12 Rue de Rome, Boucherville', '438-871-1234', 'prof.julie.gagnon@cegep.qc.ca','francais'),
				(2,'Sanchez', 'Helena', 'M', '1980-07-23', '34 Rue Saint-Denis, Montreal', '514-555-2345', 'prof.helena.sanchez@cegep.qc.ca','mathematiques'),
				(3,'Lapointe', 'Simon', 'M', '1978-12-10', '1234 Rue Pignon, Assomption', '438-555-6789', 'prof.simon.lapointe@cegep.qc.ca','physique'),
				(4,'Cote', 'Catherine', 'F', '1984-07-25', '5678 Rue Saint-Laurent, Montreal', '514-555-9876', 'prof.catherine.cote@cegep.qc.ca','chimie');


-- Insertion cours
INSERT INTO Cours (ID_cours,code_cours, nom, session,annee, groupe, enseignant_responsable) 
		VALUES (1,'601-101','Ecriture et littérature','H',2023, 1,1),
			 (2,'601-103', 'Litterature Quebecoise','H',2023, 1,1),
			 (3,'201-NYA', 'Calcul différentiel','H',2023, 1, 2),
			 (4,'201-NYB', 'Calcul intégral','H',2023, 1, 2),
			 (5,'203-NYB', 'Electricité et magnetisme','H',2022, 1, 3),
			 (6,'330-NYA', 'Mecanique','H',2021, 1, 3),
			 (7,'202-NYA', 'Chimie generale: la matiere','H',2021, 1, 4),
			 (8,'202-NYB', 'Chimie des solutions','H',2021, 1, 4);

-- Insertion isncriptions
INSERT INTO Inscription (ID_etudiant, ID_cours, date_inscription, note)
			VALUES(1, 1, '2023-01-05', NULL),
				(2, 1, '2023-01-05', NULL),
				(3, 1, '2023-01-05', NULL),
				(4, 1, '2023-01-05', NULL),
				(5, 1, '2023-01-05', NULL),
				(6, 1, '2023-01-05', NULL),
				(7, 1, '2023-01-05', NULL),
				(8, 1, '2023-01-05', 69),
				(9, 1, '2023-01-05', 89),
				(10, 1, '2023-01-05', 93),
				(8, 2, '2023-01-06', 78),
				(9, 2, '2023-01-06', 83),
				(10, 2, '2023-01-06', 68),
				(11, 2, '2023-01-06', NULL),
				(12, 2, '2023-01-06', NULL),
				(13, 2, '2023-01-06', NULL),
				(10, 2, '2023-01-06', NULL),
				(11, 2, '2023-01-06', NULL),
				(12, 2, '2023-01-06', NULL),
				(13, 2, '2023-01-06', NULL),
				(8, 3, '2023-01-06', NULL),
				(9, 3, '2023-01-06', NULL),
				(10, 3, '2023-01-06', NULL),
				(11, 3, '2022-08-27', NULL),
				(14, 3, '2023-01-07', NULL),
				(15, 3, '2023-01-07', NULL),
				(16, 3, '2023-01-07', NULL),
				(17, 3, '2023-01-07', NULL),
				(8, 4, '2023-01-07', 73),
				(9, 4, '2023-01-07', 80),
				(10, 4, '2023-01-07', 73),
				(11, 4, '2023-01-07', NULL),
				(14, 5, '2022-01-10', 82),
				(15, 5, '2022-01-10', 68),
				(16, 5, '2022-01-10', 71),
				(17, 5, '2022-01-10', 63),
				(18, 5, '2022-01-10', 93),
				(14, 5, '2022-01-10', 68),
				(15, 5, '2022-01-10', 83),
				(16, 5, '2022-01-10', 85),
				(17, 5, '2022-01-10', 79),
				(18, 5, '2022-01-10', 71),
				(19, 6, '2021-01-12', 59),
				(19, 7, '2021-01-12', 66),
				(19, 8, '2021-01-12', 73),
				(20, 6, '2021-01-12', 87),
				(20, 7, '2021-01-12', 92),
				(20, 8, '2021-01-12', 79);


--1.(25%)Écrire une procédure stockée ChercherCoursEtudiant qui accepte en paramètre
--@prenomEtudiant et @nomEtudiant et affiche le code, le nom, la session et l'année des cours
--auxquels un étudiant donné en paramètre est inscrit. La procédure retourne une erreur sil'étudiant n'existe pas.

CREATE PROCEDURE ChercherCoursEtudiant
    @prenomEtudiant VARCHAR(50),
    @nomEtudiant VARCHAR(50)
AS
BEGIN
    SET NOCOUNT ON;

    IF NOT EXISTS (SELECT 1 FROM Etudiant WHERE prenom = @prenomEtudiant AND nom = @nomEtudiant)
    BEGIN
        RAISERROR ('L''étudiant spécifié n''existe pas.', 16, 1)
        RETURN;
    END

    SELECT C.code_cours, C.nom, C.session, C.annee
    FROM Cours C
    INNER JOIN Inscription I ON C.ID_cours = I.ID_cours
    INNER JOIN Etudiant E ON I.ID_etudiant = E.ID_Etudiant
    WHERE E.prenom = @prenomEtudiant AND E.nom = @nomEtudiant;
END

EXEC ChercherCoursEtudiant 'Marie', 'Gagnon';



--2. (30%) Écrire une fonction stockée ListeEnseignantsEtudiant qui accepte en paramètre
--@prenomEtudiant et @nomEtudiant et retourne la liste des noms complets (prénom et nom
--dans une seule colonne), le courriel et le numéro de téléphone des enseignants qui ont enseigné
--à cet étudiant. Attention, un nom complet d'enseignant ne doit pas apparaître 2 fois.

CREATE FUNCTION ListeEnseignantsEtudiant (@prenomEtudiant VARCHAR(50), @nomEtudiant VARCHAR(50))
RETURNS TABLE
AS
RETURN
(
    SELECT DISTINCT CONCAT(E.prenom, ' ', E.nom) AS NomComplet,
                    E.courriel,
                    E.telephone
    FROM Enseignant E
    INNER JOIN Cours C ON E.ID_Enseigant = C.enseignant_responsable
    INNER JOIN Inscription I ON C.ID_cours = I.ID_cours
    INNER JOIN Etudiant Etu ON I.ID_etudiant = Etu.ID_Etudiant
    WHERE Etu.prenom = @prenomEtudiant AND Etu.nom = @nomEtudiant
);

SELECT * FROM ListeEnseignantsEtudiant('Marie', 'Gagnon');



--3.(30%)Créez un déclencheur trgVerifInscription qui, lors de l'insertion d'une nouvelle
--inscription dans la table "Inscription", vérifie si l'étudiant est déjà inscrit à un autre cours ayant
--le même code de cours (code_cours) mais enseigné à une session différente. Si c'est le cas, le
--déclencheur doit empêcher l'insertion de la nouvelle inscription et afficher un message d'erreur
--indiquant que l'étudiant est déjà inscrit à ce cours dans une autre session. On suppose qu'on
--insère toujours une seule inscription à la fois (donc pas besoin d'utiliser un curseur).

CREATE TRIGGER trgVerifInscription
ON Inscription
INSTEAD OF INSERT
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM inserted i
        JOIN Inscription ins ON i.ID_etudiant = ins.ID_etudiant
        JOIN Cours c ON i.ID_cours = c.ID_cours
        JOIN Cours c2 ON c.code_cours = c2.code_cours AND c.session != c2.session
        WHERE ins.ID_cours != i.ID_cours
    )
    BEGIN
        RAISERROR ('L''étudiant est déjà inscrit à ce cours dans une autre session.', 16, 1)
        ROLLBACK TRANSACTION;
        RETURN;
    END

    INSERT INTO Inscription (ID_etudiant, ID_cours, date_inscription, note)
    SELECT ID_etudiant, ID_cours, date_inscription, note
    FROM inserted;
END;

INSERT INTO Inscription (ID_etudiant, ID_cours, date_inscription, note)
VALUES (1, 2, '2024-04-05', NULL);
SELECT * FROM Inscription WHERE ID_etudiant = 1;


--4. (10%) Créez 3 connexions alain, alice et bob qui permettent d'accéder à la base Cegep
--a. Alice aura le droit de lire seulement le contenu de la base
--b. Alain aura le droit de lire et modifier les données des tables (SELECT, INSERT,UPDATE, DELETE). Il aura aussi le droit d'exécuter les ordres comme CREATE,ALTER et DROP
--c. Bob sera un administrateur de toute l'instance SQL




CREATE LOGIN alice WITH PASSWORD='abc.123456a';
ALTER ROLE db_datareader ADD MEMBER alice;

CREATE LOGIN alain WITH PASSWORD='abc.123456a';
ALTER SERVER ROLE db_ddladmin ADD MEMBER alain;

CREATE LOGIN bob WITH PASSWORD='abc.123456a';
ALTER SERVER ROLE Sysadmin ADD MEMBER bob;



--5. (5%) Comment interdire à Alice l'utilisation de SELECT sur la table Enseignant?
DENY SELECT ON dbo.Enseignant TO alice;
