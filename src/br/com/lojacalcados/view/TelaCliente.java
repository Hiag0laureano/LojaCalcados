package br.com.lojacalcados.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.lojacalcados.dao.DAOCliente;
import br.com.lojacalcados.dao.DAOContato;
import br.com.lojacalcados.dao.DAODadosPessoais;
import br.com.lojacalcados.dao.DAOEndereco;
import br.com.lojacalcados.pojo.Cliente;
import br.com.lojacalcados.pojo.Contato;
import br.com.lojacalcados.pojo.DadosPessoais;
import br.com.lojacalcados.pojo.Endereco;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtDataNascimento;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JFormattedTextField txtTelefoneResidencial;
	private JFormattedTextField txtTelefoneCelular;
	private JFormattedTextField txtTelefoneComercial;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtEstado;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JComboBox cboLogradouro;
	private JFormattedTextField txtCep;
	private JTable table;
	private JScrollPane scrollPane;
	//instancias do pojo
	private Cliente cliente = new Cliente();
	private DadosPessoais dp = new DadosPessoais();
	private Contato ct = new Contato();
	private Endereco end = new Endereco();
	//Instancias do DAO
	private DAOCliente daocli = new DAOCliente();
	private DAODadosPessoais daodp = new DAODadosPessoais();
	private DAOContato daocontato = new DAOContato();
	private DAOEndereco daoend = new DAOEndereco();
			

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCliente() {
		setResizable(false);
		setTitle("Tela Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlTitulo.setBackground(new Color(123, 104, 238));
		pnlTitulo.setBounds(10, 11, 1059, 150);
		contentPane.add(pnlTitulo);
		pnlTitulo.setLayout(null);
		
		JLabel lblicone = new JLabel("");
		lblicone.setIcon(new ImageIcon("C:\\Users\\hiago.lfsantos.SENACEDU\\Documents\\LojadeCalcados\\LojaCalcados\\imagens\\pessoas.png"));
		lblicone.setBounds(10, 11, 139, 128);
		pnlTitulo.add(lblicone);
		
		JLabel lblTituloTela = new JLabel("Gerenciar Clientes");
		lblTituloTela.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTituloTela.setBounds(159, 41, 244, 60);
		pnlTitulo.add(lblTituloTela);
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\hiago.lfsantos.SENACEDU\\Documents\\LojadeCalcados\\LojaCalcados\\imagens\\salvar-arquivo.png"));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.setBounds(688, 11, 158, 128);
		pnlTitulo.add(btnSalvar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(255, 255, 255));
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\hiago.lfsantos.SENACEDU\\Documents\\LojadeCalcados\\LojaCalcados\\imagens\\lupa.png"));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultar.setBounds(885, 11, 158, 128);
		pnlTitulo.add(btnConsultar);
		
		JPanel pnldp = new JPanel();
		pnldp.setBackground(new Color(255, 255, 255));
		pnldp.setBounds(10, 172, 514, 115);
		contentPane.add(pnldp);
		pnldp.setLayout(null);
		
		JLabel lblNomeCliente = new JLabel("Nome do Cliente");
		lblNomeCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeCliente.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNomeCliente.setBounds(10, 11, 145, 14);
		pnldp.add(lblNomeCliente);
		
		JLabel lblcpf = new JLabel("CPF");
		lblcpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblcpf.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblcpf.setBounds(109, 36, 46, 14);
		pnldp.add(lblcpf);
		
		JLabel lblDataNascimento = new JLabel("Data nascimento");
		lblDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNascimento.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblDataNascimento.setBounds(10, 61, 145, 14);
		pnldp.add(lblDataNascimento);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblSexo.setBounds(73, 88, 82, 14);
		pnldp.add(lblSexo);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(165, 8, 339, 20);
		pnldp.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		try {
		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBounds(165, 33, 339, 20);
		pnldp.add(txtCpf);
		
		txtDataNascimento = new JFormattedTextField(new  MaskFormatter("####-##-##"));
		txtDataNascimento.setBounds(165, 60, 162, 20);
		pnldp.add(txtDataNascimento);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JComboBox cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino", "Outros"}));
		cboSexo.setBounds(165, 85, 97, 22);
		pnldp.add(cboSexo);
		
		JPanel p = new JPanel();
		p.setBackground(new Color(255, 255, 255));
		p.setBounds(534, 172, 530, 115);
		contentPane.add(p);
		p.setLayout(null);
		
		JLabel lblTelefoneResidencial = new JLabel("Telefone Residencial");
		lblTelefoneResidencial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneResidencial.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTelefoneResidencial.setBounds(10, 11, 145, 14);
		p.add(lblTelefoneResidencial);
		
		JLabel lblTelefoneCelular = new JLabel("Telefone Celular");
		lblTelefoneCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneCelular.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTelefoneCelular.setBounds(10, 36, 145, 14);
		p.add(lblTelefoneCelular);
		
		JLabel lblTelefoneComercial = new JLabel("Telefone Comercial");
		lblTelefoneComercial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneComercial.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTelefoneComercial.setBounds(10, 62, 145, 14);
		p.add(lblTelefoneComercial);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEmail.setBounds(10, 90, 145, 14);
		p.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(165, 88, 339, 20);
		p.add(txtEmail);
		
		try {
		txtTelefoneResidencial = new JFormattedTextField(new MaskFormatter("(##)####-####"));
		txtTelefoneResidencial.setBounds(165, 9, 339, 20);
		p.add(txtTelefoneResidencial);
		
		txtTelefoneCelular = new JFormattedTextField(new MaskFormatter("(##)9####-####"));
		txtTelefoneCelular.setBounds(165, 34, 339, 20);
		p.add(txtTelefoneCelular);
		
		txtTelefoneComercial = new JFormattedTextField(new MaskFormatter("(##)####-####"));
		txtTelefoneComercial.setBounds(165, 60, 339, 20);
		p.add(txtTelefoneComercial);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		JPanel pnlEndereco = new JPanel();
		pnlEndereco.setBackground(new Color(255, 255, 255));
		
		pnlEndereco.setBounds(10, 310, 1059, 115);
		contentPane.add(pnlEndereco);
		pnlEndereco.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo Logradouro");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTipo.setBounds(10, 11, 101, 14);
		pnlEndereco.add(lblTipo);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogradouro.setFont(new Font("Arial", Font.PLAIN, 13));
		lblLogradouro.setBounds(10, 36, 101, 14);
		pnlEndereco.add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumero.setBounds(10, 61, 101, 14);
		pnlEndereco.add(lblNumero);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCep.setBounds(10, 86, 101, 14);
		pnlEndereco.add(lblCep);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 13));
		lblBairro.setBounds(525, 86, 101, 14);
		pnlEndereco.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCidade.setBounds(525, 61, 101, 14);
		pnlEndereco.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEstado.setBounds(525, 36, 101, 14);
		pnlEndereco.add(lblEstado);
		
		JLabel lblCompleto = new JLabel("Complemento");
		lblCompleto.setBackground(new Color(255, 255, 255));
		lblCompleto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompleto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCompleto.setBounds(525, 11, 101, 14);
		pnlEndereco.add(lblCompleto);
		
		
		cboLogradouro = new JComboBox();
		cboLogradouro.setModel(new DefaultComboBoxModel(new String[] {"Rua", "Avenida", "Pra\u00E7a", "Alameda", "Viela", "Estrada", "Travessa"}));
		cboLogradouro.setBounds(133, 6, 382, 22);
		pnlEndereco.add(cboLogradouro);
		
		try {
		txtCep = new JFormattedTextField(new MaskFormatter ("#####-###"));
		txtCep.setBounds(133, 86, 382, 20);
		pnlEndereco.add(txtCep);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(133, 34, 382, 20);
		pnlEndereco.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(133, 60, 382, 20);
		pnlEndereco.add(txtNumero);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(667, 8, 382, 20);
		pnlEndereco.add(txtComplemento);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(667, 33, 382, 20);
		pnlEndereco.add(txtEstado);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(667, 58, 382, 20);
		pnlEndereco.add(txtCidade);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(667, 83, 382, 20);
		pnlEndereco.add(txtBairro);
		
		JPanel pnlCLiente = new JPanel();
		pnlCLiente.setBackground(new Color(255, 255, 255));
		pnlCLiente.setBounds(10, 436, 1059, 180);
		contentPane.add(pnlCLiente);
		pnlCLiente.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1039, 158);
		pnlCLiente.add(scrollPane);
		
		carregarDados();
		
		
		btnSalvar.setBackground(new Color(255, 255, 255));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Fazer as passagens do elemento do formulario para os respectivos objetos e depois cadastrar
				end.setTipo(cboLogradouro.getSelectedItem().toString());
				end.setLogradouro(txtLogradouro.getText());
				end.setNumero(txtNumero.getText());
				end.setComplemento(txtComplemento.getText());
				end.setCep(txtCep.getText());
				end.setBairro(txtBairro.getText());
				end.setCidade(txtCidade.getText());
				end.setEstado(txtEstado.getText());
				//efetuar a gravação do endereco na tabela.
				//o id sera alocado em uma variavel
				String rse = daoend.create(end); 
				
				//passagem dos dados para o objeto contato
				ct.setTelefoneResidencial(txtTelefoneResidencial.getText());
				ct.setTelefoneCelular(txtTelefoneCelular.getText());
				ct.setTelefoneComercial(txtTelefoneComercial.getText());
				ct.setEmail(txtEmail.getText());
				String rsc = daocontato.create(ct);
				
				//passagem dos dados para o objeto dadospessoais
				dp.setCpf(txtCpf.getText());
				dp.setDataNascimento(Date.valueOf(txtDataNascimento.getText()));
				dp.setSexo(cboSexo.getSelectedItem().toString());
				String rsdp = daodp.create(dp);
				
				//passagem dos dados para o objeto cliente
				cliente.setNomeCliente(txtNomeCliente.getText());
				
				dp.setIdDadosPessoais(Long.parseLong(rsdp));
				cliente.setDadosPessoais(dp);
				
				ct.setIdContato(Long.parseLong(rsc));
				cliente.setContato(ct);
				
				end.setIdEndereco(Long.parseLong(rse));
				cliente.setEndereco(end);
				
				JOptionPane.showMessageDialog(null, daocli.create(cliente));
				carregarDados();
				
			}
		});
	}
	
	private void carregarDados() {
		//Construir o cabeçalho da tabela
				String[] cabecalho = {
						  "ID do Cliente",
							"Nome do Cliente",
							"CPF",
							"Sexo",
							"Tel.Residencial",
							"Tel.Celular",
							"Tel.Comercial",
							"E-mail",
							"Tipo",
							"Logradouro",
							"Número",
							"Complemento",
							"CEP",
							"Bairro",
							"Cidade",
							"Estado"
						 
				};
				
				List<Cliente> lstcliente = new ArrayList<Cliente>();
				lstcliente = daocli.read();
				Object[] dados = new Object[16];
				DefaultTableModel tm = new DefaultTableModel(cabecalho,0);		
				for(int i = 0 ; i < lstcliente.size() ; i++) {
					
					
					dados[0] = lstcliente.get(i).getIdCliente();
					dados[1] = lstcliente.get(i).getNomeCliente();
					dados[2] = lstcliente.get(i).getDadosPessoais().getCpf();
					dados[3] = lstcliente.get(i).getDadosPessoais().getSexo();
					dados[4] = lstcliente.get(i).getContato().getTelefoneResidencial();
					dados[5] = lstcliente.get(i).getContato().getTelefoneCelular();
					dados[6] = lstcliente.get(i).getContato().getTelefoneComercial();
					dados[7] = lstcliente.get(i).getContato().getEmail();
					dados[8] = lstcliente.get(i).getEndereco().getTipo();
					dados[9] = lstcliente.get(i).getEndereco().getLogradouro();
					
					dados[10] = lstcliente.get(i).getEndereco().getNumero();
					dados[11] = lstcliente.get(i).getEndereco().getComplemento();
					dados[12] = lstcliente.get(i).getEndereco().getCep();
					dados[13] = lstcliente.get(i).getEndereco().getBairro();
					dados[14] = lstcliente.get(i).getEndereco().getCidade();
					dados[15] = lstcliente.get(i).getEndereco().getEstado();
					
					tm.addRow(dados);			
				}
				
				table = new JTable(tm);
				scrollPane.setViewportView(table);
	}
	
	
}



