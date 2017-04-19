package vdev;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import javax.swing.JOptionPane;
/**
 * 
 * Classe permettant la gestion des commandes
 * 
 * @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
 * @version 1.0
 * 
 * */
public class GestionCommandes {

	private PersistanceSQL les_donnees;
	
	/**
	 * Attribution d'un objet PersistanceSQL pour pouvoir effectuer des opérations sur la base de données
	 * 
	 * @param les_donnees
	 * @see PersistanceSQL
	 * 
	 * */
	public GestionCommandes(PersistanceSQL les_donnees)
	{
		this.les_donnees = les_donnees;
	}
	/**
	 * Retrouve un distributeur dans la base de données via son id, avec la fonction chargerBase 
	 * @param id_distributeur
	 * @return Distributeur
	 * @see PersistanceSQL
	 * 
	 * */
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
	/**
	 * Retrouve une commande dans la base de données via son id, avec la fonction chargerBase
	 * @param id_commande
	 * @return Commande
	 * @see PersistanceSQL
	 * 
	 * */
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
	/**
	 * Retrouve un produit dans la base de données via son id, avec la fonction chargerBase
	 * @param id_produit
	 * @return Produit
	 * @see PersistanceSQL
	 * 
	 * */
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
	/**
	 * 
	 * Retourne les_donnees
	 * @return PersistanceSQL
	 * 
	 * */
	public PersistanceSQL getPersistance()
	{
		return les_donnees;
	}
	/**
	 * 
	 * Edite un fichier XML comportant les commandes non livrées d'un distributeur et l'enregistre dans un répertoire 'Commandes'
	 * 
	 * @param distributeur
	 * @see Distributeur
	 * @throws IOException
	 * 
	 * */
	public static void XMLCommande(Distributeur distributeur) throws Exception
	{
		
		
		File fichier_commandes = new File("Commandes\\"+distributeur.getId()+" - "+distributeur.getNom()+".xml");
		
		BufferedWriter print_commandes = new BufferedWriter(new FileWriter(fichier_commandes));
		
		print_commandes.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		print_commandes.newLine();
		print_commandes.write("<commandes idDistributeur=\""+distributeur.getId()+"\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");
		print_commandes.newLine();
		
		for(Commande commande: distributeur.getCommandesEnCours())
		{			
				print_commandes.write("<commande id=\""+commande.getId()+"\">");
				print_commandes.newLine();
				print_commandes.write("<produit variete=\""+commande.getProduit().getVariete()+"\" type=\""+commande.getProduit().getType()+"\" calibre=\""+commande.getProduit().getCalibre()+"\" />");
				print_commandes.newLine();
				print_commandes.write("<conditionnement type=\""+commande.getConditionnement()+"\" />");
				print_commandes.newLine();
				print_commandes.write("<quantite>"+commande.getQuantite()+"</quantite>");
				print_commandes.newLine();
				print_commandes.write("<date_conditionnement>"+commande.getDateConditionnement()+"</date_conditionnement>");
				print_commandes.newLine();
				print_commandes.write("<date_envoi>"+commande.getDateEnvoi()+"</date_envoi>");
				print_commandes.newLine();
				print_commandes.write("</commande>");
				print_commandes.newLine();
		}
		print_commandes.write("</commandes>");
		print_commandes.close();	
		JOptionPane.showMessageDialog(null, "Edition terminée ! Votre fichier se trouve dans le dossier:\n\n Commandes\\"+distributeur.getId()+" - "+distributeur.getNom()+".xml","Gestion des commandes",JOptionPane.INFORMATION_MESSAGE);

		
	}
}
