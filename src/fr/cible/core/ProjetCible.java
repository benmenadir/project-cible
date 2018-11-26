package fr.cible.core;

import java.awt.Container;
import java.awt.Graphics;

import javax.swing.*;

/**
 * Projet Tir sur Cible
 * @version 01
 * @date 06/10/10
 * @author BNadir
 */
public class ProjetCible  extends JFrame
{    
	private static final long serialVersionUID = 1L;
	private int VITESSE = 10;
    private Menu menu;
    private Ecran panneauEcran ;

    /**
     * Class ProjetCible
     */
    public ProjetCible()    
    {    	
        //--------dans un conteneur------------------
        Container c = getContentPane();
        c.setLayout(null);

        //--------deux panneaux Menu et Ecran--------        
        panneauEcran = new Ecran();
        c.add(panneauEcran);
        menu = new Menu();
        menu.setPanneauEcran(panneauEcran);
        c.add(menu);
        //----passage en parametre de la reference panneauEcran
        
        
        setTitle("Projet Cible");
        setSize(700, 500);
        setVisible(true);

        //----un Thread pour le mouvement de la cible-------
        new Thread(new Runnable(){
			//@Override
			public void run() {
				 while(true){   
			            if(menu.getDecompteurPoint())menu.getReferenceObjetCible().bouge();
			            try   {Thread.sleep(VITESSE);}
			            catch(InterruptedException ee){}        
			       }				
			}
        	
        }).start();
        
    }     
    
    /**
     * pour le rafraichissement de la cible
     * lors d'un �venement de la JFrame
     * Repeindre tous les composants
     */
    //@Override
    public void paint(Graphics g){
 	  super.paintComponents(g);
 	   if(menu.getReferenceObjetCible() != null)
 		   menu.getReferenceObjetCible().dessine();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ProjetCible();
    }    
}
