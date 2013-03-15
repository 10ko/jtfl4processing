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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import jtfl4processing.core.impl.bus.instant.BusStopInstantConst.StopInstantParams;

import com.google.gson.*;

public class BusStopPrediction implements Comparable<BusStopPrediction>{
	
	private String stopId;
	private Long timeStamp;
	private HashMap<String, String> resultMap;

    public Long getResponseType(){ return Long.valueOf(resultMap.get(StopInstantParams.RESPONSE_TYPE.getName())); }
	public String getStopId(){ return stopId; }
	public Long getTimeStamp(){return timeStamp; }
	public String getStopPointName(){ return resultMap.get(StopInstantParams.STOP_POINT_NAME.getName()); }
	public String getStopCode1(){ return resultMap.get(StopInstantParams.STOP_CODE_1.getName()); }
	public String getStopCode2(){ return resultMap.get(StopInstantParams.STOP_CODE_2.getName()); }
	public String getStopPointState(){ return resultMap.get(StopInstantParams.STOP_POINT_STATE.getName()); }
	public String getStopPointType(){ return resultMap.get(StopInstantParams.STOP_POINT_TYPE.getName()); }
	public String getStopPointIndicator(){ return resultMap.get(StopInstantParams.STOP_POINT_INDICATOR.getName()); }
	public String getTowards(){ return resultMap.get(StopInstantParams.TOWARDS.getName()); }
	public Long getBearing(){ return Long.valueOf(resultMap.get(StopInstantParams.BEARING.getName())); }
	public String getLatitude(){ return resultMap.get(StopInstantParams.LATITUDE.getName()); }
	public String valueOfitude(){ return resultMap.get(StopInstantParams.LONGITUDE.getName()); }
	public Long getVisitNumber(){ return Long.valueOf(resultMap.get(StopInstantParams.VISIT_NUMBER.getName())); }
	public Long getTripId(){ return Long.valueOf(resultMap.get(StopInstantParams.TRIP_ID.getName())); }
	public String getVehicleId(){ return resultMap.get(StopInstantParams.VEHICLE_ID.getName()); }
	public String getRegistrationNumber(){ return resultMap.get(StopInstantParams.REGISTRATION_NUMBER.getName()); }
	public String getLineId(){ return resultMap.get(StopInstantParams.LINE_ID.getName()); }
	public String getLineName(){ return resultMap.get(StopInstantParams.LINE_NAME.getName()); }
	public String getDirectionId(){ return resultMap.get(StopInstantParams.DIRECTION_ID.getName()); }
	public String getDestinationText(){	return resultMap.get(StopInstantParams.DESTINATION_TEXT.getName());	}
	public String getDestinationName(){	return resultMap.get(StopInstantParams.DESTINATION_NAME.getName()); }
	public Long getEstimatedTime(){	return Long.valueOf(resultMap.get(StopInstantParams.ESTIMATED_TIME.getName())); }
	public Long getExpireTime(){ return Long.valueOf(resultMap.get(StopInstantParams.EXPIRE_TIME.getName())); }
	
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
