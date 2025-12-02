package br.ce.jcsilva.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import br.ce.jcsilva.core.BaseTest;
import br.ce.jcsilva.core.Propriedades;
import br.ce.jcsilva.pages.MenuPage;
import br.ce.jcsilva.pages.MovimentacaoPage;
import br.ce.jcsilva.utils.DataUtils;
import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Rule
	public TestName testName = new TestName();
	
	
	@Test
	public void test1_InserirMovimentacao() {
    //movPage.cadastrarMovimentacao();
		
		menuPage.acessarTelaInserirMovimentação();
		movPage.setDataMovimentacao("02/04/2025");
		movPage.setDataPagamento("02/02/2027");
		movPage.setDescricao("Descrição Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		//movPage.situacao("status_pago");
		movPage.salvar();
			
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    
		
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		//movPage.salvarComCamposVazios();
		
		menuPage.acessarTelaInserirMovimentação();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		// Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
		// Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", 
				"Data do pagamento é obrigatório", 
				"Descrição é obrigatório",
				"Interessado é obrigatório", 
				"Valor é obrigatório", 
				"Valor deve ser um número"
				)));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3_InserirMovimentacaoFutura() {
		//movPage.cadastrarMovimentacao();
		
		 Date dataFuturaMovimentacao = DataUtils.obterDataComDiferencaDias(5);
		 Date dataFuturaPagamento = DataUtils.obterDataComDiferencaDias(8);
		// new Date()
		
				menuPage.acessarTelaInserirMovimentação();
				movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFuturaMovimentacao));
				movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFuturaPagamento));
				movPage.setDescricao("Descrição Teste");
				movPage.setInteressado("Interessado Qualquer");
				movPage.setValor("500");
				movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
				movPage.setStatusPago();
				//movPage.situacao("status_pago");
				movPage.salvar();
					
				//Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movPage.obterMensagemErro());
				
				List<String> erros = movPage.obterErros();
				// Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
				// Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
				Assert.assertTrue(erros.contains(
						"Data da Movimentação deve ser menor ou igual à data atual"
						));
				Assert.assertEquals(1, erros.size());
	}
}
