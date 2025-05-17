package dev.etech.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.etech.config.RestConfig;
import dev.etech.pojo.usuarios.Endereco;
import dev.etech.pojo.usuarios.UsuarioRequest;
import dev.etech.pojo.usuarios.UsuarioResponse;
import dev.etech.utils.GeradorDeMassa;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UsuariosEndpoint extends RestConfig {
    private UsuarioRequest usuarioRequest = new UsuarioRequest();
    private Endereco endereco = new Endereco();
    private ObjectMapper objectMapper = new ObjectMapper();

    public String carregaPayloadNovoUsuario() throws JsonProcessingException {
        usuarioRequest.setNome(GeradorDeMassa.gerarNomeAleatorio());
        usuarioRequest.setApelido("Marcos QA");
        usuarioRequest.setTelefone("11998896868");
        usuarioRequest.setDataNascimento("2020-12-12T00:00:00.000Z");
        usuarioRequest.setEmail(GeradorDeMassa.gerarEmailAleatorio());
        usuarioRequest.setSenha("Teste@123");

        endereco.setCep("07790845");
        endereco.setRua("Rua teste");
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");

        usuarioRequest.setEndereco(endereco);

        usuarioRequest.setGoogleId("eeiguadsikjddasdsa");

        return objectMapper.writeValueAsString(usuarioRequest);

    }

    public String carregaPayloadUsuarioExistente() throws JsonProcessingException {
        usuarioRequest.setNome(GeradorDeMassa.gerarNomeAleatorio());
        usuarioRequest.setApelido("Marcos QA");
        usuarioRequest.setTelefone("11998896868");
        usuarioRequest.setDataNascimento("2020-12-12T00:00:00.000Z");
        usuarioRequest.setEmail("teste@teste12321.com.br");
        usuarioRequest.setSenha("Teste@123");

        endereco.setCep("07790845");
        endereco.setRua("Rua teste");
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");

        usuarioRequest.setEndereco(endereco);

        usuarioRequest.setGoogleId("eeiguadsikjddasdsa");

        return objectMapper.writeValueAsString(usuarioRequest);

    }

    public Response criarNovoUsuario(String payload){
        response = request
                .body(payload)
                .when()
                .request(Method.POST, "/usuarios");
        return response;
    }

//    public void validaCadastroSucesso(Response responseData){
//        responseData.then()
//                .log().all()
//                .statusCode(201)
//                .body("mensagem",equalTo("Usuário criado com sucesso."))
//                .body("dados.nome", equalTo(usuarioRequest.getNome()))
//                .body("timestamp",is(notNullValue()))
//                .body("dados._id",is(notNullValue()))
//                .body("dados.email",equalTo(usuarioRequest.getEmail()));
//    }

    public void validaCadastroSucesso(UsuarioResponse responseData){
        assertThat(responseData.getMensagem(),equalTo("Usuário criado com sucesso."));
        assertThat(responseData.getDados().getNome(),equalTo(usuarioRequest.getNome()));
        assertThat(responseData.getDados().getApelido(),equalTo(usuarioRequest.getApelido()));
    }

    public void validaMensagemUsuarioExistente(Response response, String mensagemEsperada){
        assertThat(response.getBody().as(UsuarioResponse.class).getMensagem(), is(mensagemEsperada));
    }
}
