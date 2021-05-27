package web.service.misc;

import web.service.models.AppFields;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppTextProcessing {

    public void createTextFile(AppFields fields) throws IOException {
        String fileName = fields.getDateTime() + ".txt";
        File file = new File(fileName);
        if (!file.createNewFile()) { System.out.println("Error creating new file " + fileName); }
        try (FileWriter writer = new FileWriter(file, true))
        {
            writer.write(fields.getParam1()); writer.append('\n');
            writer.write(fields.getParam2()); writer.append('\n');
            writer.write(fields.getParam3()); writer.append('\n');
            writer.write(fields.getParam4()); writer.append('\n');
            writer.write(fields.getParam5()); writer.append('\n');
            writer.flush();
        }
    }
}
