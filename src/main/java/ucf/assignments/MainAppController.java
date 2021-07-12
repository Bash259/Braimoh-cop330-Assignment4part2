package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {
    @FXML
    public TextField _ListTitleGetter;

    public TableColumn<TodoListCollector, String> _Progress;
    public TableColumn<TodoListCollector,String> _DueDate;
    public TableView<TodoListCollector> _PrintList;
    public TableColumn<TodoListCollector,String> _PrintTask;

    @FXML
    private TextField _saveFile;

    @FXML
    private DatePicker _PickDate;

    @FXML
    private TextField _ItemField;

    @FXML
    public Label _ListName;

    public String ReturnToDoTitle() {
    String title = _ListTitleGetter.getText();
    _ListName.setText(title);
    return title;
    }

    public String ReturnListItem() {
        String Item = _ItemField.getText();
        return Item;
    }

    public JSONObject AddItem(javafx.event.ActionEvent actionEvent) {
            String Item = ReturnListItem();
            System.out.println(Item);

            String Date = ItemDate();
            System.out.println(ItemDate());

            JSONObject ToDoList = new JSONObject();
            ToDoList.put(Item, Date);

            TodoListCollector todoListCollector = new TodoListCollector("Not Done",_ItemField.getText(),_PickDate.getValue().toString());
            _PrintList.getItems().add(todoListCollector);
        return ToDoList;
    }


    public JSONArray ToDoListCollectorGen(JSONObject ToDoList) {
        JSONArray ToDoStorage = new JSONArray();
        for (int i=0 ;i < Integer.MAX_VALUE;i++){
            ToDoStorage.put(ToDoList);
        }
        return ToDoStorage;
    }

    public String ItemDate() {
        String Date = _PickDate.getValue().toString();
     return Date;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _PrintTask.setCellValueFactory(new PropertyValueFactory<>("Task"));
        _DueDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        _Progress.setCellValueFactory(new PropertyValueFactory<>("Progress"));

        _PrintList.setEditable(true);
        _PrintTask.setCellFactory(TextFieldTableCell.forTableColumn());
        _DueDate.setCellFactory(TextFieldTableCell.forTableColumn());
        _Progress.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void buttonRemove(javafx.event.ActionEvent actionEvent) {
        ObservableList<TodoListCollector> allProduct,SingleProduct;
        allProduct = _PrintList.getItems();
        SingleProduct = _PrintList.getSelectionModel().getSelectedItems();
        SingleProduct.forEach(allProduct::remove);
    }

    public void onEditChanged(TableColumn.CellEditEvent<TodoListCollector, String> todoListCollectorStringCellEditEvent) {
   TodoListCollector todoListCollector = _PrintList.getSelectionModel().getSelectedItem();
   todoListCollector.setTask(todoListCollectorStringCellEditEvent.getNewValue());
    }

    public void buttonClear(javafx.event.ActionEvent actionEvent) {
        ObservableList<TodoListCollector> allProduct,SingleProduct;
        _PrintList.getItems().clear();
    }

    public void saveList(ActionEvent actionEvent) {
        JSONArray saveThis = ToDoListCollectorGen(AddItem(actionEvent));
        String savePath = _saveFile.getText();
        try (FileWriter file = new FileWriter(savePath)) {
            file.write(saveThis.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LoadList(ActionEvent actionEvent) {
    }

    public void showDone(ActionEvent actionEvent) {

    }

}
