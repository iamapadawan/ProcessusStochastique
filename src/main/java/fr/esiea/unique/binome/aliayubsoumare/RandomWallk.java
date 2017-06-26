package fr.esiea.unique.binome.aliayubsoumare;

import java.util.Random;

public class RandomWallk {

    private ComputerNetwork reseauxComputers;

    public RandomWallk(ComputerNetwork pComputerNetwork) {
        this.reseauxComputers = pComputerNetwork;
    }

    public void genererMarche(Computer Computer) {
        Random random = new Random();
        int nombre = random.nextInt(11);

        // As long as the number drawn is equal to 5, we choose another random number
        while (nombre == 5)
            nombre = random.nextInt(11);

        if (nombre < 5) {
            if (Computer.HasVirus()) {
                Computer.setVirus(null);
                Computer.getLinkPrevious().setVirus(new Virus());
            }
            if (Computer.aLAntivirus()) {
                Computer.setAntivirus(null);
                Computer.getLinkPrevious().setAntivirus(new Antivirus());
            }
        } else {
            if (Computer.HasVirus()) {
                Computer.setVirus(null);
                Computer.getLinkNext().setVirus(new Virus());
            }
            if (Computer.aLAntivirus()) {
                Computer.setAntivirus(null);
                Computer.getLinkNext().setAntivirus(new Antivirus());
            }
        }
    }

    // Function that displays the status of the system
    public void parcoursListeDoubleChainee() {
        /* These variables will be used to not re-run the viral / antiviral load as well as the random walk */
        boolean chargeViraleExecuteeOuNon = false;
        boolean chargeAntivraleExecuteeOuNon = false;

        Computer Computer = this.reseauxComputers.getStart();
        if (this.reseauxComputers.getTaille() == 0) {
            System.out.print("Random Walk impossible : no machine\n");
            return;
        }
        if (this.reseauxComputers.getStart().getLinkNext() == this.reseauxComputers.getStart()) {
            System.out.print("Random Walk impossible : Only one machine\n");
            return;
        }

        // ANTIVIRUS
        if (Computer.aLAntivirus()) {
            if (!chargeAntivraleExecuteeOuNon) {
                if (Computer.getAntivirus().chargeAntiviraleSucces()) {
                    Computer.setInfecte(false);
                }
                chargeAntivraleExecuteeOuNon = true;
                genererMarche(Computer);
            }
        }

        // VIRUS
        if (Computer.HasVirus()) {
            if (!chargeViraleExecuteeOuNon) {
                if (Computer.getVirus().chargeViraleSucces()) {
                    Computer.setInfecte(true);
                }
                chargeViraleExecuteeOuNon = true;
                genererMarche(Computer);
            }
        }

        Computer = this.reseauxComputers.getStart().getLinkNext();
        while (Computer.getLinkNext() != this.reseauxComputers.getStart()) // On check le voisin suivant
        {

            // ANTIVIRUS
            if (Computer.aLAntivirus()) {
                if (!chargeAntivraleExecuteeOuNon) {
                    if (Computer.getAntivirus().chargeAntiviraleSucces()) {
                        Computer.setInfecte(false);
                    }
                    chargeAntivraleExecuteeOuNon = true;
                    genererMarche(Computer);
                }
            }

            // VIRUS
            if (Computer.HasVirus()) {
                if (!chargeViraleExecuteeOuNon) {
                    if (Computer.getVirus().chargeViraleSucces()) {
                        Computer.setInfecte(true);
                    }
                    chargeViraleExecuteeOuNon = true;
                    genererMarche(Computer);
                }
            }

            // Ordnateur suivant
            Computer = Computer.getLinkNext();
        }

        // ANTIVIRUS
        if (Computer.aLAntivirus()) {
            if (!chargeAntivraleExecuteeOuNon) {
                if (Computer.getAntivirus().chargeAntiviraleSucces()) {
                    Computer.setInfecte(false);
                }
                chargeAntivraleExecuteeOuNon = true;
                genererMarche(Computer);
            }
        }

        // VIRUS
        if (Computer.HasVirus()) {
            if (!chargeViraleExecuteeOuNon) {
                if (Computer.getVirus().chargeViraleSucces()) {
                    Computer.setInfecte(true);
                }
                chargeViraleExecuteeOuNon = true;
                genererMarche(Computer);
            }
        }

    }
}