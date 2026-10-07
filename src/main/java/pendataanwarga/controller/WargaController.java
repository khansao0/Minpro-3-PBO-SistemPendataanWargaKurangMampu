/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pendataanwarga.controller;

import java.util.ArrayList;
import pendataanwarga.model.KriteriaKemiskinan;
import pendataanwarga.model.Warga;
import pendataanwarga.model.WargaDisabilitas;
import pendataanwarga.model.WargaLansia;

/**
 *
 * @author qonitah
 */
public class WargaController {
    private String idData;
    private String tanggalPendataan;
    private boolean statusValidasi;
    private ArrayList<Warga> daftarWargaKurangMampu;

    public WargaController(String idData, String tanggalPendataan, boolean statusValidasi) {
        this.idData = idData;
        this.tanggalPendataan = tanggalPendataan;
        this.statusValidasi = statusValidasi;
        this.daftarWargaKurangMampu = new ArrayList<>();
        isiDataAwal();
    }

    private void isiDataAwal() {
        KriteriaKemiskinan k1 = new KriteriaKemiskinan("K01", "Buruh Harian", 500000, "Numpang");
        KriteriaKemiskinan k2 = new KriteriaKemiskinan("K02", "Pedagang Keliling", 750000, "Sewa");

        daftarWargaKurangMampu.add(new WargaLansia("6472010101500001", "Mbah Maimunah", "Jl. Gerilya No. 12", 1, k1, 68, "Hipertensi"));
        daftarWargaKurangMampu.add(new WargaDisabilitas("6472010203950002", "Rahmat Hidayat", "Jl. Siradj Salman No. 04", 3, k2, "Tunawicara", "Kursi Roda"));
    }

    public void tambahWarga(Warga warga) {
        this.daftarWargaKurangMampu.add(warga);
    }

    public ArrayList<Warga> getDaftarWarga() {
        return daftarWargaKurangMampu;
    }

    public boolean ubahWarga(int index, String namaBaru, String alamatBaru, int tanggunganBaru, double pendapatanBaru, String statusRumahBaru) {
        if (index >= 0 && index < daftarWargaKurangMampu.size()) {
            Warga w = daftarWargaKurangMampu.get(index);
            w.setNama(namaBaru);
            w.setAlamat(alamatBaru);
            w.setJumlahTanggungan(tanggunganBaru);
            if (w.getKriteria() != null) {
                w.getKriteria().setPendapatanBulanan(pendapatanBaru);
                w.getKriteria().setStatusRumah(statusRumahBaru);
            } else {
                w.setKriteria(new KriteriaKemiskinan("K-NEW", "Umum", pendapatanBaru, statusRumahBaru));
            }
            return true;
        }
        return false;
    }

    public boolean hapusWarga(int index) {
        if (index >= 0 && index < daftarWargaKurangMampu.size()) {
            daftarWargaKurangMampu.remove(index);
            return true;
        }
        return false;
    }

    public int jumlahData() {
        return daftarWargaKurangMampu.size();
    }

    // Getter dan Setter
    public String getIdData() {
        return idData;
    }

    public void setIdData(String idData) {
        this.idData = idData;
    }

    public String getTanggalPendataan() {
        return tanggalPendataan;
    }

    public void setTanggalPendataan(String tanggalPendataan) {
        this.tanggalPendataan = tanggalPendataan;
    }

    public boolean isStatusValidasi() {
        return statusValidasi;
    }

    public void setStatusValidasi(boolean statusValidasi) {
        this.statusValidasi = statusValidasi;
    }
}