package vdev;
/**
*
* Classe permettant d'instancier un objet Produit
* 
* @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
* @version 1.0
* 
*
*/
public class Produit {

	private String variete;
	private String type;
	private int calibre;
	/**
	 * 
	 * Cr�� un objet Produit avec ses attributs.
	 * 
	 * @param variete
	 * variete du produit (exemple: franquette)
	 * @param type
	 * type du produit (exemple: fraiche)
	 * @param calibre
	 * calibre du produit (exemple: 20)
	 * */
	public Produit(String variete, String type, int calibre)
	{
		this.variete = variete;
		this.type = type;
		this.calibre = calibre;
		
	}
	/**
	 * Permet de r�cup�rer la variete du produit
	 * @return String
	 * 
	 * */
	public String getVariete()
	{
		return this.variete;
	}
	/**
	 * Permet de r�cup�rer le type du produit
	 * @return String
	 * 
	 * */
	public String getType()
	{
		return this.type;
	}
	/**
	 * Permet de r�cup�rer le calibre du produit
	 * @return int
	 * 
	 * */
	public int getCalibre()
	{
		return this.calibre;
	}
}
