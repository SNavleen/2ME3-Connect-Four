import java.io.IOException;

/*
 * Player.java
 *
 * Created on December 5, 2003, 11:55 PM
 */

/**
 *
 * @author  Chen
 */
public interface Player {
    public void go(currentBoard b) throws IOException;
    public void setMove(int col);
}
