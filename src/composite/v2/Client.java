package composite.v2;

import java.util.ArrayList;

abstract class AbstractFile {
    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}

// Leaf
class ImageFile extends AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("unsupported operation");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("unsupported operation");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("unsupported operation");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("kill virus on image file: " + name);
    }
}

class TextFile extends AbstractFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("unsupported operation");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("unsupported operation");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("unsupported operation");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("kill virus on text file: " + name);
    }

}

class VideoFile extends AbstractFile {

    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("unsupported operation");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("unsupported operation");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("unsupported operation");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("kill virus on video file: " + name);
    }
}

class Folder extends AbstractFile {

    private ArrayList<AbstractFile> files = new ArrayList<>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        files.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        files.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return files.get(i);
    }

    @Override
    public void killVirus() {

        System.out.println("Kill virus on folder: " + name);
        files.forEach(AbstractFile::killVirus);
    }
}

public class Client {
    public static void main(String[] args) {
        AbstractFile file1, file2, file3, file4, file5,
                folder1, folder2, folder3, folder4;
        folder1 = new Folder("Downloads");
        folder2 = new Folder("Home");
        folder3 = new Folder("Videos");
        folder4 = new Folder("Images");

        file1 = new ImageFile("dog.jpg");
        file2 = new ImageFile("cat.gif");
        file3 = new TextFile("readme.md");
        file4 = new VideoFile("unit test.avi");
        file5 = new VideoFile("php.mp4");

        folder1.add(file4);
        folder3.add(file5);
        folder2.add(file3);
        folder4.add(file1);
        folder4.add(file2);

        folder1.add(folder3);
        folder1.add(folder4);
        folder2.add(folder1);

        folder2.killVirus();
        /*
        kill virus on folder: Home
        kill virus on text file: readme.md
        kill virus on folder: Downloads
        kill virus on video file: unit test.avi
        kill virus on folder: Videos
        kill virus on video file: php.mp4
        kill virus on folder: Images
        kill virus on image file: dog.jpg
        kill virus on image file: cat.gif
         */
    }
}
/*
组合模式使用面向对象的思想来实现树形结构的构建与处理，
描述了如何将容器对象和叶子对象进行递归组合，实现简单，灵活性好。

由于在软件开发中存在大量的树形结构，因此组合模式是一种使用频率较高的结构型设计模式，
Java SE中的AWT和Swing包的设计就基于组合模式，
在这些界面包中为用户提供了大量的容器构件（如Container）和成员构件（如Checkbox、Button和TextComponent等）

1. 主要优点

      组合模式的主要优点如下：

      (1) 组合模式可以清楚地定义分层次的复杂对象，表示对象的全部或部分层次，它让客户端忽略了层次的差异，方便对整个层次结构进行控制。

      (2) 客户端可以一致地使用一个组合结构或其中单个对象，不必关心处理的是单个对象还是整个组合结构，简化了客户端代码。

      (3) 在组合模式中增加新的容器构件和叶子构件都很方便，无须对现有类库进行任何修改，符合“开闭原则”。

      (4) 组合模式为树形结构的面向对象实现提供了一种灵活的解决方案，通过叶子对象和容器对象的递归组合，可以形成复杂的树形结构，但对树形结构的控制却非常简单。

      2. 主要缺点

      组合模式的主要缺点如下：

      在增加新构件时很难对容器中的构件类型进行限制。
      有时候我们希望一个容器中只能有某些特定类型的对象，例如在某个文件夹中只能包含文本文件，使用组合模式时，不能依赖类型系统来施加这些约束，
      因为它们都来自于相同的抽象层，在这种情况下，必须通过在运行时进行类型检查来实现，这个实现过程较为复杂。

      3. 适用场景

      在以下情况下可以考虑使用组合模式：

      (1) 在具有整体和部分的层次结构中，希望通过一种方式忽略整体与部分的差异，客户端可以一致地对待它们。

      (2) 在一个使用面向对象语言开发的系统中需要处理一个树形结构。

      (3) 在一个系统中能够分离出叶子对象和容器对象，而且它们的类型不固定，需要增加一些新的类型。
 */
