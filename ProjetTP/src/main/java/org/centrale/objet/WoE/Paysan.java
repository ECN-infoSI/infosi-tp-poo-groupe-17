/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Ulysse
 */
public class Paysan extends Personnage {

    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    public Paysan(Personnage p) {
        super(p);
    }

    public Paysan() {
    }
    @Override
    public void affiche() {
        super.affiche();
        System.out.print(this.getNom()+" travaille dans sa ferme.");
    }
}
