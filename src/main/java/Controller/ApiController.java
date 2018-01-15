/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


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
import org.springframework.security.core
	.context.SecurityContextHolder;
import org.springframework.security.web
	.authentication.logout.SecurityContextLogoutHandler;

/**
 *
 * @author yusuf
 */
public class ApiController {
    @Autowired
	private SuratRepo suratRepo;
	
	@RequestMapping("/ambil-data")
	public Map<String, Object> getData() {
		Map<String, Object> result = new HashMap();
		result.put("nama", "edang");
		
		return result;	
	}


	// -- untuk aplikasi mahasiswa
	@RequestMapping("/list-surat")
	public List<Surat> getListSrt() {
		return suratRepo.findAll();
	}
        @RequestMapping(value = "/tambah", 
                        method = RequestMethod.POST)
        public void tambahData(@RequestBody Surat srt){
        System.out.println("nomer" + srt.getNomer());
        System.out.println("tanggal" + srt.getTanggal());
        System.out.println("nama" + srt.getNama());
        System.out.println("perihal" + srt.getPerihal());
        suratRepo.save(srt);
                }
    
}
