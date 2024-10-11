package com.salsabilla.karyawan.services;

import com.salsabilla.karyawan.models.Karyawan;
import java.util.List;
import java.util.Optional;

public interface KaryawanService {
    String addKaryawan(Karyawan karyawan);
    String deleteKaryawan(Long nik);
    List<Karyawan> getAll();
    String editKaryawan(Long nik, Karyawan karyawan);
    Optional<Karyawan> getKaryawanByNik(Long nik);
}
