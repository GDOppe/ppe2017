
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public  class GestionRessources {
	
	//Images de fond
	private static BufferedImage principale;
	private static BufferedImage logo;	
	//Boutons
	private static BufferedImage distributeursBouton;
	private static BufferedImage commandesBouton;
	private static BufferedImage produitsBouton;
	private static BufferedImage distributeursBoutonHover;
	private static BufferedImage commandesBoutonHover;
	private static BufferedImage produitsBoutonHover;
	private static BufferedImage genererXML;
	private static BufferedImage genererXMLHover;

	
	public  void chargerImages()
	{
		SplashScreen  pageChargement = new SplashScreen();
		try
		{
			System.out.println("Chargement des images ...");
			principale = ImageIO.read(getClass().getResourceAsStream("images/principale.png"));
			logo = ImageIO.read(getClass().getResourceAsStream("images/logo.png"));		
			distributeursBouton = ImageIO.read(getClass().getResourceAsStream("images/distributeurs.png"));
			commandesBouton = ImageIO.read(getClass().getResourceAsStream("images/commandes.png"));
			produitsBouton = ImageIO.read(getClass().getResourceAsStream("images/produits.png"));
			distributeursBoutonHover = ImageIO.read(getClass().getResourceAsStream("images/distributeursHover.png"));
			commandesBoutonHover = ImageIO.read(getClass().getResourceAsStream("images/commandesHover.png"));
			produitsBoutonHover = ImageIO.read(getClass().getResourceAsStream("images/produitsHover.png"));
			genererXML = ImageIO.read(getClass().getResourceAsStream("images/genererXML.png"));
			genererXMLHover = ImageIO.read(getClass().getResourceAsStream("images/genererXMLHover.png"));

			System.out.println("Chargement effectué");
			pageChargement.hide();
			pageChargement.finirChargement();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Impossible de charger l'application.","Oups !",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	public static BufferedImage getLogo()
	{
		return logo;
	}
	public static BufferedImage getPrincipale()
	{
		return principale;
	}
	public static BufferedImage getDistributeursBouton()
	{
		return distributeursBouton;
	}
	public static BufferedImage getCommandesBouton()
	{
		return commandesBouton;
	}
	public static BufferedImage getProduitsBouton()
	{
		return produitsBouton;
	}
	public static BufferedImage getDistributeursBoutonHover()
	{
		return distributeursBoutonHover;
	}
	public static BufferedImage getCommandesBoutonHover()
	{
		return commandesBoutonHover;
	}
	public static BufferedImage getProduitsBoutonHover()
	{
		return produitsBoutonHover;
	}
	public static BufferedImage getGenererXML()
	{
		return genererXML;
	}
	public static BufferedImage getGenererXMLHover()
	{
		return genererXMLHover;
	}
	
}
