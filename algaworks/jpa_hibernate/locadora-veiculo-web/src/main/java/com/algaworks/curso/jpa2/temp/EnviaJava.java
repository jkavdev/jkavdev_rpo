package com.algaworks.curso.jpa2.temp;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviaJava {

	Email email;

	public EnviaJava() {
		email = new SimpleEmail();
		configure();
	}

	public void enviarEmail(String from, String subject, String message,
			String to) {
		try {
			// quem esta enviando
			email.setFrom(from);
			// assunto
			email.setSubject(subject);
			// mensagem
			email.setMsg(message);
			// para quem
			email.addTo(to);
			// envia email
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	private void configure() {
		// qual o servidor do email
		email.setHostName("smtp.googlemail.com");
		// a porta deste servidor
		// podemos deixar em branco, pois
		// ele vai procurar uma porta padrao
		email.setSmtpPort(465);
		// identificacao do usuario
		// email.setAuthenticator(new DefaultAuthenticator("username",
		// "password"));
		// para vermos o processo de execucao
		email.setDebug(true);
		email.setAuthentication("jhonatankolen@gmail.com", "73754012");
		// certificando de utilizar uma conexao segura
		email.setSSLOnConnect(true);
	}
}
