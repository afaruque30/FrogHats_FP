import java.io.File;
 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

import javax.sound.sampled.SourceDataLine;
 
public class simpleSoundPlayer implements Runnable {
 
    
    private static final int BUFFER_SIZE = 4096;
    private volatile boolean running = true; 

    void play(String filePath) {
        File soundFile = new File(filePath);
        try {
          //convering the audio file to a stream
            AudioInputStream sampleStream = AudioSystem.getAudioInputStream(soundFile);
 
            AudioFormat formatAudio = sampleStream.getFormat();
 
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, formatAudio);
 
            SourceDataLine theAudioLine = (SourceDataLine) AudioSystem.getLine(info);
 
            theAudioLine.open(formatAudio);
 
            theAudioLine.start();

             
            byte[] bufferBytes = new byte[BUFFER_SIZE];
            int readBytes = -1;
 
            while ((readBytes = sampleStream.read(bufferBytes)) != -1) {
                theAudioLine.write(bufferBytes, 0, readBytes);
            }
             
            theAudioLine.drain();
            theAudioLine.close();
            sampleStream.close();
             
             
        } catch (Exception p) {
            System.out.println("error");
        }
    }
    public void terminate() {
        running = false;
    }
    public void run() {
        
            while (running) {
                try {
                    play("RocketFuel.aiff");
                } catch (Exception e) {
                    running = false;
                    
                }
            }
            
        }
        
        
    
     
    public static void main(String[] args) {
        String thePath = "RocketFuel.aiff";
        simpleSoundPlayer player = new simpleSoundPlayer();
        player.play(thePath);
    }
 
}