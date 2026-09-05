// modeles/modeleEquipes.js
const pool = require('../bd');

const obtenirTousLesEquipes = async () => {
    const [lignes] = await pool.query('SELECT * FROM equipes ORDER BY nom_equipe ASC;');
    return lignes;
};

const obtenirTop5Equipes = async () => {
    const [lignes] = await pool.query('SELECT * FROM equipes ORDER BY nombre_coupes_stanley DESC LIMIT 5;');
    return lignes;
};

const obtenirTop0Equipes = async () => {
    const [lignes] = await pool.query('SELECT * FROM equipes WHERE nombre_coupes_stanley = 0;');
    return lignes;
};

// const compterEquipesParPays = async () => {
//     const [lignes] = await pool.query('SELECT pays, COUNT(*) AS nombre_equipes FROM equipes GROUP BY pays');
//     return lignes;
// };

const compterEquipesParPays = async () => {
    const [lignes] = await pool.query('SELECT pays, COUNT(*) AS nombre_equipes FROM equipes GROUP BY pays');
    return lignes;
};

const obtenirEquipesParCouleur = async (couleur) => {
    try {
        const [rows] = await pool.query('SELECT * FROM equipes WHERE FIND_IN_SET(?, couleur_principale)', [couleur]);
        return rows;
    } catch (error) {
        console.error('Error al obtener equipos por couleur:', error);
        throw error;
    }
};

const supprimerEquipeParId = async (id) => { 
    await pool.query('DELETE FROM equipes WHERE id = ?', [id]);
}

module.exports = {
    obtenirTousLesEquipes,
    obtenirTop5Equipes,
    obtenirTop0Equipes,
    compterEquipesParPays,
    obtenirEquipesParCouleur,
    // compterEquipesParPays,
    supprimerEquipeParId
};