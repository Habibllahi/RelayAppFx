/*
version 1.1
This application is owned and
Developed by Hamzat Habibllahi Adewale 2018
*/
package RelayApFx;
import com.fazecast.jSerialComm.*;
import static RelayApFx.SwitchGUI.ChangedFlag;
import static RelayApFx.SwitchGUI.SelectedPortIndex;
import static RelayApFx.SwitchGUI.selectedBaudRate;
import static RelayApFx.SwitchGUI.selectedBitPerWord;
import static RelayApFx.SwitchGUI.selectedParity;
import static RelayApFx.SwitchGUI.selectedStopBit;
import static RelayApFx.SwitchGUI.sendViaComPortText;
import static RelayApFx.serialComm.ports;
import static RelayApFx.serialComm.readBuffer;
import static RelayApFx.serialComm.readSucessful;
import com.fazecast.jSerialComm.SerialPort;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class RelayGUIcontroller implements Initializable{
String buffer1 = "A1";
String buffer2 = "B1";
String buffer3 = "C1";
String buffer4 = "D1";
String buffer5 = "A0";
String buffer6 = "B0";
String buffer7 = "C0";
String buffer8 = "D0";
String CarriageType="In Line";
int[] parityTypeValue = {0,1,2,3,4};
int[] StopBit = {0,1,2,3};
//Object varible creation for the FXML loader class to auto generate there respective objects via the sceneBuider
@FXML
private RadioButton relayStatusA,relayStatusB, relayStatusC,relayStatusD;
@FXML
private Button modifier,configureButton,sendButton,fxidDataAnalsyt,ClearButton;
@FXML
private Button relayOnA,relayOnB,relayOnC,relayOnD,relayOffA,relayOffB,relayOffC,relayOffD;
@FXML
private  TextField sendViaComPort;
@FXML
private TextArea receiveViaComPort;
@FXML
private Label fxidChannelALabel,fxidChannelBLabel,fxidChannelCLabel,fxidChannelDLabel;
@FXML
private Slider fxidChanelASlider,fxidChanelBSlider,fxidChanelCSlider,fxidChanelDSlider;
@FXML
private ProgressIndicator fxidChanelAProgressBar,fxidChanelBProgressBar,fxidChanelCProgressBar,fxidChanelDProgressBar;
@FXML
private ComboBox<String> portDiscription,Parity,Stopbit,CariageSlector;
@FXML
private ComboBox<Integer> serialBaudRate,BitPerWord;


/*******************Event Handling codes ***********************************/

@FXML
private void onRelayA(ActionEvent event){
    try{
              if(event.getSource()==relayOnA) {
             if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
             //to do more
        /*###################code to make the button write via selected serial port*######################################*/
int successful = serialComm.ports[SelectedPortIndex].writeBytes(buffer1.getBytes(), buffer1.getBytes().length);
            if(successful==buffer1.getBytes().length){
             relayStatusA.setSelected(true);
            relayStatusA.setText("ON");
             //closePortAfterUsage();
            }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            } 
           } 
}
catch(Exception e){
    JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
}}
@FXML
private void onRelayB(ActionEvent E){
    try{
              if(E.getSource()==relayOnB) {
             if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
             //to do more
        /*###################code to make the button write via selected serial port*######################################*/
int successful = serialComm.ports[SelectedPortIndex].writeBytes(buffer2.getBytes(), buffer2.getBytes().length);
            if(successful==buffer2.getBytes().length){
             relayStatusB.setSelected(true); 
             relayStatusB.setText("ON");
            }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            }
           } 
}
    catch(Exception e){
        JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
    }}
@FXML
private void onRelayC(ActionEvent C){
    try{
             if(C.getSource()==relayOnC) {
             if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
             //to do more
        /*###################code to make the button write via selected serial port*######################################*/
             int successful = serialComm.ports[SelectedPortIndex].writeBytes(buffer3.getBytes(), buffer3.getBytes().length);
            if(successful==buffer3.getBytes().length){
             relayStatusC.setSelected(true);
             relayStatusC.setText("ON");
             //closePortAfterUsage();
            }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            }
           }  
}
    catch(Exception e){
       JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
    }}
