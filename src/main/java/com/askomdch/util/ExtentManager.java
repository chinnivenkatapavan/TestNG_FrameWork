package com.askomdch.util;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
        // prevent object creation
    }

    public static synchronized ExtentReports getReport() {
        if (extent == null) {

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String reportPath = System.getProperty("user.dir")
                    + "/Reports/"+timestamp+".html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportPath);



            reporter.config().setReportName("Automation Execution Report");
            reporter.config().setDocumentTitle("Extent Reports");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Framework", "Selenium TestNG");
            extent.setSystemInfo("Author", "VenkatPavan");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
        return extent;

    }
}
