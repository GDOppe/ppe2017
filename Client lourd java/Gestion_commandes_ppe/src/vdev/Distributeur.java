package vdev;
import java.util.*;
/**
*
* Classe permettant d'instancier un objet Distributeur
* 
* @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
* @version 1.0
* 
*
*/
public class Distributeur {

	private String id_distributeur;
	private String nom_distributeur;
	private ArrayList<Commande> les_commandes;
	/**
	 * Créé un objet Distributeur avec ses attributs puis initiliase une liste de d'objet Commande
	 * @see Commande
	 * 
	 * @param id
	 * id du distributeur
	 * @param nom
	 * nom du distributeur
	 * */
	public Distributeur(String id, String nom)
	{
		les_commandes = new ArrayList<>();
		this.id_distributeur = id;
		this.nom_distributeur = nom;
	}
	/**
	 * Permet de récupérer l'id du distributeur
	 * @return String 
	 * */
	public String getId()
	{
		return this.id_distributeur;
	}
	/**
	 * Permet de récupérer le nom du distributeur
	 * @return String 
	 * */
	public String getNom()
	{
		return this.nom_distributeur;
	}
	/**
	 * Permet de récupérer la liste des commandes associées au distributeur
	 * @return ArrayList
	 * @see Commande
	 *  
	 * */
	public ArrayList<Commande> getCommandes()
	{
		return this.les_commandes;
	}
	/**
	 * Permet de récupérer la liste des commandes non livrées
	 * @return ArrayList
	 * @see Commande
	 *  
	 * */
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
	/**
	 * Permet d'affecter une liste de commande au distributeur
	 * @param les_commandes
	 * @see Commande
	 * 
	 *  
	 * */
	public void setLesCommandes(ArrayList<Commande> les_commandes)
	{
		this.les_commandes = les_commandes;
	}
}
