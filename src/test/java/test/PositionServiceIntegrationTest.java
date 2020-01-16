package test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.App;
import com.bae.persistence.domain.Player;
import com.bae.persistence.domain.Position;
import com.bae.persistence.repo.PositionRepository;
import com.bae.service.PositionService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = App.class)
@SpringBootTest
public class PositionServiceIntegrationTest {

	@Autowired
	private PositionService positionService;

	@Autowired
	private PositionRepository positionRepo;

	private Position testPosition;

	private Position testPositionWithID;

	@Before
	public void init() {

		this.testPosition = new Position("ST");

		this.positionRepo.deleteAll();

		this.testPositionWithID = this.positionRepo.save(this.testPosition);

	}

	@Test
	public void testCreatePositon() {

		assertEquals(this.testPositionWithID, this.positionService.addNewPosition(testPosition));

	}

	@Test
	public void testDeletePlayer() {
		assertThat(this.positionService.deletePosition(this.testPositionWithID.getId())).isFalse();
	}
	
	@Test
	public void testReadPosition() {

		assertEquals(this.positionService.getAllPositions().toString(),((Arrays.asList(new Position[] { this.testPositionWithID }).toString())));

	}
	
	@Test
	public void testUpdatePosition() {
		Position newPosition = new Position("ST");
		Position updatedPosition = new Position(newPosition.getPosition());
		updatedPosition.setId(this.testPositionWithID.getId());

		assertThat(this.positionService.updatePosition(newPosition, this.testPositionWithID.getId()).toString())
				.isEqualTo(updatedPosition.toString());

	}

	
}
