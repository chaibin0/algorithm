package programmers.q12933;

import org.hamcrest.core.Is;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		Solution solution = new Solution();
		assertThat(solution.solution(118372), Is.is(873211L));
	}

}
