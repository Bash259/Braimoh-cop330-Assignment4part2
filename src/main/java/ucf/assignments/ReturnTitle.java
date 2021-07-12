package ucf.assignments;

public class ReturnTitle extends MainAppController{
    public String ReturnToDoTitle() {
        String title = _ListTitleGetter.getText();
        _ListName.setText(title);
        return title;
    }
}
