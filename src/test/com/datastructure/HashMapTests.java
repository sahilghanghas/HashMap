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
	public void containsKeyTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        map.add("testing",1 ); 
        map.add("hash",2 ); 
        map.add("map",5 );
        assertEquals(true,map.containsKey("hash"));
        assertEquals(false,map.containsKey("table"));
	}
	
	@Test
	public void emptyTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        assertEquals(true,map.isEmpty());
	}
	
	@Test
	public void clearTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        map.add("testing",1 ); 
        map.add("hash",2 ); 
        map.add("map",5 );
        map.clear();
        assertEquals(0,map.getSize());
	}
	
	@Test
	public void rehashingTest() {
		HashMap<String, Integer>map = new HashMap<>(); 
        map.add("testing",1 ); 
        map.add("hash",2 );
        map.add("test1",3 ); 
        map.add("test2",4 );
        map.add("test3",5 ); 
        map.add("test4",6 );
        map.add("test5",7 );
        map.add("test6",8 ); 
        map.add("test7",9 );
        map.add("test8",10 ); 
        map.add("test9",11 );
        map.add("test10",12 );
        map.add("test11",13 ); 
        map.add("test12",14 );
        map.add("test13",15 ); 
        map.add("test14",16 );
        map.add("test15",17 );
        map.remove("testing");
        assertEquals(16,map.getSize());
	}
}
