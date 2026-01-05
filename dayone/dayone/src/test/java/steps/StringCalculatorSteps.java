package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;
import dtu.StringCalculator;

public class StringCalculatorSteps {

    private StringCalculator calculator;
    private int result;
    private Exception caughtException;

    @Given("I have a string calculator")
    public void i_have_a_string_calculator() {
        calculator = new StringCalculator();
    }

    @When("I add an empty string")
    public void i_add_an_empty_string() {
        result = calculator.add("");
    }

    @When("I add {string}")
    public void i_add_a_number(String number) {
        String processedInput = number.replace("\\n", "\n");
        try {
            result = calculator.add(processedInput);
        } catch (Exception e) {
            caughtException = e;
        }
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, result);
    }

    @Then("an exception should be thrown")
    public void an_exception_should_be_thrown() {
        assertNotNull(caughtException, "Expected an exception to be thrown");
    }
}
