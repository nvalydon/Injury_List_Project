package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

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

	private MemberDomain testMemberWithID;
	// private MemberDomain testMemberWithID2;

	@Before
	public void init() {
		// this.memberRepo.deleteAll();

		this.member1 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated Shouler", 3, "Months");
		// this.member2 = new MemberDomain("Alex", "Lacazette", 28, "ST", "Sprained
		// Ankle", 1, "Month");

		this.memberRepo.deleteAll();
		this.testMemberWithID = this.memberRepo.save(this.member1);
		// this.testMemberWithID2 = this.memberRepo.save(this.member2);

		// this.member2 = this.memberRepo.save(this.member1);
		// this.member2 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated
		// Shoulder", 3, "Months");
		// this.member2.setId(1L);

	}

	@Test
	public void testAddNewMember() {
		// Assert.assertEquals(this.member1, this.service.addNewMember(this.member2));
		// Assert.assertEquals(this.member1.toString(),
		// this.service.addNewMember(this.member2).toString());
		Assert.assertEquals(this.testMemberWithID, this.service.addNewMember(member1));
	}

//	@Test
//	public void testFindMembersByID() {
//		Assert.assertTrue(this.service.readMembers()).isEqualTo(this.testMemberWithID);
//	}

	@Test
	public void testReadMembers() {
		System.out.println(this.service.readMembers());
		assertThat(this.service.readMembers()).isEqualTo(Arrays.asList(new MemberDomain[] { this.testMemberWithID }));
	}

//	@Test
//	public void testUpdateMember() {
//		MemberDomain newMember = new MemberDomain("James", "Tierney", 25, "LB", "Dislocated Shouler", 3, "Months");
//		MemberDomain updatedMember = new MemberDomain(newMember.getFirstName(), newMember.getLastName(),
//				newMember.getAge(), newMember.getPosition(), newMember.getTypeOfInjury(), newMember.getLengthOfInjury(),
//				newMember.getTimePeriod());
//
//		updatedMember.setId(this.testMemberWithID.getId());
//
//		assertThat(this.service.updateMember(newMember, this.testMemberWithID.getId())).isEqualTo(updatedMember);
//	}
//
//	@Test
//	public void testDeleteMember() {
//
//		Assert.assertTrue(this.service.deleteMember(this.testMemberWithID.getId()));
//
//	}

}
