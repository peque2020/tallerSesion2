package localReport;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Report {

    public static void main(String[]args) throws InterruptedException {

        Thread.sleep(20000);
        String ruta=new File(".").getAbsolutePath().replace(".","")+"build\\reports\\cucumber\\";
        File folderReport= new File(ruta+"JBReport");

        List<String> jsonsLists = new ArrayList<>();
        jsonsLists.add(ruta+"report.json");

        Configuration configuration = new Configuration(folderReport,"JB Mobile Cucumber");
        configuration.setBuildNumber("v0.0001");
        configuration.addClassifications("Owner","JB");
        configuration.addClassifications("OS","Windows");
        configuration.addClassifications("Device","Android");
        configuration.addClassifications("tipo","local");
        configuration.addClassifications("Branch","Master");
        configuration.addClassifications("Suite","Regression");

        ReportBuilder reportBuilder = new ReportBuilder(jsonsLists,configuration);
        reportBuilder.generateReports();

    }


}
