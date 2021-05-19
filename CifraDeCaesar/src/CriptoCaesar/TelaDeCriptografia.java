package CriptoCaesar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TelaDeCriptografia extends JFrame {
	
	JTextArea campoDeTexto;
	JButton botaoSalvar;
	JButton botaoAbrir;
    JTextArea campoDeSenha;
    
	//Construtor da tela
	public TelaDeCriptografia() {

	super("Criptografia de arquivo");

		//Campo do texto
		campoDeTexto = new JTextArea("Digite seu texto aqui");
		add(campoDeTexto,"West");
		
		
		//Campo de senha 
		campoDeSenha = new JTextArea("Digite uma Senha");
		add(campoDeSenha,"East");
		
		
		

		// Botao para salva o arquivo
		botaoSalvar = new JButton("Salvar");
		add(botaoSalvar, "South");

		// Botao pra abrir o arquivo
		botaoAbrir = new JButton("Abrir");
		add(botaoAbrir, "North");

		JOptionPane.showMessageDialog(null, "Digite seu texto a esquerda e a senha a direita para 'Salva' seu texto cripitografado. \n Para Abrir um arquivo, coloque primero a senha do arquivo que dejesa no campo de texto a direita. ", "alerta",
				JOptionPane.INFORMATION_MESSAGE);

		// Botao para salvar o arquivo
		botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileC = new JFileChooser();
				fileC.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = fileC.showSaveDialog(null);

				if (i == 1) {
					JOptionPane.showMessageDialog(null, "Voce nao escolheu nome do arquivo ", "alerta",
							JOptionPane.ERROR_MESSAGE);
				} else {
					File arquivo = fileC.getSelectedFile();
					
					FileWriter arq;
					try {
					
						arq = new FileWriter(arquivo.getAbsolutePath());
						PrintWriter gravarArquivo = new PrintWriter(arq);
						
						
						String textoString = campoDeTexto.getText(); //transforma campo de texto em String
					    String senhaString = campoDeSenha.getText();//transforma o campo de texto da senha em string
					    
					    int deslocamento = senhaString.length();  // Pega tamando da senha de String e transforma em INTEIRO  
					    
					    
					    
					    
						 String sla = Caesar.criptografarCaesar(textoString,deslocamento);   
					     gravarArquivo.printf(sla + "%n");
					    
					     String voltaTextoCripto = sla;
					     
					     String limparSenha = senhaString;
					     
					     limparSenha = "Digite a senha para \n"+"descriptografar ou criptografar";
					     			     
					     campoDeSenha.setText(limparSenha);
					     
					     campoDeTexto.setText(voltaTextoCripto);
					     
						
						arq.close();

						JOptionPane.showMessageDialog(null,
								"O arquivo " + arquivo.getName() + " foi salvo com sucesso!", "alerta",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}

			}

		});

	
		// Botao para abrir arquivos
		botaoAbrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {

				if (a.getSource() == botaoAbrir) {
					JFileChooser fc = new JFileChooser();
					
					int i = fc.showOpenDialog(null);
					
					if (i == JFileChooser.APPROVE_OPTION) {
						File f = fc.getSelectedFile();
						String filePath = f.getPath();
						
						try {
							BufferedReader br = new BufferedReader(new FileReader(filePath));//O BufferedReader irá pegar essa String que será o caminho onde está o arquivo
							String s1 = "", s2 = "";
						    
							while ((s1 = br.readLine()) != null) { 	
								s2 += s1 + "\n";
							}
							
						
							 String testeSenha = campoDeSenha.getText();//transforma o campo de senha em uma string
							    
							 int deslocament = testeSenha.length(); // pega o tamanho da senha e transforma em um INTEIRO
							 
						    
						     String sla = Caesar.criptografarCaesar(s2,26-deslocament);
							
						     
						    campoDeTexto.setText(sla);
							
							br.close();
							
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}

			}

		});

		

		// tamanho da tela e para fechar com o X
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	
		

	}
	
}
 

