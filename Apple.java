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
            world = (MyWorld) getWorld();
            world.removeObject(this);
            Elephant.lives--;
            if (Elephant.lives > 0)
            {
                world.spawnApple();
            }
        }

        if (Elephant.lives == 0)
        {
            world.removeObject(this);
            world.gameOver();
            world = (MyWorld) getWorld();
        }

    }

    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
