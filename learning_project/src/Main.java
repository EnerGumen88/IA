/**
 * Created by ASUS on 23/03/2015.
 */
import stdp.Input ;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFileChooser fs = new JFileChooser("C:\\Users\\ASUS\\Desktop\\IA\\trunk\\Data") ;
        fs.showOpenDialog(null) ;
        String path = fs.getSelectedFile().getAbsolutePath() ;
        System.out.println(path);
        Input data = new Input(path) ;
        System.out.println(data);
    }
}
