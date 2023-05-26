package pack.dao;

import java.util.List;
import pack.model.m_apotek;



public interface implementApotek {

    public void TampilData(m_apotek a);

    public void UbahData(m_apotek a);

    public void SimpanData(m_apotek a);

    public void HapusData(String kode);

    public List<m_apotek> getCariJenis(String jenis);

    public List<m_apotek> getAll();
    public String user = "";
}
