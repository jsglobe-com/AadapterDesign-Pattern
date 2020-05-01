import com.jsglobe.ui.MainForm;

import java.awt.*;

public class Program {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainForm form = new MainForm();
            form.setVisible(true);
        });
    }
}
