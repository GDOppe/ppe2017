package vdev;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
*
* Classe permettant l'affichage des distributeurs
* 
* @author Giaquinto Raphael Dubrulle Gaetan Ostrowski Benjamin
* @version 1.0
* 
*
*/
public class PageDistributeurs extends JFrame{
	
	private JComboBox<String> liste_distributeurs_page_distributeurs;
	private JComboBox<String> liste_commandes_page_distributeurs;
	private JLabel id_distributeur;
	private JLabel nom_distributeur;
	private JLabel commandes_associees;
	private JLabel conditionnement_commande_courante;
	private JLabel date_conditionnement_commande_courante;
	private JLabel date_envoi_commande_courante;
	private JLabel quantite_commande_courante;
	private JLabel variete_produit_commande_courante;
	private JLabel type_produit_commande_courante;
	private JLabel calibre_produit_commande_courante;
	private JPanel panel;	
	private BoutonXML bouton_xml;
	private Font police_distributeur;
	private Color couleur_police;	
	private static Distributeur distributeur_courant;

	/**
	 * 
	 * Création d'une fenêtre de 600x450 pour afficher les distributeurs en détails<br><br>
	 * Les id des distributeurs sont stockées dans une liste déroulante<br>
	 * Les id des commandes associés au distributeur courant, sont stockées dans une liste déroulante<br>
	 * Le reste des informations concernants les distributeurs et ses commandes sont représentées via des labels
	 * @throws Exception
	 * 
	 * */	
	public PageDistributeurs() throws Exception
	{			
		liste_distributeurs_page_distributeurs = new JComboBox<>();
		liste_commandes_page_distributeurs = new JComboBox<>();
		
		initPanel();		
		this.setTitle("Distributeurs enregistrés");
		this.setSize(600, 450);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(GestionRessources.getLogo());
		this.setContentPane(panel);		
		this.setVisible(true);
		
	}
	/**
	 * 
	 * Initialisation des composants swing sur la fenêtre<br><br>
	 * Initialisation de la liste des id des distributeurs, via la fonction chargeListeDistributeurs<br><br>
	 * Initialisation de la liste des commandes du distributeur courant via la fonction getCommandes et chargerBase<br>
	 * A chaque sélection d'id dans la liste des distributeurs, le distributeur courant change, et la liste des commandes est actualisée
	 * 
	 * @see PersistanceSQL
	 * @see Distributeur
	 * @throws Exception
	 * 
	 * 
	 * */
	private void initPanel() throws Exception
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
		
		this.liste_distributeurs_page_distributeurs = new GestionCommandes(PagePrincipale.getSQL()).getPersistance().chargerListeDistributeurs();
		distributeur_courant = (Distributeur)new GestionCommandes(PagePrincipale.getSQL()).getPersistance().chargerBase(liste_distributeurs_page_distributeurs.getSelectedItem().toString(),"Distributeur");
		
		for(Commande commande: distributeur_courant.getCommandes())
		{
			liste_commandes_page_distributeurs.addItem(commande.getId());
		}
		
		police_distributeur = new Font("Verdana",0,18);
		couleur_police = new Color(185, 236, 0);
		
		id_distributeur = new JLabel("Id:");
		id_distributeur.setFont(police_distributeur);
		id_distributeur.setForeground(couleur_police);
		
		nom_distributeur = new JLabel("Nom: "+distributeur_courant.getNom());
		nom_distributeur.setFont(police_distributeur);
		nom_distributeur.setForeground(couleur_police);
		
		commandes_associees = new JLabel("Commandes associées:");
		commandes_associees.setFont(police_distributeur);
		commandes_associees.setForeground(couleur_police);
		
		conditionnement_commande_courante = new JLabel("Conditionnement:");
		conditionnement_commande_courante.setFont(police_distributeur);
		conditionnement_commande_courante.setForeground(couleur_police);
		
		date_conditionnement_commande_courante = new JLabel("Date de conditionnement:");
		date_conditionnement_commande_courante.setFont(police_distributeur);
		date_conditionnement_commande_courante.setForeground(couleur_police);
		
		date_envoi_commande_courante = new JLabel("Date d'envoi:");
		date_envoi_commande_courante.setFont(police_distributeur);
		date_envoi_commande_courante.setForeground(couleur_police);
		
		quantite_commande_courante = new JLabel("Quantité:");
		quantite_commande_courante.setFont(police_distributeur);
		quantite_commande_courante.setForeground(couleur_police);
		
		
		variete_produit_commande_courante = new JLabel("Variété:");
		variete_produit_commande_courante.setFont(police_distributeur);
		variete_produit_commande_courante.setForeground(couleur_police);
		
		type_produit_commande_courante = new JLabel("Type:");
		type_produit_commande_courante.setFont(police_distributeur);
		type_produit_commande_courante.setForeground(couleur_police);
		
