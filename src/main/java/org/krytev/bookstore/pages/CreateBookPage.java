package org.krytev.bookstore.pages;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileBuffer;
import com.vaadin.flow.component.upload.receivers.FileData;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.GenreEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.krytev.bookstore.services.BookService;
import org.krytev.bookstore.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Route("createBook")
@RolesAllowed("ROLE_ADMIN")
public class CreateBookPage extends VerticalLayout {

    private final BookService bookService;
    private final GenreService genreService;
    private TextField title = new TextField();
    private TextField author = new TextField();
    private IntegerField year = new IntegerField();
    private BigDecimalField price = new BigDecimalField();
    ComboBox<GenreEntity> genreComboBox = new ComboBox<>("Genre");
    private Button create = new Button();
    FileBuffer fileBuffer = new FileBuffer();
    Upload singleFileUpload = new Upload(fileBuffer);

    @Autowired
    public CreateBookPage(BookService bookService, GenreService genreService) {

        singleFileUpload.setAcceptedFileTypes("src/main/resources/static/images", ".png");
        singleFileUpload.addSucceededListener(event -> {
            FileData savedFileData = fileBuffer.getFileData();
        });
        this.bookService = bookService;
        this.genreService = genreService;
        genreComboBox.setItems(genreService.findAll());
        genreComboBox.setItemLabelGenerator(GenreEntity::getName);
        title.setLabel("title");
        author.setLabel("author");
        year.setLabel("year");
        price.setLabel("price");
        create.setText("create");
        add(title, author, year, price, genreComboBox, singleFileUpload, create);
        create.addClickListener(event -> {
            BookEntity book = new BookEntity();
            book.setTitle(title.getValue());
            book.setAuthor(author.getValue());
            book.setPrice(price.getValue().doubleValue());
            book.setYear(year.getValue());
            book.setGenre(genreComboBox.getValue());
            FileData savedFileData = fileBuffer.getFileData();
            UUID uuid = UUID.randomUUID();
            book.setImage(uuid.toString());
            bookService.save(book);
            try {
                Files.move(Paths.get(savedFileData.getFile().getAbsoluteFile().toString()),
                        Paths.get("src/main/resources/static/images" + "/" + uuid.toString() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            UI.getCurrent().navigate("/index");
        });
    }
}
