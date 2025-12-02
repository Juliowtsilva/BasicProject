package br.ce.jcsilva.tests;

import org.junit.Test;

import org.junit.Assert;

import br.ce.jcsilva.core.BaseTest;
import br.ce.jcsilva.core.Propriedades;
import br.ce.jcsilva.pages.HomePage;
import br.ce.jcsilva.pages.MenuPage;

public class SaldoTest extends BaseTest {
	
	private HomePage page = new HomePage();
	private MenuPage menuPage = new MenuPage();

	@Test
	public void testSaldoConta() {
		menuPage.acessarTelaPrincipal();
		Assert.assertEquals("500.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}
}
