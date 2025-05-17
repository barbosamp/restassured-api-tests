#language: pt
#enconded: UTF-8
#author: Marcos Barbosa
#version: 1.0

  Funcionalidade: Validar endpoint de Auth(Login)

    @login  @regressivo
    Cenario: Verificar login com sucesso
      Dado que o payload foi criado com dados validos de login
      Quando realizar a chamada de login
      Entao deve visualizar a mensagem de login "Logado com sucesso."