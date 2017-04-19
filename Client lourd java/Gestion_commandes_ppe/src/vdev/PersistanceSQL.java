package vdev;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;

/**
 * Classe PersistanceSQL: gère la connexion à la base de données
 * <b>Librairie utilisée: MysqlConnector</b> 
 * 
 * @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
 * 
 */

public class PersistanceSQL {

	private Connection connexion_base;
	private ResultSet resultat;
	private Statement etat;
	
	private String ip_base;
	private int port;
	private String nom_base;
	private String serveur;
	private String utilisateur;
	private String motDePasse;
	
	/** 
	 * 
	 * @param ip_base
	 * adresse IP de la base de données (exemple: 127.0.0.1)
	 * @param port
	 * port de la base de données (exemple: 3306), n'est pas obligatoire dans certains cas (par exemple localhost)
	 * @param nom_base
	 * nom de la base de données
	 * @param utilisateur
	 * identifiant de connexion (exemple: root)
	 * @param motDePasse
	 * mot de passe de connexion (exemple: root)
	 * 
	 * @throws SQLException
	 * */
	public PersistanceSQL(String ip_base, int port, String nom_base, String utilisateur, String motDePasse) throws Exception
	{
	    
	    this.ip_base = ip_base;               
	    this.nom_base = nom_base;	                           
	    this.port = port;
	    this.utilisateur = utilisateur;
	    this.motDePasse = motDePasse;
	    if(port <=0)
	    {
	    	 this.serveur ="jdbc:mysql://"+this.ip_base+"/"+this.nom_base+"?useSSL=false";
	    }
	    else
	    {
	    	 this.serveur ="jdbc:mysql://"+this.ip_base+":"+this.port+"/"+this.nom_base+"?useSSL=false";
	    }   
	    
	    Class.forName("com.mysql.jdbc.Driver");   
    	connexion_base = DriverManager.getConnection(this.serveur,this.utilisateur,this.motDePasse);  	
    	etat = connexion_base.createStatement(); 
    	
	          
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	/** 
	 * 
	 * Charge la liste des distributeurs depuis la base de données
	 * 
	 * @return JComboBox
	 * @throws SQLException
	 * */
	public JComboBox<String> chargerListeDistributeurs() throws Exception
	{
		
		JComboBox<String> liste_distributeurs = new JComboBox<>();
		
		resultat = etat.executeQuery("select * from distributeur");
		
		while(resultat.next())
		{
			String id_distributeur = resultat.getString("idDistributeur");
			liste_distributeurs.addItem(id_distributeur);		
		}
		return liste_distributeurs;		
	}
	/** 
	 * 
	 * Charge la liste des commandes depuis la base de données
	 * 
	 * @return JComboBox
	 * @throws SQLException
	 * */
	public JComboBox<String> chargerListeCommandes() throws Exception
	{
		JComboBox<String> liste_commandes = new JComboBox<>();
		
		String selection = "SELECT * FROM commande";
		resultat = etat.executeQuery(selection);
		
		while(resultat.next())
		{
			String id_commande = resultat.getString("idCommande");
			liste_commandes.addItem(id_commande);
		}
		return liste_commandes;		
	}
	/** 
	 * 
	 * Charge la liste des produits depuis la base de données
	 * 
	 * @return JComboBox
	 * @throws SQLException
	 * */
	public JComboBox<String> chargerListeProduits() throws Exception
	{
		JComboBox<String> liste_produits = new JComboBox<>();
		
		String selection = "SELECT * FROM commande";
		resultat = etat.executeQuery(selection);
		
		while(resultat.next())
		{
			String id_produit = resultat.getString("idCommande");
			liste_produits.addItem(id_produit);
		}
		return liste_produits;		
	}
	
	/** 
	 * 
	 * Charge un objet depuis la base de données en fonction de son id et de son type
	 * 
	 * @param id
	 * id de l'objet stocké dans la base de données
	 * @param nom_classe
	 * correspond au type de l'objet a charger
	 * 
	 * @return JComboBox
	 * @throws SQLException
	 * */
	public Object chargerBase(String id, String nom_classe) throws Exception
	{
		Object objet_charge = new Object();
		boolean objet_existant = false;
		
		switch(nom_classe)
		{
			
			case("Distributeur"):
				
				Distributeur distributeur = null;
				String selection_distributeur = "SELECT * FROM distributeur WHERE idDistributeur = '"+id+"'";
	    		resultat = etat.executeQuery(selection_distributeur);
	    		while(resultat.next())
	    		{    			
	    			distributeur = new Distributeur(resultat.getString("idDistributeur"),resultat.getString("nomDistributeur"));
	    			objet_existant = true;
	    		}
	    		if(objet_existant)
	    		{
	    			ArrayList<Commande> liste_commandes = new ArrayList<>();
					String selection_commandes = "SELECT * FROM commande WHERE idDistributeur = '"+distributeur.getId()+"'";
					resultat = etat.executeQuery(selection_commandes);
					while(resultat.next())
					{
						Commande commande = new Commande(resultat.getString("idCommande"),resultat.getString("typeCond"),resultat.getInt("quantite"),resultat.getDate("dateCond"),resultat.getDate("dateLiv"),resultat.getString("idDistributeur"));
						Produit le_produit = new Produit(resultat.getString("varieteNoix"),resultat.getString("typeProduit"),resultat.getInt("calibre"));
						commande.setProduit(le_produit);
						liste_commandes.add(commande);
						
					}	
					distributeur.setLesCommandes(liste_commandes);
					objet_charge = distributeur;
	    		}
	    		else
	    		{
	    			objet_charge = null;
	    		}
	    		
			break;
			
			case("Commande"):
				Commande commande = null;
				String selection_commandes = "SELECT * FROM commande WHERE idCommande = '"+id+"'";
				resultat = etat.executeQuery(selection_commandes);
				while(resultat.next())
				{			
	    			commande = new Commande(resultat.getString("idCommande"), resultat.getString("typeCond"), resultat.getInt("quantite"), resultat.getDate("dateCond"), resultat.getDate("dateLiv"),resultat.getString("idDistributeur"));
	    			objet_existant = true;
	    		}
				if(objet_existant)
				{
					String selection_produit = "SELECT * FROM commande  WHERE idCommande = '"+commande.getId()+"'";
					resultat = etat.executeQuery(selection_produit);
					Produit le_produit = null;
					while(resultat.next())
					{
						le_produit = new Produit(resultat.getString("varieteNoix"),resultat.getString("typeProduit"),resultat.getInt("calibre"));
					}
					commande.setProduit(le_produit);
					objet_charge = commande;
				}
				else
	    		{
	    			objet_charge = null;
	    		}
			break;
			case("Produit"):
				Produit produit = null;
				String selection_produit = "SELECT * FROM commande WHERE idCommande = '"+id+"'";
				resultat = etat.executeQuery(selection_produit);
				while(resultat.next())
				{	
					produit = new Produit(resultat.getString("varieteNoix"), resultat.getString("typeProduit"), resultat.getInt("calibre"));
                    objet_existant = true;
                }
				if(objet_existant)
				{
					objet_charge = produit;
				}	
			break;
		}
		return objet_charge;
		
	}
	
}
