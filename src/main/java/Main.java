import view.MenuPrincipal;
import view.ViewInterface;

public class Main{

    static ViewInterface start = new MenuPrincipal();

    public static void main(String[] args) {
        start.initComponents();
    }
}