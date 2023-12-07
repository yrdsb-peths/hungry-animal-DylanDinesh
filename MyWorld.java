import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our here lives in. 
 * 
 * @author Dylan Dinesh 
 * @version November 2023
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    private boolean isPaused = false;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);

        // Create the elephant object 
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);

        //Creates a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);

        spawnApple();
    }

    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }

    /**
     * Increases score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);

        if (score % 5 == 0)
        {
            level++;
        }
    }

    /**
     * Create a new apple at a random location at top of screen
     */
    public void spawnApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}