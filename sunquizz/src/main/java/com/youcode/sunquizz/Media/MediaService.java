package com.youcode.sunquizz.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {
    MediaRepository mediaRepository;
    @Autowired
    public MediaService(MediaRepository mediaRepository)
    {
        this.mediaRepository = mediaRepository;
    }
    public Media getMedia(Integer id)
    {
        Optional<Media> media = mediaRepository.findById(id);
        if (media.isPresent()) {
            return media.get();
        }
        return null;
    }
    public List<Media> getMedias()
    {
        return mediaRepository.findAll();
    }
    public List<Media> getMediaByType(MediaType type)
    {
        return mediaRepository.findAllByType(type);
    }
    public Media createMedia(Media media)
    {
        return mediaRepository.save(media);
    }
    public Media updateMedia(Media media,Integer id)
    {
        Optional<Media> existMedia = mediaRepository.findById(id);
        if(existMedia.isPresent()) {
            media.setId(existMedia.get().getId());
            return mediaRepository.save(media);
        }
        return null;
    }
    public Integer deleteMedia(Integer id)
    {
        Optional<Media> media = mediaRepository.findById(id);
        if(media.isPresent()) {
            mediaRepository.delete(media.get());
            return 1;
        }else return 0;
    }
}
