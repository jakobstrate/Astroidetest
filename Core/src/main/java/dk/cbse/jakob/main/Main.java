package dk.cbse.jakob.main;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    public static void main (String[] args){
        launch(Main.class);
    }
    @Override
    public void start(Stage window)throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        for (String beans : context.getBeanDefinitionNames()) {
            System.out.println(beans);
        }


        App app = context.getBean(App.class);
        app.start(window);
        app.render();
    }
}
