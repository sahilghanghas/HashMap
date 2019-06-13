package test.com.datastructure;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.datastructure.HashMap;

public class HashMapTests {
	
	@Test
	public void insetTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        map.add("testing",1 ); 
        map.add("hash",2 );
        map.add("map",5 ); 
        assertEquals(3,map.getSize());
	}
	
	@Test
	public void removeTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        map.add("testing",1 ); 
        map.add("hash",2 ); 
        map.add("testing",4 ); 
        map.add("map",5 );
        map.remove("testing");
        assertEquals(2,map.getSize());
	}
	
	@Test
	public void getTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        map.add("testing",1 ); 
        map.add("hash",2 ); 
        map.add("map",5 );
        assertEquals(2,map.get("hash"));
	}
	
	@Test
	public void containsTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        map.add("testing",1 ); 
        map.add("hash",2 ); 
        map.add("map",5 );
        assertEquals(true,map.contains("hash"));
        assertEquals(false,map.contains("table"));
	}
	
	@Test
	public void emptyTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        assertEquals(true,map.isEmpty());
	}
	
}
