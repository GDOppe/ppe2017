import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonProduits extends JButton {

	public BoutonProduits()
	{
		setIcon(new ImageIcon(GestionRessources.getProduitsBouton()));
		addMouseListener(new GestionClique());
		setBorder(null);
	}
	public void bouttonClique()
	{
		setIcon(new ImageIcon(GestionRessources.getProduitsBoutonHover()));
	}
	public void bouttonNormal()
	{
		setIcon(new ImageIcon(GestionRessources.getProduitsBouton()));
	}
}
