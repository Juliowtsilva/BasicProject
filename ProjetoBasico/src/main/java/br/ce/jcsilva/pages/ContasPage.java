package br.ce.jcsilva.pages;

import java.util.Random;

import org.openqa.selenium.By;

import br.ce.jcsilva.core.BasePage;


public class ContasPage extends BasePage {
	
	private MenuPage menuPage = new MenuPage();
	

	public void setNome(String nome) {
		escrever("nome", nome);
	}
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
		//menuPage.clicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public String obterMensagemSucesso() {
		return menuPage.obterTexto(By.xpath("//div[@class='alert alert-success']"));
		//div[@class='alert alert-success']
		//html/body/div[1]
	}
	
	
	public String obterMensagemAlteradoSucesso() {
		return obterTexto(By.xpath("/html/body/div[@class='alert alert-success']"));
		///html/body/div[1]
	}
	
	public String obterMensagemExcluirSucesso() {
		return menuPage.obterTexto(By.xpath("//div[@class='alert alert-success']"));
		//div[@class='alert alert-success']
		//html/body/div[1]
	}
	
	public String obterMensagemErro() {
		return obterTexto(By.xpath("/html/body/div[@class='alert alert-danger']"));
		///html/body/div[1]
	}
	
	public String obterMensagemErroExcluir() {
		return obterTexto(By.xpath("/html/body/div[@class='alert alert-danger']"));
		///html/body/div[1]
	}
	
	public void cadastrarConta() {
		menuPage.acessarTelaInserirConta();
		setNome("Conta Júlio "+ Integer.toString(((new Random().nextInt(10))+1)));
		salvar();
		
		//Assert.assertEquals("Conta adicionada com sucesso!", obterMensagemSucesso());
		
	}
	
	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas").
		findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		// /html/body/table/tbody/tr[2]/td[2]/a[1]/span
	}
	
	public void alterarConta() {
		menuPage.acessarTelaListarConta();
        clicarAlterarConta("Conta Júlio");
		setNome("Conta Júlio Alterada"+ Integer.toString(((new Random().nextInt(10))+1)));
		salvar();
		
		///html/body/table/tbody/tr/td[2]/a[1]/span
		///
	}
	
	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas").
		findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
		///html/body/table/tbody/tr[2]/td[2]/a[2]/span
	}
	
	public void excluirConta() {
		menuPage.acessarTelaListarConta();
        clicarExcluirConta("Conta do Teste");
		
		///html/body/table/tbody/tr/td[2]/a[1]/span
		///
	}
	
	public void excluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
        clicarExcluirConta("Conta do Teste Alterada");
		
		///html/body/table/tbody/tr/td[2]/a[1]/span
		///
	}
	
}
