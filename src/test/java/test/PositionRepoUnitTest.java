package test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.App;
import com.bae.persistence.domain.Position;
import com.bae.persistence.repo.PositionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = App.class)
public class PositionRepoUnitTest {

	@Autowired
	private PositionRepository positionRepo;

	private final String TEST_POSITION = "ST";

	private final Position TEST = new Position(TEST_POSITION);

	private Position testSavedPosition;

	@Before
	public void init() {

		this.positionRepo.deleteAll();
		this.testSavedPosition = this.positionRepo.save(this.TEST);

	}
	
	@Test
	public void testFindByPosition() {
		
		assertThat(this.positionRepo.findByPosition(TEST_POSITION));
		
	}

}
