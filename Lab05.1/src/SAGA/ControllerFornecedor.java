package SAGA;

import java.util.HashMap;

public class ControllerFornecedor {

    private HashMap<String, Fornecedor> fornecedores;

    public ControllerFornecedor()
    {
        this.fornecedores = new HashMap<>();
    }

    public boolean cadastraFornecedor(String nome, String email, String telefone)
    {
        if (fornecedores.containsKey(nome))
        {
            return false;
        }
        Fornecedor fornecedor = new Fornecedor(nome,email,telefone);
        fornecedores.put(nome,fornecedor);
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

    public  boolean editarClienteNome()
}
