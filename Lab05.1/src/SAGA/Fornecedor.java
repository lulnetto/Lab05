package SAGA;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Representacao do fornecedor.
 * @author Lourival Gonçalves Prata Netto - 119111236 - UFCG.
 *
 */
public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private Map<String, Produto> produtos;

    /**
	 * Construtoi um novo fornecedor apatir do seu nome, email e telefone, e inicializa um HashMap de produtos desse fornecedor.
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 */
    public Fornecedor(String nome, String email, String telefone)
    {
        if(nome == null || "".equals(nome)) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }else if(email == null || "".equals(email)) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }else if(telefone == null || "".equals(telefone)) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new TreeMap<>();
    }

    /**
     * Seta um email para o fornecedor.
     * @param email novo email.
     */
    public void setEmail(String email)
    {
        if(email == null || "".equals(email)) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }
        this.email = email;
    }

    /**
     * Seta um telefone para o fornecedor.
     * @param telefone novo telefone.
     */
    public void setTelefone(String telefone)
    {
        if(telefone == null || "".equals(telefone)) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }
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

    /**
	 * Cadastra um novo produto no fornecedor com base no seu nome, descricao e preco, e adiciona ao HashMap de produtos onde a chave é uma string composta pelo nome + descricao.
	 * @param nome nome do produto.
     * @param descricao descricao do produto.
     * @param preco preco do produto.
	 * @return um booleano caso o produto seja adicionado com sucesso.
	 */
    public boolean cadastraProduto(String nome, String descricao, double preco)
    {

        String chave = nome + descricao;
        if (this.produtos.containsKey(chave))
        {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }
        Produto produto = new Produto(nome, descricao, preco);
        this.produtos.put(chave,produto);
        return true;
    }
    /**
	 * Exibe um produto apatir do seu nome e descricao.
	 * @param nome nome do produto.
     * @param descricao descricao do produto.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeProduto(String nome, String descricao)
    {
        String chave = nome + descricao;
        if (!this.produtos.containsKey(chave))
        {
            throw new NullPointerException("Erro na exibicao de produto: produto nao existe.");
        }
        return this.produtos.get(chave).toString();
    }

    /**
	 * Exibe todos os produtos já cadastrados de um determinado fornecedor.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO | PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeTodosProdutos()
    {
        if (produtos.isEmpty())
        {
            return "Sem produtos cadastrados.";
        }
        return produtos.values().stream().map(produto -> produto.toString()).collect(Collectors.joining(" | "));

    }

    /**
	 * Exibe todos os produtos já cadastrados de todos os fornecedores.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO | PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeTodosProdutosFornecedores()
    {
        return produtos.values().stream()

                .map(produto -> produto.toString())
                .collect(Collectors.joining(" | "));

    }

    /**
	 * Edita o preco de um produto apartir do seu nome, descricao e do seu novo preco.
	 * @param nome nome do produto.
     * @param descricao descricao do produto.
	 * @param preco novo valor do produto.
	 * @return retorna um booleano True caso a edicao seja um sucesso.
	 */
    public boolean editaPrecoProduto(String nome, String descricao, double preco)
    {
        String chave = nome + descricao;
        if (!this.produtos.containsKey(chave))
        {
            throw new NullPointerException("Erro na edicao de produto: produto nao existe.");
        }
        this.produtos.get(chave).setPreco(preco);
        return true;
    }

    /**
	 * Remove um produto do fornecedor apartir do nome do produto e sua descricao.
	 * @param nome nome do produto.
     * @param descricao descricao do produto.
	 * @return retorna um booleano True caso o produto seja removido com sucesso.
	 */
    public boolean removeProduto(String nome, String descricao)
    {
        String chave = nome + descricao;
        if (!this.produtos.containsKey(chave))
        {
            throw new NullPointerException("Erro na remocao de produto: produto nao existe.");
        }
        this.produtos.remove(chave);
        return true;
    }



}
