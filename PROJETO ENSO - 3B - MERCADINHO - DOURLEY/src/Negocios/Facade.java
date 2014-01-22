package Negocios;

import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Persistencia.Banco;

public class Facade {

	private static Facade instance = new Facade();
	private static Venda venda = null;
	
	private Facade() {
		
	}
	
	public static Facade getInstance() {
		return instance;
	}

	/**
	 * Método para cadatrar produtos, chamando o método cadastrarProduto de
	 * catálogo e passando a instancia de produto criada como parâmetro.
	 **/
	public void cadastrarProduto(String nomeProduto, String descricaoProduto,
			float precoProduto, String unidadeProduto) {

		Produto produto = new Produto(nomeProduto, descricaoProduto, precoProduto, unidadeProduto);
		Catalogo.cadastrarProduto(produto);
	}

	/**
	 * Recebe o codigo do produto para alterar seus atributos
	 * Retorna o boolean confirmando se foi ou não alterado
	 */
	public void alterarProduto(int codigoProduto, String nome, String descricao, float preco, String unidade) {

		Catalogo.alterarProduto(codigoProduto, nome, descricao, preco, unidade);
		
	}

	/**
	 *Recebe um código de produto para consulta-lo no banco de dados
	 *Retorna uma string com os dados do produto
	 */
	public String consultarProduto(int codigoProduto) {
		Produto produto = Catalogo.consultarProduto(codigoProduto);

		return produto.toString();
	}
	
	public float calcularCusto(int codigo, int quantidade){
		
		float custo = 0;
		
		Produto produto = Catalogo.consultarProduto(codigo);
		
		custo = produto.getPrecoProduto()*quantidade;
		
		return custo;
		
	}
	
	public Produto verificarProduto(int codigo){
		
		return Catalogo.consultarProduto(codigo);
		
	}
	
	

	public String detalharVenda(int codigo){
	
		Venda venda = Banco.getInstance().retornarVenda(codigo);
		
		String informacaoVenda = "";
		
		if (venda != null)
			informacaoVenda = venda.mostrarItens();
			
		
		return informacaoVenda;
		
	}
	
	/**
	 *Recebe um código referente a um produto para excluí-lo do Banco de dados 
	 */
	public boolean excluirProduto(int codigoProduto) {
		return Catalogo.excluirProduto(codigoProduto);
	}

	/**
	 * Método para instanciar uma nova venda
	 */
	public void novaVenda() {
		venda = new Venda();
		venda.novosItens();
	}

	/**
	 * Salva a venda no Banco de dados
	 */
	public void cadastrarVenda() {
		Venda.salvarVenda(venda);
	}

	/**
	 *Consulta vendas de uma determinada data 
	 */
	public String consultarVenda(Date data) {
		return Venda.consultar(data);
	}

	/**
	 * Inserir item a uma venda, recebendo como parâmetros o código e a quantidade do determinado produto
	 */
	public void inserirItemVenda(int codigo, int quantidade) {
		venda.insereItem(codigo, quantidade);
	}

	/**
	 * Calcula o valor total da venda
	 */
	public float valorTotal() {
		return venda.getTotal();
	}

	/**
	 *Atribui o custo total de uma venda 
	 */
	public void setTotalVenda(float total) {
		venda.setTotal(total);
	}

	public void setTroco(float troco) {
		venda.setTroco(troco);
	}
	
	/**
	 * Atribui o pagamento recebido pela venda
	 */
	public void setPagamentoVenda(float pagamento) {
		venda.setPagamentoRecebido(pagamento);
	}
	
	public float getTroco() {
		return venda.getTroco();
	}
}
