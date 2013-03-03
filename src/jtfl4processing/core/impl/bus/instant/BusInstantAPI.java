package jtfl4processing.core.impl.bus.instant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jtfl4processing.core.JTFLBase;
import jtfl4processing.core.JTFLBusAPI;
import jtfl4processing.core.impl.bus.model.APIParam;
import jtfl4processing.core.impl.bus.model.BusPrediction;

public class BusInstantAPI extends JTFLBase implements JTFLBusAPI{
	
	public List<BusPrediction> getBusPrevisionList(Long stopId) throws Exception{
		if(stopId != null && stopId > 0)
			return getBusPrevisionList(stopId, null);
		else
			throw new Exception("Error, cant't process the request without specifing a stopId!");
		
	}
	
	public BusPrediction[] getBusPrevisionArray(Long stopId) throws Exception{
		if(stopId != null && stopId > 0)
			return getBusPrevisionArray(stopId, null);
		else
			throw new Exception("Error, cant't process the request without specifing a stopId!");
	}
	
	public List<BusPrediction> getBusPrevisionList(Long stopId, String... params){
		if(params == null);
		StringBuilder url = new StringBuilder(BusInstantConst.BUS_INSTANT_BASE_URL + "StopId=" + stopId + "&ReturnList=");
		Collection<APIParam> apiParams = new ArrayList<APIParam>();
		
		//url.append(JTFLBusInstantConst.RESPONSE_TYPE + ",");
		apiParams.add(new APIParam(BusInstantConst.RESPONSE_TYPE, 0));
		
		for(String urlParam : params){
			urlParam=urlParam.toLowerCase();
			if(urlParam.equals(BusInstantConst.STOP_POINT_NAME.toLowerCase())){
				url.append(BusInstantConst.STOP_POINT_NAME + ",");
				apiParams.add(new APIParam(BusInstantConst.STOP_POINT_NAME, 1));
			}
			else if(urlParam.equals(BusInstantConst.STOP_ID.toLowerCase())){
				url.append(BusInstantConst.STOP_ID + ",");
				apiParams.add(new APIParam(BusInstantConst.STOP_ID, 2));
			}
			else if(urlParam.equals(BusInstantConst.STOP_CODE_1.toLowerCase())){
				url.append(BusInstantConst.STOP_CODE_1 + ",");
				apiParams.add(new APIParam(BusInstantConst.STOP_CODE_1, 3));
			}
			else if(urlParam.equals(BusInstantConst.STOP_CODE_2.toLowerCase())){
				url.append(BusInstantConst.STOP_CODE_2 + ",");
				apiParams.add(new APIParam(BusInstantConst.STOP_CODE_2, 4));
			}
			else if(urlParam.equals(BusInstantConst.STOP_POINT_TYPE.toLowerCase())){
				url.append(BusInstantConst.STOP_POINT_TYPE + ",");
				apiParams.add(new APIParam(BusInstantConst.STOP_POINT_TYPE, 5));
			}
			else if(urlParam.equals(BusInstantConst.TOWARDS.toLowerCase())){
				url.append(BusInstantConst.TOWARDS + ",");
				apiParams.add(new APIParam(BusInstantConst.TOWARDS, 6));
			}
			else if(urlParam.equals(BusInstantConst.BEARING.toLowerCase())){
				url.append(BusInstantConst.BEARING + ",");
				apiParams.add(new APIParam(BusInstantConst.BEARING, 7));
			}
			else if(urlParam.equals(BusInstantConst.STOP_POINT_INDICATOR.toLowerCase())){
				url.append(BusInstantConst.STOP_POINT_INDICATOR + ",");
				apiParams.add(new APIParam(BusInstantConst.STOP_POINT_INDICATOR, 8));
			}
			else if(urlParam.equals(BusInstantConst.STOP_POINT_STATE.toLowerCase())){
				url.append(BusInstantConst.STOP_POINT_STATE + ",");
				apiParams.add(new APIParam(BusInstantConst.STOP_POINT_STATE, 9));
			}
			else if(urlParam.equals(BusInstantConst.LATITUDE.toLowerCase())){
				url.append(BusInstantConst.LATITUDE + ",");
				apiParams.add(new APIParam(BusInstantConst.LATITUDE, 10));
			}
			else if(urlParam.equals(BusInstantConst.LONGITUDE.toLowerCase())){
				url.append(BusInstantConst.LONGITUDE + ",");
				apiParams.add(new APIParam(BusInstantConst.LONGITUDE, 11));
			}
			else if(urlParam.equals(BusInstantConst.VISIT_NUMBER.toLowerCase())){
				url.append(BusInstantConst.VISIT_NUMBER + ",");
				apiParams.add(new APIParam(BusInstantConst.VISIT_NUMBER, 12));
			}
			else if(urlParam.equals(BusInstantConst.LINE_ID.toLowerCase())){
				url.append(BusInstantConst.LINE_ID + ",");
				apiParams.add(new APIParam(BusInstantConst.LINE_ID, 13));
			}
			else if(urlParam.equals(BusInstantConst.LINE_NAME.toLowerCase())){
				url.append(BusInstantConst.LINE_NAME + ",");
				apiParams.add(new APIParam(BusInstantConst.LINE_NAME, 14));
			}
			else if(urlParam.equals(BusInstantConst.DIRECTION_ID.toLowerCase())){
				url.append(BusInstantConst.DIRECTION_ID + ",");
				apiParams.add(new APIParam(BusInstantConst.DIRECTION_ID, 15));
			}
			else if(urlParam.equals(BusInstantConst.DESTINATION_TEXT.toLowerCase())){
				url.append(BusInstantConst.DESTINATION_TEXT + ",");
				apiParams.add(new APIParam(BusInstantConst.DESTINATION_TEXT, 16));
			}
			else if(urlParam.equals(BusInstantConst.DESTINATION_NAME.toLowerCase())){
				url.append(BusInstantConst.DESTINATION_NAME + ",");
				apiParams.add(new APIParam(BusInstantConst.DESTINATION_NAME, 17));
			}
			else if(urlParam.equals(BusInstantConst.VEHICLE_ID.toLowerCase())){
				url.append(BusInstantConst.VEHICLE_ID + ",");
				apiParams.add(new APIParam(BusInstantConst.VEHICLE_ID, 18));
			}
			else if(urlParam.equals(BusInstantConst.TRIP_ID.toLowerCase())){
				url.append(BusInstantConst.TRIP_ID + ",");
				apiParams.add(new APIParam(BusInstantConst.TRIP_ID, 19));
			}
			else if(urlParam.equals(BusInstantConst.REGISTRATION_NUMBER.toLowerCase())){
				url.append(BusInstantConst.REGISTRATION_NUMBER + ",");
				apiParams.add(new APIParam(BusInstantConst.REGISTRATION_NUMBER, 20));
			}
			else if(urlParam.equals(BusInstantConst.ESTIMATED_TIME.toLowerCase())){
				url.append(BusInstantConst.ESTIMATED_TIME + ",");
				apiParams.add(new APIParam(BusInstantConst.ESTIMATED_TIME, 21));
			}
			else if(urlParam.equals(BusInstantConst.EXPIRE_TIME.toLowerCase())){
				url.append(BusInstantConst.EXPIRE_TIME + ",");
				apiParams.add(new APIParam(BusInstantConst.EXPIRE_TIME, 22));
			}
		}
		try {
			List<BusPrediction> result = new ArrayList<BusPrediction>();
			String responseArr[] = loadStrings(url.toString());
			Long timeStamp = 0L;
			for(String response : responseArr){
				System.out.println(response);
				response = response.replace("[","").replace("]","").replace("\"", "");
				String[] recordArray = response.split(",");
				if(timeStamp == null){
					timeStamp = Long.valueOf(recordArray[2]);
				}
				else{
					Collections.sort((List<APIParam>)apiParams);
					result.add(new BusPrediction(stopId, (ArrayList<APIParam>)apiParams, recordArray, timeStamp));
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public BusPrediction[] getBusPrevisionArray(Long stopId, String... params){
		try{
			List<BusPrediction> returnList = getBusPrevisionList(stopId, params); 
			if(returnList != null && returnList.size() > 0){
				BusPrediction[] retArr = new BusPrediction[returnList.size()];
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