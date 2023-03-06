package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.dto.CommentaryDTO;
import co.simplon.hippopocrate.model.Commentary;

/**
* @author Caroline
* Interface that contains the methods use for the commentary'
*
*/
public interface CommentaryService {
	void saveCommentary(CommentaryDTO commentary);

	List<Commentary> fetchCommentaryList();

	// update operation
	Commentary updateCommentary(Commentary commentary, int id);

	// delete operation
	void deleteCommentaryById(int id);

}