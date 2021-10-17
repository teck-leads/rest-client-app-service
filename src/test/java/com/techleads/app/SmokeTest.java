package com.techleads.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techleads.app.controller.ActivityLogController;

@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private ActivityLogController activityLogController;

	@Test
	void contextLoads() {
		assertThat(activityLogController).isNotNull();
	}
}
