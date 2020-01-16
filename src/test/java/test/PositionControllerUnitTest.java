package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Position;
import com.bae.rest.PositionController;
import com.bae.service.PositionService;

@RunWith(SpringRunner.class)
public class PositionControllerUnitTest {

	@InjectMocks
	private PositionController positionController;

	@Mock
	private PositionService positionService;

	private List<Position> positionList;

	private Position testPosition;

	private Position testPositionWithID;

	final Long id = 1L;

	@Before
	public void init() {

		this.positionList = new ArrayList<>();
		this.positionList.add(testPosition);
		this.testPosition = new Position("ST");
		this.testPositionWithID = new Position(testPosition.getPosition());
		this.testPositionWithID.setId(id);

	}

	@Test
	public void createPositionTest() {

		when(this.positionService.addNewPosition(testPosition)).thenReturn(testPositionWithID);

		assertEquals(this.testPositionWithID, this.positionController.addNewPosition(testPosition));

	}

	@Test
	public void readPositionTest() {

		when(positionService.getAllPositions()).thenReturn(this.positionList);

		assertFalse("Controller has found no positions", this.positionController.getAllPositions().isEmpty());

	}

	@Test
	public void updatePositionTest() {

		Position newPosition = new Position("ST");
		Position updatedPosition = new Position(newPosition.getPosition());
		updatedPosition.setId(this.id);
		when(this.positionService.updatePosition(newPosition, id)).thenReturn(updatedPosition);

		assertEquals(updatedPosition, this.positionController.updatePosition(newPosition, this.id));

	}

	@Test
	public void deletePositionTest() {

		this.positionController.deleteUserDetails(id);

	}
	
	@Test
	public void findPositionByID() {

		when(this.positionService.findPositionByID(this.id)).thenReturn(this.testPositionWithID);

		assertEquals(this.testPositionWithID, this.positionController.getPosition(this.id));

	}
	

}
