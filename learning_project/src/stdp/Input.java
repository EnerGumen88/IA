package stdp;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ASUS on 22/03/2015.
 */
public class Input {
    private ArrayList<Datum> data ;

    public Input(String path) {
        try {
            BufferedReader f = new BufferedReader(new FileReader(new File(path))) ;
            String line = "" ;
            while((line = f.readLine()) != null)
                data.add(new Datum(line)) ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
