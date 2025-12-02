package br.ce.jcsilva.tests;

import org.junit.Test;

import br.ce.jcsilva.core.BaseTest;
import br.ce.jcsilva.core.Propriedades;
import br.ce.jcsilva.pages.ContasPage;
import br.ce.jcsilva.pages.MenuPage;
import org.junit.Assert;

public class RemoverMovimentacaoContaTest extends BaseTest {
	
	private ContasPage contasPage = new ContasPage();
	private MenuPage menuPage = new MenuPage();
	
	@Test
	public void removerContaComMovimentacao() {
		// contasPage.excluirContaComMovimentacao();
		
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErroExcluir());
	}
	
	/*************
	@Test
	public void removerConta() {
		// contasPage.excluirConta();
		
		menuPage.acessarTelaListarConta();
        contasPage.clicarExcluirConta("Conta do Teste Alterada");
        
        Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemExcluirSucesso());
	}
	*********/
}
