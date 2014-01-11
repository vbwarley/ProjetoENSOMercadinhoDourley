package Negocios;

import javax.swing.JOptionPane;
import Persistencia.Banco;

public class Catalogo {

	/**
	 * Metodo para cadastro de novos produtos no catalogo
	 */
	public static void cadastrarProduto (Produto produto)
	{
		produto.setCodProduto(Banco.getInstance().salvarProduto(produto));

	}

	/**
	 * Método que mostra os dados no produto e ao lado o usuario escreve o novo valor para os atributos do objeto
	 */
	public static Produto alterarProduto (int codigoProduto)
	{	
		Produto produtoRetornado = null;
		produtoRetornado = consultarProduto(codigoProduto);

		if (produtoRetornado != null) {
			int opcao = JOptionPane.showConfirmDialog(null, "Você está prestes a alterar o produto com a seguinte descrição: \n\n" 
					+ produtoRetornado.toString() + "\n\n"
					+ "Deseja realmente alterar esse produto?");

			if (opcao == JOptionPane.YES_OPTION) {
				try {

					String nome = JOptionPane.showInputDialog("Digite o novo nome do produto: ").toString();
					String desc = JOptionPane.showInputDialog("Digite a nova descrição do produto: ").toString();
					float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o novo preço do produto: ").toString());
					String unidade = JOptionPane.showInputDialog("Digite a nova unidade do produto: ").toString();


					if (!nome.isEmpty() && desc.length() > 10 && preco > 0 && !unidade.isEmpty()) {
						Banco.getInstance().alterarProduto(produtoRetornado.getCodProduto(), nome, desc, preco, unidade);
					} else {
						JOptionPane.showMessageDialog(null, "Os dados estão incorretos. Por favor, tente novamente.");
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção dos valores. Por favor, tente novamente.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Produto não alterado.");
				produtoRetornado = null;
			}
		}

		return produtoRetornado;
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
