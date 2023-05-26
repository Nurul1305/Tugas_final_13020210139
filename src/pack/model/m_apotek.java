package pack.model;


public class m_apotek {

    public String Nama_Obat, Jenis, Harga, Produsen;
    public String Kode_Obat;

    public String getkode() {
        return Kode_Obat;
    }

    public String getnama() {
        return Nama_Obat;
    }

    public String getjenis() {
        return Jenis;
    }

    public String getharga() {
        return Harga;
    }

    public String getprodusen() {
        return Produsen;
    }

    //method set  
    public void setkode(String kode) {
        this.Kode_Obat = kode;
    }

    public void setnama(String nama) {
        this.Nama_Obat = nama;
    }

    public void setprodusen(String produsen) {
        this.Produsen = produsen;
    }

    public void setjenis(String jenis) {
        this.Jenis = jenis;
    }

    public void setharga(String harga) {
        this.Harga = harga;
    }
}
