package co.simplon.hippopocrate.service;

import java.util.List;

import java.util.List;
import java.util.Objects;

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
		// TODO Auto-generated method stub
		return cr.findAll();
	}
	
	public Commentary findCommentaryById(long id) {
		return cr.findById(id).get();
	}
	
//	@Override
	//public void deleteCommentaryById(long id) {
		// TODO Auto-generated method stub

	//}
}
