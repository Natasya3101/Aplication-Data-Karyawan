package com.salsabilla.karyawan.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salsabilla.karyawan.models.Karyawan;
import com.salsabilla.karyawan.services.KaryawanService;



@RequestMapping("/karyawan")
@RestController
@Controller
public class KaryawanController {
    
    @Autowired
    private KaryawanService karyawanService;

    // Menambahkan karyawan
    @PostMapping("/add")
    public String addKaryawan(@RequestBody Karyawan karyawan) {
        return karyawanService.addKaryawan(karyawan);
    }

    // Menghapus karyawan berdasarkan NIK
    @DeleteMapping("{nik}")
    public String deleteKaryawan(@PathVariable Long nik) {
        return karyawanService.deleteKaryawan(nik);
    }

    // Mengambil semua data karyawan
    @GetMapping("/getAll")
    public List<Karyawan> getAll() {
        return karyawanService.getAll();
    }
   
    
    // Mengedit data karyawan berdasarkan NIK
    @PutMapping("edit/{nik}")
    public String editKaryawan(@PathVariable Long nik, @RequestBody Karyawan karyawan) {
        return karyawanService.editKaryawan(nik, karyawan);
    }

    // Mengambil data karyawan berdasarkan NIK
    @GetMapping("{nik}")
    public Optional<Karyawan> getKaryawanByNik(@PathVariable Long nik) {
        return karyawanService.getKaryawanByNik(nik);
    }

    // HTML
    @GetMapping
    public String showKaryawanPage(Model model) {
        List<Karyawan> karyawans = karyawanService.getAll();
        model.addAttribute("karyawans", karyawans);
        model.addAttribute("karyawan", new Karyawan()); // Untuk form tambah karyawan
        return "index"; // Menampilkan halaman karyawan.html
    }
}

