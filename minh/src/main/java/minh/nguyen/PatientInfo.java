package minh.nguyen;

import android.net.wifi.rtt.WifiRttManager;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.Date;

public class PatientInfo implements Serializable {

    private String FirstName;
    private String LastName;
    private String Department;
    private String Gender;
    private Date time;
    private String BloodPressure;
    private String RespiratoryRate;
    private String BloodOxygenLevel;
    private String ID;



    public PatientInfo()
    {
        ID = "";
        FirstName = "";
        LastName = "";
        Department = "";
        Gender = "";
        time = new Date();
        BloodPressure = "";
        RespiratoryRate = "";
        BloodOxygenLevel = "";

    }

    public String getID(){ return String.valueOf(ID); }

    public void setID(String id){
        this.ID = id;
    }


    public String getFirstName(){
        return FirstName;
    }

    public void setFirstName(String firstName){
        this.FirstName = firstName;
    }

    public String getLastName(){
        return LastName;
    }

    public void setLastName(String lastName){
        this.LastName = lastName;
    }

    public String getDepartment(){
        return Department;
    }

    public void setDepartment(String department){
        this.Department = department;
    }

    public String getGender(){
        return Gender;
    }

    public void setGender(String gender){
        this.Gender = gender;
    }

    public String getBloodPressure(){
        return BloodPressure;
    }

    public void setBloodPressure(String blood){
        this.BloodPressure = blood;
    }

    public String getRespiratoryRate(){
        return RespiratoryRate;
    }

    public void setRespiratoryRate(String respiratoryRate){ this.RespiratoryRate = respiratoryRate; }

    public String getBloodOxygenLevel(){
        return BloodOxygenLevel;
    }

    public void setBloodOxygenLevel(String bloodOxygenLevel){ this.BloodOxygenLevel = bloodOxygenLevel; }

    public String toString(){
        String format;

        format ="#"+ID+" "+FirstName + " " + LastName;
        return format;
    }
}