package shape;

public class Shape {
    private TypeOfShape t;
    private Color c;

    public Shape(TypeOfShape t, Color c) {
        this.t = t;
        this.c = c;
    }

    public TypeOfShape getT() {
        return t;
    }

    public void setT(TypeOfShape t) {
        this.t = t;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "t=" + t +
                ", c=" + c +
                '}';
    }
}
