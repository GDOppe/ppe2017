

public class Main {

	private static GestionRessources ressources;
	private static PagePrincipale principale;
	
	public static void main(String[] args)
	{	
		initialiserRessources();
		initialiserFenetre();	
	}
	public static void initialiserFenetre()
	{
		principale = new PagePrincipale();	
	}
	public static void initialiserRessources()
	{
		ressources = new GestionRessources();
		ressources.chargerImages();
	}
	public static PagePrincipale getPagePrincipale()
	{
		return principale;
	}

}
