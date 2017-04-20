package vdev;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GestionCommandesTest {

	Distributeur distributeur01;
	Commande commande01;
	Produit produit01;
	PersistanceSQL sql;
	GestionCommandes gestion;
	
	@Before
	public void setUp() throws Exception {
		
		sql = new PersistanceSQL("127.0.0.1", 0, "vdev", "root", "root");
		gestion = new GestionCommandes(sql);
	}

	@Test
	public void testGetDistributeur() {
		
		distributeur01 = gestion.getDistributeur("d01");
		assertEquals("chargement échoué","d01",distributeur01.getId());
	}

	@Test
	public void testGetCommande() {
		
		commande01 = gestion.getCommande("1");
		assertEquals("chargement échoué","1",commande01.getId());
	}
	//Le produit portant l'id '1' dans la base de données, doit avoir la variété "franquette"
	@Test
	public void testGetProduit() {
		produit01 = gestion.getProduit("1");
		assertEquals("chargement échoué","franquette",produit01.getVariete());
	}
	@Test
	public void testGetPersistance() {
		
		assertEquals("mauvaise persistanceSQL", sql,gestion.getPersistance());
	}

}
