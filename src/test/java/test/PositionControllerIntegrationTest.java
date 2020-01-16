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
import com.bae.persistence.repo.PositionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = App.class)
public class PositionControllerIntegrationTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private PositionRepository positionRepo;

	private ObjectMapper mapper = new ObjectMapper();

	private long id;

	private Position testPosition;

	private Position testPositionWithID;

	@Before
	public void init() {

		this.positionRepo.deleteAll();

		this.testPosition = new Position("ST");
		this.testPositionWithID = this.positionRepo.save(this.testPosition);
		this.id = this.testPositionWithID.getId();

	}

	@Test
	public void testCreatePosition() throws Exception {

		String result = this.mock
				.perform(request(HttpMethod.POST, "/position/create").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(testPosition)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(testPositionWithID), result);

	}

	@Test
	public void testDeletePosition() throws Exception {

		this.mock.perform(request(HttpMethod.DELETE, "/position/delete/" + this.id)).andExpect(status().isOk());

	}
	
	@Test
	public void testGetAllPlayers() throws Exception {

		List<Position> positionList = new ArrayList<>();
		positionList.add(this.testPosition);

		String content = this.mock.perform(request(HttpMethod.GET, "/position/getAll").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(positionList), content);

	}
	
	@Test
	public void testUpdatePosition() throws Exception {
		Position newPosition = new Position("LB");
		Position updatedPosition = new Position(newPosition.getPosition());
		updatedPosition.setId(this.id);

		String result = this.mock
				.perform(request(HttpMethod.PUT, "/position/update/" + this.id).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newPosition)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(updatedPosition), result);
	}
	
	
	/*@Test
	public void testGetPositionByID() throws Exception{
		

		List<Position> positionList = new ArrayList<>();
		positionList.add(this.testPosition);

		String content = this.mock.perform(request(HttpMethod.GET, "/position/get/" + this.id).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		
		assertEquals(this.mapper.writeValueAsString(positionList).toString(), content.toString());

	}*/
		
		
		
	}


