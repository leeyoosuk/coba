/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kmp2.uas.repo;


import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import lab.kmp2.uas.entity.Surat;
/**
 *
 * @author yusuf
 */

@Repository
public interface SuratRepo 
        extends JpaRepository<Surat, String>{

    public List<Surat> findAll();
}
