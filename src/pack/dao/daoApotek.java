package pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pack.control.koneksi;
import pack.model.m_apotek;


public class daoApotek implements implementApotek {
    Connection connection;
    public String TampilData = "SELECT * FROM `obat`";
    public String UbahData = "UPDATE `obat` SET `kode_obat`=?, `nama_obat`=?, `jenis_obat`=?, `produsen`=? Where `harga`=?;";
    public String SimpanData = "INSERT INTO `obat` VALUES (?, ?, ?, ?, ?)";
    public String HapusData = "DELETE FROM `obat` WHERE kode_obat=?";
    public String CariJenis = "SELECT `kode_obat`, `nama_obat`, `jenis_obat`, `produsen`, `harga` FROM `obat` WHERE jenis_obat like ?";

    public daoApotek() {
        connection = koneksi.setKoneksi();
    }

    @Override
    public void TampilData(m_apotek a) {
    }

    @Override
    public void UbahData(m_apotek a) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UbahData);
            statement.setString(1, a.getkode());
            statement.setString(2, a.getnama());
            statement.setString(3, a.getjenis());
            statement.setString(4, a.getprodusen());
            statement.setString(5, a.getharga());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(daoApotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void SimpanData(m_apotek a) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SimpanData);
            statement.setString(1, a.getkode());
            statement.setString(2, a.getnama());
            statement.setString(3, a.getjenis());
            statement.setString(4, a.getprodusen());
            statement.setString(5, a.getharga());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                a.setkode(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoApotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//menampilkan data ke tabel sesuai pencarian     
    @Override
    public List<m_apotek> getCariJenis(String jenis) {
        List<m_apotek> lt = null;
        try {
            lt = new ArrayList<m_apotek>();
            PreparedStatement st = connection.prepareStatement(CariJenis);
            st.setString(1, "%" + jenis + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                m_apotek toko = new m_apotek();
                toko.setkode(rs.getString("kode_obat"));
                toko.setnama(rs.getString("nama_obat"));
                toko.setjenis(rs.getString("jenis_obat"));
                toko.setprodusen(rs.getString("produsen"));
                toko.setharga(rs.getString("harga"));
                lt.add(toko);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoApotek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lt;
    }
    
    //menampilkan data ke Tabel     
    @Override
    public List<m_apotek> getAll() {
        List<m_apotek> lt = null;
        try {
            lt = new ArrayList<m_apotek>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(TampilData);
            while (rs.next()) {
                m_apotek toko = new m_apotek();
                toko.setkode(rs.getString("kode_obat"));
                toko.setnama(rs.getString("nama_obat"));
                toko.setjenis(rs.getString("jenis_obat"));
                toko.setprodusen(rs.getString("produsen"));
                toko.setharga(rs.getString("harga"));
                lt.add(toko);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoApotek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lt;
    }    
    //hapus data     
    @Override    
    public void HapusData(String kode) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(HapusData);
            statement.setString(1, kode);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(daoApotek.class
                    .getName()
            ).log(Level.SEVERE, null, ex);
        }
    }     
    //pencarian data     
    public void CariJenis(int kode) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(CariJenis);
            statement.setInt(1, kode);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(daoApotek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}