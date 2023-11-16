package view.outputView;

public class ConsoleOutput implements Output {

    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
