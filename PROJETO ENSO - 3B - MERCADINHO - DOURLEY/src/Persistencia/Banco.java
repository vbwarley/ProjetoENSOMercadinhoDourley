// Toda esta classe vai ser remodelada para implementação do Hibernate.

package Persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Negocios.Venda;
import Negocios.Produto;
import Negocios.Item;;

public class Banco {

	private static Banco instance = new Banco();
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mercadinho");
	private EntityManager manager = factory.createEntityManager();
	
	private Banco() {

	}

	public static Banco getInstance() {
		return instance;
	}
	
	/**
	 * Consulta de vendas pela data.
	 * Retorna um ArrayList de todas as vendas realizadas na data digitada.
	 **/
	public Collection<Venda> consultarVenda(String data){
		
		Query query = manager.createQuery("SELECT v FROM Venda v WHERE data = '" + data +"'");
		Collection<Venda> vendas = query.getResultList();

		return vendas;
	}

	/**
	 *Consulta uma venda pelo código e retorna uma instância de venda, 
	 *com os dados equivalentes aos da venda encontrada no banco de dados.  
	 */
	public Venda retornarVenda(int codigo) {

		Venda venda = manager.find(Venda.class, Integer.valueOf(codigo));

		return venda;
	}

	/**
	 * Salva uma venda no Banco de dados.
	 */
	public int salvarVenda(Venda venda){
		manager.getTransaction().begin();
		manager.persist(venda);
//		for (Item i : venda.getItens()) 
//			manager.persist(i.getProduto());
		manager.getTransaction().commit();
		return 0;
	}


	/**
	 *Excluir um produto do Banco de dados 
	 **/
	public boolean excluirProduto(int codigo) {

		boolean excluiu = true;

		manager.getTransaction().begin();
		Produto p = manager.find(Produto.class, Integer.valueOf(codigo));
		
		if (p != null) 
			manager.remove(p);
		else
			excluiu = false;
		
		manager.getTransaction().commit();
		
		return excluiu;
	}

	/**
	 * Salva um produto no Banco de dados.
	 */
	public void salvarProduto(Produto produto){
		
		manager.getTransaction().begin();
		manager.persist(produto);
		manager.getTransaction().commit();
		
	}

	/** 
	 * Consultar produto a partir do codigo
	 */
	public Produto consultarProduto(int codigo) {
		
		Produto p = manager.find(Produto.class, Integer.valueOf(codigo));	

		return p;
	}

	/**
	 * Alterar produto do banco de dados
	 */
	public void alterarProduto(Produto produto) {

		manager.getTransaction().begin();
		manager.merge(produto);
		manager.getTransaction().commit();
		
	}

	/**
	 * Salva um item no BD
	 */
	public void salvarItem(Item item) {
		
	}
}