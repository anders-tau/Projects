package file.generation.services;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FileGenerationExceptionHandler extends RuntimeException {

    public FileGenerationExceptionHandler(String message, Throwable err, Class className, String methodName) {
        super(message, err);
        loggingException(message + " method: " + methodName, className);
    }

    private void loggingException(String message, Class className) {
        Logger log = Logger.getLogger(className.getName());
        log.log(Level.FINE, message);
    }
}
