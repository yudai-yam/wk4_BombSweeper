public class Driver
{
	private static int width = 11;
	private static int height = 10;

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
