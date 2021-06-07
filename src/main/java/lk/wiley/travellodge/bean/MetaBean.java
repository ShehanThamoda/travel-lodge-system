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
public class MetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int totalPages;
	private int currentPage;
	private long totalRecord;
}
