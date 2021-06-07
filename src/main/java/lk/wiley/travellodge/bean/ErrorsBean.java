package lk.wiley.travellodge.bean;

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
public class ErrorsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;

}