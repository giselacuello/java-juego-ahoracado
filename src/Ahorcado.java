import java.util.Scanner;
import java.util.Random;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        //Array de palabras posibles para adivinar
        String[] palabras = {"inteligencia", "programacion", "computadora", "dificultad"};

        //Generador de numeros aleatorios
        Random random = new Random();

        // selecciona una palabra al azar del array
        String palabraSecreta = palabras[random.nextInt(palabras.length)];
         
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        //Arreglos:
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i<letrasAdivinadas.length; i++){
            letrasAdivinadas[i] = '_';
        }

        while(!palabraAdivinada && intentos < intentosMaximos){
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");

            System.out.println("Introduce una letra");
            //solo va a tomar el primer caracter de lo que ingrese el usuario
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++){

                if(palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }                
            }
            if(!letraCorrecta){
                intentos++;
                System.out.println("Letra incorrecta, Te quedan " + (intentosMaximos - intentos) + " intentos");
            }
            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades, has adivinado la palabra secreta: " + palabraSecreta);
            }            
        }

        if(!palabraAdivinada){
            System.out.println("Que pena, te has quedado sin intentos. Perdiste!");
        }

        scanner.close();
    }
}
