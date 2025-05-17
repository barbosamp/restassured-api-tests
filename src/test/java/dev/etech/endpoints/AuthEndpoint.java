package dev.etech.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.etech.config.RestConfig;
import dev.etech.pojo.auth.AuthRequest;
import dev.etech.pojo.usuarios.UsuarioResponse;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AuthEndpoint extends RestConfig {
    private AuthRequest authRequest = new AuthRequest();
    private ObjectMapper objectMapper = new ObjectMapper();


    public String carregaPayloadLoginSucesso() throws IOException {
        authRequest.setEmail("teste@teste12321.com.br");
        authRequest.setSenha("esse elit labore");
        return objectMapper.writeValueAsString(authRequest);
    }

    public Response realizaLogin(String payload){
        response = request
                .body(payload)
                .when()
                .request(Method.POST, "/auth/login");
        accessToken = response.getBody().jsonPath().get("dados.access_token");
        return response;
    }

    public void validaLoginSucesso(UsuarioResponse response, String mensagem){
        assertThat(response.getMensagem(), is(mensagem));
    }

}
