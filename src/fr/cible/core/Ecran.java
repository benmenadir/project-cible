package fr.cible.core;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author BNadir
 */
public class Ecran extends JPanel{
    
	private static final long serialVersionUID = 1L;
	private Cible objetCible;
    private JTextField nbrTouche;
    private Integer nbTotalTirs = new Integer(0);

    /**
     * Constructeur de l'�cran
     * associ� avec un �v�nement souris
     */
    public Ecran(){
         //---------le panneau graphique---------
        setBounds(20, 30, 400, 400);
        setBackground(Color.YELLOW);
        addMouseListener(new MouseListener(){
        	public void mousePressed(MouseEvent e) {
                int xSouris = e.getX();
                int ySouris = e.getY();

                if(objetCible.estDansLaCible(xSouris,ySouris)){
                    nbTotalTirs++;
                    nbrTouche.setText(nbTotalTirs.toString());
                }
                System.out.println(xSouris + "   " + ySouris);
            }
        	public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e)  {}
            public void mouseClicked(MouseEvent e) {}
            public void mouseReleased(MouseEvent e){}
        });
    }

    /**
     *
     * @param nbrTouche
     * @param objetCible
     * @param nbTotalTirs
     */
    public void initEcran(JTextField nbrTouche,Cible objetCible, int nbTotalTirs){
        this.nbrTouche = nbrTouche;
        this.objetCible = objetCible;
    }    
}