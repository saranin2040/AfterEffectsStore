import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    // Пример эндпоинта для получения данных
    @GetMapping("/api/data")
    public String getData() {
        // Ваш код для получения данных из базы данных или другого источника
        return "Some data from backend";
    }

    // Пример эндпоинта для отправки данных
    @PostMapping("/api/sendData")
    public String sendData(@RequestBody String data) {
        // Ваш код для обработки полученных данных, например, сохранение в базу данных
        return "Data received and processed: " + data;
    }
}