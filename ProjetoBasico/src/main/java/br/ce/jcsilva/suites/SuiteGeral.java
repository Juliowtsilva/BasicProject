package br.ce.jcsilva.suites;

import static br.ce.jcsilva.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.jcsilva.core.DriverFactory;
import br.ce.jcsilva.pages.LoginPage;
import br.ce.jcsilva.tests.ContaTest;
import br.ce.jcsilva.tests.MovimentacaoTest;
import br.ce.jcsilva.tests.LimparMassaTest;
import br.ce.jcsilva.tests.RemoverMovimentacaoContaTest;
import br.ce.jcsilva.tests.ResumoTest;
import br.ce.jcsilva.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class,
	LimparMassaTest.class
})

public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {

	
	page.acessarTelaInicial();
	
	//page.setEmail("email@email123456.com");
	//page.setSenha("123456");
	//page.entrar();
	page.logar("9sR2uAMOgeOpBNZ@email.com", "9sR2uAMOgeOpBNZ");
	
	}
	
	@AfterClass
	public static void finaliza() {
		killDriver();
	}

}
