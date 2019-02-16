/*
version 1.1
This application is owned and
Developed by Hamzat Habibllahi Adewale 2018
*/
package RelayApFx;

public class SwitchGUI {
    public  static int selectedBaudRate=9600,selectedBitPerWord=8,SelectedPortIndex,selectedParity=0,selectedStopBit=0; 
    public static boolean ChangedFlag=false;
    public static boolean portOpenStatus;
    public static boolean portClosedStatus; 
    public static String PORTDESCRIPTION,sendViaComPortText;
    public static boolean dontPorpulate = false, couldNotFindDesiredPort = false;
    public static String RelayAonLabel,RelayBonLabel,RelayConLabel,RelayDonLabel,RelayAoffLabel,RelayBoffLabel,RelayCoffLabel,RelayDoffLabel,ChanelaLabel,ChanelbLabel,ChanelcLabel,ChaneldLabel;
    public static boolean labelChanegedFlag = false;
}
