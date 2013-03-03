package jtfl4processing.core.bus.instant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jtfl4processing.core.JTFLBasicAPI;
import jtfl4processing.core.model.APIParam;
import jtfl4processing.core.model.Prediction;

public class BusInstantAPI extends JTFLBasicAPI{
	
	public static void main(String[] meh) throws Exception{
		Prediction[] pr = getBusPrevisionArray(18215L,"stopId","stopPointNamE","DESTInationName","EstimatedTime","bearing","towards");
		for(Prediction precord : pr)
			System.out.println(precord.toJson());
	}
	
	public static List<Prediction> getBusPrevisionList(Long stopId) throws Exception{
		if(stopId != null && stopId > 0)
			return getBusPrevisionList(stopId, null);
		else
			throw new Exception("Error, cant't process the request without specifing a stopId!");
		
	}
	
	public static Prediction[] getBusPrevisionArray(Long stopId) throws Exception{
		if(stopId != null && stopId > 0)
			return getBusPrevisionArray(stopId, null);
		else
			throw new Exception("Error, cant't process the request without specifing a stopId!");
	}
	
	public static List<Prediction> getBusPrevisionList(Long stopId, String... params){
		if(params == null);
		StringBuilder url = new StringBuilder(JTFLBusInstantConst.BUS_INSTANT_BASE_URL + "StopId=" + stopId + "&ReturnList=");
		Collection<APIParam> apiParams = new ArrayList<APIParam>();
		
		//url.append(JTFLBusInstantConst.RESPONSE_TYPE + ",");
		apiParams.add(new APIParam(JTFLBusInstantConst.RESPONSE_TYPE, 0));
		
		for(String urlParam : params){
			urlParam=urlParam.toLowerCase();
			if(urlParam.equals(JTFLBusInstantConst.STOP_POINT_NAME.toLowerCase())){
				url.append(JTFLBusInstantConst.STOP_POINT_NAME + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.STOP_POINT_NAME, 1));
			}
			else if(urlParam.equals(JTFLBusInstantConst.STOP_ID.toLowerCase())){
				url.append(JTFLBusInstantConst.STOP_ID + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.STOP_ID, 2));
			}
			else if(urlParam.equals(JTFLBusInstantConst.STOP_CODE_1.toLowerCase())){
				url.append(JTFLBusInstantConst.STOP_CODE_1 + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.STOP_CODE_1, 3));
			}
			else if(urlParam.equals(JTFLBusInstantConst.STOP_CODE_2.toLowerCase())){
				url.append(JTFLBusInstantConst.STOP_CODE_2 + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.STOP_CODE_2, 4));
			}
			else if(urlParam.equals(JTFLBusInstantConst.STOP_POINT_TYPE.toLowerCase())){
				url.append(JTFLBusInstantConst.STOP_POINT_TYPE + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.STOP_POINT_TYPE, 5));
			}
			else if(urlParam.equals(JTFLBusInstantConst.TOWARDS.toLowerCase())){
				url.append(JTFLBusInstantConst.TOWARDS + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.TOWARDS, 6));
			}
			else if(urlParam.equals(JTFLBusInstantConst.BEARING.toLowerCase())){
				url.append(JTFLBusInstantConst.BEARING + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.BEARING, 7));
			}
			else if(urlParam.equals(JTFLBusInstantConst.STOP_POINT_INDICATOR.toLowerCase())){
				url.append(JTFLBusInstantConst.STOP_POINT_INDICATOR + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.STOP_POINT_INDICATOR, 8));
			}
			else if(urlParam.equals(JTFLBusInstantConst.STOP_POINT_STATE.toLowerCase())){
				url.append(JTFLBusInstantConst.STOP_POINT_STATE + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.STOP_POINT_STATE, 9));
			}
			else if(urlParam.equals(JTFLBusInstantConst.LATITUDE.toLowerCase())){
				url.append(JTFLBusInstantConst.LATITUDE + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.LATITUDE, 10));
			}
			else if(urlParam.equals(JTFLBusInstantConst.LONGITUDE.toLowerCase())){
				url.append(JTFLBusInstantConst.LONGITUDE + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.LONGITUDE, 11));
			}
			else if(urlParam.equals(JTFLBusInstantConst.VISIT_NUMBER.toLowerCase())){
				url.append(JTFLBusInstantConst.VISIT_NUMBER + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.VISIT_NUMBER, 12));
			}
			else if(urlParam.equals(JTFLBusInstantConst.LINE_ID.toLowerCase())){
				url.append(JTFLBusInstantConst.LINE_ID + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.LINE_ID, 13));
			}
			else if(urlParam.equals(JTFLBusInstantConst.LINE_NAME.toLowerCase())){
				url.append(JTFLBusInstantConst.LINE_NAME + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.LINE_NAME, 14));
			}
			else if(urlParam.equals(JTFLBusInstantConst.DIRECTION_ID.toLowerCase())){
				url.append(JTFLBusInstantConst.DIRECTION_ID + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.DIRECTION_ID, 15));
			}
			else if(urlParam.equals(JTFLBusInstantConst.DESTINATION_TEXT.toLowerCase())){
				url.append(JTFLBusInstantConst.DESTINATION_TEXT + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.DESTINATION_TEXT, 16));
			}
			else if(urlParam.equals(JTFLBusInstantConst.DESTINATION_NAME.toLowerCase())){
				url.append(JTFLBusInstantConst.DESTINATION_NAME + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.DESTINATION_NAME, 17));
			}
			else if(urlParam.equals(JTFLBusInstantConst.VEHICLE_ID.toLowerCase())){
				url.append(JTFLBusInstantConst.VEHICLE_ID + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.VEHICLE_ID, 18));
			}
			else if(urlParam.equals(JTFLBusInstantConst.TRIP_ID.toLowerCase())){
				url.append(JTFLBusInstantConst.TRIP_ID + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.TRIP_ID, 19));
			}
			else if(urlParam.equals(JTFLBusInstantConst.REGISTRATION_NUMBER.toLowerCase())){
				url.append(JTFLBusInstantConst.REGISTRATION_NUMBER + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.REGISTRATION_NUMBER, 20));
			}
			else if(urlParam.equals(JTFLBusInstantConst.ESTIMATED_TIME.toLowerCase())){
				url.append(JTFLBusInstantConst.ESTIMATED_TIME + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.ESTIMATED_TIME, 21));
			}
			else if(urlParam.equals(JTFLBusInstantConst.EXPIRE_TIME.toLowerCase())){
				url.append(JTFLBusInstantConst.EXPIRE_TIME + ",");
				apiParams.add(new APIParam(JTFLBusInstantConst.EXPIRE_TIME, 22));
			}
		}
		try {
			List<Prediction> result = new ArrayList<Prediction>();
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
					result.add(new Prediction(stopId, (ArrayList<APIParam>)apiParams, recordArray, timeStamp));
				}
					
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Prediction[] getBusPrevisionArray(Long stopId, String... params){
		try{
			List<Prediction> returnList = getBusPrevisionList(stopId, params); 
			if(returnList != null && returnList.size() > 0){
				Prediction[] retArr = new Prediction[returnList.size()];
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
