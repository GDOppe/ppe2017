import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonXML extends JButton{
	
	public BoutonXML()
	{
		setIcon(new ImageIcon(GestionRessources.getGenererXML()));
		setBorder(null);
	}
	public void bouttonClique()
	{
		setIcon(new ImageIcon(GestionRessources.getGenererXMLHover()));
	}
	public void bouttonNormal()
	{
		setIcon(new ImageIcon(GestionRessources.getGenererXML()));
	}
}
