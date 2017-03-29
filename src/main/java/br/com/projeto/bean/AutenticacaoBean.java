package br.com.projeto.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.domain.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	private Usuario usuario;
	private Usuario usuarioLogado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
	}

	public void autenticar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autenticar(usuario.getEmail(), usuario.getSenha());

			if (usuarioLogado == null) {
				Messages.addGlobalError("E-mail e/ou Senha Incorretos");
				return;
			}

			Faces.redirect("./pages/curriculoVaga.xhtml");

		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Não foi possível Realizar a Autenticação. Erro: " + erro.getMessage());
		}
	}

	public void desconectar() {
		try {
			usuario = new Usuario();
			usuarioLogado = null;

			Faces.redirect("./pages/autenticacao.xhtml");

		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Não foi possível Desconectar. Erro: " + erro.getMessage());
		}
	}
}
