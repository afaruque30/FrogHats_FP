

public class TestingCharacter {
    

    private int pos;
    private String color;

    public TestingCharacter() {
        this.pos = 10;
        this.color = Constants.Colors.BLUE;
    }
    public int getPos() {
        return this.pos;
    }
    public void setPos(int newPos) {
        this.pos = newPos;
    }
    public String getColor() {
        return this.color;
    }
}
