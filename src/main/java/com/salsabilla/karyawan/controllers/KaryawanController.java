package com.salsabilla.karyawan.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.salsabilla.karyawan.models.Karyawan;
import com.salsabilla.karyawan.services.KaryawanService;


@Controller
public class KaryawanController {
    @Autowired KaryawanService karyawanService;

    // Halaman Awal
    @GetMapping
    public String showKaryawanPage(Model model) {
        List<Karyawan> karyawans = karyawanService.getAll();
        model.addAttribute("karyawans", karyawans);
        return "index"; // Menampilkan halaman karyawan.html
    }

    @GetMapping("/getAll")
    public List<Karyawan> getAll() {
        return karyawanService.getAll();
    }

     // Menambahkan karyawan
    @GetMapping("/add-karyawan")
    public String addKaryawanPage(Model model) {
        model.addAttribute("karyawan", new Karyawan()); 
        return "tambah";
    }

    // Menambahkan karyawan
    @PostMapping("/add")
    public String addKaryawan(@ModelAttribute Karyawan karyawan,RedirectAttributes redirectAttributes, Model model) {
        try {
            karyawanService.addKaryawan(karyawan);
            redirectAttributes.addFlashAttribute("successMessage", " Data Karyawan berhasil ditambahkan.");
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "tambah";
        }
        
    }
    
    

    //Page edit data karyawan berdasarkan NIK
    @GetMapping("edit/{nik}")
    public String editKaryawanPage(@PathVariable Long nik, Model model) {
        model.addAttribute("editKaryawan", karyawanService.getKaryawan(nik));
        return "edit";
    }
    // Mengedit data karyawan
    @PostMapping("/edit")
    public String editKaryawan(Karyawan karyawan, RedirectAttributes redirectAttributes, Model model){
        System.out.println(karyawan);
        try {
            karyawanService.editKaryawan(karyawan);
            redirectAttributes.addFlashAttribute("successMessage", " Data Karyawan berhasil diubah.");
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "edit";
        }
        
        
    }

    // detail 
    @GetMapping("detail/{nik}")
    public String detailKaryawanPage(@PathVariable Long nik, Model model) {
        model.addAttribute("detail", karyawanService.getKaryawan(nik));
        return "detail";
    }

    // Menghapus karyawan berdasarkan NIK
    @DeleteMapping("/delete/{nik}")
    public String deleteKaryawan(@PathVariable Long nik) {
        System.out.println(nik);
        karyawanService.deleteKaryawan(nik);
        return "redirect:/";
    }
}
