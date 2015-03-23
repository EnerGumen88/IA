package stdp;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ASUS on 22/03/2015.
 */
public class Input {
    private ArrayList<Datum> data ;

    public Input(String path) {
        data = new ArrayList<Datum>() ;
        try {
            BufferedReader f = new BufferedReader(new FileReader(new File(path))) ;
            String line = "" ;
            while((line = f.readLine()) != null)
                if(!line.isEmpty())
                    data.add(new Datum(line)) ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int taille(){
        return data.size() ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("") ;
        for(Datum d : data)
            sb.append(d+"\n") ;
        return "Input taille = " + taille() +"\n"+sb.toString();
    }
}
