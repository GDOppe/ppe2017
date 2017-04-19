package vdev;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
*
* Classe permettant de charger les images nécessaires au fonctionnement de l'application
* 
* @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
* @version 1.0
* 
*
*/
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

	/**
	 * 
	 * Charge les images de l'application
	 * 
	 * */
	public  void chargerImages()
	{
		SplashScreen  pageChargement = new SplashScreen();
		try
		{
			System.out.println("Chargement des images ...");
			principale = ImageIO.read(getClass().getResourceAsStream("/images/principale.png"));
			logo = ImageIO.read(getClass().getResourceAsStream("/images/logo.png"));		
			distributeursBouton = ImageIO.read(getClass().getResourceAsStream("/images/distributeurs.png"));
			commandesBouton = ImageIO.read(getClass().getResourceAsStream("/images/commandes.png"));
			produitsBouton = ImageIO.read(getClass().getResourceAsStream("/images/produits.png"));
			distributeursBoutonHover = ImageIO.read(getClass().getResourceAsStream("/images/distributeursHover.png"));
			commandesBoutonHover = ImageIO.read(getClass().getResourceAsStream("/images/commandesHover.png"));
			produitsBoutonHover = ImageIO.read(getClass().getResourceAsStream("/images/produitsHover.png"));
			genererXML = ImageIO.read(getClass().getResourceAsStream("/images/genererXML.png"));
			genererXMLHover = ImageIO.read(getClass().getResourceAsStream("/images/genererXMLHover.png"));

			System.out.println("Chargement effectué");
			pageChargement.hide();
			pageChargement.finirChargement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Impossible de charger l'application.","Oups !",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	/**
	 * Retourne le logo de l'application
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getLogo()
	{
		return logo;
	}
	/**
	 * Retourne l'image de fond de l'application
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getPrincipale()
	{
		return principale;
	}
	/**
	 * Retourne l'image du bouton des distributeurs
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getDistributeursBouton()
	{
		return distributeursBouton;
	}
	/**
	 * Retourne l'image du bouton des commandes
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getCommandesBouton()
	{
		return commandesBouton;
	}
	/**
	 * Retourne l'image du bouton des produits
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getProduitsBouton()
	{
		return produitsBouton;
	}
	/**
	 * Retourne l'image du bouton des distributeurs lorsqu'un clique est effectué
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getDistributeursBoutonHover()
	{
		return distributeursBoutonHover;
	}
	/**
	 * Retourne l'image du bouton des commandes lorsqu'un clique est effectué
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getCommandesBoutonHover()
	{
		return commandesBoutonHover;
	}
	/**
	 * Retourne l'image du bouton des produits lorsqu'un clique est effectué
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getProduitsBoutonHover()
	{
		return produitsBoutonHover;
	}
	/**
	 * Retourne l'image du bouton d'édition de l'XML 
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getGenererXML()
	{
		return genererXML;
	}
	/**
	 * Retourne l'image du bouton d'édition de l'XML lorsqu'un clique est effectué
	 * @return BufferedImage
	 * 
	 * */
	public static BufferedImage getGenererXMLHover()
	{
		return genererXMLHover;
	}
	
}
