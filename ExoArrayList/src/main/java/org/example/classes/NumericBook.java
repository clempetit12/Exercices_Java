package org.example.classes;

import org.example.Format;

public class NumericBook extends Book{

    protected Format format;
    protected int sizeBook;

    public NumericBook(String title, String author, Format format, int sizeBook) {
        super(title, author);
        this.format = format;
        this.sizeBook = sizeBook;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public int getSizeBook() {
        return sizeBook;
    }

    public void setSizeBook(int sizeBook) {
        this.sizeBook = sizeBook;
    }

    @Override
    public String toString() {
        return "Titre du livre = " + super.getTitle() +"\n" + "Auteur du livre = " + super.getAuthor();
    }
}
