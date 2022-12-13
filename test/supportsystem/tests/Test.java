/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supportsystem.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.Test;
import static org.junit.Assert.*;
import supportsystem.view.vendaGerarXML;

/**
 *
 * @author bruno.sahlberg
 */
public class Test {

    float preco_item;
    int qtd;
    int qtd_estoque;

    float preco_servico;

    float valor_total;

    public Test() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass");

    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass");

    }

    @Before
    public void setUp() {
        System.out.println("setUp");
        //altere os números para produzir falhas
        preco_item = 100.0f;
        qtd = 0;
        qtd_estoque = 2;

        preco_servico = 90.0f;
        valor_total = 0.00f;
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        preco_item = 100.0f;
        qtd = 1;
        qtd_estoque = 1;

        preco_servico = 90.0f;
        valor_total = 190.00f;
    }

    /**
     * Test of concatenarTexto method, of class Utils.
     */
//    @Test
//    public void testConcatenarTexto() {
//        System.out.println("concatenarTexto");
//        String s1 = "teste";
//        String s2 = "1";
//        String expResult = "teste1";
//        String result = Utils.concatenarTexto(s1, s2);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of fatorial method, of class Utils.
//     */
//    //@Test(expected = IllegalArgumentException.class)
//    @Test(timeout = 5)
//    //@Test
//    public void testFatorial() {
//        System.out.println("fatorial");
//        //int numero = 7;
//        //int numero = -1; // teste de argumento inválido
//        int numero = 999999999; // teste de timeout
//        String expResult = "5040";
//        String result = Utils.fatorial(numero);
//        assertEquals(expResult, result);
//        //assertTrue(result.equals(expResult));
//    }
//
    /**
     * Test of somar method, of class Utils.
//     */
//    @Test
//    public void testVenda() {
//        System.out.println("Venda");
//        vendaGerarXML instance = null;
//        float expResult = 190.00f;
//        float result = instance.preco_item);
//        assertEquals(expResult, result, 0.0);
//    }

    /**
     * Test of subtrair method, of class Utils.
     */
//    //@Ignore 
//    @Test
//    public void testSubtrair() {
//        System.out.println("subtrair");
//        Utils instance = null;
//        float expResult = 0.0F;
//        float result = instance.subtrair(numero1, numero2);
//        assertEquals(expResult, result, 0.0);
//    }
//
//    /**
//     * Test of dividir method, of class Utils.
//     */
//    @Test
//    public void testDividir() {
//        System.out.println("dividir");
//        Utils instance = null;
//        float expResult = 0.0F;
//        float result = instance.dividir(numero1, numero2);
//        assertEquals(expResult, result, 1.0);
//    }
//
//    /**
//     * Test of multiplicar method, of class Utils.
//     */
//    @Test
//    public void testMultiplicar() {
//        System.out.println("multiplicar");
//        Utils instance = null;
//        float expResult = 1.0F;
//        float result = instance.multiplicar(numero1, numero2);
//        assertEquals(expResult, result, 0.0);
//    }
}
