package CriptoCaesar;

public class Caesar{

public static String criptografarCaesar(String texto, int deslocamento) {
	
	StringBuilder escrivao= new StringBuilder();

	for(int i=0; i<texto.length();i++) {

		if(Character.isAlphabetic(texto.charAt(i))) {

			if (Character.isUpperCase(texto.charAt(i))) 
			{ 
				char ch = (char)(((int)texto.charAt(i) + 
						deslocamento - 65) % 26 + 65); 
				escrivao.append(ch); 
			} 
			else
			{ 
				char ch = (char)(((int)texto.charAt(i) + 
						deslocamento - 97) % 26 + 97); 
				escrivao.append(ch);  	
			}
		} else {			
			escrivao.append(texto.charAt(i));
		}

	}
	return escrivao.toString();
}}

