package dev.etech.steps;

import dev.etech.endpoints.AuthEndpoint;
import dev.etech.pojo.usuarios.UsuarioResponse;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import java.io.IOException;

public class LoginSteps {
    private AuthEndpoint authEndpoint = new AuthEndpoint();
    private String payload;
    private Response response;
    public static String accessToken = "";

    @Dado("que o payload foi criado com dados validos de login")
    public void que_o_payload_foi_criado_com_dados_validos_login() throws IOException {
        payload = authEndpoint.carregaPayloadLoginSucesso();

    }

    @Quando("realizar a chamada de login")
    public void realizarAChamadaDeLogin() {
        response = authEndpoint.realizaLogin(payload);
    }

    @Entao("deve visualizar a mensagem de login {string}")
    public void deveVisualizarAMensagemDeLogin(String mensagem) {
        authEndpoint.validaLoginSucesso(response.getBody().as(UsuarioResponse.class),mensagem);
    }
}
