package dev.etech.pojo.usuarios;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "mensagem",
        "dados",
        "timestamp"
})

public class UsuarioResponse {

    @JsonProperty("mensagem")
    private String mensagem;
    @JsonProperty("dados")
    private Dados dados;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("mensagem")
    public String getMensagem() {
        return mensagem;
    }

    @JsonProperty("mensagem")
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @JsonProperty("dados")
    public Dados getDados() {
        return dados;
    }

    @JsonProperty("dados")
    public void setDados(Dados dados) {
        this.dados = dados;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
