package package01;

public class Room {
    boolean canMove;
    boolean canLoot;
    boolean canFight;
    boolean canQuest;
    boolean haveLooted = false;

    boolean[] availDecis = new boolean[4];
    boolean[] availDirec = new boolean[4];

    String enterMessage;


    Room leftRoom = null;
    Room rightRoom = null;
    Room forwardRoom = null;
    Room backRoom = null;

    int lootAmount; //Will most likely need to create a player wallet.

    //Quest roomQuest = null; //Need to make quest class.

    //Fight roomFight = null; //Need to implement a Fight class.

    //Default constructor
    public Room()
    {
        this.canMove = false;
        this.canLoot = false;
        this.canFight = false;
        this.canQuest = false;
        this.availDecis[0] = canMove;
        this.availDecis[1] = canLoot;
        this.availDecis[2] = canFight;
        this.availDecis[3] = canQuest;

        this.lootAmount = 0;
    }

    //Custom constructor
    public Room(boolean canMove, boolean canLoot, boolean canFight, boolean canQuest)
    {
        this.canMove = canMove;
        this.canLoot = canLoot;
        this.canFight = canFight;
        this.canQuest = canQuest;
        this.availDecis[0] = canMove;
        this.availDecis[1] = canLoot;
        this.availDecis[2] = canFight;
        this.availDecis[3] = canQuest;
    }

    //Setters
    public void setEnterText(String text)
    {
        this.enterMessage = text;
    }

    public void setMove(boolean[] availDirec)
    {
        if (!(this.canMove))
        {
            this.canMove = true;
            this.availDirec = availDirec;
        } else {
            this.availDirec = availDirec;
        }

    }

    public void setLootAmount(int lootAmount)
    {
        if (!(canLoot))
        {
            this.canLoot = true;
            this.lootAmount = lootAmount;
        } else {
            this.lootAmount = lootAmount;
        }
    }

	/*public void setFight(Fight roomFight)
	{
		if (!(canFight))
		{
			this.canFight = true;
			this.roomFight = roomRight;
		} else {
			this.roomFight = roomFight;
		}
	}
	*/

	/*
	public void setQuest(Quest roomQuest)
	{
		if (!(canQuest))
		{
			this.canQuest = true;
			this.roomQuest = roomQuest;
		} else {
			this.roomQuest = roomQuest;
		}
	}
	*/

    //Getters
    public String getEnterMessage()
    {
        return this.enterMessage;
    }

    public boolean[] getMoveOpt()
    {
        {
            if (this.canMove)
            {
                return this.availDirec;
            } else {
                System.out.println("You are unable to move.");
                return this.availDirec;
            }
        }
    }
    // All Action Methods

    public boolean[] getChoice()
    {
        return this.availDecis;
    }

    public int loot()
    {
        if (!(this.haveLooted))
        {
            if (this.canLoot)
            {
                this.haveLooted = true;
                return lootAmount;
            } else {
                System.out.println("There is no loot in this room.");
                this.haveLooted = true;
                return 0;
            }
        } else {
            System.out.println("You have already looted this room.");
            return 0;
        }
    }

	/*
	public void quest()
	{
		if (canQuest)
		{
			return this.roomQuest; //Still need to make this functionality
		} else {
			System.out.println("There are unfortunately no available quests in this room.");
		}
	}
	*/

    public void fight()
    {
        if (canFight)
        {
            System.out.println("test");
//            return; //Need to implement fight mechanics
        }
    }
}

