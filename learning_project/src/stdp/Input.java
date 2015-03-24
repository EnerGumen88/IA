package stdp;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ASUS on 22/03/2015.
 */
public class Input {
    private ArrayList<Datum> data ;

    public Input(String path) {
        data = new ArrayList<>() ;
        try {
            BufferedReader f = new BufferedReader(new FileReader(new File(path))) ;
            String line = "" ;
            int cnt = 0 ;
            while((line = f.readLine()) != null){
                if(!line.isEmpty()){
                    cnt++ ;
                    data.add(new Datum(line, cnt)) ;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int taille(){
        return data.size() ;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("") ;
        for(Datum d : data)
            sb.append(d+"\n") ;
        return "Input taille = " + taille() +"\n"+sb.toString();
    }
}
