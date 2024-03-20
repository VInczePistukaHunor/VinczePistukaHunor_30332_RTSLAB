package App1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RThread extends Thread{

    FileService service;

    public RThread(FileService service) {

        this.service = service;

    }

    public void run() {
        while (!Main.isStopThreads()) {
            try {
                synchronized (service) {
                    String readMsg = service.read();
                    System.out.println(readMsg);
                }
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}