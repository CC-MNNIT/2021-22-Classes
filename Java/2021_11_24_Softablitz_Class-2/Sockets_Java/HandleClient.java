import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class HandleClient implements Runnable {
    private Socket socket;
    ObjectInputStream objectInputStream;

    public HandleClient(Socket socket) {
        this.socket = socket;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Message message = (Message) objectInputStream.readObject();
                System.out.println("Message received");
                System.out.println(message);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }


}
