package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Position;
import com.bae.persistence.repo.PositionRepository;
import com.bae.service.PositionService;

@RunWith(SpringRunner.class)
public class PositionServiceUnitTest {

	@InjectMocks
	private PositionService positionService;

	@Mock
	private PositionRepository positionRepo;

	private List<Position> positionList;

	private Position testPosition;

	private Position testPositionWithID;

	private Long id = 1L;

	@Before
	public void init() {

		this.positionList = new ArrayList<>();
		this.positionList.add(testPosition);
		this.testPosition = new Position("ST");
		this.testPositionWithID = new Position(testPosition.getPosition());
		this.testPositionWithID.setId(id);
	}

	@Test
	public void createPosition() {
		when(this.positionRepo.save(testPosition)).thenReturn(testPositionWithID);

		assertEquals(this.testPositionWithID, this.positionService.addNewPosition(testPosition));

		verify(this.positionRepo, times(1)).save(this.testPosition);
		System.out.println("Done Create");
	}

	@Test
	public void readPositionTest() {

		when(positionRepo.findAll()).thenReturn(this.positionList);

		assertFalse("Controller found no Positions", this.positionService.getAllPositions().isEmpty());

		verify(positionRepo, times(1)).findAll();
		System.out.println("Done Read");
	}
	
	@Test
	public void updatePlayerTest() {
		
		Position newPosition = new Position("LB");
		Position updatedPosition = new Position(newPosition.getPosition());
		updatedPosition.setId(this.id);
	
		
		when(this.positionRepo.findById(this.id)).thenReturn(Optional.of(this.testPositionWithID));

		when(this.positionRepo.save(updatedPosition)).thenReturn(updatedPosition);

		assertEquals(updatedPosition, this.positionService.updatePosition(newPosition, this.id));

	}
	
	@Test
	public void deletePlayerTest() {

		when(this.positionRepo.existsById(id)).thenReturn(true, false);

		this.positionService.deletePosition(id);
		System.out.println("Done Delete");
		//verify(this.positionRepo, times(1)).deleteById(id);
		//verify(this.positionRepo, times(2)).existsById(id);

	}
	
	


}
