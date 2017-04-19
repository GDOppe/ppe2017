package vdev;
import java.util.Date;
/**
*
* Classe permettant d'instancier un objet Commande
* 
* @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
* @version 1.0
* 
*
*/
public class Commande {

	private String id_commande;
	private String conditionnement;
	private String id_distributeur;
	private int quantite;
	private Date date_conditionnement;
	private Date date_envoi;
	private Produit le_produit;
	
	/**
	 * 
	 * Cr�� un objet Commande avec ses attributs.
	 * 
	 * @param id
	 * id de la commande
	 * @param conditionnement
	 * type de conditionnement de la commande (exemple: sachet, tonneau ...)
	 * @param quantite
	 * quantit� command�e
	 * @param date_conditionnement
	 * date de conditionnement de la commande
	 * @param date_envoi
	 * date d'envoi de la commande, peut �tre null si la commande n'est pas encore livr�e
	 * @param id_distributeur
	 * id du distributeur li� � la commande
	 * 
	 * */
	public Commande(String id, String conditionnement, int quantite, Date date_conditionnement,Date date_envoi,String id_distributeur)
	{
		this.id_commande = id;
		this.conditionnement = conditionnement;
		this.quantite = quantite;
		this.date_conditionnement = date_conditionnement;
		this.date_envoi = date_envoi;
		this.id_distributeur = id_distributeur;
	}
	/**
	 * Permet de r�cup�rer l'id de la commande
	 * @return String 
	 * */
	public String getId()
	{
		return this.id_commande;
	}
	/**
	 * Permet de r�cup�rer le produit li� � la commande
	 * @return Produit
	 * @see Produit 
	 * */
	public Produit getProduit()
	{
		return this.le_produit;
	}
	/**
	 * Permet de r�cup�rer la date de conditionnement de la commande
	 * @return Date 
	 * */
	public Date getDateConditionnement()
	{
		return this.date_conditionnement;
	}
	/**
	 * Permet de r�cup�rer le type de conditionnement de la commande
	 * @return String 
	 * */
	public String getConditionnement()
	{
		return this.conditionnement;
	}
	/**
	 * Permet de r�cup�rer la quantit� command�e
	 * @return int 
	 * */
	public int getQuantite()
	{
		return this.quantite;
	}
	/**
	 * Permet de r�cup�rer la date d'envoi de la commande
	 * @return Date
	 * */
	public Date getDateEnvoi()
	{
		return this.date_envoi;
	}
	/**
	 * Permet d'assigner un produit � la commande
	 * @param le_produit
	 * @see Produit
	 * 
	 * */
	public void setProduit(Produit le_produit)
	{
		this.le_produit = le_produit;
	}
	/**
	 * Permet de r�cup�rer l'id du distributeur li� � la commande
	 * @return String
	 * */
	public String getIdDistributeur()
	{
		return this.id_distributeur;
	}
	/**
	 * V�rifie si la commande est en cours de livraison ou non (si date_envoi == null ou non)
	 * @return boolean
	 * */
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
