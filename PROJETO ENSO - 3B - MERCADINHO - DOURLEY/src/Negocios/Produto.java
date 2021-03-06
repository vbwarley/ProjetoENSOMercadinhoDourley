package Negocios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private int codProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private float precoProduto;
	private String unidadeProduto;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Método construtor de Produto, atribuindo valores iniciais a nome, descrição, preço, unidade
	 */
	public Produto (String nomeProduto, String descricaoProduto, float precoProduto, String unidadeProduto)
	{
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.precoProduto = precoProduto;
		this.unidadeProduto = unidadeProduto;
	}

	/**
	 *Atribui código ao produto
	 */
	public void setCodProduto(int codigo) {
		this.codProduto = codigo;
	}

	/**
	 * Retorna código do produto 
	 */
	public int getCodProduto() {
		return this.codProduto;
	}

	/**
	 * Retorna o nome do produto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}

	/**
	 * Retorna descrição do produto
	 */
	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	/** 
	 * Retorna o preco do produto
	 */
	public float getPrecoProduto() {
		return precoProduto;
	}

	/** 
	 * Retorna o unidade do produto
	 */
	public String getUnidadeProduto() {
		return unidadeProduto;
	}

	/**
	 * Consulta produto a partir do código.
	 */
	public static Produto consultarProduto(int codigo) {
		return Catalogo.consultarProduto(codigo);
	}
	
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public void setPrecoProduto(float precoProduto) {
		this.precoProduto = precoProduto;
	}

	public void setUnidadeProduto(String unidadeProduto) {
		this.unidadeProduto = unidadeProduto;
	}

	/**
	 * Retorna como string todos os valores dos atributos do produto
	 */
	public String toString()
	{
		String valores = (
				"Codigo: " + this.getCodProduto() + 
				"\nNome: "+this.getNomeProduto()+"\nDescrição: "+this.getDescricaoProduto()+
				"\nPreco: "+this.getPrecoProduto()+"\nUnidade: "+this.getUnidadeProduto() + "\n");
		return valores;
	}
}
