package servlets;

public class DbConfig {
    private DbConfig() {}

    // Read from environment variables (Docker) or use defaults (local)
    public static String getDbHost() {
        String host = System.getenv("DB_HOST");
        return (host != null) ? host : "localhost";
    }

    public static String getDbPort() {
        String port = System.getenv("DB_PORT");
        return (port != null) ? port : "1521";
    }

    public static String getDbService() {
        String service = System.getenv("DB_SERVICE");
        return (service != null) ? service : "FREEPDB1";
    }

    public static String getDbUser() {
        String user = System.getenv("DB_USER");
        return (user != null) ? user : "shoaib";
    }

    public static String getDbPassword() {
        String pass = System.getenv("DB_PASSWORD");
        return (pass != null) ? pass : "system";
    }

    public static String getUrl() {
        return "jdbc:oracle:thin:@" + getDbHost() + ":" + getDbPort() + "/" + getDbService();
    }
}
