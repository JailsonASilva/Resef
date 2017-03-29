package br.com.projeto.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import br.com.projeto.dao.CurriculoVagaDAO;
import br.com.projeto.dao.VagaPerfilDAO;
import br.com.projeto.domain.CurriculoVaga;
import br.com.projeto.domain.VagaPerfil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CurriculoVagaBean implements Serializable {

	private CurriculoVaga curriculoVaga;
	private List<CurriculoVaga> curriculosVagas;

	private VagaPerfil vagaPerfil;
	private List<VagaPerfil> vagasDisponiveis;

	private FacesMessage message;

	public List<VagaPerfil> getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(List<VagaPerfil> vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public CurriculoVaga getCurriculoVaga() {
		return curriculoVaga;
	}

	public void setCurriculoVaga(CurriculoVaga curriculoVaga) {
		this.curriculoVaga = curriculoVaga;
	}

	public FacesMessage getMessage() {
		return message;
	}

	public void setMessage(FacesMessage message) {
		this.message = message;
	}

	public VagaPerfil getVagaPerfil() {
		return vagaPerfil;
	}

	public void setVagaPerfil(VagaPerfil vagaPerfil) {
		this.vagaPerfil = vagaPerfil;
	}

	public List<CurriculoVaga> getCurriculosVagas() {
		return curriculosVagas;
	}

	public void setCurriculosVagas(List<CurriculoVaga> curriculosVagas) {
		this.curriculosVagas = curriculosVagas;
	}

	@PostConstruct
	public void inicializar() {
		try {
			VagaPerfilDAO vagaPerfilDAO = new VagaPerfilDAO();
			vagasDisponiveis = vagaPerfilDAO.listarVagas();

		} catch (Exception erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Não foi possível Listar as Vagas Disponíveis. Erro: " + erro.getMessage());
		}
	}

	public void duploClique(SelectEvent evento) {
		try {
			org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('dialogoVaga').show();");

		} catch (RuntimeException erro) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um Erro ao Tentar Selecionar Registro.",
					"Erro Inesperado!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);
			erro.printStackTrace();
		}
	}

	public void onRowSelect(SelectEvent event) {

	}

	public void onRowUnselect(UnselectEvent event) {
		vagaPerfil = null;
	}

	public void detalhesVaga(ActionEvent evento) {
		try {
			vagaPerfil = (VagaPerfil) evento.getComponent().getAttributes().get("vagaSelecionada");

		} catch (RuntimeException erro) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um Erro ao Tentar Selecionar Registro.",
					"Erro Inesperado!");

			RequestContext.getCurrentInstance().showMessageInDialog(message);
			erro.printStackTrace();
		}
	}

	public void listarCurriculos(ActionEvent evento) {
		try {
			CurriculoVagaDAO curriculoVagaDAO = new CurriculoVagaDAO();
			curriculosVagas = curriculoVagaDAO.listarCurriculos(vagaPerfil.getCodigo());

		} catch (RuntimeException erro) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um Erro ao Tentar Listar Currículos Cadastrados.",
					"Erro Inesperado: " + erro.getMessage());

			RequestContext.getCurrentInstance().showMessageInDialog(message);
			erro.printStackTrace();
		}
	}

	public void listarCurriculosAtalho(ActionEvent evento) {
		try {
			vagaPerfil = (VagaPerfil) evento.getComponent().getAttributes().get("vagaSelecionada");

			CurriculoVagaDAO curriculoVagaDAO = new CurriculoVagaDAO();
			curriculosVagas = curriculoVagaDAO.listarCurriculos(vagaPerfil.getCodigo());

		} catch (RuntimeException erro) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um Erro ao Tentar Listar Currículos Cadastrados.",
					"Erro Inesperado: " + erro.getMessage());

			RequestContext.getCurrentInstance().showMessageInDialog(message);
			erro.printStackTrace();
		}
	}
}
