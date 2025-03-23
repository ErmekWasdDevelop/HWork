import java.util.Random;

public class HW4 {

    public static int bossHealth = 1500;
    public static int bossDamage = 50;
    public static int golemDefence = bossDamage/5*4;
    public static String bossDefence;
    public static int[] heroesHealth = {280, 270, 240, 360, 500, 200, 300, 240};
    public static int[] heroesDamage = {15, 20, 10, 0, 5, 20, 0, 20};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic", "Golem", "Lucky", "Whitch", "Thor"};
    public static int roundNumber;
    public static Random random = new Random();


    public static void main(String[] args) {
        showStatistics();
        while (!isGameOver()) {
            playRound();
        }
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!\n You Passed!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int heroHealth : heroesHealth) {
            if (heroHealth > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!! \n You Lose!!!");
            return true;
        }
        return false;
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        setRandomHeal();
        witchNecromance();
        bossAttack();
        heroesAttack();
        showStatistics();
    }

    public static void chooseBossDefence() {
        int randomIndex = random.nextInt(heroesAttackType.length); // 0,1,2
        bossDefence = heroesAttackType[randomIndex];
    }

    public static void setRandomHeal() {
        int heal = random.nextInt(50, 100);
        for (int i = 0; i < heroesAttackType.length; i++) {
            if (heroesHealth[i] < 100 && heroesHealth[i] > 0 && heroesHealth[3] > 0&& i!=3) {
                heroesHealth[i] = heroesHealth[i] + heal;
                System.out.println("HEAL = " + heal);
                break;
            }
        }
    }

    public static void witchNecromance() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] == 0 && heroesHealth[6] > 0) {
                heroesHealth[i] = heroesHealth[i] + heroesHealth[6];
                heroesHealth[6] = 0;
                System.out.println("Hero Alive!");
            }
        }
    }

    public static void bossAttack() {
        boolean Stun = random.nextBoolean();
        int chance = random.nextInt(1, 4);
        boolean lucky = false;
        if (chance == 4) {lucky = true;}
        if (chance!= 4) {lucky=false;}
        if (Stun == true){System.out.println("BOSS STUN!!!");}
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[7] > 0 && Stun) {
                    heroesHealth[i] = heroesHealth[i] - bossDamage * 0;
                }else if(heroesHealth[4]<0){ heroesHealth[4] = 0;
                } else if (heroesHealth[4] > 0) {
                    heroesHealth[i] = heroesHealth[i] < bossDamage ? 0 : heroesHealth[i] - golemDefence;
                    heroesHealth[4] = heroesHealth[4] + golemDefence - (bossDamage + (bossDamage / 5));

                } else if (lucky && (heroesHealth[6] > 0)) {
                    if (heroesHealth[4] > 0) {
                        heroesHealth[i] = heroesHealth[i] < golemDefence ? 0 : heroesHealth[i] - golemDefence;
                        heroesHealth[6] = heroesHealth[6] - golemDefence;
                        heroesHealth[4] = heroesHealth[4]  +golemDefence - (bossDamage + (bossDamage / 5)) ;
                    }else {
                        heroesHealth[i] = heroesHealth[i] < bossDamage ? 0 : heroesHealth[i] - bossDamage;
                        heroesHealth[6] = heroesHealth[6] < bossDamage ? 0 : heroesHealth[6] - bossDamage;
                    }


                } else {
                    heroesHealth[i] = heroesHealth[i] < bossDamage ? 0 : heroesHealth[i] - bossDamage;
                }
            }
        }
    }


    public static void heroesAttack() {
        for (int i = 0; i < heroesAttackType.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int damage = heroesDamage[i];
                if (heroesAttackType[i] == bossDefence) {
                    int coeff = random.nextInt(2, 10); // 2,3,4,5,6,7,8,9
                    damage = damage * coeff;
                    System.out.println("Critical damage: " + damage);
                }
                bossHealth = bossHealth < damage ? 0 : bossHealth - damage;
            }
        }
    }

    public static void showStatistics() {
        System.out.println("ROUND: " + roundNumber + " -----------------");
        System.out.println("Boss health: " + bossHealth + " damage: " + bossDamage
                + " defence: " + (bossDefence == null ? "No defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i]
                    + " damage: " + heroesDamage[i]);
        }
    }


}
