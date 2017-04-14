import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PagePrincipale extends JFrame{

	private static JPanel panel;
	private static BoutonCommandes bouton_commandes;
	private static BoutonDistributeur bouton_distributeur;
	private static BoutonProduits bouton_produits;
	private static String menu_courant;
	private static GestionClique clique = new GestionClique();
	
	public PagePrincipale()
	{
		initPanel();
		initialiserPositions();
		this.setTitle("Agrur - Gestion des commandes XML");
		this.setSize(1024, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(panel);
		this.setLayout(null);
		this.setIconImage(GestionRessources.getLogo());
		this.setVisible(true);
		
	}
	public void initPanel()
	{
		panel = new JPanel()
		{
			@Override
			public void paintComponent(Graphics g)
			{
				g.drawImage(GestionRessources.getPrincipale(), 0, 0, this.getWidth(),this.getHeight(),null);
				g.setColor(new Color(199, 207, 0));
				g.setFont(new Font("Verdana",0,25));
				g.drawString(PageConnexion.getIdentifiant(), 85, 45);			
			}
		};
		
		bouton_distributeur = new BoutonDistributeur();
		bouton_distributeur.addMouseListener(clique);
		bouton_commandes = new BoutonCommandes();
		bouton_commandes.addMouseListener(clique);
		bouton_produits = new BoutonProduits();
		bouton_produits.addMouseListener(clique);
		
	}
	
	public void initialiserPositions()
	{	
		bouton_distributeur.setBounds(5, 150, 150, 50);	
		bouton_commandes.setBounds(5, 300, 150, 50);
		bouton_produits.setBounds(5, 450, 150, 50);
	
		panel.add(bouton_distributeur);
		panel.add(bouton_commandes);
		panel.add(bouton_produits);
			
	}
		
	public static String getMenuCourant()
	{
		return menu_courant;
	}

	public static BoutonDistributeur getDistributeursBouton()
	{
		return bouton_distributeur;
	}
	public static BoutonCommandes getCommandesBouton()
	{
		return bouton_commandes;
	}
	public static BoutonProduits getProduitsBouton()
	{
		return bouton_produits;
	}
		
}