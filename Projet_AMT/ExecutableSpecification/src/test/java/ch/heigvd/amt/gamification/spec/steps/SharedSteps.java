package ch.heigvd.amt.gamification.spec.steps;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;



public class SharedSteps {

    private SharedData data;

    public SharedSteps(SharedData data){
        this.data = data;
    }

    @Then("^I receive a (\\d+) status code$")
    public void i_receive_a_status_code(int arg1) throws Throwable {
        assertEquals(arg1, data.getStatusCode());
    }
}
