package test.com.datastructure;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;

import com.datastructure.HashMap;

public class HashMapTests {
	
	@Test
	public void insetTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        map.add("this",1 ); 
        map.add("coder",2 ); 
        map.add("this",4 ); 
        map.add("hi",5 ); 
        assertEquals(3,map.getSize());
	}
	
	@Test
	public void removeTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        map.add("this",1 ); 
        map.add("coder",2 ); 
        map.add("this",4 ); 
        map.add("hi",5 );
        map.remove("this");
        assertEquals(2,map.getSize());
	}
	
}
