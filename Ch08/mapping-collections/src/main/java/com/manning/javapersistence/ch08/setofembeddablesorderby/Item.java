 
package com.manning.javapersistence.ch08.setofembeddablesorderby;

import com.manning.javapersistence.ch08.Constants;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @OrderBy("filename DESC, width DESC")
    private Set<Image> images = new LinkedHashSet<>();

    public Item(String name) {
        this.name = name;
    }

    public Item() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Image> getImages() {
        return Collections.unmodifiableSet(images);
    }

    public void addImage(Image image) {
        images.add(image);
    }
}
