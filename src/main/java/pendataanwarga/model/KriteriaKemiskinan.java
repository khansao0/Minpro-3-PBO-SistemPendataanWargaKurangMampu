/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pendataanwarga.model;

/**
 *
 * @author qonitah
 */
public class KriteriaKemiskinan {
    private String idKriteria;
    private String jenisPekerjaan;
    private double pendapatanBulanan;
    private String statusRumah;

    public KriteriaKemiskinan(String idKriteria, String jenisPekerjaan, double pendapatanBulanan, String statusRumah) {
        this.idKriteria = idKriteria;
        this.jenisPekerjaan = jenisPekerjaan;
        setPendapatanBulanan(pendapatanBulanan);
        this.statusRumah = statusRumah;
    }

    public String getIdKriteria() {
        return idKriteria;
    }

    public void setIdKriteria(String idKriteria) {
        this.idKriteria = idKriteria;
    }

    public String getJenisPekerjaan() {
        return jenisPekerjaan;
    }

    public void setJenisPekerjaan(String jenisPekerjaan) {
        this.jenisPekerjaan = jenisPekerjaan;
    }

    public double getPendapatanBulanan() {
        return pendapatanBulanan;
    }

    public void setPendapatanBulanan(double pendapatanBulanan) {
        if (pendapatanBulanan >= 0) {
            this.pendapatanBulanan = pendapatanBulanan;
        } else {
            System.out.println("Pendapatan tidak boleh negatif!");
            this.pendapatanBulanan = 0;
        }
    }

    public String getStatusRumah() {
        return statusRumah;
    }

    public void setStatusRumah(String statusRumah) {
        this.statusRumah = statusRumah;
    }
}