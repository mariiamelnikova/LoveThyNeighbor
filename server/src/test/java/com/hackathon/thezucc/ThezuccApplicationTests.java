package com.hackathon.thezucc;

import com.hackathon.thezucc.users.model.User;
import com.hackathon.thezucc.users.repository.UsersRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThezuccApplicationTests {

	@Autowired
	private UsersRespository usersRespository;


	@Test
	void name() {
//		User byQrId = usersRespository.findByQrId(5000);
		User user = User.builder()
				.firstName("fds")
				.lastName("fdsfds")
				.build();
		usersRespository.save(user);
		System.out.println("dsf");
	}
}
