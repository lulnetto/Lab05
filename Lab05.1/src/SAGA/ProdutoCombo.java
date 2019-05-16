package SAGA;

import java.util.HashSet;
import java.util.Set;

public class ProdutoCombo implements Produto
{
    private String nome;
    private String descricao;
    private double preco;
    private double desconto;
    private Set<ProdutoSimples> produtos;

    public ProdutoCombo(String nome, String descricao, double desconto, Set<ProdutoSimples> produtos)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = 0;
        this.desconto = desconto;
        this.produtos = produtos;
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
