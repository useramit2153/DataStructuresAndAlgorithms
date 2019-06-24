import java.util.Scanner;

public class Manager {
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;
	
	public static void main(String args[]) {
//		Scanner s = new Scanner(System.in);
//		OthelloBoard b = new OthelloBoard();
//		int n = s.nextInt();
//		boolean p1Turn = false;
//		while(n > 0) {
//			int x = s.nextInt();
//			int y = s.nextInt();
//			boolean ans = false;
//			if(p1Turn) {
//				ans = b.move(player1Symbol, x, y);
//			}
//			else {
//				ans = b.move(player2Symbol, x, y);
//			}
//			if(ans) {
//				b.print();
//				p1Turn = !p1Turn;
//				n--;
//			}
//			else {
//				System.out.println(ans);
//			}
//		}
		
		Manager m = new Manager();
		m.startGame();
	}
	
	public void startGame() {
		// two players input
		Player p1 = takePlayerInput(1);
		Player p2 = takePlayerInput(2);
		Scanner scan = new Scanner(System.in);
		while(p1.getColor() == p2.getColor()) {
			System.out.println(p2.getPlayerName() + ", please choose another color: ");
			char color = scan.next().charAt(0);
			p2.setColor(color);
		}
		
		// Board
		Board b = new Board(p1.getColor(), p2.getColor());
		b.print();
		
		// Conduct
		int status = Board.INCOMPLETE;
		boolean player1turn = true;
		if(p1.getColor() == 'w')
			player1turn = false;
		while(status == Board.INCOMPLETE || status ==  Board.INVALID) {
			if(player1turn) {
				System.out.println(p1.getPlayerName() + "'s turn...");
				System.out.println("Enter x: ");
				int x = scan.nextInt();
				System.out.println("Enter y: ");
				int y = scan.nextInt();
				status = b.move(x, y, p1.getColor());
				if(status != Board.INVALID) {
					b.print();
					player1turn = false;
				} else
					System.out.println("Invalid Move !! Please Try Again !!");
			} else {
				System.out.println(p2.getPlayerName() + "'s turn...");
				System.out.println("Enter x: ");
				int x = scan.nextInt();
				System.out.println("Enter y: ");
				int y = scan.nextInt();
				status = b.move(x, y, p2.getColor());
				if(status != Board.INVALID) {
					b.print();
					player1turn = true;
				} else
					System.out.println("Invalid Move !! Please Try Again !!");
			}
		}
		
		if(status == Board.PLAYER_1_WINS) {
			System.out.println(p1.getPlayerName() + " wins !!");
			System.out.println("Congratulations");
		}
		
		if(status == Board.PLAYER_2_WINS) {
			System.out.println(p2.getPlayerName() + " wins !!");
			System.out.println("Congratulations");
		}
		
		if(status == Board.DRAW)
			System.out.println("Game Draw !!");
		
		scan.close();
	}
	
	public Player takePlayerInput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player - " + num + " Name: ");
		String name = s.nextLine();
		System.out.println("Enter Player - " + num + " Color: ");
		char color = s.next().charAt(0);
		Player p = new Player(name, color);
		return p;
	}
	
}
