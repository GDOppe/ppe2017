package vdev;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * 
 * Classe qui gère le bouton des commandes
 * 
 * @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
 * @version 1.0
 * 
 * 
 * */
public class BoutonCommandes extends JButton {
	
	/**
	 * 
	 * Applique au bouton son image et efface son bord
	 * @see GestionRessources
	 * 
	 * */
	public BoutonCommandes()
	{
		setIcon(new ImageIcon(GestionRessources.getCommandesBouton()));
		setBorder(null);
	}
	/**
	 * 
	 * Applique au bouton son image lorsqu'un clique est effectué
	 * @see GestionRessources
	 * 
	 * */
	public void bouttonClique()
	{
		setIcon(new ImageIcon(GestionRessources.getCommandesBoutonHover()));
	}
	/**
	 * 
	 * Applique au bouton son image lorsque la pression est relachée
	 * @see GestionRessources 
	 * */
	public void bouttonNormal()
	{
		setIcon(new ImageIcon(GestionRessources.getCommandesBouton()));
	}
}
