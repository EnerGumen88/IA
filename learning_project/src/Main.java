/**
 * Created by ASUS on 23/03/2015.
 */
import neuron.NeuronLif;
import stdp.Input ;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private ArrayList<NeuronLif> reseauSTDP ;

    private Main(){
        JFileChooser fs = new JFileChooser("C:\\Users\\ASUS\\Desktop\\IA\\trunk\\Data") ;
        fs.showOpenDialog(null) ;
        String path = fs.getSelectedFile().getAbsolutePath() ;
        System.out.println(path);
        Input data = new Input(path) ;
        System.out.println(data);
        int nb_epoch = 100 ;
        double dt = .01 ;
        for(int e = 0; e < nb_epoch; e++){
            for (int i = 0; i < data.taille(); i++) {
                for(int j = 0; j<10; j+=dt) // simulation d'une seconde de presentation de la donnée
                    excitationInput(i);
                excitationLaterale();
            }
        }
    }

    private static void excitationInput(int i) {

    }

    private static void excitationLaterale() {

    }

    public static void main(String[] args) {
        Main m = new Main() ;
    }
}
