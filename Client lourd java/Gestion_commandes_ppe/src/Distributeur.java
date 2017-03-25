import java.util.*;

public class Distributeur {

	private String id_distributeur;
	private String nom_distributeur;
	private ArrayList<Commande> les_commandes;
	
	public Distributeur(String id, String nom)
	{
		les_commandes = new ArrayList<>();
		this.id_distributeur = id;
		this.nom_distributeur = nom;
	}
	public String getId()
	{
		return this.id_distributeur;
	}
	public String getNom()
	{
		return this.nom_distributeur;
	}
	public ArrayList<Commande> getCommandes()
	{
		return this.les_commandes;
	}
	
	public ArrayList<Commande> getCommandesEnCours()
	{
		ArrayList<Commande> commandes_en_cours = new ArrayList<>();
		
		for(Commande commande: this.les_commandes)
		{
			if(commande.EnCours())
			{
				commandes_en_cours.add(commande);
			}
		}
		return commandes_en_cours;
	}
	public void setLesCommandes(ArrayList<Commande> les_commandes)
	{
		this.les_commandes = les_commandes;
	}
}
