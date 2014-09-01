package com.akorobtc.angualrspringapp.service;

import java.util.List;

import com.akorobtc.angualrspringapp.beans.SiteImageInfo;

public interface SearchService {

	public abstract List<SiteImageInfo> findSiteImageInfo(List<String> urls);
	
	/*public abstract List<SiteImageInfo> getAllResults();
	public abstract void removeAll();*/
}