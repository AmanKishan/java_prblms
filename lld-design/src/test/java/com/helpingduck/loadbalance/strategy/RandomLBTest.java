package com.helpingduck.loadbalance.strategy;

import com.helpingduck.loadbalance.strategy.impl.RandomLB;
import org.junit.jupiter.api.*;

import static com.helpingduck.loadbalance.strategy.MockData.getMockServers;
import static com.helpingduck.loadbalance.strategy.MockData.getNotPresentMockServers;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Random Load Balancer Test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RandomLBTest  {

	private RandomLB randomLB;

	@BeforeEach
	void setUp(){
		randomLB = new RandomLB(getMockServers());
	}

	@Test
	@DisplayName("Test for getting random server details")
	void getServerDetailsTest(){
		assertTrue(getMockServers().contains(randomLB.getServerDetails().getServerIp()));
	}

	@Test
	@DisplayName("Test for not getting not present random server details")
	void getServerDetailsNotPresentServerTest(){
		assertFalse(getNotPresentMockServers().contains(randomLB.getServerDetails().getServerIp()));
	}

}
