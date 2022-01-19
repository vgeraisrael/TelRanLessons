package Controller;

import java.util.Scanner;

public class ConsoleInputOutput implements InputOutput {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String inputString(String prompt) {
        outputLine(prompt + " or cancel");
        String res = scanner.nextLine();
        if(res.toLowerCase().equals("cancel"))
            return null;
        return res;
    }

    @Override
    public void output(Object obj) {
        System.out.print(obj);
    }
}
