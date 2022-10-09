import java.io.*;
import java.util.*;
// implemented the hashMap using the Separate Chaining

class LLNode{
	int val;
	LLNode next;
	LLNode(int val, LLNode next) {
		this.val = val;
		this.next = next;
	}
}

class custom_HashMap_SepChaining{
	class LLNode{
		int val;
		LLNode next;
		LLNode(int val, LLNode next) {
			this.val = val;
			this.next = next;
		}
	}

	LLNode[] map = new LLNode[10];
	custom_HashMap_SepChaining() {
		Arrays.fill(map, null);
	}

	int hashFunction(int element) {
		return element%map.length;
	}

	void insert(int element) {
		int hash = hashFunction(element);
		LLNode next = map[hash];

		//creating a node and inserting at the beginning of the list
		LLNode node = new LLNode(element, next);
		map[hash] = node;
	}

	boolean search(int element) {
		int hash = hashFunction(element);
		LLNode root = map[hash];
		while(root != null) {
			if(root.val == element) return true;
			root = root.next;
		}
		return false;
	}

	void delete(int element) {
		if(!search(element)) return;

		int hash = hashFunction(element);
		LLNode root = map[hash];
		LLNode prev = null;
		while(root != null) {
			if(root.val == element) break;
			prev = root;
			root = root.next;
		}
		if(prev == null) map[hash] = map[hash].next;
		prev.next = root.next;
	}

}
public class CustomHashMap {
	public static void main(String[] args) {
		try{
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		}
		catch(Exception e) {
			System.err.println(e);
		}


		custom_HashMap_SepChaining hmsc = new custom_HashMap_SepChaining();
		hmsc.insert(23);
		hmsc.insert(833);
		hmsc.insert(783);
		hmsc.insert(43);
		hmsc.insert(67);
		hmsc.insert(24);
		System.out.println();
		System.out.println("Using the Seperate chaining: ");
		System.out.println("Before deleting the index of 783: "+hmsc.search(783));
		hmsc.delete(783);
		System.out.println("after deleting the index of 783: "+hmsc.search(783));
		System.out.println("search for 833 "+hmsc.search(833));
		System.out.println("search for 83 "+hmsc.search(83));
	}
}
