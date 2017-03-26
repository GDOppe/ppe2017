import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonDistributeur extends JButton{

	public BoutonDistributeur()
	{
		setIcon(new ImageIcon(GestionRessources.getDistributeursBouton()));
		setBorder(null);
	}
	public void bouttonClique()
	{
		setIcon(new ImageIcon(GestionRessources.getDistributeursBoutonHover()));
	}
	public void bouttonNormal()
	{
		setIcon(new ImageIcon(GestionRessources.getDistributeursBouton()));
	}
}
