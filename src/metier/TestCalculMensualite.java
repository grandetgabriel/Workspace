package metier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculMensualite {

	private ICreditMetier metier;

	@Before
	public void setUp() throws Exception {
		metier = new CreditMetierImpl();
	}

	@Test
	public void testCalculerMensualiteCredit() {
		double capital = 200000;
		double taux = 4.5;
		int duree = 240;

		double resultatAttendu = 1265.2987;
		double resultatActuel = metier.calculerMensualiteCredit(capital, taux, duree);

		assertEquals(resultatAttendu, resultatActuel, 0.0001);

	}

}
