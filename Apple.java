import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Apples are the target for the player/elephant, and the goal of the game is to "eat" the apple.
 * 
 * @author Dylan Dinesh 
 * @version Dec 2023
 */
public class Apple extends Actor
{
    int speed = 1;
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);

        /**
         * Remove apples when apple gets to bottom.
         */ 
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight())
        {
            world = (MyWorld) getWorld();
            world.removeObject(this);
            Elephant.lives--;
            world.decreaseLives();

            // Prevents extra apple from being spawned temporarily after the game over screen.  
            if (Elephant.lives > 0)
            {
                world.spawnApple();
            }
        }

        // Game over screen once all the lives are out, meaning that the apple got to the bottom 3 times.
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
