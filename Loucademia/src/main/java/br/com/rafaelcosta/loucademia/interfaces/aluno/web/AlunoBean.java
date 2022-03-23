package br.com.rafaelcosta.loucademia.interfaces.aluno.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafaelcosta.loucademia.application.service.AlunoService;
import br.com.rafaelcosta.loucademia.application.util.StringUtils;
import br.com.rafaelcosta.loucademia.domain.aluno.Aluno;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class AlunoBean implements Serializable {
	
	@EJB
	private AlunoService alunoService;
	
	@Inject
	private FacesContext facesContext;

	private Aluno aluno = new Aluno();
	
	private String matricula;
	
	private String titulo = "Novo aluno";

	public void carregar() {
		if(!StringUtils.isEmpty(matricula)) {
			aluno = alunoService.findByMatricula(matricula);
			this.titulo = "Alterar aluno";
		}
	}

	public String gravar() {
		alunoService.createOrUpdate(aluno);
		facesContext.addMessage(null,new FacesMessage("Dados Gravados Com Sucesso!"));
		return null;
	}

	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
