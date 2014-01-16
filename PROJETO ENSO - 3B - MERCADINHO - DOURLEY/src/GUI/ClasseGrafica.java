package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ClasseGrafica extends JFrame implements ActionListener{

	private static JFrame janela;
	private static JPanel painel;
	private static JButton botao;
	
	public ClasseGrafica () {
		
		super("Mercadinho do Zé");
		
		setVisible(true);
		setLocation(400, 150);
		setSize(600, 400);
		setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		
		painel = new JPanel();
		
		botao = new JButton("Primeiro botao");
		botao.setLocation(30, 40);
		botao.setSize(40, 20);
		
		painel.add(botao);
		add(painel);
		
		botao.addActionListener(this);
				
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == botao){
			System.out.println("Funfou");
		}
		
	}
	
}
