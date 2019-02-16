
package RelayApFx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class ModifierController implements Initializable {

@FXML
private Button LabelsSetter;
@FXML
private TextField RelayA1Label,RelayB1Label,RelayC1Label,RelayD1Label,RelayA0Label,RelayB0Label,RelayC0Label,RelayD0Label,ChannelALabel,ChannelBLabel,ChannelCLabel,ChannelDLabel;
@FXML
private void LabelSetterEvent(ActionEvent e){
SwitchGUI.RelayAonLabel = RelayA1Label.getText();
SwitchGUI.RelayBonLabel = RelayB1Label.getText();
SwitchGUI.RelayConLabel = RelayC1Label.getText();
SwitchGUI.RelayDonLabel = RelayD1Label.getText();
SwitchGUI.RelayAoffLabel = RelayA0Label.getText();
SwitchGUI.RelayBoffLabel = RelayB0Label.getText();
SwitchGUI.RelayCoffLabel = RelayC0Label.getText();
SwitchGUI.RelayDoffLabel = RelayD0Label.getText();
SwitchGUI.ChanelaLabel = ChannelALabel.getText();
SwitchGUI.ChanelbLabel = ChannelBLabel.getText();
SwitchGUI.ChanelcLabel = ChannelCLabel.getText();
SwitchGUI.ChaneldLabel = ChannelDLabel.getText();
SwitchGUI.labelChanegedFlag = true;
}
@Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }
    
}
