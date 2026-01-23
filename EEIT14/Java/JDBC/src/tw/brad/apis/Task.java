package tw.brad.apis;

public interface Task {
	void execute(StoreService service) throws Exception;
	String label();
}