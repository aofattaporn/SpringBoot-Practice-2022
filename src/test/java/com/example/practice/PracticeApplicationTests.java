package com.example.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PracticeApplicationTests {

	@Test
	void contextLoads() {
		boolean expected = true;
		boolean actual = true;
		Assertions.assertEquals(expected, actual);
	}

}
