import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableWrittenObject extends ObjectOutputStream {
    public AppendableWrittenObject(OutputStream out) throws IOException, IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // Do nothing to avoid writing a new header
    }
}
