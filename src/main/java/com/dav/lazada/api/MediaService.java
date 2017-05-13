package com.dav.lazada.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.dav.lazada.connect.SERVER;

@Path("/music")
public class MediaService {
	@GET
	@Path("/")
	public String hello(){
		return "Hello";
	}
	
	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getMedia() {
		String url ="http://" + SERVER.SERVER+ ":8080/LazadaAPI/musics/test-music.mp3";
		int start = 10000,end = 11200;
		
		JSONObject result = new JSONObject();
		try {
			result.put("url", url);
			result.put("start", start+"");
			result.put("end", end+"");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
	}
}
