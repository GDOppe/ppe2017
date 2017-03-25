import java.util.Date;

public class Commande {

	private String id_commande;
	private String conditionnement;
	private String id_distributeur;
	private int quantite;
	private Date date_conditionnement;
	private Date date_envoi;
	private Produit le_produit;
	
	public Commande(String id, String conditionnement, int quantite, Date date_conditionnement,Date date_envoi,String id_distributeur)
	{
		this.id_commande = id;
		this.conditionnement = conditionnement;
		this.quantite = quantite;
		this.date_conditionnement = date_conditionnement;
		this.date_envoi = date_envoi;
		this.id_distributeur = id_distributeur;
	}
	
	public String getId()
	{
		return this.id_commande;
	}
	
	public Produit getProduit()
	{
		return this.le_produit;
	}
	
	public Date getDateConditionnement()
	{
		return this.date_conditionnement;
	}
	public String getConditionnement()
	{
		return this.conditionnement;
	}
	public int getQuantite()
	{
		return this.quantite;
	}
	public Date getDateEnvoi()
	{
		return this.date_envoi;
	}
	public void setProduit(Produit le_produit)
	{
		this.le_produit = le_produit;
	}
	public String getIdDistributeur()
	{
		return this.id_distributeur;
	}
	
	public boolean EnCours()
	{
		boolean en_cours = true;
		
		if(this.date_envoi!=null)
		{
			en_cours = false;
		}
		
		return en_cours;
	}
	
}
