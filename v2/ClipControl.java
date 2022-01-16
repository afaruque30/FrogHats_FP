import java.io.File;
import javax.sound.sampled.*;

class ClipControl implements Runnable {
    File path = new File("RocketFuel.aiff");
    AudioInputStream ais;
    Clip clip;

    public ClipControl() {
        try {
            load();
        } catch (Exception e) {
            //TODO: handle exception
        }
       
    }
    public void load() throws Exception {
        path = new File("RocketFuel.aiff");
        ais = AudioSystem.getAudioInputStream(path);
        clip = AudioSystem.getClip();
        
    }
    public void run() {
        try {
            clip.open(ais);
        } catch (Exception e) {
           
        }
        
        while (!Thread.currentThread().isInterrupted()) {
            clip.start();
        }
    }
}