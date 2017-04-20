package vdev;

import static org.junit.Assert.*;

import javax.swing.JComboBox;


import org.junit.Before;
import org.junit.Test;

public class PersistanceSQLTest {

	PersistanceSQL sql;
	Distributeur distributeur01;
	Commande commande01;
	Produit produit01;
	JComboBox<String> liste_distributeurs;
	JComboBox<String> liste_commandes;
	JComboBox<String> liste_produits;
	
	@Before
	public void setUp() throws Exception {
		
		sql = new PersistanceSQL("127.0.0.1", 0, "vdev", "root", "root");
		
	}

	@Test
	public void testChargerListeDistributeurs() throws Exception{
		
		
		liste_distributeurs = sql.chargerListeDistributeurs();
		assertNotNull("chargement echoué",liste_distributeurs.getItemCount());
		for(int i=0; i<liste_distributeurs.getItemCount();i++)
		{
			System.out.println("id_distributeur: "+liste_distributeurs.getItemAt(i));
		}
	}

	@Test
	public void testChargerListeCommandes() throws Exception{
		
		liste_commandes = sql.chargerListeCommandes();
		assertNotNull("chargement echoué",liste_commandes.getItemCount());
		for(int i=0; i<liste_commandes.getItemCount();i++)
		{
			System.out.println("id_commande: "+liste_commandes.getItemAt(i));
		}
	}

	@Test
	public void testChargerListeProduits() throws Exception{
		
		liste_produits = sql.chargerListeProduits();
		assertNotNull("chargement echoué",liste_produits.getItemCount());
		for(int i=0; i<liste_produits.getItemCount();i++)
		{
			System.out.println("id_produit: "+liste_produits.getItemAt(i));
		}
	}

	@Test
	public void testChargerBase() throws Exception{
		
		distributeur01 = (Distributeur) sql.chargerBase("d01", "Distributeur");
		assertEquals("chargement echoué", distributeur01.getId(),"d01");
		
		commande01 = (Commande) sql.chargerBase("1", "Commande");
		assertEquals("chargement echoué", commande01.getId(),"1");
		
		produit01 = (Produit) sql.chargerBase("1", "Produit");
		assertEquals("chargement echoué", produit01.getVariete(),"franquette");
	}

}
