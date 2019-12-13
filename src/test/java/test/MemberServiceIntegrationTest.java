package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.MemberDomain;
import com.bae.persistence.repo.MemberRepository;
import com.bae.rest.MemberController;
import com.bae.service.MemberService;

import main.App;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {App.class}) 
@SpringBootTest
public class MemberServiceIntegrationTest {

	@MockBean
	private MemberService service;
	
	@MockBean
	@Autowired
	private MemberRepository memberRepo;
	
	//private ObjectMapper mapper = new ObjectMapper();

	private MemberDomain member1;
	private MemberDomain member2;	
	
	@Before
	public void init() {
		this.memberRepo.deleteAll();
		
		this.member1 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated Shouler", 3, "Months");
		this.member2 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated Shouler", 3, "Months");
		member2.setId(1L);
		
	}
	@Test
	public void testAddNewMember() {
		Assert.assertEquals(this.member1, this.service.addNewMember(member2));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
//	public void testCreateUser() throws JsonProcessingException, Exception {
//
//		Mockito.when(this.service.addNewMember(member1)).thenReturn(member2);
//		this.mock
//				.perform(request(HttpMethod.POST, "localhost:8080/injurylistapp/create").contentType(MediaType.APPLICATION_JSON)
//						.content(this.mapper.writeValueAsString(member1)).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}

}
