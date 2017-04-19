package vdev;
/**
 *
 * Classe principale du programme
 * 
 * @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
 * @version 1.0
 * 
 *
 */

public class Main {

	private static GestionRessources ressources;
	private static PagePrincipale principale;
	
	/** 
	 * 
	 * Vérifie si toutes les images nécessaires au programme sont OK 
	 * puis lance une nouvelle instance de PagePrincipale
	 * 
	 * 
	 * */
	public static void main(String[] args)
	{	
		initialiserRessources();
		initialiserFenetre();	
	}
	/**
	 * 
	 * Instancie une fenêtre principale
	 * @see PagePrincipale
	 *  
	 *  */
	public static void initialiserFenetre()
	{
		principale = new PagePrincipale();	
	}
	/**
	 * 
	 * Charge les images permettant le bon fonctionnement du programme
	 * @see GestionRessources
	 *  
	 *  */
	public static void initialiserRessources()
	{
		ressources = new GestionRessources();
		ressources.chargerImages();
	}
	/**
	 * 
	 * Retourne la fenêtre principale du programme
	 * @return PagePrincipale
	 * @see PagePrincipale
	 *  */
	public static PagePrincipale getPagePrincipale()
	{
		return principale;
	}

}
