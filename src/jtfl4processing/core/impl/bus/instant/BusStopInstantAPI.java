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
* BusInstantAPI is the main parser for the Bus Instant APIs.
* Its methods return a set of Prediction that will contain the predictions for a certain bus stop.
* 
*/

package jtfl4processing.core.impl.bus.instant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jtfl4processing.core.JTFLBase;
import jtfl4processing.core.JTFLBusAPI;
import jtfl4processing.core.impl.bus.model.APIParam;
import jtfl4processing.core.impl.bus.model.BusStopPrediction;

/**
 * @author tenko
 *
 */
public class BusStopInstantAPI extends JTFLBase implements JTFLBusAPI{
	
	/* (non-Javadoc)
	 * @see jtfl4processing.core.JTFLBusAPI#getBusPrevisionList(java.lang.Long)
	 */
	public List<BusStopPrediction> getBusStopPredictionList(String stopId){
		try{
			if(stopId != null && stopId != "")
				return getBusStopPredictionList(stopId, null);
			else
				throw new Exception("Error, cant't process the request without specifing a stopId!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see jtfl4processing.core.JTFLBusAPI#getBusPrevisionArray(java.lang.Long)
	 */
	public BusStopPrediction[] getBusStopPredictionArray(String stopId){
		try{
		if(stopId != null && stopId != "")
			return getBusStopPredictionArray(stopId, null);
		else
			throw new Exception("Error, cant't process the request without specifing a stopId!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
	
	/* (non-Javadoc)
	 * @see jtfl4processing.core.JTFLBusAPI#getBusPrevisionList(java.lang.Long, java.lang.String[])
	 */
	public List<BusStopPrediction> getBusStopPredictionList(String stopId, String... params){
		
		StringBuilder url = new StringBuilder(BusStopInstantConst.BUS_INSTANT_BASE_URL + "StopId=" + stopId + "&ReturnList=");
		Collection<APIParam> apiParams = new ArrayList<APIParam>();
		apiParams.add(new APIParam(BusStopInstantConst.RESPONSE_TYPE, 0));
		
		if(params != null){
			
			//url.append(JTFLBusInstantConst.RESPONSE_TYPE + ",");
			for(String urlParam : params){
				urlParam=urlParam.toLowerCase();
				if(urlParam.equals(BusStopInstantConst.STOP_POINT_NAME.toLowerCase())){
					url.append(BusStopInstantConst.STOP_POINT_NAME + ",");
					apiParams.add(new APIParam(BusStopInstantConst.STOP_POINT_NAME, 1));
				}
				else if(urlParam.equals(BusStopInstantConst.STOP_ID.toLowerCase())){
					url.append(BusStopInstantConst.STOP_ID + ",");
					apiParams.add(new APIParam(BusStopInstantConst.STOP_ID, 2));
				}
				else if(urlParam.equals(BusStopInstantConst.STOP_CODE_1.toLowerCase())){
					url.append(BusStopInstantConst.STOP_CODE_1 + ",");
					apiParams.add(new APIParam(BusStopInstantConst.STOP_CODE_1, 3));
				}
				else if(urlParam.equals(BusStopInstantConst.STOP_CODE_2.toLowerCase())){
					url.append(BusStopInstantConst.STOP_CODE_2 + ",");
					apiParams.add(new APIParam(BusStopInstantConst.STOP_CODE_2, 4));
				}
				else if(urlParam.equals(BusStopInstantConst.STOP_POINT_TYPE.toLowerCase())){
					url.append(BusStopInstantConst.STOP_POINT_TYPE + ",");
					apiParams.add(new APIParam(BusStopInstantConst.STOP_POINT_TYPE, 5));
				}
				else if(urlParam.equals(BusStopInstantConst.TOWARDS.toLowerCase())){
					url.append(BusStopInstantConst.TOWARDS + ",");
					apiParams.add(new APIParam(BusStopInstantConst.TOWARDS, 6));
				}
				else if(urlParam.equals(BusStopInstantConst.BEARING.toLowerCase())){
					url.append(BusStopInstantConst.BEARING + ",");
					apiParams.add(new APIParam(BusStopInstantConst.BEARING, 7));
				}
				else if(urlParam.equals(BusStopInstantConst.STOP_POINT_INDICATOR.toLowerCase())){
					url.append(BusStopInstantConst.STOP_POINT_INDICATOR + ",");
					apiParams.add(new APIParam(BusStopInstantConst.STOP_POINT_INDICATOR, 8));
				}
				else if(urlParam.equals(BusStopInstantConst.STOP_POINT_STATE.toLowerCase())){
					url.append(BusStopInstantConst.STOP_POINT_STATE + ",");
					apiParams.add(new APIParam(BusStopInstantConst.STOP_POINT_STATE, 9));
				}
				else if(urlParam.equals(BusStopInstantConst.LATITUDE.toLowerCase())){
					url.append(BusStopInstantConst.LATITUDE + ",");
					apiParams.add(new APIParam(BusStopInstantConst.LATITUDE, 10));
				}
				else if(urlParam.equals(BusStopInstantConst.LONGITUDE.toLowerCase())){
					url.append(BusStopInstantConst.LONGITUDE + ",");
					apiParams.add(new APIParam(BusStopInstantConst.LONGITUDE, 11));
				}
				else if(urlParam.equals(BusStopInstantConst.VISIT_NUMBER.toLowerCase())){
					url.append(BusStopInstantConst.VISIT_NUMBER + ",");
					apiParams.add(new APIParam(BusStopInstantConst.VISIT_NUMBER, 12));
				}
				else if(urlParam.equals(BusStopInstantConst.LINE_ID.toLowerCase())){
					url.append(BusStopInstantConst.LINE_ID + ",");
					apiParams.add(new APIParam(BusStopInstantConst.LINE_ID, 13));
				}
				else if(urlParam.equals(BusStopInstantConst.LINE_NAME.toLowerCase())){
					url.append(BusStopInstantConst.LINE_NAME + ",");
					apiParams.add(new APIParam(BusStopInstantConst.LINE_NAME, 14));
				}
				else if(urlParam.equals(BusStopInstantConst.DIRECTION_ID.toLowerCase())){
					url.append(BusStopInstantConst.DIRECTION_ID + ",");
					apiParams.add(new APIParam(BusStopInstantConst.DIRECTION_ID, 15));
				}
				else if(urlParam.equals(BusStopInstantConst.DESTINATION_TEXT.toLowerCase())){
					url.append(BusStopInstantConst.DESTINATION_TEXT + ",");
					apiParams.add(new APIParam(BusStopInstantConst.DESTINATION_TEXT, 16));
				}
				else if(urlParam.equals(BusStopInstantConst.DESTINATION_NAME.toLowerCase())){
					url.append(BusStopInstantConst.DESTINATION_NAME + ",");
					apiParams.add(new APIParam(BusStopInstantConst.DESTINATION_NAME, 17));
				}
				else if(urlParam.equals(BusStopInstantConst.VEHICLE_ID.toLowerCase())){
					url.append(BusStopInstantConst.VEHICLE_ID + ",");
					apiParams.add(new APIParam(BusStopInstantConst.VEHICLE_ID, 18));
				}
				else if(urlParam.equals(BusStopInstantConst.TRIP_ID.toLowerCase())){
					url.append(BusStopInstantConst.TRIP_ID + ",");
					apiParams.add(new APIParam(BusStopInstantConst.TRIP_ID, 19));
				}
				else if(urlParam.equals(BusStopInstantConst.REGISTRATION_NUMBER.toLowerCase())){
					url.append(BusStopInstantConst.REGISTRATION_NUMBER + ",");
					apiParams.add(new APIParam(BusStopInstantConst.REGISTRATION_NUMBER, 20));
				}
				else if(urlParam.equals(BusStopInstantConst.ESTIMATED_TIME.toLowerCase())){
					url.append(BusStopInstantConst.ESTIMATED_TIME + ",");
					apiParams.add(new APIParam(BusStopInstantConst.ESTIMATED_TIME, 21));
				}
				else if(urlParam.equals(BusStopInstantConst.EXPIRE_TIME.toLowerCase())){
					url.append(BusStopInstantConst.EXPIRE_TIME + ",");
					apiParams.add(new APIParam(BusStopInstantConst.EXPIRE_TIME, 22));
				}
			}
		}
		else{
			url.append(BusStopInstantConst.STOP_POINT_NAME + ",");
			apiParams.add(new APIParam(BusStopInstantConst.STOP_POINT_NAME, 1));
			url.append(BusStopInstantConst.LINE_NAME + ",");
			apiParams.add(new APIParam(BusStopInstantConst.LINE_NAME, 14));
			url.append(BusStopInstantConst.ESTIMATED_TIME + ",");
			apiParams.add(new APIParam(BusStopInstantConst.ESTIMATED_TIME, 21));
		}
		try {
			List<BusStopPrediction> result = new ArrayList<BusStopPrediction>();
			String responseArr[] = this.loadStrings(url.toString());
			Long timeStamp = null;
			for(String response : responseArr){
				response = response.replace("[","").replace("]","").replace("\"", "");
				String[] recordArray = response.split(",");
				if(timeStamp == null){
					timeStamp = Long.valueOf(recordArray[2]);
				}
				else{
					Collections.sort((List<APIParam>)apiParams);
					result.add(new BusStopPrediction(stopId, (ArrayList<APIParam>)apiParams, recordArray, timeStamp));
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see jtfl4processing.core.JTFLBusAPI#getBusPrevisionArray(java.lang.Long, java.lang.String[])
	 */
	public BusStopPrediction[] getBusStopPredictionArray(String stopId, String... params){
		try{
			List<BusStopPrediction> returnList = getBusStopPredictionList(stopId, params); 
			if(returnList != null && returnList.size() > 0){
				BusStopPrediction[] retArr = new BusStopPrediction[returnList.size()];
				System.arraycopy(returnList.toArray(), 0, retArr, 0, returnList.size());
				return retArr;
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
