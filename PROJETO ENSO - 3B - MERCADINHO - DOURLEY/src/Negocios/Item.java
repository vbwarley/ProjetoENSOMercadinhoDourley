package Negocios;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ItemVenda")
public class Item {
	@Id
	@GeneratedValue
	private int codItem = 0;
	
	private int qtdProduto = 0;
	private float custo = 0;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codProduto", nullable=false)
	private Produto produto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codVenda", nullable=false)
	private Venda venda;

	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Método construtor de Item
	 */
	public Item (Produto produto, int qtdProduto) { 
		//this.codItem++;
		this.produto = produto;
		this.qtdProduto = qtdProduto;
		this.custo = produto.getPrecoProduto() * this.qtdProduto;
	}

	/**
	 * Metodo para obter o valor de cada item
	 */
//	public float obtemValorDoItem()
//	{
//		float resultado = Produto.consultarProduto(codProduto).getPrecoProduto() * this.qtdProduto;
//		return resultado;
//	}

	/**
	 * Retorna o codigo do item
	 */
	public int getCodItem() {
		return codItem;
	}

	/**
	 * retorna a quantidade do produto
	 */
	public int getQtdProduto() {
		return qtdProduto;
	}

	/**
	 * Atribui a quantidade do produto
	 */
	public void setQtdProduto(int qtd) {
		this.qtdProduto += qtd;
	}

	
	/**
	 * Atribui o custo do item (recebendo o custo como parâmetro)
	 */
	public void setCusto(float custo) {
		this.custo = custo;
	}

	/**
	 * Calcula o custo do item e o atribui ao atributo "custo";
	 */
//	public void setCusto() {
//		this.custo = obtemValorDoItem();
//	}

	/**
	 * Retorna o custo do item
	 */
	public float getCusto() {
		return custo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}
	
	
	
	/**
	 * Retorna uma string com os vlores do item
	 */
	public String toString() {
		
		return String.format("\n%s\t%d\t%.2f\n\n", produto.toString(), qtdProduto, custo);
	}

}
