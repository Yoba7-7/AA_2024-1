public class Conversor{

	public static String casosBase(String octal){
		String binario = "";

		switch(octal){
		case "o":
			binario = "000";
			break;
		case "1":
			binario = "001";
			break;
		case "2":
			binario = "010";
			break;
		case "3":
			binario = "011";
			break;
		case "4":
			binario = "100";
			break;
		case "5":
			binario = "101";
			break;
		case "6":
			binario = "110";
			break;
		case "7":
			binario = "111";
			break;
			}

		return binario;
	}

	public static void imprimeBonito(String[] numero){
		for(String n : numero){
			System.out.print(n);
		}
	}

	public static String[] octalBinario(String[] octal){
		String[] binario = new String[octal.length];

		for(int i = 0; i < octal.length; i++){
			String bits = casosBase(octal[i]);
			binario[i] = bits;
		}

		return binario;
	}

	public static void main(String[] args) {
		String[] octal = new String[4];
		octal[0] = "2";
		octal[1] = "5";
		octal[2] = "6";
		octal[3] = "1";
		imprimeBonito(octalBinario(octal));
	}
}