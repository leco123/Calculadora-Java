package br.com.leco.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.leco.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{
	
	private final Color COR_CINZA_ESCURO  = new Color(68, 68, 68);
	private final Color COR_CINZA_CLARO  = new Color(99, 99, 99);
	private final Color COR_LARANJA  = new Color(242, 163, 60);
	
	public Teclado() {

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints C = new GridBagConstraints();
		
		setLayout(layout);
		
		C.weightx = 1; // Peso do Eixo X 1= Ocupar todo o Eixo X
		C.weighty = 1; // Peso do Eixo Y 1= Ocupar todo o Eixo Y
		// Expandir Componentes "Preencher os Componentes conforme necessidade"
		C.fill = GridBagConstraints.BOTH;
		
		// LINHA 1 DA CALCULADORA
		C.gridwidth = 2; // Largura  = 3
		adicionarBotao("AC", COR_CINZA_ESCURO, C, 0, 0);
		C.gridwidth = 1; // Largura  = 1
		adicionarBotao("+/-", COR_CINZA_ESCURO, C, 2, 0);
		//adicionarBotao("%", COR_CINZA_ESCURO, C, 2, 0);
		adicionarBotao("/", COR_LARANJA, C, 3, 0);
		
		// LINHA 2 DA CALCULADORA
		adicionarBotao("7", COR_CINZA_CLARO, C, 0, 1);
		adicionarBotao("8", COR_CINZA_CLARO, C, 1, 1);
		adicionarBotao("9", COR_CINZA_CLARO, C, 2, 1);
		adicionarBotao("*", COR_LARANJA, C, 3, 1);
		
		// LINHA 3 DA CALCULADORA
		adicionarBotao("4", COR_CINZA_CLARO, C, 0, 2);
		adicionarBotao("5", COR_CINZA_CLARO, C, 1, 2);
		adicionarBotao("6", COR_CINZA_CLARO, C, 2, 2);
		adicionarBotao("-", COR_LARANJA, C, 3, 2);
		
		// LINHA 4 DA CALCULADORA
		adicionarBotao("1", COR_CINZA_CLARO, C, 0, 3);
		adicionarBotao("2", COR_CINZA_CLARO, C, 1, 3);
		adicionarBotao("3", COR_CINZA_CLARO, C, 2, 3);
		adicionarBotao("+", COR_LARANJA, C, 3, 3);
		
		// LINHA 5 DA CALCULADORA
		C.gridwidth = 2; // Largura  = 2
		adicionarBotao("0", COR_CINZA_CLARO, C, 0, 4);
		C.gridwidth = 1; // Largura  = 1
		adicionarBotao(",", COR_CINZA_CLARO, C, 2, 4);
		adicionarBotao("=", COR_LARANJA, C, 3, 4);
		
	}

	private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		c.gridx = x;
		c.gridy = y;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
		}
		
	}
}
