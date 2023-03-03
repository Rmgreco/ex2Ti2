package app;

import java.util.List;

import java.util.Scanner;

import dao.DAO;
import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {
	static int option;
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner (System.in);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		while(true) {
			menu();
		switch (option) {
			case 1: 
				System.out.println("\n\n==== Mostrar todos usuários === ");
				List<Usuario> usuarios = usuarioDAO.getAll();
				for (Usuario u: usuarios) {
					System.out.println(u.toString());
				}
				break;
			case 2:
				System.out.println("\n\n==== Inserir usuário === ");
				Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
				if(usuarioDAO.insert(usuario) == true) {
					System.out.println("Inserção com sucesso -> " + usuario.toString());
				}
				break;
			case 3:
				System.out.println("\n\n==== Excluir usuário === ");
				System.out.println("Digite o valor de cod:");
				int cod = scanner.nextInt();
				Usuario user = usuarioDAO.get(cod);
				usuarioDAO.delete(user.getCodigo());
				break;
			case 4:
				
				System.out.println("\n\n==== Atualizar senha) === ");
				System.out.println("Digite o valor de cod:");
				int codi = scanner.nextInt();
				Usuario users = usuarioDAO.get(codi);
				users.setSenha(DAO.toMD5("pablo"));
				usuarioDAO.update(users);
				break;
			case 5:
		        System.out.println("Saindo do programa...");
		        System.exit(0);
		         break;
			default:
				System.out.println("nao existe!");
		}
	}
}
	private static void menu() {
	    Scanner scanner = new Scanner (System.in);
		
		System.out.println("Menu: \n");
		System.out.println("1: Listar \n");
		System.out.println("2: Inserir \n");
		System.out.println("3: Excluir \n");
		System.out.println("4: Atualizar \n");
		System.out.println("5: Sair \n");
		option = scanner.nextInt();
		scanner.nextLine();
	}
}
