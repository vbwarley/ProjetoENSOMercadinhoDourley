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

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClasseGrafica extends JFrame implements ActionListener{

	private JPanel painel;
	private JButton botaoOkProdutos;	
	private JButton botaoOkManterProdutos;	
	private JButton botaoOkCadastrarVenda;
	private JButton botaoOkConsultarVenda;
	private JButton botaoOkSair;
	private JButton botaoOkIncluir;
	private JButton botaoOkAlterar;
	private JButton botaoOkConsultar;
	private JButton botaoOkExcluir;
	private JButton botaoOkSairProdutos;
	private JButton botaoVerificarExistencia;
	private JTextField codigoProduto;
	
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
		painel.add(labelConsultarVenda, grid);
		
		grid.gridx = 1;
		grid.gridy = 2;		
		botaoOkSair = new JButton("OK");
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
		
		JPanel painelManterProdutos = new JPanel();
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
		botaoOkConsultar = new JButton("OK");
		botaoOkConsultar.addActionListener(this);
		painelManterProdutos.add(botaoOkConsultar, gridVendas);
				
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
		botaoOkSairProdutos = new JButton("OK");
		botaoOkSairProdutos.addActionListener(this);
		painelManterProdutos.add(botaoOkSairProdutos, gridVendas);
		
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
		JLabel codigoProdutoLabel = new JLabel("Codigo do produto");
		painelCadastrarVenda.add(codigoProdutoLabel, gridVendas);
		
		gridVendas.gridx = 1;
		gridVendas.gridy = 0;
		codigoProduto = new JTextField(20);
		painelCadastrarVenda.add(codigoProduto, gridVendas);
		
		gridVendas.gridx = 1;
		gridVendas.gridy = 1;
		botaoVerificarExistencia = new JButton("Verificar existencia");
		botaoVerificarExistencia.addActionListener(this);
		painelCadastrarVenda.add(botaoVerificarExistencia, gridVendas);
				
		painelCadastrarVenda.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == botaoOkManterProdutos){
			painel.setVisible(false);
			painelManterProdutos();
		} else if(e.getSource() == botaoOkCadastrarVenda){
			painel.setVisible(false);
			painelCadastrarVenda();
		}
		
	}

	
}
