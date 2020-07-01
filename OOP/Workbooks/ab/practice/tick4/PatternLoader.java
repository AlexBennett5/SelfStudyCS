
package ab.practice.tick4;

import java.io.Reader;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.io.FileReader;

public class PatternLoader {

	public static List<Pattern> load(Reader r) throws IOException, PatternFormatException {

		BufferedReader br = new BufferedReader(r);
		List<Pattern> resultList = new LinkedList<Pattern>();

		while (br.ready()) {

			Pattern p = new Pattern(br.readLine());
			resultList.add(p);

		}

		return resultList;

	}

	public static List<Pattern> loadFromURL(String url) throws IOException, PatternFormatException {

		URL destination = new URL(url);
		URLConnection conn = destination.openConnection();
		return load(new InputStreamReader(conn.getInputStream()));

	}

	public static List<Pattern> loadFromDisk(String filename) throws IOException, PatternFormatException {

		return load(new FileReader(filename));
	}

}

