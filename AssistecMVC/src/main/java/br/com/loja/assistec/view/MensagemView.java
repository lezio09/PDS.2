package br.com.loja.assistec.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MensagemView extends JDialog {
	private static final long serialVersionUID = 1L;
	private int resposta;

	public MensagemView(String mensagem, int tipo) {
		setTitle("Mensagem");
		setModal(true);

		JPanel painel = new JPanel();
		painel.setLayout(new BorderLayout());
		add(painel);

		JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
		painel.add(lblMensagem, BorderLayout.CENTER);

		String iconeURL;
		switch (tipo) {
		case 0:
			iconeURL = "/br/com/loja/assistec/icones/errro.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 1:
			iconeURL = "/br/com/loja/assistec/icones/info.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 2:
			iconeURL = "/br/com/loja/assistec/icones/alerta.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 3:
			iconeURL = "/br/com/loja/assistec/icones/sucesso.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 10:
			iconeURL = "/br/com/loja/assistec/icones/assistec.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		}
		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		painelSul.add(new JPanel());
		JButton bntSim = new JButton("Sim");
		bntSim.setPreferredSize(new Dimension(100, 30));
		bntSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}});
		painelSul.add(bntSim);
		painelSul.add(new JPanel());
		
		painelSul.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		painel.add(painelSul,BorderLayout.SOUTH);
		getRootPane().setDefaultButton(bntSim);
		setSize(350,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public MensagemView(String pergunta) {
		setTitle("Mensagem");
		setModal(true);

		JPanel painel = new JPanel();
		painel.setLayout(new BorderLayout());
		add(painel);
		
		JLabel labelPergunta = new JLabel(pergunta, SwingConstants.CENTER);
		String iconPath;
		iconPath = "br/com/loja/assistec/icones/question.png";
		labelPergunta.setIcon(new ImageIcon(getClass().getResource(iconPath)));
		painel.add(labelPergunta, BorderLayout.CENTER);
		
		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		painelSul.add(new JPanel());
		JButton bntSim = new JButton("Sim");
		bntSim.setPreferredSize(new Dimension(100, 30));
		bntSim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resposta = 1;
				setVisible(false);
			}});
		
			JPanel painel1 = new JPanel();
			painel1.setLayout(new BorderLayout());
			add(painel1);
			
			JLabel labelPergunta1 = new JLabel(pergunta, SwingConstants.CENTER);
			String iconPath1;
			iconPath1 = "br/com/loja/assistec/icones/question.png";
			labelPergunta1.setIcon(new ImageIcon(getClass().getResource(iconPath1)));
			painel1.add(labelPergunta1, BorderLayout.CENTER);
			
			JPanel painelSul1 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
			painelSul1.add(new JPanel());
			JButton bntNao = new JButton("Não");
			bntNao.setPreferredSize(new Dimension(100, 30));
			bntNao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					resposta = 0;
					setVisible(false);
				}});
		}
		
	
	public int getResposta() {
		return resposta;
	}

}
