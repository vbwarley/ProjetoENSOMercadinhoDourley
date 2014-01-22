package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Delayed;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClasseGrafica extends JFrame implements ActionListener{

	
	//Botoes e campos de textos
	private JButton botaoOkManterProdutos;	
	private JButton botaoOkCadastrarVenda;
	private JButton botaoOkConsultarVenda;
	private JButton botaoOkSair;
	private JButton botaoOkIncluir;
	private JButton botaoOkAlterar;
	private JButton botaoOkConsultarProduto;
	private JButton botaoOkExcluir;
	private JButton botaoVoltarManterProdutos;
	private JButton botaoVerificarExistencia;
	private JButton incluirProduto;
	private JButton adicionaAoCarrinho;
	private JButton finalizarVenda;
	private JButton botaoConsultarVenda;
	private JButton alterarProduto;
	private JButton botaoVoltarInclusaoProdutos;
	private JButton botaoVoltarAlterarProduto;
	private JButton botaoConsultarProduto;
	private JButton botaoVoltarConsultarProduto;
	private JButton botaoExcluirProduto;
	private JButton botaoVoltarExcluirProduto;
	private JButton botaoVoltarConsultarVenda;
	private JTextField quantidadeProdutoText;
	private JTextField dataVendasText;
	private JTextField nomeProdutoText;
	private JTextField descricaoProdutoText;
	private JTextField precoProdutoText;
	private JTextField unidadeProdutoText;
	private JTextField codigoProdutoText;
	
	//Paineis
	private JPanel painel;
	private JPanel painelManterProdutos;
	private JPanel painelIncluirProduto;
	private JPanel painelAlterarProduto;
	private JPanel painelConsultarProduto;
	private JPanel painelExcluirProduto;
	private JPanel painelConsultarVenda;
	
	public ClasseGrafica () {
		
		super("Mercadinho do Zé");
		
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		center();
		
		painel = new JPanel();
		painel.setBorder(BorderFactory.createTitledBorder("Menu"));
		painel.setLayout(new GridBagLayout());
		painel.setSize(new Dimension(500, 500));
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		JLabel labelManterProdutos = new JLabel("Manter produtos");
		painel.add(labelManterProdutos, grid);
		
		grid.gridx = 1;
		grid.gridy = 0;		
		botaoOkManterProdutos = new JButton("OK");
		botaoOkManterProdutos.addActionListener(this);
		painel.add(botaoOkManterProdutos, grid);
		
		grid.gridx = 0;
		grid.gridy = 1;
		JLabel labelCadastrarVenda = new JLabel("Cadastrar venda");
		painel.add(labelCadastrarVenda, grid);
		
		grid.gridx = 1;
		grid.gridy = 1;		
		botaoOkCadastrarVenda = new JButton("OK");
		botaoOkCadastrarVenda.addActionListener(this);
		painel.add(botaoOkCadastrarVenda, grid);
		
		grid.gridx = 0;
		grid.gridy = 2;		
		JLabel labelConsultarVenda = new JLabel("Consultar venda");
		painel.add(labelConsultarVenda, grid);
		
		grid.gridx = 1;
		grid.gridy = 2;		
		botaoOkConsultarVenda = new JButton("OK");
		botaoOkConsultarVenda.addActionListener(this);
		painel.add(botaoOkConsultarVenda, grid);
		
		grid.gridx = 0;
		grid.gridy = 2;		
		JLabel labelSair = new JLabel("Consultar venda");
		painel.add(labelSair, grid);
		
		grid.gridx = 1;
		grid.gridy = 3;		
		botaoOkSair = new JButton("Sair");
		botaoOkSair.addActionListener(this);
		painel.add(botaoOkSair, grid);
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painel);
		
}
	
	private void center(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Dimension tamanhoJanela = toolkit.getScreenSize();
		
		int larguraJanela = tamanhoJanela.width - this.getWidth();
		int alturaJanela = tamanhoJanela.height - this.getHeight();
		
		setLocation(larguraJanela/2, alturaJanela/2);
		
	}
	
	private void painelManterProdutos() {
		
		painelManterProdutos = new JPanel();
		painelManterProdutos.setBorder(BorderFactory.createTitledBorder("Manter produtos"));
		painelManterProdutos.setLayout(new GridBagLayout());
		painelManterProdutos.setSize(new Dimension(500, 500));
		
		GridBagConstraints gridVendas = new GridBagConstraints();
		gridVendas.insets = new Insets(4, 4, 4, 4);
		
		gridVendas.gridx = 0;
		gridVendas.gridy = 0;
		JLabel opcIncluir = new JLabel("Incluir");
		painelManterProdutos.add(opcIncluir, gridVendas);
		
		gridVendas.gridx = 1;
		gridVendas.gridy = 0;
		botaoOkIncluir = new JButton("OK");
		botaoOkIncluir.addActionListener(this);
		painelManterProdutos.add(botaoOkIncluir, gridVendas);
				
		gridVendas.gridx = 0;
		gridVendas.gridy = 1;
		JLabel opcAlterar = new JLabel("Alterar");
		painelManterProdutos.add(opcAlterar, gridVendas);
		
		gridVendas.gridx = 1;
		gridVendas.gridy = 1;
		botaoOkAlterar = new JButton("OK");
		botaoOkAlterar.addActionListener(this);
		painelManterProdutos.add(botaoOkAlterar, gridVendas);
		
		gridVendas.gridx = 0;
		gridVendas.gridy = 2;
		JLabel opcConsultar = new JLabel("Consultar");
		painelManterProdutos.add(opcConsultar, gridVendas);
		
		gridVendas.gridx = 1;
		gridVendas.gridy = 2;
		botaoOkConsultarProduto = new JButton("OK");
		botaoOkConsultarProduto.addActionListener(this);
		painelManterProdutos.add(botaoOkConsultarProduto, gridVendas);
				
		gridVendas.gridx = 0;
		gridVendas.gridy = 3;
		JLabel opcExcluir = new JLabel("Excluir");
		painelManterProdutos.add(opcExcluir, gridVendas);
		
		gridVendas.gridx = 1;
		gridVendas.gridy = 3;
		botaoOkExcluir = new JButton("OK");
		botaoOkExcluir.addActionListener(this);
		painelManterProdutos.add(botaoOkExcluir, gridVendas);
				
		gridVendas.gridx = 0;
		gridVendas.gridy = 4;
		JLabel opcSair = new JLabel("Voltar...");
		painelManterProdutos.add(opcSair, gridVendas);
		
		gridVendas.gridx = 1;
		gridVendas.gridy = 4;
		botaoVoltarManterProdutos = new JButton("OK");
		botaoVoltarManterProdutos.addActionListener(this);
		painelManterProdutos.add(botaoVoltarManterProdutos, gridVendas);
		
		painelManterProdutos.setVisible(true);
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelManterProdutos);
		
	}
	
	private void painelCadastrarVenda() {
		
		JPanel painelCadastrarVenda = new JPanel();
		painelCadastrarVenda.setBorder(BorderFactory.createTitledBorder("Manter produtos"));
		painelCadastrarVenda.setLayout(new GridBagLayout());
		painelCadastrarVenda.setSize(new Dimension(500, 500));
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelCadastrarVenda);
		
		GridBagConstraints gridVendas = new GridBagConstraints();
		gridVendas.insets = new Insets(4, 4, 4, 4);
		
		gridVendas.gridx = 0;
		gridVendas.gridy = 0;
		JLabel codigoProdutoLabel = new JLabel("Código do produto");
		painelCadastrarVenda.add(codigoProdutoLabel, gridVendas);
		
		gridVendas.gridx = 1;
		gridVendas.gridy = 0;
		codigoProdutoText = new JTextField(15);
		painelCadastrarVenda.add(codigoProdutoText, gridVendas);
		
		gridVendas.gridx = 2;
		gridVendas.gridy = 0;
		botaoVerificarExistencia = new JButton("Verificar");
		botaoVerificarExistencia.addActionListener(this);
		painelCadastrarVenda.add(botaoVerificarExistencia, gridVendas);
				
		gridVendas.gridx = 0;
		gridVendas.gridy = 2;
		JLabel quantidadeProdutoLabel = new JLabel("Quantidade");
		painelCadastrarVenda.add(quantidadeProdutoLabel, gridVendas);
				
		gridVendas.gridx = 1;
		gridVendas.gridy = 2;
		quantidadeProdutoText = new JTextField(8);
		painelCadastrarVenda.add(quantidadeProdutoText, gridVendas);
		
		gridVendas.gridx = 2;
		gridVendas.gridy = 2;
		adicionaAoCarrinho = new JButton("Adicionar");
		adicionaAoCarrinho.addActionListener(this);
		painelCadastrarVenda.add(adicionaAoCarrinho, gridVendas);
		
		gridVendas.gridx = 1;
		gridVendas.gridy = 4;
		finalizarVenda = new JButton("finalizar venda");
		finalizarVenda.addActionListener(this);
		painelCadastrarVenda.add(finalizarVenda, gridVendas);
		
		painelCadastrarVenda.setVisible(true);
		
	}
	
	private void painelAlterarProduto() {
		
		painelAlterarProduto = new JPanel();
		painelAlterarProduto.setBorder(BorderFactory.createTitledBorder("Alterar produto"));
		painelAlterarProduto.setLayout(new GridBagLayout());
		painelAlterarProduto.setSize(new Dimension(500, 500));
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelAlterarProduto);
		
		GridBagConstraints gridProdutos = new GridBagConstraints();
		gridProdutos.insets = new Insets(4, 4, 4, 4);
		
		gridProdutos.gridx = 0;
		gridProdutos.gridy = 0;
		JLabel codigoProdutoLabel = new JLabel("Codigo do produto");
		painelAlterarProduto.add(codigoProdutoLabel, gridProdutos);
		
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 0;
		codigoProdutoText = new JTextField(15);
		painelAlterarProduto.add(codigoProdutoText, gridProdutos);
		
		gridProdutos.gridx = 2;
		gridProdutos.gridy = 0;
		botaoVerificarExistencia = new JButton("Verificar");
		botaoVerificarExistencia.addActionListener(this);
		painelAlterarProduto.add(botaoVerificarExistencia, gridProdutos);
		
		gridProdutos.gridx = 0;
		gridProdutos.gridy = 1;
		JLabel nomeProdutoLabel = new JLabel("Nome do produto");
		painelAlterarProduto.add(nomeProdutoLabel, gridProdutos);
		
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 1;
		nomeProdutoText = new JTextField(15);
		painelAlterarProduto.add(nomeProdutoText, gridProdutos);
				
		gridProdutos.gridx = 0;
		gridProdutos.gridy = 2;
		JLabel descricaoProdutoLabel = new JLabel("Descrição");
		painelAlterarProduto.add(descricaoProdutoLabel, gridProdutos);
				
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 2;
		descricaoProdutoText = new JTextField(15);
		painelAlterarProduto.add(descricaoProdutoText, gridProdutos);
		
		gridProdutos.gridx = 0;
		gridProdutos.gridy = 3;
		JLabel precoProdutoLabel = new JLabel("Preço");
		painelAlterarProduto.add(precoProdutoLabel, gridProdutos);
				
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 3;
		precoProdutoText = new JTextField(6);
		painelAlterarProduto.add(precoProdutoText, gridProdutos);
		
		gridProdutos.gridx = 0;
		gridProdutos.gridy = 4;
		JLabel unidadeProdutoLabel = new JLabel("Unidade");
		painelAlterarProduto.add(unidadeProdutoLabel, gridProdutos);
				
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 4;
		unidadeProdutoText = new JTextField(8);
		painelAlterarProduto.add(unidadeProdutoText, gridProdutos);
		
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 5;
		alterarProduto = new JButton("Alterar no banco de dados");
		alterarProduto.addActionListener(this);
		painelAlterarProduto.add(alterarProduto, gridProdutos);
		
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 6;
		botaoVoltarAlterarProduto = new JButton("Voltar...");
		botaoVoltarAlterarProduto.addActionListener(this);
		painelAlterarProduto.add(botaoVoltarAlterarProduto, gridProdutos);
		
		painelAlterarProduto.setVisible(true);
		
	}
	
	private void painelConsultarProduto() {
		
		painelConsultarProduto = new JPanel();
		painelConsultarProduto.setBorder(BorderFactory.createTitledBorder("Consultar produto"));
		painelConsultarProduto.setLayout(new GridBagLayout());
		painelConsultarProduto.setSize(new Dimension(500, 500));
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelConsultarProduto);
		
		GridBagConstraints gridConsultarProduto = new GridBagConstraints();
		gridConsultarProduto.insets = new Insets(4, 4, 4, 4);
		
		gridConsultarProduto.gridx = 0;
		gridConsultarProduto.gridy = 0;
		JLabel codigoProdutoLabel = new JLabel("Codigo do produto");
		painelConsultarProduto.add(codigoProdutoLabel, gridConsultarProduto);
		
		gridConsultarProduto.gridx = 1;
		gridConsultarProduto.gridy = 0;
		codigoProdutoText = new JTextField(15);
		painelConsultarProduto.add(codigoProdutoText, gridConsultarProduto);
		
		gridConsultarProduto.gridx = 2;
		gridConsultarProduto.gridy = 0;
		botaoVerificarExistencia = new JButton("Verificar");
		botaoVerificarExistencia.addActionListener(this);
		painelConsultarProduto.add(botaoVerificarExistencia, gridConsultarProduto);
		
		gridConsultarProduto.gridx = 1;
		gridConsultarProduto.gridy = 1;
		botaoConsultarProduto = new JButton("Consultar");
		botaoConsultarProduto.addActionListener(this);
		painelConsultarProduto.add(botaoConsultarProduto, gridConsultarProduto);
		
		gridConsultarProduto.gridx = 2;
		gridConsultarProduto.gridy = 1;
		botaoVoltarConsultarProduto = new JButton("Voltar");
		botaoVoltarConsultarProduto.addActionListener(this);
		painelConsultarProduto.add(botaoVoltarConsultarProduto, gridConsultarProduto);
		
		
		painelConsultarProduto.setVisible(true);
		
	}
	
	private void painelExcluirProduto() {
		
		painelExcluirProduto = new JPanel();
		painelExcluirProduto.setBorder(BorderFactory.createTitledBorder("Excluir produto"));
		painelExcluirProduto.setLayout(new GridBagLayout());
		painelExcluirProduto.setSize(new Dimension(500, 500));
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelExcluirProduto);
		
		GridBagConstraints gridConsultarProduto = new GridBagConstraints();
		gridConsultarProduto.insets = new Insets(4, 4, 4, 4);
		
		gridConsultarProduto.gridx = 0;
		gridConsultarProduto.gridy = 0;
		JLabel codigoProdutoLabel = new JLabel("Codigo do produto");
		painelExcluirProduto.add(codigoProdutoLabel, gridConsultarProduto);
		
		gridConsultarProduto.gridx = 1;
		gridConsultarProduto.gridy = 0;
		codigoProdutoText = new JTextField(15);
		painelExcluirProduto.add(codigoProdutoText, gridConsultarProduto);
		
		gridConsultarProduto.gridx = 2;
		gridConsultarProduto.gridy = 0;
		botaoVerificarExistencia = new JButton("Verificar");
		botaoVerificarExistencia.addActionListener(this);
		painelExcluirProduto.add(botaoVerificarExistencia, gridConsultarProduto);
		
		gridConsultarProduto.gridx = 1;
		gridConsultarProduto.gridy = 1;
		botaoExcluirProduto = new JButton("Excluir");
		botaoExcluirProduto.addActionListener(this);
		painelExcluirProduto.add(botaoExcluirProduto, gridConsultarProduto);
		
		gridConsultarProduto.gridx = 2;
		gridConsultarProduto.gridy = 1;
		botaoVoltarExcluirProduto = new JButton("Voltar");
		botaoVoltarExcluirProduto.addActionListener(this);
		painelExcluirProduto.add(botaoVoltarExcluirProduto, gridConsultarProduto);
		
		
		painelExcluirProduto.setVisible(true);
		
	}
	
	private void painelIncluirProduto() {
		
		painelIncluirProduto = new JPanel();
		painelIncluirProduto.setBorder(BorderFactory.createTitledBorder("Incluir produtos"));
		painelIncluirProduto.setLayout(new GridBagLayout());
		painelIncluirProduto.setSize(new Dimension(500, 500));
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelIncluirProduto);
		
		GridBagConstraints gridProdutos = new GridBagConstraints();
		gridProdutos.insets = new Insets(4, 4, 4, 4);
		
		gridProdutos.gridx = 0;
		gridProdutos.gridy = 0;
		JLabel nomeProdutoLabel = new JLabel("Nome do produto");
		painelIncluirProduto.add(nomeProdutoLabel, gridProdutos);
		
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 0;
		nomeProdutoText = new JTextField(15);
		painelIncluirProduto.add(nomeProdutoText, gridProdutos);
				
		gridProdutos.gridx = 0;
		gridProdutos.gridy = 1;
		JLabel descricaoProdutoLabel = new JLabel("Descrição");
		painelIncluirProduto.add(descricaoProdutoLabel, gridProdutos);
				
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 1;
		descricaoProdutoText = new JTextField(15);
		painelIncluirProduto.add(descricaoProdutoText, gridProdutos);
		
		gridProdutos.gridx = 0;
		gridProdutos.gridy = 2;
		JLabel precoProdutoLabel = new JLabel("Preço");
		painelIncluirProduto.add(precoProdutoLabel, gridProdutos);
				
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 2;
		precoProdutoText = new JTextField(6);
		painelIncluirProduto.add(precoProdutoText, gridProdutos);
		
		gridProdutos.gridx = 0;
		gridProdutos.gridy = 3;
		JLabel unidadeProdutoLabel = new JLabel("Unidade");
		painelIncluirProduto.add(unidadeProdutoLabel, gridProdutos);
				
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 3;
		unidadeProdutoText = new JTextField(8);
		painelIncluirProduto.add(unidadeProdutoText, gridProdutos);
		
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 4;
		incluirProduto = new JButton("Alterar");
		incluirProduto.addActionListener(this);
		painelIncluirProduto.add(incluirProduto, gridProdutos);
		
		gridProdutos.gridx = 1;
		gridProdutos.gridy = 5;
		botaoVoltarInclusaoProdutos = new JButton("Voltar...");
		botaoVoltarInclusaoProdutos.addActionListener(this);
		painelIncluirProduto.add(botaoVoltarInclusaoProdutos, gridProdutos);
		
		painelIncluirProduto.setVisible(true);
		
	}


	private void painelConsultarVenda() {
		
		painelConsultarVenda = new JPanel();
		painelConsultarVenda.setBorder(BorderFactory.createTitledBorder("Consultar vendas"));
		painelConsultarVenda.setLayout(new GridBagLayout());
		painelConsultarVenda.setSize(new Dimension(500, 500));
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelConsultarVenda);
		
		GridBagConstraints gridConsultaVendas = new GridBagConstraints();
		gridConsultaVendas.insets = new Insets(4, 4, 4, 4);
		
		gridConsultaVendas.gridx = 0;
		gridConsultaVendas.gridy = 0;
		JLabel dataDasVendasLabel = new JLabel("Data das vendas");
		painelConsultarVenda.add(dataDasVendasLabel, gridConsultaVendas);
		
		gridConsultaVendas.gridx = 1;
		gridConsultaVendas.gridy = 0;
		dataVendasText = new JTextField(15);
		painelConsultarVenda.add(dataVendasText, gridConsultaVendas);
		
		gridConsultaVendas.gridx = 2;
		gridConsultaVendas.gridy = 0;
		botaoConsultarVenda = new JButton("Consultar");
		botaoConsultarVenda.addActionListener(this);
		painelConsultarVenda.add(botaoConsultarVenda, gridConsultaVendas);
		
		gridConsultaVendas.gridx = 1;
		gridConsultaVendas.gridy = 1;
		botaoVoltarConsultarVenda = new JButton("Voltar...");
		botaoVoltarConsultarVenda.addActionListener(this);
		painelConsultarVenda.add(botaoVoltarConsultarVenda, gridConsultaVendas);
		
		painelConsultarVenda.setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == botaoOkManterProdutos){
			painel.setVisible(false);
			painelManterProdutos();
		} else if(e.getSource() == botaoOkCadastrarVenda){
			painel.setVisible(false);
			painelCadastrarVenda();
		} else if (e.getSource() == botaoOkConsultarVenda){
			painel.setVisible(false);
			painelConsultarVenda();
		} else if (e.getSource() == botaoOkSair){
			JOptionPane.showMessageDialog(null, "Saída do sistema!");
			System.exit(0);
		} else if (e.getSource() == botaoOkIncluir){
			painel.setVisible(false);
			painelManterProdutos.setVisible(false);
			painelIncluirProduto();
		} else if (e.getSource() == botaoVoltarInclusaoProdutos){
			painelIncluirProduto.setVisible(false);
			painelManterProdutos.setVisible(true);
		} else if (e.getSource() == botaoOkAlterar){
			painel.setVisible(false);
			painelManterProdutos.setVisible(false);
			painelAlterarProduto();
		} else if (e.getSource() == botaoVoltarAlterarProduto){
			painelAlterarProduto.setVisible(false);
			painelManterProdutos.setVisible(true);
		} else if (e.getSource() == botaoOkConsultarProduto){
			painel.setVisible(false);
			painelManterProdutos.setVisible(false);
			painelConsultarProduto();
		} else if (e.getSource() == botaoVoltarConsultarProduto){
			painelConsultarProduto.setVisible(false);
			painelManterProdutos.setVisible(true);
		} else if (e.getSource() == botaoVoltarManterProdutos){
			painelManterProdutos.setVisible(false);
			painel.setVisible(true);
		} else if (e.getSource() == botaoOkExcluir){
			painel.setVisible(false);
			painelManterProdutos.setVisible(false);
			painelExcluirProduto();
		} else if (e.getSource() == botaoVoltarConsultarVenda){
			painelConsultarVenda.setVisible(false);
			painel.setVisible(true);
		}
		
	}

	
}
