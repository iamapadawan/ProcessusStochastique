/// **Creation:25 juin 2017*/
// package fr.esiea.unique.binome.aliayubsoumare.GUI;
//
// import java.awt.FlowLayout;
// import java.awt.GridLayout;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.WindowAdapter;
// import java.awt.event.WindowEvent;
// import java.net.URL;
// import java.util.Scanner;
//
// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.SwingConstants;
//
// import fr.esiea.unique.binome.aliayubsoumare.Computer;
// import fr.esiea.unique.binome.aliayubsoumare.ComputerNetwork;
// import fr.esiea.unique.binome.aliayubsoumare.ComputeurNetwork;
//
// public class ManageComputers {
// private JFrame mainFrame;
// private JLabel headerLabel;
// private JLabel statusLabel;
// private JPanel controlPanel;
//
// Scanner scanner = new Scanner(System.in);
// // Cluster Computers
// ComputeurNetwork ComputerNetwork = new ComputerNetwork();
//
// public ManageComputers() {
// prepareGUI();
// }
//
// public static void main(String[] args) {
// ManageComputers ManageComputers = new ManageComputers();
// ManageComputers.showButtonDemo();
// }
//
// private void prepareGUI() {
// mainFrame = new JFrame("Gestion du réseau d'Computers ");
// mainFrame.setSize(400, 400);
// mainFrame.setLayout(new GridLayout(3, 1));
//
// mainFrame.addWindowListener(new WindowAdapter() {
// public void windowClosing(WindowEvent windowEvent) {
// System.exit(0);
// }
// });
// headerLabel = new JLabel("", JLabel.CENTER);
// statusLabel = new JLabel("", JLabel.CENTER);
// statusLabel.setSize(350, 100);
//
// controlPanel = new JPanel();
// controlPanel.setLayout(new FlowLayout());
//
// mainFrame.add(headerLabel);
// mainFrame.add(controlPanel);
// mainFrame.add(statusLabel);
// mainFrame.setVisible(true);
// }
//
// private static ImageIcon createImageIcon(String path, String description) {
// URL imgURL = ManageComputers.class.getResource(path);
// if (imgURL != null) {
// return new ImageIcon(imgURL, description);
// } else {
// System.err.println("Couldn't find file: " + path);
// return null;
// }
// }
//
// private void showButtonDemo() {
// headerLabel.setText(
// "\nRéseau d'Computers, Topologie Circulaire - List Operations\n1. Insertion PC au début\n 2. Insertion PC à la fin\n 3. Insertion PC à une/
/// position\n 4. Insertion PC + Antivirus au début\n 5. Insertion PC + Antivirus à la fin\n 6. Insertion PC + Antivirus à une position\n 7. Insertion
/// PC + Virus au début\n 8. Insertion PC + Virus à la f\n 9. Insertion PC + Virus à une/ position\n 10. Suppression PC à une position\n 11. Vérifie
/// si le réseau est vide\n 12. Nombre de machines\n 13. Lancer marche aléatoire\n 14./ Afficher réseau");
//
// // resources folder should be inside SWING folder.
// ImageIcon icon = createImageIcon("/resources/java_icon.png", "Java");
// ImageIcon icon2 = createImageIcon("ressources/ordi.png", "test");
//
// JButton okButton = new JButton(icon2);
// JButton javaButton = new JButton("Submit", icon);
// JButton cancelButton = new JButton("Cancel", icon);
// cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);
//
// okButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// statusLabel.setText("Ok Button clicked.");
// Computer ComputerDebut = new Computer(null, null);
// ComputerNetwork.insertAtStart(ComputerDebut);
// }
// });
// javaButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// statusLabel.setText("Submit Button clicked.");
// }
// });
// cancelButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// statusLabel.setText("Cancel Button clicked.");
// }
// });
// controlPanel.add(okButton);
// controlPanel.add(javaButton);
// controlPanel.add(cancelButton);
//
// mainFrame.setVisible(true);
// }
// }