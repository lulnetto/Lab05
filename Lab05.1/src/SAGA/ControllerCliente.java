package SAGA;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
         throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
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
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
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

        return clientes.values().stream().map(cliente -> cliente.toString()).collect(Collectors.joining(" | "));

    }

    /**
     * Altera os atributos de um cliente.
     * @param cpf cpf do cliente que quer alteração.
     * @param atributo qual atributo ele quer alterar.
     * @param novoValor qual o novo atributo.
     * @return return true caso a alteração ocorra com sucesso.
     */
    public boolean editaCliente(String cpf, String atributo, String novoValor)
    {
        if (!clientes.containsKey(cpf))
        {
            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
        } else if (atributo == null || "".equals(atributo.trim()))
        {
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        } else if (novoValor == null || "".equals(novoValor.trim()))
        {
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        } else {
            switch (atributo)
            {
                case "nome":
                    this.clientes.get(cpf).setNome(novoValor);
                    return true;
                case "email":
                    this.clientes.get(cpf).setEmail(novoValor);
                    return true;
                case "localizacao":
                    this.clientes.get(cpf).setLocalizacao(novoValor);
                    return true;
                default:
                    throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
            }
        }
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
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }
        this.clientes.remove(cpf);
        return true;
    }


}
