package br.com.finperson.domain.enumm;

import static br.com.finperson.util.ConstantsMessages.USER_REGISTRATION_MESSAGE;
import static br.com.finperson.util.ConstantsMessages.USER_REGISTRATION_SUBJECT;
import static br.com.finperson.util.ConstantsMessages.USER_RESET_PASSWORD_MESSAGE;
import static br.com.finperson.util.ConstantsMessages.USER_RESET_PASSWORD_SUBJECT;

import lombok.Getter;

@Getter
public enum TypeEmailEnum {

	CONFIRMATION_USER(USER_REGISTRATION_SUBJECT, "/user/registrationConfirm?token=", USER_REGISTRATION_MESSAGE),
	RESET_PASSWORD(USER_RESET_PASSWORD_SUBJECT, "/user/resetPasswordConfirm?token=", USER_RESET_PASSWORD_MESSAGE);
	
	private String subject;
	private String url;
	private String message;
	
	TypeEmailEnum(String subject, String url, String message) {

		this.subject = subject;
		this.url = url;
		this.message = message;
	}
	
	
}
