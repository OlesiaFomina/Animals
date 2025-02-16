import java.io.IOException;

public class Counter implements AutoCloseable {
    private int count;
    private boolean isClosed;

    public Counter() {
        this.count = 0;
        this.isClosed = false;
    }

    public void add() throws IOException {
        if (isClosed) {
            throw new IOException("Счетчик закрыт.");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws IOException {
        if (!isClosed) {
            isClosed = true;
        } else {
            throw new IOException("Счетчик уже был закрыт.");
        }
    }

    public boolean isClosed() {
        return isClosed;
    }
}