package Negocios;

import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Facade {

	private static Venda venda = null;

	/**
	 * Método para cadatrar produtos, chamando o método cadastrarProduto de
	 * catálogo e passando a instancia de produto criada como parâmetro.
	 **/
	public static void cadastrarProduto(String nomeProduto, String descricaoProduto,
			float precoProduto, String unidadeProduto) {

		Produto produto = new Produto(nomeProduto, descricaoProduto,
				precoProduto, unidadeProduto);
		Catalogo.cadastrarProduto(produto);
	}

	/**
	 * Recebe o codigo do produto para alterar seus atributos
	 * Retorna o boolean confirmando se foi ou não alterado
	 */
	public static boolean alterarProduto(int codigoProduto) {

		Produto produtoRetornado = Catalogo.alterarProduto(codigoProduto);
		boolean retornou = false;

		if (produtoRetornado != null)
			retornou = true;

		return retornou;
	}

	/**
	 *Recebe um código de produto para consulta-lo no banco de dados
	 *Retorna uma string com os dados do produto
	 */
	public static String consultarProduto(int codigoProduto) {
		Produto produto = Catalogo.consultarProduto(codigoProduto);
		String dadosProduto = "";

		if (produto != null) {
			dadosProduto = produto.toString();
		}

		return dadosProduto;
	}

	/**
	 *Recebe um código referente a um produto para excluí-lo do Banco de dados 
	 */
	public static void excluirProduto(int codigoProduto) {
		Catalogo.excluirProduto(codigoProduto);
	}

	/**
	 * Método para instanciar uma nova venda
	 */
	public static void novaVenda() {
		venda = new Venda();
		venda.novosItens();
	}

	/**
	 * Salva a venda no Banco de dados
	 */
	public static void cadastrarVenda() {
		Venda.salvarVenda(venda);
	}

	/**
	 *Consulta vendas de uma determinada data 
	 */
	public static void consultarVenda(Date data) {
	
		String vendaConsultada = Venda.consultar(data);

		if (!vendaConsultada.isEmpty()) {
			JOptionPane.showMessageDialog(null, new JTextArea(vendaConsultada + "\n"));
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código da venda a qual deseja detalhar: \n").toString());

			venda = Venda.retornarVenda(codigo);
			JOptionPane.showMessageDialog(null, new JTextArea(venda.consultarItem(codigo)));
		} else {
			JOptionPane.showMessageDialog(null, "Não foi encontrada nenhuma venda na data: " + data);
		}
	}

	/**
	 * Inserir item a uma venda, recebendo como parâmetros o código e a quantidade do determinado produto
	 */
	public static void inserirItemVenda(int codigo, int quantidade) {
		venda.insereItem(codigo, quantidade);
	}

	/**
	 * Salvar itens da venda
	 */
	public static void salvarItens() {
		venda.salvarItem();
	}

	/**
	 * Calcula o valor total da venda
	 */
	public static float valorTotal() {
		return venda.getTotal();
	}

	/**
	 *Atribui o custo total de uma venda 
	 */
	public static void setTotalVenda(float total) {
		venda.setTotal(total);
	}

	/**
	 * Atribui o pagamento recebido pela venda
	 */
	public static void setPagamentoVenda(float pagamento) {
		venda.setPagamentoRecebido(pagamento);
	}
}
