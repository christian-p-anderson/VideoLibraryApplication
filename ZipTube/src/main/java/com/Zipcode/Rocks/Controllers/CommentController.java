package com.Zipcode.Rocks.Controllers;

import com.Zipcode.Rocks.Models.Comment;
import com.Zipcode.Rocks.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost"})
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("comment/addcomment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.addComment(comment), HttpStatus.CREATED);}

    @DeleteMapping("deletecomment/{commentID}")
    public void deleteCommentById(@PathVariable Long commentID){ commentService.deleteComment(commentID);}

    @GetMapping("comments/allcomments")
    public ResponseEntity<List<Comment>> getAllComments(){
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
    }

    @GetMapping("commentsbyvideo/{videoID}")
    public ResponseEntity<List<Comment>> getCommentsByVideoID(@PathVariable Long videoID){return new ResponseEntity<>(commentService.getCommentsByVideo(videoID), HttpStatus.OK);}

    @PutMapping("comment/{commentId}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable Long commentId) {
        return new ResponseEntity<>(commentService.putEditComment(commentId, comment.getComment()), HttpStatus.OK);
    }
}
