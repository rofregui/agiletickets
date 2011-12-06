package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {

	private Sessao s;
	
	@Before
	public void inicializa(){
		this.s = new Sessao();
	}
	

	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
        this.s.setTotalIngressos(2);

        Assert.assertTrue(this.s.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		this.s.setTotalIngressos(2);

		Assert.assertFalse(this.s.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		this.s.setTotalIngressos(5);

		this.s.reserva(3);
		Assert.assertEquals(2, this.s.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void deveVenderTodosIngressosDisponiveis() throws Exception {
		this.s.setTotalIngressos(4);
		
		Assert.assertTrue(this.s.podeReservar(4));
	}
	
	@Test
	public void deveVenderTodosIngressosDisponiveisZero() throws Exception {
		this.s.setTotalIngressos(0);
		
		Assert.assertTrue(this.s.podeReservar(0));
	}
}
