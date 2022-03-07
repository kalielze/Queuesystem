/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.process_control;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author user
 */
public class load_sound {
    
    private final String[] data_sat = {"nol.wav", "satu.wav", "dua.wav", "tiga.wav", "empat.wav", "lima.wav", "enam.wav", "tujuh.wav", "delapan.wav", "sembilan.wav"};
    private final String[] data_pul = {"belas.wav", "puluh.wav", "ratus.wav", "ribu.wav"};
    private final String[] data_se = {"sepuluh.wav", "sebelas.wav", "seratus.wav", "seribu.wav"};
    private int digit_sat, digit_dua, digit_tig, digit_emp;

    @SuppressWarnings({"UseSpecificCatch", "SleepWhileHoldingLock"})
    private void play_sound(File f, long mili) {
        try {
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(f));
            c.start();
            /*while (!c.isRunning())
                Thread.sleep(mili);
            while (c.isRunning())*/
                Thread.sleep(mili);
            c.stop();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(load_sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(load_sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(load_sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(load_sound.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void get_sat(int nomer) {
        //File n = new File("sounds/" + data_sat[nomer]).getAbsoluteFile();
        //play_sound(n, 1000L);
        playSound("sounds/" + data_sat[nomer]);
    }

    private void get_pul(int nomer) {
        //File n = new File("sounds/" + data_pul[nomer]).getAbsoluteFile();
        //play_sound(n, 1000L);
        playSound("sounds/" + data_pul[nomer]);
    }

    private void get_se(int nomer) {
        //File n = new File("sounds/" + data_se[nomer]).getAbsoluteFile();
        //play_sound(n, 1000L);
        playSound("sounds/" + data_se[nomer]);
    }

    private void code(int kategori) {
        if (kategori == 1 || kategori < 3) {
            //File q = new File("sounds/spp.wav").getAbsoluteFile();
            //play_sound(q, 1500L);
            playSound("sounds/spp.wav");
        } else if (kategori == 3 || kategori < 5) {
            //File q = new File("sounds/setoran.wav").getAbsoluteFile();
            //play_sound(q, 1500L);
            playSound("sounds/setoran.wav");
        } else if (kategori >= 5) {
            //File q = new File("sounds/tabungan.wav").getAbsoluteFile();
            //play_sound(q, 1500L);
            playSound("sounds/tabungan.wav");
        }
    }

    private void number(String nomor) {
        digit_sat = Integer.parseInt(nomor.substring(0, 1));
        digit_dua = Integer.parseInt(nomor.substring(1, 2));
        digit_tig = Integer.parseInt(nomor.substring(2, 3));
        digit_emp = Integer.parseInt(nomor.substring(3));

        if (digit_sat != 0) {
            if (digit_sat == 1) {
                get_se(3);
            } else if (digit_sat > 1) {
                get_sat(digit_sat);
                get_pul(3);
            }
        }

        if (digit_dua != 0) {
            if (digit_dua == 1) {
                get_se(2);
            } else if (digit_dua > 1) {
                get_sat(digit_dua);
                get_pul(2);
            }
        }

        if (digit_tig != 0 && digit_emp == 0) {
            if (digit_tig == 1) {
                get_se(0);
            } else if (digit_tig > 1) {
                get_sat(digit_tig);
                get_pul(1);
            }
        } else if (digit_tig != 0 && digit_emp != 0) {
            if (digit_tig == 1 && digit_emp == 1) {
                get_se(1);
            } else if (digit_tig == 1 && digit_emp > 1) {
                get_sat(digit_emp);
                get_pul(0);
            } else if (digit_tig > 1 && digit_emp >= 1) {
                get_sat(digit_tig);
                get_pul(1);
                get_sat(digit_emp);
            }
        } else if (digit_tig == 0 && digit_emp != 0) {
            get_sat(digit_emp);
        }
    }

    private void counter(String count) {
        //File c = new File("sounds/meja.wav").getAbsoluteFile();
        //play_sound(c, 1500L);
        playSound("sounds/meja.wav");
        
        if (count.length() == 1) {
            digit_tig = 0;
            digit_emp = Integer.parseInt(count);
        } else {
            digit_tig = Integer.parseInt(count.substring(0, 1));
            digit_emp = Integer.parseInt(count.substring(1, 2));
        }

        if (digit_tig != 0 && digit_emp == 0) {
            if (digit_tig == 1) {
                get_se(0);
            } else if (digit_tig > 1) {
                get_sat(digit_tig);
                get_pul(1);
            }
        } else if (digit_tig != 0 && digit_emp != 0) {
            if (digit_tig == 1 && digit_emp == 1) {
                get_se(1);
            } else if (digit_tig == 1 && digit_emp > 1) {
                get_sat(digit_emp);
                get_pul(0);
            } else if (digit_tig > 1 && digit_emp >= 1) {
                get_sat(digit_tig);
                get_pul(1);
                get_sat(digit_emp);
            }
        } else if (digit_tig == 0 && digit_emp != 0) {
            get_sat(digit_emp);
        }
    }

    public void call_number(String nomor_antrian, String nomor_meja) {
        synchronized(this) {
            //playSound("sounds/pembuka.wav");
            code(Integer.parseInt(nomor_antrian.substring(0, 1)));
            number(nomor_antrian);
            counter(nomor_meja);
            //playSound("sounds/penutup.wav");
        }
    }
    
    private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    
    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch", "SleepWhileInLoop"})
    public void playSound(String filename){

        String strFilename = filename;

        try {
            soundFile = new File(strFilename).getAbsoluteFile();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();
        while(sourceLine.isRunning()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(load_sound.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }
    
}
