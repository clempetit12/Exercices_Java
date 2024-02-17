package org.example.tp_blog.service;

import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostInterface<Post> {

    private final Map<UUID, Post> posts;

    public PostServiceImpl(){
        posts = new HashMap<>();
        Post post1 = Post.builder()
                .id(UUID.randomUUID())
                .title("Les meilleurs endroits à visiter en Europe")
                .description("Découvrez les destinations les plus magnifiques en Europe.")
                .commentList(commentsPost1())
                .content("L'Europe regorge de destinations touristiques incroyables, allant des villes historiques aux paysages naturels époustouflants. De la majesté de Paris à la beauté naturelle de la côte amalfitaine en passant par les magnifiques fjords de Norvège, il y en a pour tous les goûts.")
                .build();

        Post post2 = Post.builder()
                .id(UUID.randomUUID())
                .title("Les bienfaits d'une alimentation équilibrée")
                .description("Apprenez comment une alimentation saine peut améliorer votre santé.")
                .commentList(commentsPost2())
                .content("Une alimentation équilibrée riche en fruits, légumes, protéines maigres et grains entiers peut avoir un impact significatif sur votre santé. Elle peut vous aider à maintenir un poids santé, à réduire le risque de maladies cardiovasculaires et à améliorer votre énergie et votre humeur.")
                .build();



        Post post3 = Post.builder()
                .id(UUID.randomUUID())
                .title("Conseils pour un sommeil de qualité")
                .description("Dormez mieux avec ces astuces simples.")
                .commentList(commentsPost3())
                .content("Un bon sommeil est essentiel pour une bonne santé et un bien-être général. Pour améliorer la qualité de votre sommeil, essayez de créer une routine de sommeil régulière, de limiter la caféine et les écrans avant le coucher, et de créer un environnement propice au sommeil dans votre chambre.")
                .build();
        posts.put(post1.getId(),post1);
        posts.put(post2.getId(),post2);
        posts.put(post3.getId(),post3);
    }
    private static List<Comment> commentsPost1() {
        List<Comment> comments = new ArrayList<>();

        Comment comment1 = Comment.builder()
                .id(UUID.randomUUID())
                .lastName("Dupont")
                .email("dupont@example.com")
                .content("Super article, merci pour les recommandations !")
                .build();

        Comment comment2 = Comment.builder()
                .id(UUID.randomUUID())
                .lastName("Martin")
                .email("martin@example.com")
                .content("J'aimerais visiter ces endroits un jour.")
                .build();

        comments.add(comment1);
        comments.add(comment2);

        return comments;
    }

    private static List<Comment> commentsPost2() {
        List<Comment> comments = new ArrayList<>();

        Comment comment1 = Comment.builder()
                .id(UUID.randomUUID())
                .lastName("Garcia")
                .email("garcia@example.com")
                .content("L'alimentation équilibrée a vraiment changé ma vie.")
                .build();

        Comment comment2 = Comment.builder()
                .id(UUID.randomUUID())
                .lastName("Lefebvre")
                .email("lefebvre@example.com")
                .content("C'est un sujet très important, merci pour cet article.")
                .build();

        comments.add(comment1);
        comments.add(comment2);

        return comments;
    }

    private static List<Comment> commentsPost3() {
        List<Comment> comments = new ArrayList<>();

        Comment comment1 = Comment.builder()
                .id(UUID.randomUUID())
                .lastName("Chang")
                .email("chang@example.com")
                .content("Je vais essayer ces conseils dès ce soir.")
                .build();

        Comment comment2 = Comment.builder()
                .id(UUID.randomUUID())
                .lastName("Rossi")
                .email("rossi@example.com")
                .content("Merci pour les astuces, j'ai vraiment besoin de mieux dormir.")
                .build();

        comments.add(comment1);
        comments.add(comment2);

        return comments;
    }


    @Override
    public List<Post> getAll() {
        return posts.values().stream().toList();
    }

    @Override
    public Post getById(UUID id) {
        return posts.values().stream().filter(post -> post.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public boolean add(Post element) {
        element.setId(UUID.randomUUID());
        posts.put(element.getId(),element);
        return true ;
    }

    @Override
    public boolean deletePost(UUID id) {
        Post post = getById(id);
        posts.remove(id,post);
        return true;
    }

    @Override
    public Post update(UUID id, Post element) {
        Post postExist = getById(id);
        if (postExist != null) {
            postExist.setTitle(element.getTitle());
            postExist.setDescription(element.getDescription());

        }

        return postExist;
    }

    public boolean addCommentToPost(Post post, Comment comment) {
        List<Comment> comments = post.getCommentList();
        comments.add(comment);
        return true;
    }
}
