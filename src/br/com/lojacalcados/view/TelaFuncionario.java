package br.com.lojacalcados.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import br.com.lojacalcados.dao.DAOContato;
import br.com.lojacalcados.dao.DAODadosPessoais;
import br.com.lojacalcados.dao.DAOEndereco;
import br.com.lojacalcados.dao.DAOFuncionario;
import br.com.lojacalcados.dao.DAOUsuario;
import br.com.lojacalcados.pojo.Contato;
import br.com.lojacalcados.pojo.DadosPessoais;
import br.com.lojacalcados.pojo.Endereco;
import br.com.lojacalcados.pojo.Funcionario;
import br.com.lojacalcados.pojo.Usuario;

public class TelaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeFun;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtEstado;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEmail;
	private JTextField txtCargo;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtDataNascimento;
	private JLabel lblEmail;
	private JFormattedTextField txtTelefoneResidencial;
	private JFormattedTextField txtTelefoneCelular;
	private JFormattedTextField txtTelefoneComercial;
	private JComboBox cboLogradouro;
	private JFormattedTextField txtCep;
	private JTable table;
	private JFormattedTextField txtExpediente;
	//instancias do pojo
	private Funcionario funcionario = new Funcionario();
	private DadosPessoais dp = new DadosPessoais();
	private Contato ct = new Contato();
	private Endereco end = new Endereco();
	private Usuario us = new Usuario();
	//Instancias do DAO
	private DAOFuncionario daofun= new DAOFuncionario();
	private DAODadosPessoais daodp = new DAODadosPessoais();
	private DAOContato daoct = new DAOContato();
	private DAOEndereco daoend = new DAOEndereco();
	private DAOUsuario daous = new DAOUsuario();
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
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
	public TelaFuncionario() {
		setResizable(false);
		setTitle("Tela Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1099, 826);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnldp = new JPanel();
		pnldp.setLayout(null);
		pnldp.setBackground(Color.WHITE);
		pnldp.setBounds(10, 172, 514, 115);
		contentPane.add(pnldp);
		
		JLabel lblNomeFuncionario = new JLabel("Nome do Funcion\u00E1rio");
		lblNomeFuncionario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeFuncionario.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNomeFuncionario.setBounds(10, 11, 145, 14);
		pnldp.add(lblNomeFuncionario);
		
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
		
		txtNomeFun = new JTextField();
		txtNomeFun.setColumns(10);
		txtNomeFun.setBounds(165, 8, 339, 20);
		pnldp.add(txtNomeFun);
		
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
		
		JPanel pnlEndereco = new JPanel();
		pnlEndereco.setLayout(null);
		pnlEndereco.setBackground(Color.WHITE);
		pnlEndereco.setBounds(10, 599, 1054, 136);
		contentPane.add(pnlEndereco);
		
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
		lblCompleto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompleto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCompleto.setBackground(Color.WHITE);
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
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(133, 34, 382, 20);
		pnlEndereco.add(txtLogradouro);
		
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
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		p.setBounds(534, 172, 530, 115);
		contentPane.add(p);
		
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
		
		JLabel lblEmail = new JLabel("E-mail");
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
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setLayout(null);
		pnlTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlTitulo.setBackground(new Color(106, 90, 205));
		pnlTitulo.setBounds(10, 11, 1059, 150);
		contentPane.add(pnlTitulo);
		
		JLabel lblicone = new JLabel("");
		lblicone.setIcon(new ImageIcon("C:\\Users\\hiago.lfsantos.SENACEDU\\Documents\\LojadeCalcados\\LojaCalcados\\imagens\\1256650.png"));
		lblicone.setBounds(10, 11, 139, 128);
		pnlTitulo.add(lblicone);
		
		JLabel lblGerenciarFuncionarios = new JLabel("Gerenciar Funcion\u00E1rios");
		lblGerenciarFuncionarios.setForeground(new Color(255, 255, 255));
		lblGerenciarFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblGerenciarFuncionarios.setBounds(159, 41, 299, 60);
		pnlTitulo.add(lblGerenciarFuncionarios);
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\hiago.lfsantos.SENACEDU\\Documents\\LojadeCalcados\\LojaCalcados\\imagens\\salvar-arquivo.png"));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(688, 11, 158, 128);
		pnlTitulo.add(btnSalvar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\hiago.lfsantos.SENACEDU\\Documents\\LojadeCalcados\\LojaCalcados\\imagens\\lupa.png"));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(885, 11, 158, 128);
		pnlTitulo.add(btnConsultar);
		
		JPanel pnldp_1 = new JPanel();
		pnldp_1.setLayout(null);
		pnldp_1.setBackground(Color.WHITE);
		pnldp_1.setBounds(10, 434, 514, 136);
		contentPane.add(pnldp_1);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCargo.setBounds(10, 29, 82, 14);
		pnldp_1.add(lblCargo);
		
		JLabel lblsetor = new JLabel("Setor");
		lblsetor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblsetor.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblsetor.setBounds(46, 54, 46, 14);
		pnldp_1.add(lblsetor);
		
		JLabel lblDataNascimento_1 = new JLabel("Gestor");
		lblDataNascimento_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNascimento_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblDataNascimento_1.setBounds(19, 81, 73, 14);
		pnldp_1.add(lblDataNascimento_1);
		
		JLabel lblExpediente = new JLabel("Expediente");
		lblExpediente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpediente.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblExpediente.setBounds(10, 107, 82, 14);
		pnldp_1.add(lblExpediente);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(102, 27, 339, 20);
		pnldp_1.add(txtCargo);
		
		JFormattedTextField txtSetor = new JFormattedTextField();
		txtSetor.setBounds(102, 52, 339, 20);
		pnldp_1.add(txtSetor);
		
		JFormattedTextField txtGestor = new JFormattedTextField();
		txtGestor.setBounds(102, 79, 162, 20);
		pnldp_1.add(txtGestor);
		try {
		txtExpediente = new JFormattedTextField(new  MaskFormatter("##:## - ##:##"));
		txtExpediente.setBounds(102, 105, 38, 20);
		pnldp_1.add(txtExpediente);
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		btnSalvar.setBackground(new Color(255, 255, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(534, 298, 530, 272);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hiago.lfsantos.SENACEDU\\Documents\\LojadeCalcados\\LojaCalcados\\imagens\\icons8-camera-50.png"));
		btnNewButton_1.setBounds(225, 203, 93, 58);
		panel.add(btnNewButton_1);
		
		JLabel lblfoto = new JLabel("Foto do funcion\u00E1rio");
		lblfoto.setBackground(Color.WHITE);
		lblfoto.setBounds(222, 25, 218, 138);
		panel.add(lblfoto);
		
		JPanel pnldp_1_1 = new JPanel();
		pnldp_1_1.setLayout(null);
		pnldp_1_1.setBackground(Color.WHITE);
		pnldp_1_1.setBounds(10, 298, 514, 123);
		contentPane.add(pnldp_1_1);
		
		JLabel lblUsuario = new JLabel("Usuaio:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblUsuario.setBounds(70, 32, 82, 14);
		pnldp_1_1.add(lblUsuario);
		
		JLabel lblsenha = new JLabel("Senha");
		lblsenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblsenha.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblsenha.setBounds(106, 57, 46, 14);
		pnldp_1_1.add(lblsenha);
		
		JLabel lblNivelAcesso = new JLabel("Nivel Acesso");
		lblNivelAcesso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNivelAcesso.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNivelAcesso.setBounds(49, 82, 103, 14);
		pnldp_1_1.add(lblNivelAcesso);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(162, 27, 162, 20);
		pnldp_1_1.add(txtUsuario);
		
		JFormattedTextField txtNivelAcesso = new JFormattedTextField();
		txtNivelAcesso.setBounds(162, 80, 162, 20);
		pnldp_1_1.add(txtNivelAcesso);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(162, 55, 162, 20);
		pnldp_1_1.add(txtSenha);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Passagem dos dados para o objeto endereco
				end.setTipo(cboLogradouro.getSelectedItem().toString());
				end.setLogradouro(txtLogradouro.getText());
				end.setNumero(txtNumero.getText());
				end.setComplemento(txtComplemento.getText());
				end.setCep(txtCep.getText());
				end.setBairro(txtBairro.getText());
				end.setCidade(txtCidade.getText());
				end.setEstado(txtEstado.getText());
				String rsend = daoend.create(end);
				end.setIdEndereco(Long.parseLong(rsend));
				
				//Passagem dos dados para o objeto contato
				ct.setTelefoneResidencial(txtTelefoneResidencial.getText());
				ct.setTelefoneCelular(txtTelefoneCelular.getText());
				ct.setTelefoneComercial(txtTelefoneComercial.getText());
				ct.setEmail(txtEmail.getText());
				String rsct = daoct.create(ct);
				ct.setIdContato(Long.parseLong(rsct));
			
				//Passagem dos dados para o objeto DadosPessoais
				dp.setCpf(txtCpf.getText());
				dp.setSexo(cboSexo.getSelectedItem().toString());
				dp.setDataNascimento(Date.valueOf(txtDataNascimento.getText()));
				String rsdp = daodp.create(dp);
				dp.setIdDadosPessoais(Long.parseLong(rsdp));
				
				//Passagem dos dados para o objeto Usuario
				us.setNomeUsuario(txtUsuario.getText());
				us.setSenha(txtSenha.getText());
				us.setNivelAcesso(txtNivelAcesso.getText());
				String rsus = daous.create(us);
				us.setIdUsuario(Long.parseLong(rsus));
				
				//Passagem dos dados par o objeto Funcionario
				funcionario.setNomeFuncionario(txtNomeFun.getText());
				funcionario.setCargo(txtCargo.getText());
				funcionario.setSetor(txtSetor.getText());
				funcionario.setGestor(Long.parseLong(txtGestor.getText()));
				funcionario.setExpediente(txtExpediente.getText());
				funcionario.setfoto("funcionario.jpg");
				funcionario.setDadosPessoais(dp);
				funcionario.setEndereco(end);
				funcionario.setContato(ct);
				funcionario.setUsuario(us);
				JOptionPane.showMessageDialog(null, daofun.create(funcionario));
				
			}
		});
		
	}
}
