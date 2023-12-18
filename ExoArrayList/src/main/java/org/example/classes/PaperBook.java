package org.example.classes;

public class PaperBook extends Book {

    protected int numberOfPages;

    protected String edition;

    public PaperBook(String title, String author, int numberOfPages, String edition) {
        super(title, author);
        this.numberOfPages = numberOfPages;
        this.edition = edition;
    }


    @Override
    public String toString() {
        return "Titre du livre = " + super.getTitle() +"\n" + "Auteur du livre = " + super.getAuthor();
    }
}
