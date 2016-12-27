package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entidades.Fatura;

public class TesteSistemaPagamentos {
	
	private Fatura fatura;
	
	@Before
	 public void setUp(){
	 this.fatura = new Fatura();
	 }

	@Test
	public void test1() {
		String res = this.fatura.CondicaoDaFatura(50, 50);
		String valorEsperado = "Fatura PAGA";
		assertEquals(valorEsperado, res);
	}
	
	@Test
	public void test2() {
		String res = this.fatura.CondicaoDaFatura(45, 50);
		String valorEsperado = "Fatura PAGA com credito";
		assertEquals(valorEsperado, res);
	}
	
	@Test
	public void test3() {
		String res = this.fatura.CondicaoDaFatura(50, 20);
		String valorEsperado = "Fatura  NÂO PAGA";
		assertEquals(valorEsperado, res);
	}
	
		

}
