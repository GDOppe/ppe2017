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

public class PageCommandes extends JFrame{
	
	private JComboBox<String> liste_commandes_page_commandes;
	private JLabel id_commande;
	private JLabel conditionnement_commande_courante;
	private JLabel quantite_commande_courante;
	private JLabel date_conditionnement_commande_courante;
	private JLabel date_envoi_commande_courante;
	private JLabel id_distributeur_commande_courante;
	private JLabel variete_produit_commande_courante;
	private JLabel type_produit_commande_courante;
	private JLabel calibre_produit_commande_courante;
	private JPanel panel;	
	private Font police_distributeur;
	private Color couleur_police;
	private Commande commande_courante;
	
	public PageCommandes() throws Exception
	{
		liste_commandes_page_commandes = new JComboBox<>();
		
		initPanel();		
		this.setTitle("Commandes enregistrés");
		this.setSize(600, 450);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(GestionRessources.getLogo());
		this.setContentPane(panel);		
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}
	public void initPanel() throws Exception
	{
		police_distributeur = new Font("Verdana",0,18);
		couleur_police = new Color(185, 236, 0);
		
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
		
		this.liste_commandes_page_commandes = new GestionCommandes(PagePrincipale.getSQL()).getPersistance().chargerListeCommandes();
		commande_courante = (Commande)new GestionCommandes(PagePrincipale.getSQL()).getPersistance().chargerBase(liste_commandes_page_commandes.getSelectedItem().toString(),"Commande");
		
		id_commande = new JLabel("Id:");
		id_commande.setFont(police_distributeur);
		id_commande.setForeground(couleur_police);
		
		conditionnement_commande_courante = new JLabel("Conditionnement: "+commande_courante.getConditionnement());
		conditionnement_commande_courante.setFont(police_distributeur);
		conditionnement_commande_courante.setForeground(couleur_police);
		
		date_conditionnement_commande_courante = new JLabel("Date de conditionnement: "+commande_courante.getDateConditionnement());
		date_conditionnement_commande_courante.setFont(police_distributeur);
		date_conditionnement_commande_courante.setForeground(couleur_police);
		
		date_envoi_commande_courante = new JLabel("Date d'envoi: "+commande_courante.getDateEnvoi());
		date_envoi_commande_courante.setFont(police_distributeur);
		date_envoi_commande_courante.setForeground(couleur_police);
		
		quantite_commande_courante = new JLabel("Quantité: "+commande_courante.getQuantite());
		quantite_commande_courante.setFont(police_distributeur);
		quantite_commande_courante.setForeground(couleur_police);
		
		id_distributeur_commande_courante = new JLabel("Distributeur associé: "+commande_courante.getIdDistributeur());
		id_distributeur_commande_courante.setFont(police_distributeur);
		id_distributeur_commande_courante.setForeground(couleur_police);
		
		variete_produit_commande_courante = new JLabel("Variété: "+commande_courante.getProduit().getVariete());
		variete_produit_commande_courante.setFont(police_distributeur);
		variete_produit_commande_courante.setForeground(couleur_police);
		
		type_produit_commande_courante = new JLabel("Type: "+commande_courante.getProduit().getType());
		type_produit_commande_courante.setFont(police_distributeur);
		type_produit_commande_courante.setForeground(couleur_police);
		
		calibre_produit_commande_courante = new JLabel("Type: "+commande_courante.getProduit().getCalibre());
		calibre_produit_commande_courante.setFont(police_distributeur);
		calibre_produit_commande_courante.setForeground(couleur_police);
		
		id_commande.setBounds(20,20,200,20);
		liste_commandes_page_commandes.setBounds(60, 20, 150, 20);
		conditionnement_commande_courante.setBounds(20, 60, 300, 20);
		date_conditionnement_commande_courante.setBounds(20, 100, 350, 20);
		date_envoi_commande_courante.setBounds(20, 140, 350, 20);
		quantite_commande_courante.setBounds(20, 180, 300, 20);
		id_distributeur_commande_courante.setBounds(20, 220, 300, 20);
		variete_produit_commande_courante.setBounds(20, 300, 300, 20);
		type_produit_commande_courante.setBounds(20, 340, 300, 20);
		calibre_produit_commande_courante.setBounds(20, 380, 300, 20);

		liste_commandes_page_commandes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				try
				{
					commande_courante = (Commande)new GestionCommandes(PagePrincipale.getSQL()).getPersistance().chargerBase(liste_commandes_page_commandes.getSelectedItem().toString(),"Commande");
					conditionnement_commande_courante.setText("Conditionnement: "+commande_courante.getConditionnement());
					date_conditionnement_commande_courante.setText("Date de conditionnement: "+commande_courante.getDateConditionnement());	
					date_envoi_commande_courante.setText("Date d'envoi: "+commande_courante.getDateEnvoi());		
					quantite_commande_courante.setText("Quantité: "+commande_courante.getQuantite());
					id_distributeur_commande_courante.setText("Distributeur associé: "+commande_courante.getIdDistributeur());
					variete_produit_commande_courante.setText("Variété: "+commande_courante.getProduit().getVariete());					
					type_produit_commande_courante.setText("Type: "+commande_courante.getProduit().getType());			
					calibre_produit_commande_courante.setText("Type: "+commande_courante.getProduit().getCalibre());
				}
				catch(Exception ex)
				{
					dispose();
					JOptionPane.showMessageDialog(null, "Impossible de charger l'objet correspondant.\n Essayez de relancer une fenêtre des commandes.\nSi l'erreur persiste, vérifiez votre connexion internet et relancez l'application","Gestion des commandes",JOptionPane.INFORMATION_MESSAGE);;
				}
			}
		});
		
		panel.add(id_commande);
		panel.add(liste_commandes_page_commandes);
		panel.add(conditionnement_commande_courante);
		panel.add(date_conditionnement_commande_courante);
		panel.add(date_envoi_commande_courante);
		panel.add(quantite_commande_courante);
		panel.add(id_distributeur_commande_courante);
		panel.add(variete_produit_commande_courante);
		panel.add(type_produit_commande_courante);
		panel.add(calibre_produit_commande_courante);
	}
	
}
