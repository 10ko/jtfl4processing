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
* BusStreamAPI is the main parser for the Bus Stream APIs.
* Its methods return a set of Prediction that will contain the predictions for a certain bus stop.
* 
*/

package jtfl4processing.core.impl.bus.instant;

import java.util.List;

import jtfl4processing.core.JTFLBusAPI;
import jtfl4processing.core.impl.bus.model.BusPrediction;


// TODO: Not implemented yet. You need permission from TFL to use those APIs.
public class BusStreamAPI implements JTFLBusAPI {

	/* (non-Javadoc)
	 * @see jtfl4processing.core.JTFLBusAPI#getBusPrevisionList(java.lang.Long)
	 */
	@Override
	public List<BusPrediction> getBusPrevisionList(Long stopId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see jtfl4processing.core.JTFLBusAPI#getBusPrevisionList(java.lang.Long, java.lang.String[])
	 */
	@Override
	public List<BusPrediction> getBusPrevisionList(Long stopId,
			String... params) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see jtfl4processing.core.JTFLBusAPI#getBusPrevisionArray(java.lang.Long)
	 */
	@Override
	public BusPrediction[] getBusPrevisionArray(Long stopId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see jtfl4processing.core.JTFLBusAPI#getBusPrevisionArray(java.lang.Long, java.lang.String[])
	 */
	@Override
	public BusPrediction[] getBusPrevisionArray(Long stopId, String... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
