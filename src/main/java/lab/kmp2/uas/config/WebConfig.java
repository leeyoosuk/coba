/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kmp2.uas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author yusuf
 */
public class WebConfig extends WebMvcConfigurerAdapter {
     @Override
    public void addViewControllers(ViewControllerRegistry reg) {
        reg.addViewController("/")
        	.setViewName("test-angular");
        reg.addViewController("/daftar-surat")
        	.setViewName("daftar-surat");
        reg.addViewController("/form")
        	.setViewName("form-entry");
        reg.addViewController("/form-edit")
        	.setViewName("form-edit");
    }
    
    
}
