package jtfl4processing.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import jtfl4processing.core.bus.instant.JTFLBusInstantConst;

import com.google.gson.*;

public class Prediction {
	
	private Long stopId;
	private Long timeStamp;
	private HashMap<String, String> resultMap;
		
	// GETTERS AND SETTERS
    public Long getResponseType(){ 
    	return Long.getLong(resultMap.get(JTFLBusInstantConst.RESPONSE_TYPE)); 
    }
	public Long getStopId(){ return stopId; }
	public Long getTimeStamp(){return timeStamp; }
	public String getStopPointName(){ return resultMap.get(JTFLBusInstantConst.STOP_POINT_NAME); }
	public String getStopCode1(){ return resultMap.get(JTFLBusInstantConst.STOP_CODE_1); }
	public String getStopCode2(){ return resultMap.get(JTFLBusInstantConst.STOP_CODE_2); }
	public String getStopPointState(){ return resultMap.get(JTFLBusInstantConst.STOP_POINT_STATE); }
	public String getStopPointType(){ return resultMap.get(JTFLBusInstantConst.STOP_POINT_TYPE); }
	public String getStopPointIndicator(){ return resultMap.get(JTFLBusInstantConst.STOP_POINT_INDICATOR); }
	public String getTowards(){ return resultMap.get(JTFLBusInstantConst.TOWARDS); }
	public Long getBearing(){ return Long.getLong(resultMap.get(JTFLBusInstantConst.BEARING)); }
	public String getLatitude(){ return resultMap.get(JTFLBusInstantConst.LATITUDE); }
	public String getLongitude(){ return resultMap.get(JTFLBusInstantConst.LONGITUDE); }
	public Long getVisitNumber(){ return Long.getLong(resultMap.get(JTFLBusInstantConst.VISIT_NUMBER)); }
	public Long getTripId(){ return Long.getLong(resultMap.get(JTFLBusInstantConst.TRIP_ID)); }
	public String getVehicleId(){ return resultMap.get(JTFLBusInstantConst.VEHICLE_ID); }
	public String getRegistrationNumber(){ return resultMap.get(JTFLBusInstantConst.REGISTRATION_NUMBER); }
	public String getLineId(){ return resultMap.get(JTFLBusInstantConst.LINE_ID); }
	public String getLineName(){ return resultMap.get(JTFLBusInstantConst.LINE_NAME); }
	public String getDirectionId(){ return resultMap.get(JTFLBusInstantConst.DIRECTION_ID); }
	public String getDestinationText(){	return resultMap.get(JTFLBusInstantConst.DESTINATION_TEXT);	}
	public String getDestinationName(){	return resultMap.get(JTFLBusInstantConst.DESTINATION_NAME); }
	public Long getEstimatedTime(){	return Long.getLong(resultMap.get(JTFLBusInstantConst.ESTIMATED_TIME)); }
	public Long getExpireTime(){ return Long.getLong(resultMap.get(JTFLBusInstantConst.EXPIRE_TIME)); }
	
	public String toJson(){
		return new Gson().toJson(this);
	}
    
	public Prediction(Long stopId, ArrayList<APIParam> paramList, String[] returnList, Long timeStamp) throws Exception{
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		Iterator<APIParam> iter = paramList.iterator();
		int i=0;
		
		if(returnList.length != paramList.size())
			throw new Exception("meeeh!!");
		
		while(iter.hasNext()){
			APIParam par = iter.next();
			resultMap.put(par.getKey(), returnList[i]);
			i++;
		}
		
		this.resultMap = resultMap;
		this.stopId = stopId;
		this.timeStamp = timeStamp;
	}
	public Prediction() {
		super();
	}    
}
