package music;

import java.io.File;
import javax.sound.midi.*;

public class ClipControl implements Runnable {
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
    public void setSong(int i) {
        switch (i) {
            case 0:
                path = new File("Opening.mid");
                break;
            case 1:
                path = new File("Shop.mid");
                break;
            case 2: 
                path = new File("Battle.mid");
                break;
            case 3:
                path = new File("BossBattle.mid");
                break;
            case 4:
                path = new File("Heavenly.mid");
                break;
            case 5:
                path = new File("Lose.mid");
                break;
            case 6: 
                path = new File("Village.mid");
                break;
        }
        
    }
    public void load() throws Exception {
        
        sequence = MidiSystem.getSequence(path);
        sequencer = MidiSystem.getSequencer();
        sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        
        
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
