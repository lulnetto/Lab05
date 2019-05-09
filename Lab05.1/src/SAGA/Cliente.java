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
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    /**
     * Seta um nome para o cliente.
     *
     * @param nome nome do cliente.
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * Seta um email para o cliente.
     *
     * @param email email do cliente.
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Seta um local para o cliente.
     *
     * @param localizacao local do cliente.
     */
    public void setLocalizacao(String localizacao)
    {
        this.localizacao = localizacao;
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
