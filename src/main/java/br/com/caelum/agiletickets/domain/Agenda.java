package br.com.caelum.agiletickets.domain;

import java.util.List;

import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.agiletickets.models.Sessao;

public interface Agenda {

	List<Espetaculo> listarEspetaculos();

	void cadastra(Espetaculo espetaculo);

	List<Sessao> listarProximasSessoes(int maximo);

	Sessao obterSessao(Long sessaoId);

	Espetaculo obterEspetaculo(Long espetaculoId);

	void agende(List<Sessao> sessoes);

}
