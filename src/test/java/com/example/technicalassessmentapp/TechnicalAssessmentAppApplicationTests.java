package com.example.technicalassessmentapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TechnicalAssessmentAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void main() {
		TechnicalAssessmentAppApplication.main(new String[] {});
	}
}
