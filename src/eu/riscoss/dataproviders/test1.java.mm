package eu.riscoss.dataproviders;

import com.atlassian.stash.commit.CommitService;


public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//https://api.github.com/repos/xwiki/xwiki-platform/commits
			 
		    CommitService commitService = new CommitService();
		 
		    RepositoryCommit commit = commitService.getCommit(repository, sha);
		 
		    System.out.println("Total lines impacted: " + commit.getTotal());
		 
		    System.out.println("Total files impacted: " + commit.getFiles().size());
		}

	}

}
