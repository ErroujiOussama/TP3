import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class table_perso extends AbstractTableModel {
    public ArrayList<Personne> personnes;
   table_perso(ArrayList<Personne> personnes){
      this.personnes=personnes;
      for(int i=0;i<personnes.size();i++){
          this.setValueAt(personnes.get(i).getNom(), i, 0);
            this.setValueAt(personnes.get(i).getPrenom(), i, 1);
            this.setValueAt(personnes.get(i).getAge(), i, 2);
      }

   }
    @Override
    public int getRowCount() {
        return personnes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
           case 0:
               return personnes.get(rowIndex).getNom();
           case 1:
               return personnes.get(rowIndex).getPrenom();
           case 2:
               return personnes.get(rowIndex).getAge();
           default:
               return null;
    }
}

}

