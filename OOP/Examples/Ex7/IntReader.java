
package Ex7;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

class IntReader {



	public static void main(String[] args) {

		try {

			FileReader file = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(file);
			ArrayList<String> nums = new ArrayList<String>();

			while (br.ready()) {
				nums.add(br.readLine());
			}
		
			Collections.sort(nums, new IntDubComparator());
	
			for (int i=0; i<nums.size(); i++) {
				System.out.println(nums.get(i));
			}

		} catch (IOException ex) {

			System.out.println("Invalid file");

		}

	}



}



