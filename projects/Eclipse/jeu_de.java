package jeu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class jeu_de extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    public static int pari = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    jeu_de frame = new jeu_de();
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
    public jeu_de() {
        setTitle("Jeu de mise sur un de");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 499, 492);
        contentPane = new JPanel();
        contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        contentPane.setBackground(new Color(227, 236, 255));
        
        JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Jeu de mise: mizes  sur la facette d'un de lance au hasard!");
        lblNewJgoodiesTitle.setForeground(new Color(153, 60, 232));
        lblNewJgoodiesTitle.setBounds(25, 6, 400, 16);
        contentPane.add(lblNewJgoodiesTitle);
        
        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("par Felipe Acevedo");
        lblNewJgoodiesLabel.setForeground(new Color(153, 60, 232));
        lblNewJgoodiesLabel.setBounds(145, 22, 122, 16);
        contentPane.add(lblNewJgoodiesLabel);
        
        JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Votre avoir actuelle: ");
        lblNewJgoodiesTitle_1.setBounds(6, 47, 138, 16);
        contentPane.add(lblNewJgoodiesTitle_1);
        
        JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("10");
        lblNewJgoodiesTitle_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewJgoodiesTitle_2.setBounds(145, 47, 31, 16);
        contentPane.add(lblNewJgoodiesTitle_2);
        
        JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("$");
        lblNewJgoodiesTitle_3.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewJgoodiesTitle_3.setBounds(177, 40, 14, 30);
        contentPane.add(lblNewJgoodiesTitle_3);
        

        JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory.getInstance().createTitle("Retroation");
        lblNewJgoodiesTitle_4.setBounds(6, 257, 70, 16);
        contentPane.add(lblNewJgoodiesTitle_4);


        JLabel lblNewJgoodiesTitle_7 = DefaultComponentFactory.getInstance().createTitle("Chiffre lance:");
        lblNewJgoodiesTitle_7.setBounds(397, 149, 96, 16);
        contentPane.add(lblNewJgoodiesTitle_7);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Mode nuit");
        chckbxNewCheckBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
		        if (chckbxNewCheckBox.isSelected()) {
		            contentPane.setBackground(Color.BLACK);
                    chckbxNewCheckBox.setForeground(Color.WHITE);
                    lblNewJgoodiesTitle_1.setForeground(Color.WHITE);
                    lblNewJgoodiesTitle_2.setForeground(Color.WHITE);
                    lblNewJgoodiesTitle_3.setForeground(Color.WHITE);
                    lblNewJgoodiesTitle_4.setForeground(Color.WHITE);
                    lblNewJgoodiesTitle_7.setForeground(Color.WHITE);
		        } else {
		            contentPane.setBackground(new Color(227, 236, 255));
                    chckbxNewCheckBox.setForeground(Color.BLACK);
                    lblNewJgoodiesTitle_1.setForeground(Color.BLACK);
                    lblNewJgoodiesTitle_2.setForeground(Color.BLACK);
                    lblNewJgoodiesTitle_3.setForeground(Color.BLACK);
                    lblNewJgoodiesTitle_4.setForeground(Color.BLACK);
                    lblNewJgoodiesTitle_7.setForeground(Color.BLACK);

		        }
        	}
        });
        chckbxNewCheckBox.setBounds(6, 388, 128, 23);
        contentPane.add(chckbxNewCheckBox);
              
        

        

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(407, 172, 71, 58);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel resultat = DefaultComponentFactory.getInstance().createLabel("?");
        resultat.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        resultat.setBounds(29, 20, 15, 15);
        panel_1.add(resultat);



        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Vore mise", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(6, 130, 241, 100);
        contentPane.add(panel);
        panel.setLayout(null);
        


        JSpinner spinner_1 = new JSpinner();
        spinner_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        spinner_1.setBounds(175, 21, 60, 47);
        panel.add(spinner_1);
        spinner_1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int newValue = (int) spinner_1.getValue();
                pari = newValue;
            }
        });

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(6, 276, 322, 100);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
        lblNewJgoodiesLabel_1.setBounds(6, 6, 310, 88);
        panel_2.add(lblNewJgoodiesLabel_1);

        JButton btnNewButton = new JButton("Lancer le de !");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            int chiffre = (int) (Math.random() * 5)+1;
            resultat.setText(Integer.toString(chiffre));
                int actualicerSalde = 0;
                String message = lblNewJgoodiesLabel_1.getText();
                if (chiffre == (int)(spinner_1.getValue())){
                    message = lblNewJgoodiesLabel_1.getText() + "\n Bravo! Vous avez gagne " + pari + "$. \n";
                    lblNewJgoodiesLabel_1.setText(message);
                    actualicerSalde = Integer.parseInt(lblNewJgoodiesTitle_2.getText()) + pari;
                    lblNewJgoodiesTitle_2.setText(Integer.toString(actualicerSalde));
                } else {
                    message = lblNewJgoodiesLabel_1.getText() + "\n Desole! Vous avez perdu " + pari + "$. \n";
                    lblNewJgoodiesLabel_1.setText(message);
                    actualicerSalde = Integer.parseInt(lblNewJgoodiesTitle_2.getText()) - pari;
                    lblNewJgoodiesTitle_2.setText(Integer.toString(actualicerSalde));
                }
        	}
        });
        btnNewButton.setBackground(new Color(83, 85, 203));
        btnNewButton.setBounds(263, 157, 122, 75);
        contentPane.add(btnNewButton);
        

        

        

        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("1$");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(rdbtnNewRadioButton.isSelected()) {
                    pari = 1;
        		}
        	}
        });
        rdbtnNewRadioButton.setBounds(6, 21, 141, 23);
        panel.add(rdbtnNewRadioButton);
        buttonGroup.add(rdbtnNewRadioButton);
        
        JSpinner spinner = new JSpinner();
        spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        spinner.setBounds(136, 70, 34, 26);
        panel.add(spinner);
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int newValue = (int) spinner.getValue();
                pari = newValue;
                System.out.println(pari);
            }
        });

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Autre montant!");
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if(rdbtnNewRadioButton_2.isSelected()) {
                    pari = (int) spinner_1.getValue();
        		}
        	}
        });
        rdbtnNewRadioButton_2.setBounds(6, 71, 141, 23);
        panel.add(rdbtnNewRadioButton_2);
        buttonGroup.add(rdbtnNewRadioButton_2);
        

        

        
        JLabel lblNewJgoodiesTitle_6 = DefaultComponentFactory.getInstance().createTitle("Votre choix:");
        lblNewJgoodiesTitle_6.setBounds(159, 10, 80, 16);
        panel.add(lblNewJgoodiesTitle_6);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Tout!");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if(rdbtnNewRadioButton_1.isSelected()) {
                    pari = Integer.parseInt(lblNewJgoodiesTitle_2.getText());
        		}
        	}
        });
        rdbtnNewRadioButton_1.setBounds(6, 45, 141, 23);
        panel.add(rdbtnNewRadioButton_1);
        buttonGroup.add(rdbtnNewRadioButton_1);
        

        

        

        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(356, 276, 137, 100);
        contentPane.add(panel_3);
        panel_3.setLayout(null);
        


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnInformation = new JMenu("Information");
        menuBar.add(mnInformation);

        JMenuItem menuItemInformation = new JMenuItem("A propos");
        mnInformation.add(menuItemInformation);
        menuItemInformation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "jue cree par: Felipe Acevedo \nle: 24/05/2024 \nau: collegue maisonneuve");
            }
        });
        
        JMenuItem menuItemQuitter = new JMenuItem("Quitter");
        mnInformation.add(menuItemQuitter);
        menuItemQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
    }
}

