package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Player;
import com.bae.rest.PlayerController;
import com.bae.service.PlayerService;

@RunWith(SpringRunner.class)
public class PlayerControllerUnitTest {

	@InjectMocks
	private PlayerController playerController;

	@Mock
	private PlayerService playerService;

	private List<Player> playerList;

	private Player testPlayer;

	private Player testPlayerWithID;

	final long id = 1L;

	@Before
	public void init() {

		this.playerList = new ArrayList<>();
		this.playerList.add(testPlayer);
		this.testPlayer = new Player("Kieran", "Tierney", 22, "Dislocated Shoulder", 3, "Months");
		this.testPlayerWithID = new Player(testPlayer.getFirstName(), testPlayer.getLastName(),
				testPlayer.getAge(), testPlayer.getTypeOfInjury(), testPlayer.getLengthOfInjury(),
				testPlayer.getTimePeriod());
		this.testPlayerWithID.setId(id);

	}

	@Test
	public void createPlayerTest() {

		when(this.playerService.addNewMember(testPlayer)).thenReturn(testPlayerWithID);

		assertEquals(this.testPlayerWithID, this.playerController.addNewMember(testPlayer));

	}

	@Test
	public void readPlayerTest() {

		when(playerService.readMembers()).thenReturn(this.playerList);

		assertFalse("Controller has found no Players", this.playerController.getAllMembers().isEmpty());

	}

	@Test
	public void updatePlayerTest() {

		Player newPlayer = new Player("Henry", "Allen", 30, "Broken Ankle", 5, "Months");
		Player updatedPlayer = new Player(newPlayer.getFirstName(), newPlayer.getLastName(),
				newPlayer.getAge(), newPlayer.getTypeOfInjury(), newPlayer.getLengthOfInjury(),
				newPlayer.getTimePeriod());

		updatedPlayer.setId(this.id);

		when(this.playerService.updateMember(newPlayer, id)).thenReturn(updatedPlayer);

		assertEquals(updatedPlayer, this.playerController.updateMember(this.id, newPlayer));

	}

	@Test
	public void deletePlayerTest() {

		this.playerController.deleteUserDetails(id);

	}

	@Test
	public void findPlayerByID() {

		when(this.playerService.findMemberByID(this.id)).thenReturn(this.testPlayerWithID);

		assertEquals(this.testPlayerWithID, this.playerController.getPlayer(this.id));

	}

}
