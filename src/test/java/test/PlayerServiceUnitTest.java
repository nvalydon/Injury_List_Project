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

import com.bae.persistence.domain.PlayerDomain;
import com.bae.persistence.repo.PlayerRepository;
import com.bae.service.PlayerService;

@RunWith(SpringRunner.class)
public class PlayerServiceUnitTest {

	@InjectMocks
	private PlayerService playerService;

	@Mock
	private PlayerRepository playerRepo;

	private List<PlayerDomain> playerList;

	private PlayerDomain testPlayer;

	private PlayerDomain testPlayerWithID;

	final long id = 1L;

	@Before
	public void init() {
		this.playerList = new ArrayList<>();
		this.playerList.add(testPlayer);
		this.testPlayer = new PlayerDomain("Kieran", "Tierney", 22, "Dislocated Shoulder", 3, "Months");
		this.testPlayerWithID = new PlayerDomain(testPlayer.getFirstName(), testPlayer.getLastName(),
				testPlayer.getAge(), testPlayer.getTypeOfInjury(), testPlayer.getLengthOfInjury(),
				testPlayer.getTimePeriod());
		this.testPlayerWithID.setId(id);

	}

	@Test
	public void createPlayerTest() {
		when(this.playerRepo.save(testPlayer)).thenReturn(testPlayerWithID);

		assertEquals(this.testPlayerWithID, this.playerService.addNewMember(testPlayer));

		verify(this.playerRepo, times(1)).save(this.testPlayer);
	}

	@Test
	public void readPlayerTest() {

		when(playerRepo.findAll()).thenReturn(this.playerList);

		assertFalse("Controller found no Players", this.playerService.readMembers().isEmpty());

		verify(playerRepo, times(1)).findAll();

	}

	@Test
	public void updatePlayerTest() {

		PlayerDomain newPlayer = new PlayerDomain("Henry", "Allen", 30, "Broken Ankle", 5, "Months");
		PlayerDomain updatedPlayer = new PlayerDomain(newPlayer.getFirstName(), newPlayer.getLastName(),
				newPlayer.getAge(), newPlayer.getTypeOfInjury(), newPlayer.getLengthOfInjury(),
				newPlayer.getTimePeriod());
		updatedPlayer.setId(this.id);
		
		when(this.playerRepo.findById(this.id)).thenReturn(Optional.of(this.testPlayerWithID));

		when(this.playerRepo.save(updatedPlayer)).thenReturn(updatedPlayer);
		System.out.println("This is the value of updatedPlayer " + updatedPlayer);
		System.out.println("This is the value of id " + this.id);
		System.out.println(this.playerService.updateMember(updatedPlayer, this.id));
		assertEquals(updatedPlayer, this.playerService.updateMember(updatedPlayer, this.id));

//		verify(this.playerRepo, times(1)).findById(1L);
//		verify(this.playerRepo, times(1)).save(updatedPlayer);

	}

	@Test
	public void deletePlayerTest() {

		when(this.playerRepo.existsById(id)).thenReturn(true, false);

		this.playerService.deleteMember(id);

		verify(this.playerRepo, times(1)).deleteById(id);
		verify(this.playerRepo, times(2)).existsById(id);

	}

}
