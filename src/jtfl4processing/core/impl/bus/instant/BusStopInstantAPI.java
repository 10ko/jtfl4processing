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
import jtfl4processing.core.impl.bus.instant.BusStopInstantConst;
import jtfl4processing.core.impl.bus.instant.BusStopInstantConst.StopInstantParams;
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
		
		//We always get the ResponseType back, hence is added by default to the apiParams.
		apiParams.add(new APIParam(BusStopInstantConst.StopInstantParams.RESPONSE_TYPE.getName(), 
				BusStopInstantConst.StopInstantParams.RESPONSE_TYPE.getPosition()));
		
		
		if(params != null){
			for(String urlParam : params){
				urlParam = urlParam.toLowerCase();
				for(StopInstantParams sip : StopInstantParams.values()){
					if(urlParam.equals(sip.getName().toLowerCase())){
						url.append(sip.getName() + ",");
						apiParams.add(new APIParam(sip.getName(), sip.getPosition()));
					}
				}
			}
		}
		else{
			url.append(BusStopInstantConst.StopInstantParams.STOP_POINT_NAME.getName() + ",");
			apiParams.add(new APIParam(BusStopInstantConst.StopInstantParams.STOP_POINT_NAME.getName(),
					BusStopInstantConst.StopInstantParams.STOP_POINT_NAME.getPosition()));
			url.append(BusStopInstantConst.StopInstantParams.LINE_NAME.getName() + ",");
			apiParams.add(new APIParam(BusStopInstantConst.StopInstantParams.LINE_NAME.getName(),
					BusStopInstantConst.StopInstantParams.LINE_NAME.getPosition()));
			url.append(BusStopInstantConst.StopInstantParams.LINE_NAME.getName() + ",");
			apiParams.add(new APIParam(BusStopInstantConst.StopInstantParams.LINE_NAME.getName(),
					BusStopInstantConst.StopInstantParams.LINE_NAME.getPosition()));
			url.append(BusStopInstantConst.StopInstantParams.ESTIMATED_TIME.getName() + ",");
			apiParams.add(new APIParam(BusStopInstantConst.StopInstantParams.ESTIMATED_TIME.getName(),
					BusStopInstantConst.StopInstantParams.ESTIMATED_TIME.getPosition()));
		}
		try {
			List<BusStopPrediction> result = new ArrayList<BusStopPrediction>();
			String responseArr[] = loadStrings(url.toString());
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
