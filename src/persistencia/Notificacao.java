package persistencia;

import java.util.Date;

public class Notificacao {
    // Atributos
    private String mensagem;
    private String tipoNotificacao;
    private Date dataEnvio;
    
    // Construtor
    public Notificacao(String _mensagem, String _tipoNotificacao, Date _dataEnvio) {
        this.mensagem = _mensagem;
        this.tipoNotificacao = _tipoNotificacao;
        this.dataEnvio = _dataEnvio;
    }
    
    // Getters
    public String getMensagem() {
        return mensagem;
    }
    public String getTipoNotificacao() {
        return tipoNotificacao;
    }
    public Date getDataEnvio() {
        return dataEnvio;
    }
    
    // Setters
    public void setMensagem(String _mensagem) {
        this.mensagem = _mensagem;
    }
    public void setTipoNotificacao(String _tipoNotificacao) {
        this.tipoNotificacao = _tipoNotificacao;
    }
    public void setDataEnvio(Date _dataEnvio) {
        this.dataEnvio = _dataEnvio;
    }
    
    // Métodos
    public void enviarNotificacao() { }
    public void exibirNotificacoes() { }
}
