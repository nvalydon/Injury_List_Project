package test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.App;
import com.bae.persistence.domain.Player;
import com.bae.persistence.domain.Position;
import com.bae.persistence.repo.PlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = App.class)
public class PlayerControllerIntegrationTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private PlayerRepository playerRepo;

	private ObjectMapper mapper = new ObjectMapper();

	private long id;

	private Player testPlayer;

	private Player testPlayerWithID;
	
	private List<Player> playerList = new ArrayList<>();

	private List<Position> defaultPositionList = new ArrayList<>();
	
	@Before
	public void init() {

		this.playerRepo.deleteAll();

		this.testPlayer = new Player("Kieran", "Tierney", 22, "Dislocated Shoulder", 3, "Months");
		testPlayer.setPositions(defaultPositionList);
		this.testPlayerWithID = this.playerRepo.save(this.testPlayer);
		this.id = this.testPlayerWithID.getId();

	}

	@Test
	public void testCreatePlayer() throws Exception {

		String result = this.mock
				.perform(request(HttpMethod.POST, "/player/create").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(testPlayer)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(testPlayerWithID), result);

	}

	@Test
	public void testDeletePlayer() throws Exception {

		this.mock.perform(request(HttpMethod.DELETE, "/player/delete/" + this.id)).andExpect(status().isOk());

	}

	@Test
	public void testGetAllPlayers() throws Exception {
		playerList.add(this.testPlayer);

		String content = this.mock.perform(request(HttpMethod.GET, "/player/getAll").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(playerList), content);

	}

	@Test
	public void testUpdatePlayer() throws Exception {
		
		Player updatedPlayer = new Player(testPlayer.getFirstName(), testPlayer.getLastName(), testPlayer.getAge(),
				testPlayer.getTypeOfInjury(), testPlayer.getLengthOfInjury(), testPlayer.getTimePeriod());
		updatedPlayer.setId(this.id);
		updatedPlayer.setPositions(testPlayer.getPositions());

		String result = this.mock
				.perform(request(HttpMethod.PUT, "/player/update/" + this.id).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(testPlayer)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(updatedPlayer), result);
	}

}
