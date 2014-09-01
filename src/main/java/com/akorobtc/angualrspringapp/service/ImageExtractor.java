package com.akorobtc.angualrspringapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;



import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import com.akorobtc.angualrspringapp.beans.SiteImageInfo;

public class ImageExtractor implements Runnable{

	private static ConcurrentHashMap<SiteImageInfo, Object> map = new ConcurrentHashMap<SiteImageInfo, Object>();

	public static List<SiteImageInfo> getResultList() {
		return new ArrayList<SiteImageInfo>(map.keySet());
	}

	public static void clearResultList() {
		ImageExtractor.map = new ConcurrentHashMap<SiteImageInfo, Object>();;
	}

	private String webUrl;
	private int count;
	private long sizeInBytes;
	private long startTime;

	public ImageExtractor (String url){
		this.webUrl = url;
		this.startTime = new Date().getTime();
	}

	public void run() {
		try{
			findImages();
		} catch (Exception e){
			e.printStackTrace();
		}
		int procTime = (int)(new Date().getTime() - startTime);
		SiteImageInfo sii = new SiteImageInfo(webUrl, count, (int)(sizeInBytes/1024), startTime, procTime);
		map.put(sii,  new Object());
	}

	private void findImages() throws Exception {
		URL url = new URL(webUrl);
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		HTMLEditorKit htmlKit = new HTMLEditorKit();
		HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
		HTMLEditorKit.Parser parser = new ParserDelegator();
		HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
		parser.parse(br, callback, true);

		for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.IMG); iterator.isValid(); iterator.next()) {
			AttributeSet attributes =  iterator.getAttributes();
			String imgSrc = (String)attributes.getAttribute(HTML.Attribute.SRC);

			if (imgSrc != null && (imgSrc.endsWith(".jpg") || (imgSrc.endsWith(".png")) || (imgSrc.endsWith(".jpeg")) || (imgSrc.endsWith(".bmp")) || (imgSrc.endsWith(".ico")))) {
				count++;
				String imgUrl = webUrl;
				if (!(imgSrc.startsWith("http"))) {
					imgUrl = imgUrl + imgSrc;
				} else {
					imgUrl = imgSrc;
				}
				URL imageUrl = new URL(imgUrl);
				URLConnection conn = imageUrl.openConnection();
				sizeInBytes += conn.getContentLength();
			}

		}

	}

}
