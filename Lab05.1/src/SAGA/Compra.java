package SAGA;

public class Compra
{
    private String data;
    private String produto;
    private double preco;

    public Compra(String data, String produto, double preco)
    {
        this.data = data;
        this.produto = produto;
        this.preco = preco;
    }

    public String getData()
    {
        return data;
    }

    public String getProduto()
    {
        return produto;
    }

    public double getPreco()
    {
        return preco;
    }

    @Override
    public String toString()
    {
        return this.produto + " - " + this.data;
    }
}
