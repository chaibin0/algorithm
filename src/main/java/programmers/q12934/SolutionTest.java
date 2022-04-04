package programmers.q12934;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

	@Test
	public void test() {
		Solution solution = new Solution();
		System.out.println(solution.solution(121));
		assertThat(solution.solution(121), Is.is(144));
	}

	@Test
	public void test2() {
		Solution solution = new Solution();
		assertThat(solution.solution(3), Is.is(144));
	}

}
