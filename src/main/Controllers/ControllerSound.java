package main.Controllers;

import main.Notes;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class ControllerSound {
    public static int getCode(String name) {
        return Notes.valueOf(name).code;
    }

    private static MidiChannel channel;

    private static void loadChannel() {
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            synth.loadInstrument(synth.getDefaultSoundbank().getInstruments()[5]);

            channel = synth.getChannels()[0];

        } catch (MidiUnavailableException e) {
            System.out.println("Cannot get synth");
            e.printStackTrace();
        }
    }

    public static void playSound(int number) {
        loadChannel();
        channel.noteOn(number, 90);
        channel.noteOff(number);
    }
}
