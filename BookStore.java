import Models.SQLDatabase;
import Views.Home.HomeView;

public class BookStore {
    public static void main(String[] args) throws Exception {
        final int WINDOW_WIDTH = 1000;
        final int WINDOW_HEIGHT = 600;

        SQLDatabase sys = new SQLDatabase("root", "reallyStrongPwd123");
        sys.connectTo("jdbc:mysql://localhost:3306/sys");


        HomeView main = new HomeView(WINDOW_WIDTH, WINDOW_HEIGHT);

        main.render();
    }
}
