package Tick2Star;

public class Test {

	public static void main(String[] args) {
		LCSTopDownRecursive rec = new LCSTopDownRecursive("xaxbxcxd", "aabbccdd");
		System.out.println(rec.getLCSLength());
		System.out.println(rec.getLCSString());
		LCSTopDownNonRecursive nonrec = new LCSTopDownNonRecursive("xaxbxcxd", "aabbccdd");
		System.out.println(nonrec.getLCSLength());
		System.out.println(nonrec.getLCSString());
	}

}
