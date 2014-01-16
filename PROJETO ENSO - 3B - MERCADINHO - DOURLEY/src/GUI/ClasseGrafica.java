package GUI;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ClasseGrafica {

	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Mercado do zé");
		
		janela.setVisible(true);
		janela.setLocation(400, 150);
		janela.setSize(600, 400);
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		
		JPanel painel = new JPanel();
		
		JButton botao = new JButton("Primeiro botao");
		botao.setLocation(30, 40);
		botao.setSize(40, 20);
		
		painel.add(botao);
		janela.add(painel);
		
		Eventos eventos = new Eventos();
		
		botao.addActionListener(eventos);
		
		while (true)
		{
			System.out.println("Executando");
			
		}
		
	}

}
