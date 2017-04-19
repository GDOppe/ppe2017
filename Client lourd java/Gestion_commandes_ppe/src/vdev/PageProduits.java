package vdev;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PageProduits extends JFrame {

	private JComboBox<String> liste_produits_menu_produits;
	private JLabel variete_produit_menu_produits;
	private JLabel type_produit_menu_produits;
	private JLabel calibre_produit_menu_produits;
	private JLabel id_produit;
	private JPanel panel;
	private Font police_distributeur;
	private Color couleur_police;
	private Produit produit_courant;
	
	public PageProduits() throws Exception
	{
		liste_produits_menu_produits = new JComboBox<>();
		initPanel();	
		this.setTitle("Produits commandés");
		this.setSize(600, 250);
		this.setResizable(false);
		this.setLocationRelativeTo(this.getParent());
		this.setContentPane(panel);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}
	
	public void initPanel() throws Exception
	{
		panel = new JPanel()
		{
			@Override
			public void paintComponent(Graphics g)
			{
				g.setColor(new Color(48, 48, 48));
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
			}
		};
		
		panel.setLayout(null);
		
		this.liste_produits_menu_produits = new GestionCommandes(PagePrincipale.getSQL()).getPersistance().chargerListeProduits();
		produit_courant = (Produit)new GestionCommandes(PagePrincipale.getSQL()).getPersistance().chargerBase(liste_produits_menu_produits.getSelectedItem().toString(),"Produit");
		
		
		police_distributeur = new Font("Verdana",0,18);
		couleur_police = new Color(185, 236, 0);
		
		id_produit = new JLabel("Id commande:");
		id_produit.setFont(police_distributeur);
		id_produit.setForeground(couleur_police);
		
		variete_produit_menu_produits = new JLabel("Variété: "+produit_courant.getVariete());
		variete_produit_menu_produits.setFont(police_distributeur);
		variete_produit_menu_produits.setForeground(couleur_police);
		
		type_produit_menu_produits = new JLabel("Type: "+produit_courant.getType());
		type_produit_menu_produits.setFont(police_distributeur);
		type_produit_menu_produits.setForeground(couleur_police);

		calibre_produit_menu_produits = new JLabel("Calibre: "+produit_courant.getCalibre());
		calibre_produit_menu_produits.setFont(police_distributeur);
		calibre_produit_menu_produits.setForeground(couleur_police);
	
		id_produit.setBounds(20,20,200,20);
		liste_produits_menu_produits.setBounds(160, 20, 150, 20);
		type_produit_menu_produits.setBounds(20, 60, 300, 25);
		variete_produit_menu_produits.setBounds(20, 100, 300, 25);
		calibre_produit_menu_produits.setBounds(20, 140, 300, 25);
		
		liste_produits_menu_produits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					produit_courant = (Produit)new GestionCommandes(PagePrincipale.getSQL()).getPersistance().chargerBase(liste_produits_menu_produits.getSelectedItem().toString(),"Produit");
					variete_produit_menu_produits.setText("Variété: "+produit_courant.getVariete());					
					type_produit_menu_produits.setText("Type: "+produit_courant.getType());
					calibre_produit_menu_produits.setText("Calibre: "+produit_courant.getCalibre());
		
				}
				catch(Exception ex)
				{
					dispose();
					JOptionPane.showMessageDialog(null, "Impossible de charger l'objet correspondant.\n Essayez de relancer une fenêtre des produits.\nSi l'erreur persiste, vérifiez votre connexion internet et relancez l'application","Gestion des commandes",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		panel.add(id_produit);
		panel.add(liste_produits_menu_produits);
		panel.add(variete_produit_menu_produits);
		panel.add(type_produit_menu_produits);
		panel.add(calibre_produit_menu_produits);
	}
}
