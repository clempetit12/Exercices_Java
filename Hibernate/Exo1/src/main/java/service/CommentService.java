package service;

import dao.CommentDao;
import dao.ImageDao;
import entity.Comments;
import entity.Image;
import entity.Product;

public class CommentService {



    private CommentDao commentDao;

    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public boolean createComment(Comments comment) {
        return commentDao.create(comment);
    }

    public Comments getCommentById(Long id) {
        return commentDao.getById(id);
    }


}
