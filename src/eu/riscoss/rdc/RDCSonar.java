package eu.riscoss.rdc;

import java.util.Collection;
import java.util.Map;

import eu.riscoss.rdc.model.RiskData;

public class RDCSonar implements RDC {

	private String name;

	public RDCSonar( String name ) {
		this.name = name;
	}

	@Override
	public Map<String, RiskData> getIndicators(String componentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Collection<RDCParameter> getParameterList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParameter( String parName, String parValue ) throws Exception {
//		defaultProperties.put( parName, parValue );
	}
	
}
