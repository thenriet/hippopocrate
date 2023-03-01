package co.simplon.hippopocrate.service;

import java.util.List;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.repository.CommentaryRepository;


@Service
public class CommentaryServiceImpl implements CommentaryService {
	
	@Autowired
	private CommentaryRepository cr;

	@Override
	public Commentary saveCommentary(Commentary commentary) {
		return cr.save(commentary);
	}
	
	@Override
	public List<Commentary> fetchCommentaryList() {
		return cr.findAll();
	}
	
	@Override
	public Commentary updateCommentary(Commentary commentary, int id) {
		return null;
	}
	
	@Override
	public void deleteCommentaryById(int id) {
	}
	

}
