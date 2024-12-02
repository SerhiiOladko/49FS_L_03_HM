package app;

import app.controller.BookController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("app");

        BookController controller = context.getBean(BookController.class);
        controller.start();

        context.close();
    }
}

