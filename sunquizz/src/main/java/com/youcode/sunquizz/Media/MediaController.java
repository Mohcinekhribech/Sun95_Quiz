package com.youcode.sunquizz.Media;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Media.DTOs.MediaReqDTO;
import com.youcode.sunquizz.Media.DTOs.MediaRespDTO;
import com.youcode.sunquizz.Media.Media;
import com.youcode.sunquizz.Media.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("media")
public class MediaController {
    @Autowired
    MediaService mediaService;
    @PostMapping
    public ResponseEntity<MediaRespDTO> createMedia(@RequestBody MediaReqDTO media)
    {
        MediaRespDTO media1 = mediaService.createMedia(media);
        if(media1 != null)
        {
            return ResponseEntity.ok().body(media1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MediaRespDTO> updateMedia(@PathVariable Integer id, @RequestBody MediaReqDTO media)
    {
        MediaRespDTO media1 = mediaService.updateMedia(media,id);
        if(media1 != null)
        {
            return ResponseEntity.ok().body(media1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<MediaRespDTO>> getMedias()
    {
        return ResponseEntity.ok().body(mediaService.getMedias());
    }
    @GetMapping("/type/{mediaType}")
    public ResponseEntity<List<MediaRespDTO>> getMediasByType(@PathVariable MediaType mediaType)
    {
        return ResponseEntity.ok().body(mediaService.getMediaByType(mediaType));
    }
    @GetMapping("/{id}")
    public ResponseEntity<MediaRespDTO> getMedia(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(mediaService.getMedia(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteMedia(@PathVariable Integer id)
    {
        Integer deleted = mediaService.deleteMedia(id);
        if(deleted == 1)
        {
            return  ResponseEntity.ok().body("media deleted");
        }
        return ResponseEntity.badRequest().body("media not deleted");
    }
}
