package test;

import static org.assertj.core.api.Assertions.assertThat;

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
@ContextConfiguration(classes = { App.class })
@SpringBootTest
public class MemberServiceIntegrationTest {

	@MockBean
	@Autowired
	private MemberService service;

	@MockBean
	@Autowired
	private MemberRepository memberRepo;

	// private ObjectMapper mapper = new ObjectMapper();

	private MemberDomain member1;
	// private MemberDomain member2;

	private MemberDomain testMemberwithID;

	@Before
	public void init() {
		// this.memberRepo.deleteAll();

		this.member1 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated Shouler", 3, "Months");
		this.memberRepo.deleteAll();
		this.testMemberwithID = this.memberRepo.save(this.member1);
		// this.member2 = this.memberRepo.save(this.member1);
		// this.member2 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated
		// Shouler", 3, "Months");
		// this.member2.setId(1L);

	}

	@Test
	public void testAddNewMember() {
		// Assert.assertEquals(this.member1, this.service.addNewMember(this.member2));
		// Assert.assertEquals(this.member1.toString(),
		// this.service.addNewMember(this.member2).toString());
		Assert.assertEquals(this.testMemberwithID, this.service.addNewMember(member1));
	}

	@Test
	public void testDeleteMember() {

		Assert.assertThat(this.service.deleteMember(this.testMemberwithID.getId())).isFalse();

	}

}
