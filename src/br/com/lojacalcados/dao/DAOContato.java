package br.com.lojacalcados.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lojacalcados.crud.ICRContato;
import br.com.lojacalcados.pojo.Contato;
import br.com.lojacalcados.pojo.DadosPessoais;

public class DAOContato extends Conexao implements ICRContato{

	@Override
	public String create(Contato obj) {
		String msg = "";
		try {
			if(abrirBanco()) {
				String query = "Insert Into contato(telefoneresidencial, telefonecelular, telefonecomercial, email)values(?,?,?,?)";
				/*
				 *Para execultar a consula é necessario carregá-la em memoria, assim usamos o comndo prepareStantement.
				 *Foi aplicado também o comando Stantement.RETURN_GENERATED_KEYS para pegar o id gerado no momento do cadastro dos dados pessoais 				 */
				pst = cx.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				
				pst.setString(1, obj.getTelefoneResidencial());
				pst.setString(2, obj.getTelefoneCelular());
				pst.setString(3,obj.getTelefoneComercial());
				pst.setString(4, obj.getEmail());
				
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

				if(r>0) {
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
	public Contato read(Contato obj) {
		
		Contato contato = new Contato();
		
		try {
			if(abrirBanco()) {
				String query = "SELECT * FROM contato WHERE email=?";
				pst = cx.prepareStatement(query);
				
				pst.setString(1, obj.getEmail());
				
				rs = pst.executeQuery();
				if(rs.next()) {
					contato.setIdContato(rs.getLong(1));
					contato.setTelefoneResidencial(rs.getString(2));
					contato.setTelefoneCelular(rs.getString(3));
					contato.setTelefoneComercial(rs.getString(4));
					contato.setEmail(rs.getString(5));
				}
				else {
					System.out.println("Email não localizado");
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
		return contato;
	}

	@Override
	public List<Contato> read() {
List<Contato> lst = new ArrayList<Contato>();
		
		try {
			if(abrirBanco()) {
				String query = "SELECT * FROM contato";
				pst = cx.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next()) {
					
					Contato contato = new Contato();
					
					contato.setIdContato(rs.getLong(1));
					contato.setTelefoneResidencial(rs.getString(2));
					contato.setTelefoneCelular(rs.getString(3));
					contato.setTelefoneComercial(rs.getString(4));
					contato.setEmail(rs.getString(5));
					
					lst.add(contato);
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

	@Override
	public String atualizarTelefone(Contato contato) {
		
		String msg = "";
		String query = "";
		try {
			if(contato.getTelefoneResidencial()!=null)
				query = "UPDATE contato SET telefoneresidencial=? where idcontato=?";
			else if(contato.getTelefoneCelular()!=null)
				query = "UPDATE contato SET telefonecelular=? where idcontato=?";
			else if(contato.getTelefoneComercial()!=null)
				query = "UPDATE contato SET telefonecomercial=? where idcontato=?";
			else msg="Não há telefone para atualizar";
			
			if(abrirBanco()) {
				pst = cx.prepareStatement(query);
				
				int rs = pst.executeUpdate();
				if(rs > 0) {
					msg = "Dados atualizados";
				}
				else {
					msg = "Não foi possível atualizar";
				}
			}
			else {
				msg = "Não foi possível abrir o banco";
			}
			
		}
		catch(SQLException se) {
			msg = "Erro ao tentar atualizar -> "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado -> "+e.getMessage();
		}
		finally {
			fecharBanco();
		}
		return msg;	
		
	}

}















