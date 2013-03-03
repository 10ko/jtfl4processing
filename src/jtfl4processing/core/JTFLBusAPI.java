package jtfl4processing.core;

import java.util.List;

import jtfl4processing.core.impl.bus.model.BusPrediction;

public interface JTFLBusAPI {
	public List<BusPrediction> getBusPrevisionList(Long stopId) throws Exception;
	public List<BusPrediction> getBusPrevisionList(Long stopId, String... params);
	public BusPrediction[] getBusPrevisionArray(Long stopId) throws Exception;
	public BusPrediction[] getBusPrevisionArray(Long stopId, String... params);
}
