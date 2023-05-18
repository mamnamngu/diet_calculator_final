
import com.dietcalculator.dao.BillDAO;
import com.dietcalculator.dao.CommentDAO;
import com.dietcalculator.dao.DayDAO;
import com.dietcalculator.dao.ExSessionDAO;
import com.dietcalculator.dao.ExerciseDAO;
import com.dietcalculator.dao.UserDAO;
import com.dietcalculator.dto.Bill;
import com.dietcalculator.dto.Comment;
import com.dietcalculator.dto.Day;
import com.dietcalculator.dto.ExSession;
import com.dietcalculator.dto.Exercise;
import com.dietcalculator.dto.User;
import com.dietcalculator.util.Utils;
import java.sql.Date;

import java.util.List;

/**
 *
 * @author admin
 */
public class TestdaoCuaDat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        COMMENT TEST
//        CommentDAO dao = new CommentDAO();
//        boolean rs = dao.createComment("CMT000000", "U00000", "PRO0001", 0, "dep");
//        boolean rs = dao.updateComment("CMT000000", "U00000", "PRO0001", 0, "xau");
//        boolean rs = dao.deleteComment("CMT000000");
//        System.out.println(rs);
//        List<Comment> list = dao.readComment();
//        for (Comment ex : list) {
//            System.out.println(ex.toString());
//        }


//        EXERCISE TEST
//        ExerciseDAO dao = new ExerciseDAO();
//        boolean rs = dao.createExercise("EX057", "push up", 2.5, 5.2, 1000);
//        boolean rs = dao.updateExercise("EX057", "plank", 5, 3.2, 500);
//        boolean rs = dao.deleteExercise("EX057");

//        StringBuilder sb = new StringBuilder();
//        sb.append("'EX057'").append(",");
//        sb.append("'EX058'");
//        System.out.println(sb);

//        boolean rs = dao.deleteMultipleExercise(sb);
//        System.out.println(rs);
//        List<Exercise> list = dao.readExercise();
//        for(Exercise ex: list)
//            System.out.println(ex.toString());


//        EXSESSION TEST
//        ExSessionDAO dao = new ExSessionDAO();
//        boolean rs = dao.createExSession("SES000000", "EX055", "U00000", "DAY00000");
//        boolean rs = dao.updateExSession("SES000000", "EX056", "U00000", "DAY00000");
//        boolean rs = dao.deleteExSession("SES000000");
//        System.out.println(rs);
//        List<ExSession> list = dao.readExSession();
//        for(ExSession ex: list) {
//            System.out.println(ex.toString());
//        }



//        USER TEST
//        UserDAO dao = new UserDAO();
//        boolean rs = dao.createUser("U00001", "nam", Utils.convertJavaDateToSqlDate(2020, 12, 02), "12345678", "hcm", "nam@gmail.com", "123456", 65.5, 171, 1, 1, 0, 0, 2, 8, 3, 1, 1, 1, new Date(2023,2,26));
//        boolean rs = dao.updateUser("U00001", "dat", new Date(2016, 05, 02), "123456789", "hanoi", "dat@gmail.com", "1234567", 65.4, 172, 1, 1, 0, 0, 2, 8, 3, 1, 1, 1, new Date(2023, 03, 27));
//        boolean rs = dao.deleteUser("U00001");
//        System.out.println(rs);
//        List<User> list = dao.readUser();
//        for (User ex : list) {
//            System.out.println(ex.toString());
//        }

//        BILL TEST
//        BillDAO dao = new BillDAO();
//        boolean rs = dao.createBill("BILL000000", "U00000", Utils.convertJavaDateToSqlDate(2020, 12, 02), "", "");
//        boolean rs = dao.updateBill("BILL000000", "U00000", Utils.convertJavaDateToSqlDate(2020, 12, 02), "sss", "");
//        boolean rs = dao.deleteBill("BILL000000");
//        System.out.println(rs);
//        List<Bill> list = dao.readBillByUserID("U00000");
//        for (Bill ex : list) {
//            System.out.println(ex.toString());
//        }


//        DAY TEST
//        DayDAO dao = new DayDAO();
//        boolean rs = dao.createDay("DAY00001", "U00000", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//        boolean rs = dao.updateDay("DAY00001", "U00000", 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//        boolean rs = dao.deleteDay("DAY00001");
//        System.out.println(rs);
//        List<Day> list = dao.readDayByUserID("U00000");
//        for (Day ex : list) {
//            System.out.println(ex.toString());
//        }


    }

}
