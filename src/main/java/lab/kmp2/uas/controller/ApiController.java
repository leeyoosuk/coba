/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kmp2.uas.controller;


import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import lab.kmp2.uas.entity.Surat;
import lab.kmp2.uas.repo.SuratRepo;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 *
 * @author yusuf
 */
@RestController
public class ApiController {
    @Autowired
    private SuratRepo suratRepo;

    @RequestMapping("/daftar-surat")
    public List<Surat> getDaftarSurat() {
        List<Surat> data = suratRepo.findAll();
        for(int i=0; i<data.size(); i++) {
            System.out.println(((Surat) data.get(i)).getTanggal());
        }
        return suratRepo.findAll();
    }

    @RequestMapping(value = "/api/tambah", method = RequestMethod.POST) 
    public void tambahData(@RequestBody Surat surat) {
        //System.out.println("nomer : " + surat.getNomer());
        //System.out.println("tanggal :  "+ surat.getTanggal());
        //System.out.println("nama : " + surat.getNama());
        //System.out.println("perihal : " + surat.getPerihal());
        suratRepo.save(surat);
    }

    @RequestMapping(value = "/api/hapus/{id}", method = RequestMethod.DELETE)
    public void hapusData(@PathVariable("nomer") int nomer) {
        suratRepo.delete(nomer);
    }
    
}
