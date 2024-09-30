package org.centrale.objet.WoE;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Ulysse
 */
public class World {

    LinkedList<Creature> creatures;
    LinkedList<Objet> objets;
    Random seed;
    boolean[][] grille;
    int taille;

    /**
     * Monde avec personnages par défaut
     */
    public World() {
        this.creatures = new LinkedList<>();
        this.objets = new LinkedList<>();
        this.seed = new Random();
    }

    /**
     * Création d'un monde aléatoire
     *
     * @param taille Taille du monde
     */
    public void creeMondeAlea(int taille) {
        this.taille = taille;
        int x;
        int y;
        boolean pris;
        this.grille = new boolean[taille][taille];
        for (int i=0;i<100000;i++){
        creatures.add(new Archer());
        }
        Iterator<Creature> CreaIt1 = this.creatures.iterator();
        Iterator<Creature> CreaIt2;
        Creature c1;
        Creature c2;
        while (CreaIt1.hasNext()) {
            c1 = CreaIt1.next();
            x = 0;
            y = 0;
            pris = true;

            while (pris) {
                x = this.seed.nextInt(this.taille);
                y = this.seed.nextInt(this.taille);
                pris = this.grille[x][y];
            }
            c1.setPos(x, y);
            this.grille[x][y] = true;
            //c1.affiche();
        }

        Iterator<Objet> ObjIt1 = this.objets.iterator();
        Iterator<Objet> ObjIt2;
        Objet o1;
        Objet o2;
        while (ObjIt1.hasNext()) {
            o1 = ObjIt1.next();
            x = 0;
            y = 0;
            pris = true;

            while (pris) {
                pris = false;
                x = this.seed.nextInt(taille);
                y = this.seed.nextInt(taille);
                ObjIt2 = this.objets.iterator();
                o2 = ObjIt2.next();
                while (o2 != o1 && !pris) {
                    if (o2.getX() == x && o2.getY() == y) {
                        pris = true;
                    }
                    o2 = ObjIt2.next();
                }

                CreaIt2 = this.creatures.iterator();
                while (CreaIt2.hasNext() && !pris) {
                    c2 = CreaIt2.next();
                    if (c2.getX() == x && c2.getY() == y) {
                        pris = true;
                    }
                }
            }
            o1.setPos(x, y);
            // o1.affiche(); TODO
        }

    }

    /**
     * Gestion d'un tour de jeu : on affiche le nom ou le type de la créature
     * qui joue, la déplace puis l'affiche.
     */
    public void tourDeJeu() {
        cleanEntites(creatures);
        cleanEntites(objets);
        for (Creature creature : creatures) {
            System.out.println("C'est au tour de " + creature + " de jouer.");
            creature.deplace();
            creature.affiche();
        }
        System.out.println("Fin du tour de jeu");
    }

    /**
     * Affichage du monde
     */
    public void afficheWorld() {

    }

    /**
     * Retire les objets utilisés (sans position)
     *
     * @param Liste
     */
    public void cleanEntites(LinkedList Liste) {
        Iterator<Entite> listIt = Liste.iterator();

        while (listIt.hasNext()) {
            Entite p = listIt.next();
            if (p.getPos() == null) {
                listIt.remove();
            }
        }
    }
}
