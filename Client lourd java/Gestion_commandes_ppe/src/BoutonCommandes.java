import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonCommandes extends JButton {

	public BoutonCommandes()
	{
		setIcon(new ImageIcon(GestionRessources.getCommandesBouton()));
		addMouseListener(new GestionClique());
		setBorder(null);
	}
	public void bouttonClique()
	{
		setIcon(new ImageIcon(GestionRessources.getCommandesBoutonHover()));
	}
	public void bouttonNormal()
	{
		setIcon(new ImageIcon(GestionRessources.getCommandesBouton()));
	}
}
