package com.afterhours.game;

import com.afterhours.game.action.Action;
import com.afterhours.game.action.ActionParser;
import com.afterhours.game.player.Player;
import com.afterhours.game.strategy.ProcessorStrategy;
import com.afterhours.game.strategy.ProcessorStrategyFactory;

import java.util.Scanner;

public class Game {

    public Game() {

    }

    public void begin() {
        displayTitle();
        displayOpeningParagraph();
        runGame();
    }

    private void displayTitle() {
        System.out.println("After Hours at the Puzzle Museum");
    }

    private void displayOpeningParagraph() {
        System.out.println("You're a security guard working your first night at the puzzle museum.\n" +
                "\n" +
                "It's been a quiet, uneventful first work day. And you have a couple minutes left 'til the museum closes...\n");
    }

    private void runGame() {
        Scanner in = new Scanner(System.in);
        Player player = new Player();
        ProcessorStrategyFactory processorStrategyFactory = new ProcessorStrategyFactory();

        while (true) {
            ActionParser actionParser = new ActionParser();
            String[] input = in.nextLine().split(" ");
            Action action = actionParser.parseAction(input[0]);
            ProcessorStrategy processorStrategy = processorStrategyFactory.determineStrategy(action);
            System.out.println(processorStrategy.processAction(player, input));
        }
    }
}
