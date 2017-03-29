package br.com.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table
public class Acesso extends GenericDomain {
	@Column(length = 100, nullable = false)
	private String nome;

	@Column(nullable = true)
	private Boolean acesso;

	@Column(nullable = true)
	private Boolean usuario;

	@Column(nullable = true)
	private Boolean perfil;

	@Column(nullable = true)
	private Boolean vaga;

	@Column(nullable = true)
	private Boolean curriculo;

	@Column(nullable = true)
	private Boolean etapa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAcesso() {
		return acesso;
	}

	public void setAcesso(Boolean acesso) {
		this.acesso = acesso;
	}

	public Boolean getUsuario() {
		return usuario;
	}

	public void setUsuario(Boolean usuario) {
		this.usuario = usuario;
	}

	public Boolean getPerfil() {
		return perfil;
	}

	public void setPerfil(Boolean perfil) {
		this.perfil = perfil;
	}

	public Boolean getVaga() {
		return vaga;
	}

	public void setVaga(Boolean vaga) {
		this.vaga = vaga;
	}

	public Boolean getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Boolean curriculo) {
		this.curriculo = curriculo;
	}

	public Boolean getEtapa() {
		return etapa;
	}

	public void setEtapa(Boolean etapa) {
		this.etapa = etapa;
	}

}
