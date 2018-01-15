/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kmp2.uas.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author yusuf
 */
@Entity
public class Surat {
    @Id @Getter @Setter
	private String nomer;
	@Getter @Setter
	private String tanggal;
	@Getter @Setter
	private String nama;
        @Getter @Setter
	private String perihal;

    

    
    
}
