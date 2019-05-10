package SAGA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    @Test
    void getNome()
    {
        Fornecedor f = new Fornecedor("nome", "email", "telefone");
        assertEquals("nome",f.getNome());
    }

    @Test
    void getEmail()
    {
        Fornecedor f = new Fornecedor("nome", "email", "telefone");
        assertEquals("email",f.getEmail());
    }

    @Test
    void getTelefone()
    {
        Fornecedor f = new Fornecedor("nome", "email", "telefone");
        assertEquals("telefone",f.getTelefone());
    }

    @Test
    void testtoString()
    {
        Fornecedor f = new Fornecedor("nome", "email", "telefone");
        assertEquals("nome - email - telefone",f.toString());
    }

    @Test
    void cadastraProduto()
    {
    }

    @Test
    void exibeProduto()
    {
    }

    @Test
    void exibeTodosProdutos()
    {
    }

    @Test
    void exibeTodosProdutosFornecedores()
    {
    }

    @Test
    void editaPrecoProduto()
    {
    }

    @Test
    void removeProduto()
    {
    }
}