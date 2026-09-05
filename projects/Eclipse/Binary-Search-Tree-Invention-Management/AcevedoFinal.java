import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcevedoFinal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ArbreBinaire arbre = new ArbreBinaire();
    private JTextPane textCategorie;
    private JTextPane Categorie;
    private JTextPane nomInvention;
    private JTextPane nomInventeur;
    private JTextPane anneeInvention;
    private JTextPane inventionAModifierAnne;
    private JTextPane nouvelleAnne;
    private JTextPane CategorieAsupprimer;
    private JTextPane nomInventeurAfficher;
    private JTextPane affichagePane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AcevedoFinal frame = new AcevedoFinal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AcevedoFinal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 831, 505);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(210, 215, 217));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(195, 200, 200));
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ajouter Une Categorie", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(14, 39, 255)));
        panel.setBounds(6, 6, 402, 68);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Nom de la categorie:");
        lblNewJgoodiesTitle.setBounds(6, 26, 153, 16);
        panel.add(lblNewJgoodiesTitle);
        
        textCategorie = new JTextPane();
        textCategorie.setBounds(152, 26, 115, 16);
        panel.add(textCategorie);
        
        JButton ajouterCategorie = new JButton("Ajouter");
        ajouterCategorie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomCategorie = textCategorie.getText();
                arbre.ajouterCategorie(nomCategorie);
                affichagePane.setText("Categorie ajoutée : " + nomCategorie);
                textCategorie.setText("");
            }
        });
        ajouterCategorie.setBounds(279, 21, 117, 29);
        panel.add(ajouterCategorie);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(195, 200, 200));
        panel_1.setBorder(new TitledBorder(null, "Ajouter une invention", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(14, 39, 255)));
        panel_1.setBounds(6, 86, 402, 154);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Categorie:");
        lblNewJgoodiesTitle_1.setBounds(72, 28, 68, 16);
        panel_1.add(lblNewJgoodiesTitle_1);
        
        Categorie = new JTextPane();
        Categorie.setBounds(152, 28, 122, 16);
        panel_1.add(Categorie);
        
        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nom de l'invention:");
        lblNewJgoodiesLabel.setBounds(18, 56, 133, 16);
        panel_1.add(lblNewJgoodiesLabel);
        
        nomInvention = new JTextPane();
        nomInvention.setBounds(152, 56, 177, 16);
        panel_1.add(nomInvention);
        
        nomInventeur = new JTextPane();
        nomInventeur.setBounds(152, 84, 177, 16);
        panel_1.add(nomInventeur);
        
        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Nom de l'inventeur:");
        lblNewJgoodiesLabel_1.setBounds(18, 84, 133, 16);
        panel_1.add(lblNewJgoodiesLabel_1);
        
        JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Annee de l'invention:");
        lblNewJgoodiesLabel_2.setBounds(18, 112, 134, 16);
        panel_1.add(lblNewJgoodiesLabel_2);
        
        anneeInvention = new JTextPane();
        anneeInvention.setBounds(152, 112, 122, 16);
        panel_1.add(anneeInvention);
        
        JButton ajouterInvention = new JButton("Ajouter");
        ajouterInvention.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomCategorie = Categorie.getText();
                String nomInv = nomInvention.getText();
                String inventeur = nomInventeur.getText();
                int annee = Integer.parseInt(anneeInvention.getText());
                Invention invention = new Invention(nomInv, inventeur, annee);
                arbre.ajouterInvention(nomCategorie, invention);
                affichagePane.setText("Invention ajoutée : " + nomInv + " par " + inventeur + " en " + annee + " dans la categorie " + nomCategorie);
                Categorie.setText("");
                nomInvention.setText("");
                nomInventeur.setText("");
                anneeInvention.setText("");
            }
        });
        ajouterInvention.setBounds(278, 107, 117, 29);
        panel_1.add(ajouterInvention);
        
        JButton afficherCategories = new JButton("Afficher toutes les categories et ses inventions");
        afficherCategories.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                affichagePane.setText(arbre.afficherCategoriesEtInventions());
            }
        });
        afficherCategories.setBounds(6, 252, 402, 71);
        contentPane.add(afficherCategories);
                
        JButton effacer = new JButton("Effacer");
        effacer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                affichagePane.setText("");
            }
        });
        effacer.setBounds(705, 335, 117, 83);
        contentPane.add(effacer);
        
        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        quitter.setBounds(705, 430, 117, 29);
        contentPane.add(quitter);
        
        JScrollPane affichage = new JScrollPane();
        affichage.setToolTipText("Bienvenue! Commencez pour ajouter une categorie.");
        affichage.setBounds(16, 335, 677, 124);
        contentPane.add(affichage);
        
        affichagePane = new JTextPane();
        affichage.setViewportView(affichagePane);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(195, 200, 200));
        panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Modifier l'annee d'une invention", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(244, 0, 4)));
        panel_2.setBounds(420, 6, 402, 83);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Nom de l'invention:");
        lblNewJgoodiesLabel_3.setBounds(6, 22, 132, 16);
        panel_2.add(lblNewJgoodiesLabel_3);
        
        inventionAModifierAnne = new JTextPane();
        inventionAModifierAnne.setBounds(140, 22, 122, 16);
        panel_2.add(inventionAModifierAnne);
        
        JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Nouvelle annee:");
        lblNewJgoodiesLabel_4.setBounds(35, 55, 93, 16);
        panel_2.add(lblNewJgoodiesLabel_4);
        
        nouvelleAnne = new JTextPane();
        nouvelleAnne.setBounds(140, 55, 122, 16);
        panel_2.add(nouvelleAnne);
        
        JButton modifierAnne = new JButton("Modifier");
        modifierAnne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomInvention = inventionAModifierAnne.getText();
                int nouvelleAnnee = Integer.parseInt(nouvelleAnne.getText());
                arbre.modifierAnneeInvention(nomInvention, nouvelleAnnee);
                affichagePane.setText("Annee de l'invention " + nomInvention + " modifiée en " + nouvelleAnnee);
                inventionAModifierAnne.setText("");
                nouvelleAnne.setText("");
            }
        });
        modifierAnne.setBounds(274, 29, 117, 29);
        panel_2.add(modifierAnne);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(195, 200, 200));
        panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Supprimer une categorie", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(198, 35, 31)));
        panel_3.setBounds(420, 101, 402, 69);
        contentPane.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("Nom de la categorie:");
        lblNewJgoodiesLabel_5.setBounds(6, 27, 122, 16);
        panel_3.add(lblNewJgoodiesLabel_5);
        
        CategorieAsupprimer = new JTextPane();
        CategorieAsupprimer.setBounds(140, 27, 122, 16);
        panel_3.add(CategorieAsupprimer);
        
        JButton supprimerCategorie = new JButton("Supprimer");
        supprimerCategorie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomCategorie = CategorieAsupprimer.getText();
                arbre.supprimerCategorie(nomCategorie);
                affichagePane.setText("Categorie supprimée : " + nomCategorie);
                CategorieAsupprimer.setText("");
            }
        });
        supprimerCategorie.setBounds(274, 22, 117, 29);
        panel_3.add(supprimerCategorie);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(195, 200, 200));
        panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Afficher les inventions d'un inventeur", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(216, 0, 6)));
        panel_4.setBounds(420, 252, 402, 68);
        contentPane.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblNewJgoodiesLabel_6 = DefaultComponentFactory.getInstance().createLabel("Nom de l'inventeur:");
        lblNewJgoodiesLabel_6.setBounds(6, 23, 133, 16);
        panel_4.add(lblNewJgoodiesLabel_6);
        
        nomInventeurAfficher = new JTextPane();
        nomInventeurAfficher.setBounds(151, 23, 144, 16);
        panel_4.add(nomInventeurAfficher);
        
        JButton afficherInventions = new JButton("Afficher");
        afficherInventions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inventeur = nomInventeurAfficher.getText();
                affichagePane.setText(arbre.afficherInventionsParInventeur(inventeur));
                nomInventeurAfficher.setText("");
            }
        });
        afficherInventions.setBounds(296, 18, 100, 29);
        panel_4.add(afficherInventions);
        
        JPanel panel_3_1 = new JPanel();
        panel_3_1.setBackground(new Color(195, 200, 200));
        panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Annuler la derniere suppresion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(244, 0, 4)));
        panel_3_1.setBounds(420, 175, 392, 65);
        contentPane.add(panel_3_1);
        panel_3_1.setLayout(null);
        
        JButton annulerSuppresion = new JButton("Annuler la suppresion plus recente");
        annulerSuppresion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                arbre.annulerSuppression();
                affichagePane.setText("Suppression annulée.");
            }
        });
        annulerSuppresion.setBounds(6, 19, 369, 29);
        panel_3_1.add(annulerSuppresion);
    }
}
