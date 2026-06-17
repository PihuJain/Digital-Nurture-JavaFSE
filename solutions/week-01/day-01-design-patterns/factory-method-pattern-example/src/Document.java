// product interface for the factory method pattern
// went with interface not abstract class because word pdf and excel share no common behaviour

public interface Document {
    void open();
    void save();
    void close();
}
