package testpackage;

import jtfl4processing.core.JTFLBusAPI;
import jtfl4processing.core.impl.bus.instant.BusInstantAPI;
import jtfl4processing.core.impl.bus.model.BusStopPrediction;

public class TestingClass {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		

		JTFLBusAPI api = new BusInstantAPI();
		
		BusStopPrediction[] pr = api.getBusPrevisionArray(18215L);
		for(BusStopPrediction precord : pr)
			System.out.println(precord.getEstimatedTime());
		
		pr = api.getBusPrevisionArray(18215L,"StopPointIndicator","StopCode2","DestinationText");
		for(BusStopPrediction precord : pr)
			System.out.println(precord.toJson());
	}

}
