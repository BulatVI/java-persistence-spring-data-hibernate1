 
package com.manning.javapersistence.ch08.bagofembeddables;

import com.manning.javapersistence.ch08.configuration.bagofembeddables.SpringDataConfiguration;
import com.manning.javapersistence.ch08.repositories.bagofembeddables.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class MappingCollectionsSpringDataJPATest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void storeLoadEntities() {

        Item item = new Item("Foo");

        item.addImage(new Image("Background", "background.jpg", 640, 480));
        item.addImage(new Image("Foreground", "foreground.jpg", 640, 480));
        item.addImage(new Image("Landscape", "landscape.jpg", 640, 480));
        item.addImage(new Image("Portrait", "portrait.jpg", 480, 640));

        itemRepository.save(item);

        Item item2 = itemRepository.findItemWithImages(item.getId());

        List<Item> items2 = itemRepository.findAll();
        Set<String> images = itemRepository.findImagesNative(item.getId());

        assertAll(
                () -> assertEquals(4, item2.getImages().size()),
                () -> assertEquals(1, items2.size()),
                () -> assertEquals(4, images.size())
        );


    }
}
