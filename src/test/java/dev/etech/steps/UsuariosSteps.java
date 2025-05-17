package dev.etech.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.etech.endpoints.UsuariosEndpoint;
import dev.etech.pojo.usuarios.UsuarioResponse;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class UsuariosSteps {
    private UsuariosEndpoint usuariosEndpoint = new UsuariosEndpoint();
    String jsonPayload;
    private Response responseData;

    @Dado("que payload possua dados de um novo usuário")
    public void que_o_payload_possua_dados_de_um_novo_usuario() throws JsonProcessingException {
        jsonPayload = usuariosEndpoint.carregaPayloadNovoUsuario();
    }

    @Quando("realizar a criação de um novo usuário")
    public void realizarACriaçãoDeUmNovoUsuário() {
        responseData = usuariosEndpoint.criarNovoUsuario(jsonPayload);
    }

    @Então("deve validar o status code {string}")
    public void deveValidarOStatusCode(String arg0) {

    }

    @Então("deve criar o usuario com sucesso")
    public void deveCriarOUsuarioComSucesso() {
        usuariosEndpoint.validaCadastroSucesso(responseData.getBody().as(UsuarioResponse.class));
    }

    @Dado("que o payload possua dados de um novo usuario com email existente")
    public void queOPayloadPossuaDadosDeUmNovoUsuarioComEmailExistente() throws JsonProcessingException {
        jsonPayload = usuariosEndpoint.carregaPayloadUsuarioExistente();
    }

    @Entao("deve visualizar a mensagem {string}")
    public void deveVisualizarAMensagem(String mensagemEsperada) {
        usuariosEndpoint.validaMensagemUsuarioExistente(
                responseData, mensagemEsperada);
    }
}
