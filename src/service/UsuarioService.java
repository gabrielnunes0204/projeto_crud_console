package service;

import dao.BD;
import model.Usuario;

public class UsuarioService {
	
	static public Usuario create(String nome, Integer idade, String email, String senha) {
		Usuario usuario = new Usuario(nome, idade, email, senha);
		
		return usuario;
	}
	
	static public void update(int id, String nome, Integer idade, String email, String senha) {
		BD.listaUsuarios.get(id).setNome(nome);
		BD.listaUsuarios.get(id).setIdade(idade);
		BD.listaUsuarios.get(id).setEmail(email);
		BD.listaUsuarios.get(id).setSenha(senha);
	}
	
	static public void delete(int id) {
		BD.listaUsuarios.remove(id);
	}
	
	static public boolean get() {
		if (BD.listaUsuarios.size() > 0) {
			for(int i = 0; i < BD.listaUsuarios().size(); i++) {
				System.out.println("ID: " + BD.listaUsuarios().get(i).getId() + "\n" +
								   "Nome: " + BD.listaUsuarios().get(i).getNome() + "\n" + 
								   "Idade: " + BD.listaUsuarios().get(i).getIdade() + " Anos" + "\n" +
								   "E-mail: " + BD.listaUsuarios().get(i).getEmail() + "\n" +
								   "Senha: " + BD.listaUsuarios.get(i).getSenha() + "\n");
			}
			return true;
		} else {
			return false;
		}
	}
}
