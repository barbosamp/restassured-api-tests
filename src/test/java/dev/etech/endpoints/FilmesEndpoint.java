package dev.etech.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.etech.config.RestConfig;
import dev.etech.pojo.filmes.FilmesRequest;
import dev.etech.pojo.usuarios.UsuarioResponse;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class FilmesEndpoint extends RestConfig {
    private FilmesRequest filmesRequest = new FilmesRequest();
    private ObjectMapper objectMapper = new ObjectMapper();

    public String carregaPayloadFilmesSucesso() throws JsonProcessingException {
                filmesRequest.setNome("Qas Em Ação");
                filmesRequest.setAnoLancamento(2024);
                filmesRequest.setLinkYoutube("https://you.tub.qa.test");
//                filmesRequest.setCapas(Arrays.asList("Capa 1","Capa 2","Capa 3"));
                filmesRequest.setCapas(List.of("Capa 1", "Capa 2", "Capa 3"));
                filmesRequest.setTags(List.of("Qa","Ação", "Bug"));
                filmesRequest.setDuracao(90);
                filmesRequest.setDirecao("Marcos Barbosa");

                return objectMapper.writeValueAsString(filmesRequest);
    }

    public Response realizaInsercaoFilme(String payload){
        response = request
                .header("Authorization", "Bearer " + accessToken)
                .body(payload)
                .when()
                .request(Method.POST, "/filmes");
        validaStatusCode(response.then());
        return response;
    }

    public void validaStatusCode(ValidatableResponse response){
        response.statusCode(201);
    }

    public void validaSucessoInsercaoFilme(UsuarioResponse response){

        assertThat(response.getMensagem(), is("Filme criado com sucesso."));
    }
}
