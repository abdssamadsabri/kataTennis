package stepTest;

import com.quanteam.domain.TennisGame;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TennisTest {

    TennisGame game;


    @Given("^(.+) and (.+) play together$")
    public void nadal_and_Federer_play_together(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game = new TennisGame(arg1, arg2);
    }

    @When("^(.+) wins point$")
    public void wins_point(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (arg1.equals("Nadal"))
            game.playerOneWinsPoint();
        if ((arg1.equals("Federer")))
            game.playerTwoWinsPoint();

    }

    @Then("^(.+) wins the game$")
    public void wins_the_game(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String result = arg1 + " wins the game";
        Assert.assertEquals(result, game.getScoreGame());
    }


    @When("^They reach (\\d+) point$")
    public void they_reach_point(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getPlayerOne().setScore(arg1);
        game.getPlayerTwo().setScore(arg1);
    }

    @Then("^the DEUCE rule is activated$")
    public void the_DEUCE_rule_is_activated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String resultScore = "DEUCE";
        Assert.assertEquals(resultScore, game.getScoreGame());
    }

    @Given("^DEUCE rule is activated$")
    public void deuce_rule_is_activated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getPlayerOne().setScore(3);
        game.getPlayerTwo().setScore(3);
    }

    @Then("^(.+) takes advantage$")
    public void nadal_takes_advantage(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String resultScore = arg1 + " has advantage";
        Assert.assertEquals(resultScore, game.getScoreGame());
    }

    @Given("^(.+) has advantage$")
    public void nadal_has_advantage(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getPlayerOne().setScore(4);
        game.getPlayerTwo().setScore(3);
    }

    @When("^Nadal reach the Set score of (\\d+)$")
    public void nadal_reach_the_Set_score_of(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getPlayerOne().setSetScore(arg1);


    }

    @When("^Federer has a Set score of (\\d+)$")
    public void federer_has_a_Set_score_of(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getPlayerTwo().setSetScore(arg1);
    }

    @Given("^the Set score of each other is \\((\\d+),(\\d+)\\)$")
    public void the_set_score_of_each_other_is(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getPlayerOne().setSetScore(arg1);
        game.getPlayerTwo().setSetScore(arg2);
    }

    @Given("^their game score is \\((\\d+),(\\d+)\\)$")
    public void their_game_score_is(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int scorePlayerOne = 0;
        int scorePlayerTwo = 0;

        switch (arg1) {
            case 0:
                scorePlayerOne = 0;
                break;
            case 15:
                scorePlayerOne = 1;
                break;
            case 30:
                scorePlayerOne = 2;
                break;
            case 40:
                scorePlayerOne = 3;
                break;
        }
        switch (arg2) {
            case 0:
                scorePlayerTwo = 0;
                break;
            case 15:
                scorePlayerTwo = 1;
                break;
            case 30:
                scorePlayerTwo = 2;
                break;
            case 40:
                scorePlayerTwo = 3;
                break;
        }
        game.getPlayerOne().setScore(scorePlayerOne);
        game.getPlayerTwo().setScore(scorePlayerTwo);
    }

    @Then("^Nadal wins the game and the Set$")
    public void nadal_wins_the_game_and_the_Set() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String result = game.getPlayerOne().getName() + " wins the game and the Set";
        Assert.assertEquals(result, game.getScoreGame());
    }

    @Then("^Nadal wins the game and the match$")
    public void nadal_wins_the_game_and_the_match() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String result = game.getPlayerOne().getName() + " wins the game and the match";
        Assert.assertEquals(result, game.getScoreGame());
    }

    @Then("^the Tie-Break rule is activated$")
    public void the_Tie_Break_rule_is_activated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getScoreGame();
        Assert.assertTrue(game.isTieBreak());
    }

    @Given("^Tie-Break rule is activated$")
    public void Tie_Break_rule_is_activated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getPlayerOne().setSetScore(6);
        game.getPlayerTwo().setSetScore(6);
    }

    @Given("^the score is \\((\\d+),(\\d+)\\)$")
    public void the_score_is(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game.getPlayerOne().setTieBreakScore(arg1);
        game.getPlayerTwo().setTieBreakScore(arg2);
    }

    @Then("^Nadal wins the Set and match$")
    public void nadal_wins_the_Set_and_match() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String result = game.getPlayerOne().getName() + "wins the Set and the match";
        Assert.assertEquals(result, game.getScoreGame());
    }

}
