package com.salesmanager.web.tags;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.salesmanager.core.business.merchant.model.MerchantStore;

public class ContentImageUrlTag extends TagSupport {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6319855234657139862L;
	private final static String STATIC_URI = "/ststic";
	private static final Logger LOGGER = LoggerFactory.getLogger(ContentImageUrlTag.class);

	private MerchantStore merchantStore;
	private String imageName;
	private String imageType;


	public int doStartTag() throws JspException {
		try {



			HttpServletRequest request = (HttpServletRequest) pageContext
					.getRequest();
			
			HttpSession session = request.getSession();

			StringBuilder imagePath = new StringBuilder();
			
			//TODO domain from merchant, else from global config, else from property (localhost)
			
			//http://domain/static/merchantid/imageType/imageName
			
			@SuppressWarnings("unchecked")
			Map<String,String> configurations = (Map<String, String>)session.getAttribute("STORECONFIGURATION");
			String scheme = (String)configurations.get("scheme");
			
			if(StringUtils.isBlank(scheme)) {
				scheme = "http";
			}
			
			imagePath.append(scheme).append("://").append(merchantStore.getDomainName()).append(STATIC_URI)
				.append(merchantStore.getCode()).append("/").append(this.getImageName())
				.append("/").append(this.getImageName());
			

			pageContext.getOut().print(imagePath.toString());


			
		} catch (Exception ex) {
			LOGGER.error("Error while getting content url", ex);
		}
		return SKIP_BODY;
	}

	public int doEndTag() {
		return EVAL_PAGE;
	}

	public void setMerchantStore(MerchantStore merchantStore) {
		this.merchantStore = merchantStore;
	}

	public MerchantStore getMerchantStore() {
		return merchantStore;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageType() {
		return imageType;
	}




	

}
