package TP01.TP01Q06;

import TP01.MyIO;

public class Is {
    public static void main(String[] args) {
		
        String palavra = MyIO.readLine();
        while (!palavra.equalsIgnoreCase("FIM")) {
            boolean[] list = new boolean[4];
            list[0] = isVogal(palavra);
            list[1] = isConsoante(palavra);
            list[2] = isInt(palavra);
            list[3] = isDouble(palavra);
            verifica(list);
			System.out.println("");
            palavra = MyIO.readLine();
        }
    }

    public static boolean isVogal(String palavra) {

        String vogais = "AEIOUaeiou";
        for (int i = 0; i < palavra.length(); i++) {
            if (vogais.indexOf(palavra.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isConsoante(String palavra) {
		
		String consoantes = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
        for(int i = 0; i < palavra.length(); i++){
			if(consoantes.indexOf(palavra.charAt(i)) == -1){
				return false;
			}
		}
		return true;
    }

    public static boolean isInt(String palavra) {
        try {
            Integer.parseInt(palavra);
            return true;
        } catch (NumberFormatException naoeinteiro) {
            return false;
        }
    }

    public static boolean isDouble(String palavra) {
        try {
            Double.parseDouble(palavra);
            return true;
        } catch (NumberFormatException naoedouble) {
            return false;
        }
    }

    public static void verifica(boolean[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i]) {
                System.out.print("SIM ");
            } else {
                System.out.print("NAO ");
            }
        }
    }
}
