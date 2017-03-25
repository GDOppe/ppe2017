import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PageConnexion extends JFrame{

	private static JPanel panel;
	private static JTextField input_utilisateur;
	private static JPasswordField input_mot_de_passe;
	private static BoutonConnexion bouton_connexion;
	private static String identifiant;
	
	public PageConnexion()
	{
		initPanel();
		initialiserPositions();
		this.setTitle("Agrur - Gestion des commandes");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setIconImage(GestionRessources.getLogo());
		this.setContentPane(panel);
		this.setLayout(null);	
		this.setVisible(true);
		
	}
	
	public void initPanel()
	{
		panel = new JPanel()
		{
			@Override
			public void paintComponent(Graphics g)
			{
				g.drawImage(GestionRessources.getImageFondLogin(), 0, 0, this.getWidth(),this.getHeight(),null);
			}
		};
		
		bouton_connexion = new BoutonConnexion();		
		input_utilisateur = new JTextField();
		input_utilisateur.setOpaque(false);
		input_utilisateur.setBorder(null);
		input_utilisateur.setFont(new Font("Calibri",0,20));
		input_utilisateur.setForeground(new Color(199, 207, 0));
		
		input_mot_de_passe = new JPasswordField();
		input_mot_de_passe.setOpaque(false);
		input_mot_de_passe.setBorder(null);
		input_mot_de_passe.setFont(new Font("Calibri",0,20));
		input_mot_de_passe.setForeground(new Color(199, 207, 0));
				
	}
	
	public void initialiserPositions()
	{
		input_utilisateur.setBounds(215,176,165,30);
		input_mot_de_passe.setBounds(215,285,165,30);
		bouton_connexion.setBounds(207,400,180,45);
				
		panel.add(input_utilisateur);
		panel.add(input_mot_de_passe);
		panel.add(bouton_connexion);
	}
	
	
	public static BoutonConnexion getConnexion()
	{
		return bouton_connexion;
	}
	public static String getIdentifiant()
	{
		return identifiant;
	}
	public static void setIdentifiant(String nouveau_identifiant)
	{
		identifiant = nouveau_identifiant;
	}
	public static JTextField getInputUtilisateur()
	{
		return input_utilisateur;
	}
	public static JPasswordField getInputMotDePasse()
	{
		return input_mot_de_passe;
	}
	

}
