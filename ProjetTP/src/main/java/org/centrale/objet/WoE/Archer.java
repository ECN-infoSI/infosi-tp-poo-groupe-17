package org.centrale.objet.WoE;

/**
 * Classe archer : personnage disposant de flèches
 *
 * @author Ulysse
 */
public class Archer extends Personnage implements Combatif {

    private int nbFleches;

    /**
     * Initialise un archer
     *
     * @param n nom
     * @param pV points de vie
     * @param dA distance d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussir une attaque
     * @param paPar probabilité de réussir une parade
     * @param dMax distance d'attaque maximale
     * @param p position (Point2D)
     * @param nbFl nombre de flèches
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFl) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.nbFleches = nbFl;
    }

    /**
     * Crée un archer identique à l'archer a
     *
     * @param a Archer à copier
     */
    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.getNbFleches();
    }

    /**
     * Génère un archer aléatoire
     */
    public Archer() {
        super();
        this.nbFleches = getRandom(17);
    }

    /**
     *
     * @return nombre de flèches
     */
    public int getNbFleches() {
        return this.nbFleches;
    }

    /**
     * Modifie le nombre de flèches d'un archer
     *
     * @param nbFleches nombre de fleches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Affiche des informations sur l'archer
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.print(this.getNom() + " maîtrise l'archerie et a " + getNbFleches() + " flèches.\n");
    }

    /**
     * Combattre une créature désignée
     *
     * @param c
     */
    @Override
    public void combattre(Creature c) {
        String msg = new String();
        if (this.distance(c) <= 1) {
            int pAtt = this.getDegAtt();
            Epee arme = this.getArme();
            
            if (arme != null) {
                pAtt += (int) (100-pAtt)*arme.getPageAtt();
            }
            
            if (this.lanceDe(pAtt)) {
                int dAtt = this.getDegAtt();
                
                if (arme != null) {
                    dAtt *= (5+arme.getDegAtt())/10.;
                }
                
                int pPar = c.getPagePar();
                boolean cIsPerso = c instanceof Personnage;
                if (cIsPerso) {
                    Epee cArme = ((Personnage) c).getArme();
                    if (cArme != null) {
                        pPar += (int) (100-pAtt)*this.getArme().getPagePar();
                    }
                }
                
                if (c.lanceDe(pPar)) {
                    int dPar = c.getPtPar();
                    if (cIsPerso) {
                        Epee cArme = ((Personnage) c).getArme();
                        if (cArme != null) {
                            dPar *= (5+cArme.getPtPar())/10.;
                        }
                    }
                    
                    msg = "Touché mais bloqué";
                    
                }
            }
        }
    }
}
