package br.com.lojacalcados.dao;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lojacalcados.crud.ICR;
import br.com.lojacalcados.pojo.DadosPessoais;

public class DAODadosPessoais extends Conexao implements ICR<DadosPessoais>{

	@Override
	public String create(DadosPessoais obj) {
		String msg = "";
		try {
			if(abrirBanco()) {
				String query = "Insert Into dadospessoais(cpf,datanascimento,sexo)values(?,?,?)";
				/*
				 *Para execultar a consula é necessario carregá-la em memoria, assim usamos o comndo prepareStantement.
				 *Foi aplicado também o comando Stantement.RETURN_GENERATED_KEYS para pegar o id gerado no momento do cadastro dos dados pessoais 				 */
				pst = cx.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, obj.getCpf());
				pst.setDate(2, (Date) obj.getDataNascimento());
				pst.setString(3,obj.getSexo());
				//Executar o cadastro no banco
				int r = pst.executeUpdate();
				/*
				 * Para guardar o id gerado no momento da inserção foi execultado o comando getGeneateKeys e alocado na variavel de ResultSet(rs) a coluna
				 * de id da tabela dados pessoais*/
				rs = pst.getGeneratedKeys();
				
				/*
				 * Estamos verificando se o r que guarda o resultado do cadastro é maior que zero(0) e, se for irá retornar o id gerado no momento 
				 * do cadastro. O Id é do tipo Long(númerico), porem a variavel msg é do tipo String(texto), então foi necessaria fazer a conversão de tipos.
				 * sendo esta de numero para texto.
				 */
				
				if(r>0){
					if(rs.next()) {
						msg =String.valueOf(rs.getLong(1));
					}
				}
				else 
					msg = "Não foi possível cadastrar";				
			}else {
				msg = "Erro ao abrir o banco";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao tentar cadastrar -> "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado -> "+e.getMessage();
		}
		finally {
			fecharBanco();
		}
		return msg;
	}

	@Override
	public DadosPessoais read(DadosPessoais obj) {

		DadosPessoais dp = new DadosPessoais();
		
		try {
			if(abrirBanco()) {
				String query = "SELECT * FROM dadospessoais WHERE cpf=?";
				pst = cx.prepareStatement(query);
				pst.setString(1, obj.getCpf());
				rs = pst.executeQuery();
				if(rs.next()) {
					dp.setIdDadosPessoais(rs.getLong(1));
					dp.setCpf(rs.getString(2));
					dp.setDataNascimento(rs.getDate(3));
					dp.setSexo(rs.getString(4));
				}
				else {
					System.out.println("CPF não localizado");
				}
			}
			else {
				System.out.println("Erro ao abrir o banco");
			}
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar selecionar -> "+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado -> "+e.getMessage());
		}
		finally {
			fecharBanco();
		}
		return dp;
	}

	@Override
	public List<DadosPessoais> read() {
		
		List<DadosPessoais> lst = new ArrayList<DadosPessoais>();
		
		try {
			if(abrirBanco()) {
				String query = "SELECT * FROM dadospessoais";
				pst = cx.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next()) {
					DadosPessoais dp = new DadosPessoais();
					
					dp.setIdDadosPessoais(rs.getLong(1));
					dp.setCpf(rs.getString(2));
					dp.setDataNascimento(rs.getDate(3));
					dp.setSexo(rs.getString(4));
					
					lst.add(dp);
				}
			}
			else {
				System.out.println("Erro ao abrir o banco");
			}
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar selecionar -> "+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado -> "+e.getMessage());
		}
		finally {
			fecharBanco();
		}
		return lst;	
	}
	
	
}







