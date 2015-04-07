package eu.riscoss.rdc;

public class RDCApp {
	public static void main( String[] args ) {
		new RDCApp().run( args );
	}

	public void run(String[] args) {
		RDCFactory.get().registerRDC( new RDCFossology( "Fossology" ) );
		RDCFactory.get().registerRDC( new RDCMaven( "Maven" ) );
		RDCFactory.get().registerRDC( new RDCMarkmail( "Markmail" ) );
		RDCFactory.get().registerRDC( new RDCJira( "Jira" ) );
		RDCFactory.get().registerRDC( new RDCSonar( "Sonar" ) );
	}
}
