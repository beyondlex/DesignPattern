package composite.v1;


import java.util.ArrayList;

class ImageFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        //简化代码，模拟杀毒
        System.out.println("----对图像文件'" + name + "'进行杀毒");
    }
}

class TextFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        //简化代码，模拟杀毒
        System.out.println("----对文本文件'" + name + "'进行杀毒");
    }
}

class Folder {
    private String name;
    //定义集合folderList，用于存储Folder类型的成员
    private ArrayList<Folder> folderList = new ArrayList<>();
    //定义集合imageList，用于存储ImageFile类型的成员
    private ArrayList<ImageFile> imageList = new ArrayList<>();
    //定义集合textList，用于存储TextFile类型的成员
    private ArrayList<TextFile> textList = new ArrayList<>();

    /*
    3.
    系统的灵活性和可扩展性差，
    如果需要增加新的类型的叶子和容器都需要对原有代码进行修改，
    例如如果需要在系统中增加一种新类型的视频文件VideoFile，则必须修改Folder类的源代码，否则无法在文件夹中添加视频文件
     */

    public Folder(String name) {
        this.name = name;
    }

    //增加新的Folder类型的成员
    public void addFolder(Folder f) {
        folderList.add(f);
    }

    //增加新的ImageFile类型的成员
    public void addImageFile(ImageFile image) {
        imageList.add(image);
    }

    //增加新的TextFile类型的成员
    public void addTextFile(TextFile text) {
        textList.add(text);
    }

    //需提供三个不同的方法removeFolder()、removeImageFile()和removeTextFile()来删除成员，代码省略

    //需提供三个不同的方法getChildFolder(int i)、getChildImageFile(int i)和getChildTextFile(int i)来获取成员，代码省略

    public void killVirus() {
        System.out.println("****对文件夹'" + name + "'进行杀毒");  //模拟杀毒

        //如果是Folder类型的成员，递归调用Folder的killVirus()方法
        for(Object obj : folderList) {
            ((Folder)obj).killVirus();
        }

        //如果是ImageFile类型的成员，调用ImageFile的killVirus()方法
        for(Object obj : imageList) {
            ((ImageFile)obj).killVirus();
        }

        //如果是TextFile类型的成员，调用TextFile的killVirus()方法
        for(Object obj : textList) {
            ((TextFile)obj).killVirus();
        }
    }
    /*
    1.
    文件夹类Folder的设计和实现都非常复杂，
    需要定义多个集合存储不同类型的成员，
    而且需要针对不同的成员提供增加、删除和获取等管理和访问成员的方法，
    存在大量的冗余代码，系统维护较为困难
     */
}

class Client {
    public static void main(String[] args) {
        Folder folder1,folder2,folder3;
        folder1 = new Folder("Sunny的资料");
        folder2 = new Folder("图像文件");
        folder3 = new Folder("文本文件");

        ImageFile image1,image2;
        image1 = new ImageFile("小龙女.jpg");
        image2 = new ImageFile("张无忌.gif");

        TextFile text1,text2;
        text1 = new TextFile("九阴真经.txt");
        text2 = new TextFile("葵花宝典.doc");
        /*
        2.
        由于系统没有提供抽象层，
        客户端代码必须有区别地对待充当容器的文件夹Folder和充当叶子的ImageFile和TextFile，无法统一对它们进行处理；
         */

        folder2.addImageFile(image1);
        folder2.addImageFile(image2);
        folder3.addTextFile(text1);
        folder3.addTextFile(text2);
        folder1.addFolder(folder2);
        folder1.addFolder(folder3);

        folder1.killVirus();
    }
}
/*
****对文件夹'Sunny的资料'进行杀毒
****对文件夹'图像文件'进行杀毒
----对图像文件'小龙女.jpg'进行杀毒
----对图像文件'张无忌.gif'进行杀毒
****对文件夹'文本文件'进行杀毒
----对文本文件'九阴真经.txt'进行杀毒
----对文本文件'葵花宝典.doc'进行杀毒
 */

