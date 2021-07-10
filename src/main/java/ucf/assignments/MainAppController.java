package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.io.OutputStreamWriter;

public class MainAppController {

    @FXML
    private String ReturnToDoTitle(InputMethodEvent event) {
        String Title = event.toString();
        return Title;
    }

    @FXML
    private Text DisplayEnteredTitle(OutputStreamWriter Output){
        Text OutputA = new Text(ReturnToDoTitle(null));
        return OutputA;
    }

    @FXML
    private String GetDateOfItem(ContextMenuEvent event) {
    return event.toString();
    }

    @FXML
    void ReturnListItem(ActionEvent event) {

    }

    @FXML
    void ToDoListCollector(ActionEvent event) {

    }

    @FXML
    void ToDoListEditor(ActionEvent event) {

    }

}
