/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pendataanwarga.model;

/**
 *
 * @author qonitah
 */
public class WargaLansia extends Warga {
    private int umur;
    private String kondisiKesehatan;

    public WargaLansia(String nik, String nama, String alamat, int jumlahTanggungan, KriteriaKemiskinan kriteria, int umur, String kondisiKesehatan) {
        super(nik, nama, alamat, jumlahTanggungan, kriteria);
        setUmur(umur);
        setKondisiKesehatan(kondisiKesehatan);
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if (umur >= 60) {
            this.umur = umur;
        } else {
            System.out.println("Umur lansia minimal 60 tahun! Otomatis diset 60.");
            this.umur = 60;
        }
    }

    public String getKondisiKesehatan() {
        return kondisiKesehatan;
    }

    public void setKondisiKesehatan(String kondisiKesehatan) {
        this.kondisiKesehatan = kondisiKesehatan;
    }

    @Override
    public String getKategori() {
        return "WARGA LANSIA";
    }

    @Override
    public boolean cekKelayakanBantuan() {
        return (getKriteria() != null && getKriteria().getPendapatanBulanan() <= 1000000) || getUmur() >= 70;
    }

    @Override
    public String getCatatanBantuan() {
        return "Prioritas Bantuan Lansia (" + getKondisiKesehatan() + ")";
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[KATEGORI: " + getKategori() + "]");
        super.tampilkanInfo();
        System.out.println("Umur            : " + getUmur() + " tahun");
        System.out.println("Kondisi Kesehatan: " + getKondisiKesehatan());
    }
}