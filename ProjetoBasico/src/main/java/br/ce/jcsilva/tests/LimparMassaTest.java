package br.ce.jcsilva.tests;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.jcsilva.core.BaseTest;
import br.ce.jcsilva.core.Propriedades;
import br.ce.jcsilva.pages.ContasPage;
import br.ce.jcsilva.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LimparMassaTest extends BaseTest {
	
	private ContasPage contasPage = new ContasPage();
	private MenuPage menuPage = new MenuPage();

	@Test
	public void test1_RemoverConta() {
		// contasPage.excluirConta();
		
		menuPage.acessarTelaListarConta();
        contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
        
        Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemExcluirSucesso());
	}
}
