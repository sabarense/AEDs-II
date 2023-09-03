package TP01.Q03;

import TP01.MyIO;

public class cifraCesar {

	public static void main(String[] args){
		String palavra = MyIO.readLine();
		while(!palavra.equals("FIM")){
			criptografa(palavra);
			palavra = MyIO.readLine();		
		}
	}
	static void criptografa(String palavra){
		String result = "";
		for(int i = 0; i < palavra.length(); i++){
			int character = (int) palavra.charAt(i);
			character += 3;
			result += (char) character;
		}
		MyIO.println(result);
	}
}