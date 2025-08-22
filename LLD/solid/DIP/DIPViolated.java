package LLD.solid.DIP;


class SQLSave {

    public void saveToSQL(String str)
    {
        System.out.println(str+" save into SQL DB");
    }
}
class NoSQLSave {

    public void saveToNoSQL(String str)
    {
        System.out.println(str+" save into NoSQL DB");
    }
}

class DBPersistence {
    SQLSave sql = new SQLSave();
    NoSQLSave nosql = new NoSQLSave();

    void saveToSQL_DB(String str)
    {
        sql.saveToSQL(str);
    }
    void saveToNoSQL_DB(String str)
    {
        nosql.saveToNoSQL(str);
    }
}


public class DIPViolated {
    
    public static void main(String[] args) {
        System.out.println("Violated Code");
        DBPersistence db = new DBPersistence();

        db.saveToNoSQL_DB("Gamebeez");
        db.saveToSQL_DB("Dispute Management System");
    }
}
