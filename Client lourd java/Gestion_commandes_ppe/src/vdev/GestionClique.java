package vdev;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
				JOptionPane.showMessageDialog(null, "Impossible d'afficher le menu des distributeurs.\nVeuillez vérifer votre connexion internet puis relancez l'application.","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "Impossible d'afficher le menu des commandes.\nVeuillez vérifer votre connexion internet puis relancez l'application.","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "Impossible d'afficher le menu des produits.\nVeuillez vérifer votre connexion internet puis relancez l'application.","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
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
