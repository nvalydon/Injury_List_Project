package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bae.persistence.domain.Position;
public class PositionDomainUnitTest {

	@Test
	public void hashCodeAndEqualstest() {
		Position x = new Position("CF");
		Position y = new Position("CF");
		
		assertTrue(x.equals(y)&& y.equals(x));
		assertTrue(x.hashCode() == y.hashCode());
	}

}
