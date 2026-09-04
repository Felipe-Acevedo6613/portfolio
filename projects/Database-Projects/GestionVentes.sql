-- 420-921-MA Bases de données – TP2
-- Étudiant : Felipe Acevedo
-- Gr 23611, session H24
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



-- 420-921-MA Bases de données – TP2
-- Étudiant : Felipe Acevedo
-- Gr 23611, session H24
--=========================


/*Question 1 Indiquez le numéro de pièce et la description de chaque pièce qui ne se trouve
pas dans la classe d’article HW et qui a entre 10 et 25 unités disponibles.
Ordonner la sortie par numéro de pièce dans la classe d’article. (C’est-à-dire,
ordonner la sortie par classe d’article, puis par numéro de pièce.)*/
SELECT numPiece, DESCRIPTION
FROM PIECE
WHERE classe NOT LIKE 'HW' 
AND nbDisp BETWEEN 10 AND 25;


/*Question 2. Énumérez les noms et l’adresse complète (en une seule colonne) des clients et
dont la limite de crédit est d’au moins 10 000$ et dont le nom commence par D.*/
 SELECT  CONCAT(nomC+''+rueC, ' ', villeC, ' ', etatC) AS Nom_et_Adresse_Complete 
 FROM Client WHERE limite_credit <= 10000 ANd nomC LIKE 'D%';


 /*Question 3. Affichez les 3 pièces les plus chères dans la base de données*/
 SELECT TOP 3 * FROM PIECE ORDER BY prix_unitaire DESC;

 
 /*Question 4. Indiquez le numéro de pièce, la description de la pièce et la valeur disponible
(valeur disponible = unités disponibles * prix unitaire) de chaque pièce dans la classe d’article ‘AP'.*/
SELECT numPiece , DESCRIPTION, (nbDisp * prix_unitaire) AS Valeur_Disponible FROM PIECE WHERE classe LIKE 'AP';


/*Question 5. Affichez la somme des soldes de tous les clients pour chaque représentant
commercial. Regroupez les résultats par numéro de commercial.*/
SELECT R.numR, SUM(C.balance) AS somme_soldes
FROM Client C
JOIN Repreresentant R ON C.numRepresentant = R.numR
GROUP BY C.numRepresentant, R.numR;


/*Question 6. Énumérez la somme des soldes de tous les clients pour chaque représentant
commercial, mais limitez la production aux représentants commerciaux pour
lesquels la somme est supérieure à 10 000 $.*/
SELECT C.numRepresentant, R.nomR, R.prenomR, SUM(C.balance) AS somme_soldes
FROM Client C
JOIN Repreresentant R ON C.numRepresentant = R.numR
GROUP BY C.numRepresentant, R.nomR, R.prenomR
HAVING SUM(C.balance) > 10000;


/*Question 7. Combien de clients ont des soldes inférieurs à leurs limites de crédit? On doit
afficher le nombre par état (State).*/
SELECT etatC AS State, COUNT(*) AS nombre_clients
FROM Client
WHERE balance < limite_credit
GROUP BY etatC;
 
/*Question 8. Trouvez le total des soldes de tous les clients représentés par le représentant
commercial 65 dont les soldes sont inférieurs à leurs limites de crédit.*/
SELECT SUM(balance) AS total_soldes_Clients_R_65 FROM Client
WHERE numRepresentant = '65' AND balance < limite_credit;


/*Question 9. Utilisez l’opérateur IN pour trouver le numéro et le nom de chaque client qui
a passé une commande le 21 octobre 2023.*/
SELECT C.numC, C.nomC
FROM Client C
WHERE C.numC IN (
    SELECT DISTINCT CO.numClient
    FROM Commande CO
    WHERE CO.dateCommande = '2023-10-21'
);
 

/*Question 10. Répétez la question précédente à l’aide de l’opérateur EXISTS.*/
SELECT C.numC, C.nomC
FROM Client C
WHERE EXISTS (
    SELECT *
    FROM Commande CO
    WHERE CO.dateCommande = '2023-10-21' 
	--AND CO.numClient = C.numC
);

