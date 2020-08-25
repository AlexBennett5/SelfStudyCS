
package src.main;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.lang.Exception;
import java.util.ArrayList;

public class Note implements SoundSequence {

	private ArrayList<MidiEvent> soundData;

	public Note(int note, int tick) {

		soundData = new ArrayList<MidiEvent>();
		soundData.add(generateMidiEvent(ShortMessage.NOTE_ON, note, tick));
		soundData.add(generateMidiEvent(ShortMessage.NOTE_OFF, note, tick + 2));

	}

	public MidiEvent generateMidiEvent(int command, int note, int tick) {

		MidiEvent event = null;

		try {

			ShortMessage message = new ShortMessage();
			message.setMessage(command, 1, note, 100);
			event = new MidiEvent(message, tick);
		
		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return event;

	}

	public ArrayList<MidiEvent> generateSounds() {
		return soundData;
	}

}

