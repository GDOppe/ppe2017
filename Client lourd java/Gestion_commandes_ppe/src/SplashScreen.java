import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class SplashScreen extends JFrame{
	
	private String progressionChargement = "";
	private int secondesChargement = 0;
	private static boolean enChargement = true;
	public SplashScreen()
	{
            setSize(600, 300);
            setLocationRelativeTo(null);
            setResizable(false);
            setUndecorated(true);
            setResizable(false);
            setContentPane(new JPanel()
            {
                @Override
                public void paintComponent(Graphics g)
                {
                    g.setColor(new Color(48, 48, 48));
                    g.fillRect(0, 0, this.getWidth(), this.getHeight());
                    g.setFont(new Font("Verdana",0,35));
                    g.setColor(new Color(112, 141, 35));
                    g.drawString("Agrur - Gestion de commandes", 25, 50);
                    g.setFont(new Font("Verdana",0,15));
                    g.setColor(new Color(186, 186, 186));
                    g.drawString("Chargement en cours "+progressionChargement, 25, 100);
                    g.setFont(new Font("Verdana",0,15));
                    g.setColor(new Color(186, 186, 186));
                    g.drawString("Version 1.0", 500, 250);
                    g.setFont(new Font("Verdana",0,10));
                    g.setColor(new Color(158, 158, 158));
                    g.drawString("Développé par Giaquinto R, Ostrowski B, Dubrulle G", 25, 250);
                }
            });
            setVisible(true);	
            initTimer();
	}
	public void initTimer()
	{
            Timer time = new Timer();
            TimerTask task = new TimerTask()
            {
            	@Override
		public void run()
		{
                    if(enChargement)
                    {
                        if(progressionChargement.length()<3)
			{
                            progressionChargement +=".";				
			}
			else
			{
                            progressionChargement ="";
			}	
                        secondesChargement ++;
                        System.out.println("Elapsed time: "+secondesChargement +" s");
                        getContentPane().repaint();	                                     
                    }
                    else
                    {
			this.cancel();
                    }
		}
            };
            time.scheduleAtFixedRate(task, 0, 1000);
	}
        public void animationTimer()
        {
            Timer time = new Timer();
            TimerTask task = new TimerTask()
            {
                @Override
                public void run()
                {
                    
                }
            };
        }
	public static void finirChargement()
	{
            enChargement = false;
	}
	
	
}
