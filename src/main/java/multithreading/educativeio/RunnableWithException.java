package multithreading.educativeio;

@FunctionalInterface
public interface RunnableWithException {
    void run() throws Exception;
}
