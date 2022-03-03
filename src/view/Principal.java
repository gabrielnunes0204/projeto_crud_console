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
			opcao = Utils.lerEntrada("Informe uma das op��es acima: ");
			
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
					System.out.println("USU�RIO CADASTRADO COM SUCESSO");
					break;
				case "2":
					System.out.println("");
					System.out.println("========================== ALTERA��O ==========================");
					System.out.println("");
					
					if (UsuarioService.get()) {
						idAlterar = Integer.parseInt(Utils.lerEntrada("Informe o ID do usu�rio que deseja alterar: "));
						System.out.println("");
						
						nome = Utils.lerEntrada("Informe o seu nome: ");
						idade = Integer.parseInt(Utils.lerEntrada("Informe a sua idade: "));
						email = Utils.lerEntrada("Informe o seu e-mail: ");
						senha = Utils.lerEntrada("Crie uma senha: ");						
						UsuarioService.update(idAlterar, nome, idade, email, senha);
						
						System.out.println("");
						System.out.println("USU�RIO ALTERADO COM SUCESSO");
					} else {
						System.out.println("N�o h� usu�rios cadastrados");
					}
					break;
				case "3":
					System.out.println("");
					System.out.println("========================== EXCLUS�O ==========================");
					System.out.println("");
					
					if (UsuarioService.get()) {
						idExcluir = Integer.parseInt(Utils.lerEntrada("Informe o ID do usu�rio que deseja exclu�r: "));
						
						UsuarioService.delete(idExcluir);
						
						System.out.println("");
						System.out.println("USU�RIO EXCLU�DO COM SUCESSO");
					} else {
						System.out.println("N�o h� usu�rios cadastrados");
					}
					break;
				case "4":
					System.out.println("");
					System.out.println("========================== CONSULTA ==========================");
					System.out.println("");
					if (UsuarioService.get()) {
						//NADA AQUI
					} else {
						System.out.println("N�o h� usu�rios cadastrados");
					}
					break;
				case "5":
					System.out.println("Aplica��o encerrada");
					System.exit(0);
					break;
				default:
					System.out.println("Op��o Inv�lida");
			}
		} while(!opcao.equals("5"));
	}
}
