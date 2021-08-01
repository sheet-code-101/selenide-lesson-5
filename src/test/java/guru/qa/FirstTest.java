package guru.qa;

import org.junit.jupiter.api.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after allS");
    }

    @BeforeEach
    void setUp()  {
        System.out.println("before each");
    }

    @AfterEach
    void tearDown()  {
        System.out.println("after each");
    }

    @Test
    void firstTest() {
        System.out.println("first test");
        Assertions.assertTrue(true);
    }

    @Test
    void secondTest() {
        System.out.println("second test");
        Assertions.assertTrue(true);
    }

}
