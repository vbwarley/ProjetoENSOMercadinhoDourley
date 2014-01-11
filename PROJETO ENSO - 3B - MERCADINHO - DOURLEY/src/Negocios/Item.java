package Negocios;


public class Item {

	private int codItem = 0;
	private int codProduto = 0;	
	private int codVenda = 0;
	private int qtdProduto;
	private float custo = 0;


	/**
	 * Método construtor de Item
	 */
	public Item (int codProduto, int qtdProduto)
	{ 
		this.codItem++;
		this.codProduto = codProduto;
		this.qtdProduto = qtdProduto;
	}

	/**
	 * Metodo para obter o valor de cada item
	 */
	public float obtemValorDoItem()
	{
		float resultado = Produto.consultarProduto(codProduto).getPrecoProduto() * this.qtdProduto;
		return resultado;
	}

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
	 * Retorna o codigo do produto
	 */
	public int getCodProduto() {
		return codProduto;
	}

	/**
	 * Atribui o codigo da venda associada
	 */
	public void setCodigoVenda(int codigo) {
		this.codVenda = codigo;
	}

	/**
	 * Retorna o codigo da venda associada
	 */
	public int getCodigoVenda() {
		return codVenda;
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
	public void setCusto() {
		this.custo = obtemValorDoItem();
	}

	/**
	 * Retorna o custo do item
	 */
	public float getCusto() {
		return custo;
	}

	/**
	 * Retorna uma string com os vlores do item
	 */
	public String toString() {
		return String.format("\n%s\t%d\t%.2f\n\n", Produto.consultarProduto(codProduto), qtdProduto, custo);
	}

}
