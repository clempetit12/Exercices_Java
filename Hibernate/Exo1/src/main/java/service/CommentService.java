package service;

import dao.CommentDao;
import entity.Comment;

public class CommentService {



    private CommentDao commentDao;

    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public boolean createComment(Comment comment) {
        return commentDao.create(comment);
    }

    public Comment getCommentById(Long id) {
        return commentDao.getById(id);
    }


}
