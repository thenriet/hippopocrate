package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.model.Commentary;

public interface CommentaryService {
	Commentary saveCommentary (Commentary commentary);
	
	List<Commentary> fetchCommentaryList();
	  
    // update operation
  Commentary updateCommentary(Commentary commentary, int id);
  
    // delete operation
    void deleteCommentaryById(int id);

}