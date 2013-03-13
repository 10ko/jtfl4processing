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
* JTFLBusAPI is the interface for the Bus APIs.
* It is implemented by BusInstantAPI and BusStreamAPI.
* 
*/

package jtfl4processing.core;
import java.util.List;
import jtfl4processing.core.impl.bus.model.BusStopPrediction;

/**
 * The main interface for the bus stop APIs.
 * @author tenko
 *
 * @see jtfl4processing.core.impl.bus.instant.BusStopInstantAPI
 * @see jtfl4processing.core.impl.bus.stream.BusStopStreamAPI
 */
public interface JTFLBusAPI {
	/** 
	 * Returns a List of BusStopPrediction containing all the predictions for the bus stop specified by the parameter <b>stopId</b>
	 * The default map of value returned will contain only StopPointName,LineName and EstimatedTime
	 * 
	 * @param stopId The id of the bus stop to lookup.
	 * @return List<BusStopPrediction> The default BusStopPrediction map of attribute will contain only StopPointName,
	 * LineName and EstimatedTime
	 * @throws Exception
	 */
	public List<BusStopPrediction> getBusStopPredictionList(String stopId);
	
	/** 
	 * Returns a List of BusStopPrediction containing all the predictions for the bus stop specified by the parameter <b>stopId</b>
	 * The value map for each prediction will contain the attribute specified by <b>params</b>
	 * @param stopId The id of the bus stop to lookup.
	 * @param params The parameters we want to retrieve. Possible values are: ResponseType,StopPointName,
	 * StopID,StopCode1,StopCode2,StopPointType,Towards,Bearing,StopPointIndicator,StopPointState,Latitude,
	 * Longitude,VisitNumber,LineID,LineName,DirectionID,DestinationText,DestinationName,VehicleID,TripID,
	 * RegistrationNumber,EstimatedTime,ExpireTime
	 * @return List<BusStopPrediction> a list containing all the prediction for the stopId bus stop.
	 */
	public List<BusStopPrediction> getBusStopPredictionList(String stopId, String... params);
	
	/**
	 * Returns an array of BusStopPrediction containing all the predictions for the bus stop specified by the parameter <b>stopId</b>
	 * The default map of value returned will contain only StopPointName,LineName and EstimatedTime
	 * @param stopId The id of the bus stop to lookup.
	 * @return BusStopPrediction[] an array containing all the prediction for the stopId bus stop.
	 * @throws Exception
	 */
	public BusStopPrediction[] getBusStopPredictionArray(String stopId);
	
	/**
	 * Returns an array of BusStopPrediction containing all the predictions for the bus stop specified by the parameter <b>stopId</b>
	 * The value map for each prediction will contain the attribute specified by <b>params</b>
	 * @param stopId The id of the bus stop to lookup.
	 * @param params The parameters we want to retrieve. Possible values are: ResponseType,StopPointName,
	 * StopID,StopCode1,StopCode2,StopPointType,Towards,Bearing,StopPointIndicator,StopPointState,Latitude,
	 * Longitude,VisitNumber,LineID,LineName,DirectionID,DestinationText,DestinationName,VehicleID,TripID,
	 * RegistrationNumber,EstimatedTime,ExpireTime
	 * @return BusStopPrediction[] an array containing all the prediction for the stopId bus stop.
	 */
	public BusStopPrediction[] getBusStopPredictionArray(String stopId, String... params);
}
