package SAGA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testCadastraClienteValido()
    {
        Cliente c = new Cliente("12345678911", "Lourival", "asd", "ASD");
    }

    @Test
    void testCadastraClienteCPFinvalido()
    {

        assertThrows(IllegalArgumentException.class, () -> new Cliente("1234567891", "Mariana", "DSA", "ADS"));
    }

    @Test
    void testCadastraClienteNomeInvalido()
    {

        assertThrows(IllegalArgumentException.class,() -> new Cliente("1234567891", "", "DSAD", "FFF"));
    }

    @Test
    void testCadastraClienteEmailInvalido()
    {

        assertThrows(IllegalArgumentException.class,()-> new Cliente("1234567891", "Othon", "", "FFF"));
    }

    @Test
    void testCadastraClienteLocalInvalido()
    {

        assertThrows(IllegalArgumentException.class,()->new Cliente("1234567891", "GUGA", "DEIXA EU PEGAR NO SEU PINTO", ""));
    }

    @Test
    void testSetNomeValido()
    {
        Cliente c = new Cliente("12345678911", "Talita", "A@a.com", "SPS");
        c.setNome("Gaby");
    }

    @Test
    void testSetNomeInvalido()
    {
        Cliente c = new Cliente("12345678911", "Caio", "QQQQ", "KKLKLK");
        assertThrows(IllegalArgumentException.class,()-> c.setNome(""));
    }

    @Test
    void testSetEmailValido()
    {
        Cliente c = new Cliente("12345678911", "LAUNNA", "QUERO", "BROWNIE");
        c.setEmail("b@b.com");
    }

    @Test
    void testSetEmailInvalido()
    {
        Cliente c = new Cliente("12345678911", "JOÃO", "ASSSsSS", "SPS");
        assertThrows(IllegalArgumentException.class,()->c.setEmail(""));
    }

    @Test
    void testSetLocalValido()
    {
        Cliente c = new Cliente("12345678911", "GABRIELL", "NOBREGA", "ÉFODA");
        c.setLocalizacao("FODAD+");
    }

    @Test
    void testSetLocalInvalido()
    {
        Cliente c = new Cliente("12345678911", "Felipe", "A@a.com", "SPS");
        assertThrows(IllegalArgumentException.class,()->c.setLocalizacao(""));
    }

    @Test
    void testToString()
    {
        Cliente c = new Cliente("12345678911", "Felipe", "Monitor", "Melhor");
        String msg = "Felipe - Melhor - Monitor";
        assertEquals(msg, c.toString());
    }

    @Test
    void testEqualsTrue()
    {
        Cliente c = new Cliente("12345678911", "Higor", "Santos", "OCARA");
        Cliente d = new Cliente("12345678911", "Higor", "Santos", "OCARA");
        assertEquals(true, c.equals(d));
    }

    @Test
    void testEqualsTrueTrue()
    {
        Cliente c = new Cliente("12345678911", "Felipe", "A@a.com", "SPS");
        assertEquals(true, c.equals(c));
    }

    @Test
    void testEqualsFalse()
    {
        Cliente c = new Cliente("12345678911", "Felipe", "A@a.com", "SPS");
        Cliente d = new Cliente("12345678912", "Felipe", "A@a.com", "SPS");
        assertEquals(false, c.equals(d));
    }

    @Test
    void testEqualsFalseFalse()
    {
        Cliente c = new Cliente("12345678911", "Felipe", "A@a.com", "SPS");
        assertEquals(false, c.equals(null));
    }

    @Test
    void testEqualsFalseFalseFalse()
    {
        Cliente c = new Cliente("12345678911", "Felipe", "A@a.com", "SPS");
        Object o = new Object();
        assertEquals(false, c.equals(o));

    }
}