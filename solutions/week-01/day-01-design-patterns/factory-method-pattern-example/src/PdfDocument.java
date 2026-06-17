// concrete product - handles pdf specific behaviour for open save and close
public class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("opening PDF document (.pdf)");
    }

    @Override
    public void save() {
        System.out.println("saving PDF document");
    }

    @Override
    public void close() {
        System.out.println("closing PDF document");
    }
}
