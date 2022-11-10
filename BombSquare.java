import java.util.*;

/**
 * This provides visual actions when a user click on a square on the board.
 * @author Yudai Yamase
 */
public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;

	static Driver driver = new Driver();
	

	static int height = driver.getHeight();
	static int width = driver.getWidth();

	/** store the index of squares with bomb **/
	static volatile int[][] arr = new int[width][height];
	

	/**
	 * This sets up initial state of squares. It also stores where a bomb is located when ditected
	 * @param x x-coordinate of a square
	 * @param y y-coordinate of a square
	 * @param board gameboard where each square resides
	 */
	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);

		if(thisSquareHasBomb){
			arr[x][y] = 1;
		}
		else{
			arr[x][y] = 0;
		}
	}

	/**
	 * It gets invoked if a user click on a square.
	 * If the square has a bomb underneath, it shows the image of bomb, else it calls bombChecker method
	 */
	public void clicked()
	{
		if (thisSquareHasBomb == true){
			setImage("images/bomb.png");
		}

		if (thisSquareHasBomb == false){
			bombChecker(xLocation,yLocation, true);
		}
	}

	/**
	 * It checks how many bombs are hidden in adjacent squares. If none, it reveals the status of adjacent squares.
	 * @param x x-coordinate of a square
	 * @param y y-coordinate of a square
	 * @param first true if it's the first time to get called, and if it is a recursive call, returns false
	 */
	public void bombChecker(int x, int y, boolean first){
		int counter = 0;
		for (int i=0; i<3; i++){
			for (int j=0; j<3; j++){
				if (0 <= x+i-1 && x+i-1 <= width-1 && 0 <= y+j-1 && y+j-1 <= height-1){ // check if it's within the range
					if (arr[x+i-1][y+j-1] == 1){
						counter++;
					}
				}			
			}
		}	

		switch (counter) {
			case 0:
				board.getSquareAt(x, y).setImage("images/0.png");
				if (first){
					if (x-1>=0){
						bombChecker(x-1, y, false);
						if (y-1>=0){
							bombChecker(x-1, y-1, false);
						}
					}
					
					if (y-1>=0){
						bombChecker(x, y-1, false);
						if (x+1<=width-1){
							bombChecker(x+1, y-1, false);
						}
					}

					if (x+1<=width-1){
						bombChecker(x+1, y, false);
						if (y+1<=height-1){
							bombChecker(x+1, y+1, false);
						}
					}

					if (y+1<=height-1){
						bombChecker(x, y+1, false);
						if (x-1>=0){
							bombChecker(x-1, y+1, false);
						}
					}
				}
				break;
			case 1:
				board.getSquareAt(x, y).setImage("images/1.png");
				break;
			case 2:
				board.getSquareAt(x, y).setImage("images/2.png");
				break;
			case 3:
				board.getSquareAt(x, y).setImage("images/3.png");
				break;
			case 4:
				board.getSquareAt(x, y).setImage("images/4.png");
				break;
			case 5:
				board.getSquareAt(x, y).setImage("images/5.png");
				break;
			case 6:
				board.getSquareAt(x, y).setImage("images/6.png");
				break;
			case 7:
				board.getSquareAt(x, y).setImage("images/7.png");
				break;
			case 8:
				board.getSquareAt(x, y).setImage("images/8.png");
				break;	
		}
	}
}
