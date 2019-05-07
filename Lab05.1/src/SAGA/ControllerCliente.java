package SAGA;

import java.util.TreeMap;

public class ControllerCliente {

    private TreeMap<String, Cliente> clientes;

    public  ControllerCliente()
    {
        this.clientes = new TreeMap<>();
    }

    public String cadastraCliente(String cpf, String nome, String email, String localizacao)
    {
        if (clientes.containsKey(cpf))
        {
         throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        Cliente cliente = new Cliente(cpf, nome, email, localizacao);
        this.clientes.put(cpf,cliente);
        return cpf;
    }

    public String exibeCliente(String cpf)
    {
        if (!this.clientes.containsKey(cpf))
        {
            return "Cliente não cadastrado.";
        }
        return this.clientes.get(cpf).toString();
    }

    public String exibeClientesCadastrados()
    {
        String msg = "";
        if (clientes.isEmpty())
        {
            return "Nenhum cliente cadastrado.";
        } else
        {
            for (Cliente cliente: clientes.values())
            {
                msg += cliente.toString() + " | ";
            }
            return msg.substring(0, msg.length() - 3);
        }
    }

    public boolean alteraNomeCliente(String cpf, String nome)
    {
        if (!this.clientes.containsKey(cpf))
        {
            return false;
        }
        this.clientes.get(cpf).setNome(nome);
        return true;
    }

    public boolean alteraEmailCliente(String cpf, String email)
    {
        if (!this.clientes.containsKey(cpf))
        {
            return false;
        }
        this.clientes.get(cpf).setEmail(email);
        return true;
    }

    public boolean alteraLocalizacaoCliente(String cpf, String localizacao)
    {
        if (!this.clientes.containsKey(cpf))
        {
            return false;
        }
        this.clientes.get(cpf).setLocalizacao(localizacao);
        return true;
    }

    public boolean removeCliente(String cpf)
    {
        if (!this.clientes.containsKey(cpf))
        {
            return false;
        }
        this.clientes.remove(cpf);
        return true;
    }


}
