package Util;

import java.util.Comparator;
import SAGA.Cliente;
public class NameComparator implements Comparator<Cliente>
{

    @Override
    public int compare(Cliente o, Cliente t1)
    {
        return o.getNome().compareTo(t1.getNome());
    }


}
