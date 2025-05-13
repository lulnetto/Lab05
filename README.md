# 💼 SAGA - Sistema de Administração de Gastos e Aquisições

Este projeto implementa um sistema de gerenciamento de clientes, fornecedores, produtos e compras. A classe `Facade` atua como ponto de entrada para testes de aceitação, centralizando as chamadas para a classe `Controller` e permitindo a integração com o EasyAccept.

## 📚 Sobre o Projeto

A `Facade` serve como camada intermediária entre a interface de teste (EasyAccept) e a lógica de negócio. Os casos de uso são testados por meio de arquivos `.txt` com os cenários de entrada esperados.

O projeto contempla funcionalidades como:

- Cadastro, edição e remoção de clientes e fornecedores.
- Cadastro, exibição, edição e remoção de produtos.
- Registro e consulta de compras.
- Cálculo de débitos por cliente e fornecedor.
