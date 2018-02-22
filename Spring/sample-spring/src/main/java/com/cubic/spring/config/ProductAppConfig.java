package com.cubic.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@DependsOn({ "applicationConfig" })
public class ProductAppConfig {

	@Value("${usps.addverify.url}")
	private String uspsUrl;

	@Value("${app.maxthreadcount}")
	private Long maxThreadCount;

	@Value("${app.mainthreadcount}")
	private Long mainThreadCount;

	public String getUspsUrl() {
		return uspsUrl;
	}

	public void setUspsUrl(String uspsUrl) {
		this.uspsUrl = uspsUrl;
	}

	public Long getMaxThreadCount() {
		return maxThreadCount;
	}

	public void setMaxThreadCount(Long maxThreadCount) {
		this.maxThreadCount = maxThreadCount;
	}

	public Long getMainThreadCount() {
		return mainThreadCount;
	}

	public void setMainThreadCount(Long mainThreadCount) {
		this.mainThreadCount = mainThreadCount;
	}

	@Override
	public String toString() {
		return "ProductAppConfig [uspsUrl=" + uspsUrl + ", maxThreadCount=" + maxThreadCount + ", mainThreadCount="
				+ mainThreadCount + "]";
	}

}
