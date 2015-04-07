package eu.riscoss.rdc;

import java.util.Collection;
import java.util.Map;
import eu.riscoss.rdc.model.RiskData;

public interface RDC {
	
	public String getName();
	
	public Collection<RDCParameter> getParameterList();
	
	public void setParameter( String parName, String parValue ) throws Exception;
	
	public Map<String,RiskData> getIndicators( String componentName );
	
}
