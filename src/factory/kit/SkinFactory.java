package factory.kit;

interface Button {
    public void display();
}
class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("spring button");
    }
}
class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("summer button");
    }
}

// --------------------
interface TextField {
    public void display();
}
class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("spring text field");
    }
}
class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("summer text field");
    }
}

// --------------------
interface ComboBox {
    public void display();
}
class SpringComboBox implements ComboBox {
    @Override
    public void display() {
        System.out.println("spring combo box");
    }
}
class SummerComboBox implements ComboBox {
    @Override
    public void display() {
        System.out.println("summer combo box");
    }
}

// --------------------
interface SkinFactory {
    public Button createButton();
    public TextField createTextField();
    public ComboBox createComboBox();
}
class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }
    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }
    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
class SummerSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SummerButton();
    }
    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }
    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}

// --------------------
class Client {
    public static void main(String[] args) {
        SkinFactory skinFactory;
        Button button;
        TextField textField;
        ComboBox comboBox;
        skinFactory = new SpringSkinFactory();
        button = skinFactory.createButton();
        textField = skinFactory.createTextField();
        comboBox = skinFactory.createComboBox();

        button.display();
        textField.display();
        comboBox.display();

        skinFactory = new SummerSkinFactory();
        button = skinFactory.createButton();
        textField = skinFactory.createTextField();
        comboBox = skinFactory.createComboBox();

        button.display();
        textField.display();
        comboBox.display();
    }
}
