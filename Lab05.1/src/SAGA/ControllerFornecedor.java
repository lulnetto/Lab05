package SAGA;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Sistema contralador dos fornecedores.
 * @author Lourival Gonçalves Prata Netto - 119111236 - UFCG.
 *
 */
public class ControllerFornecedor {

    private Map<String, Fornecedor> fornecedores;

    /**
	 * Construtor que inicializa o TreeMap onde ficam armazenados os fornecedores.
	 */
    public ControllerFornecedor()
    {
        this.fornecedores = new TreeMap<>();
    }

    /**
	 * Adiciona um novo fornecedor valido apartir do seu nome, email e telefone.
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 * @return um booleano se fornecedor for cadastrado com sucesso.
	 */
    public String adicionaFornecedor(String nome, String email, String telefone)
    {
        if (fornecedores.containsKey(nome))
        {
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }
        Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
        this.fornecedores.put(nome, fornecedor);
        return nome;
    }

    /**
	 * Exibe um fornecedor valido apartir do seu nome.
	 * @param nome nome do fornecedor.
	 * @return uma string que representa o fornecedor no formato NOME - EMAIL - TELEFONE.
	 */
    public String exibeFornecedor(String nome)
    {
        if (!fornecedores.containsKey(nome))
        {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
        return fornecedores.get(nome).toString();
    }

    /**
	 * Exibe todos fornecedores validos.
	 * @return uma string que representa todos os fornecedores no formato NOME - EMAIL - TELEFONE | NOME - EMAIL - TELEFONE.
	 */
    public String exibeFornecedoresCadastrados()
    {
        return fornecedores.values().stream().map(fornecedor -> fornecedor.toString()).collect(Collectors.joining(" | "));

    }

    /**
	 * Edita o email de um fornecedor valido apartir do seu nome e do novo email.
	 * @param nome nome do fornecedor.
     * @param atributo qual atributo ele quer alterar.
     * @param novoAtributo qual o novo atributo.
	 * @return retorna um booleano True se a edicao for um sucesso.
	 */
    public boolean editaFornecedor(String nome, String atributo, String novoAtributo)
    {
        if (!this.fornecedores.containsKey(nome))
        {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        } else if (atributo == null || "".equals(atributo.trim()))
        {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        } else if (novoAtributo == null || "".equals(novoAtributo.trim()))
        {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        } else {
            switch (atributo)
            {
                case "telefone":
                    this.fornecedores.get(nome).setTelefone(novoAtributo);
                    return true;
                case "email":
                    this.fornecedores.get(nome).setEmail(novoAtributo);
                    return true;
                case "nome":
                    throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
                default:
                    throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
            }
        }
    }

    /**
	 * Remove um fornecedor apartir do seu nome.
	 * @param nome nome do fornecedor.
	 * @return retorna um booleano True se a remocao do fornecedor for um sucesso.
	 */
    public boolean removeFornecedor(String nome)
    {
        if ("".equals(nome.trim())) {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        } else if (!this.fornecedores.containsKey(nome))
        {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
        this.fornecedores.remove(nome);
        return true;
    }

    /**
	 * Adiciona um produto valido para determinado fornecedor.
	 * 
	 * @param nomeFornecedor fornecedor que vai ter aquele produto.
	 * @param nome nome do produto.
	 * @param descricao descricao do produto.
	 * @param preco preco do produto.
	 * @return um booleando True se o produto for adicionado com sucesso.
	 */
    public boolean adicionaProduto(String nomeFornecedor, String nome, String descricao, double preco)
    {
        if (nome == null || "".equals(nome.trim()))
        {
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || "".equals(descricao.trim()))
        {
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        } else if (preco < 0)
        {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        } else if (nomeFornecedor == null || "".equals(nomeFornecedor.trim()))
        {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            throw new NullPointerException("Erro no cadastro de produto: fornecedor nao existe.");
        }
        return this.fornecedores.get(nomeFornecedor).cadastraProdutoSimples(nome, descricao, preco);

    }

    /**
	 * Exibe um produto apartir do seu nome, descricao e fornecedor.
	 *
     * @param nomeFornecedor nome do fornecedor do produto.
     * @param nome nome do produto.
	 * @param descricao descricao do produto.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeProduto(String nome, String descricao,String nomeFornecedor)
    {
        if (nome == null || "".equals(nome.trim()))
        {
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || "".equals(descricao.trim()))
        {
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (nomeFornecedor == null || "".equals(nomeFornecedor.trim()))
        {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
        }
        return this.fornecedores.get(nomeFornecedor).exibeProduto(nome, descricao);
    }

    /**
	 * Exibe todos produtos de um fornecedor.
	 * @param nomeFornecedor nome do fornecedor.
	 * @return uma String com todos produtos do fornecedor, no formado FORNECEDOR - PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeTodosProduto(String nomeFornecedor)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            return "Fornecedor não cadastrado.";
        }
        return this.fornecedores.get(nomeFornecedor).exibeTodosProdutos();
    }

    /**
	 * Exibe todos produtos ja adicionados em ordem alfabetica do seu fornecedor.
	 * @return uma String com todos produtos, no formado FORNECEDOR - PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeTodosProdutoFornecedores()
    {
        return fornecedores.values().stream().map(fornecedor -> fornecedor.exibeTodosProdutosFornecedores()).collect(Collectors.joining(" | "));
    }

    /**
	 * Edita o preco de um produto apartir do seu nome, descricao, nome do fornecedor e seu novo preco.
	 * @param nomeFornecedor nome do fornecedor.
	 * @param nome nome do produto.
	 * @param descricao descricao do produto.
	 * @param preco novo preco do produto.
	 * @return um booleano True se o produto for editado com sucesso.
	 */
    public boolean editaProduto(String nomeFornecedor, String nome, String descricao, double preco)
    {
        if (nome == null || "".equals(nome.trim()))
        {
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || "".equals(descricao.trim()))
        {
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (preco < 0)
        {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        } else if (nomeFornecedor == null || "".equals(nomeFornecedor.trim()))
        {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        } else  if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            throw new NullPointerException("Erro na edicao de produto: fornecedor nao existe.");
        }
        return this.fornecedores.get(nomeFornecedor).editaPrecoProduto(nome, descricao, preco);
    }

    /**
	 * Remove um produto valido de um determinado fornecedor.
	 * @param nomeFornecedor nome do produto.
	 * @param descricao descricao do produto.
	 * @param nome nome do fornecedor do produto.
	 * @return retorna um booleano True se o produto for removido com sucesso.
	 */
    public boolean removeProduto(String nomeFornecedor, String nome, String descricao)
    {
        if (descricao == null || "".equals(descricao.trim()))
        {
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        } else if (nomeFornecedor == null || "".equals(nomeFornecedor.trim()))
        {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            throw new NullPointerException("Erro na remocao de produto: fornecedor nao existe.");
        } else if (nome == null || "".equals(nome.trim()))
        {
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        }
        return this.fornecedores.get(nomeFornecedor).removeProduto(nome, descricao);
    }

    public boolean adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProduto, String descricaoProduto)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            throw new IllegalArgumentException();
        }
        else
        {
            return this.fornecedores.get(nomeFornecedor).realizaCompra(cpf, data, nomeProduto, descricaoProduto);
        }
    }

    public double getDebito(String cpf, String nomeFornecedor)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            throw new IllegalArgumentException();
        } else return this.fornecedores.get(nomeFornecedor).getDebito(cpf);
    }

    public String exibeContas(String cpf, String nomeFornecedor)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            throw new IllegalArgumentException();
        } else return this.fornecedores.get(nomeFornecedor).getNome() + " | " + this.fornecedores.get(nomeFornecedor).exibeContas(cpf);
    }

}
