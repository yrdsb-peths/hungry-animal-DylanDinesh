import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our Elephant lives in and where the game takes place. 
 * 
 * @author Dylan Dinesh 
 * @version Dec 2023
 */
public class MyWorld extends World
{
    private int friesEatenCount = 0;
    private boolean gameOver = false;
    public int score = 0;
    Label scoreLabel;
    Label livesLabel;
    int level = 1;

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
        addObject(elephant, 300, getHeight() - 100);

        //Creates a label for score
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 35);

        // Creates a label for the number of lives the elephant has left
        livesLabel = new Label("Lives: " + Elephant.lives, 60);
        addObject(livesLabel, 485, 35);

        spawnApple();
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }

    /**
     * End the game and draw 'GameOver'
     * shows score & let's them start again when they press start (even during the game if they give up, they can press space to start again)
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 50);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2);
        
        Label scoreMessageLabel = new Label("Score: " + score + "\nPress space to start again", 30);
        addObject(scoreMessageLabel, getWidth() / 2, getHeight() / 2 + 50);
        
    }

    /**
     * Decrease the lives label
     */
    public void decreaseLives()
    {
        livesLabel.setValue("Lives: " + Elephant.lives);
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