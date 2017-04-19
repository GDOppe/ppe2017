package vdev;

public class Produit {

	private String variete;
	private String type;
	private int calibre;
	
	public Produit(String variete, String type, int calibre)
	{
		this.variete = variete;
		this.type = type;
		this.calibre = calibre;
		
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
