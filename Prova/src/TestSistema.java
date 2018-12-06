import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSistema {
	
	Sistema sistema;
	
	@BeforeEach
	void setUp() throws Exception {
		sistema = new Sistema();
		sistema.cadastrarEcom("Bar do Cuscuz", "11.125.081/0001-72", "Joao da Silva",3);
		sistema.cadastrarEcom("Bar do feijão", "123456789011", "Joao da Silva",2);
		sistema.cadastrarEcom("Bar do Arroz", "123456789876543", "Joao da Silva",1);
		
	}

	@BeforeEach
	void testCadastrarEcom() {
		
		try {
			sistema.cadastrarEcom("", "10952375435", "Pablo", 3);
		} catch(RuntimeException e) {
			assertEquals("Nome fantasia não pode ser nulo ou vazio.", e.getMessage());
		}
		
		try {
			sistema.cadastrarEcom("Pablo", "", "sadsfg", 2);
		} catch(RuntimeException e) {
			assertEquals("CNPJ não pode ser nulo ou vazio.", e.getMessage());
		}
		
		try {
			sistema.cadastrarEcom("Pablo", "12345678" , "", 2);
		} catch(RuntimeException e) {
			assertEquals("Proprietario não pode ser nulo ou vazio.", e.getMessage());
		}
		
		try {
			sistema.cadastrarEcom(null, "12345", "12345", 2);
		}catch (RuntimeException e) {
			assertEquals("Nome fantasia não pode ser nulo ou vazio.",e.getMessage());
		}
		
		try {
			sistema.cadastrarEcom("Pablo", null, "12345", 2);
		}catch (RuntimeException e) {
			assertEquals("CNPJ não pode ser nulo ou vazio.",e.getMessage());
		}
		try {
			sistema.cadastrarEcom("Pablo", "12345", null, 2);
		}catch (RuntimeException e) {
			assertEquals("Proprietario não pode ser nulo ou vazio.",e.getMessage());
		}
		
		sistema.cadastrarEcom("Bar do Cuscuz", "11.125.081/0001-72", "Joao da Silva",3);
	}

	@Test
	void testRecuperaEcom() {
		assertEquals("Bar do Cuscuz * 11.125.081/0001-72 * Joao da Silva * RESTAURANTE ",sistema.recuperaEcom("11.125.081/0001-72"));
	}

	@Test
	void testAlteraTipoEcom() {
		Ecom econ = new Ecom("Bar do Cuscuz", "11.125.081/0001-72", "Joao da Silva",3);
		sistema.alteraTipoEcom("11.125.081/0001-72",2);
		assertEquals("Bar do Cuscuz * 11.125.081/0001-72 * Joao da Silva * QUIOSQUE ", econ.toString());
	}

	@Test
	void testInformarValorArrecadado() {
		sistema.informarValorArrecadado("11.125.081/0001-72", 1500.00);
	}

	@Test
	void testConsultarTaxasDevidas() {
		sistema.consultarTaxasDevidas("11.125.081/0001-72");
		sistema.consultarTaxasDevidas("123456789011");
		sistema.consultarTaxasDevidas("123456789876543");
	}

	@Test
	void testConsultarTotalArrecadado() {
		sistema.consultarTotalArrecadado("11.125.081/0001-72"); 
	}

}
