package com.quanteam.domain;

public class TennisGame {


    private Player playerOne;
    private Player playerTwo;
    private String scoreGame;

    public TennisGame(String arg1, String arg2) {
        playerOne = new Player(arg1);
        playerTwo = new Player(arg2);
    }


    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void setScoreGame(String scoreGame) {
        this.scoreGame = scoreGame;
    }

    public String getScoreGame() {

        int scorePlayer1 = 0;
        int scorePlayer2 = 0;
        int score_player_one = playerOne.getScore();
        int score_player_two = playerTwo.getScore();
        if (score_player_one <= 3 && score_player_two <= 3 && score_player_one != score_player_two) {
            switch (score_player_one) {
                case 0:
                    scorePlayer1 = 0;
                    break;

                case 1:
                    scorePlayer1 = 15;
                    break;
                case 2:
                    scorePlayer1 = 30;
                    break;
                default:
                    scorePlayer1 = 40;
                    break;
            }
            switch (score_player_two) {
                case 0:
                    scorePlayer2 = 0;
                    break;
                case 1:
                    scorePlayer2 = 15;
                    break;
                case 2:
                    scorePlayer2 = 30;
                    break;
                default:
                    scorePlayer2 = 40;
                    break;
            }
            scoreGame = playerOne.getName() + ":" + scorePlayer1 + "-" + scorePlayer2 + ":" + playerTwo.getName();

        }

        if (score_player_one >= 3 && score_player_one > score_player_two + 1) {
            scoreGame = playerOne.getName() + " wins the game";
            playerOne.setScore(0);
            playerTwo.setScore(0);
            int setScore = playerOne.getSetScore();
            setScore++;
            playerOne.setSetScore(setScore);
            if (playerOne.getSetScore() == 6 && playerTwo.getSetScore() <= 4) {
                scoreGame = scoreGame + " and the Set";
            }
            if (playerOne.getSetScore() == 7) {
                scoreGame = scoreGame + " and the match";
            }

        }
        if (score_player_two >= 3 && score_player_two > score_player_one + 1) {
            scoreGame = playerTwo.getName() + " wins the game";
            playerOne.setScore(0);
            playerTwo.setScore(0);
            int setScore = playerTwo.getSetScore();
            setScore++;
            playerTwo.setSetScore(setScore);
            if (playerTwo.getSetScore() == 6 && playerOne.getSetScore() <= 4) {
                scoreGame = scoreGame + " and the Set";
            }
            if (playerTwo.getSetScore() == 7) {
                scoreGame = scoreGame + " and the match";
            }
        }

        if (score_player_one >= 3 && score_player_one == score_player_two + 1) {
            scoreGame = playerOne.getName() + " has advantage";
        }

        if (score_player_one >= 3 && score_player_two == score_player_one + 1) {
            scoreGame = playerOne.getName() + " has advantage";
        }

        if (score_player_one >= 3 && score_player_one == score_player_two) {
            scoreGame = "DEUCE";
        }
        return scoreGame;
    }
}
