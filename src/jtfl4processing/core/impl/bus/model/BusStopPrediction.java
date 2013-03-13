/*
* ##library.name##
* ##library.sentence##
* ##library.url##
*
* Copyright ##copyright## ##author.name##
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
* 
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
* 
* You should have received a copy of the GNU Lesser General
* Public License along with this library; if not, write to the
* Free Software Foundation, Inc., 59 Temple Place, Suite 330,
* Boston, MA  02111-1307  USA
* 
* @author      ##author.name##
* @modified    ##date##
* @version     ##library.prettyVersion## (##library.version##)
*
*
* BusPrediction is the representation of the data returned by the Bus (both stream and instant) APIs.
* The complete documentation about the Prediction data can be found on the TFL website at the following url:
* "http://www.tfl.gov.uk/assets/downloads/businessandpartners/tfl-live-bus-arrivals-api-documentation.pdf".
*/

package jtfl4processing.core.impl.bus.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import jtfl4processing.core.impl.bus.instant.BusStopInstantConst;

import com.google.gson.*;

public class BusStopPrediction implements Comparable<BusStopPrediction>{
	
	private String stopId;
	private Long timeStamp;
	private HashMap<String, String> resultMap;

	// GETTERS AND SETTERS
    public Long getResponseType(){ return Long.valueOf(resultMap.get(BusStopInstantConst.RESPONSE_TYPE)); }
	public String getStopId(){ return stopId; }
	public Long getTimeStamp(){return timeStamp; }
	public String getStopPointName(){ return resultMap.get(BusStopInstantConst.STOP_POINT_NAME); }
	public String getStopCode1(){ return resultMap.get(BusStopInstantConst.STOP_CODE_1); }
	public String getStopCode2(){ return resultMap.get(BusStopInstantConst.STOP_CODE_2); }
	public String getStopPointState(){ return resultMap.get(BusStopInstantConst.STOP_POINT_STATE); }
	public String getStopPointType(){ return resultMap.get(BusStopInstantConst.STOP_POINT_TYPE); }
	public String getStopPointIndicator(){ return resultMap.get(BusStopInstantConst.STOP_POINT_INDICATOR); }
	public String getTowards(){ return resultMap.get(BusStopInstantConst.TOWARDS); }
	public Long getBearing(){ return Long.valueOf(resultMap.get(BusStopInstantConst.BEARING)); }
	public String getLatitude(){ return resultMap.get(BusStopInstantConst.LATITUDE); }
	public String valueOfitude(){ return resultMap.get(BusStopInstantConst.LONGITUDE); }
	public Long getVisitNumber(){ return Long.valueOf(resultMap.get(BusStopInstantConst.VISIT_NUMBER)); }
	public Long getTripId(){ return Long.valueOf(resultMap.get(BusStopInstantConst.TRIP_ID)); }
	public String getVehicleId(){ return resultMap.get(BusStopInstantConst.VEHICLE_ID); }
	public String getRegistrationNumber(){ return resultMap.get(BusStopInstantConst.REGISTRATION_NUMBER); }
	public String getLineId(){ return resultMap.get(BusStopInstantConst.LINE_ID); }
	public String getLineName(){ return resultMap.get(BusStopInstantConst.LINE_NAME); }
	public String getDirectionId(){ return resultMap.get(BusStopInstantConst.DIRECTION_ID); }
	public String getDestinationText(){	return resultMap.get(BusStopInstantConst.DESTINATION_TEXT);	}
	public String getDestinationName(){	return resultMap.get(BusStopInstantConst.DESTINATION_NAME); }
	public Long getEstimatedTime(){	return Long.valueOf(resultMap.get(BusStopInstantConst.ESTIMATED_TIME)); }
	public Long getExpireTime(){ return Long.valueOf(resultMap.get(BusStopInstantConst.EXPIRE_TIME)); }
	
	public Date getTimeStampDate(){
		try{
			return new Date(this.getTimeStamp());
		}
		catch(Exception e){ 
			return null; 
		}
	}
	public Date getEstimatedTimeDate(){
		try {
			return new Date(this.getEstimatedTime());
		} catch (Exception e) {
			return null;
		}
	}
	public Date getExpireTimeDate(){
		try {
			return new Date(this.getExpireTime());
		} catch (Exception e) {
			return null;
		}
	}
	
	public String toJson(){
		return new Gson().toJson(this);
	}
    
	public BusStopPrediction(String stopId, ArrayList<APIParam> paramList, String[] returnList, Long timeStamp) throws Exception{
		
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
	public BusStopPrediction() {
		super();
	}
	
	@Override
	public int compareTo(BusStopPrediction o) {
		return (int)(this.getEstimatedTime() - o.getEstimatedTime());
	}
	 
}
