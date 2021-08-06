package com.helpingduck.loadbalance.strategy;

import com.helpingduck.loadbalance.strategy.impl.IpHashingLB;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.helpingduck.loadbalance.strategy.MockData.getIpHashExpectedServerDetails;
import static com.helpingduck.loadbalance.strategy.MockData.getMockServers;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Ip Hashing Load Balance Test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IpHashingLBTest {

    @Test
    @DisplayName("Get Test Details for ip Hashing load balance test")
    void getServerDetailsTest() {
        String clientIp = "192.164.1.1";
        IpHashingLB ipHashingLB = new IpHashingLB(clientIp, getMockServers());
        assertEquals(getIpHashExpectedServerDetails(clientIp), ipHashingLB.getServerDetails().getServerIp());
    }

    @Test
    @DisplayName("Get Test Details for ip Hashing load balance test for null")
    void getServerDetailsNullTest() {
        String clientIp = "127.0.0.1";
        IpHashingLB ipHashingLB = new IpHashingLB(null, getMockServers());
        assertEquals(getIpHashExpectedServerDetails(clientIp), ipHashingLB.getServerDetails().getServerIp());
    }
}
