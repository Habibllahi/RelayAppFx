/*
version 1.1
This application is owned and
Developed by Hamzat Habibllahi Adewale 2018
*/
package RelayApFx;
import com.fazecast.jSerialComm.*;
public class serialComm extends SwitchGUI{
  //static variables set for obtaing available real or virtual  comports on the system 
  static int numOfComAvailable = SerialPort.getCommPorts().length; 
  static SerialPort[] ports = new SerialPort[numOfComAvailable]; 
  static String[] portsName = new String[numOfComAvailable];
  int x = 0;
  static byte[]readBuffer;
  static int readSucessful;
  static boolean readSucessfulFlag=false;
  public serialComm(){
   //creating object instance of SerialPort class and simultaniously fettchhing the available comPorts as the created objects
   for(SerialPort COM: SerialPort.getCommPorts()){
       
       if(x < numOfComAvailable){
           ports[x] = COM;
           portsName[x] = ports[x].getDescriptivePortName();
           System.out.println(ports[x]);
           System.out.println(portsName[x]);
           x++;}}//end of comPort fettching           
}
  /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Event handling<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
//The event handling formerly done here in version1.0 as been transfered to javaFx controller thread using anounumouse inner class technique
}

