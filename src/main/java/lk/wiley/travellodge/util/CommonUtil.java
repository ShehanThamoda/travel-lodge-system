/**
 * 
 */
package lk.wiley.travellodge.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.wiley.travellodge.bean.ErrorsBean;
import lk.wiley.travellodge.bean.MetaBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;


/**
 * @des common variables and methods define in here
 * @author shehan
 *
 */
@Component
public class CommonUtil {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);


	public static MetaBean setCommonPageDetails(int totalElements, int totalPages, int currentpage) {
		MetaBean meta = new MetaBean();
		meta.setTotalRecord(totalElements);
		meta.setTotalPages(totalPages);
		meta.setCurrentPage(currentpage + 1);
		return meta;
	}

	public static ErrorsBean setEmptyErrorObj() {

		ErrorsBean errorsBean = new ErrorsBean();
		errorsBean.setCode(String.valueOf(ErrorCodes.NO_RECORDS_FOUND_DB));
		errorsBean.setMessage("No records found");
		return errorsBean;
	}

	public static ErrorsBean setError(String code,String message){
		ErrorsBean errorsBean = new ErrorsBean();
		errorsBean.setCode(code);
		errorsBean.setMessage(message);
		return errorsBean;
	}

	public static Timestamp getDateTimeNow() {
		Date date = new Date();
		return new Timestamp(date.getTime());
	}

}
