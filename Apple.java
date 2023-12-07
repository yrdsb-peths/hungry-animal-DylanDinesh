import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author Dylan Dinesh 
 * @version November 2023
 */
public class Apple extends Actor
{
    int speed = 1;
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);

        // Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }

    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
