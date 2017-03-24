package br.com.projeto.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class AtalhosBean implements Serializable {

	public void curriculo() {
		try {
			Faces.redirect("./pages/curriculo.xhtml");

		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Não foi possível Executar este Comando. Erro: " + erro.getMessage());
		}
	}

	public void perfil() {
		try {
			Faces.redirect("./pages/perfil.xhtml");

		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Não foi possível Executar este Comando. Erro: " + erro.getMessage());
		}
	}

	public void vaga() {
		try {
			Faces.redirect("./pages/vaga.xhtml");

		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Não foi possível Executar este Comando. Erro: " + erro.getMessage());
		}
	}
}
