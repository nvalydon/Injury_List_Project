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
import com.bae.persistence.repo.PlayerRepository;
import com.bae.service.PlayerService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = App.class)
@SpringBootTest
public class PlayerServiceIntegrationTest {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private PlayerRepository playerRepo;

	private Player testPlayer;

	private Player testPlayerWithID;

	@Before
	public void init() {
		this.testPlayer = new Player("Kieran", "Tierney", 22, "Dislocated Shoulder", 3, "Months");

		this.playerRepo.deleteAll();

		this.testPlayerWithID = this.playerRepo.save(this.testPlayer);

	}

	@Test
	public void testCreatePlayer() {

		assertEquals(this.testPlayerWithID, this.playerService.addNewMember(testPlayer));

	}

	@Test
	public void testDeletePlayer() {

		assertThat(this.playerService.deleteMember(this.testPlayerWithID.getId())).isFalse();

	}

	@Test
	public void testFindPlayerByID() {
		System.out.println(this.testPlayerWithID.getId());

		assertThat(this.playerService.findMemberByID(this.testPlayerWithID.getId()).toString())
				.isEqualTo(this.testPlayerWithID.toString());

	}

	@Test
	public void testReadPlayer() {

		assertEquals(this.playerService.readMembers().toString(),
				((Arrays.asList(new Player[] { this.testPlayerWithID }).toString())));

	}

	@Test
	public void testUpdatePlayer() {
		Player newPlayer = new Player("Kieran", "Tierney", 22, "Dislocated Shoulder", 3, "Months");
		Player updatedPlayer = new Player(newPlayer.getFirstName(), newPlayer.getLastName(), newPlayer.getAge(),
				newPlayer.getTypeOfInjury(), newPlayer.getLengthOfInjury(), newPlayer.getTimePeriod());
		updatedPlayer.setId(this.testPlayerWithID.getId());

		assertThat(this.playerService.updateMember(newPlayer, this.testPlayerWithID.getId()).toString())
				.isEqualTo(updatedPlayer.toString());

	}

}
