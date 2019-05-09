package SAGA;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Sistema contralador dos fornecedores.
 * @author Lourival Gonçalves Prata Netto - 119111236 - UFCG.
 *
 */
public class ControllerFornecedor {

    private TreeMap<String, Fornecedor> fornecedores;

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
    public boolean cadastraFornecedor(String nome, String email, String telefone)
    {
        if (fornecedores.containsKey(nome))
        {
            return false;
        }
        Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
        this.fornecedores.put(nome, fornecedor);
        return true;
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
            return "Fornecedor não cadastrado.";
        }
        return fornecedores.get(nome).toString();
    }

    /**
	 * Exibe todos fornecedores validos.
	 * @return uma string que representa todos os fornecedores no formato NOME - EMAIL - TELEFONE | NOME - EMAIL - TELEFONE.
	 */
    public String exibeFornecedoresCadastrados()
    {
        String msg = "";
        if (fornecedores.isEmpty())
        {
            return "Nenhum fornecedor cadastrado.";
        } else
        {
            for (Fornecedor fornecedor : fornecedores.values())
            {
                msg += fornecedor.toString() + " | ";
            }
            return msg.substring(0, msg.length() - 3);
        }
    }

    /**
	 * Edita o email de um fornecedor valido apartir do seu nome e do novo email.
	 * @param nome nome do fornecedor.
	 * @param email novo email.
	 * @return retorna um booleano True se a edicao for um sucesso.
	 */
    public boolean editaFornecedorEmail(String nome, String email)
    {
        if (!this.fornecedores.containsKey(nome))
        {
            return false;
        }
        this.fornecedores.get(nome).setEmail(email);
        return true;
    }

    /**
	 * Edita o telefone de um fornecedor valido apartir do seu nome e do novo telefone.
	 * @param nome nome do fornecedor.
	 * @param telefone novo telefone.
	 * @return retorna um booleano True se a edicao for um sucesso.
	 */
    public boolean editaFornecedorTelefone(String nome, String telefone)
    {
        if (!this.fornecedores.containsKey(nome))
        {
            return false;
        }
        this.fornecedores.get(nome).setTelefone(telefone);
        return true;
    }

    /**
	 * Remove um fornecedor apartir do seu nome.
	 * @param nome nome do fornecedor.
	 * @return retorna um booleano True se a remocao do fornecedor for um sucesso.
	 */
    public boolean removeFornecedor(String nome)
    {
        if (!this.fornecedores.containsKey(nome))
        {
            return false;
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
    public boolean cadastraProduto(String nomeFornecedor, String nome, String descricao, double preco)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            return false;
        }
        return this.fornecedores.get(nomeFornecedor).cadastraProduto(nome, descricao, preco);

    }

    /**
	 * Exibe um produto apartir do seu nome, descricao e fornecedor.
	 *
     * @param nomeFornecedor nome do fornecedor do produto.
     * @param nome nome do produto.
	 * @param descricao descricao do produto.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeProduto(String nomeFornecedor, String nome, String descricao)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            return "Fornecedor não cadastrado.";
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
        String msg = "";
        if (this.fornecedores.isEmpty())
        {
            return "Nenhum fornecedor cadastrado.";
        } else {
            for (Fornecedor fornecedor : fornecedores.values())
            {
                msg += fornecedor.exibeTodosProdutosFornecedores();
            }
            return msg.substring(0,msg.length()-3);
        }
    }

    /**
	 * Edita o preco de um produto apartir do seu nome, descricao, nome do fornecedor e seu novo preco.
	 * @param nomeFornecedor nome do fornecedor.
	 * @param nome nome do produto.
	 * @param descricao descricao do produto.
	 * @param preco novo preco do produto.
	 * @return um booleano True se o produto for editado com sucesso.
	 */
    public boolean editaPrecoProduto(String nomeFornecedor, String nome, String descricao, double preco)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            return false;
        }
        return this.fornecedores.get(nomeFornecedor).editaPrecoProduto(nome, descricao, preco);
    }

    /**
	 * Remove um produto valido de um determinado fornecedor.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param nomeFornecedor nome do fornecedor do produto.
	 * @return retorna um booleano True se o produto for removido com sucesso.
	 */
    public boolean removeProduto(String nomeForncedor, String nome, String descricao)
    {
        if (!this.fornecedores.containsKey(nomeForncedor))
        {
            return false;
        }
        return this.fornecedores.get(nomeForncedor).removeProduto(nome, descricao);
    }


}