@FXML
private void onRelayD(ActionEvent D){
   try{
              if(D.getSource()==relayOnD) {
             if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
             //to do more
        /*###################code to make the button write via selected serial port*######################################*/
             int successful = serialComm.ports[SelectedPortIndex].writeBytes(buffer4.getBytes(), buffer4.getBytes().length);
            if(successful==buffer4.getBytes().length){
             relayStatusD.setSelected(true);
             relayStatusD.setText("ON");
             //closePortAfterUsage();
            }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            }
           }
   } catch(Exception e){
       JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
   }}       
@FXML
private void offRelayA(ActionEvent event){
    try{
             if(event.getSource()==relayOffA) {
             if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
        /*###################code to make the button write via selected serial port*######################################*/
             int successful = serialComm.ports[SelectedPortIndex].writeBytes(buffer5.getBytes(), buffer5.getBytes().length);
            if(successful==buffer5.getBytes().length){
             relayStatusA.setSelected(false);
             relayStatusA.setText("OFF");
             //closePortAfterUsage();
            }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            }
           }  
}catch(Exception e){
    JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
}}
@FXML
private void offRelayB(ActionEvent event){
    try{
               if(event.getSource()==relayOffB){
             if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
             //to do more
        /*###################code to make the button write via selected serial port*######################################*/
             int successful = serialComm.ports[SelectedPortIndex].writeBytes(buffer6.getBytes(), buffer6.getBytes().length);
            if(successful==buffer6.getBytes().length){
             relayStatusB.setSelected(false);
             relayStatusB.setText("OFF");
             //closePortAfterUsage();
            }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            }
           }
}catch(Exception e){
   JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
}}
@FXML
private void offRelayC(ActionEvent event){
    try{
             if(event.getSource()==relayOffC) {
             if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
             //to do more
        /*###################code to make the button write via selected serial port*######################################*/
             int successful = serialComm.ports[SelectedPortIndex].writeBytes(buffer7.getBytes(), buffer7.getBytes().length);
            if(successful==buffer7.getBytes().length){
             relayStatusC.setSelected(false); 
             relayStatusC.setText("OFF");
             //closePortAfterUsage();
            }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            }
           }  
}catch(Exception e){
    JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
}}
@FXML
private void offRelayD(ActionEvent event){
    try{
              if(event.getSource()==relayOffD) {
             if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
        /*###################code to make the button write via selected serial port*######################################*/
            int successful = serialComm.ports[SelectedPortIndex].writeBytes(buffer8.getBytes(),buffer8.getBytes().length);
            if(successful==buffer8.getBytes().length){
             relayStatusD.setSelected(false);
             relayStatusD.setText("OFF");
            }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            }
           } 
}catch(Exception e){
    JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
}}
@FXML
private void sendButtonAction(ActionEvent e){
    try{
         if(e.getSource()==sendButton){
         if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
           sendViaComPortText = sendViaComPort.getText();
           sendViaComPort.setText("");//clear text after sent
           System.out.println(sendViaComPortText);
           /*###########write out via comport########################*/
   int sucessful = serialComm.ports[SelectedPortIndex].writeBytes(sendViaComPortText.getBytes(),sendViaComPortText.getBytes().length);
      if(sucessful==sendViaComPortText.getBytes().length){
          System.out.println("all byte sent sucessfully"); 
      }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            }   
        } 
}catch(Exception ee){
    JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
}}
@FXML
private void DataButtonAction(ActionEvent event){
    
}

