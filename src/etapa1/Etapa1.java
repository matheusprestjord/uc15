package etapa1;

import persistencia.Usuario;
import java.util.List;
import java.util.Scanner;

public class Etapa1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criação de novo usuário
        Usuario usuario1 = new Usuario();
        
        
        // Registrar as informações do usuário
        System.out.println("Qual é o seu cargo?");
        usuario1.setCargo(scanner.nextLine());
        
        System.out.println("Qual é o seu nome? (Sem espaços e com letras minúsculas)");
        usuario1.setNome(scanner.nextLine());
        
        System.out.println("Crie uma senha");
        usuario1.setSenha(scanner.nextLine());
        
        // Definir as permissões do usuário dependendo do cargo
        
        /*
        Se alguém pode alterar uma permissão, automaticamente irá poder acessá-la. Fiz isso para reduzir redundâncias
        
        As permissões relacionadas com o estoque interagem com as classes produtos e insumos,
        O resto é auto-explicativo.
        */
        switch(usuario1.getCargo()) {
            case "gerente":
                usuario1.adicionarPermissao("alterarEstoque");
                usuario1.adicionarPermissao("alterarRelatorio");
                usuario1.adicionarPermissao("acessarVenda");
                usuario1.adicionarPermissao("alterarVenda");
                usuario1.adicionarPermissao("alterarReceita");
                usuario1.adicionarPermissao("alterarUsuario");
                usuario1.adicionarPermissao("alterarPromocao");
                usuario1.adicionarPermissao("alterarCaixa");
                usuario1.adicionarPermissao("alterarFidelidade");
                break;
            case "caixa":
                usuario1.adicionarPermissao("acessarEstoque");
                usuario1.adicionarPermissao("alterarRelatorio");
                usuario1.adicionarPermissao("alterarVenda");
                usuario1.adicionarPermissao("acessarPromocao");
                usuario1.adicionarPermissao("acessarNotificacao");
                usuario1.adicionarPermissao("alterarCaixa");
                usuario1.adicionarPermissao("alterarFidelidade");
                break;
            case "estoquista":
                usuario1.adicionarPermissao("alterarEstoque");
                usuario1.adicionarPermissao("alterarRelatorio");
                usuario1.adicionarPermissao("acessarNotificacao");
                break;
            case "padeiro":
                usuario1.adicionarPermissao("alterarEstoque");
                usuario1.adicionarPermissao("alterarReceita");
                usuario1.adicionarPermissao("acessarNotificacao");
                break;
            case "gestor financeiro":
                usuario1.adicionarPermissao("alterarRelatorio");
                usuario1.adicionarPermissao("acessarPromocao");
                usuario1.adicionarPermissao("acessarNotificacao");
                usuario1.adicionarPermissao("acessarCaixa");
                usuario1.adicionarPermissao("acessarVenda");
                break;
        }
    }
    
}
