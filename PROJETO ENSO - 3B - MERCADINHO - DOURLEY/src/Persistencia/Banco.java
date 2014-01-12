// Toda esta classe vai ser remodelada para implementação do Hibernate.

package Persistencia;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Negocios.Venda;
import Negocios.Produto;
import Negocios.Item;;

public class Banco {

	private static Banco instance = new Banco();
	private Connection con = null;
	private Statement stm = null;

	private Banco(){

	}

	/**
	 * Retorna uma instância do banco.
	 * 
	 */
	public static Banco getInstance(){
		return instance;
	}	

	/**
	 * Abre a conexão com o BD.
	 */
	public void abreConexao(){
		try {	
			con = DriverManager.getConnection("jdbc:mysql://localhost/mercadinho","root","WARLEYROOT");
			stm = con.createStatement();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao abrir a conexão! ");
			System.exit(1);
		}
	}

	/**
	 * Fecha a conexão com o BD.
	 */
	public void fechaConexao(){
		try {
			con.close();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão! ");
		}
	}

	/**
	 * Consulta de vendas pela data.
	 * Retorna um ArrayList de todas as vendas realizadas na data digitada.
	 **/
	public ArrayList<Venda> consultarVenda(String data){
		abreConexao();

		Venda venda = null;
		ArrayList<Venda> vendas = new ArrayList<>();

		try {

			String sql = "SELECT * FROM venda WHERE data = '"+data+"'";
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next())
			{				
				venda = new Venda();
				venda.setCodIdentificacao(rs.getInt("codigo"));
				venda.setData(rs.getDate("data"));
				venda.setTotal(rs.getFloat("total"));
				venda.setPagamentoRecebido(rs.getFloat("pagamentoRecebido"));
				venda.setTroco(rs.getFloat("troco"));

				vendas.add(venda);
			}

		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao consultar venda! ");
		}

		fechaConexao();

		return vendas;
	}

	/**
	 *Consulta uma venda pelo código e retorna uma instância de venda, 
	 *com os dados equivalentes aos da venda encontrada no banco de dados.  
	 */
	public Venda retornarVenda(int codigo) {
		abreConexao();

		Venda venda = null;

		try {
			String sql = "SELECT * FROM venda WHERE codigo = "+codigo;

			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				venda = new Venda();
				venda.setCodIdentificacao(rs.getInt("codigo"));
				venda.setData(rs.getDate("data"));
				venda.setTotal(rs.getFloat("total"));
				venda.setPagamentoRecebido(rs.getFloat("pagamentoRecebido"));
				venda.setTroco(rs.getFloat("troco"));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao retornar venda! ");
		}

		return venda;
	}

	/**
	 *Retorna um ArrayList com todos os itens que estão associados ao código da venda que é recebido como parâmetro 
	 */
	public ArrayList<Item> consultarItens(int codigo){
		abreConexao();

		Item item = null;
		ArrayList<Item> itens = new ArrayList<>();

		try {

			String sql = "SELECT * FROM item WHERE codVenda = "+codigo+"";
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next())
			{				
				item = new Item(rs.getInt("codProduto"), rs.getInt("qtdProdutos"));
				item.setCusto(rs.getInt("custoItem"));

				itens.add(item);
			}

		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao consultar item! ");
		}

		fechaConexao();

		return itens;
	}

	/**
	 * Salva uma venda no Banco de dados.
	 */
	public int salvarVenda(Venda venda){
		abreConexao();
		int codigo = -1;

		try {

			String sql = "INSERT INTO venda (data, total, pagamentoRecebido, troco) values (" +
					"'"+venda.getData()+"', "+venda.getTotal()+", "+venda.getPagamentoRecebido()+", "+venda.getTroco()+") ";


			stm.executeUpdate(sql);

			String sql2 = "SELECT max(codigo) FROM venda";
			ResultSet rs = stm.executeQuery(sql2);
			if (rs.next()){
				codigo = rs.getInt(1);
			}

			venda.setCodIdentificacao(codigo);

		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao salvar venda! ");
		}

		fechaConexao();
		return codigo;
	}


	/**
	 *Excluir um produto do Banco de dados 
	 **/
	public boolean excluirProduto(int codigo) {
		abreConexao();
		boolean excluiu = true;
		try {

			String sql = "DELETE FROM produto WHERE codigo = "+codigo;
			stm.executeUpdate(sql);

		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao excluir produto! ");
			excluiu = false;
		}

		fechaConexao();
		return excluiu;
	}

	/**
	 * Salva um produto no Banco de dados.
	 */
	public int salvarProduto(Produto produto){
		abreConexao();

		int codigo = -1;

		try {

			// validar o produto a ser inserido no caso de duplicatas
			String sql = "INSERT INTO produto (nome, descricao, preco, unidade) values ('"+produto.getNomeProduto()+"'," +
					"'"+produto.getDescricaoProduto()+"',"+produto.getPrecoProduto()+",'"+produto.getUnidadeProduto()+"')";

			stm.executeUpdate(sql);

			String sql2 = "SELECT max(codigo) FROM produto";
			ResultSet rs = stm.executeQuery(sql2);

			if (rs.next()){
				codigo = rs.getInt(1);
			}

		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao salvar produto! ");
		}

		fechaConexao();

		return codigo;
	}

	/** 
	 * Consultar produto a partir do codigo
	 */
	public Produto consultarProduto(int codigo) {
		abreConexao();

		Produto produto = null;

		try {

			String sql = "SELECT * FROM produto WHERE codigo = "+codigo;
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next())
			{
				produto = new Produto(rs.getString("nome"), rs.getString("descricao"), rs.getFloat("preco"), rs.getString("unidade"));
				produto.setCodProduto(rs.getInt("codigo"));
			}

		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao consultar produto! ");
		}

		fechaConexao();

		return produto;
	}

	/**
	 * Alterar produto do banco de dados
	 */
	public void alterarProduto(int codigo, String nome, String descricao, float preco, String unidade) {
		abreConexao();

		try {

			String sql = "UPDATE produto SET nome = '"+nome+"', descricao = '"+descricao+"', " +
					"preco = "+preco+", unidade = '"+unidade+"' where codigo = "+codigo;

			stm.executeUpdate(sql);

		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao alterar produto! ");
		}

		fechaConexao();
	}

	/**
	 * Salva um item no BD
	 */
	public void salvarItem(Item item){
		abreConexao();

		try {

			String sql = "INSERT INTO item (codProduto, codVenda, qtdProdutos, custoItem) values (" +
					item.getCodProduto() + "," + item.getCodigoVenda() + ", " + item.getQtdProduto() + "," + item.getCusto() + ")";
			stm.executeUpdate(sql);

		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao salvar item! ");
		}

		fechaConexao();
	}

}