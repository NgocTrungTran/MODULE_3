package dhhighschool.studentmanagedh.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Validator implements IValidator{
    public static final String INT_REGEX = "^\\d+$";
    private String dateFormat;
    public Validator(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Validator() {

    }

    public boolean isIntValid(String number) {
        return Pattern.compile(INT_REGEX).matcher(number).matches();
    }
    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat (this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        Validator validator = new Validator ( "1996-03-25" );
//        System.out.println (validator.isValid ( "1996-03-25" ));
//    }
}
