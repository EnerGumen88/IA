package stdp;

import java.util.ArrayList;

/**
 * Created by ASUS on 22/03/2015.
 */
public class Datum {
    private ArrayList<Double> composantes ;
    private String type ;
    private int indice ;

    public Datum(String line, int ind) {
        String[] compo = line.split(",") ;
        composantes = new ArrayList<>() ;
        indice = ind ;
        for(int i = 0; i <60; i++)
            composantes.add(Double.parseDouble(compo[i])) ;
        type = compo[60] ;
    }

    public String getType() {
        return type;
    }

    public int getIndice() {
        return indice;
    }

    public Double getComposante(int i){
        if(i <0 || i >=60)
            throw new IllegalArgumentException("indice hors limite") ;
        return composantes.get(i) ;
    }

    @Override
    public String toString() {
        return "Datum n°"+indice+" "+ getType() + " : nb composante = "+ composantes.size();
    }
}
