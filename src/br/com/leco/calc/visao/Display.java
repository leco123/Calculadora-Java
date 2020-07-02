package br.com.leco.calc.visao;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.leco.calc.modelo.Memoria;
import br.com.leco.calc.modelo.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador {
	
	private final JLabel label;
	
	public Display() {
		Memoria.getInstancia().adicionarObservador(this);
		setBackground(new Color(46, 49, 50));
		label  = new JLabel(Memoria.getInstancia().getTextoAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		
		// Gerenciador de Layout
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		add(label);
	}
	
	@Override
	public void valorAlterado(String novovalor) {
		label.setText(novovalor);		
	}
}
