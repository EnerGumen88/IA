package neuron;


/**
 * Created by ASUS on 22/03/2015.
 */
public class NeuronLif {
    private double potential ;
    private int favorite_input ;
    private int nb_rock = 0, nb_mine = 0 ;
    private double spike = -1 ;
    private double C = 0.1 ; // Capacité
    private double R = 1 ; // Resistance
    private double V = 1 ; // Seuil d'exitation du neurone
    
    public NeuronLif(int favorite){
        favorite_input = favorite ;
    }

    public int getFavorite_input() {
        return favorite_input;
    }

    public double getSpike() {
        return spike;
    }

    public double getPotential() {
        return potential;
    }

    public String getEtiquette() {
        if(nb_mine > nb_rock)
            return "Mine" ;
        return "Rock   Mine = "+nb_mine+" Rock = "+nb_rock ;
        //return "Mine = "+nb_mine+" Rock = "+nb_rock ;
    }

    public void input(double indice, double val, String type) {
        potential += (val/C - potential/(R*C))*0.01 ;
        if(potential >= V) {
            potential = 0 ;
            spike = indice ;
            if(type.equals("Mine"))
                nb_mine++ ;
            else
                nb_rock++ ;
        }
    }

    public void add(double u, double indice) {
       potential += u ;
       if(potential >= V){
            potential = 0 ;
            spike = indice ;
       }
    }

}
