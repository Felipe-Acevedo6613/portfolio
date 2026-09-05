const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs').promises;
const path = require('path');
const e = require('express');
const app = express();
const port = 3000;
// Démarrer le serveur
app.listen(port, () => {
    console.log(`Serveur démarré sur http://localhost:${port}`);
});
//  ******************** Fin de la configuration du serveur ********************

//  ************** Configuration de l'application. Voir les projets faits en classe **************

// Configuration du middleware pour analyser les requêtes JSON et URL-encodées
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname, 'publique')));

const cheminFichier = 'donnees/fleurs.json';

//  ******************** Fin de la configuration de l'application ********************

const lireFichierFleurs = async () => {
    const donnees = await fs.readFile(cheminFichier);
    return JSON.parse(donnees);
};

const ecrireFichierFleurs = async (fleurs) => {
    await fs.writeFile(cheminFichier, JSON.stringify(fleurs, null, 2));
};

app.get('/', (req, res) => {
    res.sendFile('index.html');
});

app.get('/fleurs', async (req, res) => {
    try {
        const listeFleurs = await lireFichierFleurs();
        res.json(listeFleurs);
    } catch (err) {
        res.send('Erreur de lecture du fichier');
    }
});

app.get('/fleurs/:id', async (req, res) => {
    try {
        const fleurId = parseInt(req.params.id);
        const listeFleurs = await lireFichierFleurs();
        const leFleur = listeFleurs.find(unFleur => unFleur.id == fleurId);
        if (!leFleur) {
            return res.status(404).send('Fleur non trouvé');
        }
        res.json(leFleur);
    } catch (erreur) {
        res.status(500).send('Erreur de lecture du fichier');
    }
});

app.get('/fleurs/categorie/:categorie', async (req, res) => {
    try {
        const categorie = req.params.categorie;
        const listeFleurs = await lireFichierFleurs();
        const listeFleursDuCategorie = listeFleurs.filter(unFleur => unFleur.categorie.toUpperCase() == categorie.toUpperCase());
        if (!listeFleursDuCategorie) {
            return res.status(404).send('Aucun Fleur de cette categorie');
        }
        res.json(listeFleursDuCategorie);
    } catch (erreur) {
        res.status(500).send('Erreur de lecture du fichier');
    }
});


app.post('/fleurs', async (req, res) => {
    try {
        const nouvelFleur = req.body;
        const listeFleurs = await lireFichierFleurs(); 
        nouvelFleur.id = listeFleurs[listeFleurs.length - 1].id + 1;
        listeFleurs.push(nouvelFleur);
        await ecrireFichierFleurs(listeFleurs);
        res.status(201).send('Fleur créé');
    } catch (err) {
        res.status(500).send('Erreur d\'écriture dans le fichier');
    }
});

app.delete('/fleurs/:id', async (req, res) => {
    try {
        const fleurId = parseInt(req.params.id); 
        let listeFleurs = await lireFichierFleurs();
        nouvelleListeFleurs = listeFleurs.filter(unFleur => unFleur.id != fleurId);
        await ecrireFichierFleurs(nouvelleListeFleurs);
        res.send('fleur supprimé');
    } catch (err) {
        res.status(500).send('Erreur d\'écriture dans le fichier');
    }
});

app.get('/fleurs/prix', async (req, res) => {
    try {
        const listeFleurs = await lireFichierFleurs();
        const prixTotal = listeFleurs.reduce((total, unFleur) => total + unFleur.prix, 0);
        res.json({ prixTotal });
    } catch (erreur) {
        res.status(500).send('Erreur de lecture du fichier');
    }
});