		calibre_produit_commande_courante = new JLabel("Calibre:");
		calibre_produit_commande_courante.setFont(police_distributeur);
		calibre_produit_commande_courante.setForeground(couleur_police);
		
		bouton_xml = new BoutonXML();
		bouton_xml.setBounds(500, 20, 64, 64);
		bouton_xml.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				bouton_xml.bouttonClique();
				try
				{
					GestionCommandes.XMLCommande(PageDistributeurs.getDistributeurCourant());	
				}
				catch(Exception ex)
				{
					dispose();
					JOptionPane.showMessageDialog(null, "Impossible d'éditer le distributeur ["+PageDistributeurs.getDistributeurCourant().getId()+"] .","Gestion des commandes",JOptionPane.ERROR_MESSAGE);
				}
				bouton_xml.bouttonNormal();
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
						
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		
		id_distributeur.setBounds(20,20,200,20);
		liste_distributeurs_page_distributeurs.setBounds(60, 20, 150, 20);
		nom_distributeur.setBounds(230,20,200,20);
		
		commandes_associees.setBounds(20,60,250,20);
		liste_commandes_page_distributeurs.setBounds(250, 60, 150, 20);
		
		conditionnement_commande_courante.setBounds(20, 100, 250, 20);
		date_conditionnement_commande_courante.setBounds(20, 140, 350, 20);
		date_envoi_commande_courante.setBounds(20, 180, 250, 20);
		quantite_commande_courante.setBounds(20, 220, 250, 20);
		variete_produit_commande_courante.setBounds(20,300,250,20);
		type_produit_commande_courante.setBounds(20,340,250,20);
		calibre_produit_commande_courante.setBounds(20,380,250,20);		
		
		initialiserListeCommandes();

		liste_distributeurs_page_distributeurs.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(liste_commandes_page_distributeurs.getItemCount()>0)
					{
						liste_commandes_page_distributeurs.removeAllItems();
					}
					distributeur_courant = (Distributeur)new GestionCommandes(PagePrincipale.getSQL()).getPersistance().chargerBase(liste_distributeurs_page_distributeurs.getSelectedItem().toString(),"Distributeur");
					nom_distributeur.setText("Nom: "+distributeur_courant.getNom());
					for(Commande commande: distributeur_courant.getCommandes())
					{
						liste_commandes_page_distributeurs.addItem(commande.getId());
					}
				}
				catch(Exception ex)
				{
					dispose();
					JOptionPane.showMessageDialog(null, "Impossible de charger l'objet correspondant.\n Essayez de relancer une fenêtre des distributeurs.\nSi l'erreur persiste, vérifiez votre connexion internet et relancez l'application","Gestion des commandes",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		liste_commandes_page_distributeurs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					initialiserListeCommandes();
				} 
				catch (Exception ex) {
					dispose();
					JOptionPane.showMessageDialog(null, "Impossible de charger l'objet correspondant.\n Essayez de relancer une fenêtre des distributeurs.\nSi l'erreur persiste, vérifiez votre connexion internet et relancez l'application","Gestion des commandes",JOptionPane.INFORMATION_MESSAGE);
				}			
			}
		});
		
		
		panel.add(liste_distributeurs_page_distributeurs);
		panel.add(liste_commandes_page_distributeurs);
		panel.add(id_distributeur);
		panel.add(nom_distributeur);
		panel.add(commandes_associees);
		panel.add(conditionnement_commande_courante);
		panel.add(date_conditionnement_commande_courante);
		panel.add(date_envoi_commande_courante);
		panel.add(quantite_commande_courante);
		panel.add(variete_produit_commande_courante);
		panel.add(type_produit_commande_courante);
		panel.add(calibre_produit_commande_courante);
		panel.add(bouton_xml);
		
	}
	private void initialiserListeCommandes()
	{
		for(Commande commande: distributeur_courant.getCommandes())
		{
			if(liste_commandes_page_distributeurs.getItemCount()>0)
			{
				if(commande.getId().equals(liste_commandes_page_distributeurs.getSelectedItem().toString()))
				{
					conditionnement_commande_courante.setText("Conditionnement: "+commande.getConditionnement());
					date_conditionnement_commande_courante.setText("Date de conditionnement: "+commande.getDateConditionnement());
					date_envoi_commande_courante.setText("Date d'envoi: "+commande.getDateEnvoi());
					quantite_commande_courante.setText("Quantité: "+commande.getQuantite());
					variete_produit_commande_courante.setText("Variété: "+commande.getProduit().getVariete());
					type_produit_commande_courante.setText("Type: "+commande.getProduit().getType());
					calibre_produit_commande_courante.setText("Calibre: "+commande.getProduit().getCalibre());

				}
			}
		}
	}
	public static Distributeur getDistributeurCourant()
	{
		return distributeur_courant;
	}
}
