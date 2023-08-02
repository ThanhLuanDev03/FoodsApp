//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utils;

import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class MsgBox {
    public MsgBox() {

    }
   public static boolean actionForInvalidComponent(Component component, String type, String errorMessage){
        /* Types
        1.email
        2.sdt
        3.date
        */
        if(component instanceof JTextField){
            String value = ((JTextField) component).getText().trim();
            if(!value.equals("")){
                component.requestFocus();
                try{
                    if(type!=null){
                        if(type.equalsIgnoreCase("email")){
                            Pattern patternEmail= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
                            Matcher matcherEmail = patternEmail.matcher(value);
                            if(!matcherEmail.find()){
                                MsgBox.alert(component,errorMessage+" phải đúng định dạng");
                                return false;
                            }
                        }
                        if(type.equalsIgnoreCase("sdt")){
                            try{
                                int number = Integer.valueOf(value);
                                if(value.length()<7||value.length()>11){
                                    MsgBox.alert(component,"Số điện thoại phải từ 7-11 số");
                                    return false;
                                }
                            }catch (NumberFormatException numberFormatException){

                                MsgBox.alert(component,errorMessage+" không đúng định dạng");
                                return false;
                            }
                        }

                        if(type.equalsIgnoreCase("date")){
                            try {
                                if(value.contains("/")){
                                    LocalDate.parse(value,
                                            DateTimeFormatter.ofPattern("dd/MM/yyyy")
                                    );
                                }
                                if(value.contains("-")){
                                    LocalDate.parse(value,
                                            DateTimeFormatter.ofPattern("dd-MM-yyyy")
                                    );
                                }
                                if(value.contains(".")){
                                    LocalDate.parse(value,
                                            DateTimeFormatter.ofPattern("dd.MM.yyyy")
                                    );
                                }
                            } catch (DateTimeParseException e) {
                                e.printStackTrace();
                                MsgBox.alert(component,errorMessage+" phải đúng định dạng ");
                                return false;

                            }
                        }
                    }
                }catch (NullPointerException nullPointerException){
                    nullPointerException.printStackTrace();
                }
            }
            //empty value case
            else {
                component.requestFocus();
                MsgBox.alert(component,errorMessage+" đang bỏ trống");
                return false;
            }
        }

        if (component instanceof JRadioButton){

        }

        if(component instanceof JCheckBox){

        }
        if (component instanceof JTextArea){
            String value = ((JTextArea) component).getText().trim();
            if (value.equals("")){
                component.requestFocus();
                MsgBox.alert(component,errorMessage+" đang bỏ trống");
                return false;
            }
        }


        return true;
    }

    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Hệ thống quản lý đào tạo", 1);
    }

    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Hệ thống quản lý đào tạo", 0, 3);
        return result == 0;
    }

    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message, "Hệ thống quản lý đào tạo", 1);
    }
}

