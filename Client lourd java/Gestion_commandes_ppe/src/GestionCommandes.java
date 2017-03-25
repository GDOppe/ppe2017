
public class GestionCommandes {

	private PersistanceSQL les_donnees;
	
	public GestionCommandes(PersistanceSQL les_donnees)
	{
		this.les_donnees = les_donnees;
	}
	
	public Distributeur getDistributeur(String id_distributeur)
	{
		Distributeur le_distributeur = null;
		
		try
		{
			le_distributeur = (Distributeur) les_donnees.chargerBase(id_distributeur, "Distributeur");
			return le_distributeur;
		}
		catch(Exception e)
		{
			return le_distributeur;
		}
	}
	public Commande getCommande(String id_commande)
	{
		Commande la_commande = null;
		
		try
		{
			la_commande = (Commande) les_donnees.chargerBase(id_commande, "Commande");
			return la_commande;
		}
		catch(Exception e)
		{
			return la_commande;
		}
	}
	public Produit getProduit(String id_produit)
	{
		Produit le_produit = null;
		
		try
		{
			le_produit = (Produit) les_donnees.chargerBase(id_produit, "Produit");
			return le_produit;
		}
		catch(Exception e)
		{
			return le_produit;
		}
	}
	public PersistanceSQL getPersistance()
	{
		return les_donnees;
	}
}
