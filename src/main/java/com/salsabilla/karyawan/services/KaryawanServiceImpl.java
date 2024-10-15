package com.salsabilla.karyawan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salsabilla.karyawan.models.Karyawan;
import com.salsabilla.karyawan.repositorys.KaryawanRepository;

import java.util.List;
import java.time.LocalDate;

@Service
public class KaryawanServiceImpl implements KaryawanService {

    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public void addKaryawan(Karyawan karyawan) throws Exception{
        if (karyawanRepository.existsById(karyawan.getNik())) {
            throw new Exception ( "Karyawan dengan NIK " + karyawan.getNik() + " sudah ada.");
        }
        if (!karyawan.getTanggalLahir().isBefore(LocalDate.now())) {
            throw new Exception ("Tanggal lahir harus sebelum hari ini.");
        }
        karyawanRepository.save(karyawan);
        
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
    public void editKaryawan(Karyawan karyawan) throws Exception {
        if (!karyawan.getTanggalLahir().isBefore(LocalDate.now())) {
            throw new Exception ("Tanggal lahir harus sebelum hari ini.");
        }
        karyawanRepository.saveAndFlush(karyawan);

    }

    @Override
    public Karyawan getKaryawan(Long nik) {
        return karyawanRepository.findKaryawanByNik(nik);
    }
}
