package sample;

import javafx.stage.Stage;
import sample.model.User;
import sample.service.*;
import sample.view.UI;

public class HomeLibrary {
    Stage primaryStage;
    private UI ui;

    public HomeLibrary(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void createUI(){
        AudioServiceImplementation audioService = new AudioServiceImplementation();
        VideoServiceImplementation videoService= new VideoServiceImplementation();
        BookServiceImplementation bookService = new BookServiceImplementation();
        AuthorizationServiceImplementation authorizationService = new AuthorizationServiceImplementation();
        UserServiceImplementation userService = new UserServiceImplementation();

        User lera = new User(1, true, "Zubr", "Lera", "Gen", 30, "login123", "pas123");
        userService.createUser(lera);
        User valera = new User(1, false, "Rudy", "Vaera", "Nor", 12, "login3", "pas3");
        userService.createUser(lera);


        UI ui = new UI(primaryStage);
        ui.setUserService(userService);
        ui.setAudioService(audioService);
        ui.setAuthorizationService(authorizationService);
        ui.setBookService(bookService);
        ui.setVideoService(videoService);
        ui.show();
    };
}
