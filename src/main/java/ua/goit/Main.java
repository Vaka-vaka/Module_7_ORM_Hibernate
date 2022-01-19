package ua.goit;

import ua.goit.config.DbMigration;

public class Main {
    public static void main( String[] args ) {
        DbMigration.migrate();
    }
}
