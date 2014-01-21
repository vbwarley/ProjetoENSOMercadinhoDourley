package Negocios;

import javax.swing.JOptionPane;
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
		Produto produtoRetornado;
		produtoRetornado = Banco.getInstance().consultarProduto(codigoProduto);

		if (produtoRetornado == null) {
			JOptionPane.showMessageDialog(null, "Produto não encontrado!");
		} 

		return produtoRetornado;
	}

	/**
	 * Recebe o código do produto para excluí-lo do Banco de dados
	 */
	public static void excluirProduto(int codigoProduto) {
		Produto produtoRetornado;
		produtoRetornado = consultarProduto(codigoProduto);

		if (produtoRetornado != null) {
			int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o "+ produtoRetornado.getNomeProduto() +"?");

			if (opcao == JOptionPane.YES_OPTION) {
				if (Banco.getInstance().excluirProduto(produtoRetornado.getCodProduto())) {
					JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Produto não foi excluído.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "O produto não foi exclúido.");
			}
		}
	}
}
