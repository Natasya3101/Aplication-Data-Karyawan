package com.salsabilla.karyawan.repositorys;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salsabilla.karyawan.models.Karyawan;
@Repository

public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {
    Karyawan findKaryawanByNik(Long nik);
    // Boolean existsByNameAndIdNot()
    
}

    


