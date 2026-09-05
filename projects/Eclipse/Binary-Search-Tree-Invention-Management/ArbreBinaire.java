import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArbreBinaire {
    private class Noeud {
        String categorie;
        List<Invention> inventions;
        Noeud gauche;
        Noeud droite;

        Noeud(String categorie) {
            this.categorie = categorie;
            this.inventions = new ArrayList<>();
            this.gauche = null;
            this.droite = null;
        }
    }

    private Noeud racine;
    private Stack<Noeud> historiqueSuppression;

    public ArbreBinaire() {
        this.racine = null;
        this.historiqueSuppression = new Stack<>();
    }

    public void ajouterCategorie(String nomCategorie) {
        if (racine == null) {
            racine = new Noeud(nomCategorie);
        } else {
            ajouterCategorieRecursif(racine, nomCategorie);
        }
    }

    private void ajouterCategorieRecursif(Noeud current, String nomCategorie) {
        if (nomCategorie.compareTo(current.categorie) < 0) {
            if (current.gauche == null) {
                current.gauche = new Noeud(nomCategorie);
            } else {
                ajouterCategorieRecursif(current.gauche, nomCategorie);
            }
        } else if (nomCategorie.compareTo(current.categorie) > 0) {
            if (current.droite == null) {
                current.droite = new Noeud(nomCategorie);
            } else {
                ajouterCategorieRecursif(current.droite, nomCategorie);
            }
        }
    }

    public void ajouterInvention(String nomCategorie, Invention invention) {
        Noeud categorieNoeud = rechercherCategorie(nomCategorie);
        if (categorieNoeud != null) {
            categorieNoeud.inventions.add(invention);
        } else {
            System.out.println("Categorie non trouvée.");
        }
    }

    private Noeud rechercherCategorie(String nomCategorie) {
        return rechercherCategorieRecursif(racine, nomCategorie);
    }

    private Noeud rechercherCategorieRecursif(Noeud current, String nomCategorie) {
        if (current == null) {
            return null;
        }
        if (current.categorie.equals(nomCategorie)) {
            return current;
        }
        if (nomCategorie.compareTo(current.categorie) < 0) {
            return rechercherCategorieRecursif(current.gauche, nomCategorie);
        } else {
            return rechercherCategorieRecursif(current.droite, nomCategorie);
        }
    }

    public String afficherCategoriesEtInventions() {
        StringBuilder sb = new StringBuilder();
        afficherCategoriesEtInventionsRecursif(racine, sb);
        return sb.toString();
    }

    private void afficherCategoriesEtInventionsRecursif(Noeud current, StringBuilder sb) {
        if (current != null) {
            sb.append("Categorie: ").append(current.categorie).append("\n");
            for (Invention invention : current.inventions) {
                sb.append("    ").append(invention).append("\n");
            }
            afficherCategoriesEtInventionsRecursif(current.gauche, sb);
            afficherCategoriesEtInventionsRecursif(current.droite, sb);
        }
    }

    public void modifierAnneeInvention(String nomInvention, int nouvelleAnnee) {
        modifierAnneeInventionRecursif(racine, nomInvention, nouvelleAnnee);
    }

    private void modifierAnneeInventionRecursif(Noeud current, String nomInvention, int nouvelleAnnee) {
        boolean trouve = false;  // Variable para verificar si la catégorie a été trouvée

        if (current != null) {
            for (Invention invention : current.inventions) {
                if (invention.getNom().equals(nomInvention)) {
                    invention.setAnnee(nouvelleAnnee);
                    trouve = true;  // La catégorie a été trouvée
                    break;  // Sortez de la boucle pour éviter des vérifications inutiles
                }
            }
            if (!trouve) {  // Si après la boucle l'invention n'est pas trouvée
                modifierAnneeInventionRecursif(current.gauche, nomInvention, nouvelleAnnee);
                modifierAnneeInventionRecursif(current.droite, nomInvention, nouvelleAnnee);
            } else {
                return;  // Si l'invention est trouvée, pas besoin de continuer
            }
        }
        
        if (!trouve) {
            // Afficher le message si après la traversée de l'arbre l'invention n'est pas trouvée
            System.out.println("Catégorie non trouvée. Voulez-vous entrer une catégorie valide ?");
        }
    }


    public void supprimerCategorie(String nomCategorie) {
        racine = supprimerCategorieRecursif(racine, nomCategorie);
    }

    private Noeud supprimerCategorieRecursif(Noeud current, String nomCategorie) {
        if (current == null) {
            return null;
        }
        if (nomCategorie.compareTo(current.categorie) < 0) {
            current.gauche = supprimerCategorieRecursif(current.gauche, nomCategorie);
        } else if (nomCategorie.compareTo(current.categorie) > 0) {
            current.droite = supprimerCategorieRecursif(current.droite, nomCategorie);
        } else {
            historiqueSuppression.push(current);
            if (current.gauche == null) {
                return current.droite;
            } else if (current.droite == null) {
                return current.gauche;
            } else {
                Noeud successeur = obtenerMinimo(current.droite);
                current.categorie = successeur.categorie;
                current.inventions = successeur.inventions;
                current.droite = eliminarMinimo(current.droite);
            }
        }
        return current;
    }

    private Noeud obtenerMinimo(Noeud current) {
        while (current.gauche != null) {
            current = current.gauche;
        }
        return current;
    }

    private Noeud eliminarMinimo(Noeud current) {
        if (current.gauche == null) {
            return current.droite;
        }
        current.gauche = eliminarMinimo(current.gauche);
        return current;
    }

    public String afficherInventionsParInventeur(String inventeur) {
        StringBuilder sb = new StringBuilder();
        afficherInventionsParInventeurRecursif(racine, inventeur, sb);
        return sb.toString();
    }

    private void afficherInventionsParInventeurRecursif(Noeud current, String inventeur, StringBuilder sb) {
        if (current != null) {
            for (Invention invention : current.inventions) {
                if (invention.getInventeur().equals(inventeur)) {
                    sb.append(invention).append("\n");
                }
            }
            afficherInventionsParInventeurRecursif(current.gauche, inventeur, sb);
            afficherInventionsParInventeurRecursif(current.droite, inventeur, sb);
        }
    }

    public void annulerSuppression() {
        if (!historiqueSuppression.isEmpty()) {
            Noeud derniereSuppression = historiqueSuppression.pop();
            ajouterCategorie(derniereSuppression.categorie);
            for (Invention invention : derniereSuppression.inventions) {
                ajouterInvention(derniereSuppression.categorie, invention);
            }
        } else {
            System.out.println("Aucune suppression à annuler.");
        }
    }
}
