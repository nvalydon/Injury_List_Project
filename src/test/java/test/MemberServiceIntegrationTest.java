//package test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Arrays;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.bae.App;
//import com.bae.persistence.domain.PlayerDomain;
//import com.bae.persistence.repo.PlayerRepository;
//import com.bae.rest.PlayerController;
//import com.bae.service.PlayerService;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = { App.class })
//@SpringBootTest
//public class MemberServiceIntegrationTest {
//
//	@MockBean
//	@Autowired
//	private PlayerService service;
//	
//	@MockBean
//	@Autowired
//	private PlayerRepository memberRepo;
//
//	// private ObjectMapper mapper = new ObjectMapper();
//
//	private PlayerDomain player1;
//	// private MemberDomain member2;
//
//	private PlayerDomain testMemberWithID;
//	// private MemberDomain testMemberWithID2;
//
//	@Before
//	public void init() {
//		// this.memberRepo.deleteAll();
//
//		this.player1 = new PlayerDomain("Kieran", "Tierney", 22, "Dislocated Shouler", 3, "Months");
//		// this.member2 = new MemberDomain("Alex", "Lacazette", 28, "ST", "Sprained
//		// Ankle", 1, "Month");
//
//		this.memberRepo.deleteAll();
//		this.testMemberWithID = this.memberRepo.save(this.player1);
//		// this.testMemberWithID2 = this.memberRepo.save(this.member2);
//
//		// this.member2 = this.memberRepo.save(this.member1);
//		// this.member2 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated
//		// Shoulder", 3, "Months");
//		// this.member2.setId(1L);
//
//	}
//
//	@Test
//	public void testAddNewMember() {
//		
//		Assert.assertEquals(this.testMemberWithID, this.service.addNewMember(player1));
//	}
//
////	@Test
////	public void testFindMembersByID() {
////		Assert.assertTrue(this.service.readMembers()).isEqualTo(this.testMemberWithID);
////	}
//
////	@Test
////	public void testReadMembers() {
////		System.out.println(this.service.readMembers());
////		assertThat(this.service.readMembers()).isEqualTo(Arrays.asList(new PlayerDomain[] { this.testMemberWithID }));
////	}
//
////	@Test
////	public void testUpdateMember() {
////		MemberDomain newMember = new MemberDomain("James", "Tierney", 25, "LB", "Dislocated Shouler", 3, "Months");
////		MemberDomain updatedMember = new MemberDomain(newMember.getFirstName(), newMember.getLastName(),
////				newMember.getAge(), newMember.getPosition(), newMember.getTypeOfInjury(), newMember.getLengthOfInjury(),
////				newMember.getTimePeriod());
////
////		updatedMember.setId(this.testMemberWithID.getId());
////
////		assertThat(this.service.updateMember(newMember, this.testMemberWithID.getId())).isEqualTo(updatedMember);
////	}
//
//	@Test
//	public void testDeleteMember() {
//
//		Assert.assertTrue(this.service.deleteMember(this.testMemberWithID.getId()));
//
//	}
//
//}
