package SAGA;

import easyaccept.EasyAccept;

public class Facade {
    private Controller cc;

    public static void main(String[] args)
    {
        args = new String[]{"SAGA.Facade","Lab05.1/acceptance_test/use_case_1.txt","Lab05.1/acceptance_test/use_case_2.txt",
                "Lab05.1/acceptance_test/use_case_3.txt","Lab05.1/acceptance_test/use_case_4.txt","Lab05.1/acceptance_test/use_case_5.txt",
                "Lab05.1/acceptance_test/use_case_6.txt"};
        EasyAccept.main(args);
    }

    public Facade()
    {
        this.cc = new Controller();
    }

    public String adicionaCliente(String cpf, String nome, String email, String localizacao)
    {
        return cc.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf)
    {
       return cc.exibeCliente(cpf);
    }

    public String exibeClientes()
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
        return cc.adicionaFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome)
    {
        return cc.exibeFornecedor(nome);
    }

    public String exibeFornecedores()
    {
        return cc.exibeFornecedoresCadastrados();
    }

    public boolean editaFornecedor(String nome, String atributo, String novoValor)
    {
        return cc.editaFornecedor(nome, atributo, novoValor);
    }

    public boolean removeFornecedor(String nome)
    {
        return cc.removeFornecedor(nome);
    }

    public boolean adicionaProduto(String fornecedor, String nome, String descricao, double preco)
    {
        return cc.adicionaProduto(fornecedor, nome, descricao, preco);

    }

    public String exibeProduto(String nome, String descricao, String fornecedor)
    {
        return cc.exibeProduto(nome, descricao, fornecedor);
    }

    public String exibeTodosProduto(String nomeFornecedor)
    {
        return cc.exibeTodosProduto(nomeFornecedor);
    }

    public String exibeTodosProdutoFornecedores()
    {
        return cc.exibeTodosProdutoFornecedores();
    }

    public boolean editaProduto(String nome, String descricao, String fornecedor, double novoPreco)
    {
        return cc.editaProduto(fornecedor, nome, descricao, novoPreco);
    }

    public boolean removeProduto(String nome, String descricao,String fornecedor)
    {
        return cc.removeProduto(fornecedor, nome, descricao);
    }

    public boolean adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProduto, String descricaoProduto)
    {
        return this.cc.adicionaCompra(cpf, nomeFornecedor, data, nomeProduto, descricaoProduto);
    }

    public double getDebito(String cpf, String nomeFornecedor)
    {
        return this.cc.getDebito(cpf,nomeFornecedor);
    }

    public String exibeContas(String cpf, String nomeFornecedor)
    {
        return this.cc.exibeContas(cpf, nomeFornecedor);
    }


}
