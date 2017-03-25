import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonConnexion extends JButton{
	
	public BoutonConnexion()
	{
		setIcon(new ImageIcon(GestionRessources.getConnexionBouton()));
		addMouseListener(new GestionClique());
		setBorder(null);
	}
	public void bouttonClique()
	{
		setIcon(new ImageIcon(GestionRessources.getConnexionBoutonHover()));
	}
	public void bouttonNormal()
	{
		setIcon(new ImageIcon(GestionRessources.getConnexionBouton()));
	}
}
