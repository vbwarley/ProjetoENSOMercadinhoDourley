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

	private JLabel jLabel;
	private JPanel painel;
	private JButton botao;
	private JTextField campoTexto;
	private FlowLayout layout;
	
	
	public ClasseGrafica () {
		/*
		"1 - Manter Produtos\n" +
				"2 - Cadastrar Venda\n" +
				"3 - Consultar Venda\n" +
				"4 - Sair\n\n"*/
		
		super("Mercadinho do Zé");
		
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		center();
		
		this.setLayout(new BorderLayout());
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(4, 4, 4, 4));
		
		painel = new JPanel();
		painel.setBorder(BorderFactory.createTitledBorder("Menu"));
		painel.setLayout(new GridBagLayout());
		painel.setSize(new Dimension(300, 300));
		
		GridBagConstraints grid = new GridBagConstraints();
		
		grid.gridx = 0;
		grid.gridy = 0;
		
		botao = new JButton("OK");
		botao.addActionListener(this);
		
		jLabel = new JLabel("Manter produtos ");
		
		this.add(BorderLayout.NORTH, painel);
		painel.add(jLabel, grid);
		
		grid.gridx = 1;
		grid.gridy = 0;		
		
		painel.add(botao, grid);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == botao){
			painel.setVisible(false);
			painelManterProdutos();
		}
		
	}
	
	private void center(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Dimension tamanhoJanela = toolkit.getScreenSize();
		
		int larguraJanela = tamanhoJanela.width - this.getWidth();
		int alturaJanela = tamanhoJanela.height - this.getHeight();
		
		setLocation(larguraJanela/2, alturaJanela/2);
		
	}
	
	private void painelManterProdutos() {
		
		JPanel painelProdutos = new JPanel();
		painelProdutos = new JPanel();
		painelProdutos.setBorder(BorderFactory.createTitledBorder("Menu de vendas"));
		painelProdutos.setSize(new Dimension(500, 500));
		painelProdutos.setLayout(new GridBagLayout());
		
		this.add(BorderLayout.NORTH, painelProdutos);
		
		GridBagConstraints gridVendas = new GridBagConstraints();
		gridVendas.insets = new Insets(4, 4, 4, 4);
		
		gridVendas.gridx = 0;
		gridVendas.gridy = 0;
		
		
		JLabel opcIncluir = new JLabel("Incluir");
		
		painelProdutos.add(opcIncluir, gridVendas);
		

		gridVendas.gridx = 1;
		gridVendas.gridy = 0;
		
		JButton botaoOk = new JButton("OK");
		
		painelProdutos.add(botaoOk);
		
		
		painelProdutos.setVisible(true);
		
	}
	
}
