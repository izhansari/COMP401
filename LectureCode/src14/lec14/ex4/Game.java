package lec14.ex4;

public interface Game {

	public abstract void scorePoints(String team, int points_to_add);

	public abstract void printScore();

	public abstract String whoIsWinning();

}