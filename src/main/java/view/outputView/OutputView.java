package view.outputView;

public class OutputView {

    private final Output output;

    public OutputView(Output output) {
        this.output = output;
    }


    public void requestAnnounce(String announce) {
        output.print(announce);
    }

}
