import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int TotalGame;
		try {
			File Streak = new File("Streak.txt"); // Bundan itibaren olan 5 satirda oyun kapatip acidiginda ust uste olan kazanma sayisi 0 yapiliyor.
			FileWriter StreakWriter = new FileWriter("Streak.txt");
			String Score = Integer.toString(0);
			StreakWriter.write(Score);
			StreakWriter.close();
			File TotalGames = new File("TotalGames.txt"); // Asagidaki satirlarda oyun kapatilip acildiginda toplam oyun sayisi 1 artiriliyorki hesaplamalar bozulmasin
			Scanner scan2 = new Scanner(TotalGames);
			TotalGame = scan2.nextInt();
			FileWriter TotalGameWriter = new FileWriter("TotalGames.txt");
			TotalGame = TotalGame + 1;
			String score2 = Integer.toString(TotalGame);
			TotalGameWriter.write(score2);
			TotalGameWriter.close();
		}
		catch (Exception e) {
			
		}
		
		new gameFrame(); // Oyun ekrani aciliyor
	}

}
