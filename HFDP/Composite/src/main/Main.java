
package src.main;

public class Main {


	public static void main(String[] args) {

		int[] trill = {13, 14, 13, 14, 13, 15};
		int[] beethoven = {6, 6, 6, 2, 5, 5, 5, 1};
		int[] goingup = {5, 7, 10, 15, 23, 30};

		MusicalPhrase p1 = createPhrase(trill, 1);
		MusicalPhrase p2 = createPhrase(beethoven, 13);
		MusicalPhrase p3 = createPhrase(goingup, 20);		
		
		Melody md = new Melody();
		md.add(p1);
		md.add(p2);
		md.add(p3);

		Note testNote = new Note(15, 1);

		SoundSequencePlayer player = new SoundSequencePlayer(p2);
		player.play();
		player.setSoundSequence(md);
		player.play();
		player.setSoundSequence(testNote);
		player.play();

	}

	public MusicalPhrase createPhrase(int[] noteValues, int startingTick) {

		MusicalPhrase phrase = new MusicalPhrase();

		for (int i = 0; i < noteValues.length; i++) {
			phrase.addNote(new Note(noteValues[i], startingTick));
			startingTick += 2;
		}

		return phrase;

	}

}

