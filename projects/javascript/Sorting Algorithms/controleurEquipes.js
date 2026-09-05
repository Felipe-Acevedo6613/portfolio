// controleurs/controleurEquipes.js
const modeleEquipes = require('../modeles/modeleEquipes');

const obtenirTousLesEquipes = async (req, res) => {
    try {
      const equipes = await modeleEquipes.obtenirTousLesEquipes();
      res.json(equipes);
    } catch (err) {
      res.status(500).json({ erreur: err.message });
    }
};

const obtenirTop5Equipes = async (req, res) => {
    try {
      const equipes = await modeleEquipes.obtenirTop5Equipes();
      res.json(equipes);
    } catch (err) {
      res.status(500).json({ erreur: err.message });
    }
};

const obtenirTop0Equipes = async (req, res) => {
    try {
      const equipes = await modeleEquipes.obtenirTop0Equipes();
      res.json(equipes);
    } catch (err) {
      res.status(500).json({ erreur: err.message });
    }
};

// const obtenirEquipesParPays = async (req, res) => {
//     try {
//       const equipes = await modeleEquipes.obtenirEquipesParPays(req.params.pays);
//       res.json(equipes);
//     } catch (err) {
//       res.status(500).json({ erreur: err.message });
//     }
// };

const compterEquipesParPays = async (req, res) => {
    try {
      const equipes = await modeleEquipes.compterEquipesParPays();
      res.json(equipes);
    } catch (err) {
      res.status(500).json({ erreur: err.message });
    }
};

const obtenirEquipesParCouleur = async (req, res) => {
    try {
        const couleur = req.params.couleur;
        const equipes = await modeleEquipes.obtenirEquipesParCouleur(couleur);
        res.json(equipes);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
};



const supprimerEquipeParId = async (req, res) => { 
    try {
      const numeroEquipe = req.params.numeroEquipe; 
      await modeleEquipes.supprimerEquipeParId(numeroEquipe);
      res.json({ message: 'Equipe supprimé' });
    } catch (err) {
      res.status(500).json({ erreur: err.message });
    }
};

module.exports = {
    obtenirTousLesEquipes,
    obtenirTop5Equipes,
    obtenirTop0Equipes,
    obtenirEquipesParCouleur,
    // obtenirEquipesParPays,
    obtenirEquipesParCouleur,
    compterEquipesParPays,
    supprimerEquipeParId
};