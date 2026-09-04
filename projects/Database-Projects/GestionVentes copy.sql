-- 420-921-MA Bases de données – TP3
-- Étudiant : Felipe Acevedo
-- Gr 1234, session H24
--=========================
--Premiere Products SQL Database 

CREATE DATABASE GestionVentes;
GO

USE GestionVentes;
GO


-- creation table Repreresentant
CREATE TABLE Repreresentant(
	numR CHAR(2) PRIMARY KEY,
	nomR CHAR(15),
	prenomR CHAR(15),
	rueR CHAR(15),
	villeR CHAR(15),
	etatR CHAR(2),
	codePostalR CHAR(5),
	commission DECIMAL(7,2),
	taux DECIMAL(3,2) 
	); 
	
-- creation table Client	
CREATE TABLE Client(
	numC CHAR(3) PRIMARY KEY,
	nomC CHAR(35) NOT NULL, 
	rueC CHAR(15),
	villeC CHAR(15), 
	etatC CHAR(2), 
	codePostalC CHAR(5),
	balance DECIMAL(8,2),
	limite_credit DECIMAL(8,2),
	numRepresentant CHAR(2),
	CONSTRAINT FK_Client_Representant FOREIGN KEY(numRepresentant) REFERENCES Repreresentant(numR)
	);
	
-- creation table Commande
CREATE TABLE Commande(
	numCommande CHAR(5) PRIMARY KEY,
	dateCommande DATE,
	numClient CHAR(3),
	CONSTRAINT FK_Commande_Client FOREIGN KEY(numClient) REFERENCES Client(numC)
	); 
	
-- creation table piece
CREATE TABLE PIECE(
	numPiece CHAR(4) PRIMARY KEY, 
	DESCRIPTION CHAR(15),
	nbDisp DECIMAL(4,0), 
	classe CHAR(2), 
	entrepot CHAR(1), 
	prix_unitaire DECIMAL(6,2) 
	); 

-- creation table lignesCommande
CREATE TABLE lignesCommande (
	numCommande CHAR(5),
	numPiece CHAR(4),
	nbCommandes DECIMAL(3,0),
	prix_annonce DECIMAL(6,2),
	PRIMARY KEY (numCommande, numPiece),
	CONSTRAINT FK_lignesCommande_Commande FOREIGN KEY(numCommande) REFERENCES Commande(numCommande),
	CONSTRAINT FK_lignesCommande_Piece FOREIGN KEY(numPiece) REFERENCES Piece(numPiece)
	);



--Enregistrements de la table Representant
INSERT INTO Repreresentant VALUES ('20','Kaiser','Valerie','624 Randall','Grove','FL','33321',20542.50,0.05),
                       ('35','Hull','Richard','532 Jackson','Sheldon','FL','33553',39216.00,0.07),
                       ('65','Perez','Juan','1626 Taylor','Fillmore','FL','33336',23487.00,0.05);

--Enregistrements de la table Client
INSERT INTO Client VALUES ('148','Al''s Appliance and Sport','2837 Greenway','Fillmore','FL','33336',6550.00,7500.00,'20'), 
                            ('282','Brookings Direct','3827 Devon','Grove','FL','33321',431.50,10000.00,'35'), 
                            ('356','Ferguson''s','382 Wildwood','Northfield','FL','33146',5785.00,7500.00,'65'),
                            ('408','The Everything Shop','1828 Raven','Crystal','FL','33503',5285.25,5000.00,'35'),
                            ('462','Bargains Galore','3829 Central','Grove','FL','33321',3412.00,10000.00,'65'), 
                            ('524','Kline''s','838 Ridgeland','Fillmore','FL','33336',12762.00,15000.00,'20'),
                            ('608','Johnson''s Department Store','372 Oxford','Sheldon','FL','33553',2106.00,10000.00,'65'), 
                            ('687','Lee''s Sport and Appliance','282 Evergreen','Altonville','FL','32543',2851.00,5000.00,'35'), 
                            ('725','Deerfield''s Four Seasons','282 Columbia','Sheldon','FL','33553',248.00,7500.00,'35'),
                            ('842','All Season','28 Lakeview','Grove','FL','33321',8221.00,7500.00,'20');



--Enregistrements de la table Piece
INSERT INTO Piece VALUES ('AT94','Iron',50,'HW','3',24.95), 
                        ('BV06','Home Gym',45,'SG','2',794.95), 
                        ('CD52','Microwave Oven',32,'AP','1',165.00), 
                        ('DL71','Cordless Drill',21,'HW','3',129.95), 
                        ('DR93','Gas Range',8,'AP','2',495.00),
                        ('DW11','Washer',12,'AP','3',399.99),
                        ('FD21','Stand Mixer',22,'HW','3',159.95), 
                        ('KL62','Dryer',12,'AP','1',349.95),
                        ('KT03','Dishwasher',8,'AP','3',595.00), 
                        ('KV29','Treadmill',9,'SG','2',1390.00);

