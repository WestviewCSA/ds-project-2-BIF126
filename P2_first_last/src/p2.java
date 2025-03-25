import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.LinkedList;


public class p2 {

	static Queue<Tile> queue = new LinkedList();
	static Queue<Tile> visit = new LinkedList();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("p2");
		
		readMap("TEST05.txt");
	}

	public static void readMap(String filename) {
		
		try {
		    File file = new File(filename);
		    Scanner scanner = new Scanner(file);
		    // use scanner to read file
		    
		    int numRows = scanner.nextInt();
		    int numCols = scanner.nextInt();
		    int numRooms = scanner.nextInt();
		    
		    Tile[][][] tiles = new Tile[numRows][numCols][numRooms];
		    
		    int rowIndex = 0;
		    int colsIndex = 0;
		    int roomsIndex = 0;
		    
		    //process the map!
		    while(scanner.hasNextLine()) {
		    	//grab a line (one row of the map)
		    	String row = scanner.nextLine();
		    	
		    	if(row.length()>0) {
		    		for(int i = 0; i < numCols && i < row.length(); i++) {
		    			char el = row.charAt(i);
		    			Tile obj = new Tile(rowIndex, i, el, roomsIndex);
		    			
		    		}
		    	}
		    	
		    }
		    
		    
		} catch (FileNotFoundException e) {
		    // handle exception
			System.out.println(e);
		}
				
	}
	
	public static Tile findStart(Tile[][][] tiles2) {
		Tile startingPosition = null;
		for(int i = 0; i < tiles2.length; i++) {
			for(int j = 0; j < tiles2[i].length; j++) {
				for(int k = 0; k < tiles2[i][j].length; k++) {
					if(tiles2[i][j][k].equals("W")) {
						startingPosition = tiles2[i][j][k];
					}
				}
			}
		}
		return startingPosition;
	}
	
	
	public static void queueStartingPos(Tile[][][] dotTiles) {
		
		Tile thePos = findStart(dotTiles);
		queue.add(findStart(dotTiles));
		
	}
	
	public static void dequeueStartingPos(Tile[][][] dotTiles) {
		Tile curr = queue.poll();
		visit.add(curr);
		
		for(int i = curr.getRow(); i > 0; i++) {
			if(dotTiles[curr.getRoom()][i][curr.getCol()].equals('.')) {
				queue.add(dotTiles[curr.getRoom()][i][curr.getCol()]);
			}
		}
		
		for(int i = curr.getRow(); i < dotTiles.length; i++) {
			if(dotTiles[curr.getRoom()][i][curr.getCol()].equals('.')) {
				queue.add(dotTiles[curr.getRoom()][i][curr.getCol()]);
			}
		}
		
		for(int i = curr.getCol(); i < dotTiles[curr.getRow()].length; i++) {
			if(dotTiles[curr.getRoom()][i][curr.getCol()].equals('.')) {
				queue.add(dotTiles[curr.getRoom()][curr.getRow()][i]);
			}
		}
		
		for(int i = curr.getCol(); i > 0; i--) {
			if(dotTiles[curr.getRoom()][i][curr.getCol()].equals('.')) {
				queue.add(dotTiles[curr.getRoom()][curr.getRow()][i]);
			}
		}
		
	}
}
