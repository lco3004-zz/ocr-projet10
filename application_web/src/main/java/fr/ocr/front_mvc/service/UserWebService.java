/*
* Service :authentifcation usager
 */

package fr.ocr.front_mvc.service;

import fr.ocr.exception.PrjExceptionHandler;
import fr.ocr.front_mvc.model.UserWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class UserWebService {

    private final PrjExceptionHandler prjExceptionHandler;
	private final AuthenticationProvider authenticationProvider;

	@Autowired
	public UserWebService(PrjExceptionHandler prjExceptionHandler, AuthenticationProvider authenticationProvider) {
		this.prjExceptionHandler = prjExceptionHandler;
		this.authenticationProvider = authenticationProvider;
	}

	public UserDetails attemptAuthentication(UserWeb user) {
		Authentication authentication = null;

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());

		try {
			authentication = this.authenticationProvider.authenticate(token);

			SecurityContextHolder.getContext().setAuthentication(authentication);

		} catch (Exception e) {
			prjExceptionHandler.throwUserUnAuthorized();
		}
		assert authentication != null;
		return (UserDetails) authentication.getPrincipal();
	}

}
