interface EventDuring {
    FightResult currentEvent();
}

interface EventAfter{
    void afterEvent(FightResult result);
}
enum FightResult {
    WIN,
    LOSE,
    RUN
}

public abstract class FloorEvent implements EventDuring, EventAfter {
    private String description;
    
    public FloorEvent(String description) {
        this.description = description;
       
    }
    
    public String getDescription() {
        return description;
    }
}


class MonsterEvent extends FloorEvent {

    public MonsterEvent() {
        super("Encountered a monster!");
    }

    @Override
    public FightResult currentEvent() {
        System.out.println("Starting monster fight...");
        // combat logic here
        return FightResult.WIN;
    }

    @Override
    public void afterEvent(FightResult result) {
        // give loot, exp, gold
    }
}


class BossEvent extends FloorEvent {

    public BossEvent() {
        super("You encountered the final boss!");
    }

    @Override
    public FightResult currentEvent() {
        System.out.println("Starting boss fight...");
        // boss combat logic here
        return FightResult.WIN;
    }

    @Override
    public void afterEvent(FightResult result) {
        
        // end game logic here
    }
}

//Mage loots muna

class LootGenerator {
    private static String[] lootItems = {
        "Health Potion",
        "Mana Potion",
        "Gold Sack",
    };
    public static String generateLoot() {
        int randomIndex = (int)(Math.random() * lootItems.length);
        return lootItems[randomIndex];
    }
}


class SkillReward {
    private static String[] skills = {
        "Fireball",
        "Ice Shard",
        "Thunder Strike",
    };
    
    public static String[] getSkillOptions() {
        return skills;
    }
}


/* 
@Override
public void afterEvent(FightResult result) {
    switch (result) {
        case WIN -> {
            // reward player with loot
            String loot = LootGenerator.generateLoot();
            System.out.println("You received: " + loot);
        }
        case RUN -> {}
        case LOSE -> {}
    }
}
*/