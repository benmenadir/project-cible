package fr.cible.core;

import java.awt.Graphics;
import javax.swing.JPanel;


/**
 * Classe Abstraite Cible
 * @author BNadir
 */
public abstract class Cible extends JPanel {
    
	private static final long serialVersionUID = 1L;
	protected int posX,posY;
    protected int w = 50;
    protected int h = 50;
    protected int largeurPanel;
    protected int hauteurPanel;
    protected static Graphics gp;
    private double sensX = 1;
    private double sensY = 2.5;
   
    /**
     * Positionne le dessin
     * @param p transf�re de la r�f�rence JPanel
     */
    public void initDessine(JPanel p){
        hauteurPanel = p.getHeight();
        largeurPanel = p.getWidth();
        gp = p.getGraphics();
        dessine();
    }

    /**
     * Donne le mouvement au dessin
     */
    public void bouge(){
        efface();
        posX += sensX;
        posY += sensY;
        if(posX <= 0 || posX >= largeurPanel - w)  sensX = -sensX;
        if(posY <= 0 || posY >= hauteurPanel - w)  sensY = -sensY;
        dessine();
    }     
    
    /**
     * d�finition des classes abstraites
     */
    public abstract void dessine();
    public abstract void efface();
    public abstract boolean estDansLaCible(int x, int y);    
}
