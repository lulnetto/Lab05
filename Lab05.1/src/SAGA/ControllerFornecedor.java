package SAGA;

import java.util.HashMap;
import java.util.TreeMap;

public class ControllerFornecedor {

    private TreeMap<String, Fornecedor> fornecedores;

    public ControllerFornecedor()
    {
        this.fornecedores = new TreeMap<>();
    }

    public boolean cadastraFornecedor(String nome, String email, String telefone)
    {
        if (fornecedores.containsKey(nome))
        {
            return false;
        }
        Fornecedor fornecedor = new Fornecedor(nome,email,telefone);
        this.fornecedores.put(nome,fornecedor);
        return true;
    }

    public String exibeFornecedor(String nome)
    {
        if (!fornecedores.containsKey(nome))
        {
            return "Fornecedor não cadastrado.";
        }
        return fornecedores.get(nome).toString();
    }

    public String exibeFornecedoresCadastrados()
    {
        String msg = "";
        if (fornecedores.isEmpty())
        {
            return "Nenhum fornecedor cadastrado.";
        } else
        {
            for (Fornecedor fornecedor: fornecedores.values())
            {
                msg += fornecedor.toString() + " | ";
            }
            return msg.substring(0,msg.length()-3);
        }
    }

    public  boolean editaFornecedorEmail(String nome, String email)
    {
        if (!this.fornecedores.containsKey(nome))
        {
            return false;
        }
        this.fornecedores.get(nome).setEmail(email);
        return true;
    }

    public  boolean editaFornecedorTelefone(String nome, String telefone)
    {
        if (!this.fornecedores.containsKey(nome))
        {
            return false;
        }
        this.fornecedores.get(nome).setTelefone(telefone);
        return true;
    }

    public boolean removeFornecedor(String nome)
    {
        if (!this.fornecedores.containsKey(nome))
        {
            return false;
        }
        this.fornecedores.remove(nome);
        return true;
    }

    public boolean cadastraProduto(String nomeFornecedor, String nome, String descricao, double preco)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            return false;
        }
        return this.fornecedores.get(nomeFornecedor).cadastraProduto(nome, descricao, preco);

    }

    public String exibeProduto(String nomeFornecedor, String nome, String descricao)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            return "Fornecedor não cadastrado.";
        }
        return this.fornecedores.get(nomeFornecedor).exibeProduto(nome, descricao);
    }

    public String exibeTodosProduto(String nomeFornecedor, String nome, String descricao)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            return "Fornecedor não cadastrado.";
        }
        return this.fornecedores.get(nomeFornecedor).exibeTodosProdutos();
    }

    public boolean editaPrecoProduto(String nomeFornecedor, String nome, String descricao, double preco)
    {
        if (!this.fornecedores.containsKey(nomeFornecedor))
        {
            return false;
        }
        return this.fornecedores.get(nomeFornecedor).editaPrecoProduto(nome, descricao, preco);
    }



}
