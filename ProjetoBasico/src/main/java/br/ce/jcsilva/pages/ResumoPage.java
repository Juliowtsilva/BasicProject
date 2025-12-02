package br.ce.jcsilva.pages;

import org.openqa.selenium.By;

import br.ce.jcsilva.core.BasePage;

public class ResumoPage extends BasePage {
	
	private MenuPage menuPage = new MenuPage();

	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
		//div[@class='alert alert-success']
		//html/body/div[1]
	}
	
	
	public void fluxoRemoverMovimentacao() {
        menuPage.acessarTelaResumo();
		
		excluirMovimentacao();
	}
}
