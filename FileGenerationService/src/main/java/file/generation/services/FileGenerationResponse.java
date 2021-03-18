package file.generation.services;

public class FileGenerationResponse {

    private final String status;
    private final Integer code;

    public FileGenerationResponse(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

}
