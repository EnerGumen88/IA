package stdp;

import java.util.ArrayList;

/**
 * Created by ASUS on 22/03/2015.
 */
public class Datum {
    private ArrayList<Double> composantes ;
    private String type ;

    public Datum(String line) {
        String[] compo = line.split(",") ;
        composantes = new ArrayList<Double>() ;
        for(int i = 0; i <60; i++)
            composantes.add(Double.parseDouble(compo[i])) ;
        type = compo[60] ;
    }

    public String getType() {
        return type;
    }

    public Double getComposante(int i){
        if(i <0 || i >60)
            throw new IllegalArgumentException("indice hors limite") ;
        return composantes.get(i) ;
    }

    @Override
    public String toString() {
        return "Datum "+ getType() + " : nb composante = "+ composantes.size();
    }
}
