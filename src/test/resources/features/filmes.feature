#language: pt
#enconded: UTF-8
#author: Marcos Barbosa
#version: 1.0

Funcionalidade: Validar o endpoint de filmes
  Contexto: Realizar login na api
    Dado que o payload foi criado com dados validos de login
    E realizar a chamada de login

  @filmes @regressivo
  Cenario: Validar a inclusão de um filme com sucesso
    Dado que o payload foi criado com dados validos de um filme
    Quando envia a requisição para criar o filme
    Então deve visualizar a mensagem de sucesso na criação do filme