--Enregistrements de la table Commande 
INSERT INTO Commande VALUES ('21608','20-OCT-2003','148'), 
                          ('21610','20-OCT-2003','356'),
                          ('21613','21-OCT-2003','408'), 
                          ('21614','21-OCT-2003','282'), 
                          ('21617','23-OCT-2003','608'), 
                          ('21619','23-OCT-2003','148'), 
                          ('21623','23-OCT-2003','608');

--Enregistrements de la table ligneCommande
INSERT INTO lignesCommande VALUES ('21608','AT94',11,21.95),
                              ('21610','DR93',1,495.00),
                              ('21610','DW11',1,399.99), 
                              ('21613','KL62',4,329.95), 
                              ('21614','KT03',2,595.00), 
                              ('21617','BV06',2,794.95), 
                              ('21617','CD52',4,150.00), 
                              ('21619','DR93',1,495.00), 
                              ('21623','KV29',2,1290.00);

--1. Créez une procédure stockée sp_1 qui accepte le numéro de client dans le paramètre
--@NumClient et retourne le nom et la limite de crédit du client dans les paramètres de sortie
--@NomClient et @LimiteCredit, respectivement.
--Appelez votre procédure avec EXEC pour tester son fonctionnement.



CREATE PROCEDURE sp_1
    @NumClient CHAR(3),
    @NomClient CHAR(35) OUTPUT,
    @LimiteCredit DECIMAL(8,2) OUTPUT
AS
BEGIN
    SELECT @NomClient = nomC, @LimiteCredit = limite_credit
    FROM Client
    WHERE numC = @NumClient;
END;
DECLARE @NomClient CHAR(35), @LimiteCredit DECIMAL(8,2)
EXEC sp_1 '148', @NomClient OUTPUT, @LimiteCredit OUTPUT
SELECT @NomClient AS NomClient, @LimiteCredit AS LimiteCredit;



--2. Créez une procédure stockée sp_2 qui accepte le numéro de client dans le paramètre
--@NumClient et le montant d'augmentation de crédit dans le paramètre @AugmCredit. La
--procédure doit augmenter la limite de crédit du client spécifié du montant indiqué.
--Appelez votre procédure avec EXEC pour tester son fonctionnement.

CREATE PROCEDURE sp2
    @NumClient CHAR(3),
    @AugmCredit DECIMAL(8,2)
AS
BEGIN
    UPDATE Client
    SET limite_credit = limite_credit + @AugmCredit
    WHERE numC = @NumClient;
END;

EXEC sp_2 '148', 1000.00;
SELECT * FROM Client WHERE numC = '148'


--3. Créez une procédure stockée sp_3 qui accepte le numéro de représentant dans le paramètre
--@NumRepr. Cette procédure doit utiliser un curseur pour parcourir la table "Repreresentant"
--et afficher avec PRINT : le nom complet du représentant, son numéro et le montant total de
--toutes les ventes qu'il a effectuées.
--Appelez votre procédure avec EXEC pour tester son fonctionnement.

CREATE PROCEDURE sp_3
    @NumRepr CHAR(2)
AS
BEGIN
    DECLARE @NomComplet VARCHAR(50)
    DECLARE @MontantTotal DECIMAL(10, 2)

    DECLARE curRepr CURSOR FOR
    SELECT CONCAT(nomR, ' ', prenomR) AS NomComplet, numR
    FROM Repreresentant
    WHERE numR = @NumRepr;

    OPEN curRepr;

    FETCH NEXT FROM curRepr INTO @NomComplet, @NumRepr;

    WHILE @@FETCH_STATUS = 0
    BEGIN
        SELECT @MontantTotal = SUM(prix_annonce)
        FROM lignesCommande lc
        INNER JOIN Commande c ON lc.numCommande = c.numCommande
        WHERE c.numClient IN (
                SELECT numC
                FROM Client
                WHERE numRepresentant = @NumRepr
                );

        PRINT 'Nom Complet: ' + @NomComplet + ', Numéro: ' + @NumRepr + ', Montant Total des Ventes: ' + CONVERT(VARCHAR(20), @MontantTotal);

        FETCH NEXT FROM curRepr INTO @NomComplet, @NumRepr;
    END;

    CLOSE curRepr;
    DEALLOCATE curRepr;
END;

EXEC sp_3 '20';


--4. Écrivez une fonction stockée dbo.f_1 qui accepte le numéro de pièce dans le paramètre
--@NumPiece et retourne le nombre total commandé pour cette pièce.
--Testez votre fonction avec une requête SELECT affichant 2 colonnes à partir de la table
--"Piece" : numéro de pièce et quantité totale commandée.

