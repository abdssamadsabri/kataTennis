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
        if (arg1.equals("Nadal"))
            game.getPlayerOne().winPoint();
        if ((arg1.equals("Federer")))
            game.getPlayerTwo().winPoint();

    }

    @Then("^(.+) wins the game$")
    public void wins_the_game(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String result = arg1 + " wins the game";
        Assert.assertEquals(result, game.getScoreGame());
    }

    @Given("^(.+) and (.+) play together$")
    public void nadal_and_Federer_play_together(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        game = new TennisGame(arg1, arg2);
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
        game.getPlayerOne().setScore(arg1);
        game.getPlayerTwo().setScore(arg2);
    }

    @Then("^Nadal wins the game and the Set$")
    public void nadal_wins_the_game_and_the_Set() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String result = game.getPlayerOne().getName() +" wins the game and the Set";
        Assert.assertEquals(result,game.getScoreGame());
    }

    @Then("^Nadal wins the game and the match$")
    public void nadal_wins_the_game_and_the_match() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String result = game.getPlayerOne().getName() +" wins the game and the match";
        Assert.assertEquals(result,game.getScoreGame());
    }
}
