package fr.esiea.unique.binome.aliayubsoumare;

public class ComputeurNetwork {

    protected Computer start;
    protected Computer end;
    public int taille;
    public boolean aUnVirus;
    public boolean aUnAntivirus;

    public ComputeurNetwork() {
        start = null;
        end = null;
        aUnAntivirus = false;
        aUnVirus = false;
        taille = 0;
    }

    // Function that verify if the network is empty
    public boolean isEmpty() {
        return start == null;
    }

    // Function that returns the size of the computers network
    public int getTaille() {
        return taille;
    }

    // Function that add a computer at the beginning
    public void insertAtStart(Computer Computer) {
        // Computer Computer = new Computer(null, null);
        if (start == null) // Si le réseau est vide
        {
            Computer.setLinkNext(Computer);
            Computer.setLinkPrev(Computer);
            start = Computer;
            end = start;
        } else // If a computer is already present in the network
        {
            Computer.setLinkPrev(end);
            end.setLinkNext(Computer);
            start.setLinkPrev(Computer);
            Computer.setLinkNext(start);
            start = Computer; // The computer is placed at the beginning
        }
        taille++;
    }

    // Function that add a computer in the end
    public void insertAtEnd(Computer Computer) {
        // Computer Computer = new Computer(null, null);
        if (start == null) {
            Computer.setLinkNext(Computer);
            Computer.setLinkPrev(Computer);
            start = Computer;
            end = start;
        } else {
            Computer.setLinkPrev(end);
            end.setLinkNext(Computer);
            start.setLinkPrev(Computer);
            Computer.setLinkNext(start);
            end = Computer; // The computer is placed at the end
        }
        taille++;
    }

    // Function that add a computer in the network
    public void insertAtPosition(Computer Computer, int position) {
        // Computer Computer = new Computer(null, null);
        if (position == 1) {
            insertAtStart(Computer);
            return;
        }
        Computer Computer2 = start;
        for (int i = 2; i <= taille; i++) {
            if (i == position) {
                Computer tmp = Computer2.getLinkNext();
                Computer2.setLinkNext(Computer);
                Computer.setLinkPrev(Computer2);
                Computer.setLinkNext(tmp);
                tmp.setLinkPrev(Computer);
            }
            Computer2 = Computer2.getLinkNext();
        }
        taille++;
    }

    // Function that delete a computer in the network
    public void supprimerPCPosition(int position) {
        if (position == 1) // if deleted computer is at the start
        {
            if (taille == 1) {
                start = null;
                end = null;
                taille = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(end);
            end.setLinkNext(start);
            taille--;
            return;
        }
        if (position == taille) // If deleted computer is at the end
        {
            end = end.getLinkPrevious();
            end.setLinkNext(start);
            start.setLinkPrev(end);
            taille--;
        }

        Computer Computer = start.getLinkNext();
        for (int i = 2; i <= taille; i++) {
            if (i == position) {
                Computer p = Computer.getLinkPrevious();
                Computer n = Computer.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                taille--;
                return;
            }
            Computer = Computer.getLinkNext();
        }
    }

    // Function that show the state of the system
    public void affchageReseau() {
        System.out.print("\nComputers Network Infected/Uninfected\n");
        Computer Computer = start;
        if (taille == 0) {
            System.out.print("Empty\n");
            return;
        }
        if (start.getLinkNext() == start) {
            System.out.print(start + " <-> " + Computer + "\n");
            return;
        }

        System.out.print(start + " <-> ");
        Computer = start.getLinkNext();
        while (Computer.getLinkNext() != start) {
            System.out.print(Computer + " <-> ");
            Computer = Computer.getLinkNext();
        }
        System.out.print(Computer + " <-> ");
        Computer = Computer.getLinkNext();
        System.out.print(Computer + "\n");
    }

    /* ACCESSORS */
    public boolean getAUnVirus() {
        return aUnVirus;
    }

    public void setAUnVirus(boolean aUnVirus) {
        this.aUnVirus = aUnVirus;
    }

    public boolean getAUnAntivirus() {
        return aUnAntivirus;
    }

    public void setAUnAntivirus(boolean aUnAntivirus) {
        this.aUnAntivirus = aUnAntivirus;
    }

    public Computer getStart() {
        return start;
    }

    public Computer getEnd() {
        return end;
    }
}