const chargerEpices = (from) => {
    $.ajax({
        url: '/chargerEpices', 
        type: 'GET', 
        dataType: 'json', // JSON.parse(reponse); JSON.stringify(reponse);
        success: (res) => { //alert(reponse); 
            listerEpices(res, from);
        },
        error: (e) => { // Fonction exécutée en cas d'erreur
            alert(e);
        }
    });








    // fetch('/api')
    //     .then(response => response.json())
    //     .then(data => {
    //     console.log(data);
    //     });
    }