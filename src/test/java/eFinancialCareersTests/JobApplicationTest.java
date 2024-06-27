package eFinancialCareersTests;

import eFinancialCareersPages.JobPage;
import eFinancialCareersPages.JobSearchPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JobApplicationTest extends BaseTest{
    private final By hiddenElement = By.xpath("//*[@id=\"fsp-fileUpload\"]");

    @Test
    public void testJobSearch(){
        homepage.clickSignIn();
        assertEquals(homepage.getOverlayText(), "Welcome to your next opportunity", "Didn't clicked login button correctly");

        homepage.enterEmail("aliomessi.19@gmail.com");
        homepage.enterPassword("Aliraza.10");

        homepage.clickProfileButton();
        assertEquals(homepage.checkLoginStatus(), "Ali Raza", "Login failed");

        JobSearchPage jobSearchPage = homepage.jobSearch();
        assertTrue(jobSearchPage.getJobSearchResultText().contains("QA Engineer jobs"), "Job search failed");

        JobPage jobPage = jobSearchPage.clickJobLink();
        assertEquals(jobPage.checkJobPageStatus(), "Apply now", "Click job link failed");

        jobPage.applyForJob();
        assertEquals(jobPage.checkJobApplicationModal(), "Your application", "Job application modal not found");

//        jobPage.loadNewCV();
//
//        assertEquals(jobPage.fileDropAreaText(), "Select Files to Upload", "File drop area not found");
//
//        jobPage.unhiddenUploadElement(hiddenElement);
//
//        jobPage.uploadCV();
//        assertEquals(jobPage.getCvTitle(), "Ali-s Resume.pdf", "CV upload failed");

        jobPage.apply();
    }
}