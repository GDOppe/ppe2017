package vdev;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
*
* Classe de gestion des cliques de la souris
* 
* @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
* @version 1.0
* 
*
*/
public class GestionClique implements MouseListener{
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
				
			
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * V�rification lors du clique de la souris<br><br>
	 * 
	 * <b>Lorsque le bouton est celui des distributeurs</b><br><br>
	 * Cr�ation d'une nouvelle instance de PageDistributeurs et chargement de l'image de clique du bouton<br><br>
	 * 
	 * <b>Lorsque le bouton est celui des commandes</b><br><br>
	 * Cr�ation d'une nouvelle instance de PageCommandes et chargement de l'image de clique du bouton<br><br>
	 *
	 * 
	 * <b>Lorsque le bouton est celui des produits</b><br><br>
	 * Cr�ation d'une nouvelle instance de PageProduits et chargement de l'image de clique du bouton<br><br>	 
	 * 
	 * <b>Lorsque le bouton est celui pour �diter les commandes non livr�es du distributeur</b><br><br>
	 * Cr�ation d'un fichier XML portant l'id et le nom du distributeur concern�, �dition de ce dernier<br>
	 * avec les informations concernant les commandes et chargement de l'image de clique du bouton<br><br>
	 * 
	 * @see GestionCommandes
	 * @see BoutonDistributeur
	 * @see BoutonCommandes
	 * @see BoutonProduits
	 * @see BoutonXML
	 * @see PageDistributeurs
	 * @see PageProduits
	 * @see PageCommandes
	 * 
	 * */
	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void mousePressed(MouseEvent e) {
				
		if(e.getSource() instanceof BoutonDistributeur)
		{
			try
			{			
				PagePrincipale.getDistributeursBouton().bouttonClique();
				PageDistributeurs page_distributeurs = new PageDistributeurs();				
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Impossible d'afficher le menu des distributeurs.\nVeuillez v�rifer votre connexion internet puis relancez l'application.","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() instanceof BoutonCommandes)
		{
			try
			{			
				PagePrincipale.getCommandesBouton().bouttonClique();
				PageCommandes page_commandes = new PageCommandes();				
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Impossible d'afficher le menu des commandes.\nVeuillez v�rifer votre connexion internet puis relancez l'application.","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if(e.getSource() instanceof BoutonProduits)
		{	
			try
			{			
				PagePrincipale.getProduitsBouton().bouttonClique();
				PageProduits page_produits = new PageProduits();				
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Impossible d'afficher le menu des produits.\nVeuillez v�rifer votre connexion internet puis relancez l'application.","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	/**
	 * 
	 * V�rification lorsque la pression est relach�e sur un bouton<br><br>
	 * 
	 * Chargement de l'image normal des boutons
	 * 
	 * 
	 * */
	@Override
	public void mouseReleased(MouseEvent e) {

		if(e.getSource() instanceof BoutonDistributeur)
		{
			PagePrincipale.getDistributeursBouton().bouttonNormal();
			
		}
		if(e.getSource() instanceof BoutonCommandes)
		{
			PagePrincipale.getCommandesBouton().bouttonNormal();
		}
		if(e.getSource() instanceof BoutonProduits)
		{
			PagePrincipale.getProduitsBouton().bouttonNormal();
		}
	}
		
				
}
