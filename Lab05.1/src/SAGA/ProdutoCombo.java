package SAGA;

import java.util.HashSet;
import java.util.Set;

public class ProdutoCombo implements Produto
{
    private String nome;
    private String descricao;
    private double preco;
    private double desconto;
    private Set<Produto> produtos;

    public ProdutoCombo(String nome, String descricao, double preco, double desconto)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.desconto = desconto;
        this.produtos = new HashSet<>();
    }



    @Override
    public String getNome()
    {
        return this.nome;
    }

    @Override
    public String getDescricao()
    {
        return this.descricao;
    }

    @Override
    public double getPreco()
    {
        return this.preco;
    }

    @Override
    public void setPreco(double preco)
    {

    }
}
