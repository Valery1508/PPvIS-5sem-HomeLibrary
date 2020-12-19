package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.service.*;

import java.sql.SQLException;

public class UI {

    UserServiceImplementation userService;
    AudioServiceImplementation audioService;
    VideoServiceImplementation videoService;
    BookServiceImplementation bookService;
    AuthorizationServiceImplementation authorizationService;

    Stage stage;
    private Scene scene;
    private BorderPane root;
    private MenuBar menuBar;
    private Label welcomeText;
    private Button enter, register;
    private VBox group;

    public UI(Stage stage) {
        this.stage = stage;
    }

    public void show(){

        root = new BorderPane();
        root.setCenter(showEnterWindow());
        scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(600);
        stage.setResizable(false);
        stage.setTitle("Домашняя библиотека");
        stage.show();
    }

    public VBox showEnterWindow(){
        welcomeText = new Label("Добро пожаловать в систему домашней библиотеки!");
        welcomeText.setFont(Font.font(22));
        welcomeText.setStyle("-fx-font-weight: bold");

        enter = new Button("Войти в акк");
        enter.setOnAction(actionEvent -> {
            root.setCenter(showAuthorizationMenu());
        });

        register = new Button("Зарегистрироваться");
        register.setOnAction(actionEvent -> {
            root.setCenter(showRegistrationMenu());
        });

        group = new VBox();
        group.getChildren().addAll(welcomeText, enter, register);
        group.setSpacing(10);
        group.setPadding(new Insets(10, 0, 0, 10));
        return group;
    }

