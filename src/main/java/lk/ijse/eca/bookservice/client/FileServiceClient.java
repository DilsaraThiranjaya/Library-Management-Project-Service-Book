package lk.ijse.eca.bookservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient(name = "file-service")
public interface FileServiceClient {

    @PostMapping(value = "/api/files/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Map<String, Object>> uploadFile(@RequestPart("file") MultipartFile file);

    @DeleteMapping("/api/files/{filename}")
    ResponseEntity<?> deleteFile(@PathVariable("filename") String filename);
}
