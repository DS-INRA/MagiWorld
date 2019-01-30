import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.magiworld.Fight;
import com.magiworld.characters.Character;
import com.magiworld.characters.Mage;
import com.magiworld.characters.Rogue;
import com.magiworld.characters.Warrior;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Character playerOne = null;
        Character playerTwo = null;
        Fight fight = new Fight();
        fight.start("Joueur 1", "Joueur 2");
        // New game proposal
        String response;
        do {
            System.out.println("");
            System.out.println("Souhaitez vous rejouer ?");
            response = scanner.nextLine();
            if (response.equals("o"))
                fight.start("Joueur 1","Joueur 2");
            else if (response.equals("n"))
                System.out.println("Merci d'avoir joué");
        } while (!(response.equals("o")||response.equals("n")));
    }

}
