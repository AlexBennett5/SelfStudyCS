
package Observer;

public class Test {

	public static void main(String[] args) {

		NewsSource ns = new NewsSource();
		IObserver nf = new NormalFeed(ns);
		IObserver af = new AllcapsFeed(ns);

		ns.addObserver(nf);
		ns.addObserver(af);

		ns.checkNews("Urgent: Germany invades France!!");
		ns.checkNews("King Edward given the title 'Kind Edward'");
		ns.removeObserver(nf);
		ns.checkNews("Nuclear bomb detonated over Chicago");		

	}

}

