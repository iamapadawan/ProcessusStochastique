/*
 * Creation : 25 juin 2017
 */
package fr.esiea.unique.binome.aliayubsoumare;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Cluster computeurs
        ComputerNetwork ComputerNetwork = new ComputerNetwork();
        RandomWallk RandomWallk = new RandomWallk(ComputerNetwork);
        System.out.println("Computer Networks, Circular Topology\n");
        char ch;

        do {
            System.out.println("\nComputer Networks, Circular Topology - List Operations\n");
            System.out.println("1. Computer insertion at the beginning\n");
            System.out.println("2. Computer insertion at the end");
            System.out.println("3. Computer insertion at a position");
            System.out.println("4. Computer insertion with Antivirus at the beginning");
            System.out.println("5. Computer insertion with Antivirus at the end");
            System.out.println("6. Computer insertion with Antivirus at a position");
            System.out.println("7. Computer insertion with virus at the beginning");
            System.out.println("8. Computer insertion with virus at the end");
            System.out.println("9. Computer insertion with virus at a position");
            System.out.println("10. Computer supression at a position");
            System.out.println("11. Verify if the network is empty");
            System.out.println("12. Number of machines");
            System.out.println("13. Start random walk");
            System.out.println("14. Show network");

            int choix = scanner.nextInt();
            switch (choix) {
            case 1: // Computer -> START
                Computer ComputerDebut = new Computer(null, null);
                ComputerNetwork.insertAtStart(ComputerDebut);
                break;
            case 2: // Computer -> END
                Computer ComputerFin = new Computer(null, null);
                ComputerNetwork.insertAtEnd(ComputerFin);
                break;
            case 3: // Computer -> POSITION
                Computer ComputerPos = new Computer(null, null);
                System.out.println("Insert a position :");
                int pos = scanner.nextInt();
                if (pos < 1 || pos > ComputerNetwork.getTaille())
                    System.out.println("Poistion invalide\n");
                else
                    ComputerNetwork.insertAtPosition(ComputerPos, pos);
                break;
            case 4: // Computer + Antivirus -> START
                if (!ComputerNetwork.aUnAntivirus) {
                    Computer Computer = new Computer(null, null, new Antivirus());
                    ComputerNetwork.insertAtStart(Computer);
                    ComputerNetwork.setAUnAntivirus(true);
                } else
                    System.out.println("The network has already got a computer with an antivirus.");
                break;
            case 5: // Computer + Antivirus -> END
                if (!ComputerNetwork.aUnAntivirus) {
                    Computer Computer = new Computer(null, null, new Antivirus());
                    ComputerNetwork.insertAtEnd(Computer);
                    ComputerNetwork.setAUnAntivirus(true);
                } else
                    System.out.println("The network has already got a computer with an antivirus.");
                break;
            case 6: // Computer + Antivirus -> POSITION
                if (!ComputerNetwork.aUnAntivirus) {
                    Computer Computer = new Computer(null, null, new Antivirus());
                    System.out.println("Insert a position :");
                    int pos1 = scanner.nextInt();
                    if (pos1 < 1 || pos1 > ComputerNetwork.getTaille())
                        System.out.println("Poistion invalid\n");
                    else {
                        ComputerNetwork.insertAtPosition(Computer, pos1);
                        ComputerNetwork.setAUnAntivirus(true);
                    }
                } else
                    System.out.println("The network has already got a computer with an antivirus.");
                break;
            case 7: // Computer + VIRUS -> START
                if (!ComputerNetwork.aUnVirus) {
                    Computer Computer = new Computer(null, null, new Virus());
                    ComputerNetwork.insertAtStart(Computer);
                    ComputerNetwork.setAUnVirus(true);
                } else
                    System.out.println("The network has already got a computer with a virus.");
                break;
            case 8: // Computer + VIRUS -> END
                if (!ComputerNetwork.aUnVirus) {
                    Computer Computer = new Computer(null, null, new Virus());
                    ComputerNetwork.insertAtEnd(Computer);
                    ComputerNetwork.setAUnVirus(true);
                } else
                    System.out.println("The network has already got a computer with an virus.");
                break;
            case 9:
                if (!ComputerNetwork.aUnVirus) {
                    Computer Computer = new Computer(null, null, new Virus());
                    System.out.println("Insert a position :");
                    int pos1 = scanner.nextInt();
                    if (pos1 < 1 || pos1 > ComputerNetwork.getTaille())
                        System.out.println("Position invalid\n");
                    else {
                        ComputerNetwork.insertAtPosition(Computer, pos1);
                        ComputerNetwork.setAUnVirus(true);
                    }
                } else
                    System.out.println("The network has already got a computer with an virus.");
                break;
            case 10: // Computer supression position
                System.out.println("Insert a position :");
                int p = scanner.nextInt();
                if (p < 1 || p > ComputerNetwork.getTaille())
                    System.out.println("Position invalid\n");
                else
                    ComputerNetwork.supprimerPCPosition(p);
                break;
            case 11:
                if (ComputerNetwork.isEmpty())
                    System.out.println("No network is established.");
                else
                    System.out.println("A network is not established.");
                break;
            case 12:
                System.out.println("Size of the network : " + ComputerNetwork.getTaille() + " computer(s)\n");
                break;
            case 13:
                // TODO
                System.out.print("How often should the random walk be performed : ");
                int n = scanner.nextInt();
                for (int i = 0; i < n; i++) {
                    RandomWallk.parcoursListeDoubleChainee();
                    System.out.println("Instant n = " + (i + 1) + ":\n");
                    ComputerNetwork.affchageReseau();
                }
                break;
            case 14:
                ComputerNetwork.affchageReseau();
            }
            System.out.println("\nDo you want to continue ? (yY ou nN)\n");
            ch = scanner.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }

}
