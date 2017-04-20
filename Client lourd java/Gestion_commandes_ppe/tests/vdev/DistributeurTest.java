package vdev;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DistributeurTest {

	Distributeur distributeur01;
	ArrayList<Commande> les_commandes;
	
	@Before
	public void setUp() throws Exception {
		
		les_commandes = new ArrayList<>();
		distributeur01 = new Distributeur("01", "Carrefour");
		
		les_commandes.add(new Commande("01","sachet",50,new Date(),null,"01"));
		les_commandes.add(new Commande("02","tonneau",50,new Date(),new Date(),"02"));
		
		distributeur01.setLesCommandes(les_commandes);
	}

	@Test
	public void testGetId() {	
		assertEquals("ID différents","01", distributeur01.getId());
	}

	@Test
	public void testGetNom() {
		assertEquals("nom différents","Carrefour", distributeur01.getNom());
	}
	
	
		
	@Test
	public void testGetCommandes() {
		
		assertEquals("mauvaise liste des commandes", les_commandes,distributeur01.getCommandes());
	}

	@Test
	public void testGetCommandesEnCours() {
		
		for(int i=0; i<distributeur01.getCommandesEnCours().size();i++)
		{
			assertNull("commande livrée",distributeur01.getCommandesEnCours().get(i).getDateEnvoi());
		}
	}


}