/*Question 11. Indiquez le numéro de pièce, la description de la pièce et la valeur disponible
de chaque pièce dont le nombre d’unités disponibles est supérieur au nombre
moyen d’unités disponibles pour toutes les pièces. (Utilisez une sous requête.)*/
SELECT numPiece, DESCRIPTION, (nbDisp * prix_unitaire) AS 'valeur disponible'
FROM PIECE
WHERE nbDisp > (
    SELECT AVG(nbDisp)
    FROM PIECE
);


--Question 12.Indiquez le numéro et le nom de chaque client représenté Valerie Kaiser ou par Juan Perez.
SELECT numC, nomC 
FROM Client C INNER JOIN Repreresentant R ON C.numRepresentant = R.numR
WHERE R.prenomR = 'Valerie' AND R.nomR = 'Kaiser' OR R.prenomR = 'Juan' AND R.nomR = 'Perez';



--Question 13. Pour chaque commande passée le 21 octobre 2023, indiquez le numéro de 
--commande ainsi que le numéro et le nom du client qui a passé la commande.
SELECT CO.numCommande, CO.numClient, C.nomC 
FROM Commande CO INNER JOIN Client C ON CO.numClient = C.numC
WHERE CO.dateCommande = '21-OCT-2023';




--Question 14. Pour chaque commande, indiquez le numéro de commande, la date de  commande, le numéro de pièce, le nombre d'unités commandées et le prix 
--annoncé pour chaque ligne de commande (dans lignesCommande) qui compose la commande.
SELECT C.numCommande, dateCommande, numPiece, nbCommandes, prix_annonce 
FROM Commande C INNER JOIN lignesCommande L ON  C.numCommande = L.numCommande;




--Question 15.Pour chaque commande, indiquez le numéro de commande, la date de commande et le montant total de cette commande. Le montant total étant la 
--somme de (prix_annonce * nbPiecesCommandees) pour chaque ligne de  commande (order_line) qui compose la commande.
--On affichera seulement les commandes dont le montant total est > 500$
SELECT C.numCommande, dateCommande, (prix_annonce * nbCommandes) AS 'Montant Total' 
FROM Commande C INNER JOIN lignesCommande L ON C.numCommande = L.numCommande
WHERE prix_annonce > 500;




--Question 16.Utilisez une sous-requête pour trouver le numéro de représentant, le nom et le prénom de chaque représentant commercial qui représente au moins un client
--avec une limite de crédit de 5000 $. Répertoriez chaque représentant commercial une seule fois dans les résultats.

SELECT DISTINCT (numR), nomR, prenomR FROM Repreresentant R INNER JOIN Client C ON R.numR = C.numRepresentant
WHERE EXISTS (
	SELECT *
	FROM Client C
	WHERE limite_credit = 5000
);



--Question 17.Trouvez le numéro et le nom de chaque client qui a actuellement une commande dans son dossier pour une pièce "Gas Range". 
SELECT numC, nomC FROM Client C INNER JOIN Commande Cm ON C.numC = Cm.numClient
INNER JOIN lignesCommande LG ON Cm.numCommande = LG.numCommande 
INNER JOIN PIECE P ON LG.numPiece = P.numPiece
WHERE P.DESCRIPTION LIKE 'Gas Range';


--Question 18.Indiquez le numéro de commande et la date de commande pour chaque commande passée par le client nommé "Johnson's Department Store".
SELECT numCommande, dateCommande 
FROM Commande C INNER JOIN  Client CL ON C.numClient = CL.numC
WHERE CL.nomC = 'Johnson''s Department Store';
 
--Question 19. Indiquez le numéro de commande et la date de commande pour chaquecommande contenant une ligne de commande pour une pièce "Iron".

SELECT C.numCommande, dateCommande FROM Commande C 
INNER JOIN lignesCommande LC ON C.numCommande = LC.numCommande
INNER JOIN PIECE P ON LC.numPiece = P.numPiece
WHERE DESCRIPTION LIKE 'IRON';



--Question 20. Quels sont les numéros et les descriptions de pièces qui n’ont jamais étécommandé par "Johnson’s Department Store" ?
SELECT P.numPiece, DESCRIPTION FROM PIECE P 
INNER JOIN lignesCommande LC ON P.numPiece = LC.numPiece
INNER JOIN Commande C ON LC.numCommande = C.numCommande
INNER JOIN Client CL ON   C.numClient = CL.numC
WHERE CL.nomC != 'Johnson''s Department Store'
