import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class gameFrame extends JFrame implements ActionListener,KeyListener{
	// $ isareti fonksiyonlari daha kolay bulmak icin
	
	private static final long serialVersionUID = 1L;
	ImageIcon blanksq = new ImageIcon("sprites/blanksq.png"); //Icinde harf olmayan kutular
	ImageIcon filledsq = new ImageIcon("sprites/filledsq.png"); //Icinde harf olan kontrol edilmemiÅŸ kutular
	ImageIcon greysq = new ImageIcon("sprites/greysq.png"); // Dogru olmayan kutularÄ± gri yapmak icin
	ImageIcon yellowsq = new ImageIcon("sprites/yellowsq.png"); // Harfi iÃceren kutulari sari yapmak icin
	ImageIcon greensq = new ImageIcon("sprites/greensq.png"); // Dogru olan kutularÄ± yesil yapmak icin
	
	ImageIcon FrameIcon = new ImageIcon("icons/VVordleIcon.png"); // 38-45 arasi ikonlar icin
	ImageIcon resArrow = new ImageIcon("icons/reset.png"); 
	ImageIcon light = new ImageIcon("icons/Sun.png"); 
	ImageIcon dark = new ImageIcon("icons/dark.png"); 
	ImageIcon line = new ImageIcon("icons/theline.png");
	ImageIcon statLight = new ImageIcon("icons/lightModeStat.png");
	ImageIcon statDark = new ImageIcon("icons/DarkModeStat.png");
	ImageIcon botIcon = new ImageIcon("icons/Bot.png");
	ImageIcon botPerc = new ImageIcon("icons/robotPercentage.png");
	
	JPanel keyboardPanel = new JPanel();
	JLayeredPane windowPanel = new JLayeredPane();
	
	JLabel sq1 = new JLabel("0,1"); // 50-149 arasi kutucuklar icin
	JLabel sq2 = new JLabel("0,2");
	JLabel sq3 = new JLabel("0,3");
	JLabel sq4 = new JLabel("0,4");
	JLabel sq5 = new JLabel("0,5");
	JLabel sq6 = new JLabel("1,1");
	JLabel sq7 = new JLabel("1,2");
	JLabel sq8 = new JLabel("1,3");
	JLabel sq9 = new JLabel("1,4");
	JLabel sq10 = new JLabel("1,5");
	JLabel sq11 = new JLabel("2,1");
	JLabel sq12 = new JLabel("2,2");
	JLabel sq13 = new JLabel("2,3");
	JLabel sq14 = new JLabel("2,4");
	JLabel sq15 = new JLabel("2,5");
	JLabel sq16 = new JLabel("3,1");
	JLabel sq17 = new JLabel("3,2");
	JLabel sq18 = new JLabel("3,3");
	JLabel sq19 = new JLabel("3,4");
	JLabel sq20 = new JLabel("3,5");
	JLabel sq21 = new JLabel("4,1");
	JLabel sq22 = new JLabel("4,2");
	JLabel sq23 = new JLabel("4,3");
	JLabel sq24 = new JLabel("4,4");
	JLabel sq25 = new JLabel("4,5");
	JLabel sq26 = new JLabel("5,1");
	JLabel sq27 = new JLabel("5,2");
	JLabel sq28 = new JLabel("5,3");
	JLabel sq29 = new JLabel("5,4");
	JLabel sq30 = new JLabel("5,5");
	
	JLabel sqt1 = new JLabel("");
	JLabel sqt2 = new JLabel("");
	JLabel sqt3 = new JLabel("");
	JLabel sqt4 = new JLabel("");
	JLabel sqt5 = new JLabel("");
	JLabel sqt6 = new JLabel("");
	JLabel sqt7 = new JLabel("");
	JLabel sqt8 = new JLabel("");
	JLabel sqt9 = new JLabel("");
	JLabel sqt10 = new JLabel("");
	JLabel sqt11 = new JLabel("");
	JLabel sqt12 = new JLabel("");
	JLabel sqt13 = new JLabel("");
	JLabel sqt14 = new JLabel("");
	JLabel sqt15 = new JLabel("");
	JLabel sqt16 = new JLabel("");
	JLabel sqt17 = new JLabel("");
	JLabel sqt18 = new JLabel("");
	JLabel sqt19 = new JLabel("");
	JLabel sqt20 = new JLabel("");
	JLabel sqt21 = new JLabel("");
	JLabel sqt22 = new JLabel("");
	JLabel sqt23 = new JLabel("");
	JLabel sqt24 = new JLabel("");
	JLabel sqt25 = new JLabel("");
	JLabel sqt26 = new JLabel("");
	JLabel sqt27 = new JLabel("");
	JLabel sqt28 = new JLabel("");
	JLabel sqt29 = new JLabel("");
	JLabel sqt30 = new JLabel("");
	JLabel PWCount  = new JLabel("");
	
	JButton viewKeyboard = new JButton();
	JButton resetBut = new JButton();
	JButton lightSwitch = new JButton();
	JButton StatBut = new JButton();
	JButton BotBut = new JButton();
	JButton OtoBut = new JButton();
	
	JButton ABut = new JButton("A");
	JButton BBut = new JButton("B");
	JButton CBut = new JButton("C");
	JButton CHBut = new JButton("Ã‡");
	JButton DBut = new JButton("D");
	JButton EBut = new JButton("E");
	JButton FBut = new JButton("F");
	JButton GBut = new JButton("G");
	JButton GHBut = new JButton("Ğ");
	JButton HBut = new JButton("H");
	JButton IBut = new JButton("I");
	JButton IHBut = new JButton("İ");
	JButton JBut = new JButton("J");
	JButton KBut = new JButton("K");
	JButton LBut = new JButton("L");
	JButton MBut = new JButton("M");
	JButton NBut = new JButton("N");
	JButton OBut = new JButton("O");
	JButton OHBut = new JButton("Ö");
	JButton PBut = new JButton("P");
	JButton RBut = new JButton("R");
	JButton SBut = new JButton("S");
	JButton SHBut = new JButton("Ş");
	JButton TBut = new JButton("T");
	JButton UBut = new JButton("U");
	JButton ÃœBut = new JButton("Ü");
	JButton VBut = new JButton("V");
	JButton YBut = new JButton("Y");
	JButton ZBut = new JButton("Z");
	JButton DelBut = new JButton("");
	JButton EntBut = new JButton("ENTER");
	
	Color sqtColorW = new Color(210,210,210); // 151-153 Renkler icin
	Color sqtColorB = new Color(36,36,36);
	Color sqtColorR = new Color(64,64,64);
	
	//----------------------------------------\\
	
	List<String> allkelimeler = new ArrayList<String>(); //Butun 5 harfli kelimeler bunun icinde.
	List<String> kelimeler = new ArrayList<String>(); //Absurt olmayan 5 harfli kelimeler bunun icinde.

	List<String> bestWordsList = new ArrayList<String>();
	
	List<String> possibleWords = new ArrayList<String>(); // Bot icin olasi kelimeler.
	List<String> defLetters = new ArrayList<String>(); // Bot icin kesin olan kelimeler
	
	//Asagidaki iki int degeri ve 2D diziler konum belirlemek icin
	int HorPos = 0; //Horizontal Position
	int VerPos = 0; // Vertical Position
	String Answer; // Cevap kelimesi
	char[] AnswerLetters = new char[5]; // Cevap harfleri
	char[] TempAnswerLetters = new char[5]; // Gecici cevap harfleri
	char[] GuessLetters = new char[5]; // Tahmin harfleri
	String[] GuessSequence = new String[1];
	int StatArray[] = new int[4]; // istatistik icin olusan dizi
	public int WinPercentage; // Kazanma orani
	public int CurrentHighStreak; // En yuksek yapilan streak
	int Streaks; // Ardi ardina bilinen dogru cevap sayisi
	public int TotalGame; // Oynanan toplam oyun sayisi
	public int TotalWin; // Kazanilan toplam oyun sayisi
	
	Boolean ShowHint = true;
	Boolean gonnaRestart = false;
	
	JButton[] ButArr= {EBut, RBut, TBut, YBut, UBut, IBut, OBut, PBut, GHBut, DelBut, ÃœBut, ABut, SBut, DBut, FBut, GBut,
			HBut, JBut, KBut, LBut, SHBut, IHBut, ZBut, CBut, VBut, BBut, NBut, MBut, OHBut, CHBut};
	
	// vvv renk degisecek kutularÄ±n tutuldugu 2D dizi. sq Square'in kisaltmasi
	JLabel[][] BoxArr  = {
			{sq1,sq2,sq3,sq4,sq5},
			{sq6,sq7,sq8,sq9,sq10},
			{sq11,sq12,sq13,sq14,sq15},
			{sq16,sq17,sq18,sq19,sq20},
			{sq21,sq22,sq23,sq24,sq25},
			{sq26,sq27,sq28,sq29,sq30},
	   };
	// vvv kutularÄ±n ustundeki textlerin tutuldugu 2D dizi. sqt Square Text'in kisaltmasi
	JLabel[][] LabelArr  = {
			{sqt1,sqt2,sqt3,sqt4,sqt5},
			{sqt6,sqt7,sqt8,sqt9,sqt10},
			{sqt11,sqt12,sqt13,sqt14,sqt15},
			{sqt16,sqt17,sqt18,sqt19,sqt20},
			{sqt21,sqt22,sqt23,sqt24,sqt25},
			{sqt26,sqt27,sqt28,sqt29,sqt30}
	   };
	
	
	String wholeword = ""; //Satirdaki harflerin kelime olarak birlestigi String. 
	String RecWord;
	public void getList() { // $ 206-238 arasi text icinde bulunan kelimeleri diziye atamak icin
		//System.out.println("Reading");
		Scanner scans;
		Random random = new Random();
		
		File wordtext = new File("TxtFiles/kelimeler.txt");
		File allwordtext = new File("TxtFiles/kelimelerall.txt");
		File bestWords = new File("TxtFiles/bestWords.txt"); //RecWords için
		
		try {
			scans = new Scanner(allwordtext, "UTF-8");
			while(scans.hasNextLine()) {
				allkelimeler.add(scans.nextLine());
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			scans = new Scanner(wordtext, "UTF-8");
			while(scans.hasNextLine()) {
				kelimeler.add(scans.nextLine());
			}
			scans.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			scans = new Scanner(bestWords, "UTF-8");
			while(scans.hasNextLine()) {
				bestWordsList.add(scans.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PWCount.setText(Integer.toString(kelimeler.size()));
		Answer = kelimeler.get(random.nextInt(kelimeler.size()));
	}
	Locale tr = new Locale("tr", "TR"); // local türkce olmasi icin
	void YapayZeka() { // $ 239-412 arasi yapay zeka
		if(true) {
			int startindex = 0;
			//System.out.println("Başlangıç Olasılığı: " + kelimeler.size());
			//System.out.println("PW " + possibleWords.size());
			if(possibleWords.size() == 0) {
				for(int i = 0; i < 5; i++) {
					if (BoxArr[VerPos][i].getIcon() == greensq) {
						//System.out.println("Yeşil Başlangıç");
						for(int j = 0; j < kelimeler.size() ; j++) {
							String checkWord = kelimeler.get(j);
							if(checkWord.substring(i, i + 1).equals(LabelArr[VerPos][i].getText())) {
								possibleWords.add(checkWord);
								//System.out.println(checkWord + " Eklendi. (PW-Green) ");
								if(defLetters.contains(checkWord.substring(i, i + 1)) == false) {
									//System.out.println("HARF:" + checkWord.substring(i, i + 1).toUpperCase());
									defLetters.add(checkWord.substring(i, i + 1).toUpperCase());
									//System.out.println("DefLet: " + defLetters);
								}
							}
						}
						//System.out.println("YB" + possibleWords);
						startindex = i + 1;
						i = 5;
						break;
					}
				}
			}
			if(possibleWords.size() == 0) {
				for(int i = 0; i < 5; i++) {
					if (BoxArr[VerPos][i].getIcon() == yellowsq) {
						//System.out.println("Sarı Başlangıç");
						for(int j = 0; j < kelimeler.size() ; j++) {
							String checkWord = kelimeler.get(j);
							if(checkWord.contains(LabelArr[VerPos][i].getText().toUpperCase())) {
								possibleWords.add(checkWord);
								//System.out.println(checkWord + " Eklendi. (PW-Yellow)");
								if(defLetters.contains(LabelArr[VerPos][i].getText().toUpperCase()) == false) {
									defLetters.add(LabelArr[VerPos][i].getText().toUpperCase());
									//System.out.println("DefLet: " + defLetters);
								}					
							}
						}
						//System.out.println(possibleWords);
						//System.out.println("Yeni Olasılık: " + possibleWords.size());
						for(int z = 0; z < possibleWords.size(); z++) {
							String checkWord = possibleWords.get(z);
							if(checkWord.substring(i, i + 1).equals(LabelArr[VerPos][i].getText().toUpperCase())) {
								possibleWords.remove(z);
								//System.out.println(checkWord + " " + i + ". pozisyonda bu harfi içerdiği için kaldırıldı: " + LabelArr[VerPos][i].getText());
								z--;
							}
						}
						//System.out.println("Yeni Olasılık: " + possibleWords.size());
						//System.out.println(possibleWords);
						i = 5;
						break;
					}
				}
			}
			if(possibleWords.size() == 0) {
				for(int i = 0; i < 5; i++) {
					if (BoxArr[VerPos][i].getIcon() == greysq) {
						//System.out.println("Gri Başlangıç");
						for(int j = 0; j < kelimeler.size() ; j++) {
							String checkWord = kelimeler.get(j);
							if(!checkWord.contains(LabelArr[VerPos][i].getText().toUpperCase())) {
								possibleWords.add(checkWord);
								//System.out.println(checkWord + " Eklendi. (PW-Grey)");				
							}
						}
						//System.out.println(possibleWords.size() + " " + possibleWords);
						i = 5;
						break;
					}
				}
			}
			//System.out.println("Yeni olasılık: " + possibleWords.size());
			if(possibleWords.size() > 0) {
				for(int i = startindex; i < 5; i++) {
					if (BoxArr[VerPos][i].getIcon() == greensq) {
						//System.out.println("Green PW");
						for(int j = 0; j < possibleWords.size(); j++) {
							String checkWord = possibleWords.get(j);
							if(checkWord.substring(i, i + 1).equals(LabelArr[VerPos][i].getText()) == false) {
								//System.out.println(checkWord + " " + i + ". pozisyonda -" + LabelArr[VerPos][i].getText() + "- harfini içermiyor X");
								possibleWords.remove(j);
								j--;
							}
						}
						//System.out.println("Yeni Olasılık: " + possibleWords.size());
						//System.out.println(possibleWords);
						if(defLetters.contains(LabelArr[VerPos][i].getText()) == false) {
							defLetters.add(LabelArr[VerPos][i].getText());
							//System.out.println("DefLet: " + defLetters);
						}
					}
					
				}
				for(int i = 0; i < 5; i++) {
					if (BoxArr[VerPos][i].getIcon() == yellowsq) {
						//System.out.println("Yellow PW");
						for(int j = 0; j < possibleWords.size() ; j++) {
							String checkWord = possibleWords.get(j);
							if(checkWord.substring(i, i + 1).equals(LabelArr[VerPos][i].getText())) {
								//System.out.println(checkWord + " " + i + ". pozisyonda -" + LabelArr[VerPos][i].getText() + "- harfini içeriyor X");
								possibleWords.remove(j);
								j--;
							//	//System.out.println("Sarı DF: " + LabelArr[VerPos][i].getText());
								
							}
						}
						//System.out.println("Yeni Olasılık: " + possibleWords.size());
						//System.out.println(possibleWords);
						if(defLetters.contains(LabelArr[VerPos][i].getText()) == false) {
							defLetters.add(LabelArr[VerPos][i].getText());
						    //System.out.println("DefLet: " + defLetters);
						}
					}
				}
				for(int i = 0; i < 5; i++) {
					if (BoxArr[VerPos][i].getIcon() == greysq) {
					    //System.out.println("Grey PW");
						for(int j = 0; j < possibleWords.size() ; j++) {
							String checkWord = possibleWords.get(j);
							if(checkWord.contains(LabelArr[VerPos][i].getText().toUpperCase(Locale.forLanguageTag("tr-TR"))) && defLetters.contains(LabelArr[VerPos][i].getText()) == false) {
								//System.out.println(checkWord + " -" + LabelArr[VerPos][i].getText() + "- harfini içeriyor X");
								possibleWords.remove(j);
								j--;
							}
						}
						for(int j = 0; j < possibleWords.size() ; j++) {
							String checkWord = possibleWords.get(j);
							if(checkWord.substring(i, i + 1).equals(LabelArr[VerPos][i].getText())) {
								//System.out.println(checkWord + " " + i + ". pozisyonda -" + LabelArr[VerPos][i].getText() + "- harfini içeriyor X");
								possibleWords.remove(j);
								j--;
							}
						}
						//System.out.println("Yeni Olasılık: " + possibleWords.size());
						//System.out.println(possibleWords);
					}
				}
				for(int i = 0; i < defLetters.size(); i++) {
					//System.out.println("Def PW");
					for(int j = 0; j < possibleWords.size() ; j++) {
						String checkWord = possibleWords.get(j);
						if(!checkWord.contains(defLetters.get(i))) {
							//System.out.println(checkWord + " -" + LabelArr[VerPos][i].getText() + "- harfini içermiyor X");
							possibleWords.remove(j);
							j--;
						}
						
					}
					//System.out.println("Yeni Olasılık: " + possibleWords.size());
					//System.out.println(possibleWords);
				}
			}
			if(possibleWords.size() > 0) {
				PWCount.setText(Integer.toString(possibleWords.size()));
			}
			
			recWord();
			
			if(VerPos < 5 && ShowHint && !gonnaRestart) {
				for(int i = 0; i < 5; i ++) {
					LabelArr[VerPos + 1][i].setText(RecWord.substring(i, i + 1));
					LabelArr[VerPos + 1][i].setForeground(sqtColorR);
					
				}
			}
		}
	}
	public void recWord() { // $
		
		if(possibleWords.size() > 0) {
			Random rand = new Random();
			int RecIndex = rand.nextInt(possibleWords.size());
			RecWord = possibleWords.get(RecIndex);
		}
		
		/*
		for(int b = 0; b < bestWordsList.size(); b++) {
			if(possibleWords.contains(bestWordsList.get(b))) {
				RecWord = bestWordsList.get(b);
				break;
			}
		}
		if(possibleWords.size() > 0 && !possibleWords.contains(RecWord)) {
			Random rand = new Random();
			int RecIndex = rand.nextInt(possibleWords.size());
			RecWord = possibleWords.get(RecIndex);
		}
		*/
	}
	Boolean isInsane = false;

	int Win = 0;
	int Lost = 0;

	void goingInsane(String startWord, String Cevap) {
		clearBoard();
		String StartingWord;
		String theAnswer;
		String nextGuess;
		//StartingWord = kelimeler.get(3);
		//theAnswer = kelimeler.get(345);
		theAnswer = Cevap;
		//nextGuess = StartingWord;


		defLetters.clear();
		possibleWords.clear();
		clearBoard();
		StartingWord = startWord;
		//StartingWord = startWord;
		nextGuess = StartingWord;
		defLetters.clear();
		possibleWords.clear();
		for(int v = 0; v < 6; v++) {
			for(int z = 0; z < 5; z++) {
				LabelArr[VerPos][z].setText(nextGuess.substring(z,z+1));
			}
			
			//System.out.println("RBS " + StartingWord);
			//System.out.println("RBA " + theAnswer);
			
			for (int i = 0; i < 5; i++) {
				if (BoxArr[VerPos][i].getIcon() == filledsq) { // Harf yazili olan kutunun rengini degistirmek icin
					LabelArr[VerPos][i].setForeground(new Color(210,210,210));
				}
			}
			
			
			if (nextGuess.equalsIgnoreCase(theAnswer)) { // Tahminin cevap ile ayni olup olmadigina bakmak icin
				BoxArr[VerPos][0].setIcon(greensq); // 484-489 arasi harflerin kutularini yesil yapmak icin
				BoxArr[VerPos][1].setIcon(greensq);
				BoxArr[VerPos][2].setIcon(greensq);
				BoxArr[VerPos][3].setIcon(greensq);
				BoxArr[VerPos][4].setIcon(greensq);
				Win++;
				v = 6;
				break;
			}
			for (int i = 0; i < 5; i++) { // 602-680 arasi tahmin kelimesinin harfleri ile cevap kelimesinin harflerini kiyaslamak icin
				AnswerLetters[i] = theAnswer.charAt(i); // Cevabin harflerini almak icin
				TempAnswerLetters[i] = theAnswer.charAt(i); // Gecici cevap harfleri icin
				GuessLetters[i] = nextGuess.charAt(i); // Tahmin kelimesinin harfleri icin
				if(Character.toString(AnswerLetters[i]).equals(Character.toString(GuessLetters[i]))) {
					BoxArr[VerPos][i].setIcon(greensq);
					TempAnswerLetters[i] = 'X';
				}
			}
			
			String TemptheAnswer = ""; // Gecici cevap kelimesi icin
			for(int z = 0; z < 5; z++) { // Gecici cevap kelimesini olusturmak icin
				TemptheAnswer += Character.toString(TempAnswerLetters[z]);
			}
			
			for (int j = 0; j < 5; j++) {
				for(int i = 0; i < 5; i++) {
					if (TemptheAnswer.contains(Character.toString(GuessLetters[j]).toUpperCase(Locale.forLanguageTag("tr-TR"))) && BoxArr[VerPos][j].getIcon() != greensq) {
						String Letter = Character.toString(GuessLetters[j]); // Tahmin kelimesinin harflerininin kontrolunu kolaylastirmak icin
						int index = TemptheAnswer.indexOf(Letter.toUpperCase(), 0); // Ust tafata bukunan kelimenin indeksini bulmak icin
						TemptheAnswer = TemptheAnswer.substring(0,index) + "X" + TemptheAnswer.substring(index + 1, 5); // Sati olan harfler X yapiliyorki tekrar kontrol edilmesin
						BoxArr[VerPos][j].setIcon(yellowsq); // Kosulu saglayan harf kutulari sari yapiliyor
						break;
					}
				}

			}
			for(int i =0; i < 5; i++) {
				if(BoxArr[VerPos][i].getIcon() == blanksq) {
					BoxArr[VerPos][i].setIcon(greysq);
				}
			}
			if(VerPos == 5) {
				Lost++;
				v = 6;
				//System.out.println(nextGuess + "-" + possibleWords.size());
				break;
			}
			//System.out.println("Y--------------------------------------------------------------------P");
			YapayZeka();
			//.out.println("Y--------------------------------------------------------------------P");
			nextGuess = RecWord;
			VerPos++;
		}
		
		
		//System.out.println("W-L-P   " + Win + "-" + Lost + "-" + (Win + Lost));

	}
	int delay = 4;
	void goInsane() {
		isInsane = true;
		Timer myTimer = new Timer();
		TimerTask gorev = new TimerTask() {
			int s = 0;
			int g = 0;
			float newWin = 0;
			int oldWin = 0;
			@Override
			public void run() {
				String st = kelimeler.get(g); //Starting Word
				String ans = kelimeler.get(s); // Answer
				//st = "";
				//ans = "KAÇAK";
				s++;
				goingInsane(st, ans);
				//(s == kelimeler.size())
				if(s == kelimeler.size()) {
					newWin = Win - oldWin;
					oldWin = Win;
					float Perct = (newWin * 100)/1666;
					Perct = (float) (Math.floor(Perct * 100) / 100);
					System.out.println(st + "-" + newWin + " %" + Perct); //st yap
					g++;
					s = 0;
				}
				if(g == kelimeler.size()) {
					System.out.println(Win + "-" + Lost + "-" + (Win + Lost));
					myTimer.cancel();
					myTimer.purge();
				}
			}
		};
		myTimer.schedule(gorev, 0, delay); //delay = 1 milisaniye = 0.001 saniye
		
	}

	void clearBoard() { // $ 423-438 arasi oyun ekranini temizleyip yeni oyun baslatip yeni kelime vermek icin
		defLetters.clear();
		possibleWords.clear();
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 5; j++) {
				BoxArr[i][j].setIcon(blanksq); // Kutulari bos yapiyor
				LabelArr[i][j].setText(""); // Kutu iclerindeki harfleri siliyor
			}
		}
		Random random = new Random();
		Answer = kelimeler.get(random.nextInt(kelimeler.size())); // Yeni kelime veriliyor
		PWCount.setText(Integer.toString(kelimeler.size()));
		VerPos = 0;
		HorPos = 0;
		gonnaRestart = true;
	}
	public int WordCheck(String Answer, String Guess, int VerPos) { // $ 439-728 arasi kullanicinin girdigi kelimeyi kontrol etmek icin
		//Answer = "KAÇAK"; //Cevap manuel olarak buradan atanabilir.
		Answer.toUpperCase();
		Guess.toUpperCase();
		//System.out.println("RW: " + RecWord);
		try { //443-459 arasi hesaplamalar icin istatislikleri almak icin
			File TotalGames = new File("TotalGames.txt");
			Scanner scan2 = new Scanner(TotalGames);
			TotalGame = scan2.nextInt();
			File TotalWins = new File("TotalWin.txt");
			Scanner scan = new Scanner(TotalWins);
			TotalWin = scan.nextInt();
			File HighStreak = new File("HighStreak.txt");
			Scanner scan3 = new Scanner(HighStreak);
			CurrentHighStreak = scan3.nextInt();
			File WinPercentageFile = new File("WinPercentage.txt");
			Scanner scan4 = new Scanner(WinPercentageFile);
			WinPercentage = scan4.nextInt();
		}
		catch (Exception e) {
			
		}
		try { // 460-475 arasi istatistik ekranı için istatistik degerlerini almak icin
			File Stats = new File("Stats.txt");
			FileWriter StatsWriter = new FileWriter(Stats);
			BufferedWriter bw = new BufferedWriter(StatsWriter);
			bw.write(Integer.toString(WinPercentage));
			bw.newLine();
			bw.write(Integer.toString(TotalGame));
			bw.newLine();
			bw.write(Integer.toString(Streaks));
			bw.newLine();
			bw.write(Integer.toString(CurrentHighStreak));
			bw.close();
			
		}
		catch (Exception e) {
		}
		for (int i = 0; i < 5; i++) {
			if (BoxArr[VerPos][i].getIcon() == filledsq) { // Harf yazili olan kutunun rengini degistirmek icin
				LabelArr[VerPos][i].setForeground(new Color(210,210,210));
			}
		}

		//System.out.println("Guess1 " + Guess); 
		if (Guess.equalsIgnoreCase(Answer)) { // Tahminin cevap ile ayni olup olmadigina bakmak icin
			BoxArr[VerPos][0].setIcon(greensq); // 484-489 arasi harflerin kutularini yesil yapmak icin
			BoxArr[VerPos][1].setIcon(greensq);
			BoxArr[VerPos][2].setIcon(greensq);
			BoxArr[VerPos][3].setIcon(greensq);
			BoxArr[VerPos][4].setIcon(greensq);
			int result = JOptionPane.showConfirmDialog(null, "Tebrikler kelimeyi dogru tahmin ettiniz, yeniden oynamak ister misiniz?"," Oyun Sonu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // Oyun bittiginde secenek paneli acmak icin
			if (result == JOptionPane.YES_OPTION) { // eger kullanıcı evet secmisse
				try { // 491-525 arasi istatislikleri guncelleyip texr dosyasi uzerinde degisim yapmak icin
					File TotalWins = new File("TotalWin.txt");
					Scanner scan = new Scanner(TotalWins);
					TotalWin = scan.nextInt();
				}
				catch(Exception s) {
					
				}
				TotalWin = TotalWin + 1;
				try {
					File TotalWins = new File("TotalWin.txt");
					FileWriter TotalWinsWriter = new FileWriter("TotalWin.txt");
					String Score = Integer.toString(TotalWin);
					TotalWinsWriter.write(Score);
					TotalWinsWriter.close();
				}
				catch (Exception p) {
					
				}
				try {
					File Streak = new File("Streak.txt");
					File TotalGames = new File("TotalGames.txt");
					Scanner scan = new Scanner(Streak);
					Scanner scan2 = new Scanner(TotalGames);
					while(scan.hasNext() && scan2.hasNext()) {
						TotalGame = scan2.nextInt();
						 Streaks = scan.nextInt();
					}

				}
				catch (Exception e) {
					
				}
				TotalGame = TotalGame + 1;
				Streaks = Streaks + 1;
				if (Streaks > CurrentHighStreak) { // Eger guncel art arda olan dogru tahmin sayısının en yuksek tahminden buyuk olup olmadigina bakiyor. Buyukse en yuksek degerini degisiyor
					CurrentHighStreak = Streaks;
					try { // 528-572 arasi istatislikleri guncellemek ve text dosyasi uzerinde degismek icin
						File HighStreak = new File("HighStreak.txt");
						FileWriter HighStreakWriter = new FileWriter("HighStreak.txt");
						String Score3 = Integer.toString(CurrentHighStreak);
						HighStreakWriter.write(Score3);
						HighStreakWriter.close();
					}
					catch (Exception e) {
						
					}
				}
				try {
					File Streak = new File("Streak.txt");
					File TotalGames = new File("TotalGames.txt");
					FileWriter StreakWriter = new FileWriter("Streak.txt");
					FileWriter TotalGameWriter = new FileWriter("TotalGames.txt");
					String Score = Integer.toString(Streaks);
					String Score2 = Integer.toString(TotalGame);
					StreakWriter.write(Score);
					TotalGameWriter.write(Score2);
					StreakWriter.close();
					TotalGameWriter.close();
				}
				catch (Exception e) {
					
				}
				try {
					File WinPercentageFile = new File("WinPercentage.txt");
					Scanner scan = new Scanner(WinPercentageFile);
					WinPercentage = scan.nextInt();
				}
				catch (Exception t) {
					
				}
				WinPercentage = (100 * TotalWin) / TotalGame;
				try {
					File WinPercentageFile = new File("WinPercentage.txt");
					FileWriter	WinPercentageWriter = new FileWriter("WinPercentage.txt");
					String Score = Float.toString(WinPercentage);
					WinPercentageWriter.write(Score);
					WinPercentageWriter.close();
				}
				catch (Exception c) {
					
				}
				try { // 573-588 arasi istatistik ekrani icin bilgileri aliyor
					File Stats = new File("Stats.txt");
					FileWriter StatsWriter = new FileWriter(Stats);
					BufferedWriter bw = new BufferedWriter(StatsWriter);
					bw.write(Integer.toString(WinPercentage));
					bw.newLine();
					bw.write(Integer.toString(TotalGame));
					bw.newLine();
					bw.write(Integer.toString(Streaks));
					bw.newLine();
					bw.write(Integer.toString(CurrentHighStreak));
					bw.close();
					
				}
				catch (Exception e) {
				}
				clearBoard();
				return 2;

			}
			else if (result == JOptionPane.NO_OPTION) { // kullanici hayiri secerse
				dispose();
				return 2;
			}
			else { // kullanici secenek ekranini kapatirsa
				dispose();
				return 2;
			}
		}
		for (int i = 0; i < 5; i++) { // 602-680 arasi tahmin kelimesinin harfleri ile cevap kelimesinin harflerini kiyaslamak icin
			AnswerLetters[i] = Answer.charAt(i); // Cevabin harflerini almak icin
			TempAnswerLetters[i] = Answer.charAt(i); // Gecici cevap harfleri icin
			GuessLetters[i] = Guess.charAt(i); // Tahmin kelimesinin harfleri icin
			if (Character.toString(AnswerLetters[i]).equals(Character.toString(GuessLetters[i]))) { // Tahmin icindeki yesil harfleri tekrar kontrol etmemesi icin X Yapiliyor
				BoxArr[VerPos][i].setIcon(greensq);
				TempAnswerLetters[i] = 'X';
			}
		}
		String TempAnswer = ""; // Gecici cevap kelimesi icin
		for(int z = 0; z < 5; z++) { // Gecici cevap kelimesini olusturmak icin
			TempAnswer += Character.toString(TempAnswerLetters[z]);
		}
		for (int j = 0; j < 5; j++) {
			for(int i = 0; i < 5; i++) {
				if (TempAnswer.contains(Character.toString(GuessLetters[j]).toUpperCase(Locale.forLanguageTag("tr-TR"))) && BoxArr[VerPos][j].getIcon() != greensq) {
					try { // 618-635 arasi istatislikleri almak ve kazanma oranimi hesaplamak icin
						File TotalGames = new File("TotalGames.txt");
						Scanner scan2 = new Scanner(TotalGames);
						TotalGame = scan2.nextInt();
						File TotalWins = new File("TotalWin.txt");
						Scanner scan = new Scanner(TotalWins);
						TotalWin = scan.nextInt();
						File HighStreak = new File("HighStreak.txt");
						Scanner scan3 = new Scanner(HighStreak);
						CurrentHighStreak = scan3.nextInt();
						File WinPercentageFile = new File("WinPercentage.txt");
						Scanner scan4 = new Scanner(WinPercentageFile);
						WinPercentage = scan4.nextInt();
					}
					catch(Exception s) {
						
					}
					WinPercentage = (100 * TotalWin) / TotalGame;
					String Letter = Character.toString(GuessLetters[j]); // Tahmin kelimesinin harflerininin kontrolunu kolaylastirmak icin
					int index = TempAnswer.indexOf(Letter.toUpperCase(), 0); // Ust tafata bukunan kelimenin indeksini bulmak icin
					TempAnswer = TempAnswer.substring(0,index) + "X" + TempAnswer.substring(index + 1, 5); // Sati olan harfler X yapiliyorki tekrar kontrol edilmesin
					BoxArr[VerPos][j].setIcon(yellowsq); // Kosulu saglayan harf kutulari sari yapiliyor
					try { //640-655 arasi istatistik ekrani icin 
						File Stats = new File("Stats.txt");
						FileWriter StatsWriter = new FileWriter(Stats);
						BufferedWriter bw = new BufferedWriter(StatsWriter);
						bw.write(Integer.toString(WinPercentage));
						bw.newLine();
						bw.write(Integer.toString(TotalGame));
						bw.newLine();
						bw.write(Integer.toString(Streaks));
						bw.newLine();
						bw.write(Integer.toString(CurrentHighStreak));
						bw.close();
						
					}
					catch (Exception e) {
					}
					break;
				}
			}

		}

		try { // 662-678 İstatistik ekrani icin
			File Stats = new File("Stats.txt");
			FileWriter StatsWriter = new FileWriter(Stats);
			BufferedWriter bw = new BufferedWriter(StatsWriter);
			bw.write(Integer.toString(WinPercentage));
			bw.newLine();
			bw.write(Integer.toString(TotalGame));
			bw.newLine();
			bw.write(Integer.toString(Streaks));
			bw.newLine();
			bw.write(Integer.toString(CurrentHighStreak));
			bw.close();
			
		}
		catch (Exception e) {
		}
		WinPercentage = (100 * TotalWin) / TotalGame;
		for (int i = 0; i < 5; i++) { // Gri kutularin kontrolü
			if (BoxArr[VerPos][i].getIcon() == filledsq) { //  kutunun rengi sari veya yesil olup olmadigina bakiyor 
				try { // 681-718 arasi istatistik güncellemesi hesaplamasi ve istatistik ekrani icin
					File TotalGames = new File("TotalGames.txt");
					Scanner scan2 = new Scanner(TotalGames);
					TotalGame = scan2.nextInt();
					File TotalWins = new File("TotalWin.txt");
					Scanner scan = new Scanner(TotalWins);
					TotalWin = scan.nextInt();
					File HighStreak = new File("HighStreak.txt");
					Scanner scan3 = new Scanner(HighStreak);
					CurrentHighStreak = scan3.nextInt();
					File WinPercentageFile = new File("WinPercentage.txt");
					Scanner scan4 = new Scanner(WinPercentageFile);
					WinPercentage = scan4.nextInt();
				}
				catch(Exception et) {
					
				}
				try {
					File WinPercentageFile = new File("WinPercentage.txt");
					FileWriter	WinPercentageWriter = new FileWriter("WinPercentage.txt");
					String Score = Float.toString(WinPercentage);
					WinPercentageWriter.write(Score);
					WinPercentageWriter.close();
					File Stats = new File("Stats.txt");
					FileWriter StatsWriter = new FileWriter(Stats);
					BufferedWriter bw = new BufferedWriter(StatsWriter);
					bw.write(Integer.toString(WinPercentage));
					bw.newLine();
					bw.write(Integer.toString(TotalGame));
					bw.newLine();
					bw.write(Integer.toString(Streaks));
					bw.newLine();
					bw.write(Integer.toString(CurrentHighStreak));
					bw.close();
				}
				catch (Exception c) {
					
				}
				BoxArr[VerPos][i].setIcon(greysq); // Kutu Gri yapiliyor
			}
		}
		return 0;
	}
	
	public void keyboardInput(JButton but) { // $ 725-748 arasi keyListener ile birebir ayni 
		if(but == DelBut && HorPos > 0 && VerPos < 6) {
			HorPos -= 1;
			BoxArr[VerPos][HorPos].setIcon(blanksq);
			if(ShowHint == true && VerPos > 0) {
				LabelArr[VerPos][HorPos].setForeground(sqtColorR);
				LabelArr[VerPos][HorPos].setText(RecWord.substring(HorPos, HorPos + 1));
			}
			else {
				LabelArr[VerPos][HorPos].setText("");
			}
			wholeword = wholeword.substring(0, wholeword.length() - 1);
		}
		else if (HorPos < 5 && but != DelBut && VerPos < 6) {
			LabelArr[VerPos][HorPos].setText(but.getText()); // Butonun ustunnde yazan texti alip LabelArr[VerPos][HorPos] pozisyonundaki sqt'nin textine atiyor.
			wholeword = wholeword + but.getText(); //satirdaki harfleri tek bir kelimede topluyor. kelime kontrolunde kullanmak icin var.
			LabelArr[VerPos][HorPos].setForeground(sqtColorW);
			if(BoxArr[VerPos][HorPos].getIcon() == blanksq) {
				BoxArr[VerPos][HorPos].setIcon(filledsq);
			}
			
			HorPos += 1;
		}
	}
	
	public void addBut(JButton button) { // $ Frame ustundeki Klavye butonlari icin
		button.addActionListener(e -> keyboardInput(button));
		button.setFont(new Font("Sherif", Font.BOLD, 28));
		button.setFocusable(false);
		button.setBackground(new Color(40,40,40));
		button.setForeground(sqtColorW);
		button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		keyboardPanel.add(button);
	}
	public void freeButton(JButton button, ImageIcon icon) { // $ Paneldeki basi bos butonlar icin
		button.addActionListener(this);
		button.setFocusable(false);
		button.setIcon(icon);
		button.setBackground(new Color(40,40,40));
		button.setForeground(sqtColorW);
		button.setBorder(BorderFactory.createRaisedBevelBorder());
		button.setFont(new Font("Sherif", Font.BOLD, 18));
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		
		windowPanel.add(button);
	}
	public void addSquare(JLabel sq, JLabel sqt, int x, int y) { // $ Kutular icin
		windowPanel.add(sq);
		windowPanel.add(sqt, JLayeredPane.PALETTE_LAYER);
		sq.setIcon(blanksq);
		sq.setBounds(x + 18,y + 15,120,120);
		sq.setVisible(true);
		
		sqt.setText("");
		sqt.setForeground(sqtColorW);
		sqt.setBounds(x + 18,y + 18,120,120);
		sqt.setFont(new Font("Arial", Font.BOLD, 96));
		sqt.setHorizontalAlignment(JLabel.CENTER);	
	}
	public void resetGame() { // $ Oyunu resetlemek icin
		int result = JOptionPane.showConfirmDialog(null, "Yeni Kelime istedigine emin misin?"," Yeni Kelime", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // Kullanıcıya yeni kelime isteyip istenmedigi soruluyor
		if (result == JOptionPane.YES_OPTION) { // Eger evet secilirse
			try { // 791-870 arasi istatislikleri alma, guncelleme ve istatistik ekrani icin
				File TotalGames = new File("TotalGames.txt");
				Scanner scan2 = new Scanner(TotalGames);
				while(scan2.hasNext()) {
					TotalGame = scan2.nextInt();
				}

			}
			catch (Exception e) {
				
			}
			TotalGame = TotalGame + 1;
			Streaks = 0;
			try {
				File Streak = new File("Streak.txt");
				File TotalGames = new File("TotalGames.txt");
				FileWriter StreakWriter = new FileWriter("Streak.txt");
				FileWriter TotalGameWriter = new FileWriter("TotalGames.txt");
				String Score = Integer.toString(Streaks);
				String Score2 = Integer.toString(TotalGame);
				StreakWriter.write(Score);
				TotalGameWriter.write(Score2);
				StreakWriter.close();
				TotalGameWriter.close();
			}
			catch (Exception e) {
				
			}
			try {
				File TotalGames = new File("TotalGames.txt");
				Scanner scan2 = new Scanner(TotalGames);
				TotalGame = scan2.nextInt();
				File TotalWins = new File("TotalWin.txt");
				Scanner scan = new Scanner(TotalWins);
				TotalWin = scan.nextInt();
				File HighStreak = new File("HighStreak.txt");
				Scanner scan3 = new Scanner(HighStreak);
				CurrentHighStreak = scan3.nextInt();
				File WinPercentageFile = new File("WinPercentage.txt");
				Scanner scan4 = new Scanner(WinPercentageFile);
				WinPercentage = scan4.nextInt();
			}
			catch(Exception s) {
				
			}
			WinPercentage = (100* TotalWin)/TotalGame;
			try {
				File WinPercentageFile = new File("WinPercentage.txt");
				FileWriter	WinPercentageWriter = new FileWriter("WinPercentage.txt");
				String Score = Integer.toString(WinPercentage);
				WinPercentageWriter.write(Score);
				WinPercentageWriter.close();
			}
			catch (Exception c) {
				
			}
			try {
				File HighStreak = new File("HighStreak.txt");
				Scanner scan = new Scanner(HighStreak);
				CurrentHighStreak = scan.nextInt();
			}
			catch (Exception et) {
				
			}
			try {
				File Stats = new File("Stats.txt");
				FileWriter StatsWriter = new FileWriter(Stats);
				BufferedWriter bw = new BufferedWriter(StatsWriter);
				bw.write(Integer.toString(WinPercentage));
				bw.newLine();
				bw.write(Integer.toString(TotalGame));
				bw.newLine();
				bw.write(Integer.toString(Streaks));
				bw.newLine();
				bw.write(Integer.toString(CurrentHighStreak));
				bw.close();
				
			}
			catch (Exception e) {
			}
			possibleWords.clear(); // olasi kelimeler 0 laniyor
			defLetters.clear(); // kesin kelimeler 0 laniyor
			clearBoard(); // Frame temizleniyor
			gonnaRestart = false;
		}
		else if (result == JOptionPane.NO_OPTION) { // Kullanici hayir secerse
		}
		else { // Kullanici bir sey secmezse
			dispose();
		}
	}
	void showStats() { // $ İstatistik ekrani icin
		new statFrame();
	}
	void showHint() { // $
		ShowHint = !ShowHint;
		if(ShowHint) {
			PWCount.setVisible(true);
			BotBut.setIcon(botIcon);
			
			if(VerPos < 5 && VerPos > 0) {
				for(int i = 0; i < 5; i ++) {
					if(BoxArr[VerPos][i].getIcon() == blanksq) {
						//System.out.println(RecWord);
						LabelArr[VerPos][i].setText(RecWord.substring(i, i + 1));
						LabelArr[VerPos][i].setForeground(sqtColorR);
					}
				}
			}
			
		}
		else {
			PWCount.setVisible(false);
			BotBut.setIcon(new ImageIcon("icons/DeBot.png"));
			for(int i = 0; i < 5; i ++) {
				if(BoxArr[VerPos][i].getIcon() == blanksq) {
					LabelArr[VerPos][i].setText("");
				}
			}
		}
	}
	

	
	boolean isKeysVisible = false;
	boolean DarkMode = true;
	
	gameFrame(){ // $ Frame icin
		setFocusable(true);
		getList();
		//GUI KISMI vvv
		windowPanel.setPreferredSize(new Dimension(652,804));
		this.setIconImage(FrameIcon.getImage());
		viewKeyboard.setBounds(169, 794, 314, 9);
		resetBut.setBounds(528, 759, 96, 32);
		lightSwitch.setBounds(21,757,32,32);
		EntBut.setBounds(198, 764, 256, 24);
		StatBut.setBounds(59, 757, 33, 33);
		BotBut.setBounds(96, 758, 33, 33);
		OtoBut.setBounds(478, 757, 33, 33);
		
		PWCount.setForeground(sqtColorW);
		PWCount.setBounds(128,758,64,32);
		PWCount.setFont(new Font("Arial", Font.BOLD, 16));
		
		keyboardPanel.setLayout(new GridLayout(3,10,3,3));
		keyboardPanel.setBackground(new Color(100,100,100));
		keyboardPanel.setBounds(41, 804, 570, 170);
		for(int i = 0; i < ButArr.length; i++) {
			addBut(ButArr[i]);
		}
		
		DelBut.setText("<--");
		
		freeButton(viewKeyboard, line);
		freeButton(resetBut, resArrow);
		freeButton(lightSwitch, light);
		freeButton(EntBut, null);
		freeButton(StatBut, statDark);
		freeButton(BotBut, botIcon);
		freeButton(OtoBut, botPerc);
		
		EntBut.setVisible(false);
		EntBut.setBorderPainted(true);
		EntBut.setContentAreaFilled(true);
		UIManager.put( "Button.select", Color.BLACK );
		
		windowPanel.add(keyboardPanel);
		windowPanel.add(PWCount);
		
		showHint();
		resetBut.addActionListener(e -> resetGame());
		StatBut.addActionListener(e -> showStats());
		BotBut.addActionListener(e -> showHint());
		OtoBut.addActionListener(e -> goInsaneWarning()); 
		
		int gap = 4;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 5; j++) {
				addSquare(BoxArr[i][j], LabelArr[i][j], j*120 + (j*gap),i*120 + (i*gap));
			}
		}
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.addKeyListener(this);
		this.getContentPane().add(windowPanel);
		this.getContentPane().setBackground(new Color(22, 22, 22));
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	public void goInsaneWarning() {
		JOptionPane.showMessageDialog(null, "Bu tuş veri toplamak için yapılmıştır her kelimenin doğruluk oranını veriyor CPU düşük olan kişilerin çalıştırılması önerilmez programın durması için editörü kapatmalısınız", "Uyarı", 0, null);
		int result = JOptionPane.showConfirmDialog(null, "Bot istatistik sınamasını aktive etmek istiyor musunuz?"," Uyarı", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(result == JOptionPane.YES_OPTION) {
			goInsane();
		}
		if(result == JOptionPane.NO_OPTION) {
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) { // $ Burasi keyListener ile kuruldu klavyeden girilen inputlari almak icin. 
		if(e.getKeyChar() == 8 && HorPos > 0 && VerPos < 6 && e.getKeyChar() != 10 && e.getKeyChar() != 32) { // Delete tusuna basilip basilmadigina bakiyor
			HorPos -= 1; // Yatay pozisyonu 1 azaltiyor
			BoxArr[VerPos][HorPos].setIcon(blanksq); // Kutunun sembolunu bos kutu yapiyor
			if(ShowHint == true && VerPos > 0) {
				LabelArr[VerPos][HorPos].setForeground(sqtColorR);
				LabelArr[VerPos][HorPos].setText(RecWord.substring(HorPos, HorPos + 1));
			}
			else {
				LabelArr[VerPos][HorPos].setText(""); // Kutu icindeki text'i bos yapiyor
			}
			wholeword = wholeword.substring(0, wholeword.length() - 1); // Tum kelimenin son karakterini siliyor
		}
		if (HorPos < 5 && e.getKeyCode() != 8 && VerPos < 6 && e.getKeyChar() != 10 && e.getKeyChar() != 32 && e.getKeyChar() != 8) { // Enter veya delete tusuna basilip basilmadgina bakiyor
			LabelArr[VerPos][HorPos].setText(Character.toString(e.getKeyChar())); // Butonun ustunde yazan harfi klavyeden girilen harf yapiyor
			wholeword = wholeword + Character.toString(e.getKeyChar()).toUpperCase(Locale.forLanguageTag("tr-TR")); //Tum kelimeye klavyeden girilen harfi ekliyor
			if(BoxArr[VerPos][HorPos].getIcon() == blanksq) { // Kutunun sembolunu degisiyor
				LabelArr[VerPos][HorPos].setForeground(sqtColorW);
				BoxArr[VerPos][HorPos].setIcon(filledsq);
				LabelArr[VerPos][HorPos].setText(LabelArr[VerPos][HorPos].getText().toUpperCase(Locale.forLanguageTag("tr-TR")));
				HorPos += 1; // Yatay pozisyonu 1 artiriyor
			}
		}
		if (e.getKeyChar() == 10 && HorPos == 5 && VerPos <= 5){ // Enter tusuna basilip basilmadigina bakiyor
			if (allkelimeler.contains(wholeword.toUpperCase())) { // Sacma sapan kelimeler girilmemesi icin
				int sonuc = WordCheck(Answer, wholeword, VerPos); // Kelime kontrol fonksiyonu cagriliyor
				HorPos = 0; // Yatay pozisyon 0 laniyor
				YapayZeka(); // Bot calisiyor
				//System.out.println(gonnaRestart);
				if(gonnaRestart == false) { // Oyun restart edildiginde +1 bugi duzelsin diye kurulu
					VerPos +=1;
				}
				gonnaRestart = false;
				wholeword = ""; // Tum kelime 0 laniyor
				if (VerPos == 6 && sonuc != 2) { // Tahmin haklari biterse
					String word = Answer;
					possibleWords.clear(); // Olasi kelimeler 0'laniyor
					defLetters.clear(); // Kesin kelimeler 0'laniyor
					word = word.substring(0 , 1) + word.substring(1, 5).toLowerCase(); // Cevabi yazdrimak icin
					JOptionPane.showInternalMessageDialog(null, "Dogru Cevap:" + word); // Dogru cevabi söylemek icin
					int result = JOptionPane.showConfirmDialog(null, "Butunn haklarini kullandin, yeniden oynamak ister misin?"," Oyun Sonu :(", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // Evet veya hayir secim kutusu aciliyor
					if (result == JOptionPane.YES_OPTION) { // Evet secilirse
						try { // 1022-1088 arasi istatislikler ve ekrani icin
							File TotalGames = new File("TotalGames.txt");
							Scanner scan2 = new Scanner(TotalGames);
							while(scan2.hasNext()) {
								TotalGame = scan2.nextInt();
							}

						}
						catch (Exception t) {
							
						}
						TotalGame = TotalGame + 1;
						Streaks = 0;
						try {
							File Streak = new File("Streak.txt");
							File TotalGames = new File("TotalGames.txt");
							FileWriter StreakWriter = new FileWriter("Streak.txt");
							FileWriter TotalGameWriter = new FileWriter("TotalGames.txt");
							String Score = Integer.toString(Streaks);
							String Score2 = Integer.toString(TotalGame);
							StreakWriter.write(Score);
							TotalGameWriter.write(Score2);
							StreakWriter.close();
							TotalGameWriter.close();
						}
						catch (Exception t) {
							
						}
						try {
							File TotalWins = new File("TotalWin.txt");
							Scanner scan = new Scanner(TotalWins);
							TotalWin = scan.nextInt();
							File WinPercentageFile = new File("WinPercentage.txt");
							Scanner scan2 = new Scanner(WinPercentageFile);
							WinPercentage = scan2.nextInt();
						}
						catch(Exception s) {
							
						}
						WinPercentage = (100* TotalWin)/TotalGame;
						try {
							File WinPercentageFile = new File("WinPercentage.txt");
							FileWriter	WinPercentageWriter = new FileWriter("WinPercentage.txt");
							String Score = Float.toString(WinPercentage);
							WinPercentageWriter.write(Score);
							WinPercentageWriter.close();
						}
						catch (Exception c) {
							
						}
						try {
							File Stats = new File("Stats.txt");
							FileWriter StatsWriter = new FileWriter(Stats);
							BufferedWriter bw = new BufferedWriter(StatsWriter);
							bw.write(Integer.toString(WinPercentage));
							bw.newLine();
							bw.write(Integer.toString(TotalGame));
							bw.newLine();
							bw.write(Integer.toString(Streaks));
							bw.newLine();
							bw.write(Integer.toString(CurrentHighStreak));
							bw.close();
							
						}
						catch (Exception et) {
							
						}
						clearBoard(); // Frame Temizleniyor
						gonnaRestart = false;
					}
					else if (result == JOptionPane.NO_OPTION) { // Hayir secilirse
						dispose();
					}
					else { // Bir sey secilmezse
						dispose();
					}
				}
			}
			else {
				JOptionPane.showInternalMessageDialog(null, "Böyle bir kelime yok!!!");
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void actionPerformed(ActionEvent e) { // $ Butonlarin aksiyonlari icin
		if(e.getSource() == EntBut && HorPos == 5  && VerPos <= 5) { // keyListener icindeki Enter tusnun fonksiyonu ile ayni
			if (allkelimeler.contains(wholeword.toUpperCase())) {
				int sonuc = WordCheck(Answer, wholeword, VerPos);
				HorPos = 0;
				YapayZeka();
				System.out.println(gonnaRestart);
				if(gonnaRestart == false) {
					VerPos +=1;
				}
				gonnaRestart = false;
				wholeword = "";
				if (VerPos == 6 && sonuc != 2) {
					String word = Answer;
					word = word.substring(0 , 1) + word.substring(1, 5).toLowerCase();
					JOptionPane.showInternalMessageDialog(null, "DoĞru Cevap:" + word);
					int result = JOptionPane.showConfirmDialog(null, "Bütün haklarini kullandın, yeniden oynamak ister misin?"," Oyun Sonu :(", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						try {
							File TotalGames = new File("TotalGames.txt");
							Scanner scan2 = new Scanner(TotalGames);
								TotalGame = scan2.nextInt();

						}
						catch (Exception t) {
							
						}
						TotalGame = TotalGame + 1;
						Streaks = 0;
						try {
							File Streak = new File("Streak.txt");
							File TotalGames = new File("TotalGames.txt");
							FileWriter StreakWriter = new FileWriter("Streak.txt");
							FileWriter TotalGameWriter = new FileWriter("TotalGames.txt");
							String Score = Integer.toString(Streaks);
							String Score2 = Integer.toString(TotalGame);
							StreakWriter.write(Score);
							TotalGameWriter.write(Score2);
							StreakWriter.close();
							TotalGameWriter.close();
						}
						catch (Exception t) {
							
						}
						try {
							File TotalGames = new File("TotalGames.txt");
							Scanner scan2 = new Scanner(TotalGames);
							TotalGame = scan2.nextInt();
							File TotalWins = new File("TotalWin.txt");
							Scanner scan = new Scanner(TotalWins);
							TotalWin = scan.nextInt();
							File HighStreak = new File("HighStreak.txt");
							Scanner scan3 = new Scanner(HighStreak);
							CurrentHighStreak = scan3.nextInt();
							File WinPercentageFile = new File("WinPercentage.txt");
							Scanner scan4 = new Scanner(WinPercentageFile);
							WinPercentage = scan4.nextInt();
						}
						catch(Exception s) {
							
						}
						WinPercentage = (100 * TotalWin)/ TotalGame ;
						try {
							File Stats = new File("Stats.txt");
							FileWriter StatsWriter = new FileWriter(Stats);
							BufferedWriter bw = new BufferedWriter(StatsWriter);
							bw.write(Integer.toString(WinPercentage));
							bw.newLine();
							bw.write(Integer.toString(TotalGame));
							bw.newLine();
							bw.write(Integer.toString(Streaks));
							bw.newLine();
							bw.write(Integer.toString(CurrentHighStreak));
							bw.close();
							
						}
						catch (Exception et) {
							
						}
						//dispose();
						clearBoard();
						gonnaRestart = false;
						//new gameFrame();
					}
					else if (result == JOptionPane.NO_OPTION) {
						dispose();
					}
					else {
						dispose();
					}
				}
			}
			else {
				JOptionPane.showInternalMessageDialog(null, "Böyle bir kelime yok!!!");
			}
		}
		
		
		if(e.getSource() == viewKeyboard) { // Frame ustundeki klavyeyi acip kapamak icin
			isKeysVisible = !isKeysVisible;
			if(isKeysVisible == true) {
				windowPanel.setPreferredSize(new Dimension(652,990));
				EntBut.setVisible(true);
				this.pack();
			}
			else {
				windowPanel.setPreferredSize(new Dimension(652,804));
				EntBut.setVisible(false);
				this.pack();
			}
		}
		if(e.getSource() == lightSwitch) { // Karanlik ve aydinlik mod icin butonlarin renklerini degisiyor
			DarkMode = !DarkMode;
			if(DarkMode == true) {
				this.getContentPane().setBackground(new Color(22, 22, 22));
				sqtColorW = new Color(210,210,210);
				sqtColorR = new Color(72,72,72);
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 5; j++) {
						if(BoxArr[i][j].getIcon() == blanksq) {
							LabelArr[i][j].setForeground(sqtColorR);
						}
						else {
							LabelArr[i][j].setForeground(sqtColorW);
						}
						
					}
				}
				for(int i = 0; i < ButArr.length; i++) {
					ButArr[i].setBackground(new Color(40,40,40));
					ButArr[i].setForeground(sqtColorW);
				}
				PWCount.setForeground(sqtColorW);
				EntBut.setBackground(new Color(40,40,40));
				EntBut.setForeground(sqtColorW);
				UIManager.put( "Button.select", Color.BLACK);
				lightSwitch.setIcon(light);
				StatBut.setIcon(statDark);
			}
			else {
				this.getContentPane().setBackground(new Color(240, 240, 240));
				sqtColorW = new Color(36,36,36);
				sqtColorR = new Color(152,152,152);
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 5; j++) {
						if(BoxArr[i][j].getIcon() == filledsq || BoxArr[i][j].getIcon() == blanksq) {
							if(BoxArr[i][j].getIcon() == blanksq) {

								LabelArr[i][j].setForeground(sqtColorR);
							}
							else {
								LabelArr[i][j].setForeground(sqtColorW);
							}
						}
					}
				}
				
				for(int i = 0; i < ButArr.length; i++) {
					ButArr[i].setBackground(new Color(230,230,230));
					ButArr[i].setForeground(new Color(40,40,40));
				}
				PWCount.setForeground(sqtColorW);
				EntBut.setBackground(new Color(230,230,230));
				EntBut.setForeground(new Color(40,40,40));
				UIManager.put( "Button.select", Color.WHITE);
				lightSwitch.setIcon(dark);
				StatBut.setIcon(statLight);
				
			}
		}
	}
	
}
