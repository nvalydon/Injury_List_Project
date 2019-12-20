package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
		when(this.playerRepo.save(testPlayer)).thenReturn(testPlayerWithID);

		assertEquals(this.testPlayerWithID, this.playerService.addNewMember(testPlayer));

		verify(this.playerRepo, times(1)).save(this.testPlayer);
		
		
	}
	

}
