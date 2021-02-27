
import java.util.Scanner;

public class goodEvil {
	public static void main(String[] args) {
		goodEvil g = new goodEvil();
		g.run();
	}
	void run(){
		Scanner sc = new Scanner(System.in);
		int battles = sc.nextInt();
		for(int i = 0; i < battles; i++) {
			int goodSum = 0;
			int badSum = 0;
			for(int j = 0; j < 6; j++) {
				int temp = sc.nextInt();
				goodSum+=good(j)*temp;
			}
			for(int j = 0; j < 7; j++) {
				int temp = sc.nextInt();
				badSum+=bad(j)*temp;
			}
			String message = "Battle " + (i+1) + ": ";
			if(goodSum > badSum) {
				message+="Good triumphs over Evil";
			} else if(goodSum < badSum) {
				message+="Evil eradicates all trace of Good";
			} else {
				message+="No victor on this battle field";
			}
			System.out.println(message);
		}
	}
	int good(int pos) {
		int res;
		switch(pos) {
		case 0: res = 1; break;
		case 1: res = 2; break;
		case 2: res = 3; break;
		case 3: res = 3; break;
		case 4: res = 4; break;
		case 5: res = 10; break;
		default: res = 0;
		}
		return res;
	}
	int bad(int pos) {
		int res;
		switch(pos) {
		case 0: res = 1; break;
		case 1: res = 2; break;
		case 2: res = 2; break;
		case 3: res = 2; break;
		case 4: res = 3; break;
		case 5: res = 5; break;
		case 6: res = 11; break;
		default: res = 0;
		}
		return res;
	}
}
