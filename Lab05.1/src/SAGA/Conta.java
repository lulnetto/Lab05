package SAGA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Conta
{
    private List<Compra> compras;

    public Conta()
    {
        this.compras = new ArrayList<>();
    }

    public boolean cadastraCompra(String data, String produto, double preco)
    {
        Compra compra = new Compra(data, produto, preco);
        compras.add(compra);
        return true;
    }

    public double getDebito()
    {
        double total = 0;
        for (Compra compra: this.compras)
        {
            total += compra.getPreco();
        } return total;
    }

    public String exibeContas()
    {
//        String msg = "";
//        for (Compra compra: this.compras)
//        {
//            msg += compra.toString() + " | ";
//        }
//        return msg.substring(0,msg.length()-3);

        return this.compras.stream().map(compra -> compra.toString()).collect(Collectors.joining(" | "));
    }


}
