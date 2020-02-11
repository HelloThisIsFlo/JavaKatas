package katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int NUM_OF_PINS = 10;
    public static final int NUM_OF_FRAMES = 10;
    public static final int ROLLS_PER_FRAME = 2;
    boolean thisFrameIsASpare = false;
    boolean lastFrameWasSpare = false;
    int pinsAlreadyDownInCurrentFrame = 0;
    private int score;
    private List<Integer> points = new ArrayList<>();
    private int currentRoll = 0;

    public Game() {
        this.score = 0;
    }

    public void rollToni(int pinsDown) {
        if (currentRoll > 1) {
            int sumOfLastFrame = points.get(currentRoll - 1) + points.get(currentRoll - 2);
            if (sumOfLastFrame == 10) {
                score += pinsDown * 2;
            } else {
                score += pinsDown;
            }
        } else {
            score += pinsDown;
        }
        points.add(pinsDown);
        currentRoll += 1;
    }

    public void roll(int pinsDown) {
        boolean newFrame = currentRoll % 2 == 0;
        if (newFrame) pinsAlreadyDownInCurrentFrame = 0;

        thisFrameIsASpare = (pinsDown + pinsAlreadyDownInCurrentFrame) == NUM_OF_PINS;

        score += pinsDown;
        if (lastFrameWasSpare) score += pinsDown;


        pinsAlreadyDownInCurrentFrame += pinsDown;

        currentRoll++;
        lastFrameWasSpare = thisFrameIsASpare;
    }

    public void rollRefactored_butNotComplete_tooEarly(int pinsDown) {
        resetPinsDownIfNewFrame();
        checkIfThisRollsIsASpare(pinsDown);
        updateScore(pinsDown);
        updatePinsDownInCurrentFrame(pinsDown);
        prepareForNextRoll();
    }

    private void resetPinsDownIfNewFrame() {
        boolean newFrame = currentRoll % 2 == 0;
        if (newFrame) pinsAlreadyDownInCurrentFrame = 0;
    }

    private void updateScore(int pinsDown) {
        score += pinsDown;
        if (lastFrameWasSpare) score += pinsDown;
    }

    private void checkIfThisRollsIsASpare(int pinsDown) {
        thisFrameIsASpare = (pinsDown + pinsAlreadyDownInCurrentFrame) == NUM_OF_PINS;
    }

    private void updatePinsDownInCurrentFrame(int pinsDown) {
        pinsAlreadyDownInCurrentFrame += pinsDown;
    }

    private void prepareForNextRoll() {
        currentRoll++;
        lastFrameWasSpare = thisFrameIsASpare;
    }

    public int score() {
        return score;
    }
}

