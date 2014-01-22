// Toda esta classe vai ser remodelada para implementação do Hibernate.

package Persistencia;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Negocios.Venda;
import Negocios.Produto;

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
	public List<Venda> consultarVenda(Date data){
		
		Query query = manager.createNamedQuery("Venda.findByDate");
		query.setParameter("data", data);
		
		List<Venda> vendas = null;
		
		try {
			vendas = query.getResultList();
		} catch (NoResultException e) {
			// nada a por aqui
		}

		return vendas;
	}

	/**
	 *Consulta uma venda pelo código e retorna uma instância de venda, 
	 *com os dados equivalentes aos da venda encontrada no banco de dados.  
	 */
	public Venda retornarVenda(int codigo) {
		Venda venda = null;
		
		try {
			venda = manager.find(Venda.class, Integer.valueOf(codigo));
		} catch (NoResultException e) {
			// nada a por aqui
		}
		
		return venda;
	}

	/**
	 * Salva uma venda no Banco de dados.
	 */
	public void salvarVenda(Venda venda){
		manager.getTransaction().begin();
		manager.persist(venda);
		manager.getTransaction().commit();
	}


	/**
	 *Excluir um produto do Banco de dados 
	 **/
	public boolean excluirProduto(int codigo) {

		boolean excluiu = true;

		manager.getTransaction().begin();
		Produto p = consultarProduto(codigo);
		
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
		
		Produto p = null;
		
		try {
			p = manager.find(Produto.class, Integer.valueOf(codigo));
		} catch (NoResultException e) {
			// nada a por aqui
		}	

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
}