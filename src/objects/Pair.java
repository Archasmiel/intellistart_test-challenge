package objects;

public class Pair<A, B> {

    private A value1;
    private B value2;

    public Pair(A value1, B value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public A getLeft() {
        return value1;
    }

    public void setLeft(A value1) {
        this.value1 = value1;
    }

    public B getRight() {
        return value2;
    }

    public void setRight(B value2) {
        this.value2 = value2;
    }

}
