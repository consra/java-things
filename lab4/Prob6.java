class Alien {
    public static final int SNAKE_ALIEN = 0;
    public static final int OGRE_ALIEN = 1;
    public static final int MARSHMALLOW_MAN_ALIEN = 2;

    //Stores one of the three above types
    //public int type;
    //0 = dead, 100 = full strength
    public int health;
    public String name;

    public Alien(int health, String name) {
        //this.type = type;
        this.health = health;
        this.name = name;
    }
}
/*
class AlienPack {
    private Alien[] aliens;

    public AlienPack(int numAliens) {
        aliens = new Alien[numAliens];
    }

    public void addAlien(Alien newAlien, int index) {
        aliens[index] = newAlien;
    }

    public Alien[] getAliens() {
        return aliens;
    }

    public int calculateDamage() {
        int damage = 0;
        for (int i = 0; i < aliens.length; i++) {
            if (aliens[i].type == Alien.SNAKE_ALIEN) {
                //Snake does 10 damage
                damage += 10;
            } else if (aliens[i].type == Alien.OGRE_ALIEN) {
                //Ogre does 6 damage
                damage += 6;
            } else if (aliens[i].type == Alien.MARSHMALLOW_MAN_ALIEN) {
                //Marshmallow Man does 1 damage
                damage += 1;
            }
        }
        return damage;
    }
}
*/
class Snake_Alien extends Alien {
	public static final int SNAKE_DAMAGE = 10;
	
	public Snake_Alien (int health, String name)
	{
		super(health, name);
	}
	
	public int getDamage()
	{
		return SNAKE_DAMAGE;
	}
	
	
}

class Ogre_Alien extends Alien {
	public static final int SNAKE_DAMAGE = 6;
	
	public Ogre_Alien (int health, String name)
	{
		super(health, name);
	}
	
	public int getDamage()
	{
		return SNAKE_DAMAGE;
	}
}

class Marshmallow_Man_Alien extends Alien {
	public static final int SNAKE_DAMAGE = 1;
	
	public Marshmallow_Man_Alien (int health, String name)
	{
		super(health, name);
	}
	
	public int getDamage()
	{
		return SNAKE_DAMAGE;
	}
}

public class Prob6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marshmallow_Man_Alien one = new Marshmallow_Man_Alien(69, "kuku");
		System.out.print(one.getDamage());

	}

}
