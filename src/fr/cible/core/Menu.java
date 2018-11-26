package fr.cible.core;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel implements ActionListener
{   
	private static final long serialVersionUID = 1L;
	private int DELAI = 10;
    private JLabel lblTitre,message;
    private JButton btnDepart;
    private Ecran ecran;
    private ButtonGroup grpFormeCible;
    private JRadioButton rdbCibleCarree,rdbCibleRonde;
    private JTextField nbrTouche,compteurTemps;
    private Timer compteurSeconde;
    private Integer deCompte = new Integer(DELAI);
    private Cible cr,cc,objetCible = null;
    private Integer nbTotalTirs = new Integer(0);
    private boolean drap = false;

    /**
     *	Contructeur du Menu
     */
    public Menu(){
        setBackground(Color.red);
        setBounds(450,30,230,400);
        setLayout(null);

      //-----Composants bouton texte ---------
        lblTitre = new JLabel("Projet Cible");
        lblTitre.setBounds(10, 10, 90, 20);
        add(lblTitre);

        btnDepart = new JButton("Jouer");
        btnDepart.setBounds(10, 100, 100, 20);
        btnDepart.setEnabled(false);
        add(btnDepart);
        btnDepart.addActionListener(this);

        compteurTemps = new JTextField(deCompte.toString());
        compteurTemps.setBounds(10, 150,100, 30);
        add(compteurTemps);

        nbrTouche = new JTextField();
        nbrTouche.setBounds(10, 200,100, 30);
        add(nbrTouche);

        message = new JLabel();
        message.setBounds(10, 250,100, 30);
        message.setBackground(Color.red);
        add(message);

        //---------les radioBoutons ------------
        grpFormeCible = new ButtonGroup();
        rdbCibleCarree = new JRadioButton();
        rdbCibleRonde = new JRadioButton();

        grpFormeCible.add(rdbCibleCarree);
        rdbCibleCarree.setText("Cible carr�e");
        rdbCibleCarree.setBounds(10, 30, 100, 23);
        rdbCibleCarree.addActionListener(this);
        add(rdbCibleCarree);

        grpFormeCible.add(rdbCibleRonde);
        rdbCibleRonde.setText("Cible ronde");
        rdbCibleRonde.setBounds(120, 30, 100, 23);
        rdbCibleRonde.addActionListener(this);
        add(rdbCibleRonde);

        //-----un objet cible ronde ou carrée--------
        cr = new CibleRonde();
        cc = new CibleCarre();
        
        //---Temps restant D�compte par 1sec --------
        compteurSeconde = new Timer(1000,this);
        compteurSeconde.setActionCommand("deCompteur");
        compteurSeconde.addActionListener(this);

    }
    
    /**
    *  Ecoute les �v�nements composants
    * @param e
    */
   public void actionPerformed(ActionEvent e){
        String strCommand = e.getActionCommand().toString();

        //----------marche arret du jeu----------
        if(strCommand.compareTo("stopper") == 0){
            btnDepart.setText("Jouer");
            compteurSeconde.stop();
        }
        if(strCommand.compareTo("Jouer") == 0){
            nbrTouche.setText("0");
            btnDepart.setText("stopper");
            compteurSeconde.start();
        }

        //---------choix de la cible------------
        if(strCommand.compareTo("Cible carr�e") == 0){
            if(objetCible != null) objetCible.efface();
            cc.initDessine(ecran);
            objetCible = cc;
            nbTotalTirs = 0;
            ecran.initEcran(nbrTouche,objetCible,nbTotalTirs);
            btnDepart.setEnabled(true);
            
        }

        if(strCommand.compareTo("Cible ronde") == 0){
            if(objetCible != null )objetCible.efface();
            cr.initDessine(ecran);
            objetCible = cr;
            nbTotalTirs = 0;
            ecran.initEcran(nbrTouche,objetCible,nbTotalTirs);
            btnDepart.setEnabled(true);
        }

        //------------ d�comptage --------------
        if(strCommand.compareTo("deCompteur") == 0 ){
            if(drap){
                deCompte--;
                compteurTemps.setText(deCompte.toString());
                drap = false;
                if(deCompte < 1){
                    compteurSeconde.stop();
                    deCompte = DELAI;
                    compteurTemps.setText(deCompte.toString());
                    btnDepart.setText("Jouer");
                    message.setText("Termin�");
                }
            }
            else{
                drap = true;
                compteurSeconde.start();
            }
        }
    }

   /**
    * recup�ration de la r�ference de l'�cran
    * @param panneau
    */
   public void setPanneauEcran(Ecran  ecran){
       this.ecran = ecran;
   }
   /**
    * C�der la r�f�rence pour paint() et le Thread
    * @return
    */
   public Cible getReferenceObjetCible(){
	   return objetCible;
   }

   /**    
    * Etat du d�compteur pour le thread
    * @return
    */
   public boolean getDecompteurPoint(){
       return compteurSeconde.isRunning();
   }   
}