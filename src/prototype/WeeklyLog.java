package prototype;

import java.io.*;

public class WeeklyLog implements Serializable {
    private String name;
    private String date;
    private String content;
    private Attachment attachment;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeeklyLog clone() {
        Object object = null;
        try {
            object = super.clone();
            return (WeeklyLog) object;
        } catch (CloneNotSupportedException e) {
            System.out.println("clone unsupported");
            return null;
        }
    }

    public WeeklyLog deepClone() throws IOException, ClassNotFoundException {
        // 将对象写入流中
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        // 将对象从流中取出
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (WeeklyLog) objectInputStream.readObject();
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}

class Attachment implements Serializable{
    private String name;

    public void download() {
        System.out.println("downloading file: " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Client {
    public static void main(String[] args) {
        //WeeklyLog log1 = new WeeklyLog();
        //log1.setName("jim");
        //log1.setDate("week 1");
        //log1.setContent("nothing to do");
        //writeLog(log1);
        //
        //WeeklyLog log2 = log1.clone();
        //log2.setDate("week 2");
        //writeLog(log2);
        WeeklyLog log1, log2;
        log1 = new WeeklyLog();
        Attachment attachment = new Attachment();
        log1.setAttachment(attachment);
        //log2 = log1.clone();

        //System.out.println("log1 == log2 ? " + (log1 == log2));// false
        //// 浅克隆：引用对象(attachment)只会克隆内存地址，因此是同一个对象
        //System.out.println("log1.attachment == log2.attachment ? " + (log1.getAttachment() == log2.getAttachment()));// true

        try {
            WeeklyLog log3 = log1.deepClone();
            System.out.println("log1 == log3 ? " + (log1 == log3));// false
            // 深克隆
            System.out.println("log1.attachment == log3.attachment ? " + (log1.getAttachment() == log3.getAttachment()));// false

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void writeLog(WeeklyLog log) {
        System.out.println("---weekly report---");
        System.out.println("week: " + log.getDate());
        System.out.println("name: " + log.getName());
        System.out.println("content: " + log.getContent());
        System.out.println("-------------------");
    }
}
