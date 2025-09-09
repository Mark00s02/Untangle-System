
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class AppointmentMethods {
    private static final int DEFAULT_SIZE = 32;
    public AppointmentMethods[] appointments;
    private int size;
    String patientName;
    String patientAge;
    int cost;
    int date;
    String session;
    
    
    public AppointmentMethods(String patientName, String patientage, int cost, String session) {
        this.patientName = patientName;
        this.patientAge = patientage;
        this.cost = cost;
        this.session = session;
        
    }
    
    
    public AppointmentMethods() {
        appointments = new AppointmentMethods[DEFAULT_SIZE];
        size = 0;
    }
    
    public void makeAppointment(String patientname, String patientage, int cost, int date, String session) {
        int index = hash(date);
        int i = 1;
        int newDate = 0;
        
        appointments[0] = new AppointmentMethods("No data","No data",0,"No data");
        
            while (appointments[index] != null){
                
                index = (date + i) % DEFAULT_SIZE;
                i++;
                newDate = index;
        }
            if(newDate != 0){
            JOptionPane.showMessageDialog(null, "Could not make appointment: an appointment with the same date already exists." 
                    + "\n" + "Your schedule is now on: " + (newDate));
            }
            appointments[index]  = new AppointmentMethods(patientname, patientage, cost, session);
            
         
        } 
    
    
    private int hash(int data) {

        return data % DEFAULT_SIZE;
        
    }
    
    
    
    public void Print(){
        
        try(PrintWriter output = new PrintWriter("PatientRecords.txt")) {
             for (int i = 1; i < DEFAULT_SIZE; i++){
            
            if (appointments[i] != null) {
            output.print(i + ": " + appointments[i]+"\n");
        }else {
                output.print(i + ": null"+"\n");
            }
      }
    }catch (FileNotFoundException ex) {
            Logger.getLogger(AppointmentUI.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
        
    public void removeItem() {
        int search = Integer.parseInt(JOptionPane.showInputDialog("Please enter the date of your appointment you\n" + 
                "want to cancel: "));
        int index = search;
        if (index != -1) {
            appointments[index] = null;
        }
        

    }
    
        
    @Override
    public String toString() {
        return "Patient name: " + patientName + ", Patient age: "
                + patientAge + ", Cost: " + cost +  ", Session: " + session;
        
    }
}
