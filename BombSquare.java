import java.util.*;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;

	static Driver driver = new Driver();

	static int height = driver.getHeight();
	static int width = driver.getWidth();

	// store the index of squares with bomb
	static volatile int[][] arr = new int[width][height];
	


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

	public void clicked()
	{
		if (thisSquareHasBomb == true){
			setImage("images/bomb.png");
		}

		if (thisSquareHasBomb == false){
			switch (surroundingBombChecker()) {
				case 0:
					setImage("images/0.png");
					break;
				case 1:
					setImage("images/1.png");
					break;
				case 2:
					setImage("images/2.png");
					break;
				case 3:
					setImage("images/3.png");
					break;
				case 4:
					setImage("images/4.png");
					break;
				case 5:
					setImage("images/5.png");
					break;
				case 6:
					setImage("images/6.png");
					break;
				case 7:
					setImage("images/7.png");
					break;
				case 8:
					setImage("images/8.png");
					break;
				
			}
		}
	}

	public int surroundingBombChecker(){
		int counter = 0;
		arr[this.xLocation][this.yLocation] = 0;
		for (int i=0; i<3; i++){
			for (int j=0; j<3; j++){
				if (0 <= this.xLocation+i-1 && this.xLocation+i-1 <= width-1 && 0 <= this.yLocation+j-1 && this.yLocation+j-1 <= height-1){
					if (arr[this.xLocation+i-1][this.yLocation+j-1] == 1){
						counter++;
					}
				}			
			}
		}	
		return counter;
	}
	
}
