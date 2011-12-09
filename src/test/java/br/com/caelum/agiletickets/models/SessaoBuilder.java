package br.com.caelum.agiletickets.models;

import org.joda.time.DateTime;

public class SessaoBuilder {

	private Sessao instancia;
	
	private Estabelecimento criaEstabelecimento(){
		Estabelecimento est = new Estabelecimento();
		est.setEndereco("Rua 1");
		est.setNome("Casa de Show");
		return est;
		
	}
	
	private Espetaculo criaEspetaculo(){
		Espetaculo esp = new Espetaculo();
		esp.setDescricao("show");
		esp.setEstabelecimento(criaEstabelecimento());
		esp.setNome("Show");
		esp.setTipo(TipoDeEspetaculo.SHOW);
		return esp;
	}
	
	public SessaoBuilder(){
		instancia = new Sessao();
		instancia.setDuracaoEmMinutos(120);
		instancia.setEspetaculo(criaEspetaculo());
		instancia.setIngressosReservados(0);
		instancia.setInicio(new DateTime());
		instancia.setTotalIngressos(1000);
		
	}
	
	public SessaoBuilder comDataInicio(DateTime dataInicio) {
		instancia.setInicio(dataInicio);
		return this;
	}
	
	public Sessao constroi(){
		return instancia;
	}
	
}
