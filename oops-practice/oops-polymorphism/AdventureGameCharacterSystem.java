abstract class GameCharacter {

    protected final String characterName;

    GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public abstract void performAttack();
}

class Warrior extends GameCharacter {

    Warrior(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " attacks with a sword.");
    }
}

class Mage extends GameCharacter {

    Mage(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " casts a fireball.");
    }
}

class Archer extends GameCharacter {

    Archer(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " shoots an arrow.");
    }
}

public class AdventureGameCharacterSystem {

    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Arjun"),
            new Mage("Meera"),
            new Archer("Riya"),
            new Warrior("Vikram")
        };

        startBattle(characters);
        displayCharacterCounts(characters);
    }

    public static void startBattle(GameCharacter[] characters) {
        System.out.println("Battle starts:");

        for (GameCharacter character : characters) {
            character.performAttack();
        }
    }

    public static void displayCharacterCounts(GameCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        for (GameCharacter character : characters) {
            if (character instanceof Warrior) {
                warriorCount++;
            } else if (character instanceof Mage) {
                mageCount++;
            } else if (character instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println("\nParticipants:");
        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }
}
