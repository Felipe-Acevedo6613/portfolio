package jeu_de;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;

public class jeu_de extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    public static int pari;
    public static int choix;

    /**
     * @wbp.nonvisual location=455,401
     */
    

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
        setBounds(100, 100, 614, 492);
        contentPane = new JPanel() {
            private static final long serialVersionUID = 1L;

          
        };
        contentPane.setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Jeu de mise: mizes  sur la facette d'un de lance au hasard!");
        lblNewJgoodiesTitle.setForeground(new Color(0, 0, 0));
        lblNewJgoodiesTitle.setBounds(119, 6, 400, 16);
        contentPane.add(lblNewJgoodiesTitle);
        
        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("par Felipe Acevedo");
        lblNewJgoodiesLabel.setForeground(new Color(0, 0, 0));
        lblNewJgoodiesLabel.setBounds(226, 23, 122, 16);
        contentPane.add(lblNewJgoodiesLabel);
        
        JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Votre avoir actuelle: ");
        lblNewJgoodiesTitle_1.setBounds(6, 71, 138, 16);
        contentPane.add(lblNewJgoodiesTitle_1);
        
        JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("10");
        lblNewJgoodiesTitle_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewJgoodiesTitle_2.setBounds(153, 68, 46, 16);
        contentPane.add(lblNewJgoodiesTitle_2);
        
        JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("$");
        lblNewJgoodiesTitle_3.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewJgoodiesTitle_3.setBounds(198, 61, 14, 30);
        contentPane.add(lblNewJgoodiesTitle_3);
        

        JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory.getInstance().createTitle("Retroation");
        lblNewJgoodiesTitle_4.setBounds(16, 253, 70, 16);
        contentPane.add(lblNewJgoodiesTitle_4);

        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Chiffre Lance", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1.setBounds(459, 130, 138, 102);
        contentPane.add(panel_1);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Mode nuit");
        chckbxNewCheckBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
		        if (chckbxNewCheckBox.isSelected()) {
		            contentPane.setBackground(Color.BLACK);
		            lblNewJgoodiesTitle.setForeground(Color.WHITE);
		            lblNewJgoodiesLabel.setForeground(Color.WHITE);
                    chckbxNewCheckBox.setForeground(Color.WHITE);
                    lblNewJgoodiesTitle_1.setForeground(Color.WHITE);
                    lblNewJgoodiesTitle_2.setForeground(Color.WHITE);
                    lblNewJgoodiesTitle_3.setForeground(Color.WHITE);
                    lblNewJgoodiesTitle_4.setForeground(Color.WHITE);
                    panel_1.setForeground(Color.WHITE);
		          } else {
		            contentPane.setBackground(new Color(227, 236, 255));
		            lblNewJgoodiesTitle.setForeground(Color.BLACK);
		            lblNewJgoodiesLabel.setForeground(Color.BLACK);
                    chckbxNewCheckBox.setForeground(Color.BLACK);
                    lblNewJgoodiesTitle_1.setForeground(Color.BLACK);
                    lblNewJgoodiesTitle_2.setForeground(Color.BLACK);
                    lblNewJgoodiesTitle_3.setForeground(Color.BLACK);
                    lblNewJgoodiesTitle_4.setForeground(Color.BLACK);
                    panel_1.setForeground(Color.BLACK);
		        }
        	}
        });
        chckbxNewCheckBox.setBounds(6, 388, 128, 23);
        contentPane.add(chckbxNewCheckBox);


        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Vore mise", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(6, 130, 280, 100);
        contentPane.add(panel);
        panel.setLayout(null);
        
   
        JSpinner spinner_1 = new JSpinner();
        spinner_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        spinner_1.setBounds(175, 21, 60, 47);
        spinner_1.setModel(new SpinnerNumberModel(0, 0, 6, 1));

        panel.add(spinner_1);
        spinner_1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int newValue = (int) spinner_1.getValue();
                choix = newValue;
            }
        });

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 268, 328, 108);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        

        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
        lblNewJgoodiesLabel_1.setBounds(6, 6, 310, 88);
        panel_2.add(lblNewJgoodiesLabel_1);
        
        JTextArea textArea = new JTextArea("Votres retroations:");
        textArea.setLineWrap(true);
        textArea.setBounds(6, 6, 310, 88);
        lblNewJgoodiesLabel_1.add(textArea);

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(6, 6, 310, 88);
        lblNewJgoodiesLabel_1.add(scrollPane);
        

        JSpinner spinner = new JSpinner();
        spinner.setEnabled(false);

        spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        spinner.setBounds(136, 70, 53, 26);
        spinner.setModel(new SpinnerNumberModel(0, 0, Integer.parseInt(lblNewJgoodiesTitle_2.getText()), 1));
        panel.add(spinner);
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int newValue = (int) spinner.getValue();
                pari = newValue;
            }
        });
        
        
        JLabel resultat = new JLabel("?");
        resultat.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        panel_1.add(resultat);
        
  
        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Autre montant!");
        buttonGroup.add(rdbtnNewRadioButton_2);
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		spinner.setEnabled(true);
        	}
        });
        rdbtnNewRadioButton_2.setBounds(6, 71, 141, 23);
        panel.add(rdbtnNewRadioButton_2);
        
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
        
        
        JButton btnNewButton = new JButton("Lancer le de !");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            int chiffre = (int) (Math.random() * 6)+1;
            resultat.setText(Integer.toString(chiffre));
            int actualicerSolde = Integer.parseInt(lblNewJgoodiesTitle_2.getText());
        	if (rdbtnNewRadioButton_1.isSelected()) {
        		pari = actualicerSolde;
        	}
        	  if(pari == 0){
        		  
        	  }else {
                String message = lblNewJgoodiesLabel_1.getText();
                if (chiffre == (int)(spinner_1.getValue())){
                	pari = (pari*5);
                    message = textArea.getText() + "\n Bravo! Vous avez gagne " + pari + "$.";
                    textArea.setText(message);
                    actualicerSolde += pari;
                } else {
                    message = textArea.getText() + "\n Desole! Vous avez perdu " + pari + "$.";
                    textArea.setText(message);
                    actualicerSolde -= pari;
                    if (actualicerSolde <=0) {
                    	lblNewJgoodiesTitle_2.setText("0");
                    	int reponse = JOptionPane.showConfirmDialog( null, 
                    			"Voulez-vous recommencer?", "Tout perdu!",  JOptionPane.YES_NO_OPTION );
                    				if (reponse == JOptionPane.YES_OPTION) {
                    					actualicerSolde =10;
                    				} else {
                    			   		JOptionPane.showMessageDialog(null, "Au revoir!");
                    				    	System.exit(0);
                    				}
                    }
                }
                    rdbtnNewRadioButton.setSelected(false);
                    rdbtnNewRadioButton_1.setSelected(false);
                    rdbtnNewRadioButton_2.setSelected(false);
                    buttonGroup.clearSelection();
                    pari =0;
            		spinner.setEnabled(false);
                
                }
                lblNewJgoodiesTitle_2.setText(Integer.toString(actualicerSolde));
                spinner.setModel(new SpinnerNumberModel(0, 0, actualicerSolde, 1));
        	  
        	}
        });
        btnNewButton.setBackground(new Color(83, 85, 203));
        btnNewButton.setBounds(291, 139, 156, 91);
        contentPane.add(btnNewButton);
        
        JLabel lblNewJgoodiesTitle_6 = DefaultComponentFactory.getInstance().createTitle("Votre choix:");
        lblNewJgoodiesTitle_6.setBounds(159, 10, 80, 16);
        panel.add(lblNewJgoodiesTitle_6);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "Taille", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        panel_3.setBounds(340, 276, 257, 100);
        contentPane.add(panel_3);
        panel_3.setLayout(null);
        
        
        JLabel choix = DefaultComponentFactory.getInstance().createTitle("50");
        choix.setBounds(160, 62, 32, 32);
        panel_3.add(choix);
        
        
        JSlider slider = new JSlider();
        slider.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                choix.setText(Integer.toString(slider.getValue()));
                resultat.setFont(new Font("Arial", Font.PLAIN, slider.getValue()));
        	}
        });
        slider.setMaximum(70);
        slider.setMinimum(40);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(10);
        slider.setBounds(6, 18, 245, 52);
        panel_3.add(slider);
        

        
        JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Votre choix:");
        lblNewJgoodiesLabel_2.setBounds(72, 70, 76, 16);
        panel_3.add(lblNewJgoodiesLabel_2);
        
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

