package PointPackage;

public class Point {
    private int winMatch;
    private int drawMatch;
    private int loseMatch;
    private int winPoint;
    private int drawPoint;
    private int losePoint;

    public Point() {}

    public Point(int winMatch, int drawMatch, int loseMatch) {
        this.winMatch = winMatch;
        this.drawMatch = drawMatch;
        this.loseMatch = loseMatch;
        addWinPoint();
        addDrawPoint();
        addLosePoint();
    }

    private void addWinPoint() {
        winPoint = winMatch * 3;
    }

    private void addDrawPoint() {
        drawPoint = drawMatch * 1;
    }

    private void addLosePoint() {
        losePoint = loseMatch * 0;
    }

    public int sumPoint() {
        return winPoint + drawPoint + losePoint;
    }
}
