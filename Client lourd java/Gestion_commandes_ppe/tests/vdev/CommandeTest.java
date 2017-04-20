package vdev;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CommandeTest {

	Commande commande01;
	Commande commande02;
	Produit produit01;
	
	@Before
	public void setUp() throws Exception {
		
		commande01 = new Commande("01","sachet",50,new Date(),null,"01");
		commande02 = new Commande("02","tonneau",50,new Date(),new Date(),"02");
		
		produit01 = new Produit("franquette", "fraiche", 50);
		
		commande01.setProduit(produit01);
	}

	@Test
	public void testGetId() {
		
		assertEquals("ID différents", "01",commande01.getId());
		assertEquals("ID différents", "02",commande02.getId());
	}

	@Test
	public void testGetProduit() {
		
		assertEquals("produit différent", new Produit("franquette", "fraiche", 50).getCalibre(),commande01.getProduit().getCalibre());
		assertEquals("produit différent", new Produit("franquette", "fraiche", 50).getType(),commande01.getProduit().getType());
		assertEquals("produit différent", new Produit("franquette", "fraiche", 50).getVariete(),commande01.getProduit().getVariete());

	}

	@Test
	public void testGetDateConditionnement() {
		
		assertEquals("dates différentes", new Date(),commande01.getDateConditionnement());
	}

	@Test
	public void testGetConditionnement() {
		
		assertEquals("conditionnements différents", "sachet",commande01.getConditionnement());
	}

	@Test
	public void testGetQuantite() {
		
		assertEquals("quantités différentes", 50,commande01.getQuantite());
	}

	@Test
	public void testGetDateEnvoi() {
		assertNull("commande livrée",commande01.getDateEnvoi());
	}

	@Test
	public void testGetIdDistributeur() {
		
		assertEquals("ID distributeur différent", "01",commande01.getIdDistributeur());
		assertEquals("ID distributeur différent", "02",commande02.getIdDistributeur());

	}

	@Test
	public void testEnCours() {
		
		assertTrue("commande livrée",commande01.EnCours());
	}

}
