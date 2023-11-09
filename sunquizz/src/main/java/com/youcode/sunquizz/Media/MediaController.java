package com.youcode.sunquizz.Media;

import com.youcode.sunquizz.Media.Media;
import com.youcode.sunquizz.Media.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("media")
public class MediaController {
    @Autowired
    MediaService mediaService;
    @PostMapping
    public Media createMedia(@RequestBody Media media)
    {
        return mediaService.createMedia(media);
    }
    @PutMapping("/{id}")
    public Media updateMedia(@PathVariable Integer id, @RequestBody Media media)
    {
        return mediaService.updateMedia(media,id);
    }
    @GetMapping
    public List<Media> getMedias(@RequestBody Media media)
    {
        return mediaService.getMedias();
    }
    @GetMapping("/type/{mediaType}")
    public List<Media> getMediasByType(@PathVariable MediaType mediaType)
    {
        return mediaService.getMediaByType(mediaType);
    }
    @GetMapping("/{id}")
    public Media getMedia(@PathVariable Integer id)
    {
        return mediaService.getMedia(id);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteMedia(@PathVariable Integer id)
    {
        return mediaService.deleteMedia(id);
    }
}
