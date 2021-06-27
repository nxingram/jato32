package scribbles;

public class Googles {

	public static void main(String[] args) {
//		System.out.println(decipher("Aabcdefghijklmnopqrstuvwxyz%"));
		System.out.println(decipher("Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!"));

	}

	public static String solution(String x) {
		char[] var = new char[x.length()];
		for (int i = 0; i < x.length(); i++) {
			if ((int) x.charAt(i) >= 97 && (int) x.charAt(i) <= 122) {
				var[i] = (char) ((int) x.charAt(i) + (25 - (((int) x.charAt(i) - 97) * 2)));
			} else
				var[i] = x.charAt(i);
		}
		String x2 = new String(var);
		return x2;
	}

	private static String decipher(String word) {
		StringBuilder sb = new StringBuilder(word);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (Character.isLowerCase(c)) {
				sb.replace(i, i + 1, Character.toString(reverse(c)));
			}
		}
		return sb.toString();
	}

	public static char reverse(char c) {
		return (char) ((int) 'z' - (int) c + (int) 'a');
	}

	private static char convert(char c) {
		return (char) ((int) c + (25 - (((int) c - 97) * 2)));
	}
}
