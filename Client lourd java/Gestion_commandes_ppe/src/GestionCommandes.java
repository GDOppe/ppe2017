import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import javax.swing.JOptionPane;

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
	public static void XMLCommande(Distributeur distributeur) throws Exception
	{
		
		
		File fichier_commandes = new File("Commandes\\"+distributeur.getId()+" - "+distributeur.getNom()+".xml");
		
		BufferedWriter print_commandes = new BufferedWriter(new FileWriter(fichier_commandes));
		
		print_commandes.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		print_commandes.newLine();
		print_commandes.write("<commandes idDistributeur=\""+distributeur.getId()+"\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");
		print_commandes.newLine();
		
		for(Commande commande: distributeur.getCommandes())
		{
			if(commande.getDateEnvoi()==null)
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
		}
		print_commandes.write("</commandes>");
		print_commandes.close();	
		JOptionPane.showMessageDialog(null, "Edition terminée ! Votre fichier se trouve dans le dossier:\n\n Commandes\\"+distributeur.getId()+" - "+distributeur.getNom()+".xml","Gestion des commandes",JOptionPane.INFORMATION_MESSAGE);

		
	}
}
