package java7.test.car;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class validate {
	
	@Test
	public void test(){
		int result = 42;
		assertThat(result).isEqualTo(42);
	}
	
}
