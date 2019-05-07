package SAGA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private HashMap<String, Produto> produtos;

    public Fornecedor(String nome, String email, String telefone)
    {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap<>();
    }

    public boolean cadastraProduto(String nome, String descricao, double preco)
    {
        String chave = nome + descricao;
        if (this.produtos.containsKey(chave))
        {
            return false;
        }
        Produto produto = new Produto(nome, descricao, preco);
        this.produtos.put(chave,produto);
        return true;
    }
    public String exibeProduto(String nome, String descricao)
    {
        String chave = nome + descricao;
        if (!this.produtos.containsKey(chave))
        {
            return "Produto não cadastrado.";
        }
        return this.produtos.get(chave).toString();
    }

    public String exibeTodosProdutos()
    {
        String msg = "";
        if (produtos.isEmpty())
        {
            return "Sem produtos cadastrados.";
        } else
        {
            for (Produto produto: produtos.values())
            {
                msg += produto.toString() + " | ";
            }
        }
        return msg.substring(0,msg.length()-3);
    }

    public String exibeTodosProdutosFornecedores()
    {
        String msg = "";
        if (produtos.isEmpty())
        {
            return "Sem produtos cadastrados.";
        } else
        {
            for (Produto produto: produtos.values())
            {
                msg += this.nome + produto.toString() + " | ";
            }
        }
        return msg;
    }

    public boolean editaPrecoProduto(String nome, String descricao, double preco)
    {
        String chave = nome + descricao;
        if (!this.produtos.containsKey(chave))
        {
            return false;
        }
        this.produtos.get(chave).setPreco(preco);
        return true;
    }

    public boolean removeProduto(String nome, String descricao)
    {
        String chave = nome + descricao;
        if (!this.produtos.containsKey(chave))
        {
            return false;
        }
        this.produtos.remove(chave);
        return true;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
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
