package br.com.caelum.agiletickets.models;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

public class EspetaculoTest {

	/**
	 * @throws Exception
	 */
	@Test
	public void deveCriarSessaoDiariaComUmDia() throws Exception {
		LocalDateTime data = new LocalDateTime(2011, 12, 7, 17, 30, 0); 

		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(data.toLocalDate(), data.toLocalDate(), data.toLocalTime(), Periodicidade.DIARIA);
		
		Assert.assertNotNull(sessoes);
		
		Assert.assertEquals(1, sessoes.size());
		
		Assert.assertEquals(data, sessoes.get(0).getInicio().toLocalDateTime());
	}
	
	
	@Test(expected=Exception.class)
	public void naoDeveCriarSessoesComDataDeInicioPosteriorAoFim() throws Exception {
		LocalDateTime dataInicio = new LocalDateTime(2011, 12, 7, 17, 30, 0); 
		LocalDateTime dataFim    = new LocalDateTime(2011, 12, 5, 17, 30, 0); 

		Espetaculo espetaculo = new Espetaculo();
		
		espetaculo.criaSessoes(dataInicio.toLocalDate(), dataFim.toLocalDate(), dataInicio.toLocalTime(), Periodicidade.DIARIA);
	}
	
	@Test
	public void deveCriarSessaoDiariaComMaisDeUmDia() throws Exception {
		LocalDateTime dataInicio = new LocalDateTime(2011, 12, 1, 17, 30, 0); 
		LocalDateTime dataFim    = new LocalDateTime(2011, 12, 5, 17, 30, 0); 

		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(dataInicio.toLocalDate(), dataFim.toLocalDate(), dataInicio.toLocalTime(), Periodicidade.DIARIA);

		
		Assert.assertNotNull(sessoes);
		
		Assert.assertEquals(5, sessoes.size());
		
		Assert.assertEquals(dataInicio, sessoes.get(0).getInicio().toLocalDateTime());
		Assert.assertEquals(dataFim, sessoes.get(4).getInicio().toLocalDateTime());
	}
	
	@Test
	public void deveCriarSessoesSemanaisComUmDia() throws Exception {
		LocalDateTime dataInicio = new LocalDateTime(2011, 12, 1, 17, 30, 0); 
		LocalDateTime dataFim    = new LocalDateTime(dataInicio); 

		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(dataInicio.toLocalDate(), dataFim.toLocalDate(), dataInicio.toLocalTime(), Periodicidade.SEMANAL);

		
		Assert.assertNotNull(sessoes);
		
		Assert.assertEquals(1, sessoes.size());
		
		Assert.assertEquals(dataInicio, sessoes.get(0).getInicio().toLocalDateTime());
		Assert.assertEquals(dataFim, sessoes.get(0).getInicio().toLocalDateTime());
	}
	
	@Test
	public void deveCriarSessoesSemanaisComMenosDeUmaSemana() throws Exception {
		LocalDateTime dataInicio = new LocalDateTime(2011, 12, 1, 17, 30, 0);
		LocalDateTime dataFim    = new LocalDateTime(2011, 12, 6, 17, 30, 0);

		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(dataInicio.toLocalDate(), dataFim.toLocalDate(), dataInicio.toLocalTime(), Periodicidade.SEMANAL);

		
		Assert.assertNotNull(sessoes);
		
		Assert.assertEquals(1, sessoes.size());
		
		Assert.assertEquals(dataInicio, sessoes.get(0).getInicio().toLocalDateTime());
	}

	@Test
	public void deveCriarSessoesSemanaisComMaisDeUmaSemana() throws Exception {
		LocalDateTime dataInicio = new LocalDateTime(2011, 12, 1, 17, 30, 0);
		LocalDateTime dataFim    = new LocalDateTime(2011, 12, 21, 17, 30, 0);

		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(dataInicio.toLocalDate(), dataFim.toLocalDate(), dataInicio.toLocalTime(), Periodicidade.SEMANAL);

		
		Assert.assertNotNull(sessoes);
		
		Assert.assertEquals(1, sessoes.size());
		
		Assert.assertEquals(dataInicio, sessoes.get(0).getInicio().toLocalDateTime());
	}

}
