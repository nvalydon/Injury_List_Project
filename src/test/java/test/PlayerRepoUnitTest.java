package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.App;
import com.bae.persistence.domain.Player;
import com.bae.persistence.repo.PlayerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = App.class)
public class PlayerRepoUnitTest {

	@Autowired
	private PlayerRepository playerRepo;

	private final String TEST_TYPE_OF_INJURY = "Broken Ankle";
	private final Player TEST_PLAYER = new Player("Henry", "Allen", 30, TEST_TYPE_OF_INJURY, 5, "Months");

	private Player testSavedPlayer;

	@Before
	public void init() {

		this.playerRepo.deleteAll();
		this.testSavedPlayer = this.playerRepo.save(this.TEST_PLAYER);

	}

	@Test
	public void testFindByName() {

		assertThat(this.playerRepo.findByTypeOfInjury(TEST_TYPE_OF_INJURY));

	}

}
