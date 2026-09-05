// server.js
const express = require('express');
const controleurEquipes = require('./controleurs/controleurEquipes');

const app = express();
const port = 3000;

// Middleware pour parsing JSON
app.use(express.json());
app.use(express.static('public'));

// Routes
app.get('/equipes', controleurEquipes.obtenirTousLesEquipes);
app.get('/equipes/top5', controleurEquipes.obtenirTop5Equipes);
app.get('/equipes/top0', controleurEquipes.obtenirTop0Equipes);
// app.get('/equipes/count', controleurEquipes.obtenirEquipesParPays);
app.delete('/equipes/:numeroEquipe', controleurEquipes.supprimerEquipeParId);
app.get('/equipes/groupByPays', controleurEquipes.compterEquipesParPays);
app.get('/equipes/couleur/:couleur', controleurEquipes.obtenirEquipesParCouleur);

// app.get('/equipes/pays/:pays', controleurEquipes.obtenirEquipesParPays);

// app.get('/equipes/codePostal/:codePostal', controleurEquipes.obtenirEquipesParCodePostal);
// app.get('/equipes/groupByPays', controleurEquipes.compterEquipesParPays);
// app.get('/equipes/nomContact/:nomContact', controleurEquipes.obtenirEquipesParNomContact);
// app.get('/equipes/telephone/555', controleurEquipes.obtenirEquipesParTelephone);

app.listen(port, () => {

  console.log(`Serveur lancé sur http://localhost:${port}`);
});
