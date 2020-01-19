package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bae.persistence.domain.Player;
import com.bae.persistence.repo.PlayerRepository;
import com.bae.service.PlayerService;

public class PlayerDomainUnitTest {


	@Test
	public void testPlayerHashCode() {
		Player x = new Player("Kieran","Tierney", 22, "Dislocated Shoulder", 3, "Months");
		Player y = new Player("Kieran","Tierney", 22, "Dislocated Shoulder", 3, "Months");
		
		assertTrue(x.equals(y) && y.equals(x));
		assertTrue(x.hashCode() == y.hashCode());
	}

}
