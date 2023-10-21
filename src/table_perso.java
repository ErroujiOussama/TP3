import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class table_perso extends AbstractTableModel {
    public ArrayList<Personne> personnes;
    List<Color> rowColours = Arrays.asList(
            Color.RED,
            Color.GREEN,
            Color.CYAN
    );
   table_perso(ArrayList<Personne> personnes){
      this.personnes=personnes;
      for(int i=0;i<personnes.size();i++){
          this.setValueAt(personnes.get(i).getNom(), i, 0);
            this.setValueAt(personnes.get(i).getPrenom(), i, 1);
            this.setValueAt(personnes.get(i).getAge(), i, 2);
      }

   }

    public void setRowColour(int row, Color c) {
        rowColours.set(row, c);
        fireTableRowsUpdated(row, row);
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

