package br.ce.jcsilva.tests;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import br.ce.jcsilva.core.BaseTest;
import br.ce.jcsilva.core.Propriedades;
import br.ce.jcsilva.pages.ContasPage;
import br.ce.jcsilva.pages.LoginPage;
import br.ce.jcsilva.pages.MenuPage;
import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();
	
	@Rule
	public TestName testName = new TestName();
	
	
	@Test
	public void test1_InserirConta() {
    //contasPage.cadastrarConta();
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    
		
	}
	
	@Test
	public void test2_AlterarConta() {
		//contasPage.alterarConta();
		
		
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do Teste");
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemAlteradoSucesso());
	}
	
	@Test
	public void test3_InserirContaMesmoNome() {
    //contasPage.cadastrarConta();
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    
		
	}
	
	/************* Ordem de Testes Alterada
	@Test
	public void removerConta() {
		// contasPage.excluirConta();
		
		menuPage.acessarTelaListarConta();
        contasPage.clicarExcluirConta("Conta do Teste");
        
        Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemExcluirSucesso());
	}

	
	@Test
	public void removerContaComMovimentacao() {
		// contasPage.excluirContaComMovimentacao();
		
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta("Conta do Teste Alterada");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErroExcluir());
	}
	
		******/
	
}
