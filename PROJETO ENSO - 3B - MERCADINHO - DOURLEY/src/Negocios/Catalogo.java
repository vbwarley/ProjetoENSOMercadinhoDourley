package Negocios;

import Persistencia.Banco;

public class Catalogo {

	/**
	 * Metodo para cadastro de novos produtos no catalogo
	 */
	public static void cadastrarProduto (Produto produto)
	{
		Banco.getInstance().salvarProduto(produto);

	}

	/**
	 * Método que mostra os dados no produto e ao lado o usuario escreve o novo valor para os atributos do objeto
	 */
	public static void alterarProduto (int codigoProduto, String nome, String descricao, float preco, String unidade)
	{	
	
		Produto produto = new Produto();
		
		produto.setCodProduto(codigoProduto);
		produto.setNomeProduto(nome);
		produto.setDescricaoProduto(descricao);
		produto.setPrecoProduto(preco);
		produto.setUnidadeProduto(unidade);
		
		Banco.getInstance().alterarProduto(produto);
	}

	/**
	 * Recebe codigoProduto Chave-primária do produto no BD, a qual será utilizada pra consultá-lo.
	 * Retorna Uma instância de Produto, se encontrado.
	 */
	public static Produto consultarProduto (int codigoProduto)
	{		
		return Banco.getInstance().consultarProduto(codigoProduto);
	}

	/**
	 * Recebe o código do produto para excluí-lo do Banco de dados
	 */
	public static void excluirProduto(int codigoProduto) {
		// atenção para caso de produto não cadastrado
		Banco.getInstance().excluirProduto(consultarProduto(codigoProduto).getCodProduto());		
	}
}
