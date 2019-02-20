package prototype;

public class WeeklyLog implements Cloneable{
    private String name;
    private String date;
    private String content;

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
}

class Client {
    public static void main(String[] args) {
        WeeklyLog log1 = new WeeklyLog();
        log1.setName("jim");
        log1.setDate("week 1");
        log1.setContent("nothing to do");
        writeLog(log1);

        WeeklyLog log2 = log1.clone();
        log2.setDate("week 2");
        writeLog(log2);

    }
    private static void writeLog(WeeklyLog log) {
        System.out.println("---weekly report---");
        System.out.println("week: " + log.getDate());
        System.out.println("name: " + log.getName());
        System.out.println("content: " + log.getContent());
        System.out.println("-------------------");
    }
}
