package Negocios;

import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Persistencia.Banco;


public class Venda {

	//Formato em que a data deve ser apresentada
	DateFormat formatoDaData = new SimpleDateFormat("yy/MM/dd");
	private Date data; 
	private int codIdentificacao;
	private float pagamentoRecebido = 0;
	private float troco;
	private float total;

	//instancia de um item, para realização da venda de um Item
	private static ArrayList<Item> itens;


	/**
	 * Construtor da classe venda
	 */
	public Venda()
	{		
		Date data = new Date();
		this.data = data;
	}

	/**
	 * retorna a data
	 */
	public String getData() {
		//Determinando que o formato da hora foi o predeterminado no inicio (dd/MM/yy)
		String dataString = formatoDaData.format(data);

		return dataString;
	}



	/**
	 * retorna the codigo de identificacao
	 */
	public int getCodIdentificacao() {
		return codIdentificacao;
	}

	/**
	 * retorna o pagamento recebido 
	 */
	public float getPagamentoRecebido() {
		return pagamentoRecebido;
	}

	/**
	 * Atribui o pagamento recebido à venda
	 */
	public void setPagamentoRecebido(float pagamentoRecebido) {
		this.pagamentoRecebido = pagamentoRecebido;
	}


	/**
	 * Atribui data à venda
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Atribui codIdentificacao à venda
	 */
	public void setCodIdentificacao(int codIdentificacao) {
		this.codIdentificacao = codIdentificacao;
	}

	/**
	 * Atribui total à venda
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * Atribui troco a venda
	 */
	public void setTroco(float troco) {
		this.troco = troco;
	}

	/**
	 * Retorna o total da venda
	 */
	public float getTotal() {
		return total;
	}

	public void novosItens() {
		itens = new ArrayList<Item>();
	}

	/**
	 * Salvar venda chamando a persistência
	 */
	public static void salvarVenda(Venda venda) {
		Banco.getInstance().salvarVenda(venda);
	}

	/**
	 * Consulta vendas a partir da data em que aconteceram
	 */
	public static String consultar(Date data) {
		ArrayList<Venda> vendasRetornadas;
		vendasRetornadas = Banco.getInstance().consultarVenda(data.toString());

		String vendas = "Venda\tData\tTotal\tPagamento\tTroco\n\n";

		if (vendasRetornadas.isEmpty()) 
			vendas = "";		

		for (Venda v : vendasRetornadas) 
			vendas += v.toString();


		return vendas;
	}


	/**
	 * Retorna uma venda a partir do banco de dados
	 */
	public static Venda retornarVenda(int codigo) {
		return Banco.getInstance().retornarVenda(codigo);
	}

	/**
	 *Metodo para inserção de itens na compra (método mais foda que fiz na minha vida)
	 *@author Warley
	 */
	public void insereItem (int codigoProduto, int quantidade)
	{
		if (Banco.getInstance().consultarProduto(codigoProduto) != null) {
			if (itens.isEmpty()) {
				itens.add(new Item(codigoProduto, quantidade));
			} else {
				for (Item i : itens) {
					if (i.getCodProduto() == codigoProduto) {
						i.setQtdProduto(quantidade);
						break;
					} else if (itens.get(itens.size() - 1) == i) {
						itens.add(new Item(codigoProduto, quantidade));
						break;
					}
				}
			}
		}
	}

	/**
	 * Salvar os itens no Banco de dados chamando a persistencia e associando o código da venda em questão aos itens.
	 */
	public void salvarItem() {
		for (Item i : itens) {
			i.setCodigoVenda(this.codIdentificacao);
			i.setCusto();
			Banco.getInstance().salvarItem(i);
		}
	}

	/**
	 * Consulta no banco de dados, atravez da persistência,
	 * os itens relacionado ao codigo da venda passado como parâmetro.
	 */
	public String consultarItem(int codigoVenda) {
		ArrayList<Item> itensRetornados;
		itensRetornados = Banco.getInstance().consultarItens(codigoVenda);

		String dadosItens = "Venda: " + codigoVenda + "\t Data: " + data + "\n\nProduto\tQuantidade\tCusto";

		for (Item i : itensRetornados) 
			dadosItens += i.toString();

		dadosItens += "\nTotal da Venda: " + total + "\nPagamento Recebido: " + pagamentoRecebido + "\nTroco: " + troco;

		return dadosItens;
	}

	/**
	 * Método para obtensão do custo total da venda
	 */
	public float obtemValorTotal()
	{
		float valor = 0;

		for (Item i : itens) {
			valor += i.obtemValorDoItem();
		}

		return valor;
	}


	/**
	 * Método para obtensão do troco da venda
	 */
	public float getTroco() {

		if (this.pagamentoRecebido >= total){
			this.troco = this.pagamentoRecebido - total;
		} else if(this.pagamentoRecebido < total){
			this.troco = 0;
		}

		return this.troco;
	}

	/**
	 * Método que retorna os dados da venda como uma string
	 */
	public String toString() {
		return String.format("%d\t%s\t%.2f\t%.2f\t%.2f\n", codIdentificacao, data.toString(), total, pagamentoRecebido, troco);
	}
}