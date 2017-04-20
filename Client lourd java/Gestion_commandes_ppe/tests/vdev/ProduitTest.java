package vdev;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProduitTest {

	Produit produit01;
	
	@Before
	public void setUp() throws Exception {
		
		produit01 = new Produit("franquette", "fraiche", 25);
	}


	@Test
	public void testGetVariete() {
		
		assertEquals("mauvaise variété de produit", "franquette",produit01.getVariete());
		
	}

	@Test
	public void testGetType() {
		assertEquals("mauvais type de produit", "fraiche",produit01.getType());
	}

	@Test
	public void testGetCalibre() {
		assertEquals("mauvais calibre de produit", 25,produit01.getCalibre());
	}

}
