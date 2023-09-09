package eFinancialCareersTests;

import eFinancialCareersPages.JobPage;
import eFinancialCareersPages.JobSearchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JobSearchTest extends BaseTest{
    @Test
    public void testJobSearch(){
        homepage.clickSignIn();
        System.out.println(homepage.getOverlayText());
        assertEquals(homepage.getOverlayText(), "Welcome to your next opportunity", "Didn't clicked signIn button correctly");
        homepage.enterEmail("aliomessi.19@gmail.com");
        homepage.enterPassword("Aliraza.10");

        JobSearchPage jobSearchPage = homepage.jobSearch();
        System.out.println(jobSearchPage.getJobSearchResultText());
        assertTrue(jobSearchPage.getJobSearchResultText().contains("QA Engineer jobs"), "Job search failed");

        JobPage jobPage = jobSearchPage.clickJobLink();
        jobPage.applyForJob();
        jobPage.uploadCV();
    }
}