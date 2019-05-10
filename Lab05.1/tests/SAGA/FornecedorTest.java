import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest
{

    Fornecedor f = new Fornecedor("Seu Olavo","shausha","465465");

    @Test
    void exibeTodosProdutosFornecedores()
    {
        f.cadastraProduto("Cuzcuz","Milho",7);
        f.cadastraProduto("Cuzcuz2","Milho",7);
        f.cadastraProduto("Cuzcuz3","Milho",7);
        String msg = "Cuzcuz - Milho - R$7.0 | Cuzcuz3 - Milho - R$7.0 | Cuzcuz2 - Milho - R$7.0";
        Assertions.assertEquals(msg,f.exibeTodosProdutosFornecedores());
    }
}