// Modules de base pour le serveur 
import express = require('express'); // module express de Node.js (gére les routes, requêtes, réponses, middlewares, etc.)
import { Request } from "express"; // Request gérer les requêtes HTTP
import { Response } from "express"; // Response gérer les réponses HTTP
import http = require('http'); // module http de Node.js
import bodyParser = require('body-parser'); // module body-parser de Node.js (parse les requêtes HTTP)
import path = require("path"); // module path de Node.js (gére les chemins de fichiers)
import multer = require('multer'); //mutipart/form-data pour les fichiers

// Création de l'application express et du serveur

const upload = multer({ dest: 'app/src/uploads' });

const app = express(); // Création de l'application express
const server = http.createServer(app);
const porte = 8282; // Porte du serveur (8282 par défaut), 8080,8181, 8282
server.listen(porte);
console.log(`Serveur démarré sur la porte ${porte}`);

// Pour obtenir les ressources statiques css, js, images, ...
// qui partiront avec vos pages web via les balises link, script, <img src=
app.use(express.static(__dirname + "/app/src"));
// Support json encoded bodies
app.use(bodyParser.json());
// Support text encoded bodies
app.use(bodyParser.text());
// Support text encoded bodies
app.use(express.urlencoded({ extended: true }));

// **************************** Configuration de l'application *************************************************

// Gestion des routes
app.get('/', (req: Request, res: Response) => {
    //console.log(__dirname);
    res.sendFile(path.join(__dirname, '/app/src/index.html'));
});

app.use('/chargerEpices', (req, res) => {
    res.setHeader('Content-Type', 'application/json');
    res.sendFile(path.join(__dirname, 'donnees/epices.json'));
  });
