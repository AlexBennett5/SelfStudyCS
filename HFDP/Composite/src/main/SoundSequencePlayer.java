
package src.main;

import javax.sound.midi.Sequencer;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Track;
import javax.sound.midi.MidiEvent;
import java.lang.Exception;
import java.util.ArrayList;

public class SoundSequencePlayer {

	private SoundSequence sound;

	public SoundSequencePlayer(SoundSequence sound) {

		this.sound = sound;
	}

	public void setSoundSequence(SoundSequence sound) {

		this.sound = sound;
	}

	public void play() {

		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			Sequence sequence = new Sequence(Sequence.PPQ, 4);
			Track track = sequence.createTrack();

			ArrayList<MidiEvent> midi = sound.generateSounds();

			for (MidiEvent event : midi) {
				track.add(event);
			}

			sequencer.setSequence(sequence);
			sequencer.start();

			while (true) {

				if (!sequencer.isRunning()) {
					sequencer.close();
				}
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

}

