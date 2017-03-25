import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;


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
	
	public PersistanceSQL(String ip_base, int port, String nom_base, String utilisateur, String motDePasse)
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
	          
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void chargerListeDistributeurMenuDistributeurs() throws Exception
	{
		String selection = "SELECT * FROM distributeur";
		resultat = etat.executeQuery(selection);
		
		Vector vecteur = new Vector();
		while(resultat.next())
		{
			String id_distributeur = resultat.getString("idDistributeur");
			vecteur.add(id_distributeur);		
		}
		PagePrincipale.setListeDistributeursMenuDistributeurs(vecteur);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void chargerListeCommandesMenuCommandes() throws Exception
	{
		String selection = "SELECT * FROM commande";
		resultat = etat.executeQuery(selection);
		Vector vecteur = new Vector();
		while(resultat.next())
		{
			String id_commande = resultat.getString("idCommande");
			vecteur.add(id_commande);
		}
		PagePrincipale.setListeCommandesMenuCommandes(vecteur);
	}
	public void chargerListeProduitsMenuProduits() throws Exception
	{
		String selection = "SELECT * FROM produit";
		resultat = etat.executeQuery(selection);
		
		Vector vecteur = new Vector();
		while(resultat.next())
		{
			String id_produit = resultat.getString("idProduit");
			vecteur.add(id_produit);		
		}
		PagePrincipale.setListeProduitsMenuProduits(vecteur);
	}
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
					String selection_commandes = "SELECT * FROM commande as c, produit as p WHERE c.idDistributeur = '"+distributeur.getId()+"' and p.idProduit = c.idProduit";
					resultat = etat.executeQuery(selection_commandes);
					while(resultat.next())
					{
						Commande commande = new Commande(resultat.getString("idCommande"),resultat.getString("conditionnement"),resultat.getInt("quantite"),resultat.getDate("dateConditionnement"),resultat.getDate("dateEnvoi"),resultat.getString("idDistributeur"));
						Produit le_produit = new Produit(resultat.getString("idProduit"),resultat.getString("variete"),resultat.getString("type"),resultat.getInt("calibre"));
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
	    			commande = new Commande(resultat.getString("idCommande"), resultat.getString("conditionnement"), resultat.getInt("quantite"), resultat.getDate("dateConditionnement"), resultat.getDate("dateEnvoi"),resultat.getString("idDistributeur"));
	    			objet_existant = true;
	    		}
				if(objet_existant)
				{
					String selection_produit = "SELECT * FROM commande as c, produit as p WHERE c.idCommande = '"+commande.getId()+"' and p.idProduit = c.idProduit";
					resultat = etat.executeQuery(selection_produit);
					Produit le_produit = null;
					while(resultat.next())
					{
						le_produit = new Produit(resultat.getString("idProduit"),resultat.getString("variete"),resultat.getString("type"),resultat.getInt("calibre"));
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
				String selection_produit = "SELECT * FROM produit WHERE idProduit = '"+id+"'";
				resultat = etat.executeQuery(selection_produit);
				while(resultat.next())
				{	
					produit = new Produit(resultat.getString("idProduit"), resultat.getString("variete"), resultat.getString("type"), resultat.getInt("calibre"));
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
	
    public boolean connexion(String nom_utilisateur, String mot_de_passe) throws Exception
    {		
    	boolean utilisateur_existant = false;
    	Class.forName("com.mysql.jdbc.Driver"); 
   
    	connexion_base = DriverManager.getConnection(this.serveur,this.utilisateur,this.motDePasse);
    	
    	etat = connexion_base.createStatement(); 
    	
    	String selection_utilisateur = "SELECT * FROM utilisateurs WHERE login = '"+nom_utilisateur+"' and motdepasse = '"+mot_de_passe+"'";
    	resultat = etat.executeQuery(selection_utilisateur);
    	while(resultat.next())
    	{
    		utilisateur_existant = true;
    	}
    	return utilisateur_existant;
    	
    }
}
