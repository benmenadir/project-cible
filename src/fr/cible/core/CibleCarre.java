package fr.cible.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Classe CibleCarre
 * @author BNadir
 */
public class CibleCarre  extends Cible {
    
	private static final long serialVersionUID = 1L;

	/**
	 * Utilise le double bufferring
	 */
	//@Override
    public void dessine(){
    	Image offScreen = new BufferedImage(400,400,BufferedImage.TYPE_INT_RGB); 
    	Graphics gOff = offScreen.getGraphics();
    	gOff.setColor(Color.yellow);
    	gOff.fillRect(0,0, 400,  400);
    	gOff.setColor(Color.BLUE);
    	gOff.fillRect(posX,posY, w,  h);
    	gp.drawImage(offScreen,0,0,this);    	
    }

    /**
     * gomme le dessin
     */	
    //@Override
    public void efface(){
        gp.setColor(Color.YELLOW);
        gp.fillRect(posX,posY, w,  h);
    }    

    /**
     * m�thode indiquant si le click est dans
     * le dessin
     * @param xTir
     * @param yTir
     * @return
     */
    //@Override
    public boolean estDansLaCible(int xTir, int yTir) {
        if(xTir > posX  &&  xTir < posX + w && yTir > posY  &&  yTir < posY + w)
             return true;
        else return false;
    }	    
}
