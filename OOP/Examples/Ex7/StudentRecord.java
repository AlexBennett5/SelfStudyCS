
package Ex7;

import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedList;

class StudentRecord {

	private TreeMap<String, Double> alphamap;
	private TreeMap<Double, String> grademap;

	StudentRecord() {

		alphamap = new TreeMap<String,Double>();
		grademap = new TreeMap<Double,String>();

	}

	public void addRecord(String name, double grade) {

		alphamap.put(name, grade);
		grademap.put(grade, name);

	}

	public LinkedList<String> getNameList() {

		LinkedList<String> names = new LinkedList<String>();

		for (Map.Entry<String,Double> entry : alphamap.entrySet()) {

			names.add(entry.getKey());

		}

		return names;

	}

	public LinkedList<String> getTopPercent(double percent) {

		int k = (int) (grademap.size() * (percent/100.0));
		int count = grademap.size() - k;
		LinkedList<String> honors = new LinkedList<String>();

		for (Map.Entry<Double,String> entry : grademap.entrySet()) {

			if (count == 0) {
				honors.add(entry.getValue());
			} else {
				count--;
			}
			

		}

		return honors;

	}

	public double getMedian() {

		int index = grademap.size()/2;
		int count = 1;
		double res = 0.0;

		if (grademap.size() % 2 == 0) {

			for (Map.Entry<Double,String> entry : grademap.entrySet()) {

				if (count == index) {
					res = entry.getKey();
				}

				if (count == index + 1) {
					res += entry.getKey();
					res /= 2.0;
					break;
				}

				count++;
			}

		} else {

			for (Map.Entry<Double,String> entry : grademap.entrySet()) {

				if (count == index + 1) {
					res = entry.getKey();
					break;
				}

				count++;

			}

		}

		return res;

	}

	public static void main(String args[]) {

		StudentRecord test = new StudentRecord();

		test.addRecord("John Jones", 2.0);
		test.addRecord("Janice James", 34.45);
		test.addRecord("Samuel Pips", 56.78);
		test.addRecord("Lana Demp", 68.34);
		test.addRecord("Rod Perfecto", 89.73);

		LinkedList<String> alphanames = test.getNameList();
		LinkedList<String> tophund = test.getTopPercent(100.0);
		LinkedList<String> topfift = test.getTopPercent(50.0);

		System.out.println(alphanames);
		System.out.println(tophund);
		System.out.println(topfift);
		System.out.println(test.getMedian());

		test.addRecord("Ian Maestro", 94.23);

		topfift = test.getTopPercent(50.0);
		LinkedList<String> topfort = test.getTopPercent(40.0);

		System.out.println(topfift);
		System.out.println(topfort);
		System.out.println(test.getMedian());


	}

}

