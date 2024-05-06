package mate.academy.rickandmorty.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ExternalCharacterDto {
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private List<String> origin;
    private List<String> location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

    @JsonProperty("id")
    public Long getExternalId() {
        return id;
    }
}
