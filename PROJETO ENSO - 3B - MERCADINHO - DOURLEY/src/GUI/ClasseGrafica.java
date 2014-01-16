package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClasseGrafica extends JFrame implements ActionListener{

	private static JLabel jLabel;
	private static JPanel painel;
	private static JButton botao;
	
	public ClasseGrafica () {
		
		super("Mercadinho do Zé");
		
		setVisible(true);
		setSize(600, 400);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		center();
		
		painel = new JPanel();
		painel.setLocale(this.getLocale());
		painel.setLocation(0, 0);
		painel.setSize(600, 400);
		
		botao = new JButton("Primeiro botao");
		botao.setLocation(100, 200);
		botao.setSize(40, 20);
		
		jLabel = new JLabel("Label");
		
		painel.add(jLabel);
		painel.add(botao);
		add(painel);
		
		botao.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == botao){
			SistemaFinal.menu();
		}
		
	}
	
	private void center(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Dimension tamanhoJanela = toolkit.getScreenSize();
		
		int larguraJanela = tamanhoJanela.width - this.getWidth();
		int alturaJanela = tamanhoJanela.height - this.getHeight();
		
		setLocation(larguraJanela/2, alturaJanela/2);
		
	}
	
}
