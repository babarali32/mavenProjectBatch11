package utils;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;


public class APIpayloadBodyConstants {
    @Test
    public static String createEmployeePayload() {
        String createBody = "{\n" +
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

    public static String createEmployejsonBody() {
        // this is like a map created, and putting the values inside this.
// above method is
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "village");
        obj.put("emp_lastname", "town");
        obj.put("emp_middle_name", "city");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2000-02-20");
        obj.put("emp_status", "pending");
        obj.put("emp_job_title", "searching");


// all putted values s are stored inside the obj variable
        // only obj can not return becasue method is String return, obj is json map return
        return obj.toString();
    }

    public static String payloadMoreDynamic
            (String emp_firstname,
             String emp_middle_name, String emp_lastname,
             String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);
        return obj.toString();
    }

    public static String updateCreatedEmployee() {
        JSONObject obj = new JSONObject();
        obj.put("employee_id", "103644A");
        obj.put("emp_firstname", "village");
        obj.put("emp_lastname", "town");
        obj.put("emp_middle_name", "city");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2000-02-20");
        obj.put("emp_status", "pending");
        obj.put("emp_job_title", "searching");


// all putted values s are stored inside the obj variable
        // only obj can not return becasue method is String return, obj is json map return
        return obj.toString();
    }
}