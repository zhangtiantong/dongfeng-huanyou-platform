package com.navinfo.opentsp.dongfeng.common.rmi.module;

import java.io.Serializable;

public class HyPoint implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int latitude;
    private int longitude;
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
    
    
}
