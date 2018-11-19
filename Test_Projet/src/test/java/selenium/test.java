package selenium;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.probedock.client.annotations.ProbeTest;
import selenium.pages.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class test {

    private WebDriver driver;

    private final static String BASEURL = "localhost:8080/Projet_AMT";

    private final static int MINAPPLICATION = 25;
    private final static int MAXAPPLICATION = 45;

    private final static int MINDESCRIPTION = 5;
    private final static int MAXDESCRIPTION = 10;

    private final static int NUMBEROFBOBAPPLICATION = 98;
    private final static int NUMBEROFDEV = 130;

    private final static int PAGINATIONSIZE = 10;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @ProbeTest(tags = "WebUI")
    public void deconection() {
        driver.get(BASEURL + "/deconnexion");
        Home homePage = new Home(driver);
    }

    /* Test orienté vers un utilisateur admin
     */
    @Test
    @ProbeTest(tags = "WebUI")
    public void loginAsAdmin() {
        driver.get(BASEURL + "/login");
        Login loginPage = new Login(driver);
        loginPage.typeEmailAddress("andre.jacquemond@heig-vd.ch");
        loginPage.typePassword("password");
        Admin adminPage = (Admin)loginPage.submitForm(Admin.class);
    }

    @Test
    @ProbeTest(tags = "WebUI")
    public void checkPaginationAsAdmin() {
        loginAsAdmin();
        driver.get(BASEURL + "/admin");
        Admin adminPage = new Admin(driver);
        int numberOfPage = (int)Math.ceil(NUMBEROFDEV / (double)PAGINATIONSIZE);
        if(!adminPage.numberOfPages().equalsIgnoreCase(Integer.toString(numberOfPage))){
            throw new IllegalStateException("no pagination " + adminPage.numberOfPages());
        }
        deconection();
    }

    /* Test orienté vers un utilisateur développeur
     */
    @Test
    @ProbeTest(tags = "WebUI")
    public void loginAsDev() {
        driver.get(BASEURL + "/login");
        Login loginPage = new Login(driver);
        loginPage.typeEmailAddress("bob.eponge@heig-vd.ch");
        loginPage.typePassword("pass");
        Dev devPage = (Dev)loginPage.submitForm(Dev.class);
    }

    @Test
    @ProbeTest(tags = "WebUI")
    public void checkPaginationAsDevBob() {
        loginAsDev();
        driver.get(BASEURL + "/admin");
        Dev devPage = new Dev(driver);
        int numberOfPage = (int)Math.ceil(NUMBEROFBOBAPPLICATION / (double)PAGINATIONSIZE);
        if(!devPage.numberOfPages().equalsIgnoreCase(Integer.toString(numberOfPage))){
            throw new IllegalStateException("no pagination " + devPage.numberOfPages());
        }
        deconection();
    }

    /* Test de redirection
     */

    @Test
    @ProbeTest(tags = "WebUI")
    public void tryReachForbiddenPageAsAdmin() {
        loginAsAdmin();
        driver.get(BASEURL + "/dev");
        Admin adminPage = new Admin(driver);
        deconection();
    }

    @Test
    @ProbeTest(tags = "WebUI")
    public void tryReachForbiddenPageAsDev() {
        loginAsDev();
        driver.get(BASEURL + "/admin");
        Dev devPage = new Dev(driver);
        deconection();
    }

    @Test
    @ProbeTest(tags = "WebUI")
    public void loginAsUnknowUserShouldRedirectToRegister() {
        driver.get(BASEURL + "/login");
        Login loginPage = new Login(driver);
        loginPage.typeEmailAddress("abc.def@inconnu.ch");
        loginPage.typePassword("pass");
        Register registerPage = (Register)loginPage.submitForm(Register.class);
    }


    /* Test orienté vers la création d'un nouveau user, et de plusieurs appli
     */
    @Test
    @ProbeTest(tags = "WebUI")
    public void register() {
        driver.get(BASEURL + "/register");
        Register registerPage = new Register(driver);
        Faker faker = new Faker();
        String first = faker.harryPotter().character();
        registerPage.typeFirstName(first);
        String last = faker.hobbit().character();
        registerPage.typeLastName(last);
        registerPage.typeEmailAddress(first.replace(" ", "") +
                                                    last.replace(" ", "") + "@heig-vd.ch");
        registerPage.typePassword("pass");
        registerPage.typePasswordConfirmation("pass");
        Dev devPage = (Dev)registerPage.submitForm(Dev.class);
    }

    @Test
    @ProbeTest(tags = "WebUI")
    public void createAppCheckPaginationLogoutAndTryURL() {
        // Permet de s'enregistrer
        register();
        driver.get(BASEURL + "/dev");
        Dev devPage = new Dev(driver);
        Random random = new Random();
        int appNumber = random.nextInt(MAXAPPLICATION + 1 - MINAPPLICATION) + MAXAPPLICATION;
        for(int i = 0; i < appNumber; ++i){
            NewApp newAppPage = (NewApp) devPage.createApplication( NewApp.class);
            int descrSize = random.nextInt( MAXDESCRIPTION  + 1 - MINDESCRIPTION ) + MAXDESCRIPTION;
            newAppPage.typeAppName();
            newAppPage.typeAppDescription(descrSize);
            newAppPage.submitForm(Dev.class);
        }
        // Permet de checker que le nombre de page match avec le nombre d'application en fonction de la pagination
        /*int numberOfPage = 1;
        if(appNumber % 10 != 0) {
            numberOfPage = (int) Math.ceil(appNumber / (double) PAGINATIONSIZE);
        }
        else{
            numberOfPage = appNumber / PAGINATIONSIZE;
        }
        if(!devPage.numberOfPages().equalsIgnoreCase(Integer.toString(numberOfPage))){
            throw new IllegalStateException("no pagination concordance " + devPage.numberOfPages());
        }*/
        int numberOfPage = (int) Math.ceil(appNumber / (double) PAGINATIONSIZE);
        // Permet de cliquer X nombre de fois en fonction du nombre de next
        for(int i = 1; i < numberOfPage; ++i){
            devPage.NextNavigation(Dev.class);
        }

        // Permet de cliquer X nombre de fois en fonction du nombre de previous
        for(int i = 1; i < numberOfPage; ++i){
            devPage.PreviousNavigation(Dev.class);
        }

        // Permet de se déconnecter
        deconection();

        // Test d'URL connus
        driver.get(BASEURL + "/dev");
        Home homepage = new Home(driver);

        driver.get(BASEURL + "/dev/newApp");
        homepage = new Home(driver);

        driver.get(BASEURL + "/admin");
        homepage = new Home(driver);

    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}
