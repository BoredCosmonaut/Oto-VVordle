import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class statFrame extends JFrame implements KeyListener{

	ImageIcon iconStat = new ImageIcon("icons/lightModeStat.png"); // 19-40 arasi degiskenler ve label ayarlari icin
	public int TotalGames;
	public int WinPercentage;
	public int CurrentHighStreak;
	int Streaks;
	public int TotalGame;
	public int TotalWin;
	int[] StatsArray = new int[4];
	int gap = 152;
	private static final long serialVersionUID = 1L;
	JLayeredPane statPanel = new JLayeredPane();
	JLabel HeadLine = new JLabel("ÝSTATÝSTÝK");
	JLabel Played = new JLabel("100");
	JLabel Percent = new JLabel("100");
	JLabel CStreak = new JLabel("100");
	JLabel HStreak = new JLabel("100");
	JLabel bottomText1 = new JLabel("Oynandi");
	JLabel bottomText2 = new JLabel("Kazanma%");
	JLabel bottomText3 = new JLabel("Mevcut");
	JLabel bottomText31 = new JLabel("Streak");
	JLabel bottomText4 = new JLabel("En Yuksek");
	JLabel bottomText41 = new JLabel("Streak");
	
	void placeText(JLabel lb, int size, int x, int y, int yBound, String number) { // $ text yerlestirmek icin 
		lb.setText(number);
		lb.setForeground(new Color(230,230,230));
		lb.setFont(new Font("Arial", Font.BOLD, size));
		lb.setBounds(24 + x, 72 + y, 150, yBound);
		lb.setHorizontalAlignment(JLabel.CENTER);	
		statPanel.add(lb);
	}
	statFrame(){ // $ Frame kurmak icin
		HeadLine.setForeground(new Color(230,230,230));
		HeadLine.setFont(new Font("Arial", Font.BOLD, 46));
		HeadLine.setBounds(201, 20, 250, 54);
		HeadLine.setHorizontalAlignment(JLabel.CENTER);
		int i = 0;
		try { // gameFrame de bulunan istatislikleri bu Class icine tasimak icin kurldu
			File Stats = new File("Stats.txt");
			FileReader StatsReader = new FileReader(Stats);
			Scanner scan = new Scanner(StatsReader);
			while(scan.hasNext()) {
				StatsArray[i] = scan.nextInt();
				i = i + 1;		
			}
		}
		catch (Exception e) {
			String message = e.getMessage();
			System.out.println(message);
		}


		placeText(Played, 72, 0, 0, 128, Integer.toString(StatsArray[1])); // 71-80 arasi istatistik ekranina istatislikleri yazdirmak icin ve altina nelerin istatigi oldugunu gostermek icin
		placeText(Percent, 72, gap * 1, 0, 128, Integer.toString(StatsArray[0]));
		placeText(CStreak, 72, gap * 2, 0, 128, Integer.toString(StatsArray[2]));
		placeText(HStreak, 72, gap * 3, 0, 128, Integer.toString(StatsArray[3]));
		placeText(bottomText1, 24, 4 + gap * 0, 0 , 256, "Oynandi");
		placeText(bottomText2, 24, 4 + gap * 1, 0, 256, "%Kazanma");
		placeText(bottomText3, 24, 4 + gap * 2, 0, 256, "Mevcut");
		placeText(bottomText31, 24, 4 + gap * 2 , 24 , 256, "Streak");
		placeText(bottomText4, 24, 4 + gap * 3, 0, 256, "En yuksek");
		placeText(bottomText41, 24, 4 + gap * 3 , 24 , 256, "Streak");
		
		statPanel.setPreferredSize(new Dimension(642,248)); // 82-91 arasi normal Frame ayarlari
		statPanel.add(HeadLine);	
		this.setUndecorated(true);
		this.setIconImage(iconStat.getImage());
		this.getContentPane().add(statPanel);
		this.setVisible(true);
		this.addKeyListener(this);
		this.getContentPane().setBackground(new Color(22, 22, 22));
		this.pack();
		this.setLocationRelativeTo(null);
	}
	@Override
	public void keyTyped(KeyEvent e) { // $ Esc tusuna basinca istatistik ekrani kapatiliyor.
		if(e.getKeyChar() == 27) {
			this.dispose();
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
