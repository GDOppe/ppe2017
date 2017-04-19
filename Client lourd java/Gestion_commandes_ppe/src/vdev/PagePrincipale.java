package vdev;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
*
* Classe permettant la création de la fenêtre principale de l'application
* 
* @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
* @version 1.0
* 
*
*/
public class PagePrincipale extends JFrame{

	private static JPanel panel;
	private static BoutonCommandes bouton_commandes;
	private static BoutonDistributeur bouton_distributeur;
	private static BoutonProduits bouton_produits;
	private static GestionClique clique = new GestionClique();
	private static PersistanceSQL sql;

	/**
	 * 
	 * Initialisation des composants swing sur la fenêtre<br><br>
	 * Connexion à la base de données<br><br>
	 * 
	 * @see PersistanceSQL
	 * @throws Exception
	 * 
	 * 
	 * */
	public PagePrincipale()
	{
		initConnexion();
		initPanel();
		initialiserPositions();
		this.setTitle("Agrur - Gestion des commandes XML");
		this.setSize(1024, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(panel);
		this.setLayout(null);
		this.setIconImage(GestionRessources.getLogo());
		this.setVisible(true);
		
	}
	private void initPanel()
	{
		panel = new JPanel()
		{
			@Override
			public void paintComponent(Graphics g)
			{
				g.drawImage(GestionRessources.getPrincipale(), 0, 0, this.getWidth(),this.getHeight(),null);
				g.setColor(new Color(199, 207, 0));
				g.setFont(new Font("Verdana",0,25));
				g.drawString("Bienvenue", 85, 45);			
			}
		};
		
		bouton_distributeur = new BoutonDistributeur();
		bouton_distributeur.addMouseListener(clique);
		bouton_commandes = new BoutonCommandes();
		bouton_commandes.addMouseListener(clique);
		bouton_produits = new BoutonProduits();
		bouton_produits.addMouseListener(clique);
		
	}
	
	private void initialiserPositions()
	{	
		bouton_distributeur.setBounds(5, 150, 150, 50);	
		bouton_commandes.setBounds(5, 300, 150, 50);
		bouton_produits.setBounds(5, 450, 150, 50);
	
		panel.add(bouton_distributeur);
		panel.add(bouton_commandes);
		panel.add(bouton_produits);
			
	}
		
	/**
	 * 
	 * Retourne le bouton des distributeurs
	 * @return BoutonDistributeur
	 * @see BoutonDistributeur
	 * 
	 * */
	public static BoutonDistributeur getDistributeursBouton()
	{
		return bouton_distributeur;
	}
	/**
	 * 
	 * Retourne le bouton des commandes
	 * @return BoutonCommandes
	 * @see BoutonCommandes
	 * 
	 * */
	public static BoutonCommandes getCommandesBouton()
	{
		return bouton_commandes;
	}
	/**
	 * 
	 * Retourne le bouton des produits
	 * @return BoutonProduits
	 * @see BoutonProduits
	 * 
	 * */
	public static BoutonProduits getProduitsBouton()
	{
		return bouton_produits;
	}
	/**
	 * 
	 * Retourne l'objet sql
	 * @return PersistanceSQL
	 * @see PersistanceSQL
	 * 
	 * */
	public static PersistanceSQL getSQL()
	{
		return sql;
	}
	/**
	 * 
	 * Tentative de connexion à la base de données en initialisant l'objet sql
	 * @see PersistanceSQL
	 * */
	private void initConnexion()
	{
		try
		{
			sql = new PersistanceSQL("localhost", 0, "vdev", "root", "root");			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Impossible de se connecter à la base de données.\nVeuillez vérifer votre connexion internet puis relancez l'application.","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
		
}
