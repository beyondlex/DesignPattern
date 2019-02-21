package facade.concept;

class SubsystemA {
    public void methodA() {

    }
}
class SubsystemB {
    public void methodB() {

    }
}
class SubsystemC {
    public void methodC() {

    }
}

public class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;

    public void method() {
        subsystemA.methodA();
        subsystemB.methodB();
        subsystemC.methodC();
    }
}

class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}

/*
外观模式又称为门面模式，它是一种对象结构型模式。
外观模式是迪米特法则的一种具体实现，通过引入一个新的外观角色可以降低原有系统的复杂度，同时降低客户类与子系统的耦合度。

外观模式中，一个子系统的外部与其内部的通信通过一个统一的外观类进行，外观类将客户类与子系统的内部复杂性分隔开，
使得客户类只需要与外观角色打交道，而不需要与子系统内部的很多对象打交道。

外观模式的主要目的在于降低系统的复杂程度，在面向对象软件系统中，类与类之间的关系越多，不能表示系统设计得越好，反而表示系统中类之间的耦合度太大，
这样的系统在维护和修改时都缺乏灵活性，因为一个类的改动会导致多个类发生变化，而外观模式的引入在很大程度上降低了类与类之间的耦合关系。

引入外观模式之后，增加新的子系统或者移除子系统都非常方便，客户类无须进行修改（或者极少的修改），只需要在外观类中增加或移除对子系统的引用即可。
从这一点来说，外观模式在一定程度上并不符合开闭原则，增加新的子系统需要对原有系统进行一定的修改，虽然这个修改工作量不大。
 */
