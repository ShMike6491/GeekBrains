package lesson7;

public class Cat {
    private String name;
    private boolean fullness;
    private int hungerLvl;

    public Cat(String name, int hungerLvl) {
        this.name = name;
        this.fullness = false;
        if(hungerLvl < 0) {
            this.hungerLvl = 10;
        } else {
            this.hungerLvl = hungerLvl;
        }
    }

    public void eat(Plate plate) {
        int remains = plate.feedEaten(hungerLvl);

        if (remains <= 0) {
            fullness = true;
            hungerLvl = 0;
        } else {
            hungerLvl = remains;
        }
    }

    public boolean isFullness() {
        return fullness;
    }

    public int getHungerLvl() {
        return hungerLvl;
    }

    public void setFullness() {
        this.fullness = false;
    }

    public void setHungerLvl(int hungerLvl) {
        if(hungerLvl < 0) {
            return;
        }
        this.hungerLvl = hungerLvl;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", fullness=" + fullness +
                ", hungerLvl=" + hungerLvl +
                '}';
    }
}
