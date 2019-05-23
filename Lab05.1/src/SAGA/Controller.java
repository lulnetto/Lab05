package SAGA;

public class Controller
{
    private ControllerCliente cc;
    private ControllerFornecedor cf;

    public Controller()
    {
        this.cc = new ControllerCliente();
        this.cf = new ControllerFornecedor();
    }

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

    public boolean editaCliente(String cpf, String atributo, String novoValor)
    {
        return cc.editaCliente(cpf, atributo, novoValor);
    }

    public boolean removeCliente(String cpf)
    {
        return cc.removeCliente(cpf);
    }

    public String adicionaFornecedor(String nome, String email, String telefone)
    {
        return cf.adicionaFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome)
    {
        return cf.exibeFornecedor(nome);
    }

    public String exibeFornecedoresCadastrados()
    {
        return cf.exibeFornecedoresCadastrados();
    }

    public boolean editaFornecedor(String nome, String atributo, String novoValor)
    {
        return cf.editaFornecedor(nome, atributo, novoValor);
    }

    public boolean removeFornecedor(String nome)
    {
        return cf.removeFornecedor(nome);
    }

    public boolean adicionaProduto(String fornecedor, String nome, String descricao, double preco)
    {
        return cf.adicionaProduto(fornecedor, nome, descricao, preco);

    }

    public String exibeProduto(String nome, String descricao, String fornecedor)
    {
        return cf.exibeProduto(nome, descricao, fornecedor);
    }

    public String exibeTodosProduto(String nomeFornecedor)
    {
        return cf.exibeTodosProduto(nomeFornecedor);
    }

    public String exibeTodosProdutoFornecedores()
    {
        return cf.exibeTodosProdutoFornecedores();
    }

    public boolean editaProduto(String fornecedor, String descricao, String nome, double novoPreco)
    {
        return cf.editaProduto(fornecedor, nome, descricao, novoPreco);
    }

    public boolean removeProduto(String nome, String descricao,String fornecedor)
    {
        return cf.removeProduto(fornecedor, nome, descricao);
    }

    public boolean adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProduto, String descricaoProduto)
    {
        if (this.cc.existeCliente(cpf))
        {
            return this.cf.adicionaCompra(cpf,nomeFornecedor,data,nomeProduto,descricaoProduto);
        } else return false;
    }

    public double getDebito(String cpf, String nomeFornecedor)
    {
        if (!this.cc.existeCliente(cpf))
        {
         throw new IllegalArgumentException();
        } else return this.cf.getDebito(cpf, nomeFornecedor);
    }

    public String exibeContas(String cpf, String nomeFornecedor)
    {
        if (!this.cc.existeCliente(cpf))
        {
            throw new IllegalArgumentException();
        } else return "Cliente: " + this.cc.getNome(cpf) + " | " + this.cf.exibeContas(cpf,nomeFornecedor);
    }
}
