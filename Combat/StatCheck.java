// checker for minimum and max stat values

public class StatCheck{
    public int playerHPCheck(int pHP){
        if (pHP <= 0){
            return 0;
        }
        else{
            return pHP;
        }
    }
    public int monsterHPCheck(int mHP){
        if (mHP <= 0){
            return 0;
        }
        else{
            return mHP;
        }
    }
    public int playerManaCheck(int pMana){
        if (pMana <= 0){
            return 0;
        }
        else if (pMana >= 100){
            return 100;
        }
        else{
            return pMana;
        }
    }
}