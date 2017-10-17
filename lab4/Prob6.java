class Alien {
    public static final int SNAKE_ALIEN = 0;
    public static final int OGRE_ALIEN = 1;
    public static final int MARSHMALLOW_MAN_ALIEN = 2;

    public int health;
    public String name;

    public Alien(int health, String name) {
        this.health = health;
        this.name = name;
    }
}

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
            if (aliens[i] instanceof Snake_Alien) {
                //Snake does 10 damage
                damage += Snake_Alien.getDamage();
            } else if (aliens[i] instanceof Ogre_Alien) {
                //Ogre does 6 damage
                damage += Ogre_Alien.getDamage();
            } else if (aliens[i] instanceof Marshmallow_Man_Alien) {
                //Marshmallow Man does 1 damage
                damage += Marshmallow_Man_Alien.getDamage();
            }
        }
        return damage;
    }
}

class Snake_Alien extends Alien {
	public static final int SNAKE_DAMAGE = 10;
	
	public Snake_Alien (int health, String name)
	{
		super(health, name);
	}
	
	public static int getDamage()
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
	
	public static int getDamage()
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
	
	public static int getDamage()
	{
		return SNAKE_DAMAGE;
	}
}

public class Prob6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlienPack my_pack = new AlienPack(50);
		my_pack.addAlien(new Snake_Alien(20, "lel"),  0);
		my_pack.addAlien(new Ogre_Alien(40, "meh"), 1);
		my_pack.addAlien(new Marshmallow_Man_Alien(30, "hihi"), 2);
		System.out.println(my_pack.calculateDamage());

	}

}
