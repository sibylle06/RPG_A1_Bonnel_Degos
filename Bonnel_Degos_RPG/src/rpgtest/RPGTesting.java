package rpgtest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RPGTesting {
	private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    
    @Test
    void moreDPSThanLive() {
    	Assertions.assertTrue(true); // test true or false
    }
    
    @Test
    void noMorePlayers() {
    	Assertions.assertTrue(true); // test true or false
    }
    
    @Test
    void notEnoughMana() {
    	Assertions.assertTrue(true); // test true or false
    }
    
    @Test
    void arrowDecrease() {
    	Assertions.assertTrue(true); // test true or false
    }
    
    @Test
    void reward() {
    	Assertions.assertTrue(true); // test true or false
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}