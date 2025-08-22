package LLD.solid.DIP;

import javax.xml.crypto.Data;

interface Database {
    public void save(String str);
}

class SaveToSQL implements Database {

    public void save(String str) {
        System.out.println(
                "Executing SQL Query: INSERT INTO users VALUES('"
                        + str + "');");
    }
}

class SaveToNoSQL implements Database {

    public void save(String str) {
        System.out.println(
                "Executing NoSQL Query: db.users.insert({ name : "
                        + str + "});");
    }
}

class UserService {
    private Database db;

    public UserService(Database db) {
        this.db = db;
    }

    public void save(String str)
    {
        db.save(str);
    }

}

public class DIPFollowed {

    public static void main(String[] args) {
        SaveToSQL sql = new SaveToSQL();

        SaveToNoSQL nosql = new SaveToNoSQL();

        UserService service = new UserService(sql);
        service.save("Gamebeez");

        UserService service2 = new UserService(nosql);
        service2.save("Dispute Management System");
    }

}
