

public class Main {

	private static GestionRessources ressources;
	private static PageConnexion connexion;
	
	public static void main(String[] args)
	{	
		initialiserRessources();
		initialiserFenetre();	
	}
	public static void initialiserFenetre()
	{
		connexion = new PageConnexion();	
	}
	public static void initialiserRessources()
	{
		ressources = new GestionRessources();
		ressources.chargerImages();
	}
	public static PageConnexion getPageConnexion()
	{
		return connexion;
	}

}
