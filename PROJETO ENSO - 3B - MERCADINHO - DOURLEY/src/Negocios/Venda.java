package Negocios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Persistencia.Banco;

@Entity
public class Venda {

	@Id
	@GeneratedValue
	@Column(nullable=false)
	private int codVenda = 0;
	private float pagamentoRecebido = 0;
	private float troco;
	private float total = 0;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="venda")
	private List<Item> itens = new ArrayList<Item>();

	/**
	 * Construtor da classe venda
	 */
	public Venda() {
		this.data = new Date(System.currentTimeMillis());
	}
	
	/**
	 * retorna a data
	 */
	public String getData() {
		return data.toString();
	}

	/**
	 * retorna the codigo de identificacao
	 */
	public int getCodVenda() {
		return codVenda;
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
	public void setCodIdentificacao(int codVenda) {
		this.codVenda = codVenda;
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
	
		for (Item i : itens) {
			this.total += i.getCusto(); 
		}
		
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
		Collection<Venda> vendasRetornadas = Banco.getInstance()
				.consultarVenda(data.toString());

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
	 * Metodo para inserção de itens na compra (método mais foda que fiz na
	 * minha vida)
	 * 
	 * @author Warley
	 */
	public void insereItem(int codigoProduto, int quantidade) {
		Produto p = Banco.getInstance().consultarProduto(codigoProduto);
		if (p != null) {
			Item item = new Item(p, quantidade);
			if (itens.isEmpty()) {
				itens.add(item);
				itens.get(itens.lastIndexOf(item)).setVenda(this); // PORRA, ESSA LINHA!! LEMBRE-SE SEMPRE DESSA LINHA!
			} else {
				for (Item i : itens) {
					if (i.getProduto().equals(p)) {
						i.setQtdProduto(quantidade);
						break;
					} else if (itens.get(itens.size() - 1) == i) {
						Item item2 = new Item(p, quantidade);
						itens.add(item2);
						itens.get(itens.lastIndexOf(item2)).setVenda(this); // PORRA, ESSA LINHA!! LEMBRE-SE SEMPRE DESSA LINHA!

						break;
					}	
				}
			}
		}
	}

	/**
	 * Salvar os itens no Banco de dados chamando a persistencia e associando o
	 * código da venda em questão aos itens.
	 */
	public void salvarItem() {
//		for (Item i : itens) {
//			i.setCodigoVenda(this.codIdentificacao);
//			i.setCusto();
//			Banco.getInstance().salvarItem(i);
//		}
	}

	/**
	 * Consulta no banco de dados, atravez da persistência, os itens
	 * relacionado ao codigo da venda passado como parâmetro.
	 */
	public String mostrarItens() {
		
		String dadosItens = "Venda: " + codVenda + "\t Data: " + data
				+ "\n\nProduto\tQuantidade\tCusto";

		for (Item i : itens)
			dadosItens += i.toString();

		dadosItens += "\nTotal da Venda: " + total + "\nPagamento Recebido: "
				+ pagamentoRecebido + "\nTroco: " + troco;

		return dadosItens;
	}

	/**
	 * Método para obtensão do custo total da venda
	 */
//	public float obtemValorTotal() {
//		float valor = 0;
//
//		for (Item i : itens) {
//			valor += i.obtemValorDoItem();
//		}
//
//		return valor;
//	}

	/**
	 * Método para obtensão do troco da venda
	 */
	public float getTroco() {

		if (this.pagamentoRecebido >= total) {
			this.troco = this.pagamentoRecebido - total;
		} else if (this.pagamentoRecebido < total) {
			this.troco = 0;
		}

		return this.troco;
	}
	
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	/**
	 * Método que retorna os dados da venda como uma string
	 */
	public String toString() {
		return String.format("%d\t%s\t%.2f\t%.2f\t%.2f\n", codVenda,
				data.toString(), total, pagamentoRecebido, troco);
	}
}