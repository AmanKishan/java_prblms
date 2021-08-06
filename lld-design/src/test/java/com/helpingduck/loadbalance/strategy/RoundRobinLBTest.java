package com.helpingduck.loadbalance.strategy;

import com.helpingduck.loadbalance.strategy.impl.RoundRobinLB;
import org.junit.jupiter.api.*;

import static com.helpingduck.loadbalance.strategy.MockData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Round Robin Load Balance Test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoundRobinLBTest {

    private RoundRobinLB roundRobinLB;
    private RoundRobinLB roundRobinLB1;
    private RoundRobinLB roundRobinLB2;

    @BeforeAll
    void setUp() {
        roundRobinLB = new RoundRobinLB(getMockServers());
        roundRobinLB1 = new RoundRobinLB(getMockServers());
        roundRobinLB2 = new RoundRobinLB(getMockServers());
    }

    @Test
    @DisplayName("Get server details using round robin algo")
    void getServerDetailsTest() {
        assertEquals("192.168.1.1", roundRobinLB.getServerDetails().getServerIp());
        assertEquals("192.168.1.2", roundRobinLB1.getServerDetails().getServerIp());
        assertNotEquals("192.168.1.4", roundRobinLB2.getServerDetails().getServerIp());
    }
}

