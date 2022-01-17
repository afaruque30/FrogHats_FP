import java.io.File;
import javax.sound.sampled.*;
import javax.sound.midi.*;

class ClipControl implements Runnable {
    File path = new File("RocketFuel.aiff");
    Sequence sequence;
    Sequencer sequencer;

    public ClipControl() {
        try {
            load();
        } catch (Exception e) {
            //TODO: handle exception
        }
       
    }
    public void load() throws Exception {
        path = new File("Opening.mid");
        sequence = MidiSystem.getSequence(path);
        sequencer = MidiSystem.getSequencer();
        
    }
    public void run() {
        try {
            // clip.open(ais);
            sequencer.open();
            sequencer.setSequence(sequence);
    
            
        } catch (Exception e) {
           
        }
        
        while (!Thread.currentThread().isInterrupted()) {
            // clip.start();
            sequencer.start(); 
        }
        sequencer.stop();
        sequencer.close();
    }
}