CREATE FUNCTION dbo.f_1
(
    @NumPiece CHAR(4)
)
RETURNS DECIMAL(10, 0)
AS
BEGIN
    DECLARE @TotalCommande DECIMAL(10, 0);

    SELECT @TotalCommande = SUM(nbCommandes)
    FROM lignesCommande
    WHERE numPiece = @NumPiece;

    RETURN ISNULL(@TotalCommande, 0);
END;

SELECT numPiece, dbo.f_1(numPiece) AS QuantiteTotaleCommandee
FROM Piece;


--5. Écrivez une fonction stockée f_2 qui accepte le numéro de pièce dans le paramètre @NumPiece
--et retourne une table avec les noms des clients ayant acheté cette pièce, ainsi que les numéros
--et les dates de commandes correspondantes.
--Testez votre fonction avec une requête SELECT.

CREATE FUNCTION dbo.f_2
(
    @NumPiece CHAR(4)
)
RETURNS @Result TABLE
(
    NomClient VARCHAR(35),
    NumCommande CHAR(5),
    DateCommande DATE
)
AS
BEGIN
    INSERT INTO @Result (NomClient, NumCommande, DateCommande)
    SELECT c.nomC, cmd.numCommande, cmd.dateCommande
    FROM Client c
    JOIN Commande cmd ON c.numC = cmd.numClient
    JOIN lignesCommande lc ON cmd.numCommande = lc.numCommande
    WHERE lc.numPiece = @NumPiece;

    RETURN;
END;

SELECT * FROM dbo.f_2('AT94');



--6. Écrivez un déclencheur trg_1 qui s'exécute avant la suppression d'une commande et qui
--supprime tous les enregistrements de "lignesCommande" correspondants avant de supprimer la
--commande.
--Créez un scénario qui teste le fonctionnement de votre déclencheur.

CREATE TRIGGER trg_1
ON Commande
INSTEAD OF DELETE
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @NumCommande CHAR(5);

    SELECT @NumCommande = numCommande
    FROM DELETED;

    DELETE FROM lignesCommande
    WHERE numCommande = @NumCommande;

    DELETE FROM Commande
    WHERE numCommande = @NumCommande;
END;


DELETE FROM Commande WHERE numCommande = '21608';
SELECT * FROM Commande


--7. Ajoutez la table suivante dans la BD "GestionVentes" :
CREATE TABLE LogClientBalance (
idLog INT PRIMARY KEY IDENTITY,
numClient CHAR(3),
ancienneBalance DECIMAL(8,2),
nouvelleBalance DECIMAL(8,2),
dateChangement DATE
);
GO

INSERT INTO LogClientBalance (numClient, ancienneBalance, nouvelleBalance, dateChangement)
VALUES 
        ('148', 6550.00,7500.00, '2024-03-15'), 
        ('282', 431.50,10000.00, '2024-03-18'), 
        ('356', 5785.00,7500.00, '2024-03-15'),
        ('408', 5285.25,5000.00, '2024-03-18'),
        ('462', 3412.00,10000.00, '2024-03-15'), 
        ('524', 12762.00,15000.00, '2024-03-18'),
        ('608', 2106.00,10000.00, '2024-03-15'), 
        ('687', 2851.00,5000.00, '2024-03-15'), 
        ('725', 248.00,7500.00, '2024-03-18'),
        ('842', 8221.00,7500.00, '2024-03-15');



--Créez un déclencheur trg_2 qui s'exécute après la modification de la balance d'un client. Ce
--déclencheur doit insérer un nouvel enregistrement dans "LogClientBalance" avec les
--informations pertinentes.
--Créez un scénario qui teste le fonctionnement de votre déclencheur.



CREATE TRIGGER trg_2
ON Client
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    IF UPDATE(balance)
    BEGIN
        DECLARE @numClient CHAR(3);
        DECLARE @ancienneBalance DECIMAL(8, 2);
        DECLARE @nouvelleBalance DECIMAL(8, 2);
        DECLARE @dateChangement DATE;

        SELECT @numClient = d.numC,
               @ancienneBalance = d.balance,
               @nouvelleBalance = i.balance,
               @dateChangement = GETDATE()
        FROM inserted i
        JOIN deleted d ON i.numC = d.numC;

        INSERT INTO LogClientBalance (numClient, ancienneBalance, nouvelleBalance, dateChangement)
        VALUES (@numClient, @ancienneBalance, @nouvelleBalance, @dateChangement);
    END
END;
SELECT * FROM Client
SELECT * FROM LogClientBalance


UPDATE Client
SET balance = 5500.00
WHERE numC = '148';

SELECT * FROM Client
SELECT * FROM LogClientBalance



SELECT OBJECTPROPERTY(OBJECT_ID('trg_2'), 'ExecIsTriggerDisabled') AS IsTriggerDisabled;
ENABLE TRIGGER trg_2 ON Client;
SELECT OBJECTPROPERTY(OBJECT_ID('trg_2'), 'ExecIsTriggerDisabled') AS IsTriggerDisabled;
sp_helptrigger 'Client'