//textField action event
@FXML
private void TextFieldAction(ActionEvent e){
    try{
           if(e.getSource()==sendViaComPort){
         if(ChangedFlag==true){
             setComportParameter();
             ChangedFlag=false;
             }
           sendViaComPortText = sendViaComPort.getText();
           sendViaComPort.setText("");//clear text after sent
          System.out.println(sendViaComPortText);
           /*###########write out via comport########################*/
   int sucessful = serialComm.ports[SelectedPortIndex].writeBytes(sendViaComPortText.getBytes(),sendViaComPortText.getBytes().length);
      if(sucessful==sendViaComPortText.getBytes().length){
         System.out.println("all byte sent sucessfully");
      }else{
                JOptionPane.showMessageDialog(null, "Unable to write out via the port","Connection error", JOptionPane.ERROR_MESSAGE);
            }
        } 
}catch(Exception ee){
   JOptionPane.showMessageDialog(null, "No comport available","Exception error", JOptionPane.ERROR_MESSAGE);
}}
//COMBO BOX EVENT HANDLER CODE
@FXML
private void portComboActionEvent(ActionEvent g){
    try{
              if(g.getSource()== portDiscription){
            SwitchGUI.PORTDESCRIPTION = portDiscription.getValue();
            SelectedPortIndex = portDiscription.getSelectionModel().getSelectedIndex();
            openComPortIfClosed();
            setComportParameter();
            serialComm.ports[SelectedPortIndex].setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,100,100);//set comport timeout  
//creating event drivving mode for the port selected using the anounymouse inner class technique     
     ports[SelectedPortIndex].addDataListener(
        new SerialPortDataListener(){
                   @Override
        public int getListeningEvents() {
            
            return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
        }

        @Override
        public void serialEvent(SerialPortEvent event) {
            if(event.getEventType()==SerialPort.LISTENING_EVENT_DATA_AVAILABLE){
           ChangedFlag=true;//make true so that the app can resume to the previous mode          
          readBuffer = new byte[serialComm.ports[SelectedPortIndex].bytesAvailable()];
              readSucessful = serialComm.ports[SelectedPortIndex].readBytes(readBuffer,readBuffer.length);
          if(readSucessful==readBuffer.length){
                 String s = new String(readBuffer);
                 try{
                     if(CarriageType.equals("In Line")){
                      receiveViaComPort.setText(String.format("%s%s",receiveViaComPort.getText(),s)); 
                     }
                     if(CarriageType.equals("New Line")){
                    receiveViaComPort.setText(String.format("%s%s\n",receiveViaComPort.getText(),s));
                 }
                    if(CarriageType.equals("Return")){
                    receiveViaComPort.setText(s);
                 }   
                 }
                catch(Exception error){
                     JOptionPane.showMessageDialog(null,error.getMessage()+"\nUnable to write data arriving at the port to screen","Write error", JOptionPane.ERROR_MESSAGE); 
                 }
                 finally{
                 System.out.println("I RECEIVED THIS:");
                 System.out.println(s);
                 } 
          }
        }    
        }        
              }
     );
}
}catch(Exception error){
      JOptionPane.showMessageDialog(null, error.getMessage(),"Exception error", JOptionPane.ERROR_MESSAGE);   
        }
}
@FXML
private void PortComboHooverEvent(MouseEvent event){
        try{
        if(SwitchGUI.dontPorpulate == false){
         serialComm comm = new serialComm();
        //itrate through the portsName array to fetch the strings to a variable called description
        for(String description:serialComm.portsName){
            int x = 0;
            if(x<serialComm.portsName.length){
                portDiscription.getItems().add(description);
                x++;
            }
        }
        SwitchGUI.dontPorpulate = true;
        }
    }catch(Exception g){
       JOptionPane.showMessageDialog(null, g.getMessage(),"Exception error", JOptionPane.ERROR_MESSAGE); 
    }
   
}
@FXML
private void BaudRateActionEvent(ActionEvent k){
    try{
       if(k.getSource()== serialBaudRate){
        selectedBaudRate = serialBaudRate.getValue();
        ChangedFlag=true;
        System.out.println(selectedBaudRate); 
            }
    }catch(Exception g){
       JOptionPane.showMessageDialog(null, g.getMessage(),"Exception error", JOptionPane.ERROR_MESSAGE); 
    }
}
@FXML
private void ParityActionEvent(ActionEvent k){
      try{
                    if(k.getSource()== Parity){
              selectedParity = parityTypeValue[Parity.getSelectionModel().getSelectedIndex()];
              ChangedFlag=true;
              System.out.println(selectedParity); 
            }
    }catch(Exception g){
      JOptionPane.showMessageDialog(null, g.getMessage(),"Exception error", JOptionPane.ERROR_MESSAGE);  
    }  
}
@FXML
private void BitActionEvent(ActionEvent f){
         try{
                        if(f.getSource()==BitPerWord){
              selectedBitPerWord = BitPerWord.getValue();
              System.out.println(selectedBitPerWord);
              ChangedFlag=true;
            }
        
    }catch(Exception g){
      JOptionPane.showMessageDialog(null, g.getMessage(),"Exception error", JOptionPane.ERROR_MESSAGE);  
    } 
}
@FXML
private void stopBitActionEvent(ActionEvent f){
         try{
             if(f.getSource()==Stopbit){
              selectedStopBit = StopBit[Stopbit.getSelectionModel().getSelectedIndex()];
              System.out.println(selectedStopBit);
              ChangedFlag=true;
    }
         }catch(Exception g){
     JOptionPane.showMessageDialog(null, g.getMessage(),"Exception error", JOptionPane.ERROR_MESSAGE);   
    } 
}
@FXML
private void ClearButtonEvent(ActionEvent b){
    try{
        if(b.getSource()==ClearButton){
          receiveViaComPort.setText("");  
        }
    }catch(Exception e){
       JOptionPane.showMessageDialog(null, e.getMessage(),"Exception error", JOptionPane.ERROR_MESSAGE); 
    }
}
@FXML
private void CariageSelectionModel(ActionEvent e){
 CarriageType = CariageSlector.getValue();
}
/******EVENT HANDLER METHODS FOR LABELS SEETINGS ********/
@FXML
private void ModifierEvent(ActionEvent p){
        try {
        Parent modifierRoot = FXMLLoader.load(getClass().getResource("ModifierWindow.fxml"));
        Scene ModifierScene = new Scene(modifierRoot);
        Stage stage = new Stage();
        stage.setScene(ModifierScene);
        stage.setTitle("Modifier");
        stage.show();
    }
     catch(Exception e){
       JOptionPane.showMessageDialog(null, e.getMessage(),"Exception error", JOptionPane.ERROR_MESSAGE);
     } 
}
@FXML
private void setNewLabels(MouseEvent e){
       if(SwitchGUI.labelChanegedFlag==true){
           relayOnA.setText(SwitchGUI.RelayAonLabel);
           relayOnB.setText(SwitchGUI.RelayBonLabel);
           relayOnC.setText(SwitchGUI.RelayConLabel);
           relayOnD.setText(SwitchGUI.RelayDonLabel);
           relayOffA.setText(SwitchGUI.RelayAoffLabel);
           relayOffB.setText(SwitchGUI.RelayBoffLabel);
           relayOffC.setText(SwitchGUI.RelayCoffLabel);
           relayOffD.setText(SwitchGUI.RelayDoffLabel);
           fxidChannelALabel.setText(SwitchGUI.ChanelaLabel);
           fxidChannelBLabel.setText(SwitchGUI.ChanelbLabel);
           fxidChannelCLabel.setText(SwitchGUI.ChanelcLabel);
           fxidChannelDLabel.setText(SwitchGUI.ChaneldLabel);
           SwitchGUI.labelChanegedFlag=false;
       }
   }
