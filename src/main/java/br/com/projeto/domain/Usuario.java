package br.com.projeto.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends GenericDomain {
	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false)
	private String email;

	@Column(length = 100, nullable = true)
	private String senha;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Acesso acesso;

	@Transient
	private String senhaSemCriptografia;

	@Column(nullable = false)
	private Boolean ativo;
	
	@Column(nullable = false)
	private Boolean administrador;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}

	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	@Transient
	public String getAtivoFormatado() {
		String ativoFormatado = "Não";

		if (ativo) {
			ativoFormatado = "Sim";
		}

		return ativoFormatado;
	}

	@Transient
	public void setNomeDepartamento(String nomeDepartamento) {

	}

	@Transient
	public String getNomeAcesso() {
		return getAcesso() == null ? null : getAcesso().getNome();
	}

	@Transient
	public void setNomeAcesso(String nomeAcesso) {
		acesso.setNome(nomeAcesso);
	}

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}
	
	
}
