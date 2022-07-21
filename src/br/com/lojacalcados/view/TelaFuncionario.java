package br.com.lojacalcados.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

public class TelaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtLogradouro;
	private JTextField textField_2;
	private JTextField txtComplemento;
	private JTextField txtEstado;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEmail;
	private JTextField txtCargo;
	private JTextField txtNomeCliente;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtDataNascimento;
	private JLabel lblEmail;
	private JFormattedTextField txtTelefoneResidencial;
	private JFormattedTextField txtTelefoneCelular;
	private JFormattedTextField txtTelefoneComercial;
	private JTextField txtNumero;
	private JComboBox cboLogradouro;
	private JFormattedTextField txtCep;
	private JTable table;
	private JScrollPane scrollPane;

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
		setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1099, 876);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(165, 8, 339, 20);
		pnldp.add(textField);
		
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
		cboSexo.setBounds(165, 85, 97, 22);
		pnldp.add(cboSexo);
		
		JPanel pnlEndereco = new JPanel();
		pnlEndereco.setLayout(null);
		pnlEndereco.setBackground(Color.WHITE);
		pnlEndereco.setBounds(10, 298, 1059, 115);
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
		
		JComboBox cboLogradouro = new JComboBox();
		cboLogradouro.setBounds(133, 6, 382, 22);
		pnlEndereco.add(cboLogradouro);
		
		JFormattedTextField txtCep = new JFormattedTextField((AbstractFormatter) null);
		txtCep.setBounds(133, 86, 382, 20);
		pnlEndereco.add(txtCep);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(133, 34, 382, 20);
		pnlEndereco.add(txtLogradouro);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 60, 382, 20);
		pnlEndereco.add(textField_2);
		
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
		
		JFormattedTextField txtTelefoneResidencial = new JFormattedTextField((AbstractFormatter) null);
		txtTelefoneResidencial.setBounds(165, 9, 339, 20);
		p.add(txtTelefoneResidencial);
		
		JFormattedTextField txtTelefoneCelular = new JFormattedTextField((AbstractFormatter) null);
		txtTelefoneCelular.setBounds(165, 34, 339, 20);
		p.add(txtTelefoneCelular);
		
		JFormattedTextField txtTelefoneComercial = new JFormattedTextField((AbstractFormatter) null);
		txtTelefoneComercial.setBounds(165, 60, 339, 20);
		p.add(txtTelefoneComercial);
		
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
		
		JPanel pnlCLiente = new JPanel();
		pnlCLiente.setLayout(null);
		pnlCLiente.setBackground(Color.WHITE);
		pnlCLiente.setBounds(14, 646, 1059, 180);
		contentPane.add(pnlCLiente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1039, 158);
		pnlCLiente.add(scrollPane);
		
		JPanel pnldp_1 = new JPanel();
		pnldp_1.setLayout(null);
		pnldp_1.setBackground(Color.WHITE);
		pnldp_1.setBounds(10, 455, 514, 115);
		contentPane.add(pnldp_1);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCargo.setBounds(10, 10, 145, 14);
		pnldp_1.add(lblCargo);
		
		JLabel lblsetor = new JLabel("Setor");
		lblsetor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblsetor.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblsetor.setBounds(109, 36, 46, 14);
		pnldp_1.add(lblsetor);
		
		JLabel lblDataNascimento_1 = new JLabel("Gestor");
		lblDataNascimento_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNascimento_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblDataNascimento_1.setBounds(10, 61, 145, 14);
		pnldp_1.add(lblDataNascimento_1);
		
		JLabel lblExpediente = new JLabel("Expediente");
		lblExpediente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpediente.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblExpediente.setBounds(73, 88, 82, 14);
		pnldp_1.add(lblExpediente);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(165, 8, 339, 20);
		pnldp_1.add(txtCargo);
		
		JFormattedTextField txtSetor = new JFormattedTextField();
		txtSetor.setBounds(165, 33, 339, 20);
		pnldp_1.add(txtSetor);
		
		JFormattedTextField txtGestor = new JFormattedTextField();
		txtGestor.setBounds(165, 60, 162, 20);
		pnldp_1.add(txtGestor);
		
		JComboBox cboSexo_1 = new JComboBox();
		cboSexo_1.setBounds(165, 85, 97, 22);
		pnldp_1.add(cboSexo_1);
	}

}
