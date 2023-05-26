package pack.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class tableModelApotek extends AbstractTableModel {

    List<m_apotek> lt;

    public tableModelApotek(List<m_apotek> lt) {
        this.lt = lt;
    }

    @Override
    public int getRowCount() {
        return lt.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode_Obat";
            case 1:
                return "Nama_Obat";
            case 2:
                return "Produsen";
            case 3:
                return "Jenis";
            case 4:
                return "Harga";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lt.get(row).getkode();
            case 1:
                return lt.get(row).getnama();
            case 2:
                return lt.get(row).getprodusen();
            case 3:
                return lt.get(row).getjenis();
            case 4:
                return lt.get(row).getharga();
            default:
                return null;
        }
    }
}
