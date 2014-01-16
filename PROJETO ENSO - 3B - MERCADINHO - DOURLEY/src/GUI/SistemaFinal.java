// Esta classe tem de ser bem remodelada para implementação do Swing.
package GUI;

import java.sql.Date;

import javax.swing.JOptionPane;

import Negocios.Facade;


//Sistema visualisado pelo caixa
public class SistemaFinal {

	/**
	 * Menu onde será mostrado as opções para o usuário.
	 */
	public static void menu() {
		int opcaoMenu = 0;

		try {
			opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog(null, "\tBem vindo ao Mercadinho Zé!\n\nAs opções disponíveis estão descritas abaixo:\n\n" +
					"1 - Manter Produtos\n" +
					"2 - Cadastrar Venda\n" +
					"3 - Consultar Venda\n" +
					"4 - Sair\n\n").toString());
		} finally {

			switch (opcaoMenu) {
			case 1: {
				menuManterProduto();
				break;
			}
			case 2: {
				cadastrarVenda();
				menu();
				break;
			}
			case 3: {
				menuConsultarVenda();
				break;
			}
			case 4: {
				JOptionPane.showMessageDialog(null, "Você está saindo! Volte sempre!");
				System.exit(1);
			}
			case 0: System.exit(1);
			default: {
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				menu();
			}

			}
		}
	}

	/**
	 * Menu que apresenta ao usuário todas as opções do sistema em relação a produtos
	 */
	public static void menuManterProduto() {
		int opcaoManterProduto = 0;

		try {
			opcaoManterProduto = Integer.parseInt(JOptionPane.showInputDialog("\tMenu Manter Produto\n\n" +
					"1 - Incluir\n" +
					"2 - Alterar\n" +
					"3 - Consultar\n" +
					"4 - Excluir\n" +
					"5 - Sair\n").toString());
		} finally {
			switch (opcaoManterProduto) {
			case 1: {
				incluirProduto();
				menuManterProduto();
				break;
			}
			case 2: {
				alterarProduto();
				menuManterProduto();
				break;
			}
			case 3: {
				consultarProduto();
				menuManterProduto();
				break;
			}
			case 4: {
				excluirProduto();
				menuManterProduto();
				break;
			}
			case 5: {
				//JOptionPane.showMessageDialog(null, "Você está saindo! Volte sempre!");
				menu();
				break;
			}
			case 0: System.exit(1);
			default: {
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				menuManterProduto();
			}
			}
		}
	}

	/**
	 * Menu para consulta de vendas
	 */
	public static void menuConsultarVenda() {
		int opcaoMenuConsultarVenda = 0;
		try {
			opcaoMenuConsultarVenda = Integer.parseInt(JOptionPane.showInputDialog(null, "\tMenu Consultar Venda\n\n" +
					"1 - Por Data (aaaa-mm-dd) \n" +
					"2 - Sair\n\n").toString());
		} finally {
			switch (opcaoMenuConsultarVenda) {
			case 1: {
				consultarVenda();
				menuConsultarVenda();
				break;
			}
			case 2: {
				//JOptionPane.showMessageDialog(null, "Você está saindo! Volte sempre!");
				menu();
				break;
			}
			case 0: System.exit(1);
			default: {
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				menuConsultarVenda();
			}
			}
		}

	}

	/**
	 *Método de interação com o usuário para cadastro de uma Venda
	 **/
	public static void cadastrarVenda() {
		int opcao = 0;
		boolean temItem = false;
		Facade.novaVenda();
		try {

			do {

				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto que deseja adicionar: ").toString());


				if (!Facade.consultarProduto(codigo).isEmpty()){
					int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade desse produto").toString());

					if (quantidade > 0) {
						Facade.inserirItemVenda(codigo, quantidade);
						temItem = true;
						opcao = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais algum produto? ");
					} else {
						JOptionPane.showMessageDialog(null, "Quantidade desconhecida!");
					}					


				} else {
					opcao = JOptionPane.showConfirmDialog(null, "Deseja tentar novamente?");
				}

			} while (opcao == JOptionPane.YES_OPTION);

			if (temItem) {
				float total = Facade.valorTotal();
				Facade.setTotalVenda(total);
				float pagamento = Float.parseFloat(JOptionPane.showInputDialog(null, "Você deve pagar: R$ "+ total).toString());

				if (pagamento > 0) 
					Facade.setPagamentoVenda(pagamento);

				Facade.cadastrarVenda();
				Facade.salvarItens();
			}
		} catch (NullPointerException n) {
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro na digitação dos valores. Por favor, tente novamente.");
		}
	}

	/**
	 * Método de interação com o usuário para consulta de vendas
	 **/
	public static void consultarVenda() {
		try {
			String data = JOptionPane.showInputDialog("Digite a data que deseja consultar: (aaaa-mm-dd) ").toString();
			Date dataRetornada = Date.valueOf(data);
			Facade.consultarVenda(dataRetornada);

		} catch (NullPointerException n) {
			System.exit(1);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "O formato da data está errado. Por favor, tente novamente.");
		}

	}

	/**
	 * Método de interação com o usuário para inclusão de um produto no sistema
	 **/
	public static void incluirProduto() {
		try {

			String nome = JOptionPane.showInputDialog("Digite o nome do produto: ").toString();
			String desc = JOptionPane.showInputDialog("Digite a descrição do produto: ").toString();
			float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preço do produto: ").toString());
			String unidade = JOptionPane.showInputDialog("Digite a unidade do produto: ").toString();


			if (!nome.isEmpty() && desc.length() > 10 && preco > 0 && !unidade.isEmpty()) {
				Facade.cadastrarProduto(nome, desc, preco, unidade);
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Os dados estão incorretos. Por favor, tente novamente.");
			}

		} catch (NullPointerException n) {
			System.exit(1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção dos valores. Por favor, tente novamente.");
		}
	}

	/**
	 * Método de interação com o usuário para alteração nos dados de produtos
	 **/
	public static void alterarProduto() {
		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: \n").toString());

			if (Facade.alterarProduto(codigo))
				JOptionPane.showMessageDialog(null, "Produto atualizado!\n\n" + Facade.consultarProduto(codigo));

		} catch (NullPointerException n) {
			System.exit(1);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção do valor. Por favor, tente novamente.");	
		}
	}

	/**
	 * Método de interação com o usuário para consulta de produtos no sistema
	 **/
	public static void consultarProduto() {
		try {

			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: \n").toString());
			String dadosProduto = Facade.consultarProduto(codigo);

			if (!dadosProduto.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Dados do produto consultado:\n\n" + dadosProduto);
			}

		} catch (NullPointerException n) {
			System.exit(1);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção do valor. Por favor, tente novamente.");	
		}
	}

	/**
	 * Método de interação com o usuário para exclusão de produtos do sistema
	 **/
	public static void excluirProduto() {
		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: \n").toString());
			Facade.excluirProduto(codigo);

		} catch (NullPointerException n) {
			System.exit(1);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção do valor. Por favor, tente novamente.");	
		}
	}

	/**
	 * Método principal
	 **/
	public static void main(String [] args) {
	
		new ClasseGrafica();
		
		
	}
}
