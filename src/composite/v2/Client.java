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
 */
