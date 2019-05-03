package SAGA;

import java.util.HashSet;
import java.util.Objects;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private HashSet<Produto> produtos;

    public Fornecedor(String nome, String email, String telefone)
    {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashSet<>();
    }

    public String exibeProduto(String nome, String descricao)
    {
        for (Produto produto: produtos)
        {
            if (produto.getNome().equals(nome) && produto.getDescricao().equals(descricao))
            {
                return produto.toString();
            }
        }
        return "Produto não cadastrado.";
    }

    public String exibeTodosProdutos(String nome, String descricao)
    {
        String msg = "";
        if (produtos.isEmpty())
        {
            return "Sem produtos cadastrados.";
        } else
        {
            for (Produto produto: produtos)
            {
                msg += produto.toString() + " | ";
            }
        }
        return msg;
    }

    public boolean editaPrecoProduto(String nome, String descricao, double preco)
    {
        for (Produto produto: produtos)
        {
            if (produto.getNome().equals(nome) && produto.getDescricao().equals(descricao))
            {
                produto.setPreco(preco);
                return true;
            }
        }
        return false;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telefone, that.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone);
    }

}
