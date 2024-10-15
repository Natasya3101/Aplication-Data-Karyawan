package com.salsabilla.karyawan.models;


import java.time.LocalDate;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Karyawan {
    @Id


    // NIK (Nomor Induk Kependudukan) sebagai primary key
    @Column(nullable = false, unique = true, length = 16) // Assuming NIK length is 16 digits
    private Long nik;

    @Column(nullable = false, length = 100)
    private String namaLengkap;

    @Column(nullable = false)
    private String jenisKelamin; // Radio Button for Gender (Laki-Laki, Perempuan)

    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // Date field for Tanggal Lahir
    private LocalDate tanggalLahir;

    @Lob // Text Area for Alamat (long text)
    @Column(nullable = false)
    private String alamat;

    @Column(nullable = false)
    private String warna;

    @Column(nullable = false, length = 50)
    private String negara; // Dropdown for Country
}
