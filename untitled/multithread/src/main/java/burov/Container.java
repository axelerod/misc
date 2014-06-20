package burov;

/**
 * Created by IntelliJ IDEA.
 * User: alexey
 * Date: 21.06.14
 * Time: 0:46
 * To change this template use File | Settings | File Templates.
 */
public class Container<T> {
    private T t;

    public Container(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
