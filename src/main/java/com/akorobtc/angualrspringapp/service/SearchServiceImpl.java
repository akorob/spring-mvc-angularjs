package com.akorobtc.angualrspringapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.akorobtc.angualrspringapp.beans.SiteImageInfo;

@Service
public class SearchServiceImpl implements SearchService  {
	
    //private static List<SiteImageInfo> resultList = new ArrayList<SiteImageInfo>();

	public List<SiteImageInfo> findSiteImageInfo (List<String> urls){
		
		ImageExtractor.clearResultList();
		List<Thread> threadList = new ArrayList<Thread>();
		for (int i = 0; i < urls.size(); i++){
			Thread th = new Thread (new ImageExtractor(urls.get(i)));
			th.start();
			threadList.add(th);
		}
		for (Thread thread : threadList){
			try{
				thread.join();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
		List<SiteImageInfo> list = ImageExtractor.getResultList();
		
/*		for (SiteImageInfo newOne : list){
			boolean contains = false;
			for (SiteImageInfo oldOne : resultList){
				if (newOne.getUrl().equals(oldOne.getUrl()) )
					contains = true;
			}
			if (!contains) {
				resultList.add(newOne);
			}
		}*/
		
		return list;
	}
	
	/*public List<SiteImageInfo> getAllResults(){
		return resultList;
	}
	
	public void removeAll(){
		resultList.clear();
	}*/
}
