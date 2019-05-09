package SAGA;

import java.util.Map;
import java.util.TreeMap;

/**
 * Sistema controlador dos clientes.
 * @author Lourival Gonçalves Prata Netto - 119111236 - UFCG.
 *
 */
public class ControllerCliente {

    private Map<String, Cliente> clientes;

    /**
	 * Construtor que inicializa um TreeMap de clientes.
	 */
    public  ControllerCliente()
    {
        this.clientes = new TreeMap<>();
    }

    /**
	 * Adiciona um novo cliente valido apartir do seu cpf, nome, email e localizacao.
	 * 
	 * @param cpf cpf do cliente.
	 * @param nome nome do cliente.
	 * @param email email do cliente.
	 * @param localizacao localizacao do cliente.
	 * @return retorna o CPF se o cliente for cadastrado com sucesso.
	 */
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

    /**
	 * Exibe um cliente valido apartir do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return uma string que representa o cliente no formato NOME - LOCALIZACAO - EMAIL, ou Cliente não cadastrado. em demais casos.
	 */
    public String exibeCliente(String cpf)
    {
        if (!this.clientes.containsKey(cpf))
        {
            return "Cliente não cadastrado.";
        }
        return this.clientes.get(cpf).toString();
    }

     /**
	 * Exibe todos clientes cadastrados.
	 * 
	 * @return uma string que representa todos os clientes no formato NOME - LOCALIZACAO - EMAIL | NOME - LOCALIZACAO - EMAIL.
	 */
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

     /**
	 * Edita o nome de um cliente valido apartir do seu cpf e o novo nome.
	 * @param cpf cpf do cliente.
	 * @param nome novo nome.
	 * 
	 * @return retorna um booleando True se a edicao do cliente for um sucesso.
	 */
    public boolean alteraNomeCliente(String cpf, String nome)
    {
        if (!this.clientes.containsKey(cpf))
        {
            return false;
        }
        this.clientes.get(cpf).setNome(nome);
        return true;
    }

     /**
	 * Edita o email de um cliente valido apartir do seu cpf e o novo email.
	 * @param cpf cpf do cliente.
	 * @param email novo email.
	 * 
	 * @return retorna um booleando True se a edicao do cliente for um sucesso.
	 */
    public boolean alteraEmailCliente(String cpf, String email)
    {
        if (!this.clientes.containsKey(cpf))
        {
            return false;
        }
        this.clientes.get(cpf).setEmail(email);
        return true;
    }

     /**
	 * Edita a localizacao de um cliente valido apartir do seu cpf e a nova localizacao.
	 * @param cpf cpf do cliente.
	 * @param localizacao nova localizacao.
	 * 
	 * @return retorna um booleando True se a edicao do cliente for um sucesso.
	 */
    public boolean alteraLocalizacaoCliente(String cpf, String localizacao)
    {
        if (!this.clientes.containsKey(cpf))
        {
            return false;
        }
        this.clientes.get(cpf).setLocalizacao(localizacao);
        return true;
    }

    /**
	 * Remove um cliente valido apartir do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return retorna um booleano True se a remocao do cliente for um sucesso.
	 */
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
