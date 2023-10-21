import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame{
    public Window(){
        this.setTitle("Tableau de personnes");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ArrayList<Personne> personnes = new ArrayList<Personne>();
        adder adder = new adder(personnes);
        table_perso table =new table_perso(personnes);
        //set column names:
        for(int i=0;i<personnes.size();i++){
            if(personnes.get(i).getAge()<20){
                table.setRowColour(i, Color.blue);
            }
            else if(personnes.get(i).getAge()<50){
                table.setRowColour(i, Color.green);
            }
            else{
                table.setRowColour(i, Color.yellow);
            }
        }
         JTable Jtable = new JTable(table);
         Jtable.getColumnModel().getColumn(0).setHeaderValue("Nom");
            Jtable.getColumnModel().getColumn(1).setHeaderValue("Prenom");
            Jtable.getColumnModel().getColumn(2).setHeaderValue("Age");
            //set colors for rows blue (age<20) green (age<50) yellow  (age>50)


        this.add(new JScrollPane(Jtable));
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);
        this.setVisible(true);


        JButton add = new JButton("Ajouter");
        this.add(add);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
            private void addActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                String nom = JOptionPane.showInputDialog(null, "Nom de la personne");
                String prenom = JOptionPane.showInputDialog(null, "Prenom de la personne");
                String age = JOptionPane.showInputDialog(null, "Age de la personne");
                personnes.add(new Personne(nom, prenom, Integer.parseInt(age)));
                table.fireTableDataChanged();
            }
        });
        JButton remove = new JButton("Supprimer");
        this.add(remove);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
            private void removeActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                int index = Jtable.getSelectedRow();
                personnes.remove(index);
                table.fireTableDataChanged();
            }
        });
        //button mise a jour:
        JButton update = new JButton("Mise a jour");
        this.add(update);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
            private void updateActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                int index = Jtable.getSelectedRow();
                String nom = JOptionPane.showInputDialog(null, "Nom de la personne");
                String prenom = JOptionPane.showInputDialog(null, "Prenom de la personne");
                String age = JOptionPane.showInputDialog(null, "Age de la personne");
                personnes.set(index, new Personne(nom, prenom, Integer.parseInt(age)));
                table.fireTableDataChanged();
            }
        });

    }

}
