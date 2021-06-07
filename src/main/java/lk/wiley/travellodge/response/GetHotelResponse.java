package lk.wiley.travellodge.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.wiley.travellodge.bean.ErrorsBean;
import lk.wiley.travellodge.bean.MetaBean;
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
public class GetHotelResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private HotelDetailsResponse hotelDetailsResponse;

    @JsonProperty("errors")
    private ErrorsBean errorsBean;

    @JsonProperty("meta")
    private MetaBean metaBean;

}
