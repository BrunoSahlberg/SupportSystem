/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package supportsystem.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import supportsystem.dao.VendedorDAO;
import supportsystem.dao.VendedorDTO;
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
    public void testValidaVendedor() throws SQLException {
        System.out.println("Valida comissão e inserção do vendedor");
        Vendedor vendedor = new Vendedor();
        VendedorDAO instance = new VendedorDAO();

        vendedor.setNome_vendedor("Teste");

        // Alterar porcentagem de comissão para testar, >=60 causa erro.
        vendedor.setPc_comissao(90);

        if (instance.validaVendedor(vendedor)) {
            System.out.println("Teste validado!");
        } else {
            fail("Erro! Não foi possível inserir vendedor, pois porcentagem >= 60");
        }

    }
}
