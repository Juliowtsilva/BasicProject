package br.ce.jcsilva.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.jcsilva.core.BasePage;
import br.ce.jcsilva.core.DriverFactory;

public class MovimentacaoPage extends BasePage {

	private MenuPage menuPage = new MenuPage();
	

	public void setTipoMovimentacao(By opcao) {
		selecionarCombo("tipo", null);
		clicarOpcoesCombo(opcao);
	}
	
	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	public void setOutraDataMovimentacao(String dia, String mes, String ano){
		criarData("data_transacao", dia, mes, ano);
	}
	
	public void setDataPagamento(String data){
	    escrever("data_pagamento", data);
	}
	
	public void setOutraDataPagamento(String dia, String mes, String ano){
	    criarData("data_pagamento", dia, mes, ano);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}

	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void setStatusPago() {
		clicarRadio("status_pago");
	}
	
	public void setStatusPendente() {
		clicarRadio("status_pendente");
	}
	
	public void situacao(String id) {
		clicarRadio(id);
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
		//clicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
		//div[@class='alert alert-success']
		//html/body/div[1]
	}
	
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
		///html/body/div[1]/ul/li
	}
	
	public void cadastrarMovimentacao() {
		menuPage.acessarTelaInserirMovimentação();
		//setTipoMovimentacao();
		setDataMovimentacao("02/05/2024");
		setDataPagamento("02/02/2025");
		setDescricao("Descrição Teste");
		setInteressado("Interessado Qualquer");
		setValor("500");
		setConta("Conta do Teste Alterada");
		setStatusPago();
		//situacao("status_pago");
		salvar();
	}
	
	public List<String> obterErros(){
		List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		
		return retorno;
	}
	
	public void salvarComCamposVazios() {
		menuPage.acessarTelaInserirMovimentação();
		salvar();
	}
}
