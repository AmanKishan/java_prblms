package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@DisplayName("Ip Hashing Load Balance Test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class HelloWorldTest {

    @Test
    void testMain(){
        String arr[] = new String[12];
        HelloWorld.main(arr);
    }
}
