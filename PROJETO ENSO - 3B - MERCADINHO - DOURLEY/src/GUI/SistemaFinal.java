package GUI;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Negocios.Facade;

public class SistemaFinal {

	/**
	 * Cadastro de uma Venda.
	 * @author barbosa, maximo
	 * @param codigos Lista de códigos de produtos para inserir na venda.
	 * @param quantidades Lista de quantidades de produtos (relacionadas a cada código).
	 * @param pagamento Pagamento recebido pela venda feita.
	 * @param total Total da venda.
	 * @param troco Troco do cliente.
	 **/
	public static void cadastrarVenda(ArrayList<Integer> codigos, ArrayList<Integer> quantidades, float pagamento, float total, float troco) {
		Facade.getInstance().novaVenda();

		for (int i = 0; i < codigos.size(); i++) 
			Facade.getInstance().inserirItemVenda(codigos.get(i), quantidades.get(i));

		Facade.getInstance().setPagamentoVenda(pagamento);
		Facade.getInstance().setTotalVenda(total);
		Facade.getInstance().setTroco(troco);
		Facade.getInstance().cadastrarVenda();

		JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso! \n" + "Troco: "+troco);

	}

	public static float getTrocoVenda(){
		return Facade.getInstance().getTroco();
	}

	public static void detalharVenda(int codigo){

		JOptionPane.showMessageDialog(null, new JTextArea(Facade.getInstance().detalharVenda(codigo)));

	}

	public static float calcularCusto(int codigo, int quantidade){

		float custo = Facade.getInstance().calcularCusto(codigo, quantidade);

		return custo;

	}

	public static void verificarProduto(int codigo){

		if (Facade.getInstance().verificarProduto(codigo) == null){
			JOptionPane.showMessageDialog(null, "O código digitado é inválido, tente novamente");
		} else {
			JOptionPane.showMessageDialog(null, "O código digitado é válido, clique em OK para prosseguir... \n");
		}

	} 

	/**
	 * Consulta de vendas a partir da data.
	 * @author barbosa
	 * @param data Data a ser buscada como data da vendas requeridas
	 **/
	public static int consultarVenda(String data) {
		Date dataRetornada = Date.valueOf(data);

		String venda = Facade.getInstance().consultarVenda(dataRetornada);
		int codigo = 0;
		
		if (!venda.isEmpty()) {
			codigo = Integer.parseInt(JOptionPane.showInputDialog(
					null, new JTextArea("Digite o código referente a venda que deseja detalhar: \n\n" + venda)).toString());  
		}

		return codigo;

	}

	/**
	 * Inclusão de um produto no sistema.
	 * @author barbosa
	 * @param nome Nome do produto a ser incluído.
	 * @param desc Descrição do produto a ser incluído.
	 * @param preco Preço do produto a ser incluído.
	 * @param unidade Unidade do produto a ser inserido,
	 **/
	public static void incluirProduto(String nome, String desc, float preco, String unidade) {
		Facade.getInstance().cadastrarProduto(nome, desc, preco, unidade);
	}

	/**
	 * Alteração nos dados de um produto.
	 * @author barbosa
	 * @param codigo Código do produto a ser alterado.
	 **/
	public static void alterarProduto(int codigo, String nome, String descricao,float preco,String  unidade) {
		Facade.getInstance().alterarProduto(codigo, nome, descricao, preco, unidade);
	}

	/**
	 * Consulta de um produto.
	 * @author barbosa
	 * @param codigo Código do produto a ser consultado.
	 **/
	public static void consultarProduto(int codigo) {
		JOptionPane.showMessageDialog(null, Facade.getInstance().consultarProduto(codigo));
	}

	/**
	 * Exclusão um produto.
	 * @author barbosa
	 * @param codigo Código do produto a ser excluído.
	 **/
	public static void excluirProduto(int codigo) {
		if (!Facade.getInstance().excluirProduto(codigo))
			JOptionPane.showMessageDialog(null, "Algo de errado aconteceu. Ou produto pode estara associado a alguma venda, ou ele não existe!");
		else
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");
	}

	/**
	 * Método principal
	 **/
	public static void main(String [] args) {
		new ClasseGrafica();
	}
}
