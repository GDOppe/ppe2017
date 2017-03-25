import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PagePrincipale extends JFrame{

	private static JPanel panel;
	private static BoutonCommandes bouton_commandes;
	private static BoutonDistributeur bouton_distributeur;
	private static BoutonProduits bouton_produits;
	
	private static JComboBox<String> liste_distributeurs_menu_distributeurs;
	private static JComboBox<String> liste_commandes_menu_distributeurs;
	private static JLabel titre_menu;
	private static JLabel nom_distributeur_menu_distributeurs;
	private static JLabel commandes_associees_menu_distributeurs;
	private static JLabel conditionnement_menu_distributeurs;
	private static JLabel quantite_menu_distributeurs;
	private static JLabel date_conditionnement_menu_distributeurs;
	private static JLabel date_envoi_menu_distributeurs;
	private static JLabel id_produit_menu_distributeurs;
	private static JLabel variete_produit_menu_distributeurs;
	private static JLabel type_produit_menu_distributeurs;
	private static JLabel calibre_produit_menu_distributeurs;
	
	private static JComboBox<String> liste_commandes_menu_commandes;
	private static JLabel conditionnement_menu_commandes;
	private static JLabel quantite_menu_commandes;
	private static JLabel date_conditionnement_menu_commandes;
	private static JLabel date_envoi_menu_commandes;
	private static JLabel id_distributeur_menu_commandes;
	private static JLabel id_produit_menu_commandes;	
	private static JLabel variete_produit_menu_commandes;
	private static JLabel type_produit_menu_commandes;
	private static JLabel calibre_produit_menu_commandes;
	
	private static JComboBox<String> liste_produits_menu_produits;
	private static JLabel variete_produit_menu_produits;
	private static JLabel type_produit_menu_produits;
	private static JLabel calibre_produit_menu_produits;
	
	private static GestionCommandes donnees_gestion;
	
	
	public PagePrincipale()
	{
		init();
		initPositions();
		
		this.setTitle("Gestion des commandes");
		this.setSize(1024, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(panel);
		this.setLayout(null);
		this.setIconImage(GestionRessources.getLogo());
		this.setVisible(true);
		
	}
	public void init()
	{
		panel = new JPanel()
		{
			@Override
			public void paintComponent(Graphics g)
			{
				g.drawImage(GestionRessources.getPrincipale(), 0, 0, this.getWidth(),this.getHeight(),null);
				g.setColor(new Color(199, 207, 0));
				g.setFont(new Font("Verdana",0,25));
				g.drawString(PageConnexion.getIdentifiant(), 85, 45);
				
			}
		};
		
		bouton_distributeur = new BoutonDistributeur();
		bouton_distributeur.addMouseListener(new GestionClique());
		bouton_commandes = new BoutonCommandes();
		bouton_commandes.addMouseListener(new GestionClique());
		bouton_produits = new BoutonProduits();
		bouton_produits.addMouseListener(new GestionClique());
		
		liste_commandes_menu_distributeurs = new JComboBox<String>();
		liste_commandes_menu_distributeurs.addActionListener(new EcouteurListe());
		
		titre_menu = new JLabel("Distributeurs");
		titre_menu.setFont(new Font("Verdana",0,25));
		
		nom_distributeur_menu_distributeurs = new JLabel();
		nom_distributeur_menu_distributeurs.setFont(new Font("Verdana",1,15));
		commandes_associees_menu_distributeurs = new JLabel("Commandes associées:");
		commandes_associees_menu_distributeurs.setFont(new Font("Verdana",1,15));
		
		conditionnement_menu_distributeurs = new JLabel();
		conditionnement_menu_distributeurs.setFont(new Font("Verdana",1,15));
		quantite_menu_distributeurs = new JLabel();
		quantite_menu_distributeurs.setFont(new Font("Verdana",1,15));
		date_conditionnement_menu_distributeurs = new JLabel();
		date_conditionnement_menu_distributeurs.setFont(new Font("Verdana",1,15));
		date_envoi_menu_distributeurs = new JLabel();
		date_envoi_menu_distributeurs.setFont(new Font("Verdana",1,15));
		
		id_produit_menu_distributeurs = new JLabel();
		id_produit_menu_distributeurs.setFont(new Font("Verdana",1,15));	
		variete_produit_menu_distributeurs = new JLabel();
		variete_produit_menu_distributeurs.setFont(new Font("Verdana",1,15));		
		type_produit_menu_distributeurs = new JLabel();
		type_produit_menu_distributeurs.setFont(new Font("Verdana",1,15));		
		calibre_produit_menu_distributeurs = new JLabel();
		calibre_produit_menu_distributeurs.setFont(new Font("Verdana",1,15));
			
		conditionnement_menu_commandes = new JLabel();
		conditionnement_menu_commandes.setFont(new Font("Verdana",1,15));		
		quantite_menu_commandes = new JLabel();
		quantite_menu_commandes.setFont(new Font("Verdana",1,15));
		date_conditionnement_menu_commandes = new JLabel();
		date_conditionnement_menu_commandes.setFont(new Font("Verdana",1,15));
		date_envoi_menu_commandes = new JLabel();
		date_envoi_menu_commandes.setFont(new Font("Verdana",1,15));
		id_distributeur_menu_commandes = new JLabel();
		id_distributeur_menu_commandes.setFont(new Font("Verdana",1,15));
		id_produit_menu_commandes = new JLabel();
		id_produit_menu_commandes.setFont(new Font("Verdana",1,15));
		variete_produit_menu_commandes = new JLabel();
		variete_produit_menu_commandes.setFont(new Font("Verdana",1,15));
		type_produit_menu_commandes = new JLabel();
		type_produit_menu_commandes.setFont(new Font("Verdana",1,15));
		calibre_produit_menu_commandes = new JLabel();
		calibre_produit_menu_commandes.setFont(new Font("Verdana",1,15));
		
		variete_produit_menu_produits = new JLabel();
		variete_produit_menu_produits.setFont(new Font("Verdana",1,15));
		type_produit_menu_produits = new JLabel();
		type_produit_menu_produits.setFont(new Font("Verdana",1,15));
		calibre_produit_menu_produits = new JLabel();
		calibre_produit_menu_produits.setFont(new Font("Verdana",1,15));
		
		
	}
	
	public void initPositions()
	{	
		bouton_distributeur.setBounds(5, 150, 150, 50);	
		bouton_commandes.setBounds(5, 300, 150, 50);
		bouton_produits.setBounds(5, 450, 150, 50);
			
		titre_menu.setBounds(350, 125, 300, 50);	
		nom_distributeur_menu_distributeurs.setBounds(350, 200, 300, 25);
		commandes_associees_menu_distributeurs.setBounds(350, 240, 200, 25);
		liste_commandes_menu_distributeurs.setBounds(550, 240, 150, 25);		
		conditionnement_menu_distributeurs.setBounds(350, 280, 400, 25);
		quantite_menu_distributeurs.setBounds(350, 320, 400, 25);
		date_conditionnement_menu_distributeurs.setBounds(350, 360, 400, 25);
		date_envoi_menu_distributeurs.setBounds(350, 400, 400, 25);		
		id_produit_menu_distributeurs.setBounds(350, 440, 400, 25);
		variete_produit_menu_distributeurs.setBounds(350, 480, 400, 25);
		type_produit_menu_distributeurs.setBounds(350, 520, 400, 25);
		calibre_produit_menu_distributeurs.setBounds(350, 560, 400, 25);
		
		conditionnement_menu_commandes.setBounds(350, 200, 300, 25);
		quantite_menu_commandes.setBounds(350, 240, 300, 25);
		date_conditionnement_menu_commandes.setBounds(350, 280, 400, 25);
		date_envoi_menu_commandes.setBounds(350, 320, 400, 25);
		id_distributeur_menu_commandes.setBounds(350, 360, 300, 25);
		id_produit_menu_commandes.setBounds(350, 400, 400, 25);
		variete_produit_menu_commandes.setBounds(350, 440, 400, 25);
		type_produit_menu_commandes.setBounds(350, 480, 540, 25);
		calibre_produit_menu_commandes.setBounds(350, 520, 400, 25);
		
		type_produit_menu_produits.setBounds(350, 200, 300, 25);
		variete_produit_menu_produits.setBounds(350, 240, 300, 25);
		calibre_produit_menu_produits.setBounds(350, 280, 300, 25);

		
		panel.add(bouton_distributeur);
		panel.add(bouton_commandes);
		panel.add(bouton_produits);
		
		panel.add(titre_menu);
		panel.add(nom_distributeur_menu_distributeurs);
		panel.add(commandes_associees_menu_distributeurs);
		panel.add(liste_commandes_menu_distributeurs);
		panel.add(conditionnement_menu_distributeurs);
		panel.add(quantite_menu_distributeurs);
		panel.add(date_conditionnement_menu_distributeurs);
		panel.add(date_envoi_menu_distributeurs);
		panel.add(id_produit_menu_distributeurs);
		panel.add(variete_produit_menu_distributeurs);
		panel.add(type_produit_menu_distributeurs);
		panel.add(calibre_produit_menu_distributeurs);
		
		panel.add(conditionnement_menu_commandes);
		panel.add(quantite_menu_commandes);
		panel.add(date_conditionnement_menu_commandes);
		panel.add(date_envoi_menu_commandes);
		panel.add(id_distributeur_menu_commandes);
		panel.add(id_produit_menu_commandes);
		panel.add(variete_produit_menu_commandes);
		panel.add(type_produit_menu_commandes);
		panel.add(calibre_produit_menu_commandes);
		
		panel.add(variete_produit_menu_produits);
		panel.add(type_produit_menu_produits);
		panel.add(calibre_produit_menu_produits);
	}
	
	public static void setListeDistributeursMenuDistributeurs(Vector vecteur)
	{
		liste_distributeurs_menu_distributeurs = new JComboBox<String>(vecteur);
		liste_distributeurs_menu_distributeurs.addActionListener(new EcouteurListe());
		liste_distributeurs_menu_distributeurs.setBounds(350, 170, 200, 25);
		panel.add(liste_distributeurs_menu_distributeurs);

	}
	public static void setListeCommandesMenuCommandes(Vector vecteur)
	{
		liste_commandes_menu_commandes = new JComboBox<>(vecteur);
		liste_commandes_menu_commandes.addActionListener(new EcouteurListe());
		liste_commandes_menu_commandes.setBounds(350, 170, 200, 25);
		panel.add(liste_commandes_menu_commandes);

	}
	public static void setListeProduitsMenuProduits(Vector vecteur)
	{
		liste_produits_menu_produits = new JComboBox<>(vecteur);
		liste_produits_menu_produits.addActionListener(new EcouteurListe());
		liste_produits_menu_produits.setBounds(350, 170, 200, 25);
		panel.add(liste_produits_menu_produits);

	}
	public static void montrerInterfaceDistributeurs(boolean visible)
	{
		nom_distributeur_menu_distributeurs.setVisible(visible);
		commandes_associees_menu_distributeurs.setVisible(visible);
		conditionnement_menu_distributeurs.setVisible(visible);
		quantite_menu_distributeurs.setVisible(visible);
		date_conditionnement_menu_distributeurs.setVisible(visible);
		date_envoi_menu_distributeurs.setVisible(visible);
		id_produit_menu_distributeurs.setVisible(visible);
		variete_produit_menu_distributeurs.setVisible(visible);
		type_produit_menu_distributeurs.setVisible(visible);
		calibre_produit_menu_distributeurs.setVisible(visible);
		liste_commandes_menu_distributeurs.setVisible(visible);
		liste_distributeurs_menu_distributeurs.setVisible(visible);		
	}
	public static void monterInterfaceCommandes(boolean visible)
	{
		liste_commandes_menu_commandes.setVisible(visible);
		conditionnement_menu_commandes.setVisible(visible);
		date_conditionnement_menu_commandes.setVisible(visible);
		date_envoi_menu_commandes.setVisible(visible);
		quantite_menu_commandes.setVisible(visible);
		id_distributeur_menu_commandes.setVisible(visible);
		id_produit_menu_commandes.setVisible(visible);
		variete_produit_menu_commandes.setVisible(visible);
		type_produit_menu_commandes.setVisible(visible);
		calibre_produit_menu_commandes.setVisible(visible);

	}
	public static void montrerIntefaceProduits(boolean visible)
	{
		variete_produit_menu_produits.setVisible(visible);
		type_produit_menu_produits.setVisible(visible);
		calibre_produit_menu_produits.setVisible(visible);

	}
	public static void chargerMenu(String menu)
	{
		switch(menu)
		{
			case("distributeurs"):			
				montrerInterfaceDistributeurs(true);
				monterInterfaceCommandes(false);
				montrerIntefaceProduits(false);
				titre_menu.setText("Distributeurs");
			break;
			
			case("commandes"):			
				montrerInterfaceDistributeurs(false);
				monterInterfaceCommandes(true);
				montrerIntefaceProduits(false);

				titre_menu.setText("Commandes");
			break;
			
			case("produits"):			
				montrerInterfaceDistributeurs(false);
				monterInterfaceCommandes(false);
				montrerIntefaceProduits(true);
				titre_menu.setText("Produits");
			break;
		}
	}
	public static BoutonDistributeur getDistributeursBouton()
	{
		return bouton_distributeur;
	}
	public static BoutonCommandes getCommandesBouton()
	{
		return bouton_commandes;
	}
	public static BoutonProduits getProduitsBouton()
	{
		return bouton_produits;
	}
	public static JLabel getNomDistributeurMenuDistributeurs()
	{
		return nom_distributeur_menu_distributeurs;
	}
	public static JComboBox<String> getListeDistributeursMenuDistributeurs()
	{
		return liste_distributeurs_menu_distributeurs;
	}
	public static JComboBox<String> getListeCommandesMenuDistributeurs()
	{
		return liste_commandes_menu_distributeurs;
	}
	public static void setGestionCommande(GestionCommandes donnees)
	{
		donnees_gestion = donnees;
	}
	public static GestionCommandes getGestionCommandes()
	{
		return donnees_gestion;
	}
	public static JLabel getConditionnementMenuDistributeurs() 
	{		
		return conditionnement_menu_distributeurs;
	}
	public static JLabel getQuantiteMenuDistributeurs() 
	{		
		return quantite_menu_distributeurs;
	}
	public static JLabel getDateConditionnementMenuDistributeurs() 
	{		
		return date_conditionnement_menu_distributeurs;
	}
	public static JLabel getDateEnvoiMenuDistributeurs() 
	{		
		return date_envoi_menu_distributeurs;
	}
	
	public static JLabel getIdProduitMenuDistributeurs() 
	{
		return id_produit_menu_distributeurs;
	}
	public static JLabel getVarieteProduitMenuDistributeurs() 
	{
		return variete_produit_menu_distributeurs;
	}
	public static JLabel getTypeProduitMenuDistributeurs() 
	{
		return type_produit_menu_distributeurs;
	}
	public static JLabel getCalibreProduitMenuDistributeurs() 
	{
		return calibre_produit_menu_distributeurs;		
	}	
	public static JComboBox<String> getListeCommandesMenuCommandes()
	{
		return liste_commandes_menu_commandes;
	}
	public static JComboBox getListeProduitsMenusProduits()
	{
		return liste_produits_menu_produits;
	}
	public static JLabel getConditionnementMenuCommandes() 
	{		
		return conditionnement_menu_commandes;
	}
	public static JLabel getQuantiteMenuCommandes() 
	{		
		return quantite_menu_commandes;
	}
	public static JLabel getDateConditionnementMenuCommandes() 
	{		
		return date_conditionnement_menu_commandes;
	}
	public static JLabel getDateEnvoiMenuCommandes() 
	{		
		return date_envoi_menu_commandes;
	}
	
	public static JLabel getIdProduitMenuCommandes() 
	{
		return id_produit_menu_commandes;
	}
	public static JLabel getIdDistributeurMenuCommandes()
	{
		return id_distributeur_menu_commandes;
	}
	public static JLabel getVarieteProduitMenuCommandes()
	{
		return variete_produit_menu_commandes;
	}
	public static JLabel getTypeProduitMenuCommandes()
	{
		return type_produit_menu_commandes;
	}
	public static JLabel getCalibreProduitMenuCommandes()
	{
		return calibre_produit_menu_commandes;
	}
	
	public static JLabel getVarieteProduitMenuProduits()
	{
		return variete_produit_menu_produits;
	}
	public static JLabel getTypeProduitMenuProduits()
	{
		return type_produit_menu_produits;
	}
	public static JLabel getCalibreProduitMenuProduits()
	{
		return calibre_produit_menu_produits;
	}
	
}
