import org.junit.Assert;
import org.junit.Test;

import com.prateek.randomnumbergenerator.RandomNumberGenerator;

public class RandomNumberGeneratorTest {

	@Test
	public void shouldReturnRandomlyGeneratedNumber() {
			int x = RandomNumberGenerator.getRandomlyGeneratedNumber(15);
			System.out.println(x);
			Assert.assertTrue(x < 15);
	}
	
}