/***************************method
 * @return ***********************************************/
   public int getBitPerWord(){
       return selectedBitPerWord;
   }
   public int getBaurdRate(){
     return selectedBaudRate;
   }
   public int getParity(){
       return selectedParity;
   }
   public int getStopBit(){
       return selectedStopBit;
   }
   public void setComportParameter(){
      serialComm.ports[SelectedPortIndex].setComPortParameters(getBaurdRate(),getBitPerWord(),getStopBit(),getParity()); 
      setFlowControlForButtonSignals();
   }
   public void setFlowControlForButtonSignals(){
     serialComm.ports[SelectedPortIndex].setFlowControl(SerialPort.FLOW_CONTROL_XONXOFF_IN_ENABLED);
     serialComm.ports[SelectedPortIndex].setFlowControl(SerialPort.FLOW_CONTROL_XONXOFF_OUT_ENABLED);
   }
   public void  openComPortIfClosed(){
    if(serialComm.ports[SelectedPortIndex].isOpen()==false){
       SwitchGUI.portOpenStatus = serialComm.ports[SelectedPortIndex].openPort();
   }
   }
   public void closePortAfterUsage(){
       SwitchGUI.portClosedStatus=serialComm.ports[SelectedPortIndex].closePort();
   }
   public SerialPort getSelectedPort(){
      return serialComm.ports[SelectedPortIndex]; 
   }

/*************************Initializer*******************************************/
@Override
public void initialize(URL location, ResourceBundle resources){

ObservableList<Integer> BaudRates = FXCollections.observableArrayList(300,1200,2400,4800,9600,19200,38400,57600,74880,115200,230400,250000,500000,1000000,2000000);
serialBaudRate.setItems(BaudRates);
ObservableList<Integer> Bits = FXCollections.observableArrayList(8,16,32);
BitPerWord.setItems(Bits);
ObservableList<String> type = FXCollections.observableArrayList("NO","ODD","EVEN","MARK","SPACE");
Parity.setItems(type);
ObservableList<String> stopBit = FXCollections.observableArrayList("0","1","1.5","2");
Stopbit.setItems(stopBit);
CariageSlector.getItems().addAll("In Line","New Line","Return");
    }

}//end of class
