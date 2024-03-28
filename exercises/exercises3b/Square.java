package exercises.exercises3b;

import java.io.Serializable;

public class Square extends Rectangle implements Serializable {
    private static final long serialVersionUID = 1L;

    public Square(double side) {
        super(side, side);
    }
}