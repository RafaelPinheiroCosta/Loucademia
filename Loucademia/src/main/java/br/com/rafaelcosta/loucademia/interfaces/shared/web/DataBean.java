package br.com.rafaelcosta.loucademia.interfaces.shared.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.rafaelcosta.loucademia.application.service.DataService;
import br.com.rafaelcosta.loucademia.domain.aluno.Aluno.Sexo;
import br.com.rafaelcosta.loucademia.domain.aluno.Aluno.Situacao;
import br.com.rafaelcosta.loucademia.domain.aluno.Estado;

@SuppressWarnings("serial")
@Named
@ApplicationScoped
public class DataBean implements Serializable {
	
	@EJB
	private DataService dataService;
	
	public Sexo[] getSexos() {
		return dataService.getSexos();
	}
	
	public Situacao[] getSituacoes() {
		return dataService.getSituacoes();
	}
	
	public List<Estado> getEstados(){
		return dataService.listEstados();
	}

	public String formatTelefone(Integer ddd, Integer numero) {
		if(ddd==null || numero==null) {
			return "";
		}
		
		return "(" + ddd + ") " + numero;
	}
}
