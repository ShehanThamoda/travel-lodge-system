package lk.wiley.travellodge.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class HotelDetailsResponse implements Serializable {
    private static final long serialVersionUID = 8805840964091900170L;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("availabe_rooms")
    private Integer availableRooms;



}
