const apiURL = 'http://localhost:3000/fleurs';
const montrerElement = (idElement) => {
    document.getElementById(idElement).style.display = 'block';
}

const cacherElement = (idElement) => {
    document.getElementById(idElement).style.display = 'none';
}

const chargerFleurs = async () => {
    try {
        const reponse = await fetch(apiURL, { method: 'GET' }); // Requête GET pour récupérer les étudiants
        const listeFleurs = await reponse.json(); // Conversion de la réponse en JSON
        afficherFleurs("Liste des fleurs",listeFleurs);
    } catch (err) {
        console.error('Erreur lors du chargement des fleurs:', err);
    }
}

const afficherFleurs = (titre, listeFleurs) => {
    $('#titreListe').text(titre); // Afficher le titre de la liste. On pourrait le faire aussi par JavaScript document.getElementById('titreListe').innerText = titre;
    $('#fleurs-table').empty();
    listeFleurs.forEach(fleur => {
        $('#fleurs-table').append(`
                <tr>
                    <td>${fleur.id}</td>
                    <td>${fleur.nom}</td>
                    <td>${fleur.categorie}</td>
                    <td>${fleur.couleur}</td>
                    <td>${fleur.prix}</td>
                </tr>
            `);
    });
}
const reqAjouterFleur = async () => {
    const nom = $('#nom').val();
    const categorie = $('#categorie').val();
    const couleur = $('#couleur').val();
    const prix = $('#prix').val();
    if (nom && categorie && couleur && prix) {
        try {
            await fetch(apiURL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ nom, categorie, couleur, prix })
            });
            chargerFleurs();
        } catch (erreur) {
            console.error('Erreur lors de l\'ajout de l\'fleur:', erreur);
        }
    } else {
        alert('Veuillez remplir tous les champs');
    }
}

const reqSupprimerFleur = async () => {
    const fleurId = $('#idFleurSupp').val();
    if (fleurId) {
        if (confirm('Voulez-vous vraiment supprimer cette fleur ?')) {
            try {
                await fetch(`${apiURL}/${fleurId}`, { method: 'DELETE' });
                chargerFleurs();
            } catch (erreur) {
                console.error('Erreur lors de la suppression de la fleur:', erreur);
            }
        }
    } else {
        alert('Veuillez entrer un ID');
    }
}

const reqListerParCategorie = async () => {
    const categorie = $('#cat').val();
    let listeFleurs = []; // Initialisation de la liste des étudiants
    if (categorie) {
        try {
            let listeFleursDuCategorie = await fetch(`${apiURL}/categorie/${categorie}`, { method: 'GET' });
            listeFleursDuCategorie = await listeFleursDuCategorie.json(); 
            afficherFleurs("Liste des fleurs du categorie : " + categorie, listeFleursDuCategorie);
        } catch (erreur) {
            console.error('Erreur pour trouver la fleur', erreur);
        }
    } else {
        alert('Veuillez entrer une categorie');
    }
}

const reqTotalPrix = async () => {
    try {
        let total = 0;
        const listeFleurs = await fetch(apiURL, { method: 'GET' });
        const fleurs = await listeFleurs.json();
        fleurs.forEach(fleur => {
            total += parseFloat(fleur.prix);
        });
        alert('Total en inventaire: ' + total.toFixed(2) + '$');
    } catch (erreur) {
        console.error('Erreur lors du calcul du prix total:', erreur);
    }
}
// const reqTotalPrix = async () => {
//     try {
//         let total = 0;
//         const listeFleurs = await fetch(apiURL, { method: 'GET' });
//         const fleurs = await listeFleurs.json();
//         fleurs.forEach(fleur => {
//             total += parseFloat(fleur.prix);
//         });
//         $('#totalPrix').html(`Total en inventaire: <span style="font-weight: bold; color: blue;">${total.toFixed(2)}</span>`);
//     } catch (erreur) {
//         console.error('Erreur lors du calcul du prix total:', erreur);
//     }
// }