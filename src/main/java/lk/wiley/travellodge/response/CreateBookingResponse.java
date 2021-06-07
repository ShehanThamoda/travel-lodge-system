package lk.wiley.travellodge.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.wiley.travellodge.bean.ErrorsBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author shehan
 *
 */

@Getter
@Setter
@ToString
public class CreateBookingResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private BookingResponse data;

    @JsonProperty("errors")
    private ErrorsBean errorsBean;

}
