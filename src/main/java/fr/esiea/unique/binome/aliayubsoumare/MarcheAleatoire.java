package fr.esiea.unique.binome.aliayubsoumare;

import java.util.Random;

public class MarcheAleatoire {

    private ReseauOrdinateurs reseauxOrdinateurs;

    public MarcheAleatoire(ReseauOrdinateurs pReseauOrdinateurs) {
        this.reseauxOrdinateurs = pReseauOrdinateurs;
    }

    public void genererMarche(Ordinateur ordinateur) {
        Random random = new Random();
        int nombre = random.nextInt(11);

        // Tant que le nombre tiré est égal à 5, on tire de nouveau un autre nombre aléatoire
        while (nombre == 5)
            nombre = random.nextInt(11);

        if (nombre < 5) {
            if (ordinateur.aLeVirus()) {
                ordinateur.setVirus(null);
                ordinateur.getLinkPrevious().setVirus(new Virus());
            }
            if (ordinateur.aLAntivirus()) {
                ordinateur.setAntivirus(null);
                ordinateur.getLinkPrevious().setAntivirus(new Antivirus());
            }
        } else {
            if (ordinateur.aLeVirus()) {
                ordinateur.setVirus(null);
                ordinateur.getLinkNext().setVirus(new Virus());
            }
            if (ordinateur.aLAntivirus()) {
                ordinateur.setAntivirus(null);
                ordinateur.getLinkNext().setAntivirus(new Antivirus());
            }
        }
    }

    // Fonction qui affiche l'état du système
    public void parcoursListeDoubleChainee() {
        /* Ces variables serviront à ne pas ré-exécuter la charge virale / antivirale ainsi que la marche aléatoire */
        boolean chargeViraleExecuteeOuNon = false;
        boolean chargeAntivraleExecuteeOuNon = false;

        Ordinateur ordinateur = this.reseauxOrdinateurs.getStart();
        if (this.reseauxOrdinateurs.getTaille() == 0) {
            System.out.print("Marche aléatoire impossible : aucune machine\n");
            return;
        }
        if (this.reseauxOrdinateurs.getStart().getLinkNext() == this.reseauxOrdinateurs.getStart()) {
            System.out.print("Marche aléatoire impossible : 1 seule machine\n");
            return;
        }

        // ANTIVIRUS
        if (ordinateur.aLAntivirus()) {
            if (!chargeAntivraleExecuteeOuNon) {
                if (ordinateur.getAntivirus().chargeAntiviraleSucces()) {
                    ordinateur.setInfecte(false);
                }
                chargeAntivraleExecuteeOuNon = true;
                genererMarche(ordinateur);
            }
        }

        // VIRUS
        if (ordinateur.aLeVirus()) {
            if (!chargeViraleExecuteeOuNon) {
                if (ordinateur.getVirus().chargeViraleSucces()) {
                    ordinateur.setInfecte(true);
                }
                chargeViraleExecuteeOuNon = true;
                genererMarche(ordinateur);
            }
        }

        ordinateur = this.reseauxOrdinateurs.getStart().getLinkNext();
        while (ordinateur.getLinkNext() != this.reseauxOrdinateurs.getStart()) // On check le voisin suivant
        {

            // ANTIVIRUS
            if (ordinateur.aLAntivirus()) {
                if (!chargeAntivraleExecuteeOuNon) {
                    if (ordinateur.getAntivirus().chargeAntiviraleSucces()) {
                        ordinateur.setInfecte(false);
                    }
                    chargeAntivraleExecuteeOuNon = true;
                    genererMarche(ordinateur);
                }
            }

            // VIRUS
            if (ordinateur.aLeVirus()) {
                if (!chargeViraleExecuteeOuNon) {
                    if (ordinateur.getVirus().chargeViraleSucces()) {
                        ordinateur.setInfecte(true);
                    }
                    chargeViraleExecuteeOuNon = true;
                    genererMarche(ordinateur);
                }
            }

            // Ordnateur suivant
            ordinateur = ordinateur.getLinkNext();
        }

        // ANTIVIRUS
        if (ordinateur.aLAntivirus()) {
            if (!chargeAntivraleExecuteeOuNon) {
                if (ordinateur.getAntivirus().chargeAntiviraleSucces()) {
                    ordinateur.setInfecte(false);
                }
                chargeAntivraleExecuteeOuNon = true;
                genererMarche(ordinateur);
            }
        }

        // VIRUS
        if (ordinateur.aLeVirus()) {
            if (!chargeViraleExecuteeOuNon) {
                if (ordinateur.getVirus().chargeViraleSucces()) {
                    ordinateur.setInfecte(true);
                }
                chargeViraleExecuteeOuNon = true;
                genererMarche(ordinateur);
            }
        }

        // ordinateur = ordinateur.getLinkNext();
        // System.out.print(ordinateur + "\n");
    }
}