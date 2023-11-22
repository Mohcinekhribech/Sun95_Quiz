package com.youcode.sunquizz.Media;

import com.youcode.sunquizz.Media.DTOs.MediaReqDTO;
import com.youcode.sunquizz.Media.DTOs.MediaRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MediaService implements MediaServiceInterface{
    MediaRepository mediaRepository;
    ModelMapper modelMapper;
    @Autowired
    public MediaService(MediaRepository mediaRepository)
    {
        this.mediaRepository = mediaRepository;
    }
    public MediaRespDTO getMedia(Integer id)
    {
        Optional<Media> media = mediaRepository.findById(id);
        return modelMapper.map(media.orElse(null),MediaRespDTO.class);
    }
    public List<MediaRespDTO> getMedias()
    {
        return mediaRepository.findAll()
                .stream()
                .map(media -> modelMapper.map(media,MediaRespDTO.class))
                .collect(Collectors.toList());
    }
    public List<MediaRespDTO> getMediaByType(MediaType type)
    {
        return mediaRepository.findAllByType(type)
                .stream()
                .map(media -> modelMapper.map(media,MediaRespDTO.class))
                .collect(Collectors.toList());
    }
    public MediaRespDTO createMedia(MediaReqDTO media)
    {
        return modelMapper.map(
                mediaRepository
                .save(modelMapper.map(media,Media.class)),
                MediaRespDTO.class
        );
    }
    public MediaRespDTO updateMedia(MediaReqDTO media,Integer id)
    {
        Optional<Media> existMedia = mediaRepository.findById(id);
        if(existMedia.isPresent()) {
            media.setId(existMedia.get().getId());
            return modelMapper.map(
                    mediaRepository
                            .save(modelMapper.map(media,Media.class)),
                    MediaRespDTO.class
            );
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
