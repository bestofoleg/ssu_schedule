import events.ScheduleSearchEvent;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tables.forms.MyTable;

public class Main extends Application
{
    private Button submitButton;
    private Text facultyText;
    private Text groupNumberText;
    private Scene mainScene;
    private BorderPane mainPane;
    private final Point2D windowSize = new Point2D(800,600);
    private HBox mainMenuPane;
    private ComboBox<String> facultyComboBox;
    private TextField groupNumberTextField;
    private MyTable schedule;

    public static void main(String[] args)
    {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("SSU Schedule");
        primaryStage.setResizable(false);

        this.schedule = new MyTable();

//        List<MyColumn> columns = new ArrayList<>();
//
//        columns.add(new MyColumn("пн"));
//        columns.add(new MyColumn("вт"));
//        columns.add(new MyColumn("ср"));
//        columns.add(new MyColumn("чт"));
//        columns.add(new MyColumn("пт"));
//        columns.add(new MyColumn("сб"));
//
//        Random random = new Random();
//
//        int cellsCount = 0;
//
//        for(MyColumn column : columns)
//        {
//            column.setMaxWidth(40);
//            column.setMaxHeight(40);
//            column.setMinWidth(40);
//            column.setMinHeight(40);
//            cellsCount = random.nextInt(5);
//            for(int i = 0;i < cellsCount;i ++)
//            {
//                column.addCell(new MyCell(i + ""));
//            }
//            this.schedule.addColumn(column);
//
//        }


        this.facultyText = new Text("Факультет");
        this.groupNumberText = new Text("Номер группы");
        this.facultyComboBox = new ComboBox<>();
        this.facultyComboBox.getItems().addAll(

                "КНиИТ",
                "Мех-мат",
                "ФНБМТ"

        );
        this.groupNumberTextField = new TextField();


        this.submitButton = new Button("Узнать расписание");
        this.submitButton.setOnAction(new ScheduleSearchEvent(
                this.facultyComboBox,
                this.groupNumberTextField,
                this.schedule
        ));

        this.mainMenuPane = new HBox();
        this.mainMenuPane.getChildren().addAll(
                this.facultyText,
                this.facultyComboBox,
                this.groupNumberText,
                this.groupNumberTextField,
                this.submitButton
        );

        this.mainPane = new BorderPane();
        this.mainPane.setTop(this.mainMenuPane);
        this.mainPane.setCenter(this.schedule);
        this.mainScene = new Scene(this.mainPane, this.windowSize.getX(), this.windowSize.getY());

        primaryStage.setScene(this.mainScene);
        primaryStage.show();
    }
}
