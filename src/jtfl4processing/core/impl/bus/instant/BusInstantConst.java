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
* BusInstantConst contains constants required by the JTFLBusAPI implementations.
* For more information please read the TFL specification at the following url:
* 
* http://www.tfl.gov.uk/assets/downloads/businessandpartners/tfl-live-bus-arrivals-api-documentation.pdf
* 
*/

package jtfl4processing.core.impl.bus.instant;

public class BusInstantConst {
	public static final String BUS_INSTANT_BASE_URL = "http://countdown.api.tfl.gov.uk/interfaces/ura/instant_V1?";
	
	public static final String RESPONSE_TYPE = "ResponseType";
	public static final String STOP_POINT_NAME = "StopPointName";
	public static final String STOP_ID = "StopID";
	public static final String STOP_CODE_1 = "StopCode1";
	public static final String STOP_CODE_2 = "StopCode2";
	public static final String STOP_POINT_TYPE = "StopPointType";
	public static final String TOWARDS = "Towards";
	public static final String BEARING = "Bearing";
	public static final String STOP_POINT_INDICATOR = "StopPointIndicator";
	public static final String STOP_POINT_STATE = "StopPointState";
	public static final String LATITUDE = "Latitude";
	public static final String LONGITUDE = "Longitude";
	public static final String VISIT_NUMBER = "VisitNumber";
	public static final String LINE_ID = "LineID";
	public static final String LINE_NAME = "LineName";
	public static final String DIRECTION_ID = "DirectionID";
	public static final String DESTINATION_TEXT = "DestinationText";
	public static final String DESTINATION_NAME = "DestinationName";
	public static final String VEHICLE_ID = "VehicleID";
	public static final String TRIP_ID = "TripID";
	public static final String REGISTRATION_NUMBER = "RegistrationNumber";
	public static final String ESTIMATED_TIME = "EstimatedTime";
	public static final String EXPIRE_TIME = "ExpireTime";
}
