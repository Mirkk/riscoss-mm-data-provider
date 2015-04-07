package eu.riscoss.rdc;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GitHubTest {
	
	static String test_url = "https://s3.amazonaws.com/archive.travis-ci.org/jobs/53921972/log.txt";
	static Set<String> names = new HashSet<>();
	
	static {
		names.add( "forks" );
		names.add( "open_issues_count" );
//		names.add( "watchers" );
		names.add( "stargazers_count" );
		names.add( "created_at" );
		names.add( "subscribers_count" );
		names.add( "open_issues" );
		names.add( "watchers_count" );
		names.add( "forks_count" );
		names.add( "size" );
		names.add( "has_wiki" );
		names.add( "updated_at" );
//		names.add( "" );
//		names.add( "" );
//		names.add( "" );
	}
	
	public static void main( String[] args ) {
		
		
		try {
			String json = new TextFile( new File( GitHubTest.class.getResource( "github-json.txt" ).toURI() ) ).asString();
			try {
				JSONAware jv = (JSONAware) new JSONParser().parse( json );
				Map<String,String> values = new HashMap<>();
			if( jv instanceof JSONObject ) {
				JSONObject jo = (JSONObject)jv;
				for( Object key : jo.keySet() ) {
					if( names.contains( key.toString() ) ) {
//						System.out.println( key.toString() + " => " + jo.get( key ) );
						values.put( key.toString(), jo.get( key ).toString() );
					}
				}
				for( String key : values.keySet() ) {
					System.out.println( key + " => " + values.get( key ) );
				}
			}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		
//		new GitHubTestWindow().run( args );
	}
		
	String getRepo() {
		return "https://github.com/RISCOSS/riscoss-analyser";
	}
	
	void runGitHubRDC( String repo ) {
		String cmdline = "curl -H \"Accept: application/vnd.github.drax-preview+json\" -i https://api.github.com/repos/" + getRepo();
		String json = new Executable( cmdline ).exec().getOutput();
		
		System.out.println( "============" );
		Map<String,String> values = parseJson( json );
		System.out.println( json );
		for( String key : values.keySet() ) {
			System.out.println( key + " => " + values.get( key ) );
			}
	}
	
	Map<String,String> parseJson( String json ) {
		Map<String,String> values = new HashMap<>();
		try {
//			String json = new TextFile( new File( GitHubTestWindow.class.getResource( "github-json.txt" ).toURI() ) ).asString();
			try {
				JSONAware jv = (JSONAware) new JSONParser().parse( json );
			if( jv instanceof JSONObject ) {
				JSONObject jo = (JSONObject)jv;
				for( Object key : jo.keySet() ) {
					if( names.contains( key.toString() ) ) {
						values.put( key.toString(), jo.get( key ).toString() );
					}
				}
//				for( String key : values.keySet() ) {
//					System.out.println( key + " => " + values.get( key ) );
//				}
			}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return values;
	}
}
