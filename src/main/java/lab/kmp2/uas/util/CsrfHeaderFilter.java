/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kmp2.uas.util;


import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.security.web.csrf.CsrfToken;
import javax.servlet.http.Cookie;
import org.springframework.web.util.WebUtils;

/**
 *
 * @author yusuf
 */
public class CsrfHeaderFilter extends OncePerRequestFilter {
    
   @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse resp,
            FilterChain filter
    ) throws ServletException, IOException {
        CsrfToken csrf = (CsrfToken) req.getAttribute(CsrfToken.class.getName());

		if(csrf != null) {
			Cookie cookie = WebUtils.getCookie(req, "XSRF-TOKEN");
			String token = csrf.getToken();

			if(cookie == null || token != null && 
					!token.equals(cookie.getValue())) {
				cookie = new Cookie("XSRF-TOKEN", token);
				cookie.setPath("/");
				resp.addCookie(cookie);
			}
		}

		filter.doFilter(req, resp);
    }
    
}
