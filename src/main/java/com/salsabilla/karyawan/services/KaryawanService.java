package com.salsabilla.karyawan.services;

import com.salsabilla.karyawan.models.Karyawan;
import java.util.List;


public interface KaryawanService {
    void addKaryawan (Karyawan karyawan) throws Exception;
    String deleteKaryawan(Long nik);
    List<Karyawan> getAll();
    void editKaryawan(Karyawan karyawan) throws Exception;
    Karyawan getKaryawan(Long nik);
}
