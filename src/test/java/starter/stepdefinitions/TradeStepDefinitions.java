package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.templates.FieldValues;
import starter.templates.MergeFrom;
import starter.trades.TradeResponse;
import starter.trades.RecordNewTrade;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;

public class TradeStepDefinitions {

    @Steps
    RecordNewTrade recordNewTrade;

    @Steps
    TradeResponse theTradeDetails;

    String trade;

    @Given("the following trade:")
    public void the_folowing_trade(List<Map<String, String>> tradeDetails) throws IOException {

        trade = MergeFrom.template("templates/trade.json")
                         .withDefaultValuesFrom(FieldValues.in("templates/standard-trade.properties"))
                         .withFieldsFrom(tradeDetails.get(0));
    }

    @When("I record the trade")
    public void i_record_the_trade() {
        recordNewTrade.withDetails(trade);
    }

    @Then("the recorded trade should include the following details:")
    public void the_recorded_trade_should_contain_the_following_details(List<Map<String, String>> tradeDetails) {
        restAssuredThat(response -> response.statusCode(200));

        Map<String, String> expectedResponse = tradeDetails.get(0);
        Map<String, String> actualResponse = theTradeDetails.returned();

        assertThat(actualResponse).containsAllEntriesOf(expectedResponse);
    }

}
