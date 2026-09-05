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
import javax.swing.JScrollPane;

public class jeu_de extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();

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
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
        lblNewJgoodiesTitle_2.setBounds(145, 47, 31, 16);
        contentPane.add(lblNewJgoodiesTitle_2);
        
        JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("$");
        lblNewJgoodiesTitle_3.setBounds(174, 47, 122, 16);
        contentPane.add(lblNewJgoodiesTitle_3);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Mode nuit");
        chckbxNewCheckBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
		        if (chckbxNewCheckBox.isSelected()) {
		            contentPane.setBackground(Color.BLACK);
		        } else {
		            contentPane.setBackground(null);
		        }
        	}
        });
        chckbxNewCheckBox.setBounds(6, 388, 128, 23);
        contentPane.add(chckbxNewCheckBox);
              
        
        JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory.getInstance().createTitle("Retroation");
        lblNewJgoodiesTitle_4.setBounds(6, 257, 70, 16);
        contentPane.add(lblNewJgoodiesTitle_4);
        
        JLabel lblNewJgoodiesTitle_5 = DefaultComponentFactory.getInstance().createTitle("Votre mise");
        lblNewJgoodiesTitle_5.setBounds(6, 114, 80, 16);
        contentPane.add(lblNewJgoodiesTitle_5);
        
        JButton btnNewButton = new JButton("Lancer le de !");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBackground(new Color(83, 85, 203));
        btnNewButton.setBounds(263, 157, 122, 75);
        contentPane.add(btnNewButton);
        
        JLabel lblNewJgoodiesTitle_7 = DefaultComponentFactory.getInstance().createTitle("Chiffre lance:");
        lblNewJgoodiesTitle_7.setBounds(397, 149, 96, 16);
        contentPane.add(lblNewJgoodiesTitle_7);
        
        JPanel panel = new JPanel();
        panel.setBounds(6, 130, 241, 100);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("1$");
        rdbtnNewRadioButton.setBounds(6, 6, 141, 23);
        panel.add(rdbtnNewRadioButton);
        buttonGroup.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Tout!");
        rdbtnNewRadioButton_1.setBounds(6, 32, 141, 23);
        panel.add(rdbtnNewRadioButton_1);
        buttonGroup.add(rdbtnNewRadioButton_1);
        
        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Autre montant!");
        rdbtnNewRadioButton_2.setBounds(6, 57, 141, 23);
        panel.add(rdbtnNewRadioButton_2);
        buttonGroup.add(rdbtnNewRadioButton_2);
        
        JSpinner spinner = new JSpinner();
        spinner.setBounds(140, 56, 34, 26);
        panel.add(spinner);
        
        JSpinner spinner_1 = new JSpinner();
        spinner_1.setBounds(175, 21, 60, 47);
        panel.add(spinner_1);
        
        JLabel lblNewJgoodiesTitle_6 = DefaultComponentFactory.getInstance().createTitle("Votre choix:");
        lblNewJgoodiesTitle_6.setBounds(159, 10, 80, 16);
        panel.add(lblNewJgoodiesTitle_6);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(407, 172, 71, 58);
        contentPane.add(panel_1);
        
        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("            ?");
        panel_1.add(lblNewJgoodiesLabel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(6, 276, 322, 100);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 6, 310, 88);
        panel_2.add(scrollPane);
        
//        JButton button = new JButton("Botón");
//        panel.add(button);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnInformation = new JMenu("Information");
        menuBar.add(mnInformation);

        JMenuItem menuItemInformation = new JMenuItem("A propos");
        mnInformation.add(menuItemInformation);
        menuItemInformation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción que quieres realizar cuando se presione el botón
                JOptionPane.showMessageDialog(null, "jue cree par: Felipe Acevedo \nle: 24/05/2024 \nau: collegue maisonneuve");
            }
        });
        
        JMenuItem menuItemQuitter = new JMenuItem("Quitter");
        mnInformation.add(menuItemQuitter);
        menuItemQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción que quieres realizar cuando se presione el botón
            	System.exit(0);
            }
        });
    }
}

