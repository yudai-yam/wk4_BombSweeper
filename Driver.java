public class Driver
{
	private static int width = 30;
	private static int height = 20;

	public static void main(String[] Args)
	{
		
		GameBoard b = new GameBoard("BombSweeper", width,height);
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}
}
