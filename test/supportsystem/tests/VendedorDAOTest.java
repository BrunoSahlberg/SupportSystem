/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package supportsystem.tests;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import supportsystem.dao.VendedorDAO;
import supportsystem.models.Vendedor;

/**
 *
 * @author bruno.sahlberg
 */
public class VendedorDAOTest {

    public VendedorDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testValidaComissao() throws SQLException {
        System.out.println("Comissão:");
        Vendedor vendedor = new Vendedor();
        VendedorDAO instance = new VendedorDAO();

        // Alterar porcentagem de comissão para testar, >=60 causa erro.
        vendedor.setPc_comissao(70);

        if (instance.validaComissao(vendedor)) {
            System.out.println("Teste de comissão validado!");
        } else {
            System.out.println("Erro! Valor da comissão deve ser < 60.");
            fail("Erro! Não foi possível atribuir esta comissão, pois porcentagem >= 60");
        }
    }

    @Test
    public void testValidaVendedor() throws SQLException {
        System.out.println("Inserção:");
        Vendedor vendedor = new Vendedor();
        VendedorDAO instance = new VendedorDAO();

        //Informações do vendedor
        vendedor.setId_vendedor(99);
        vendedor.setNome_vendedor("Teste");
        vendedor.setPc_comissao(40);

        if (instance.validaVendedor(vendedor)) {
            System.out.println("Teste de inserção validado!");
        } else {
            fail("Erro! Não foi possível inserir vendedor.");
        }
    }
}