    public VBox showAuthorizationMenu(){
        Label loginL = new Label("Логин");
        TextField loginT = new TextField("");
        Label passwordL = new Label("Пароль");
        TextField passwordT = new TextField("");
        Button enterB = new Button("Войти в акк");
        enterB.setOnAction(actionEvent -> {
            root.setCenter(showEnterWindow());
        });

        VBox aythoriz = new VBox();
        aythoriz.getChildren().addAll(loginL, loginT, passwordL, passwordT, enterB);
        aythoriz.setSpacing(10);
        aythoriz.setPadding(new Insets(10, 10, 0, 10));
        return aythoriz;

//+ authorize
    }
    public VBox showRegistrationMenu(){
        RadioButton parentRB = new RadioButton("Родитель");
        RadioButton childRB = new RadioButton("Ребенок");
        ToggleGroup group = new ToggleGroup();
        parentRB.setToggleGroup(group);
        childRB.setToggleGroup(group);

        Label surnameL = new Label("Фамилия");
        TextField surnameT = new TextField("");
        Label nameL = new Label("Имя");
        TextField nameT = new TextField("");
        Label otchestvoL = new Label("Отчество");
        TextField otchestvoT = new TextField("");
        Label ageL = new Label("Возраст");
        TextField ageT = new TextField("");
        Label loginL = new Label("Логин");
        TextField loginT = new TextField("");
        Label passwordL = new Label("Пароль");
        TextField passwordT = new TextField("");
        Button registerB = new Button("Зарегистрироваться");

        registerB.setOnAction(actionEvent -> {
            if(parentRB.isSelected()) {root.setCenter(showParentMenu());}
            if(childRB.isSelected()) {root.setCenter(showUseContentMenu());}
        });

        VBox registerVB = new VBox();
        registerVB.getChildren().addAll(parentRB, childRB, surnameL, surnameT, nameL, nameT, otchestvoL, otchestvoT,
                                        ageL, ageT, loginL, loginT, passwordL, passwordT,  registerB);
        registerVB.setSpacing(10);
        registerVB.setPadding(new Insets(10, 10, 0, 10));
        return registerVB;

//+register
    }
    public VBox showChildMenu(){
        VBox childMenuVB = new VBox();
        /*childMenuVB.getChildren().addAll(addContentB, editContentB, deleteContentB, useContentB);*/
        childMenuVB.setSpacing(10);
        childMenuVB.setPadding(new Insets(10, 10, 0, 10));
        return childMenuVB;
    }
    public VBox showParentMenu(){
        Button addContentB = new Button("Добавить контент");
        addContentB.setOnAction(actionEvent -> {
            root.setCenter(showAddContentMenu());
        });

        Button editContentB = new Button("Изменить контент");
        editContentB.setOnAction(actionEvent -> {
            root.setCenter(showEditContentMenu());
        });

        Button deleteContentB = new Button("Удалить контент");
        deleteContentB.setOnAction(actionEvent -> {
            root.setCenter(showDeleteContentMenu());
        });

        Button useContentB = new Button("Использовать контент");
        useContentB.setOnAction(actionEvent -> {
            root.setCenter(showUseContentMenu());
        });

        VBox parentMenuVB = new VBox();
        parentMenuVB.getChildren().addAll(addContentB, editContentB, deleteContentB, useContentB);
        parentMenuVB.setSpacing(10);
        parentMenuVB.setPadding(new Insets(10, 10, 0, 10));
        return parentMenuVB;
    }
    public VBox showAddContentMenu(){
        Label nameL = new Label("Название");
        TextField nameT = new TextField("");
        Label ageL = new Label("Допустимый возраст для просмотра");
        TextField ageT = new TextField("");
        Button loadB = new Button("Загрузить с компьютера");

        ObservableList<String> langs = FXCollections.observableArrayList("Фильм", "Аудиозапись", "Книга");
        ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        langsComboBox.setValue("Фильм");
        Button addContentB = new Button("Добавить контент");

        addContentB.setOnAction(actionEvent -> {
            root.setCenter(showParentMenu());
        });

        VBox addContentMenuVB = new VBox();
        addContentMenuVB.getChildren().addAll(nameL, nameT, ageL, ageT, loadB, langsComboBox, addContentB);
        addContentMenuVB.setSpacing(10);
        addContentMenuVB.setPadding(new Insets(10, 10, 0, 10));
        return addContentMenuVB;

//+add content
    }
    public VBox showDeleteContentMenu(){
        ObservableList<String> langs = FXCollections.observableArrayList("Коллекция фильмов", "Коллекция аудиозаписей", "Коллекция книг");
        ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        langsComboBox.setValue("Коллекция фильмов");
        Button updateContentB = new Button("Обновить таблицу");

        ObservableList<String> elements = FXCollections.observableArrayList("Дукы", "18+");
        TableView<String> table = new TableView<String>(elements);
        table.setPrefWidth(250);
        table.setPrefHeight(200);

        TableColumn<String, String> nameColumn = new TableColumn<String, String>("Название");
        table.getColumns().add(nameColumn);

        TableColumn<String, String> ageColumn = new TableColumn<String, String>("Возрастное ограничение");
        table.getColumns().add(ageColumn);

        Button deleteContentB = new Button("Удалить элемент");
        deleteContentB.setOnAction(actionEvent -> {
            root.setCenter(showParentMenu());
        });

        VBox deleteContentMenuVB = new VBox();
        deleteContentMenuVB.getChildren().addAll(langsComboBox, updateContentB, table, deleteContentB);
        deleteContentMenuVB.setSpacing(10);
        deleteContentMenuVB.setPadding(new Insets(10, 10, 0, 10));
        return deleteContentMenuVB;

//+delete content
    }
    public VBox showEditContentMenu(){
        ObservableList<String> langs = FXCollections.observableArrayList("Коллекция фильмов", "Коллекция аудиозаписей", "Коллекция книг");
        ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        langsComboBox.setValue("Коллекция фильмов");
        Button updateContentB = new Button("Обновить таблицу");

        ObservableList<String> elements = FXCollections.observableArrayList("Дукы", "18+");
        TableView<String> table = new TableView<String>(elements);
        table.setPrefWidth(250);
        table.setPrefHeight(200);

        TableColumn<String, String> nameColumn = new TableColumn<String, String>("Название");
        table.getColumns().add(nameColumn);

        TableColumn<String, String> ageColumn = new TableColumn<String, String>("Возрастное ограничение");
        table.getColumns().add(ageColumn);

        Button editContentB = new Button("Изменить элемент");
        editContentB.setOnAction(actionEvent -> {
            root.setCenter(showParentMenu());
        });

        VBox editContentMenuVB = new VBox();
        editContentMenuVB.getChildren().addAll(langsComboBox, updateContentB, table, editContentB);
        editContentMenuVB.setSpacing(10);
        editContentMenuVB.setPadding(new Insets(10, 10, 0, 10));
        return editContentMenuVB;

//+edit content
    }
    public VBox showUseContentMenu(){
        ObservableList<String> langs = FXCollections.observableArrayList("Коллекция фильмов", "Коллекция аудиозаписей", "Коллекция книг");
        ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        langsComboBox.setValue("Коллекция фильмов");
        Button updateContentB = new Button("Обновить таблицу");

        ObservableList<String> elements = FXCollections.observableArrayList("Дукы", "18+");
        TableView<String> table = new TableView<String>(elements);
        table.setPrefWidth(250);
        table.setPrefHeight(200);

        TableColumn<String, String> nameColumn = new TableColumn<String, String>("Название");
        table.getColumns().add(nameColumn);

        TableColumn<String, String> ageColumn = new TableColumn<String, String>("Возрастное ограничение");
        table.getColumns().add(ageColumn);

        Button openContentB = new Button("Открыть элемент");
        openContentB.setOnAction(actionEvent -> {
            root.setCenter(showParentMenu());
        });

        VBox useContentMenuVB = new VBox();
        useContentMenuVB.getChildren().addAll(langsComboBox, updateContentB, table, openContentB);
        useContentMenuVB.setSpacing(10);
        useContentMenuVB.setPadding(new Insets(10, 10, 0, 10));
        return useContentMenuVB;

//+use content
    }

    public UserServiceImplementation getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImplementation userService) {
        this.userService = userService;
    }

    public AudioServiceImplementation getAudioService() {
        return audioService;
    }

    public void setAudioService(AudioServiceImplementation audioService) {
        this.audioService = audioService;
    }

    public VideoServiceImplementation getVideoService() {
        return videoService;
    }

    public void setVideoService(VideoServiceImplementation videoService) {
        this.videoService = videoService;
    }

    public BookServiceImplementation getBookService() {
        return bookService;
    }

    public void setBookService(BookServiceImplementation bookService) {
        this.bookService = bookService;
    }

    public AuthorizationServiceImplementation getAuthorizationService() {
        return authorizationService;
    }

    public void setAuthorizationService(AuthorizationServiceImplementation authorizationService) {
        this.authorizationService = authorizationService;
    }
}
