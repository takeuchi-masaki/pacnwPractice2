import java.util.Scanner;

public class Tongues {

	public static void main(String[] args) {
		Tongues t = new Tongues();
		t.run();
	}
	void run() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			String print="";
			for(char c: s.toCharArray()) {
				if(!Character.isAlphabetic(c)) {
					print+=c;
				} else {
					print += dec(c);
				}
			}
			System.out.println(print);
		}
		sc.close();
	}

	char dec(char c) {
		boolean u = Character.isUpperCase(c);
		char ret;
		switch(Character.toLowerCase(c)) {
		case 'a':
			ret = 'e';
			break;
		case 'i':
			ret = 'o';
			break;
		case 'y':
			ret = 'u';
			break;
		case 'e':
			ret = 'a';
			break;
		case 'o':
			ret = 'i';
			break;
		case 'u':
			ret = 'y';
			break;

		case 'b':
			ret = 'p';
			break;
		case 'k':
			ret = 'v';
			break;
		case 'x':
			ret = 'j';
			break;
		case 'z':
			ret = 'q';
			break;
		case 'n':
			ret = 't';
			break;
		case 'h':
			ret = 's';
			break;
		case 'd':
			ret = 'r';
			break;
		case 'c':
			ret = 'l';
			break;
		case 'w':
			ret = 'm';
			break;
		case 'g':
			ret = 'f';
			break;
		case 'p':
			ret = 'b';
			break;
		case 'v':
			ret = 'k';
			break;
		case 'j':
			ret = 'x';
			break;
		case 'q':
			ret = 'z';
			break;
		case 't':
			ret = 'n';
			break;
		case 's':
			ret = 'h';
			break;
		case 'r':
			ret = 'd';
			break;
		case 'l':
			ret = 'c';
			break;
		case 'm':
			ret = 'w';
			break;
		case 'f':
			ret = 'g';
			break;
		default:
			ret = ' ';
		}
		return (u?Character.toUpperCase(ret):ret);
	}

}
