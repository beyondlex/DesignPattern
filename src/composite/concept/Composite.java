package composite.concept;

import java.util.ArrayList;
import java.util.List;

/*
在组合模式中引入了抽象构件类Component，它是所有容器类(Composite)和叶子类(Leaf)的公共父类，
客户端针对Component进行编程。

组合模式的关键是定义了一个抽象构件类，它既可以代表叶子，又可以代表容器，
而客户端针对该抽象构件类进行编程，无须知道它到底表示的是叶子还是容器，可以对其进行统一处理

如果不使用组合模式，客户端代码将过多地依赖于容器对象复杂的内部实现结构，
容器对象内部实现结构的变化将引起客户代码的频繁变化，带来了代码维护复杂、可扩展性差等弊端

 */
abstract class Component {
    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract Component getChild(int i);
    public abstract void operation();
}

class Leaf extends Component {

    @Override
    public void add(Component c) {
        // nothing
    }

    @Override
    public void remove(Component c) {
        // nothing
    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        // do something
    }
}

class Composite extends Component{

    /*
    容器对象(Composite)与抽象构件类(Component)之间还建立一个聚合关联关系，
    在容器对象中既可以包含叶子，也可以包含容器，以此实现递归组合，形成一个树形结构。
     */
    private List<Component> components = new ArrayList<>();

    @Override
    public void add(Component c) {
        components.add(c);
    }

    @Override
    public void remove(Component c) {
        components.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return components.get(i);
    }

    /*
    在组合模式结构中，由于容器构件中仍然可以包含容器构件，
    因此在对容器构件进行处理时需要使用递归算法，即在容器构件的operation()方法中递归调用其成员构件的operation()方法。
     */
    @Override
    public void operation() {
        components.forEach(Component::operation);
    }
}
