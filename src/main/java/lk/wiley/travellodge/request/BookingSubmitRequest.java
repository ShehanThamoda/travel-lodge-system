package lk.wiley.travellodge.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class BookingSubmitRequest implements Serializable {
    private static final long serialVersionUID = 8805840964091900170L;

    @JsonProperty("guest_id")
    @NotNull(message = "Guest Id cannot be null")
    @Valid
    private Integer guestId;

    @Valid
    @NotNull(message = "hotel id cannot be null")
    @JsonProperty("hotel_id")
    private Integer hotelId;

    @Valid
    @NotNull(message = "no of rooms cannot be null")
    @JsonProperty("no_of_room")
    private Integer noOfRooms;

    @Valid
    @NotNull(message = "adult count cannot be null")
    @JsonProperty("adult_count")
    private Integer adult;

    @Valid
    @JsonProperty("children_count")
    private Integer children;

    @Valid
    @NotNull(message = "date cannot be null")
    @JsonProperty("date")
    private String date;





}
