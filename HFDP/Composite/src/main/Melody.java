
package src.main;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.lang.Exception;
import java.util.ArrayList;

public class Melody implements SoundSequence {

	private ArrayList<MusicalPhrase> soundData;

	public Melody() {

		soundData = new ArrayList<MusicalPhrase>();
	}

	public void addMusicalPhrase(MusicalPhrase phrase) {

		soundData.add(phrase);

	}	

	public ArrayList<MidiEvent> generateSounds() {
		
		ArrayList<MidiEvent> notes = new ArrayList<MidiEvent>();
		
		for (MusicalPhrase phrase : soundData) {

			notes.addAll(phrase.generateSounds());
		
		}

		return notes;

	}

}

