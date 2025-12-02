package br.ce.jcsilva.tests;

import static br.ce.jcsilva.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import br.ce.jcsilva.core.BasePage;
import br.ce.jcsilva.core.BaseTest;
import br.ce.jcsilva.pages.MenuPage;
import br.ce.jcsilva.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ResumoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	private BasePage basePage = new BasePage();
	
	@Test
	public void test1_ExcluirMovimentacao() {
	// resumoPage.fluxoRemoverMovimentacao();
		
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
				
		// Movimentação removida com sucesso!
	}
	
	@Test
	public void test2_ResumoMensal() {
		
		menuPage.acessarTelaResumo();
		Assert.assertEquals("Seu Barriga - Extrato", resumoPage.obterTitulo());
		
		java.util.List<WebElement> elementosEncontrados = getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());

		/***
		try {
		getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.fail();
		} catch(org.openqa.selenium.NoSuchElementException e) {
			
		}
		***/
	}

}
