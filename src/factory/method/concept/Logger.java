package factory.method.concept;


public interface Logger {
    public void writeLog();
}

class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("log in database");
    }
}

class FileLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("log in file");
    }
}

// -------------------------
// 一个具体的工厂 对应 一个具体的产品

abstract class LoggerFactory {

    public void writeLog() {
        Logger logger = this.createLogger();
        logger.writeLog();
    }
    public abstract Logger createLogger();
}

class DatabaseLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}

class FileLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}

// -------------------------

class Client {
    public static void main(String[] args) {
        //LoggerFactory loggerFactory;
        //loggerFactory = new DatabaseLoggerFactory();
        //loggerFactory.createLogger().writeLog();
        //loggerFactory = new FileLoggerFactory();
        //loggerFactory.createLogger().writeLog();

        new DatabaseLoggerFactory().writeLog();
        new FileLoggerFactory().writeLog();
    }
}
