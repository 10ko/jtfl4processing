import jtfl4processing.core.*;
import jtfl4processing.core.impl.bus.model.*;
import jtfl4processing.core.impl.bus.instant.*;



void setup() {
  
  // Initialize APIs.
  JTFLBusAPI api = new BusStopInstantAPI();
  // Get array of prediction for the bus stop "BP3504" (Trafalgar Square / Charing Cross Stn)
  BusStopPrediction[] pr = api.getBusStopPredictionArray("BP3504","StopPointName","EstimatedTime","LineID","DestinationName");
  
  System.out.println("This is a prediction for the \""+pr[0].getStopPointName()+"\" bus stop:");
  for(BusStopPrediction precord : pr){
    System.out.print("*"+precord.getLineId()+" to \""+precord.getDestinationName());
    System.out.println("\" will arrive at : "+precord.getEstimatedTimeDate());
  } 
}

void draw() {
 
}