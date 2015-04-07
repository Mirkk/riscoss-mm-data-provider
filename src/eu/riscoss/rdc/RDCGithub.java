package eu.riscoss.rdc;

import java.util.Collection;
import java.util.Map;

import eu.riscoss.rdc.model.RiskData;

public class RDCGithub implements RDC {

	@Override
	public String getName() {
		return "Github";
	}

	@Override
	public Collection<RDCParameter> getParameterList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParameter(String parName, String parValue) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, RiskData> getIndicators(String componentName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
