import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class EcouteurListe implements ActionListener {

	@SuppressWarnings("unchecked")	
	@Override	
	public void actionPerformed(ActionEvent e) {
					
		if(e.getSource().equals(PagePrincipale.getListeDistributeursMenuDistributeurs()))
		{
			initialiserDistributeursMenuDistributeurs();
			
		}
		else if(e.getSource().equals(PagePrincipale.getListeCommandesMenuDistributeurs()))
		{
			initialiserCommandesMenuDistributeurs();
		}
		else if(e.getSource().equals(PagePrincipale.getListeCommandesMenuCommandes()))
		{
			initialiserCommandesMenuCommandes();
		}
		else if(e.getSource().equals(PagePrincipale.getListeProduitsMenusProduits()))
		{
			initialiserProduitsMenuProduits();
		}
			
	}
	public static void initialiserDistributeursMenuDistributeurs()
	{		
		Distributeur distributeur_courant = PagePrincipale.getGestionCommandes().getDistributeur(PagePrincipale.getListeDistributeursMenuDistributeurs().getSelectedItem().toString());
		PagePrincipale.getNomDistributeurMenuDistributeurs().setText("Nom distributeur: "+distributeur_courant.getNom());
		if(PagePrincipale.getListeCommandesMenuDistributeurs().getItemCount()>0)
		{
			PagePrincipale.getListeCommandesMenuDistributeurs().removeAllItems();
		}
		for(Commande commande : distributeur_courant.getCommandes())
		{			
			PagePrincipale.getListeCommandesMenuDistributeurs().addItem(commande.getId());
			
			if(commande.getId().equals(PagePrincipale.getListeCommandesMenuDistributeurs().getSelectedItem().toString()))
			{
				PagePrincipale.getConditionnementMenuDistributeurs().setText("Conditionnement: "+commande.getConditionnement());
				PagePrincipale.getQuantiteMenuDistributeurs().setText("Quantité: "+commande.getQuantite());
				PagePrincipale.getDateConditionnementMenuDistributeurs().setText("Date conditionnement: " +commande.getDateConditionnement());
				PagePrincipale.getDateEnvoiMenuDistributeurs().setText("Date d'envoi: "+commande.getDateEnvoi());
			}
		}
	}
	public static void initialiserCommandesMenuDistributeurs()
	{
		Distributeur distributeur_courant = PagePrincipale.getGestionCommandes().getDistributeur(PagePrincipale.getListeDistributeursMenuDistributeurs().getSelectedItem().toString());
		for(Commande commande : distributeur_courant.getCommandes())
		{
			if(PagePrincipale.getListeCommandesMenuDistributeurs().getItemCount()>0)
			{
				if(commande.getId().equals(PagePrincipale.getListeCommandesMenuDistributeurs().getSelectedItem().toString()))
				{
					PagePrincipale.getConditionnementMenuDistributeurs().setText("Conditionnement: "+commande.getConditionnement());
					PagePrincipale.getQuantiteMenuDistributeurs().setText("Quantité: "+commande.getQuantite());
					PagePrincipale.getDateConditionnementMenuDistributeurs().setText("Date conditionnement: " +commande.getDateConditionnement());
					PagePrincipale.getDateEnvoiMenuDistributeurs().setText("Date d'envoi: "+commande.getDateEnvoi());				
					PagePrincipale.getIdProduitMenuDistributeurs().setText("Produit: "+commande.getProduit().getId());
					PagePrincipale.getVarieteProduitMenuDistributeurs().setText("Variété: "+commande.getProduit().getVariete());
					PagePrincipale.getTypeProduitMenuDistributeurs().setText("Type: "+commande.getProduit().getType());
					PagePrincipale.getCalibreProduitMenuDistributeurs().setText("Calibre: "+commande.getProduit().getCalibre());

				}
			}				
		}
	}
	public static void initialiserCommandesMenuCommandes()
	{
		Commande commande_courante = PagePrincipale.getGestionCommandes().getCommande(PagePrincipale.getListeCommandesMenuCommandes().getSelectedItem().toString());
		
		PagePrincipale.getConditionnementMenuCommandes().setText("Conditionnement: "+commande_courante.getConditionnement());
		PagePrincipale.getDateConditionnementMenuCommandes().setText("Date conditionnement: "+commande_courante.getDateConditionnement());
		PagePrincipale.getDateEnvoiMenuCommandes().setText("Date envoi: "+commande_courante.getDateEnvoi());
		PagePrincipale.getQuantiteMenuCommandes().setText("Quantité: "+commande_courante.getQuantite());
		PagePrincipale.getIdProduitMenuCommandes().setText("Produit: "+commande_courante.getProduit().getId());
		PagePrincipale.getIdDistributeurMenuCommandes().setText("Distributeur associé: "+commande_courante.getIdDistributeur());
		PagePrincipale.getVarieteProduitMenuCommandes().setText("Variété: "+commande_courante.getProduit().getVariete());
		PagePrincipale.getTypeProduitMenuCommandes().setText("Type: "+commande_courante.getProduit().getType());
		PagePrincipale.getCalibreProduitMenuCommandes().setText("Calibre: "+commande_courante.getProduit().getCalibre());
	}
	
	public static void initialiserProduitsMenuProduits()
	{
		Produit produit_courant = PagePrincipale.getGestionCommandes().getProduit(PagePrincipale.getListeProduitsMenusProduits().getSelectedItem().toString());
		
		PagePrincipale.getVarieteProduitMenuProduits().setText("Variété: "+produit_courant.getVariete());
		PagePrincipale.getTypeProduitMenuProduits().setText("Type: "+produit_courant.getType());
		PagePrincipale.getCalibreProduitMenuProduits().setText("Calibre: "+produit_courant.getCalibre());
	}

	
}
