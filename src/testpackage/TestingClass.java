package testpackage;

import java.util.Date;

import jtfl4processing.core.JTFLBusAPI;
import jtfl4processing.core.impl.bus.instant.BusStopInstantAPI;
import jtfl4processing.core.impl.bus.model.BusStopPrediction;

public class TestingClass {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		

		JTFLBusAPI api = new BusStopInstantAPI();
		BusStopPrediction[] pr = api.getBusPrevisionArray("BP3504");
		for(BusStopPrediction precord : pr)
			System.out.println(precord.getEstimatedTime());
		
		pr = api.getBusPrevisionArray("18215","StopPointIndicator","StopCode2","DestinationText");
		for(BusStopPrediction precord : pr)
			System.out.println(precord.toJson());

	}
	
}
