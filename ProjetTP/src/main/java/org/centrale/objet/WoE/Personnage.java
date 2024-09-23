package org.centrale.objet.WoE;

/**
 *
 * @author Ulysse
 */
public class Personnage extends Creature {

    private String nom;
    private int distAttMax;
    private final static String[] noms = new String[]{"Alphonse", "Clovis", "Aude", "Hubert", "Bertille", "Paulin", "Rainier", "Isaure", "Enguerrand", "Neven"};
    private Objet arme;

    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param pt
     */
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D pt) {
        super(pV, dA, pPar, paAtt, paPar, pt);
        this.nom = n;
        this.distAttMax = dMax;
    }

    /**
     *
     * @param p
     */
    public Personnage(Personnage p) {
        super(p);
        this.nom = p.getNom();
        this.distAttMax = p.getDistAttMax();
    }

    /**
     * Initialise un personnage aléatoire
     */
    public Personnage() {
        super();
        this.nom = noms[getRandom(9)];
        this.distAttMax = getRandom(8);
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return this.nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return distance maximale d'attaque
     */
    public int getDistAttMax() {
        return this.distAttMax;
    }

    /**
     * Définit la distance d'attaque maximale
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     *
     * Déplace le personnage de manière déterminée.
     *
     * @param dx
     * @param dy
     */
    public void deplace(int dx, int dy) {
        this.pos.translate(dx, dy);
    }

    /**
     * Affiche le nom
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.print("Il s'agit de " + nom + ". ");
    }

    public Objet getArme() {
        return arme;
    }

    public void setArme(Objet arme) {
        this.arme = arme;
    }

}
