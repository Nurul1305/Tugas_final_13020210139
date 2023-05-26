package pack.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pack.dao.daoApotek;
import pack.dao.implementApotek;
import pack.model.m_apotek;
import pack.view.home;
import pack.model.tableModelApotek;


public class controllerApotek {
    home hm;
    implementApotek impToko;
    List<m_apotek> lt;

    public controllerApotek(home hm) {
        this.hm = hm;
        impToko = new daoApotek();
        lt = impToko.getAll();
    }

    //mengkosongkan isian field     
    public void Reset() {
        hm.getTxtKode().setText("");
        hm.getTxtNama().setText("");
        hm.getTxtHarga().setText("");
        hm.getTxtProdusen().setText("");
        hm.getCbJenis().setSelectedItem(null);
    }      
    //menghapus data yang dipilih     
    public void Hapus() {
        if (hm.getTxtKode().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(hm, "Masukkan kode barang");
        } else {
            String kode = (hm.getTxtKode().getText());
            impToko.HapusData(kode);
            JOptionPane.showMessageDialog(hm, "Data berhasil dihapus");
        }
    }     
    //menyimpan data     
    public void SimpanData() {
        m_apotek toko = new m_apotek();
        toko.setkode(hm.getTxtKode().getText());
        toko.setnama(hm.getTxtNama().getText());
        toko.setharga(hm.getTxtHarga().getText());
        toko.setprodusen(hm.getTxtProdusen().getText());
        toko.setjenis(hm.getCbJenis().getSelectedItem().toString());
        impToko.SimpanData(toko);
    }     
    //mengubah data     
    public void Ubah() {
        m_apotek toko = new m_apotek();
        toko.setkode(hm.getTxtKode().getText());
        toko.setnama(hm.getTxtNama().getText());
        toko.setjenis(hm.getCbJenis().getSelectedItem().toString());
        toko.setprodusen(hm.getTxtProdusen().getText());
        toko.setharga(hm.getTxtHarga().getText());
        impToko.UbahData(toko);
    }
    public void isiTable() {
        lt = impToko.getAll();
        tableModelApotek tmt = new tableModelApotek(lt);
        hm.getTableData().setModel(tmt);
    }

    public void isiField(int row) {
        hm.getTxtKode().setText(lt.get(row).getkode().toString());
        hm.getTxtNama().setText(lt.get(row).getnama().toString());
        hm.getCbJenis().setSelectedItem(lt.get(row).getjenis().toString());
        hm.getTxtProdusen().setText(lt.get(row).getnama().toString());
        hm.getTxtHarga().setText(lt.get(row).getharga().toString());
    }

    public void CariJenis() {
        if (!hm.getCbCariJenis().getSelectedItem().toString().isEmpty()) {
            isiTableCariJenis();
        } else {
            JOptionPane.showMessageDialog(hm, "Silahkan Pilih Kategori");
        }
    }

    private void isiTableCariJenis() {
        String item = hm.getCbCariJenis().getSelectedItem().toString();
        lt = impToko.getCariJenis(item);
        tableModelApotek tmt = new tableModelApotek(lt);
        hm.getTableData().setModel(tmt);
    }
}