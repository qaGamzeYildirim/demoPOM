package page;

import base.BasePage;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static constants.ConstantsCareersPage.*;
import static constants.ConstantsQualityAssurancePage.*;

public class QualityAssurancePage extends BasePage {
    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }
    public void qualityAssurancePageActions() throws IOException, InterruptedException {
        try {
            this.clickSeeAllTeamsButton();
            this.clickQualityAssurance();
            this.clickSeeAllQAJobs();
            this.filterByLocations();
            this.controlDepartments();
            this.jobListControl();
            this.jobClick();
        } catch (Exception e ) {
            screenShot();
            throw e;
        }
    }

    public QualityAssurancePage clickSeeAllTeamsButton() {
        scrollUp(seeAllTeamsButton);
        jsClick(seeAllTeamsButton);
        return this;
    }

    public QualityAssurancePage clickQualityAssurance() {
        jsClick(qualityAssurance);
        return this;
    }

    public QualityAssurancePage clickSeeAllQAJobs() {
        jsClick(seeAllQAJobs);
        return this;
    }

    public QualityAssurancePage filterByLocations() throws InterruptedException {
        scroll(filterByLocations);
        Thread.sleep(3000);
        jsClick(filterByLocations);
        click(istanbulLocation);
        return this;
    }

    public QualityAssurancePage controlDepartments() throws InterruptedException {
        Thread.sleep(3000);
        assert1(filterByDepartment, "Quality Assurance");
        return this;
    }

    public QualityAssurancePage jobListControl() {
        verify(jobList);
        webElementListContainsString(jobListPositionTitleList, "Quality Assurance");
        webElementListEqualString(jobListPositionDepartmentList, "Quality Assurance");
        webElementListEqualString(jobListPositionLocationList, "Istanbul, Turkey");
        webElementListHoverElement(applyNowList);

        return this;
    }

    public QualityAssurancePage jobClick() throws InterruptedException {
        webElementListClick(applyNowList);
        Thread.sleep(3000);
        focusLastTab();
        jsClick(applyForThisJob);
        verify(applicationForm);

        return this;
    }
}
