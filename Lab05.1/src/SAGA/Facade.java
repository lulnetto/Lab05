package SAGA;

public class Facade {
    private ControllerCliente cc;
    private ControllerFornecedor cf;

    public String cadastraCliente(String cpf, String nome, String email, String localizacao)
    {
        return cc.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf)
    {
       return cc.exibeCliente(cpf);
    }

    public String exibeClientesCadastrados()
    {
        return cc.exibeClientesCadastrados();
    }

    public boolean alteraNomeCliente(String cpf, String nome)
    {
        return cc.alteraNomeCliente(cpf, nome);
    }

    public boolean alteraEmailCliente(String cpf, String email)
    {
        return cc.alteraEmailCliente(cpf, email);
    }

    public boolean alteraLocalizacaoCliente(String cpf, String localizacao)
    {
        return cc.alteraLocalizacaoCliente(cpf, localizacao);
    }

    public boolean removeCliente(String cpf)
    {
        return cc.removeCliente(cpf);
    }

    public boolean cadastraFornecedor(String nome, String email, String telefone)
    {
        return cf.cadastraFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome)
    {
        return cf.exibeFornecedor(nome);
    }

    public String exibeFornecedoresCadastrados()
    {
        return cf.exibeFornecedoresCadastrados();
    }

    public boolean editaFornecedorEmail(String nome, String email)
    {
        return cf.editaFornecedorEmail(nome, email);
    }

    public boolean editaFornecedorTelefone(String nome, String telefone)
    {
        return cf.editaFornecedorTelefone(nome, telefone);
    }

    public boolean removeFornecedor(String nome)
    {
        return cf.removeFornecedor(nome);
    }

    public boolean cadastraProduto(String nomeFornecedor, String nome, String descricao, double preco)
    {
        return cf.cadastraProduto(nomeFornecedor, nome, descricao, preco);

    }

    public String exibeProduto(String nomeFornecedor, String nome, String descricao)
    {
        return cf.exibeProduto(nomeFornecedor, nome, descricao);
    }

    public String exibeTodosProduto(String nomeFornecedor, String nome, String descricao)
    {
        return cf.exibeTodosProduto(nomeFornecedor);
    }

    public String exibeTodosProdutoFornecedores()
    {
        return cf.exibeTodosProdutoFornecedores();
    }

    public boolean editaPrecoProduto(String nomeFornecedor, String nome, String descricao, double preco)
    {
        return cf.editaPrecoProduto(nomeFornecedor, nome, descricao, preco);
    }

    public boolean removeProduto(String nomeForncedor, String nome, String descricao)
    {
        return cf.removeProduto(nomeForncedor, nome, descricao);
    }


}
