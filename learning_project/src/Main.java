/**
 * Created by ASUS on 23/03/2015.
 */
import neuron.NeuronLif;
import stdp.Input ;

import java.util.ArrayList;
import stdp.Datum;

public class Main {
    protected ArrayList<NeuronLif> reseauSTDP ;
    protected double[][] poids ;
    protected Input data ;
    protected int nb_epoch = 10 ;
    protected double duree = 0.5 ; // durée de présentation d'une entrée
    protected double dt = .01 ; // intervalle de tps
    protected double w1 = 0.01 ;
    protected double w2 = 0.01 ;
    protected double t0 = 0.5 ;
    /**
     * La formule du sujet n'est pas conforme à celles du cours.
     * Si false : maj des poids avec 0 < ti - tj < t0
     * Si true : maj des poids avec 0 < tj - ti < t0
     */
    protected boolean pas_compris = true ;
    
    private Main(){
        /*JFileChooser fs = new JFileChooser("/home/profil/charles9u/Bureau/IA/trunk/Data/sonar.txt") ;
        fs.showOpenDialog(null*/
        String path = "/home/profil/charles9u/Bureau/IA/trunk/Data/sonar.txt" ;
        data = new Input(path) ;
        poids = new double [60][60] ;
        // System.out.println(data);
        reseauSTDP = new ArrayList<>() ;
        for(int i = 0; i < 60 ; i++)
            reseauSTDP.add(new NeuronLif(i));
        for(int e = 0; e < nb_epoch; e++){
            for (int i = 0; i < data.taille(); i++) {
                for(double j = 0; j<duree; j+=dt) { // simulation d'une seconde de presentation de la donnée
                    excitationInput(data.getData().get(i), j);
                    excitationLaterale(data.getData().get(i).getIndice()+j);
                    majPoids() ;
                }
            }
        }
        affichage() ;
    }
    
    private void affichage() {
        int m = 0, r = 0 ;
        for (NeuronLif n : reseauSTDP){
            System.out.println("Neurone "+n.getFavorite_input()+" : "+(n.getEtiquette()));
            if(n.getEtiquette().equals("Mine"))
                m++ ;
            else
                r++ ;
        }
        System.out.println("nb Mi = "+m+"  nb Ro = "+r);
    }

    private void excitationInput(Datum d, double j) {
        for(NeuronLif n : reseauSTDP)
            n.input(d.getIndice()+j, d.getComposante(n.getFavorite_input()), d.getType()) ;
    }

    private void excitationLaterale(double indice) {
        double u_post = 0 ;
        int i = 0, j = 0 ;
        for(NeuronLif n1 : reseauSTDP){
            for(NeuronLif n2 : reseauSTDP){
                if(j != i)
                    u_post +=  poids[i][j]*n2.getPotential();
                j++ ;
            }
            j = 0 ;
            i++ ;
            n1.add(u_post, indice) ;
        }
    }

    private void majPoids() {
        for(int i = 0; i < poids.length; i++)
            for(int j = 0; j < poids[0].length; j++){
                if(pas_compris){
                    if(reseauSTDP.get(j).getSpike() < reseauSTDP.get(i).getSpike() + t0)
                        poids[i][j]+= w1 ;
                    else
                        poids[i][j]-= w2 ;
                }
                else {
                    if(reseauSTDP.get(i).getSpike() < reseauSTDP.get(j).getSpike() + t0)
                        poids[i][j]+= w1 ;
                    else
                        poids[i][j]-= w2 ;
                }
            }
    }

    public static void main(String[] args) {
        Main m = new Main() ;
    }
}
