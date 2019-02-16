/*
version 1.1
This application is owned by HICmikroLAB
Developed by Hamzat Habibllahi Adewale 2018
*/
package RelayApFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class RelayAP extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
     try {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Relay Version 1.1");
        stage.show();
       // serialComm comm = new serialComm(); 
    }
     catch(Exception e){
       JOptionPane.showMessageDialog(null, e.getMessage(),"Exception error", JOptionPane.ERROR_MESSAGE);
     }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
