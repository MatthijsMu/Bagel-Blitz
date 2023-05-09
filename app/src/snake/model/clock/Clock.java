package snake.model.clock;

import snake.model.basictypes.Colour;
import javafx.beans.property.*;

public interface Clock {
    public SimpleIntegerProperty getWhiteTimeProperty();
    public SimpleIntegerProperty getBlackTimeProperty();
    public BooleanProperty       running();
    
    public void setTime(int secondsTotal, int secondsIncrement, int secondsGuillotine);
    public void setTime(Colour colour, int secondsTotal, int secondsIncrement, int secondsGuillotine);
    public void resetTime();
    public void setRunning(boolean running);
}
