package main.pages;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import main.java.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DashboardPage {

    @FindBy(id="amount")
    WebElement thAmount;

    @FindBy(xpath="//span[contains(text(),'USD')]")
    List<WebElement> listAmounts;

    @FindBy(id="showExpensesChart")
    WebElement lnkCompareExpenses;

    @FindBy(id="addDataset")
    WebElement lnkShowDataForNextYear;

    @FindBy(id="canvas")
    WebElement imgCanvasChart;

    @FindBy(css="img[src*='flashSale.gif']")
    WebElement imgFlashSale1;

    @FindBy(css="img[src*='flashSale2.gif']")
    WebElement imgFlashSale2;

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    public void clickAmountRow(){
       thAmount.click();
    }

    public double[] getAmountValues(){
        double[] nums = new double[listAmounts.size()];
        int i=0;
        for(WebElement amount : listAmounts){
            double val = Double.parseDouble(amount.getText().replace("USD","").replace("+ ","").replace("- ","-").replace(",","").trim());
            nums[i] = val;
            i++;
        }
        return nums;
    }

    public void clickCompareExpenses(){
        lnkCompareExpenses.click();
    }

    public boolean flashSaleImage1Exist(){
        return imgFlashSale1.isDisplayed();
    }

    public boolean flashSaleImage2Exist(){
        return imgFlashSale2.isDisplayed();
    }

    public void clickShowDataNextYear(){
        lnkShowDataForNextYear.click();
    }

    public boolean compareChart(String fileName){
        Path path = Paths.get(fileName);
        OcularResult result = Ocular.snapshot()
                .from(path)
                .sample()
                .using(driver)
                .compare();
        return result.isEqualsImages();
    }
}
