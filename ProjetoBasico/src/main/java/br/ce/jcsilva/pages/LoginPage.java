package br.ce.jcsilva.pages;


import br.ce.jcsilva.core.BasePage;
import br.ce.jcsilva.core.DriverFactory;

public class LoginPage extends BasePage {
	

	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
		//clicarBotao(By.xpath("//button[.='Entrar']"));
	}   //button[.='Entrar']
	
	public void logar(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
}
