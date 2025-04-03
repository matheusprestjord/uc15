package persistencia;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Atributos
    private String nome;
    private String cargo;
    private String senha;
    private List<String> permissoes;
    
    // Getters
    public String getNome() {
        return nome;
    }
    public String getCargo() {
        return cargo;
    }
    public String getSenha() {
        return senha;
    }
    public List<String> getPermissoes() {
        return permissoes;
    }
    
    // Setters
    public void setNome(String _nome) {
        this.nome = _nome;
    }
    public void setCargo(String _cargo) {
        this.cargo = _cargo;
    }
    public void setSenha(String _senha) {
        this.senha = _senha;
    }
    public void setPermissoes(List<String> _permissoes) {
        this.permissoes = _permissoes;
    }
    
    // Métodos
    public void login() { }
    public void consultarPermissoes() { }
    public void alterarPermissoes() { }
    public void adicionarPermissao(String _permissao) {
        if (this.permissoes == null) {
            this.permissoes = new ArrayList<>();
        }
        this.permissoes.add(_permissao);
    }
}
