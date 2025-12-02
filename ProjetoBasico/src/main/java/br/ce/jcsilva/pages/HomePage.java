package br.ce.jcsilva.pages;


import br.ce.jcsilva.core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldoConta(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
		
	}

}
