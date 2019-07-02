package com.example.async;

import com.example.async.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncApplicationTests {
	@Autowired
	private AsyncService asyncService;
	@Test
	public void testAsync() {
		for (int i = 0; i < 10; i++) {
			asyncService.executeAsync1();
			asyncService.executeAsync2();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
