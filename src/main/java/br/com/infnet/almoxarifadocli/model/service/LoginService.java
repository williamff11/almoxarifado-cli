package br.com.infnet.almoxarifadocli.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.almoxarifadocli.clients.ILoginClient;
import br.com.infnet.almoxarifadocli.model.negocio.Usuario;


@Service
public class LoginService {

	@Autowired private ILoginClient client;

	public Usuario autenticacao(String login, String senha) {
		return client.autenticacao(login, senha);
	}
}
