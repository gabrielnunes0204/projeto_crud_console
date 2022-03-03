package view;

import dao.BD;
import model.Usuario;
import service.UsuarioService;
import utils.Utils;

public class Principal {
	
	public static void main(String[] args) {
		String opcao = "";
		int idExcluir = 0, idAlterar = 0;
		
		do {
			System.out.println("");
			System.out.println("========================== MENU PRINCIPAL ==========================");
			System.out.println("");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Alterar Clientes");
			System.out.println("3 - Excluir Clientes");
			System.out.println("4 - Consultar Clientes");
			System.out.println("5 - Encerrar");
			opcao = Utils.lerEntrada("Informe uma das opções acima: ");
			
			switch(opcao) {
				case "1":
					System.out.println("");
					System.out.println("========================== CADASTRO ==========================");
					System.out.println("");
					String nome = Utils.lerEntrada("Informe o seu nome: ");
					Integer idade = Integer.parseInt(Utils.lerEntrada("Informe a sua idade: "));
					String email = Utils.lerEntrada("Informe o seu e-mail: ");
					String senha = Utils.lerEntrada("Crie uma senha: ");
					Usuario usuario = UsuarioService.create(nome, idade, email, senha);
					
					BD.listaUsuarios().add(usuario);
					
					System.out.println("");
					System.out.println("USUÁRIO CADASTRADO COM SUCESSO");
					break;
				case "2":
					System.out.println("");
					System.out.println("========================== ALTERAÇÃO ==========================");
					System.out.println("");
					
					if (UsuarioService.get()) {
						idAlterar = Integer.parseInt(Utils.lerEntrada("Informe o ID do usuário que deseja alterar: "));
						System.out.println("");
						
						nome = Utils.lerEntrada("Informe o seu nome: ");
						idade = Integer.parseInt(Utils.lerEntrada("Informe a sua idade: "));
						email = Utils.lerEntrada("Informe o seu e-mail: ");
						senha = Utils.lerEntrada("Crie uma senha: ");						
						UsuarioService.update(idAlterar, nome, idade, email, senha);
						
						System.out.println("");
						System.out.println("USUÁRIO ALTERADO COM SUCESSO");
					} else {
						System.out.println("Não há usuários cadastrados");
					}
					break;
				case "3":
					System.out.println("");
					System.out.println("========================== EXCLUSÃO ==========================");
					System.out.println("");
					
					if (UsuarioService.get()) {
						idExcluir = Integer.parseInt(Utils.lerEntrada("Informe o ID do usuário que deseja excluír: "));
						
						UsuarioService.delete(idExcluir);
						
						System.out.println("");
						System.out.println("USUÁRIO EXCLUÍDO COM SUCESSO");
					} else {
						System.out.println("Não há usuários cadastrados");
					}
					break;
				case "4":
					System.out.println("");
					System.out.println("========================== CONSULTA ==========================");
					System.out.println("");
					if (UsuarioService.get()) {
						//NADA AQUI
					} else {
						System.out.println("Não há usuários cadastrados");
					}
					break;
				case "5":
					System.out.println("Aplicação encerrada");
					System.exit(0);
					break;
				default:
					System.out.println("Opção Inválida");
			}
		} while(!opcao.equals("5"));
	}
}
