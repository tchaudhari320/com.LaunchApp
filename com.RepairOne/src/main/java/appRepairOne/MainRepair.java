package appRepairOne;

import appRepairOne.Entities.Records;
import appRepairOne.Logic.Handler;
import appRepairOne.SaveData.FileIO;

import java.io.IOException;

public class MainRepair {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");
        Records job1 = new Records("Search");
        Records job2 = new Records("Skills");
        Records job3 = new Records("Salary");
        Handler handler = new Handler();
        handler.addRecord(job1);
        handler.addRecord(job2);
        handler.addRecord(job3);

        System.out.println(handler.findRecord(1).getId()+" "+handler.findRecord(1).getTitle());
        FileIO fileIO = new FileIO("testRec.txt","C:/Java/");
        fileIO.WriteFile("HHSHSHSH");
        fileIO.ReadFile();

    }
}
