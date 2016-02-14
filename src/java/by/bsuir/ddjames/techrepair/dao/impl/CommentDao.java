package by.bsuir.ddjames.techrepair.dao.impl;

import by.bsuir.ddjames.techrepair.dao.entity.Comment;

public class CommentDao extends EntityDao<Comment>{

    public CommentDao() {
        super(new Comment());
    }
}
