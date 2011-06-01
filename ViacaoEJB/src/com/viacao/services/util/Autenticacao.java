package com.viacao.services.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Autenticacao extends Authenticator {

	protected PasswordAuthentication getPasswordAuthentication() {
		System.out.println("Autenticando…");
		return new PasswordAuthentication("clausen.ti@gmail.com", "ti.clausen");

	}

}
