package com.Bare;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rps {

@RequestMapping(value = "/score/ties", method = RequestMethod.GET)
public int getTies() {
return ScoreBean.ties;

}

@RequestMapping(value = "/score", method = RequestMethod.POST)
public String score(String player1, String player2) {

GameController.Players(player1, player2);
String score = player1 + " " + player2;
return (GameController.Players(player1, player2) + " " + score + " " + GameController.player1Score + " "
+ GameController.player2Score);
}

@RequestMapping(value = "/score/wins", method = RequestMethod.POST)
public int increaseWins() {
ScoreBean.wins++;
return ScoreBean.wins;

}

@RequestMapping(value = "/score/ties", method = RequestMethod.POST)
public int increasTies() {
ScoreBean.ties++;
return ScoreBean.ties;

}


@RequestMapping(value = "/score", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public String getScoreBean() {

String pattern = "{ 'player1':'%s', 'player2':\"%s\", \"ties\": \"%s\"}";
return String.format(pattern, ScoreBean.wins, ScoreBean.losses, ScoreBean.ties);

}


@RequestMapping(value = "/score", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
public String update(int wins, int losses, int ties) {
ScoreBean.wins = wins;
ScoreBean.losses = losses;
ScoreBean.ties = ties;
String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
return String.format(pattern, ScoreBean.wins, ScoreBean.losses, ScoreBean.ties);
}

}

