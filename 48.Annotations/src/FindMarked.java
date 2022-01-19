import Annotations.Mark;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindMarked {

    public static final String ROOT_DIR = "application";
    public static final String AB_PATH = "C://Users//Professional//IdeaProjects//TelRanLessons//48.Annotations//src//application";

    public static void main(String[] args) throws IOException {

        Files.walk(Paths.get("48.Annotations/src/application"))
//                .forEach(path -> System.out.println(path.getFileName()));
                .map(path -> path.getFileName().toString())
                .filter(name -> name.endsWith(".java"))
                .map(str -> str.replace(".java", ""))
                .map((String className) -> {
                    if(new File(AB_PATH + "/pack1/" + className + ".java").exists()) {
                        try {
                            return Class.forName("application.pack1."+className);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            return Class.forName("application.pack2."+className);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    return null;
                })
                .filter(aClass -> aClass.isAnnotationPresent(Mark.class))
                .forEach(System.out::println);

    }
}
