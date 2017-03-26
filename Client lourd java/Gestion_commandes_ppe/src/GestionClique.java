import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GestionClique implements MouseListener{
	
	private static PersistanceSQL sql = new PersistanceSQL("localhost", 0, "gestioncommandesagrur", "root", "root");

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
				
		if(e.getSource() instanceof BoutonConnexion)
		{
			PageConnexion.getConnexion().bouttonClique();
			Main.getPageConnexion();
			String nom_utilisateur = PageConnexion.getInputUtilisateur().getText();			
			Main.getPageConnexion();			
			String mot_de_passe = PageConnexion.getInputMotDePasse().getText();	
			try
			{
				if(sql.connexion(nom_utilisateur,mot_de_passe))
				{				
					PagePrincipale principale = new PagePrincipale();
			    	Main.getPageConnexion();
					PageConnexion.setIdentifiant(nom_utilisateur);
					Main.getPageConnexion().dispose();	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe non valide","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception ex)
            {
                System.out.println(ex);
				JOptionPane.showMessageDialog(null, "Impossible de s'authentifier � la base de don�es.\nVeuillez v�rifer votre connexion internet relancez l'application","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
			}
		}
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
	
	@Override
	public void mouseReleased(MouseEvent e) {

		if(e.getSource() instanceof BoutonConnexion)
		{
			PageConnexion.getConnexion().bouttonNormal();
		}	
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
	public static PersistanceSQL getSQL()
	{
		return sql;
	}	
				
}
