package com.salsabilla.karyawan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salsabilla.karyawan.models.Karyawan;
import com.salsabilla.karyawan.repositorys.KaryawanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KaryawanServiceImpl implements KaryawanService {

    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public String addKaryawan(Karyawan karyawan) {
        if (karyawanRepository.existsById(karyawan.getNik())) {
            return "Karyawan dengan NIK " + karyawan.getNik() + " sudah ada.";
        }
        karyawanRepository.save(karyawan);
        return "Karyawan berhasil ditambahkan.";
    }

    @Override
    public String deleteKaryawan(Long nik) {
        if (karyawanRepository.existsById(nik)) {
            karyawanRepository.deleteById(nik);
            return "Karyawan dengan NIK " + nik + " berhasil dihapus.";
        }
        return "Karyawan dengan NIK " + nik + " tidak ditemukan.";
    }

    @Override
    public List<Karyawan> getAll() {
        return karyawanRepository.findAll();
    }

    @Override
public String editKaryawan(Long nik, Karyawan karyawan) {
    // Mencari karyawan berdasarkan NIK
    Karyawan existingKaryawan = karyawanRepository.findKaryawanByNik(nik);
    
    // Mengupdate data karyawan
    existingKaryawan.setNamaLengkap(karyawan.getNamaLengkap());
    existingKaryawan.setJenisKelamin(karyawan.getJenisKelamin());
    existingKaryawan.setTanggalLahir(karyawan.getTanggalLahir());
    existingKaryawan.setAlamat(karyawan.getAlamat());
    existingKaryawan.setNegara(karyawan.getNegara());

    // Menyimpan perubahan
    karyawanRepository.save(existingKaryawan);

    return "Sukses Edit Karyawan";
}


    @Override
    public Optional<Karyawan> getKaryawanByNik(Long nik) {
        return karyawanRepository.findById(nik);
    }
}
