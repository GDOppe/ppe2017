
public class Produit {

	private String variete;
	private String type;
	private int calibre;
	private String id_produit;
	
	public Produit(String id, String variete, String type, int calibre)
	{
		this.variete = variete;
		this.type = type;
		this.calibre = calibre;
		this.id_produit = id;
	}
	public String getId()
	{
		return this.id_produit;
	}
	public String getVariete()
	{
		return this.variete;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public int getCalibre()
	{
		return this.calibre;
	}
}
