package factory.method;

// simple factory
public class LoggerFactoryV0 {
    //静态工厂方法
    public static Logger createLogger(String args) {
        if(args.equalsIgnoreCase("db")) {
            //连接数据库，代码省略
            //创建数据库日志记录器对象
            Logger logger = new DatabaseLogger();
            //初始化数据库日志记录器，代码省略
            return logger;
        }
        else if(args.equalsIgnoreCase("file")) {
            //创建日志文件
            //创建文件日志记录器对象
            Logger logger = new FileLogger();
            //初始化文件日志记录器，代码省略
            return logger;
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        Logger logger;
        logger = LoggerFactoryV0.createLogger("db");

    }
}
interface Logger {

}
class DatabaseLogger implements Logger{

}
class FileLogger implements Logger{

}
