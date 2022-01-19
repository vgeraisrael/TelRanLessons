package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public interface InputOutput {
    String inputString(String prompt);
    void output(Object obj);

    default void outputLine(Object obj){
        output(obj.toString() + "\n");
    }

    default <R> R inputObject(String prompt, String errorPrompt, Function<String, R> mapper){
        while(true){
            String text = inputString(prompt);
            if(text == null) return null; //*cheking if any input is present

            R res = mapper.apply(text); //*trying to parse user input
            if(res != null) return res;

            output(errorPrompt); //* Showing error message
        }
    }

    default Integer inputInteger(String prompt){
        return inputObject(prompt,"Invalid input. Input must be a decimal number \n", s -> {
            try{
                Integer res = Integer.parseInt(s);
                return res;
            } catch (Exception e){
                return null;
            }
        });
    }

    default Integer inputInteger(String prompt, Integer min, Integer max){
        return inputObject(prompt,String.format("Invalid input. Input must be a decimal number in range [%d - %d]", min, max), s -> {
            try{
                Integer res = Integer.parseInt(s);
                return res >= min && res <= max ? res : null;
            } catch (Exception e){
                return null;
            }
        });
    }

    default Double inputDouble(String prompt){
        return inputObject(prompt,"Invalid input. Input must be a number suitable to convert to double type, " +
                "(10 or 10.5 ) \n", s -> {
            try{
                Double res = Double.parseDouble(s);
                return res;
            } catch (Exception e){
                return null;
            }
        });
    }

    default Long inputLong(String prompt){
        return inputObject(prompt,"Invalid input. Input must be a decimal number \n", s -> {
            try{
                Long res = Long.parseLong(s);
                return res;
            } catch (Exception e){
                return null;
            }
        });
    }

    default String inputString(String prompt, List<String> options){
        return inputObject(prompt,"Invalid input. Input must be a String, and must be included to options list \n", s -> {
                for(String str : options) {
                    if( str.equals(s)){
                        return s;
                    }
                }
                return null;
        });
    }

    default LocalDate inputInteger(String prompt, String format){
        return inputObject(prompt,"Invalid input. Input must be a date and corresponds to format \n", s -> {
            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                LocalDate res = LocalDate.parse(s, formatter);
                return res;
            } catch (Exception e){
                return null;
            }
        });
    }
}
