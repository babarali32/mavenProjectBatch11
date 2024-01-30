package utils;

import org.junit.Test;

public class APIpayloadBodyConstants {
    @Test
    public static String createEmployeePayload(){
        String createBody="{\n" +
                "  \"emp_firstname\": \"sum\",\n" +
                "  \"emp_lastname\": \"sim\",\n" +
                "  \"emp_middle_name\": \"som\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2020-01-30\",\n" +
                "  \"emp_status\": \"bad\",\n" +
                "  \"emp_job_title\": \"labor\"\n" +
                "}";
        return createBody;
    }
}
