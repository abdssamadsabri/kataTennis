package stepTest;

import com.quanteam.domain.TennisGame;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TennisTest {

    TennisGame game;

    @Given("^(.+) and (.+) win (\\d+) point$")
    public void and_win_point_each_other(String arg1, String arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int score = 0;
        switch (arg3) {
            case 0:
                score = 0;
                break;
            case 15:
                score = 1;
                break;
            case 30:
                score = 2;
                break;
            case 40:
                score = 3;
                break;
        }
        game = new TennisGame(arg1, arg2);
        game.getPlayerOne().setScore(score);
        game.getPlayerTwo().setScore(score);

    }

    @When("^(.+) wins point$")
    public void wins_point(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getPlayerOne().winPoint();

    }

    @Then("^(.+) wins the game$")
    public void wins_the_game(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String result = arg1 + "wins";
        Assert.assertEquals(result, game.getScoreGame());
    }

}
