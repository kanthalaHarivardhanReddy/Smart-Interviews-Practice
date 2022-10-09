import java.io.*;
import java.util.*;
// implemented the hashMap using the linear probing
// with the size 10

class Custom_HashMap_LP {
	int[] map = new int[10];

	Custom_HashMap_LP() {
		Arrays.fill(map, -1);
	}

	int hashFunction(int element) {
		return element%map.length;
	}

	int findNextEmptySpace(int element) {
		int i = 1;
		int hash = hashFunction(element);

		while(hashFunction(element+i) != hash){
			int temphash = hashFunction(element+i);
			if(map[temphash] == -1) 
				return temphash;
			i++;
		}

		return -1;
	}

	void insert(int element) {
		int hash = hashFunction(element);
		if(map[hash] != -1) hash = findNextEmptySpace(element);

		if(hash == -1) {;} // to increase the size

		map[hash] = element;
	}

	int search(int element) {
		int hash = hashFunction(element);
		if(map[hash] == element) return hash;

		int i =1;
		while(hashFunction(element+i) != hash) {
			int temphash = hashFunction(element+i);
			if(map[temphash] == element) return temphash;
			i++;
		}
		return -1;
	}

	void delete(int element) {
		int hash = search(element);
		if(hash != -1) {map[hash] = -1; return;}
	}

}


class Custom_HashMap_QP {
	int[] map = new int[10];

	Custom_HashMap_QP() {
		Arrays.fill(map, -1);
	}

	int hashFunction(int element) {
		return element%map.length;
	}

	int findNextEmptySpace(int element) {
		int i = 1;
		int hash = hashFunction(element);

		while(hashFunction(element+i) != hash){
			int temphash = hashFunction(element+(i*i));
			if(map[temphash] == -1) 
				return temphash;
			i++;
		}

		return -1;
	}

	void insert(int element) {
		int hash = hashFunction(element);
		if(map[hash] != -1) hash = findNextEmptySpace(element);

		if(hash == -1) {;} // to increase the size

		map[hash] = element;
	}

	int search(int element) {
		int hash = hashFunction(element);
		if(map[hash] == element) return hash;

		int i =1;
		while(hashFunction(element+(i*i)) != hash) {
			int temphash = hashFunction(element+(i*i));
			if(map[temphash] == element) return temphash;
			i++;
		}
		return -1;
	}

	void delete(int element) {
		int hash = search(element);
		if(hash != -1) {map[hash] = -1; return;}
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

		// usage of the Linear Probing
		Custom_HashMap_LP hmlp = new Custom_HashMap_LP();
		hmlp.insert(23);
		hmlp.insert(833);
		hmlp.insert(783);
		hmlp.insert(67);
		hmlp.insert(24);
		System.out.println("Using the Linear Probing: ");
		System.out.println("Before deleting the index of 783: "+hmlp.search(783));
		hmlp.delete(783);
		System.out.println("after deleting the index of 783: "+hmlp.search(783));
		// System.out.println(Arrays.toString(hmlp.map));


		// usage of the Quadratic probing
		Custom_HashMap_QP hmqp = new Custom_HashMap_QP();
		hmqp.insert(23);
		hmqp.insert(833);
		hmqp.insert(783);
		hmqp.insert(43);
		hmqp.insert(67);
		hmqp.insert(24);
		System.out.println();
		System.out.println("Using the Quadratic Probing: ");
		System.out.println("Before deleting the index of 783: "+hmqp.search(783));
		hmqp.delete(783);
		System.out.println("after deleting the index of 783: "+hmqp.search(783));
		// System.out.println(Arrays.toString(hmqp.map));
	}
}
