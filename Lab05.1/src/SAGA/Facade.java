package SAGA;

import easyaccept.EasyAccept;

public class Facade {
    private ControllerCliente cc;
    private ControllerFornecedor cf;

    public static void main(String[] args)
    {
        args = new String[]{"SAGA.Facade","Lab05.1/acceptance_test/use_case_1.txt","Lab05.1/acceptance_test/use_case_2.txt","Lab05.1/acceptance_test/use_case_3.txt"};
        EasyAccept.main(args);
    }

    public Facade()
    {
        this.cc = new ControllerCliente();
        this.cf = new ControllerFornecedor();
    }

    public String adicionaCliente(String cpf, String nome, String email, String localizacao)
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

    public String exibeTodosProduto(String nomeFornecedor, String nome, String descricao)
    {
        return cf.exibeTodosProduto(nomeFornecedor);
    }

    public String exibeTodosProdutoFornecedores()
    {
        return cf.exibeTodosProdutoFornecedores();
    }

    public boolean editaProduto(String nome, String descricao, String fornecedor, double novoPreco)
    {
        return cf.editaProduto(fornecedor, nome, descricao, novoPreco);
    }

    public boolean removeProduto(String nome, String descricao,String fornecedor)
    {
        return cf.removeProduto(fornecedor, nome, descricao);
    }


}
