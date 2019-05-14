package SAGA;

import java.util.Objects;

/**
 * Representacao de um cliente.
 *
 * @author Lourival Gonçalves Prata Netto - 119111236 - UFCG.
 */
public class Cliente
{

    private String cpf;
    private String nome;
    private String email;
    private String localizacao;

    /**
     * Constroi um Cliente apatir do cpf, nome, email e local.
     *
     * @param cpf         cpf do cliente.
     * @param nome        nome do cliente.
     * @param email       email do cliente.
     * @param localizacao localizacao do cliente.
     */
    public Cliente(String cpf, String nome, String email, String localizacao)
    {
        if(nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        }else if(email == null || "".equals(email.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }else if(localizacao == null || "".equals(localizacao.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }else if(cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    /**
     * Altera um nome para o cliente.
     *
     * @param nome nome do cliente.
     */
    public void setNome(String nome)
    {
        if(nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    /**
     * Altera um email para o cliente.
     *
     * @param email email do cliente.
     */
    public void setEmail(String email)
    {
        if(email == null || "".equals(email.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }
        this.email = email;
    }

    /**
     * Altera a localizacao de trabalho para o cliente.
     *
     * @param localizacao local do cliente.
     */
    public void setLocalizacao(String localizacao)
    {
        if(localizacao == null || "".equals(localizacao.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }
        this.localizacao = localizacao;
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getLocalizacao()
    {
        return this.localizacao;
    }

    @Override
    public String toString()
    {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(nome, cliente.nome) &&
                Objects.equals(email, cliente.email) &&
                Objects.equals(localizacao, cliente.localizacao);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(cpf, nome, email, localizacao);
    }
}
