package io.github.mat3e;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {
    private HelloService SUT = new HelloService();
    @Test
    public void test_prepareGreeting_null_returnsGreetingWithFallback() throws Exception {
        //given + when
        var result = SUT.prepareGreeting(null);

        //then
        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);
    }
    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName() throws Exception {
        //given + when
        var name = "test";
        var result = SUT.prepareGreeting(name);


        //then
        assertEquals("Hello " + name + "!", result);
    }
}