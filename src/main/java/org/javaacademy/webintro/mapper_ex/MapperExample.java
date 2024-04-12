package org.javaacademy.webintro.mapper_ex;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.FileOutputStream;

//@Service
@RequiredArgsConstructor
public class MapperExample {
    private final ObjectMapper objectMapper;

    @PostConstruct
    @SneakyThrows
    public void init() {
        String jsonData = "{\n"
                          + "\t\"name\": \"Aleksey\",\n"
                          + "\t\"surname\": \"Astapov\",\n"
                          + "\t\"timestamp\":\"2024-04-09T18:07+00:00\",\n"
                          + "\t\"clothes\": [\n"
                          + "\t\t\"t-shirt\",\n"
                          + "\t\t{\n"
                          + "\t\t\t\"name\": \"кроссовки\"\n"
                          + "\t\t}\n"
                          + "\t]\n"
                          + "}";
        Human human = objectMapper.readValue(jsonData, Human.class);
        System.out.println(human);
//		TypeReference<Map<String, Object>> typeReference = new TypeReference<>() {
//		};
//		Map<String, Object> map = objectMapper.readValue(jsonData, typeReference);
//		System.out.println(map);
//		Map<String, Object> sneakers = (Map<String, Object>) ((List) map.get("clothes")).get(1);
//		System.out.println(sneakers);
        human.setName("Aleksey");
        human.setSurname("Astapov");
        String newJson = objectMapper.writeValueAsString(human);
        System.out.println(newJson);
        objectMapper.writeValue(new FileOutputStream("my_json.json"), human);

    }
}
