package com.youcode.sunquizz.domains.Media;

import com.youcode.sunquizz.domains.Media.DTOs.MediaReqDTO;
import com.youcode.sunquizz.domains.Media.DTOs.MediaRespDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("media")
public class MediaController {
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
    public ResponseEntity<MediaRespDTO> updateMedia(@PathVariable Integer id,@Valid @RequestBody MediaReqDTO media)
    {
        MediaRespDTO media1 = mediaService.updateMedia(media,id);
        if(media1 != null)
        {
            return ResponseEntity.ok().body(media1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<Page<MediaRespDTO>> getMedias(Pageable pageable)
    {
        return ResponseEntity.ok().body(mediaService.getMedias(pageable));
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
