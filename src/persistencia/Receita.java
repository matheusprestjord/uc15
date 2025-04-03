package persistencia;

public class Receita {
    // Atributos
    private int id;
    private String nome;
    private String modoPreparo;
    
   // Getters e setters
    public int getId() {
        return id;
    }
    public void setId(int _id) {
        this.id = _id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String _nome) {
        this.nome = _nome;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }
    public void setModoPreparo(String _modoPreparo) {
        this.modoPreparo = _modoPreparo;
    }
}
