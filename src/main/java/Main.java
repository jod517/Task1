import DBUtill.DBUtill;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  throws SQLException {

//        UserDao dao = new UserDao();

        /*Connection con = DbUtil.getMysqlConnection();
        System.out.println( con.getAutoCommit());*/

        Connection con2 = DBUtill.getConnection();
        System.out.println( con2.getAutoCommit());
    }
}