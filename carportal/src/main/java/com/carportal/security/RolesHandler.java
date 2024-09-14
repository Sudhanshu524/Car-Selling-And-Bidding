//Divide the USER and ADMIN page

package com.carportal.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class RolesHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//Role=== ROLE_USER== Adminpage
		//Role === ROLE_ADMIN == UserPage
		
		Collection<? extends GrantedAuthority> auth=authentication.getAuthorities();
		String myurl=null;
		for(GrantedAuthority my:auth) {
			System.out.println("roles is "+my);
			if(my.getAuthority().equals("ADMIN")) {
				request.getSession().setAttribute("Header", "headerAdmin.jsp");
				request.getSession().setAttribute("editProfile", "text");
				myurl="/cars";
				break;
			}else if(my.getAuthority().equals("USER")) {
				request.getSession().setAttribute("Header", "header.jsp");
				request.getSession().setAttribute("editProfile", "hidden");
				myurl="/cars";
				break;
			}
		}		
		System.out.println(myurl);
		new DefaultRedirectStrategy()
		.sendRedirect(request, response, myurl);
		
	}

}
