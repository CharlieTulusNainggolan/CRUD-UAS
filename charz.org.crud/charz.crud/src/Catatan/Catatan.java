package Catatan;

public class Catatan
{
    private String judul;
    private String tanggal;
    private String isi;

    public Catatan(String judul, String tanggal, String isi)
    {
        this.judul = judul;
        this.tanggal = tanggal;
        this.isi = isi;
    }

    public String getJudul()
    {
        return judul;
    }

    public void setJudul(String judul)
    {  
        this.judul = judul;
    }


    public String getTanggal()
    {
        return tanggal;
    }

    public void setTanggal(String tanggal)
    {  
        this.tanggal = tanggal;
    }

    public String getIsi()
    {
        return isi;
    }

    public void setIsi(String isi)
    {
        this.isi = isi;
    }
}
