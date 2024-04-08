package App1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FileService {

    String fileName;

    BufferedReader in;

    PrintWriter out;

    public FileService(String fname) {

        this.fileName = fname;

        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(String msg) {
        syncronized {
        Date date = new Date(System.currentTimeMillis());
        out.println("Date: " + date);
        out.println("Message: " + msg);
        out.flush();
    }

    public synchronized String read() throws IOException {
        String iterator, last = "no message to read";
        while ((iterator = in.readLine()) != null) {
            last = new Date(System.currentTimeMillis()) + " - " + iterator;
        }
        return last;
    }
}
