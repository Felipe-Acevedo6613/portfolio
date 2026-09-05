
const construireUneCard = (epice, from) => {
    let card = `
        <div class="card card-perso card-marges" style="width: 18rem;">
            <img src="${epice.image}" class="card-img-top card-img" alt="...">
            <div class="card-body">
                <h5 class="card-title">${epice.nom}</h5>
                <p class="card-text">${epice.type}</p>
                <p class="card-text">${epice.vendeur}, ${epice.prix}</p>
                <p class="card-text">${epice.description}</p>
            `;
            if (from === 'membre') {
                card += `<p class="card-text"><i class="bi bi-cart-check panier"></i></p>`
            }
    card += `</div></div>`;
    return card;
}

const listerEpices = (listeEpices, from) => {
    let rep = `
        <div class="row">  
    `;
    listeEpices.forEach(epice => {
        rep += construireUneCard(epice, from);
    });
    rep += `</div`;
    document.getElementById('idListeEpices').innerHTML = rep;
};

