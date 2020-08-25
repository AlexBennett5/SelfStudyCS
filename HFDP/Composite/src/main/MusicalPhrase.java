
package src.main;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.lang.Exception;
import java.util.ArrayList;

public class MusicalPhrase implements SoundSequence {

	private ArrayList<Note> soundData;

	public MusicalPhrase() {

		soundData = new ArrayList<Note>();
	}

	public void addNote(Note note) {

		soundData.add(note);

	}	

	public ArrayList<MidiEvent> generateSounds() {
		
		ArrayList<MidiEvent> notes = new ArrayList<MidiEvent>();
		
		for (Note nt : soundData) {

			notes.addAll(nt.generateSounds());
		
		}

		return notes;

	}

}

