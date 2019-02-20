package adapter;

public class DefaultAdapter {
}

interface WindowListener {
    public void windowOpened();
    public void windowClosing();
    public void windowClosed();
    public void windowActivated();
}

/**
 * abstract类WindowAdapter作为一个默认适配器，实现WindowListener（每个方法提供一个空的实现）
 * 这样，继承WindowAdapter的子类就不需要实现所有WindowListener的方法了。
 */
abstract class WindowAdapter implements WindowListener{
    public void windowOpened(){}
    public void windowClosing(){}
    public void windowClosed(){}
    public void windowActivated(){}
}

class ComplexWindow extends WindowAdapter{
    public void windowOpened(){}
    public void windowClosing(){}
    public void windowClosed(){}
    public void windowActivated(){}
}

/**
 * 只实现少数几个方法的SimpleWindow
 */
class SimpleWindow extends WindowAdapter {
    public void windowOpened(){}
    public void windowClosed(){}
}

