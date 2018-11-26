package fr.cible.core;

import java.awt.Color;

/**
 * Classe CibleRonde
 * @author BNadir
 */
public class CibleRonde extends Cible {     
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
	private int r = w/2;
	
	/**
	 * dessine un cercle
	 */
    //@Override
    public void dessine(){
        gp.setColor(Color.RED);
        gp.fillOval(posX,posY, w,  h);        
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
        int centreCercleX = posX + r;
        int centreCercleY = posY + r;
        int dX = xTir - centreCercleX;
        int dY = yTir - centreCercleY;
        if (dX * dX + dY * dY < r * r) return true;
        else return false;
    }
}
