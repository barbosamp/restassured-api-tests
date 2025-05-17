#language: pt
#encoded: UTF-8
#author: Marcos Barbosa
#version: 1.0

@cadastro
Funcionalidade: Validar o endpoint de usuários

    @cadastroSucesso @smokeTest @regressivo
    Cenario: Verificar cadastro de novo usuário com sucesso
        Dado que payload possua dados de um novo usuário
        Quando realizar a criação de um novo usuário
        Então deve criar o usuario com sucesso

    @emailExistente  @regressivo
    Cenario: Verificar mensagem de erro ao utilizar e-mail existente
        Dado que o payload possua dados de um novo usuario com email existente
        Quando realizar a criação de um novo usuário
        Entao deve visualizar a mensagem "Este e-mail já está sendo utilizado."
