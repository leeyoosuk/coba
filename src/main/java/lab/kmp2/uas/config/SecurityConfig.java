/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kmp2.uas.config;

/**
 *
 * @author yusuf
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web
  .configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation
  .authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation
	.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import lab.kmp2.uas.util.CsrfHeaderFilter;
import javax.sql.DataSource;

@Configuration
public class SecurityConfig 
		extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;

	private String qryUser = 
		"select username, password, enabled " +
		"from users " +
		"where username = ?";

	private String qryRole = 
		"select ur.username, r.role " +
		"from user_role ur " + 
		"join roles r on (r.id = ur.id_role) " +
		"where ur.username = ?";

	@Autowired
	public void configureGlobal(
			AuthenticationManagerBuilder auth) 
			throws Exception {
		
		auth.jdbcAuthentication()
			.dataSource(ds)
			.usersByUsernameQuery(qryUser)
			.authoritiesByUsernameQuery(qryRole);

		auth.inMemoryAuthentication()
			.withUser("endang")
			.password("rahasia")
			.roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) 
			throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/js/**").permitAll()
				.antMatchers("/hapus-data/**").hasRole("ADMIN")
				.antMatchers("/form-edit").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and()
				.formLogin().permitAll()
			.and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
				.csrf().csrfTokenRepository(csrfTokenRepository());
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository tokenRepo = new HttpSessionCsrfTokenRepository();
		tokenRepo.setHeaderName("X-XSRF-TOKEN");
		return tokenRepo;
	}

} 