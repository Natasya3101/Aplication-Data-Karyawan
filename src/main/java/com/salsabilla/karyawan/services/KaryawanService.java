package com.salsabilla.karyawan.services;

import com.salsabilla.karyawan.models.Karyawan;
import java.util.List;


public interface KaryawanService {
    void addKaryawan (Karyawan karyawan) throws Exception;
    String deleteKaryawan(Long nik);
    List<Karyawan> getAll();
    String editKaryawan(Karyawan karyawan);
    Karyawan getKaryawan(Long nik);
}
