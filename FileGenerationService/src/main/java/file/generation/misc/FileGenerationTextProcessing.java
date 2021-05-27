package file.generation.misc;

import file.generation.models.FileGenerationEvent;
import file.generation.services.FileGenerationExceptionHandler;

import java.io.*;

public class FileGenerationTextProcessing {

    public void createTextFile(FileGenerationEvent event) throws IOException {
        String fileName = event.getDateTime() + ".txt";
        File file = new File(fileName);
        if (!file.createNewFile()) {
            throw new FileGenerationExceptionHandler("Error creating new file " + fileName,
                    null,
                    FileGenerationTextProcessing.class,
                    "createTextFile()");
        }
        try (FileWriter writer = new FileWriter(file, true))
        {
            writer.write(event.getParam1()); writer.append('\n');
            writer.write(event.getParam2()); writer.append('\n');
            writer.write(event.getParam3()); writer.append('\n');
            writer.write(event.getParam4()); writer.append('\n');
            writer.write(event.getParam5()); writer.append('\n');
            writer.flush();
        }
    }

    public void deleteTextFile(FileGenerationEvent event) {
        String fileName = event.getDateTime() + ".txt";
        File file = new File(fileName);
        if (!file.delete()) {
            throw new FileGenerationExceptionHandler("Error deleting file " + fileName,
                    null,
                    FileGenerationTextProcessing.class,
                    "deleteTextFile()");
        }
    }
}
