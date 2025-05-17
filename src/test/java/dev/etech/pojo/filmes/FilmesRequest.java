package dev.etech.pojo.filmes;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nome",
        "ano_lancamento",
        "link_youtube",
        "capas",
        "tags",
        "duracao",
        "direcao"
})
public class FilmesRequest {

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("ano_lancamento")
    private Integer anoLancamento;
    @JsonProperty("link_youtube")
    private String linkYoutube;
    @JsonProperty("capas")
    private List<String> capas;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("duracao")
    private Integer duracao;
    @JsonProperty("direcao")
    private String direcao;

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonProperty("ano_lancamento")
    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    @JsonProperty("ano_lancamento")
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @JsonProperty("link_youtube")
    public String getLinkYoutube() {
        return linkYoutube;
    }

    @JsonProperty("link_youtube")
    public void setLinkYoutube(String linkYoutube) {
        this.linkYoutube = linkYoutube;
    }

    @JsonProperty("capas")
    public List<String> getCapas() {
        return capas;
    }

    @JsonProperty("capas")
    public void setCapas(List<String> capas) {
        this.capas = capas;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("duracao")
    public Integer getDuracao() {
        return duracao;
    }

    @JsonProperty("duracao")
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @JsonProperty("direcao")
    public String getDirecao() {
        return direcao;
    }

    @JsonProperty("direcao")
    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

}