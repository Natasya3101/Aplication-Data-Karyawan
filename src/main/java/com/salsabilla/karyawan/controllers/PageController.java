package com.salsabilla.karyawan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salsabilla.karyawan.models.Karyawan;
import com.salsabilla.karyawan.services.KaryawanService;

@Controller
public class PageController {
    @Autowired KaryawanService karyawanService;

    @GetMapping
    public String showKaryawanPage(Model model) {
        List<Karyawan> karyawans = karyawanService.getAll();
        System.out.println(karyawans);
        model.addAttribute("karyawans", karyawans);
        model.addAttribute("karyawan", new Karyawan()); // Untuk form tambah karyawan
        return "index"; // Menampilkan halaman karyawan.html
    }
}
