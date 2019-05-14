package SAGA;

import java.util.Objects;

public class ProdutoSimples implements Produto
{

    private String nome;
    private String descricao;
    private double preco;

    public ProdutoSimples(String nome, String descricao, double preco)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
	 * Pega o nome do produto.
	 * @return retorna o nome do produto.
	 */
    public String getNome() {
        return this.nome;
    }

    /**
	 * Pega a descricao do produto.
	 * @return retorna a descricao do produto.
	 */
    public String getDescricao() {
        return this.descricao;
    }

    /**
	 * Pega o preco do produto.
	 * @return retorna o preco do produto.
	 */
    public double getPreco()
    {
        return this.preco;
    }
    /**
	 * Seta um novo preco do Produto.
	 * @param preco novo preco ou fator de desconto do Produto.
	 */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
	 * Representacao do Produto em String.
	 * @return retorna uma String que representa o Produto.
	 */
    @Override
    public String toString() {
        return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",this.preco);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoSimples produto = (ProdutoSimples) o;
        return Objects.equals(nome, produto.nome) &&
                Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
